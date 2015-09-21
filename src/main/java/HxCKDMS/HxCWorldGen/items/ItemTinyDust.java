package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemTinyDust extends Item {
    public ItemTinyDust(CreativeTabs creativeTabs) {
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDurability(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Reference.DUSTS[itemStack.getCurrentDurability()].replace("Dust", "TinyDust");
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        return Colours.getColour(stack.getUnlocalizedName());
    }

    @SideOnly(Side.CLIENT)
    private IIcon icon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(TextureHandler.getTexturePath("tinyDust"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata) {
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < Reference.DUSTS.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
