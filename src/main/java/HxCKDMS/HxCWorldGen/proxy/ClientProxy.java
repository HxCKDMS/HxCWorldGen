package HxCKDMS.HxCWorldGen.proxy;

import HxCKDMS.HxCWorldGen.client.BlockRenderer;
import HxCKDMS.HxCWorldGen.client.oreRenderer;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy {
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
        RenderingRegistry.registerBlockHandler(Reference.BLOCK_RENDER_ID, new BlockRenderer());
    }
}
