package HxCKDMS.HxCWorldGen.proxy;

import HxCKDMS.HxCWorldGen.Reference;
import HxCKDMS.HxCWorldGen.client.oreRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy {
    @Override
    public void preInit() {
        initRendering();
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
    }
}
