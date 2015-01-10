package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.registry.BlockRegistry;
import HxCKDMS.HxCWorldGen.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/*
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
*/

public class BlockOre extends Block {
    @SideOnly(Side.CLIENT)

    public BlockOre(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(creativeTabs);
        setUnlocalizedName("BlockOre");
        miningLevel();
    }

    private void miningLevel(){
        //stone
        setHarvestLevel("pickaxe", 1, getStateFromMeta(0));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(1));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(6));

        //iron
        setHarvestLevel("pickaxe", 2, getStateFromMeta(2));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(3));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(4));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(5));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(8));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(9));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(10));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(11));

        //diamond
        setHarvestLevel("pickaxe", 3, getStateFromMeta(7));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 12; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune){
        int metadata = this.getMetaFromState(state);
        switch(metadata){
            case 9:
                return ItemRegistry.itemGem;
            case 10:
                return ItemRegistry.itemGem;
            case 11:
                return ItemRegistry.itemGem;
            default:
                return Item.getItemFromBlock(BlockRegistry.blockOre);
        }
    }
}