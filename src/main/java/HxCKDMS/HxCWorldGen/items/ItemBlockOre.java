package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

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

public class ItemBlockOre extends ItemBlock {
    public Block metaBlock;

    public ItemBlockOre(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
        for(int i=0; i<NAMES.length; i++)
        {
            ModelBakery.addVariantName(this, Reference.MOD_ID + ":" + NAMES[i]);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getItemDamage()){
            case 0:
                name = "CopperOre";
                break;
            case 1:
                name = "TinOre";
                break;
            case 2:
                name = "SilverOre";
                break;
            case 3:
                name = "LeadOre";
                break;
            case 4:
                name = "NickelOre";
                break;
            case 5:
                name = "ChromiumOre";
                break;
            case 6:
                name = "AluminiumOre";
                break;
            case 7:
                name = "TitaniumOre";
                break;
            case 8:
                name = "PlatinumOre";
                break;
            case 9:
                name = "AventurineOre";
                break;
            case 10:
                name = "RubyOre";
                break;
            case 11:
                name = "SapphireOre";
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
    public static final String[] NAMES = {"CopperOre","TinOre","SilverOre","LeadOre","NickelOre","ChromiumOre","AluminiumOre","TitaniumOre","PlatinumOre","AventurineOre","RubyOre","SapphireOre"};
}
