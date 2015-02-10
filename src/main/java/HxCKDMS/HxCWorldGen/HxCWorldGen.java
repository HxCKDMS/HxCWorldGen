package HxCKDMS.HxCWorldGen;

import HxCKDMS.HxCWorldGen.Events.Events;
import HxCKDMS.HxCWorldGen.Proxy.CommonProxy;
import HxCKDMS.HxCWorldGen.registry.BlockRegistry;
import HxCKDMS.HxCWorldGen.registry.ItemRegistry;
import HxCKDMS.HxCWorldGen.registry.OreDictionaryRegistry;
import HxCKDMS.HxCWorldGen.registry.Recipes;
import HxCKDMS.HxCWorldGen.util.LogHelper;
import HxCKDMS.HxCWorldGen.util.Reference;
import HxCKDMS.HxCWorldGen.world.OreGenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.logging.Level;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class HxCWorldGen {
    @Mod.Instance
    public HxCWorldGen HxCWorldGen;

    @SidedProxy(serverSide = Reference.SERVER_PROXY_LOCATION, clientSide = Reference.CLIENT_PROXY_LOCATION)
    public static CommonProxy proxy;

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
        proxy.init();
        OreDictionaryRegistry.init();
        MinecraftForge.EVENT_BUS.register(new Events());
        LogHelper.info(Level.INFO, "Initialization has been completed!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info(Level.INFO, "Post Initialization has been completed!");
    }
}