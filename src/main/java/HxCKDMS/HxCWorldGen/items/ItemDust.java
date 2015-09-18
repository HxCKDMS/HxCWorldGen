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

    public ItemDust(CreativeTabs creativeTabs) {
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDurability(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        switch(itemStack.getCurrentDurability()) {
            case 0: return "CopperDust";
            case 1: return "TinDust";
            case 2: return "SilverDust";
            case 3: return "LeadDust";
            case 4: return "NickelDust";
            case 5: return "ChromiumDust";
            case 6: return "AluminiumDust";
            case 7: return "IlmeniteDust";
            case 8: return "PlatinumDust";
            case 9: return "AventurineDust";
            case 10: return "RubyDust";
            case 11: return "SapphireDust";
            case 12: return "RutileDust";
            case 13: return "ZirconiumDust";
            case 14: return "TitaniumDust";
            default: return "error";
        }
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(TextureHandler.getTexturePath("dust"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata) {
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < 15; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public int getIntFromColor(int Red, int Green, int Blue) {
        Red = (Red << 16) & 0x00FF0000;
        Green = (Green << 8) & 0x0000FF00;
        Blue = Blue & 0x000000FF;
        //0xFF000000 for 100% Alpha.
        return 0xFF000000 | Red | Green | Blue;
    }
}
