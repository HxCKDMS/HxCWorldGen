package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.HashMap;
import java.util.List;

public class BlockStorage extends Block {
    public BlockStorage(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setStepSound(Block.soundTypeMetal);
        setCreativeTab(creativeTabs);
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        if (metadata >= 9 && metadata <= 11 || metadata == Configurations.RESOURCES.length-1) return icons.get("gemBlock");
        return icons.get("metalBlock");
    }

    @Override
    public int getRenderType() {
        return Reference.BLOCK_RENDER_ID;
    }

    @SideOnly(Side.CLIENT)
    private HashMap<String, IIcon> icons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        icons = new HashMap<>();
        icons.put("metalBlock", iconRegister.registerIcon(TextureHandler.getTexturePath("metalBlock")));
        icons.put("gemBlock", iconRegister.registerIcon(TextureHandler.getTexturePath("gemBlock")));
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < Configurations.RESOURCES.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
