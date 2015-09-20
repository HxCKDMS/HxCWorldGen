package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 0 = Copper
 1 = Tin
 2 = Silver
 3 = Lead
 4 = Nickel
 5 = Chromium
 6 = Aluminium
 7 = Titanium / Ilmenite
 8 = Platinum
 9 = Aventurine
 10 = Ruby
 11 = Sapphire
 12 = Rutile //blocks
 12 = Zircon //items
 13 = Zirconia //items
 **/

public class ItemBlockOre extends ItemBlock {
    public Block metaBlock;

    public ItemBlockOre(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Reference.ORES[itemStack.getCurrentDurability()];
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }
}
