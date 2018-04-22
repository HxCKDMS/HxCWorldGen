package HxCKDMS.HxCWorldGen.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileStorageBlock extends TileEntity {
    public String blockName = "";
    @Override
    public boolean canUpdate() {
        return false;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if (nbt.hasKey("BlockName", 8))
            this.blockName = nbt.getString("BlockName");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if (!blockName.isEmpty())
            nbt.setString("BlockName", this.blockName);
    }
}
