package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.Config;
import HxCKDMS.HxCWorldGen.Reference;
import HxCKDMS.HxCWorldGen.proxy.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class oreRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

        // Create the Tessellator and prepare OpenGL.
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        GL11.glEnable(GL11.GL_BLEND);

        // Start drawing inner layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 0));
        tessellator.draw();

        // Start drawing outer layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colours(metadata)[0], colours(metadata)[1], colours(metadata)[2]);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        // Finish drawing.
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z), renderer);
        return true;
    }

    public static void render(Block block, int x, int y, int z, int meta, RenderBlocks renderer){
        Tessellator tessellator = Tessellator.instance;
        double min = 0.005, max = 0.995;
        tessellator.addTranslation(x, y, z);

        if (ClientProxy.renderPass == 0) {
            IIcon icon = block.getIcon(0, 0);

            if (!Config.forceNormal) {tessellator.setColorOpaque(220, 220, 220);}

            tessellator.addVertexWithUV(min, max, max, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(max, max, max, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, max, min, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(min, max, min, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(max, min, max, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(min, min, max, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(min, min, min, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, min, min, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(min, min, max, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(min, max, max, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(min, max, min, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(min, min, min, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(max, min, min, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(max, max, min, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, max, max, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, min, max, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(min, min, min, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(min, max, min, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, max, min, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, min, min, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(min, min, max, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(max, min, max, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(max, max, max, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(min, max, max, icon.getMaxU(), icon.getMinV());
        } else {
            IIcon icon = block.getIcon(6, 0);
            tessellator.setColorOpaque(colours(meta)[0], colours(meta)[1], colours(meta)[2]);

            tessellator.addVertexWithUV(0, 1, 1, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(1, 1, 1, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 1, 0, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(0, 1, 0, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(1, 0, 1, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(0, 0, 1, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(0, 0, 0, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 0, 0, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(0, 0, 1, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(0, 1, 1, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(0, 1, 0, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(0, 0, 0, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(1, 0, 0, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(1, 1, 0, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 1, 1, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 0, 1, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(0, 0, 0, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(0, 1, 0, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 1, 0, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 0, 0, icon.getMaxU(), icon.getMinV());

            tessellator.addVertexWithUV(0, 0, 1, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV(1, 0, 1, icon.getMinU(), icon.getMaxV());
            tessellator.addVertexWithUV(1, 1, 1, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV(0, 1, 1, icon.getMaxU(), icon.getMinV());
        }
        tessellator.addTranslation(-x, -y, -z);
    }



    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return Reference.ORE_RENDER_ID;
    }

    public static int[] colours(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = new int[]{250, 250, 250}; break;
            case 2 : colours = new int[]{200, 240, 255}; break;
            case 3 : colours = new int[]{80, 40, 100}; break;
            case 4 : colours = new int[]{200, 200, 152}; break;
            case 5 : colours = new int[]{240, 255, 255}; break;
            case 6 : colours = new int[]{210, 250, 255}; break;
            case 7 : colours = new int[]{133, 95, 90}; break;
            case 8 : colours = new int[]{160, 250, 255}; break;
            case 9 : colours = new int[]{0, 160, 120}; break;
            case 10 : colours = new int[]{180, 50, 70}; break;
            case 11 : colours = new int[]{30, 120, 200}; break;
            case 12 : colours = new int[]{100, 56, 18}; break;
            default : colours = new int[]{174, 105, 41}; break;
        }
        return colours;
    }
}