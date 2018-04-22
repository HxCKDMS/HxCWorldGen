package HxCKDMS.HxCWorldGen.libs;

import hxckdms.hxcconfig.Config;

import java.awt.*;
import java.util.*;
import java.util.List;

@Config
@SuppressWarnings({"unused","WeakerAccess"})
public class Configurations {
    public static HashMap<String, ore> Ores = new LinkedHashMap<>();
    public static String oreResource = "ore";
    public static boolean enableOreChunks = true, enableTinkerMaterials = true, enableIC2Recipes = true, FragmentsToIngots, tryToBlendIn;
    public static int ResourceSize = 32;
    public static int TConstructStartingID = 240, OreNodeSizeMultiplier = 1;
    public static List<Integer> validDimensions = Arrays.asList(0, 1, -1, 6, 7, -100, -19), specialDimensions = Arrays.asList(1, -1, 6, 7, -100, -19);

    public static HashMap<String, LinkedList<Integer>> Colours = new LinkedHashMap<>();


    public static LinkedList<String> DUSTS = new LinkedList<>(
            Arrays.asList("CopperDust", "TinDust", "SilverDust", "LeadDust", "NickelDust",
                    "ChromiumDust", "AluminumDust", "IlmeniteDust", "PlatinumDust", "PeridotDust", "RubyDust",
                    "SapphireDust", "ZincDust", "RutileDust", "TitaniumDust", "BronzeDust", "BrassDust", "SteelDust",
                    "ZirconiumDust", "IronDust", "GoldDust", "EmeraldDust", "DiamondDust", "CoalDust", "CharcoalDust",
                    "NetherDust", "SulfurDust"));

    public static LinkedList<String> DUSTOUTPUTS = new LinkedList<>(
            Arrays.asList("ingotCopper", "ingotTin", "ingotSilver", "ingotLead",
                    "ingotNickel", "ingotChromium", "ingotAluminum", "ingotTitanium", "ingotPlatinum", "gemPeridot",
                    "gemRuby", "gemSapphire", "ingotZinc", "ingotTitanium", "ingotTitanium", "ingotBronze", "ingotBrass",
                    "ingotSteel", "ingotZircon", "ingotIron", "ingotGold", "gemEmerald", "gemDiamond"));

    public static LinkedList<String> RESOURCES = new LinkedList<>(
            Arrays.asList("CopperIngot", "TinIngot", "SilverIngot", "LeadIngot", "NickelIngot",
                    "ChromiumIngot", "AluminumIngot", "TitaniumIngot", "PlatinumIngot", "PeridotGem", "RubyGem",
                    "SapphireGem", "ZincIngot", "BronzeIngot", "BrassIngot", "SteelIngot", "ZirconIngot", "ZirconGem"));

    public static LinkedList<String> ORES = new LinkedList<>(
            Arrays.asList("CopperOre", "TinOre", "SilverOre", "LeadOre", "NickelOre",
                    "ChromiumOre", "AluminumOre", "IlmeniteOre", "PlatinumOre", "PeridotOre", "RubyOre",
                    "SapphireOre", "ZincOre", "RutileOre"));


    public static void init() {
        Colours.put("Titanium", new LinkedList<>(
                Arrays.asList(190, 210, 215)));
        Colours.put("Zircon", new LinkedList<>(
                Arrays.asList(150, 140, 130)));
        Colours.put("Zirconia", new LinkedList<>(
                Arrays.asList(190, 195, 198)));
        Colours.put("Steel", new LinkedList<>(
                Arrays.asList(140, 145, 150)));
        Colours.put("Bronze", new LinkedList<>(
                Arrays.asList(160, 105, 61)));
        Colours.put("Brass", new LinkedList<>(
                Arrays.asList(181, 166, 66)));
        Colours.put("Diamond", new LinkedList<>(
                Arrays.asList(200, 200, 250)));
        Colours.put("Emerald", new LinkedList<>(
                Arrays.asList(0, 255, 0)));
        Colours.put("Iron", new LinkedList<>(
                Arrays.asList(180, 180, 180)));
        Colours.put("Gold", new LinkedList<>(
                Arrays.asList(255, 215, 0)));
        Colours.put("Coal", new LinkedList<>(
                Arrays.asList(40, 40, 40)));
        Colours.put("Charcoal", new LinkedList<>(
                Arrays.asList(70, 70, 70)));
        Colours.put("Nether", new LinkedList<>(
                Arrays.asList(120, 40, 0)));
        Colours.put("Sulfur", new LinkedList<>(
                Arrays.asList(255, 240, 0)));
        Colours.put("Titanium", new LinkedList<>(
                Arrays.asList(180, 180, 180)));
        Colours.put("Bronze", new LinkedList<>(
                Arrays.asList(230, 180, 0)));
        Colours.put("Brass", new LinkedList<>(
                Arrays.asList(210, 180, 0)));
        Colours.put("Steel", new LinkedList<>(
                Arrays.asList(130, 130, 130)));
        Colours.put("ERROR", new LinkedList<>(
                Arrays.asList(255, 0, 0)));

        Ores.put("copper", new ore(Reference.MOD_ID + ":blockOre", (byte) 0, (short) 6, (short) 64,(short) 8, new int[]{0, 105, 0}, new int[]{174, 105, 41}));
        Ores.put("tin", new ore(Reference.MOD_ID + ":blockOre", (byte) 1, (short) 7, (short) 55,(short) 6, new int[]{220, 230, 255}));
        Ores.put("silver", new ore(Reference.MOD_ID + ":blockOre", (byte) 2, (short) 4, (short) 20,(short) 4, new int[]{200, 240, 255}));
        Ores.put("lead", new ore(Reference.MOD_ID + ":blockOre", (byte) 3, (short) 4, (short) 16,(short) 3, new int[]{160, 150, 160}));
        Ores.put("nickel", new ore(Reference.MOD_ID + ":blockOre", (byte) 4, (short) 3, (short) 18,(short) 2, new int[]{200, 200, 152}));
        Ores.put("chromium", new ore(Reference.MOD_ID + ":blockOre", (byte) 5, (short) 3, (short) 12,(short) 2, new int[]{210, 250, 255}));
        Ores.put("aluminum", new ore(Reference.MOD_ID + ":blockOre", (byte) 6, (short) 4, (short) 80,(short) 5, new int[]{235, 235, 240}));
        Ores.put("ilmenite", new ore(Reference.MOD_ID + ":blockOre", (byte) 7, (short) 3, (short) 10,(short) 2, new int[]{133, 95, 90}));
        Ores.put("platinum", new ore(Reference.MOD_ID + ":blockOre", (byte) 8, (short) 1, (short) 10,(short) 1, new int[]{160, 250, 255}));
        Ores.put("peridot", new ore(Reference.MOD_ID + ":blockOre", (byte) 9, (short) 4, (short) 20,(short) 4, new int[]{0, 160, 120}));
        Ores.put("ruby", new ore(Reference.MOD_ID + ":blockOre", (byte) 10, (short) 4, (short) 28,(short) 5, new int[]{200, 10, 10}));
        Ores.put("sapphire", new ore(Reference.MOD_ID + ":blockOre", (byte) 11, (short) 4, (short) 28,(short) 4, new int[]{30, 120, 200}));
        Ores.put("rutile", new ore(Reference.MOD_ID + ":blockOre", (byte) 12, (short) 2, (short) 12,(short) 2, new int[]{100, 56, 18}, new int[]{190, 210, 215}));
        Ores.put("zinc", new ore(Reference.MOD_ID + ":blockOre", (byte) 13, (short) 2, (short) 16,(short) 3, new int[]{200, 200, 190}));
    }

    public static int[] getColourRGB(String key) {
        final int[] arr = new int[3];
        Colours.forEach((nam, v) -> {
            if (nam.equalsIgnoreCase(key.toLowerCase().replace("ore", "").replace("nugget", "").replace("fragment", "").replace("ingot", "").replace("block", "").replace("chunk", "").replace("gem", "").replace("dust", ""))) {
                arr[0] = Colours.get(nam).get(0);
                arr[1] = Colours.get(nam).get(1);
                arr[2] = Colours.get(nam).get(2);
            }
        });

        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
            return new int[]{255, 0, 0};

        return new int[]{arr[0], arr[1], arr[2]};
    }

    public static int getColourINT(String key) {
        if (Ores.containsKey(key.toLowerCase().replace("ore", "").trim()))
            return Ores.get(key.toLowerCase().replace("ore", "").trim()).oreColour;

        if (Ores.containsKey(key.toLowerCase().replace("nugget", "").replace("fragment", "").replace("ingot", "").replace("block", "").replace("chunk", "").replace("gem", "").replace("dust", "")))
            return Ores.get(key.toLowerCase().replace("nugget", "").replace("fragment", "").replace("ingot", "").replace("block", "").replace("chunk", "").replace("gem", "").replace("dust", "")).resourceColour;

        int[] arr = getColourRGB(key);
        return new Color(arr[0], arr[1], arr[2]).getRGB();
    }

    public static class ore {
        public String oreBlockID;
        public byte oreMetadata;
        public short nodeSize;
        public short nodeDepth;
        public short nodeRarity;
        public int oreColour = 0x00000000;
        public int resourceColour = 0x00000000;

        public ore() {}

        public ore(String id, byte meta, short size, short depth, short rarity, int colour) {
            oreBlockID = id;
            oreMetadata = meta;
            nodeSize = size;
            nodeDepth = depth;
            nodeRarity = rarity;
            oreColour = colour;
        }

        public ore(String id, byte meta, short size, short depth, short rarity, int[] colour) {
            oreBlockID = id;
            oreMetadata = meta;
            nodeSize = size;
            nodeDepth = depth;
            nodeRarity = rarity;
            oreColour = new Color(colour[0], colour[1], colour[2]).getRGB();
            resourceColour = new Color(colour[0], colour[1], colour[2]).getRGB();
        }

        public ore(String id, byte meta, short size, short depth, short rarity, int colour, int itemColour) {
            oreBlockID = id;
            oreMetadata = meta;
            nodeSize = size;
            nodeDepth = depth;
            nodeRarity = rarity;
            oreColour = colour;
            resourceColour = itemColour;
        }

        public ore(String id, byte meta, short size, short depth, short rarity, int[] colour, int[] itemColour) {
            oreBlockID = id;
            oreMetadata = meta;
            nodeSize = size;
            nodeDepth = depth;
            nodeRarity = rarity;
            oreColour = new Color(colour[0], colour[1], colour[2]).getRGB();
            resourceColour = new Color(itemColour[0], itemColour[1], itemColour[2]).getRGB();
        }
    }
}
