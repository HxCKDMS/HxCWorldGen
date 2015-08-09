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

public class ItemOreChunk extends Item {
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
 12 = Rutile
 **/
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        int[] colors = Colours.oreColour(stack.getCurrentDurability());
        return getIntFromColor(colors[0], colors[1], colors[2]);
    }

    public ItemOreChunk(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDurability(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        String name;

        switch(itemStack.getCurrentDurability()){
            case 0: name = "CopperChunk"; break;
            case 1: name = "TinChunk"; break;
            case 2: name = "SilverChunk"; break;
            case 3: name = "LeadChunk"; break;
            case 4: name = "NickelChunk"; break;
            case 5: name = "ChromiumChunk"; break;
            case 6: name = "AluminiumChunk"; break;
            case 7: name = "TitaniumChunk"; break;
            case 8: name = "PlatinumChunk"; break;
            case 9: name = "AventurineChunk"; break;
            case 10: name = "RubyChunk"; break;
            case 11: name = "SapphireChunk"; break;
            case 12: name = "RutileChunk"; break;
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
        for (int i = 0; i < 13; i++) icons[i] = iconRegister.registerIcon(TextureHandler.getTexturePath("chunk"));
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
