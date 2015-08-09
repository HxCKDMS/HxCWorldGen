package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import HxCKDMS.HxCWorldGen.items.*;
import HxCKDMS.HxCWorldGen.world.OreGenHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static HxCKDMS.HxCWorldGen.creativeTabs.MWGcreativeTab.moreWorldGenTab;

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

public class ModRegistry {
    public static Block blockOre = new BlockOre(Material.rock, moreWorldGenTab);
    public static Block blockStorage = new BlockStorage(Material.iron, moreWorldGenTab);
    public static Item itemResource = new ItemResource(moreWorldGenTab);
    public static Item itemOreChunk = new ItemOreChunk(moreWorldGenTab);
    public static Item itemFragment = new ItemResourcePiece(moreWorldGenTab);

    public static void preInit(){
        registerBlocks();
        registerItems();
        registerRecipes();
        GameRegistry.registerWorldGenerator(new OreGenHandler(), 1);
    }
    
    public static void init(){
        registerOreDictionary();
    }

    private static void registerBlocks(){
        GameRegistry.registerBlock(blockOre, ItemBlockOre.class, "blockOre");
        GameRegistry.registerBlock(blockStorage, ItemBlockStorage.class, "BlockStorage");
    }

    private static void registerItems(){
        GameRegistry.registerItem(itemResource, "itemResource");
        GameRegistry.registerItem(itemOreChunk, "itemOreChunk");
        GameRegistry.registerItem(itemFragment, "itemFragment");
    }

    private static void registerRecipes(){
        //blocking
        for (int i = 0; i < 12; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, i), "iii", "iii", "iii", 'i', Reference.RESOURCES[i]));
        for (int i = 0; i < 12; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(itemResource, 1, i), "iii", "iii", "iii", 'i', Reference.PIECES[i]));

        //unblocking
        for (int i = 0; i < 12; i++)
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, i), Reference.BLOCKS[i]));
        for (int i = 0; i < 12; i++)
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemFragment, 9, i), Reference.RESOURCES[i]));

        //smelting
        for (int i = 0; i < 11; i++)
            GameRegistry.addSmelting(new ItemStack(blockOre, 1, i), new ItemStack(itemResource, 1, i), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 12), new ItemStack(itemResource, 1, 7), 10F);
        for (int i = 0; i < 12; i++)
            GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, i), new ItemStack(itemFragment, 6, i), 10F);
        GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, 12), new ItemStack(itemFragment, 6, 7), 10F);
    }

    private static void registerOreDictionary(){
        //ores
        for (int i = 0; i < 12; i++)
            OreDictionary.registerOre(Reference.ORES[i], new ItemStack(blockOre, 1, i));

        OreDictionary.registerOre("oreAluminum", new ItemStack(blockOre, 1, 6));

        //ingots
        for (int i = 0; i < 13; i++)
            OreDictionary.registerOre(Reference.RESOURCES[i], new ItemStack(itemResource, 1, i));
        for (int i = 0; i < 13; i++)
            OreDictionary.registerOre(Reference.PIECES[i], new ItemStack(itemFragment, 1, i));

        //Storage blocks
        for (int i = 0; i < 12; i++)
            OreDictionary.registerOre(Reference.BLOCKS[i], new ItemStack(blockStorage, 1, i));
    }
}
