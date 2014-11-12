package HxCKDMS.MoreWorldGen;

import HxCKDMS.MoreWorldGen.Events.Events;
import HxCKDMS.MoreWorldGen.registry.BlockRegistry;
import HxCKDMS.MoreWorldGen.registry.ItemRegistry;
import HxCKDMS.MoreWorldGen.registry.OreDictionaryRegistry;
import HxCKDMS.MoreWorldGen.registry.Recipes;
import HxCKDMS.MoreWorldGen.util.LogHelper;
import HxCKDMS.MoreWorldGen.util.Reference;
import HxCKDMS.MoreWorldGen.world.OreGenHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

import java.util.logging.Level;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class MoreWorldGen {
    @Mod.Instance
    public MoreWorldGen MoreWorldGen;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        BlockRegistry.preInit();
        ItemRegistry.preInit();
        Recipes.PreInit();
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