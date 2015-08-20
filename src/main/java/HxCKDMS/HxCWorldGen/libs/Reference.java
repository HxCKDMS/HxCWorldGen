package HxCKDMS.HxCWorldGen.libs;

public class Reference {
    public static final String MOD_NAME = "HxC World Gen";
    public static final String MOD_ID = "HxCWorldGen";
    public static final String RESOURCE_LOCATION = MOD_ID.toLowerCase() + ":";
    public static final String VERSION = "1.5.2";
    public static final String DEPENDENCIES = "required-after:HxCCore@[1.8.1,)";
    public static final String CLIENT_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "HxCKDMS.HxCWorldGen.proxy.ServerProxy";

    public static int ORE_RENDER_ID = 0;
    public static int BLOCK_RENDER_ID = 1;

    public static final String[] ORES = new String[]{"oreCopper", "oreTin", "oreSilver", "oreLead", "oreNickel", "oreChromium",
            "oreAluminium", "oreTitanium", "orePlatinum", "oreAventurine", "oreRuby", "oreSapphire", "oreRutile"};

    public static final String[] BLOCKS = new String[]{"blockCopper", "blockTin", "blockSilver", "blockLead", "blockNickel",
            "blockChromium", "blockAluminum", "blockTitanium", "blockPlatinum", "blockPeridot", "blockRuby",
            "blockSapphire", "blockZircon"};

    public static final String[] RESOURCES = new String[]{"ingotCopper", "ingotTin", "ingotSilver", "ingotLead", "ingotNickel",
            "ingotChromium", "ingotAluminum", "ingotTitanium", "ingotPlatinum", "gemPeridot", "gemRuby", "gemSapphire",
            "gemZircon", "ingotZirconia"};

    public static final String[] PIECES = new String[]{"nuggetCopper", "nuggetTin", "nuggetSilver", "nuggetLead", "nuggetNickel",
            "nuggetChromium", "nuggetAluminum", "nuggetTitanium", "nuggetPlatinum", "nuggetPeridot", "nuggetRuby",
            "nuggetSapphire", "nuggetZircon", "nuggetZirconia"};
}
