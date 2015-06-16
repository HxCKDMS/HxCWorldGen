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

public class ItemResourcePiece extends Item {
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
 12 = Zircon
 **/
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        int[] colors = Colours.resourceColour(stack.getItemDamageForDisplay());
        return getIntFromColor(colors[0], colors[1], colors[2]);
    }

    public ItemResourcePiece(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getItemDamage()){
            case 0: name = "CopperNugget"; break;
            case 1: name = "TinNugget"; break;
            case 2: name = "SilverNugget"; break;
            case 3: name = "LeadNugget"; break;
            case 4: name = "NickelNugget"; break;
            case 5: name = "ChromiumNugget"; break;
            case 6: name = "AluminiumNugget"; break;
            case 7: name = "TitaniumNugget"; break;
            case 8: name = "PlatinumNugget"; break;
            case 9: name = "AventurineFragment"; break;
            case 10: name = "RubyFragment"; break;
            case 11: name = "SapphireFragment"; break;
            case 12: name = "ZirconFragment"; break;
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
        icons = new IIcon[13];
        for (int i = 0; i < 9; i++) icons[i] = iconRegister.registerIcon(TextureHandler.getTexturePath("nugget"));
        for (int j = 9; j <= 12; j++) icons[j] = iconRegister.registerIcon(TextureHandler.getTexturePath("fragment"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        return icons[metadata];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 13; i++){
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
