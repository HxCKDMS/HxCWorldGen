package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Configuration.Config;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TinkersConfigs {
    @Config.Map
    public static LinkedHashMap<String, String> TinData = new LinkedHashMap<>(), SilverData = new LinkedHashMap<>(),
            LeadData = new LinkedHashMap<>(), NickelData = new LinkedHashMap<>(), ChromiumData = new LinkedHashMap<>(),
            AluminiumData = new LinkedHashMap<>(), TitaniumData = new LinkedHashMap<>(), PlatinumData = new LinkedHashMap<>(),
            AventurineData = new LinkedHashMap<>(), RubyData = new LinkedHashMap<>(), SapphireData = new LinkedHashMap<>(),
            ZirconiaData = new LinkedHashMap<>();

    public static List<LinkedHashMap<String, String>> mats = Arrays.asList(TinData, SilverData, LeadData, NickelData, ChromiumData,
            AluminiumData, TitaniumData, PlatinumData, AventurineData, RubyData, SapphireData);

    static {
        TinData.put("Enabled", "true"); //boolean
        TinData.put("Id", "0"); //int
        TinData.put("Name", "Tin"); // string
        TinData.put("HarvestLevel", "1"); //int
        TinData.put("Durability", "250"); //int
        TinData.put("MiningSpeed", "100"); //int
        TinData.put("Attack", "2"); //int
        TinData.put("HandleModifier", "0.9"); //float
        TinData.put("Reinforced", "0"); //int
        TinData.put("Stonebound", "0"); //floar
        TinData.put("Style", "gray"); //string
        TinData.put("Color", "0x00000000"); //int colour
        TinData.put("Bow_DrawSpeed", "200"); //int
        TinData.put("Bow_ProjectileSpeed", "2.0"); //float
        TinData.put("Projectile_Mass", "1.0");//float
        TinData.put("Projectile_Fragility", "0.8"); //float
        TinData.put("Temperature", "500"); //int

        SilverData.put("Enabled", "true");
        SilverData.put("Id", "1");
        SilverData.put("Name", "Silver");
        SilverData.put("HarvestLevel", "2");
        SilverData.put("Durability", "450");
        SilverData.put("MiningSpeed", "250");
        SilverData.put("Attack", "1");
        SilverData.put("HandleModifier", "0.2");
        SilverData.put("Reinforced", "0");
        SilverData.put("Stonebound", "0");
        SilverData.put("Style", "gray");
        SilverData.put("Color", "0x00000000");
        SilverData.put("Bow_DrawSpeed", "250");
        SilverData.put("Bow_ProjectileSpeed", "2.0");
        SilverData.put("Projectile_Mass", "1.0");
        SilverData.put("Projectile_Fragility", "1.0");
        SilverData.put("Temperature", "400");

        LeadData.put("Enabled", "true");
        LeadData.put("Id", "2");
        LeadData.put("Name", "Lead");
        LeadData.put("HarvestLevel", "1");
        LeadData.put("Durability", "300");
        LeadData.put("MiningSpeed", "200");
        LeadData.put("Attack", "1");
        LeadData.put("HandleModifier", "0.5");
        LeadData.put("Reinforced", "0");
        LeadData.put("Stonebound", "0");
        LeadData.put("Style", "gray");
        LeadData.put("Color", "0x00000000");
        LeadData.put("Bow_DrawSpeed", "200");
        LeadData.put("Bow_ProjectileSpeed", "1.0");
        LeadData.put("Projectile_Mass", "2.4");
        LeadData.put("Projectile_Fragility", "1.0");
        LeadData.put("Temperature", "200");

        NickelData.put("Enabled", "true");
        NickelData.put("Id", "3");
        NickelData.put("Name", "Nickel");
        NickelData.put("HarvestLevel", "3");
        NickelData.put("Durability", "750");
        NickelData.put("MiningSpeed", "250");
        NickelData.put("Attack", "3");
        NickelData.put("HandleModifier", "1.5");
        NickelData.put("Reinforced", "1");
        NickelData.put("Stonebound", "0");
        NickelData.put("Style", "gray");
        NickelData.put("Color", "0x00000000");
        NickelData.put("Bow_DrawSpeed", "100");
        NickelData.put("Bow_ProjectileSpeed", "1.0");
        NickelData.put("Projectile_Mass", "1.4");
        NickelData.put("Projectile_Fragility", "0.7");
        NickelData.put("Temperature", "550");

        ChromiumData.put("Enabled", "true");
        ChromiumData.put("Id", "4");
        ChromiumData.put("Name", "Chromium");
        ChromiumData.put("HarvestLevel", "3");
        ChromiumData.put("Durability", "2000");
        ChromiumData.put("MiningSpeed", "300");
        ChromiumData.put("Attack", "3");
        ChromiumData.put("HandleModifier", "2.5");
        ChromiumData.put("Reinforced", "2");
        ChromiumData.put("Stonebound", "0");
        ChromiumData.put("Style", "gray");
        ChromiumData.put("Color", "0x00000000");
        ChromiumData.put("Bow_DrawSpeed", "100");
        ChromiumData.put("Bow_ProjectileSpeed", "1.0");
        ChromiumData.put("Projectile_Mass", "1.3");
        ChromiumData.put("Projectile_Fragility", "0.2");
        ChromiumData.put("Temperature", "900");

        AluminiumData.put("Enabled", "true");
        AluminiumData.put("Id", "5");
        AluminiumData.put("Name", "Aluminium");
        AluminiumData.put("HarvestLevel", "2");
        AluminiumData.put("Durability", "550");
        AluminiumData.put("MiningSpeed", "225");
        AluminiumData.put("Attack", "1");
        AluminiumData.put("HandleModifier", "1.1");
        AluminiumData.put("Reinforced", "0");
        AluminiumData.put("Stonebound", "0");
        AluminiumData.put("Style", "gray");
        AluminiumData.put("Color", "0x00000000");
        AluminiumData.put("Bow_DrawSpeed", "300");
        AluminiumData.put("Bow_ProjectileSpeed", "1.0");
        AluminiumData.put("Projectile_Mass", "0.4");
        AluminiumData.put("Projectile_Fragility", "0.6");
        AluminiumData.put("Temperature", "100");

        TitaniumData.put("Enabled", "true");
        TitaniumData.put("Id", "6");
        TitaniumData.put("Name", "Titanium");
        TitaniumData.put("HarvestLevel", "5");
        TitaniumData.put("Durability", "2500");
        TitaniumData.put("MiningSpeed", "250");
        TitaniumData.put("Attack", "3");
        TitaniumData.put("HandleModifier", "2.5");
        TitaniumData.put("Reinforced", "3");
        TitaniumData.put("Stonebound", "0");
        TitaniumData.put("Style", "gray");
        TitaniumData.put("Color", "0x00000000");
        TitaniumData.put("Bow_DrawSpeed", "100");
        TitaniumData.put("Bow_ProjectileSpeed", "1.0");
        TitaniumData.put("Projectile_Mass", "1.3");
        TitaniumData.put("Projectile_Fragility", "0.1");
        TitaniumData.put("Temperature", "650");

        PlatinumData.put("Enabled", "true");
        PlatinumData.put("Id", "7");
        PlatinumData.put("Name", "Platinum");
        PlatinumData.put("HarvestLevel", "3");
        PlatinumData.put("Durability", "800");
        PlatinumData.put("MiningSpeed", "400");
        PlatinumData.put("Attack", "3");
        PlatinumData.put("HandleModifier", "1.5");
        PlatinumData.put("Reinforced", "1");
        PlatinumData.put("Stonebound", "0");
        PlatinumData.put("Style", "dark_aqua");
        PlatinumData.put("Color", "0x00000000");
        PlatinumData.put("Bow_DrawSpeed", "250");
        PlatinumData.put("Bow_ProjectileSpeed", "1.0");
        PlatinumData.put("Projectile_Mass", "1.6");
        PlatinumData.put("Projectile_Fragility", "0.7");
        PlatinumData.put("Temperature", "750");

        AventurineData.put("Enabled", "true");
        AventurineData.put("Id", "8");
        AventurineData.put("Name", "Aventurine");
        AventurineData.put("HarvestLevel", "3");
        AventurineData.put("Durability", "3000");
        AventurineData.put("MiningSpeed", "400");
        AventurineData.put("Attack", "3");
        AventurineData.put("HandleModifier", "2.0");
        AventurineData.put("Reinforced", "2");
        AventurineData.put("Stonebound", "0");
        AventurineData.put("Style", "green");
        AventurineData.put("Color", "0x00000000");
        AventurineData.put("Bow_DrawSpeed", "100");
        AventurineData.put("Bow_ProjectileSpeed", "1.0");
        AventurineData.put("Projectile_Mass", "1.1");
        AventurineData.put("Projectile_Fragility", "0.9");
        AventurineData.put("Temperature", "1200");

        RubyData.put("Enabled", "true");
        RubyData.put("Id", "9");
        RubyData.put("Name", "Ruby");
        RubyData.put("HarvestLevel", "3");
        RubyData.put("Durability", "2000");
        RubyData.put("MiningSpeed", "400");
        RubyData.put("Attack", "3");
        RubyData.put("HandleModifier", "2.0");
        RubyData.put("Reinforced", "2");
        RubyData.put("Stonebound", "0");
        RubyData.put("Style", "green");
        RubyData.put("Color", "0x00000000");
        RubyData.put("Bow_DrawSpeed", "100");
        RubyData.put("Bow_ProjectileSpeed", "1.0");
        RubyData.put("Projectile_Mass", "1.1");
        RubyData.put("Projectile_Fragility", "0.9");
        RubyData.put("Temperature", "1200");

        SapphireData.put("Enabled", "true");
        SapphireData.put("Id", "10");
        SapphireData.put("Name", "Sapphire");
        SapphireData.put("HarvestLevel", "3");
        SapphireData.put("Durability", "2000");
        SapphireData.put("MiningSpeed", "400");
        SapphireData.put("Attack", "3");
        SapphireData.put("HandleModifier", "2.0");
        SapphireData.put("Reinforced", "2");
        SapphireData.put("Stonebound", "0");
        SapphireData.put("Style", "green");
        SapphireData.put("Color", "0x00000000");
        SapphireData.put("Bow_DrawSpeed", "100");
        SapphireData.put("Bow_ProjectileSpeed", "1.0");
        SapphireData.put("Projectile_Mass", "1.1");
        SapphireData.put("Projectile_Fragility", "0.9");
        SapphireData.put("Temperature", "1200");

        ZirconiaData.put("Enabled", "false");
        ZirconiaData.put("Id", "11");
        ZirconiaData.put("Name", "Zirconia");
        ZirconiaData.put("HarvestLevel", "6");
        ZirconiaData.put("Durability", "3500");
        ZirconiaData.put("MiningSpeed", "400");
        ZirconiaData.put("Attack", "4");
        ZirconiaData.put("HandleModifier", "3.0");
        ZirconiaData.put("Reinforced", "5");
        ZirconiaData.put("Stonebound", "0");
        ZirconiaData.put("Style", "green");
        ZirconiaData.put("Color", "0x00000000");
        ZirconiaData.put("Bow_DrawSpeed", "100");
        ZirconiaData.put("Bow_ProjectileSpeed", "1.0");
        ZirconiaData.put("Projectile_Mass", "1.1");
        ZirconiaData.put("Projectile_Fragility", "0.9");
    }
}
