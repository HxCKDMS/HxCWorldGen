package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.util.Reference;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

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

public class ItemGem extends Item {
    @SideOnly(Side.CLIENT)

    public ItemGem(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
        for(int i=9; i<NAMES.length; i++)
        {
            ModelBakery.addVariantName(this, Reference.MOD_ID + ":" + NAMES[i]);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){

        String name;

        switch(itemStack.getItemDamage()){
            case 9:
                name = "AventurineGem";
                break;
            case 10:
                name = "RubyGem";
                break;
            case 11:
                name = "SapphireGem";
                break;
            default:
                name = "error";
        }
        return name;
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 9; i < 12; i++){
            list.add(new ItemStack(item,1,i));
        }
    }
    public static final String[] NAMES = {"CopperIngot","TinIngot","SilverIngot","LeadIngot","NickelIngot","ChromiumIngot","AluminiumIngot","TitaniumIngot","PlatinumIngot","AventurineGem","RubyGem","SapphireGem"};

}
