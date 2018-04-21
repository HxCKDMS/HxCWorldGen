package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import HxCKDMS.HxCWorldGen.items.*;
import HxCKDMS.HxCWorldGen.world.OreGenHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static HxCKDMS.HxCWorldGen.creativeTabs.MWGcreativeTab.moreWorldGenTab;
import static HxCKDMS.HxCWorldGen.libs.Configurations.*;

public class ModRegistry {
    public static Block blockOre = new BlockOre(Material.rock, moreWorldGenTab);
    public static Block blockStorage = new BlockStorage(Material.iron, moreWorldGenTab);
    public static Item itemResource = new ItemResource(moreWorldGenTab);
    public static Item itemOreChunk = new ItemOreChunk(moreWorldGenTab);
    public static Item itemFragment = new ItemResourceNugget(moreWorldGenTab);
    public static Item itemDust = new ItemDust(moreWorldGenTab);

    public static Item itemTinyDust = new ItemTinyDust(moreWorldGenTab);
    public static Item itemCrushed = new ItemCrushed(moreWorldGenTab);
    public static Item itemPureCrushed = new ItemPureCrushed(moreWorldGenTab);

    public static void preInit(){
        registerBlocks();
        registerItems();
        GameRegistry.registerWorldGenerator(new OreGenHandler(), 1);
    }
    
    public static void init(){
        registerOreDictionary();
        registerRecipes();
    }

    private static void registerBlocks(){
        GameRegistry.registerBlock(blockOre, ItemBlockOre.class, "blockOre");
        GameRegistry.registerBlock(blockStorage, ItemBlockStorage.class, "blockStorage");
    }

    private static void registerItems(){
        GameRegistry.registerItem(itemResource, "itemResource");
        GameRegistry.registerItem(itemFragment, "itemFragment");
        GameRegistry.registerItem(itemDust, "itemDust");

        if (Loader.isModLoaded("IC2")) {
            GameRegistry.registerItem(itemTinyDust, "itemTinyDust");
            GameRegistry.registerItem(itemCrushed, "itemCrushed");
            GameRegistry.registerItem(itemPureCrushed, "itemPureCrushed");
        }
        if (Configurations.enableOreChunks)
            GameRegistry.registerItem(itemOreChunk, "itemOreChunk");
    }

    private static void registerRecipes(){
        for (int i = 0; i < RESOURCES.size(); i++) {
            if (RESOURCES.get(i).contains("Gem"))GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, i), "iii", "iii", "iii", 'i', "gem" + RESOURCES.get(i).replace("Gem", "")));
            if (RESOURCES.get(i).contains("Ingot"))GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockStorage, 1, i), "iii", "iii", "iii", 'i', "ingot" + RESOURCES.get(i).replace("Ingot", "")));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(itemResource, 1, i), "iii", "iii", "iii", 'i', "nugget" + RESOURCES.get(i).replace("Gem", "").replace("Ingot", "")));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemResource, 9, i), "block" + RESOURCES.get(i).replace("Gem", "").replace("Ingot", "")));
            if (RESOURCES.get(i).contains("Gem"))GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemFragment, 9, i), "gem" + RESOURCES.get(i).replace("Gem", "")));
            if (RESOURCES.get(i).contains("Ingot"))GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemFragment, 9, i), "ingot" + RESOURCES.get(i).replace("Ingot", "")));
        }

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemDust, 9, 17), "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustChromium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemDust, 4, 15), "dustCopper", "dustCopper", "dustCopper", "dustTin"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemDust, 9, 16), "dustZinc", "dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustCopper"));

        //smelting
        for (int i = 0; i < ORES.size()-1; i++)
            GameRegistry.addSmelting(new ItemStack(blockOre, 1, i), new ItemStack(itemResource, 1, i), 10F);
        GameRegistry.addSmelting(new ItemStack(blockOre, 1, ORES.size() - 1), new ItemStack(itemResource, 1, 7), 10F);

        for (int i = 0; i < DUSTOUTPUTS.size(); i++)
            GameRegistry.addSmelting(new ItemStack(itemDust, 1, i), OreDictionary.getOres(DUSTOUTPUTS.get(i)).get(0), 10F);

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
        for (int i = 0; i < ORES.size(); i++) {
            OreDictionary.registerOre("ore" + ORES.get(i).replace("Ore", ""), new ItemStack(blockOre, 1, i));
            if (Loader.isModLoaded("IC2")) {
                OreDictionary.registerOre("crushed" + ORES.get(i).replace("Ore", ""), new ItemStack(itemCrushed, 1, i));
                OreDictionary.registerOre("pureCrushed" + ORES.get(i).replace("Ore", ""), new ItemStack(itemPureCrushed, 1, i));
            }
            OreDictionary.registerOre("oreChunk" + ORES.get(i).replace("Ore", ""), new ItemStack(itemOreChunk, 1, i));
        }

        for (int i = 0; i < DUSTS.size(); i++) {
            OreDictionary.registerOre("dust" + DUSTS.get(i).replace("Dust", ""), new ItemStack(itemDust, 1, i));

            if (Loader.isModLoaded("IC2"))
                OreDictionary.registerOre("dustTiny" + DUSTS.get(i).replace("Dust", ""), new ItemStack(itemTinyDust, 1, i));
        }
        //ingots
        for (int i = 0; i < RESOURCES.size(); i++) {
            if (RESOURCES.get(i).contains("Gem"))OreDictionary.registerOre("gem" + RESOURCES.get(i).replace("Gem", ""), new ItemStack(itemResource, 1, i));
            if (RESOURCES.get(i).contains("Ingot"))OreDictionary.registerOre("ingot" + RESOURCES.get(i).replace("Ingot", ""), new ItemStack(itemResource, 1, i));

            OreDictionary.registerOre("nugget" + RESOURCES.get(i).replace("Ingot", "").replace("Gem", ""), new ItemStack(itemFragment, 1, i));
            OreDictionary.registerOre("block" + RESOURCES.get(i).replace("Ingot", "").replace("Gem", ""), new ItemStack(blockStorage, 1, i));
        }
    }
}
