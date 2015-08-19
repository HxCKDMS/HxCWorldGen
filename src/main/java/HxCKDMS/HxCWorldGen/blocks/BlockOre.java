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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[6];
        icons[0] = iconRegister.registerIcon(TextureHandler.getTexturePath("ore"));
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
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        return true;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        if (Configurations.enableFragments) {
            return itemOreChunk;
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