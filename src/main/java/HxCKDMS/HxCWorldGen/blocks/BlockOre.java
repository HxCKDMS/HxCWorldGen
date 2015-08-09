package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import HxCKDMS.HxCWorldGen.proxy.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Random;

import static HxCKDMS.HxCWorldGen.libs.ModRegistry.blockOre;
import static HxCKDMS.HxCWorldGen.libs.ModRegistry.itemFragment;
import static HxCKDMS.HxCWorldGen.libs.ModRegistry.itemResource;


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

public class BlockOre extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockOre(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(creativeTabs);
        miningLevel();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Forces torch placement on top.
     */
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }

    /**
     * Makes the block properly interact with AO.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube() {
        return true;
    }

    /**
     * Forces Redstone conduction.
     */
    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }

    /**
     * Forces torch placement on sides.
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    private void miningLevel(){
        //stone
        setHarvestLevel("pickaxe", 1, 0);
        setHarvestLevel("pickaxe", 1, 1);
        setHarvestLevel("pickaxe", 1, 6);

        //iron
        setHarvestLevel("pickaxe", 2, 2);
        setHarvestLevel("pickaxe", 2, 3);
        setHarvestLevel("pickaxe", 2, 4);
        setHarvestLevel("pickaxe", 2, 5);
        setHarvestLevel("pickaxe", 2, 8);
        setHarvestLevel("pickaxe", 2, 9);
        setHarvestLevel("pickaxe", 2, 10);
        setHarvestLevel("pickaxe", 2, 11);

        //diamond
        setHarvestLevel("pickaxe", 3, 7);
        setHarvestLevel("pickaxe", 3, 12);
    }

    @Override
    public int getRenderType() {
        return Reference.ORE_RENDER_ID;
    }

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[7];
        for (int i = 0; i < 6; i++) icons[i] = iconRegister.registerIcon("minecraft:stone");
        icons[6] = iconRegister.registerIcon(TextureHandler.getTexturePath("ore"));
    }

    /**
     * Makes the block render on both passes.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        ClientProxy.renderPass = pass;
        return true;
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[side];
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < 13; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (Configurations.enableFragments) {
            if (Configurations.FragmentsToIngots)return rand.nextInt(fortune) +1;
            else return rand.nextInt(fortune + 3) +1;
        }
        else return 1;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        if (Configurations.enableFragments) {
            return itemFragment;
        }
        else
            switch(metadata) {
                case 9:
                    return itemResource;
                case 10:
                    return itemResource;
                case 11:
                    return itemResource;
                default:
                    return Item.getItemFromBlock(blockOre);
            }
    }
}