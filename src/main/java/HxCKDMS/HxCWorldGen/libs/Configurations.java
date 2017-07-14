package HxCKDMS.HxCWorldGen.libs;

import hxckdms.hxcconfig.Config;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public void init() {
        if (Ores.isEmpty()) initHashMap();
    }

    public static String[] DUSTS = new String[]{"CopperDust", "TinDust", "SilverDust", "LeadDust", "NickelDust",
            "ChromiumDust", "AluminumDust", "IlmeniteDust", "PlatinumDust", "PeridotDust", "RubyDust",
            "SapphireDust", "ZincDust", "RutileDust", "TitaniumDust", "BronzeDust", "BrassDust", "SteelDust",
            "ZirconiumDust", "IronDust", "GoldDust", "EmeraldDust", "DiamondDust", "CoalDust", "CharcoalDust",
            "NetherDust", "SulfurDust"};

    public static String[] DUSTOUTPUTS = new String[]{"ingotCopper", "ingotTin", "ingotSilver", "ingotLead",
            "ingotNickel", "ingotChromium", "ingotAluminum", "ingotTitanium", "ingotPlatinum", "gemPeridot",
            "gemRuby", "gemSapphire", "ingotZinc", "ingotTitanium", "ingotTitanium", "ingotBronze", "ingotBrass",
            "ingotSteel", "ingotZircon", "ingotIron", "ingotGold", "gemEmerald", "gemDiamond"};

    public static String[] RESOURCES = new String[]{"CopperIngot", "TinIngot", "SilverIngot", "LeadIngot", "NickelIngot",
            "ChromiumIngot", "AluminumIngot", "TitaniumIngot", "PlatinumIngot", "PeridotGem", "RubyGem",
            "SapphireGem", "ZincIngot", "BronzeIngot", "BrassIngot", "SteelIngot", "ZirconIngot", "ZirconGem"};

    public static String[] ORES = new String[]{"CopperOre", "TinOre", "SilverOre", "LeadOre", "NickelOre",
            "ChromiumOre", "AluminumOre", "IlmeniteOre", "PlatinumOre", "PeridotOre", "RubyOre",
            "SapphireOre", "ZincOre", "RutileOre"};

    public static HashMap<String, int[]> Colours = new LinkedHashMap<>();

    static {
        Colours.put("Titanium", new int[]{190, 210, 215});
        Colours.put("Zircon", new int[]{150, 140, 130});
        Colours.put("Zirconia", new int[]{190, 195, 198});
        Colours.put("Steel", new int[]{140, 145, 150});
        Colours.put("Bronze", new int[]{160, 105, 61});
        Colours.put("Brass", new int[]{181, 166, 66});
        Colours.put("Diamond", new int[]{200, 200, 250});
        Colours.put("Emerald", new int[]{0, 255, 0});
        Colours.put("Iron", new int[]{180, 180, 180});
        Colours.put("Gold", new int[]{255, 215, 0});
        Colours.put("Coal", new int[]{40, 40, 40});
        Colours.put("Charcoal", new int[]{70, 70, 70});
        Colours.put("Nether", new int[]{120, 40, 0});
        Colours.put("Sulfur", new int[]{255, 240, 0});
        Colours.put("ERROR", new int[]{255, 0, 0});
    }

    public static int[] getColourRGB(String key) {
        if (Ores.containsKey(key)) return new int[]{new Color(Ores.get(key).oreColour).getRed(), new Color(Ores.get(key).oreColour).getGreen(), new Color(Ores.get(key).oreColour).getBlue()};
        final int[] arr = new int[1], arr1 = new int[1], arr2 = new int[2];
        Colours.forEach((nam, v) -> {
            if (nam.equalsIgnoreCase(key)) {
                arr[0] = Colours.get(nam)[0];
                arr1[0] = Colours.get(nam)[1];
                arr2[0] = Colours.get(nam)[2];
            }
        });

        if (arr[0] == 0 && arr1[0] == 0 && arr2[0] == 0)
            return new int[]{255, 0, 0};

        return new int[]{arr[0], arr1[0], arr2[0]};
    }

    public static int getColourINT(String key) {
        int[] arr = getColourRGB(key);
        return new Color(arr[0], arr[1], arr[2]).getRGB();
    }

    public class ore {
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
            oreColour = new Color(itemColour[0], itemColour[1], itemColour[2]).getRGB();
        }
    }

    public void initHashMap() {
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
}
