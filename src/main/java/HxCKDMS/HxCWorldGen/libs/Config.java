package HxCKDMS.HxCWorldGen.libs;

import net.minecraftforge.common.config.Configuration;

public class Config
{
    private String[] dummy;
    public static String[] NodeSizes;
    public static boolean forceNormal;

    public static int OreNodeMultiplier, ResourceSize;

    public static String Copper, Tin, Silver, Lead, Nickel, Chromium, Aluminium, Titanium, Platinum, Aventurine, Ruby, Sapphire, Rutile;

    public Config(Configuration config){
        config.load();
        config.setCategoryComment("OreGenSizes", "These are the sizes of the Ore nodes that generate. Set to 0 to disable this ore from generating");
        forceNormal = config.getBoolean("DisableForcedGrey", "Features", false, "enable this to remove my forcing of grey stone");
        ResourceSize = config.getInt("Resolution", "Features", 32, 0, 64, "0, 16, 32, 64 only supported values select 0 if you want my special handling (IE get from default resources from resource pack)");

        OreNodeMultiplier = config.getInt("NodeMultiplier", "OreGenSizes", 1, 0, 16, "Node size multiplier.(this is multiplied by the below values set to 0 to disable ore gen))");
        dummy = config.getStringList("Dummy", "OreGenSizes", new String[]{"Copper", "Tin", "Silver", "Lead", "Nickel", "Chromium", "Aluminium", "Titanium", "Platinum", "Aventurine", "Ruby", "Sapphire", "Rutile"}, "This is the list of ores in the order of which you're changing the below values DON'T MODIFY THIS");
        NodeSizes = config.getStringList("Copper node Size", "OreGenSizes", new String[]{"6", "7", "4", "4", "3", "3", "4", "3", "1", "4", "4", "4", "2"}, "min 0, max 16");

        config.setCategoryComment("OreGenOres","These are the ores to use in generating the ore nodes. DO NOT LEAVE BLANK!!! and don't forget the meta data if none use 0");

        Copper = config.getString("Copper", "OreGenOres", "<HxCWorldGen:blockOre:0>", "");
        Tin = config.getString("Tin", "OreGenOres", "<HxCWorldGen:blockOre:1>", "");
        Silver = config.getString("Silver", "OreGenOres", "<HxCWorldGen:blockOre:2>", "");
        Lead = config.getString("Lead", "OreGenOres", "<HxCWorldGen:blockOre:3>", "");
        Nickel = config.getString("Nickel", "OreGenOres", "<HxCWorldGen:blockOre:4>", "");
        Chromium = config.getString("Chromium", "OreGenOres", "<HxCWorldGen:blockOre:5>", "");
        Aluminium = config.getString("Aluminium", "OreGenOres", "<HxCWorldGen:blockOre:6>", "");
        Titanium = config.getString("Titanium", "OreGenOres", "<HxCWorldGen:blockOre:7>", "");
        Platinum = config.getString("Platinum", "OreGenOres", "<HxCWorldGen:blockOre:8>", "");
        Aventurine = config.getString("Aventurine", "OreGenOres", "<HxCWorldGen:blockOre:9>", "");
        Ruby = config.getString("Ruby", "OreGenOres", "<HxCWorldGen:blockOre:10>", "");
        Sapphire = config.getString("Sapphire", "OreGenOres", "<HxCWorldGen:blockOre:11>", "");
        Rutile = config.getString("Rutile", "OreGenOres", "<HxCWorldGen:blockOre:12>", "");

        if(config.hasChanged()) config.save();
    }
}
