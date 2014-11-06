package HxCKDMS.MoreWorldGen.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import HxCKDMS.MoreWorldGen.util.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemIngot extends Item {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemIngot(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
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
    public void registerIcons(IIconRegister iconRegister){
        icons = new IIcon[256];
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotCopper");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotTin");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotSilver");
        icons[3] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotLead");
        icons[4] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotNickel");
        icons[5] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotChromium");
        icons[6] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotAluminium");
        icons[7] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotTitanium");
        icons[8] = iconRegister.registerIcon(Reference.MOD_ID + ":ingotPlatinum");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        return icons[metadata];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 9; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
