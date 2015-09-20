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
    public static Item itemFragment = new ItemResourceNugget(moreWorldGenTab);
    public static Item itemDust = new ItemDust(moreWorldGenTab);

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
        GameRegistry.registerBlock(blockStorage, ItemBlockStorage.class, "blockStorage");
    }

    private static void registerItems(){
        GameRegistry.registerItem(itemResource, "itemResource");
        GameRegistry.registerItem(itemFragment, "itemFragment");
        GameRegistry.registerItem(itemDust, "itemDust");
        if (Configurations.enableOreChunks)
            GameRegistry.registerItem(itemOreChunk, "itemOreChunk");
    }

    private static void registerRecipes(){
        for (int i = 0; i < Reference.RESOURCES.length; i++) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, i), "iii", "iii", "iii", 'i', Reference.OREDICTIONARYRESOURCES[i]));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(itemResource, 1, i), "iii", "iii", "iii", 'i', Reference.OREDICTIONARYNUGGETS[i]));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, i), Reference.OREDICTIONARYBLOCKS[i]));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemFragment, 9, i), Reference.OREDICTIONARYRESOURCES[i]));
        }

        //smelting
        for (int i = 0; i < Reference.ORES.length-1; i++)
            GameRegistry.addSmelting(new ItemStack(blockOre, 1, i), new ItemStack(itemResource, 1, i), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, Reference.ORES.length-1), new ItemStack(itemResource, 1, 7), 10F);

        for (int i = 0; i < Reference.DUSTS.length; i++)
            GameRegistry.addSmelting(new ItemStack(itemDust, 1, i), new ItemStack(itemResource, 1, i), 10F);

        if (Configurations.enableOreChunks) {
            if (!Configurations.FragmentsToIngots) {
                for (int i = 0; i < 12; i++)
                    GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, i), new ItemStack(itemFragment, 6, i), 10F);
                GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, 12), new ItemStack(itemFragment, 6, 7), 10F);
            } else {
                for (int i = 0; i < 12; i++)
                    GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, i), new ItemStack(itemResource, 1, i), 10F);
                GameRegistry.addSmelting(new ItemStack(itemOreChunk, 1, 12), new ItemStack(itemResource, 1, 7), 10F);
            }
        }
    }

    private static void registerOreDictionary(){
        //ores
        for (int i = 0; i < Reference.ORES.length; i++)
            OreDictionary.registerOre(Reference.OREDICTIONARYORES[i], new ItemStack(blockOre, 1, i));
        OreDictionary.registerOre("oreAluminum", new ItemStack(blockOre, 1, 6));

        for (int i = 0; i < Reference.DUSTS.length; i++)
            OreDictionary.registerOre(Reference.OREDICTIONARYDUSTS[i], new ItemStack(itemDust, 1, i));

        //ingots
        for (int i = 0; i < Reference.RESOURCES.length; i++) {
            OreDictionary.registerOre(Reference.OREDICTIONARYRESOURCES[i], new ItemStack(itemResource, 1, i));
            OreDictionary.registerOre(Reference.OREDICTIONARYNUGGETS[i], new ItemStack(itemFragment, 1, i));
            OreDictionary.registerOre(Reference.OREDICTIONARYBLOCKS[i], new ItemStack(blockStorage, 1, i));
        }
    }
}
