package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Configurations {
    @Config.Map(description = "Requires a meta data, if it doesn't have a meta put 0 else it will crash")
    public static HashMap<String, String> Ores = new LinkedHashMap<>();

    @Config.Map
    public static HashMap<String, Integer> nodeSizes = new LinkedHashMap<>();

    @Config.Boolean
    public static boolean forceNormalRendering = true, enableFragments = true, enableTinkerMaterials = true, FragmentsToIngots;

    @Config.Integer(description = "0 = try to blend with resource pack, 16/32/64 are my resources")
    public static int ResourceSize = 32;

    @Config.Integer
    public static int TConstructStartingID = 240;

    @Config.Integer
    public static int OreNodeSizeMultiplier = 1;

    static {
         Ores.put("Copper", "HxCWorldGen:blockOre:0");
         Ores.put("Tin", "HxCWorldGen:blockOre:1");
         Ores.put("Silver", "HxCWorldGen:blockOre:2");
         Ores.put("Lead", "HxCWorldGen:blockOre:3");
         Ores.put("Nickel", "HxCWorldGen:blockOre:4");
         Ores.put("Chromium", "HxCWorldGen:blockOre:5");
         Ores.put("Aluminium", "HxCWorldGen:blockOre:6");
         Ores.put("Titanium", "HxCWorldGen:blockOre:7");
         Ores.put("Platinum", "HxCWorldGen:blockOre:8");
         Ores.put("Aventurine", "HxCWorldGen:blockOre:9");
         Ores.put("Ruby", "HxCWorldGen:blockOre:10");
         Ores.put("Sapphire", "HxCWorldGen:blockOre:11");
         Ores.put("Rutile", "HxCWorldGen:blockOre:12");

        nodeSizes.put("Copper", 6);
        nodeSizes.put("Tin", 7);
        nodeSizes.put("Silver", 4);
        nodeSizes.put("Lead", 4);
        nodeSizes.put("Nickel", 3);
        nodeSizes.put("Chromium", 3);
        nodeSizes.put("Aluminium", 4);
        nodeSizes.put("Titanium", 3);
        nodeSizes.put("Platinum", 1);
        nodeSizes.put("Aventurine", 4);
        nodeSizes.put("Ruby", 4);
        nodeSizes.put("Sapphire", 4);
        nodeSizes.put("Rutile", 2);
    }
}
