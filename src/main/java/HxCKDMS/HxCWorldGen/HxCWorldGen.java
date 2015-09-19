package HxCKDMS.HxCWorldGen;

import HxCKDMS.HxCCore.HxCCore;
import HxCKDMS.HxCCore.api.Configuration.Category;
import HxCKDMS.HxCCore.api.Configuration.HxCConfig;
import HxCKDMS.HxCWorldGen.ModSupport.TConstructMessages;
import HxCKDMS.HxCWorldGen.ModSupport.TinkersConfigs;
import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.proxy.IProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
        registerConfig(new HxCConfig());
        registerColourConfig(new HxCConfig());
        proxy.preInit();
        ModRegistry.preInit();

        if (Configurations.enableTinkerMaterials && Loader.isModLoaded("TConstruct"))
            registerTinkerConfig(new HxCConfig());
//        if (Configurations.enableIC2Recipes && Loader.isModLoaded("IC2"))
//            registerIC2Config(new HxCConfig());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRegistry.init();

        if (Configurations.enableTinkerMaterials && Loader.isModLoaded("TConstruct"))
            TConstructMessages.registerTinkerMats();
    }

    /*@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (Configurations.enableIC2Recipes && Loader.isModLoaded("IC2"))
            IC2Support.init();
    }*/

    public void registerConfig(HxCConfig config) {
        config.registerCategory(new Category("General", "General Configs"));
        config.handleConfig(Configurations.class, new File(HxCCore.HxCConfigDir, "HxCWorldGen.cfg"));
    }
    public void registerColourConfig(HxCConfig config) {
        config.registerCategory(new Category("General", "Colour Configs, These determine the colours of ingots/ores/nuggets/gems"));
        config.handleConfig(Colours.class, new File(HxCCore.HxCConfigDir, "HxCWorldGen_Colours.cfg"));
    }
    public void registerTinkerConfig(HxCConfig config) {
        config.registerCategory(new Category("General", "DO NOT CHANGE (Name, ItemID). Color leave alone unless you want custom colours. \n# If colour is 0x00000000 then it uses same colour as ingots."));
        config.handleConfig(TinkersConfigs.class, new File(HxCCore.HxCConfigDir, "HxCWorldGen_Tinkers'Materials.cfg"));
    }
}
