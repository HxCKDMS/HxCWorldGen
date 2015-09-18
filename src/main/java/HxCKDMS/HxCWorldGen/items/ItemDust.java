package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemDust extends Item {
/**
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
 12 = Zircon
 **/
    @SideOnly(Side.CLIENT)
    private IIcon icon;

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        int[] colors = Colours.oreColour(stack.getCurrentDurability());
        return getIntFromColor(colors[0], colors[1], colors[2]);
    }

    public ItemDust(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDurability(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getCurrentDurability()){
            case 0: name = "CopperDust"; break;
            case 1: name = "TinDust"; break;
            case 2: name = "SilverDust"; break;
            case 3: name = "LeadDust"; break;
            case 4: name = "NickelDust"; break;
            case 5: name = "ChromiumDust"; break;
            case 6: name = "AluminiumDust"; break;
            case 7: name = "IlmeniteDust"; break;
            case 8: name = "PlatinumDust"; break;
            case 9: name = "AventurineDust"; break;
            case 10: name = "RubyDust"; break;
            case 11: name = "SapphireDust"; break;
            case 12: name = "RutileDust"; break;
            case 13: name = "ZirconiumDust"; break;
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
        icon = iconRegister.registerIcon(TextureHandler.getTexturePath("dust"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 14; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    public int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000;
        Green = (Green << 8) & 0x0000FF00;
        Blue = Blue & 0x000000FF;
        //0xFF000000 for 100% Alpha.
        return 0xFF000000 | Red | Green | Blue;
    }
}
