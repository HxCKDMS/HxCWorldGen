package HxCKDMS.HxCWorldGen;

import net.minecraftforge.common.config.Configuration;

public class Config
{
    public static int OreNodeMultiplier;

    public static int CopperNodeSize, TinNodeSize, SilverNodeSize, LeadNodeSize, NickelNodeSize, ChromiumNodeSize, AluminiumNodeSize, TitaniumNodeSize, PlatinumNodeSize, AventurineNodeSize, RubyNodeSize, SapphireNodeSize, RutileNodeSize;

    public static String Copper, Tin, Silver, Lead, Nickel, Chromium, Aluminium, Titanium, Platinum, Aventurine, Ruby, Sapphire, Rutile;

    public Config(Configuration config){
        config.load();
        config.setCategoryComment("OreGenSizes", "These are the sizes of the Ore nodes that generate. Set to 0 to disable this ore from generating");

        OreNodeMultiplier = config.getInt("NodeMultiplier", "OreGenSizes", 1, 0, 16, "Node size multiplier.(this is multiplied by the below values set to 0 to disable ore gen))");
        CopperNodeSize = config.getInt("Copper node Size", "OreGenSizes", 6, 0, 16, "");
        TinNodeSize = config.getInt("Tin node Size", "OreGenSizes", 7, 0, 16, "");
        SilverNodeSize = config.getInt("Silver node Size", "OreGenSizes", 4, 0, 16, "");
        LeadNodeSize = config.getInt("Lead node Size", "OreGenSizes", 4, 0, 16, "");
        NickelNodeSize = config.getInt("Nickel node Size", "OreGenSizes", 3, 0, 16, "");
        ChromiumNodeSize = config.getInt("Chromium node Size", "OreGenSizes", 3, 0, 16, "");
        AluminiumNodeSize = config.getInt("Aluminium node Size", "OreGenSizes", 4, 0, 16, "");
        TitaniumNodeSize = config.getInt("Ilmenite(Titanium) node Size", "OreGenSizes", 3, 0, 16, "");
        PlatinumNodeSize = config.getInt("Platinum node Size", "OreGenSizes", 1, 0, 16, "");
        AventurineNodeSize = config.getInt("Aventurine(Peridot) node Size", "OreGenSizes", 4, 0, 16, "");
        RubyNodeSize = config.getInt("Ruby node Size", "OreGenSizes", 4, 0, 16, "");
        SapphireNodeSize = config.getInt("Sapphire node Size", "OreGenSizes", 4, 0, 16, "");
        RutileNodeSize = config.getInt("Rutile node Size", "OreGenSizes", 2, 0, 16, "");

        config.setCategoryComment("OreGenOres","These are the ores to use in generating the ore nodes. DO NOT LEAVE BLANK!!!");

        Copper = config.getString("Copper", "OreGenOres", "<HxCWorldGen:blockOre:0>", "Default <HxCWorldGen:blockOre:0> Don't change this comment.");
        Tin = config.getString("Tin", "OreGenOres", "<HxCWorldGen:blockOre:1>", "Default <HxCWorldGen:blockOre:1> Don't change this comment.");
        Silver = config.getString("Silver", "OreGenOres", "<HxCWorldGen:blockOre:2>", "Default <HxCWorldGen:blockOre:2> Don't change this comment.");
        Lead = config.getString("Lead", "OreGenOres", "<HxCWorldGen:blockOre:3>", "Default <HxCWorldGen:blockOre:3> Don't change this comment.");
        Nickel = config.getString("Nickel", "OreGenOres", "<HxCWorldGen:blockOre:4>", "Default <HxCWorldGen:blockOre:4> Don't change this comment.");
        Chromium = config.getString("Chromium", "OreGenOres", "<HxCWorldGen:blockOre:5>", "Default <HxCWorldGen:blockOre:5> Don't change this comment.");
        Aluminium = config.getString("Aluminium", "OreGenOres", "<HxCWorldGen:blockOre:6>", "Default <HxCWorldGen:blockOre:6> Don't change this comment.");
        Titanium = config.getString("Titanium", "OreGenOres", "<HxCWorldGen:blockOre:7>", "Default <HxCWorldGen:blockOre:7> Don't change this comment.");
        Platinum = config.getString("Platinum", "OreGenOres", "<HxCWorldGen:blockOre:8>", "Default <HxCWorldGen:blockOre:8> Don't change this comment.");
        Aventurine = config.getString("Aventurine", "OreGenOres", "<HxCWorldGen:blockOre:9>", "Default <HxCWorldGen:blockOre:9> Don't change this comment.");
        Ruby = config.getString("Ruby", "OreGenOres", "<HxCWorldGen:blockOre:10>", "Default <HxCWorldGen:blockOre:10> Don't change this comment.");
        Sapphire = config.getString("Sapphire", "OreGenOres", "<HxCWorldGen:blockOre:11>", "Default <HxCWorldGen:blockOre:11> Don't change this comment.");
        Rutile = config.getString("Rutile", "OreGenOres", "<HxCWorldGen:blockOre:12>", "Default <HxCWorldGen:blockOre:12> Don't change this comment.");

        if(config.hasChanged()) config.save();
    }
}
