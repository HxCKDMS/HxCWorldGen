package kay.MoreWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import kay.MoreWorldGen.registry.BlockRegistry;
import kay.MoreWorldGen.registry.ItemRegistry;
import kay.MoreWorldGen.registry.OreDictionaryRegistry;
import kay.MoreWorldGen.registry.Recipes;
import kay.MoreWorldGen.util.LogHelper;
import kay.MoreWorldGen.util.Reference;
import kay.MoreWorldGen.world.OreGenHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class MoreWorldGen {
    @Mod.Instance
    public static MoreWorldGen moreWorldGen;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        BlockRegistry.preInit();
        ItemRegistry.preInit();
        Recipes.PreInit();
        GameRegistry.registerWorldGenerator(new OreGenHandler(), 1);

        LogHelper.info("Pre Initialization has been completed!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        OreDictionaryRegistry.init();
        LogHelper.info("Initialization has been completed!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Post Initialization has been completed!");
    }
}
