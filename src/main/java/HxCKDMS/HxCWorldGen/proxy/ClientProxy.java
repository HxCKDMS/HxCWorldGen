package HxCKDMS.HxCWorldGen.proxy;

import HxCKDMS.HxCWorldGen.client.blockRenderer;
import HxCKDMS.HxCWorldGen.client.ingotRenderer;
import HxCKDMS.HxCWorldGen.client.oreRenderer;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import HxCKDMS.HxCWorldGen.registry.ModRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy implements IProxy {
    public static int renderPass;

    @Override
    public void preInit() {
        initRendering();
        TextureHandler.preInit();
    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    public void initRendering(){
        Reference.ORE_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(Reference.ORE_RENDER_ID, new oreRenderer());
        Reference.BLOCK_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(Reference.BLOCK_RENDER_ID, new blockRenderer());
        MinecraftForgeClient.registerItemRenderer(ModRegistry.itemResource, new ingotRenderer());
    }
}
