package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
public class ItemBlockStorage extends ItemBlock {
    public Block metaBlock;

    public ItemBlockStorage(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Reference.RESOURCES[itemStack.getCurrentDurability()].replace("Ingot", "Block").replace("Gem", "Block");
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }
}
