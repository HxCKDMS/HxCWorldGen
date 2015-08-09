package HxCKDMS.HxCWorldGen;

import HxCKDMS.HxCCore.HxCCore;
import HxCKDMS.HxCCore.api.Configuration.Category;
import HxCKDMS.HxCCore.api.Configuration.HxCConfig;
import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.proxy.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class HxCWorldGen {
    @Mod.Instance
    public HxCWorldGen HxCWorldGen;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    /**Great coding song https://www.youtube.com/watch?v=6dOP5W_k_gw**/
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        HxCConfig hxcconfig = new HxCConfig();
        registerNewConfigSys(hxcconfig);
        proxy.preInit();
        ModRegistry.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRegistry.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    public void registerNewConfigSys(HxCConfig config) {
        config.registerCategory(new Category("General", "General Configs"));
        config.handleConfig(Configurations.class, new File(HxCCore.HxCConfigDir, "HxCWorldGen.cfg"));
        config.handleConfig(Colours.class, new File("HxCWorldGen_Colours.cfg"));
    }
}