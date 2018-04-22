package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;

public class BlockStorage extends Block {
    public BlockStorage(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setStepSound(Block.soundTypeMetal);
        setCreativeTab(creativeTabs);
        setBlockUnbreakable();
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        if (metadata >= 9 && metadata <= 11 || metadata == Configurations.RESOURCES.size()-1) return icons.get("gemBlock");
        return icons.get("metalBlock");
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int face, float subX, float subY, float subZ, int meta) {
        int a = super.onBlockPlaced(world, x, y, z, face, subX, subY, subZ, meta);
        TileStorageBlock t = new TileStorageBlock();
        t.blockName = Configurations.RESOURCES.get(meta);
        world.setTileEntity(x, y, z, t);
        return a;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int face, float subX, float subY, float subZ) {
        if (!world.isRemote && player.isSneaking() && player.getHeldItem() == null) {
            TileEntity t = world.getTileEntity(x, y, z);
            System.out.println(world.getBlockMetadata(x, y, z));
            if (t != null && t instanceof TileStorageBlock) {
                for (int i = 0; i < Configurations.RESOURCES.size(); i++) {
                    if (Configurations.RESOURCES.get(i) == ((TileStorageBlock) t).blockName) {
                        ItemStack stack = new ItemStack(ModRegistry.blockStorage, i);
                        world.spawnEntityInWorld(new EntityItem(world, x, y, z, stack));
                        world.setBlockToAir(x, y, z);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        TileStorageBlock b = new TileStorageBlock();
        b.blockName = Configurations.RESOURCES.get(metadata);
        return b;
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
        for(int i = 0; i < Configurations.RESOURCES.size(); i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
