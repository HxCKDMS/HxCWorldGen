package HxCKDMS.HxCWorldGen.libs;

public class Reference {
    public static final String MOD_NAME = "HxC World Gen";
    public static final String MOD_ID = "HxCWorldGen";
    public static final String RESOURCE_LOCATION = MOD_ID.toLowerCase() + ":";
    public static final String VERSION = "1.6.0";
    public static final String DEPENDENCIES = "required-after:HxCCore@[1.8.3,)";
    public static final String CLIENT_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ServerProxy";

    public static int ORE_RENDER_ID = 0;
    public static int BLOCK_RENDER_ID = 1;

    public static final String[] OREDICTIONARYORES = new String[]{"oreCopper", "oreTin", "oreSilver", "oreLead", "oreNickel", "oreChromium",
            "oreAluminium", "oreTitanium", "orePlatinum", "oreAventurine", "oreRuby", "oreSapphire", "oreRutile"};

    public static final String[] OREDICTIONARYBLOCKS = new String[]{"blockCopper", "blockTin", "blockSilver", "blockLead", "blockNickel",
            "blockChromium", "blockAluminum", "blockTitanium", "blockPlatinum", "blockPeridot", "blockRuby",
            "blockSapphire", "blockZircon"};

    public static final String[] OREDICTIONARYRESOURCES = new String[]{"ingotCopper", "ingotTin", "ingotSilver", "ingotLead", "ingotNickel",
            "ingotChromium", "ingotAluminum", "ingotTitanium", "ingotPlatinum", "gemPeridot", "gemRuby", "gemSapphire",
            "gemZircon", "ingotZirconia"};

    public static final String[] OREDICTIONARYNUGGETS = new String[]{"nuggetCopper", "nuggetTin", "nuggetSilver", "nuggetLead", "nuggetNickel",
            "nuggetChromium", "nuggetAluminum", "nuggetTitanium", "nuggetPlatinum", "nuggetPeridot", "nuggetRuby",
            "nuggetSapphire", "nuggetZinc", "nuggetBronze", "nuggetBrass", "nuggetSteel", "nuggetZircon", "nuggetZirconia"};

    public static final String[] OREDICTIONARYDUSTS = new String[]{"dustCopper", "dustTin", "dustSilver", "dustLead", "dustNickel",
            "dustChromium", "dustAluminum", "dustTitanium", "dustPlatinum", "dustPeridot", "dustRuby",
            "dustSapphire", "dustZinc", "dustRutile", "dustBronze", "dustBrass", "dustSteel", "dustZirconium"};

    public static final String[] DUSTS = new String[]{"CopperDust", "TinDust", "SilverDust", "LeadDust", "NickelDust",
            "ChromiumDust", "AluminumDust", "IlmeniteDust", "PlatinumDust", "PeridotDust", "RubyDust",
            "SapphireDust", "ZincDust", "RutileDust", "TitaniumDust", "BronzeDust", "BrassDust", "SteelDust", "ZirconiumDust"};
    
    public static final String[] RESOURCES = new String[]{"CopperIngot", "TinIngot", "SilverIngot", "LeadIngot", "NickelIngot",
            "ChromiumIngot", "AluminumIngot", "TitaniumIngot", "PlatinumIngot", "PeridotGem", "RubyGem",
            "SapphireGem", "ZincIngot", "BronzeIngot", "BrassIngot", "SteelIngot", "ZirconGem", "ZirconIngot"};
    
    public static final String[] ORES = new String[]{"CopperOre", "TinOre", "SilverOre", "LeadOre", "NickelOre",
            "ChromiumOre", "AluminumOre", "IlmeniteOre", "PlatinumOre", "PeridotOre", "RubyOre",
            "SapphireOre", "ZincOre", "RutileOre"};

    public static final String[] BLOCKS = new String[]{"CopperBlock", "TinBlock", "SilverBlock", "LeadBlock", "NickelBlock",
            "ChromiumBlock", "AluminumBlock", "TitaniumBlock", "PlatinumBlock", "PeridotBlock", "RubyBlock",
            "SapphireBlock", "BronzeBlock", "BrassBlock", "ZincBlock", "SteelBlock", "ZirconBlock"};
}
