package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCCore.Api.EnumHxCRegistryType;
import HxCKDMS.HxCCore.Api.HxCCommonRegistry;
import HxCKDMS.HxCCore.Registry.CommonModRegistry;
import HxCKDMS.HxCWorldGen.creativeTabs.MWGcreativeTab;
import HxCKDMS.HxCWorldGen.items.ItemBlockOre;
import HxCKDMS.HxCWorldGen.items.ItemGem;
import HxCKDMS.HxCWorldGen.util.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

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

@HxCCommonRegistry(unlocalizedName = "BlockOre", registryType = EnumHxCRegistryType.BLOCK, itemBlock = ItemBlockOre.class)
public class BlockOre extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockOre() {
        super(Material.rock);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(MWGcreativeTab.moreWorldGenTab);
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
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        icons = new IIcon[256];
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":OreCopper");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":OreTin");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":OreSilver");
        icons[3] = iconRegister.registerIcon(Reference.MOD_ID + ":OreLead");
        icons[4] = iconRegister.registerIcon(Reference.MOD_ID + ":OreNickel");
        icons[5] = iconRegister.registerIcon(Reference.MOD_ID + ":OreChromium");
        icons[6] = iconRegister.registerIcon(Reference.MOD_ID + ":OreAluminium");
        icons[7] = iconRegister.registerIcon(Reference.MOD_ID + ":OreTitanium");
        icons[8] = iconRegister.registerIcon(Reference.MOD_ID + ":OrePlatinum");
        icons[9] = iconRegister.registerIcon(Reference.MOD_ID + ":OreAventurine");
        icons[10] = iconRegister.registerIcon(Reference.MOD_ID + ":OreRuby");
        icons[11] = iconRegister.registerIcon(Reference.MOD_ID + ":OreSapphire");
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return icons[metadata];
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 12; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        switch(metadata){
            case 9:
                return CommonModRegistry.itemRegistry.get(ItemGem.class);
            case 10:
                return CommonModRegistry.itemRegistry.get(ItemGem.class);
            case 11:
                return CommonModRegistry.itemRegistry.get(ItemGem.class);
            default:
                return Item.getItemFromBlock(CommonModRegistry.blockRegistry.get(BlockOre.class));
        }
    }
}