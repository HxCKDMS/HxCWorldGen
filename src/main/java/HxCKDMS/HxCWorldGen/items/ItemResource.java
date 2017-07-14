package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.HashMap;
import java.util.List;

public class ItemResource extends Item {
    public ItemResource(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Configurations.RESOURCES[itemStack.getItemDamage()];
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        return Configurations.getColourINT(stack.getUnlocalizedName());
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    private HashMap<String, IIcon> icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        icons = new HashMap<>();
        icons.put("ingot", iconRegister.registerIcon(TextureHandler.getTexturePath("ingot")));
        icons.put("gem", iconRegister.registerIcon(TextureHandler.getTexturePath("gem")));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        ItemStack stack = new ItemStack(ModRegistry.itemResource, 1, metadata);
        String type = (this.getUnlocalizedName(stack).toLowerCase().contains("gem") ? "gem" : "ingot");
        return icons.get(type);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for (int i = 0; i < Configurations.RESOURCES.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
