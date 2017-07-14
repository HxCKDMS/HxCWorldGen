package HxCKDMS.HxCWorldGen;

//import HxCKDMS.HxCWorldGen.ModSupport.IC2Support;
//import HxCKDMS.HxCWorldGen.ModSupport.TConstructMessages;
import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.proxy.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import hxckdms.hxcconfig.HxCConfig;
import hxckdms.hxccore.libraries.GlobalVariables;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class HxCWorldGen {
    @Mod.Instance
    public HxCWorldGen HxCWorldGen;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    /**Great coding song https://www.youtube.com/watch?v=6dOP5W_k_gw**/
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        HxCConfig config = new HxCConfig(Configurations.class, Reference.MOD_ID, GlobalVariables.modConfigDir, "cfg", Reference.MOD_ID);
        config.initConfiguration();
         Configurations c = new Configurations();
        c.init();
        config.initConfiguration();

        proxy.preInit();
        ModRegistry.preInit();

//        if (Configurations.enableTinkerMaterials && Loader.isModLoaded("TConstruct"))
//            registerTinkerConfig(new HxCConfig());
//        if (Configurations.enableIC2Recipes && Loader.isModLoaded("IC2"))
//            registerIC2Config(new HxCConfig());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRegistry.init();

//        if (Configurations.enableTinkerMaterials && Loader.isModLoaded("TConstruct"))
//            TConstructMessages.registerTinkerMats();
//        if (Configurations.enableIC2Recipes && Loader.isModLoaded("IC2"))
//            IC2Support.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
