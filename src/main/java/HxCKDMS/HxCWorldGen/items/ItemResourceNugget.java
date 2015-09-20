package HxCKDMS.HxCWorldGen.items;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
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

public class ItemResourceNugget extends Item {
    public ItemResourceNugget(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDurability(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return Reference.RESOURCES[itemStack.getCurrentDurability()].replace("Gem", "Fragment").replace("Ingot", "Nugget");
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int meta) {
        return Colours.getColour(stack.getUnlocalizedName());
    }

    @SideOnly(Side.CLIENT)
    private HashMap<String, IIcon> icons = new HashMap<>();

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        icons.put("nugget", iconRegister.registerIcon(TextureHandler.getTexturePath("nugget")));
        icons.put("fragment", iconRegister.registerIcon(TextureHandler.getTexturePath("fragment")));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        ItemStack stack = new ItemStack(ModRegistry.itemFragment, 1, metadata);
        String type = (this.getUnlocalizedName(stack).contains("Nugget") ? "nugget" : "fragment");
        return icons.get(type);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for (int i = 0; i < Reference.RESOURCES.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
