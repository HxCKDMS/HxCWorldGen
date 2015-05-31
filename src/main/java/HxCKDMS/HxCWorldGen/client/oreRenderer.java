package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.Reference;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class oreRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z));
        return true;
    }

    public static void render(Block block, int x, int y, int z, int meta){
        Tessellator tessellator = Tessellator.instance;
        double min = 0.001, max = 0.999;
        tessellator.addTranslation(x, y, z);

        //TOP
        IIcon under = block.getIcon(0, 13);

        tessellator.addVertexWithUV(min, max, max, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(max, max, max, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(max, max, min, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(min, max, min, under.getMaxU(), under.getMinV());

        tessellator.addVertexWithUV(max, min, max, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(min, min, max, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(min, min, min, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(max, min, min, under.getMaxU(), under.getMinV());

        tessellator.addVertexWithUV(min, min, max, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(min, max, max, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(min, max, min, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(min, min, min, under.getMaxU(), under.getMinV());

        tessellator.addVertexWithUV(max, min, min, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(max, max, min, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(max, max, max, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(max, min, max, under.getMaxU(), under.getMinV());
        
        tessellator.addVertexWithUV(min, min, min, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(min, max, min, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(max, max, min, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(max, min, min, under.getMaxU(), under.getMinV());

        tessellator.addVertexWithUV(min, min, max, under.getMinU(), under.getMinV());
        tessellator.addVertexWithUV(max, min, max, under.getMinU(), under.getMaxV());
        tessellator.addVertexWithUV(max, max, max, under.getMaxU(), under.getMaxV());
        tessellator.addVertexWithUV(min, max, max, under.getMaxU(), under.getMinV());

        IIcon over = block.getIcon(1, meta);

        tessellator.addVertexWithUV(0, 1, 1, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(1, 1, 1, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 1, 0, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(0, 1, 0, over.getMaxU(), over.getMinV());

        tessellator.addVertexWithUV(1, 0, 1, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(0, 0, 1, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(0, 0, 0, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 0, 0, over.getMaxU(), over.getMinV());

        tessellator.addVertexWithUV(0, 0, 1, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(0, 1, 1, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(0, 1, 0, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(0, 0, 0, over.getMaxU(), over.getMinV());

        tessellator.addVertexWithUV(1, 0, 0, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(1, 1, 0, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 1, 1, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 0, 1, over.getMaxU(), over.getMinV());

        tessellator.addVertexWithUV(0, 0, 0, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(0, 1, 0, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 1, 0, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 0, 0, over.getMaxU(), over.getMinV());

        tessellator.addVertexWithUV(0, 0, 1, over.getMinU(), over.getMinV());
        tessellator.addVertexWithUV(1, 0, 1, over.getMinU(), over.getMaxV());
        tessellator.addVertexWithUV(1, 1, 1, over.getMaxU(), over.getMaxV());
        tessellator.addVertexWithUV(0, 1, 1, over.getMaxU(), over.getMinV());

        tessellator.addTranslation(-x, -y, -z);
    }



    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return Reference.ORE_RENDER_ID;
    }
}