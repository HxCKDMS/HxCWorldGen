package HxCKDMS.HxCWorldGen;

import HxCKDMS.HxCWorldGen.Events.Events;
import HxCKDMS.HxCWorldGen.registry.BlockRegistry;
import HxCKDMS.HxCWorldGen.registry.ItemRegistry;
import HxCKDMS.HxCWorldGen.registry.OreDictionaryRegistry;
import HxCKDMS.HxCWorldGen.registry.Recipes;
import HxCKDMS.HxCWorldGen.util.LogHelper;
import HxCKDMS.HxCWorldGen.util.Reference;
import HxCKDMS.HxCWorldGen.world.OreGenHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.util.logging.Level;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class HxCWorldGen {
    @Mod.Instance
    public HxCWorldGen HxCWorldGen;

    public static Config Config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        BlockRegistry.preInit();
        ItemRegistry.preInit();
        Recipes.PreInit();
        Config = new Config(new Configuration(event.getSuggestedConfigurationFile()));
        GameRegistry.registerWorldGenerator(new OreGenHandler(), 1);

        LogHelper.info(Level.INFO, "Pre Initialization has been completed!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        OreDictionaryRegistry.init();
        MinecraftForge.EVENT_BUS.register(new Events());
        LogHelper.info(Level.INFO, "Initialization has been completed!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info(Level.INFO, "Post Initialization has been completed!");
    }
}