package HxCKDMS.HxCWorldGen.registry;

import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import HxCKDMS.HxCWorldGen.items.ItemBlockOre;
import HxCKDMS.HxCWorldGen.items.ItemBlockStorage;
import HxCKDMS.HxCWorldGen.items.ItemResource;
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
    }

    private static void registerRecipes(){
        //blocking
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 0), "iii", "iii", "iii", 'i', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 1), "iii", "iii", "iii", 'i', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 2), "iii", "iii", "iii", 'i', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 3), "iii", "iii", "iii", 'i', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 4), "iii", "iii", "iii", 'i', "ingotNickel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 5), "iii", "iii", "iii", 'i', "ingotChromium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 6), "iii", "iii", "iii", 'i', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 7), "iii", "iii", "iii", 'i', "ingotTitanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 8), "iii", "iii", "iii", 'i', "ingotPlatinum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 9), "iii", "iii", "iii", 'i', "gemPeridot"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 10), "iii", "iii", "iii", 'i', "gemRuby"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 11), "iii", "iii", "iii", 'i', "gemSapphire"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, 12), "iii", "iii", "iii", 'i', "gemZircon"));

        //unblocking
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 0), "blockCopper"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 1), "blockTin"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 2), "blockSilver"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 3), "blockLead"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 4), "blockNickel"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 5), "blockChromium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 6), "blockAluminum"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 7), "blockTitanium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 8), "blockPlatinum"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 9), "blockPeridot"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 10), "blockRuby"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 11), "blockSapphire"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, 12), "blockZircon"));

        //smelting
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 0), new ItemStack(itemResource, 1, 0), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 1), new ItemStack(itemResource, 1, 1), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 2), new ItemStack(itemResource, 1, 2), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 3), new ItemStack(itemResource, 1, 3), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 4), new ItemStack(itemResource, 1, 4), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 5), new ItemStack(itemResource, 1, 5), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 6), new ItemStack(itemResource, 1, 6), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 7), new ItemStack(itemResource, 1, 7), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 8), new ItemStack(itemResource, 1, 8), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 9), new ItemStack(itemResource, 1, 9), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 10), new ItemStack(itemResource, 1, 10), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 11), new ItemStack(itemResource, 1, 11), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, 12), new ItemStack(itemResource, 1, 7), 10F);
    }

    private static void registerOreDictionary(){
        //ores
        OreDictionary.registerOre("oreCopper", new ItemStack(blockOre, 1, 0));
        OreDictionary.registerOre("oreTin", new ItemStack(blockOre, 1, 1));
        OreDictionary.registerOre("oreSilver", new ItemStack(blockOre, 1, 2));
        OreDictionary.registerOre("oreLead", new ItemStack(blockOre, 1, 3));
        OreDictionary.registerOre("oreNickel", new ItemStack(blockOre, 1, 4));
        OreDictionary.registerOre("oreChromium", new ItemStack(blockOre, 1, 5));
        OreDictionary.registerOre("oreAluminum", new ItemStack(blockOre, 1, 6));
        OreDictionary.registerOre("oreTitanium", new ItemStack(blockOre, 1, 7));
        OreDictionary.registerOre("orePlatinum", new ItemStack(blockOre, 1, 8));
        OreDictionary.registerOre("oreAventurine", new ItemStack(blockOre, 1, 9));
        OreDictionary.registerOre("oreRuby", new ItemStack(blockOre, 1, 10));
        OreDictionary.registerOre("oreSapphire", new ItemStack(blockOre, 1, 11));
        OreDictionary.registerOre("oreRutile", new ItemStack(blockOre, 1, 12));

        //ingots
        OreDictionary.registerOre("ingotCopper", new ItemStack(itemResource, 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(itemResource, 1, 1));
        OreDictionary.registerOre("ingotSilver", new ItemStack(itemResource, 1, 2));
        OreDictionary.registerOre("ingotLead", new ItemStack(itemResource, 1, 3));
        OreDictionary.registerOre("ingotNickel", new ItemStack(itemResource, 1, 4));
        OreDictionary.registerOre("ingotChromium", new ItemStack(itemResource, 1, 5));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(itemResource, 1, 6));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(itemResource, 1, 7));
        OreDictionary.registerOre("ingotPlatinum", new ItemStack(itemResource, 1, 8));
        OreDictionary.registerOre("ingotZirconia", new ItemStack(itemResource, 1, 13));
        //gems
        OreDictionary.registerOre("gemPeridot", new ItemStack(itemResource, 1, 9));
        OreDictionary.registerOre("gemRuby", new ItemStack(itemResource, 1, 10));
        OreDictionary.registerOre("gemSapphire", new ItemStack(itemResource, 1, 11));
        OreDictionary.registerOre("gemZircon", new ItemStack(itemResource, 1, 12));

        //Storage blocks
        OreDictionary.registerOre("blockCopper", new ItemStack(blockStorage, 1, 0));
        OreDictionary.registerOre("blockTin", new ItemStack(blockStorage, 1, 1));
        OreDictionary.registerOre("blockSilver", new ItemStack(blockStorage, 1, 2));
        OreDictionary.registerOre("blockLead", new ItemStack(blockStorage, 1, 3));
        OreDictionary.registerOre("blockNickel", new ItemStack(blockStorage, 1, 4));
        OreDictionary.registerOre("blockChromium", new ItemStack(blockStorage, 1, 5));
        OreDictionary.registerOre("blockAluminum", new ItemStack(blockStorage, 1, 6));
        OreDictionary.registerOre("blockTitanium", new ItemStack(blockStorage, 1, 7));
        OreDictionary.registerOre("blockPlatinum", new ItemStack(blockStorage, 1, 8));
        OreDictionary.registerOre("blockPeridot", new ItemStack(blockStorage, 1, 9));
        OreDictionary.registerOre("blockRuby", new ItemStack(blockStorage, 1, 10));
        OreDictionary.registerOre("blockSapphire", new ItemStack(blockStorage, 1, 11));
        OreDictionary.registerOre("blockZircon", new ItemStack(blockStorage, 1, 12));
    }
}
