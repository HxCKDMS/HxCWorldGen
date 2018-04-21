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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static HxCKDMS.HxCWorldGen.libs.ModRegistry.*;

public class BlockOre extends Block {
    public BlockOre(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(creativeTabs);
        miningLevel();
    }

    private void miningLevel() {
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
        setHarvestLevel("pickaxe", 3, 13);
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (Configurations.enableOreChunks) {
            if (Configurations.FragmentsToIngots) return rand.nextInt(fortune) + 1;
            else return rand.nextInt(fortune + 3) + 1;
        }
        else return 1;
    }

    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        return true;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        if (Configurations.enableOreChunks)
            return itemOreChunk;
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

    @Override
    public int getRenderType() {
        return Reference.ORE_RENDER_ID;
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return icon;
    }

    @SideOnly(Side.CLIENT)
    private IIcon icon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(TextureHandler.getTexturePath("ore"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for (int i = 0; i < Configurations.ORES.size(); i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}