package HxCKDMS.HxCWorldGen;

import HxCKDMS.HxCCore.Utils.LogHelper;
import HxCKDMS.HxCWorldGen.registry.ModRegistry;
import HxCKDMS.HxCWorldGen.util.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.util.logging.Level;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)

public class HxCWorldGen {
    @Mod.Instance
    public HxCWorldGen HxCWorldGen;

    public static Config Config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config = new Config(new Configuration(event.getSuggestedConfigurationFile()));
        ModRegistry.preInit();

        LogHelper.info(Level.INFO, "Pre Initialization has been completed!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRegistry.init();

        LogHelper.info(Level.INFO, "Initialization has been completed!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info(Level.INFO, "Post Initialization has been completed!");
    }
}