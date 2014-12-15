package HxCKDMS.HxCWorldGen;

import net.minecraftforge.common.config.Configuration;

public class Config
{
    public boolean DebugMode;

    public static int OreNodeMultiplier;

    public static int CopperNodeSize;
    public static int TinNodeSize;
    public static int SilverNodeSize;
    public static int LeadNodeSize;
    public static int NickelNodeSize;
    public static int ChromiumNodeSize;
    public static int AluminiumNodeSize;
    public static int TitaniumNodeSize;
    public static int PlatinumNodeSize;
    public static int AventurineNodeSize;
    public static int RubyNodeSize;
    public static int SapphireNodeSize;

    public Config(Configuration config)
    {
        config.load();

        DebugMode = config.get("DEBUG", "Debug Mode Enable?", false).getBoolean(false);

        OreNodeMultiplier = config.get("Ore Node Size Multiplier", "Node size multiplier.(this is multiplied by the below values set to 0 to disable ore gen))", 1, "Don't Exceed 16").getInt();

        CopperNodeSize = config.get("Ore Node Sizes", "Copper node Size", 6, "Don't Exceed 16").getInt();
        TinNodeSize = config.get("Ore Node Sizes", "Tin node Size", 7, "Don't Exceed 16").getInt();
        SilverNodeSize = config.get("Ore Node Sizes", "Silver node Size", 4, "Don't Exceed 16").getInt();
        LeadNodeSize = config.get("Ore Node Sizes", "Lead node Size", 4, "Don't Exceed 16").getInt();
        NickelNodeSize = config.get("Ore Node Sizes", "Nickel node Size", 3, "Don't Exceed 16").getInt();
        ChromiumNodeSize = config.get("Ore Node Sizes", "Chromium node Size", 3, "Don't Exceed 16").getInt();
        AluminiumNodeSize = config.get("Ore Node Sizes", "Aluminium node Size", 4, "Don't Exceed 16").getInt();
        TitaniumNodeSize = config.get("Ore Node Sizes", "Titanium node Size", 3, "Don't Exceed 16").getInt();
        PlatinumNodeSize = config.get("Ore Node Sizes", "Platinum node Size", 1, "Don't Exceed 16").getInt();
        AventurineNodeSize = config.get("Ore Node Sizes", "Aventurine(Peridot) node Size", 4, "Don't Exceed 16").getInt();
        RubyNodeSize = config.get("Ore Node Sizes", "Ruby node Size", 4, "Don't Exceed 16").getInt();
        SapphireNodeSize = config.get("Ore Node Sizes", "Sapphire node Size", 4, "Don't Exceed 16").getInt();

        if(config.hasChanged())
        {
            config.save();
        }
    }
}
