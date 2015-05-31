package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemResource extends Item {

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

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemResource(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getItemDamage()){
            case 0: name = "CopperIngot"; break;
            case 1: name = "TinIngot"; break;
            case 2: name = "SilverIngot"; break;
            case 3: name = "LeadIngot"; break;
            case 4: name = "NickelIngot"; break;
            case 5: name = "ChromiumIngot"; break;
            case 6: name = "AluminiumIngot"; break;
            case 7: name = "TitaniumIngot"; break;
            case 8: name = "PlatinumIngot"; break;
            case 9: name = "AventurineGem"; break;
            case 10: name = "RubyGem"; break;
            case 11: name = "SapphireGem"; break;
            case 12: name = "Zircon"; break;
            case 13: name = "Zirconia"; break;
            default: name = "error"; break;
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
        icons = new IIcon[14];
        for (int i = 0; i < 9; i++) icons[i] = iconRegister.registerIcon(TextureHandler.getTexturePath("ingot"));
        for (int j = 10; j < 12; j++) icons[j] = iconRegister.registerIcon(TextureHandler.getTexturePath("gem"));
        icons[13] = iconRegister.registerIcon(TextureHandler.getTexturePath("ingot"));
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
