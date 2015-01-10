package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.util.Reference;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemIngot extends Item {

    @SideOnly(Side.CLIENT)

    public ItemIngot(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
        for(int i=0; i<=8; i++)
        {
            ModelBakery.addVariantName(this, Reference.MOD_ID + ":" + NAMES[i]);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getItemDamage()){
            case 0:
                name = "CopperIngot";
                break;
            case 1:
                name = "TinIngot";
                break;
            case 2:
                name = "SilverIngot";
                break;
            case 3:
                name = "LeadIngot";
                break;
            case 4:
                name = "NickelIngot";
                break;
            case 5:
                name = "ChromiumIngot";
                break;
            case 6:
                name = "AluminiumIngot";
                break;
            case 7:
                name = "TitaniumIngot";
                break;
            case 8:
                name = "PlatinumIngot";
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
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 9; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
    public static final String[] NAMES = {"CopperIngot","TinIngot","SilverIngot","LeadIngot","NickelIngot","ChromiumIngot","AluminiumIngot","TitaniumIngot","PlatinumIngot","AventurineGem","RubyGem","SapphireGem"};

}
