package HxCKDMS.HxCWorldGen.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/*
0 = Copper
1 = Tin
2 = Silver
3 = Lead
4 = Nickel
5 = Chromium
6 = Aluminium
7 = Titanium
8 = Platinum
9 = Aventurine
10 = Ruby
11 = Sapphire
*/

public class ItemBlockStorage extends ItemBlock {
    public Block metaBlock;

    public ItemBlockStorage(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getItemDamage()){
            case 0:
                name = "CopperBlock";
                break;
            case 1:
                name = "TinBlock";
                break;
            case 2:
                name = "SilverBlock";
                break;
            case 3:
                name = "LeadBlock";
                break;
            case 4:
                name = "NickelBlock";
                break;
            case 5:
                name = "ChromiumBlock";
                break;
            case 6:
                name = "AluminiumBlock";
                break;
            case 7:
                name = "TitaniumBlock";
                break;
            case 8:
                name = "PlatinumBlock";
                break;
            case 9:
                name = "AventurineBlock";
                break;
            case 10:
                name = "RubyBlock";
                break;
            case 11:
                name = "SapphireBlock";
                break;
            case 12:
                name = "ZirconBlock";
                break;
            default:
                name = "error";
                break;
        }

        return name;
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    public IIcon getIconFromDamage(int metadata){
        return metaBlock.getIcon(2, metadata);
    }
}
