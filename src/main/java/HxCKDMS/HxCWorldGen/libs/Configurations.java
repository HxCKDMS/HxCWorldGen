package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;

import java.util.*;

public class Configurations {
    @Config.Map(description = "Requires a meta data, if it doesn't have a meta put 0 else it will crash")
    public static HashMap<String, String> Ores = new LinkedHashMap<>();

    @Config.Map
    public static HashMap<String, Integer> nodeSizes = new LinkedHashMap<>(),
            oreDepth = new LinkedHashMap<>(), oreRarity = new LinkedHashMap<>();

    @Config.String
    public static String oreResource = "ore";

    @Config.Boolean
    public static boolean enableOreChunks = true, enableTinkerMaterials = true, enableIC2Recipes = true, FragmentsToIngots, tryToBlendIn;

    @Config.Integer(description = "16/32/64 are my resources")
    public static int ResourceSize = 32;

    @Config.Integer
    public static int TConstructStartingID = 240, OreNodeSizeMultiplier = 1;

    @Config.List
    public static List<Integer> validDimensions = Arrays.asList(0, 1, -1, 6, 7, -100, -19), specialDimensions = Arrays.asList(1, -1, 6, 7, -100, -19);

    static {
        Ores.put("CopperOre", "HxCWorldGen:blockOre:0");
        Ores.put("TinOre", "HxCWorldGen:blockOre:1");
        Ores.put("SilverOre", "HxCWorldGen:blockOre:2");
        Ores.put("LeadOre", "HxCWorldGen:blockOre:3");
        Ores.put("NickelOre", "HxCWorldGen:blockOre:4");
        Ores.put("ChromiumOre", "HxCWorldGen:blockOre:5");
        Ores.put("AluminumOre", "HxCWorldGen:blockOre:6");
        Ores.put("IlmeniteOre", "HxCWorldGen:blockOre:7");
        Ores.put("PlatinumOre", "HxCWorldGen:blockOre:8");
        Ores.put("PeridotOre", "HxCWorldGen:blockOre:9");
        Ores.put("RubyOre", "HxCWorldGen:blockOre:10");
        Ores.put("SapphireOre", "HxCWorldGen:blockOre:11");
        Ores.put("RutileOre", "HxCWorldGen:blockOre:12");
        Ores.put("ZincOre", "HxCWorldGen:blockOre:13");

        //Thinking of changing to String, String for "size, depth, rarity" in same line
        nodeSizes.put("CopperOre", 6);
        nodeSizes.put("TinOre", 7);
        nodeSizes.put("SilverOre", 4);
        nodeSizes.put("LeadOre", 4);
        nodeSizes.put("NickelOre", 3);
        nodeSizes.put("ChromiumOre", 3);
        nodeSizes.put("AluminumOre", 4);
        nodeSizes.put("IlmeniteOre", 3);
        nodeSizes.put("PlatinumOre", 1);
        nodeSizes.put("PeridotOre", 4);
        nodeSizes.put("RubyOre", 4);
        nodeSizes.put("SapphireOre", 4);
        nodeSizes.put("RutileOre", 2);
        nodeSizes.put("ZincOre", 2);

        oreDepth.put("CopperOre", 64);
        oreDepth.put("TinOre", 60);
        oreDepth.put("SilverOre", 20);
        oreDepth.put("LeadOre", 16);
        oreDepth.put("NickelOre", 18);
        oreDepth.put("ChromiumOre", 12);
        oreDepth.put("AluminumOre", 80);
        oreDepth.put("IlmeniteOre", 10);
        oreDepth.put("PlatinumOre", 10);
        oreDepth.put("PeridotOre", 20);
        oreDepth.put("RubyOre", 28);
        oreDepth.put("SapphireOre", 24);
        oreDepth.put("RutileOre", 12);
        oreDepth.put("ZincOre", 16);

        oreRarity.put("CopperOre", 6);
        oreRarity.put("TinOre", 6);
        oreRarity.put("SilverOre", 4);
        oreRarity.put("LeadOre", 3);
        oreRarity.put("NickelOre", 2);
        oreRarity.put("ChromiumOre", 2);
        oreRarity.put("AluminumOre", 5);
        oreRarity.put("IlmeniteOre", 2);
        oreRarity.put("PlatinumOre", 1);
        oreRarity.put("PeridotOre", 4);
        oreRarity.put("RubyOre", 5);
        oreRarity.put("SapphireOre", 4);
        oreRarity.put("RutileOre", 2);
        oreRarity.put("ZincOre", 3);
    }
}
