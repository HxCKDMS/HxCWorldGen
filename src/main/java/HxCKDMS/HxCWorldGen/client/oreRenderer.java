package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Reference;
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
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.oreColour(metadata)[0], Colours.oreColour(metadata)[1], Colours.oreColour(metadata)[2]);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 0));
        tessellator.draw();

        // Finish drawing.
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z), renderer, world);
        return true;
    }

    public static void render(Block block, int x, int y, int z, int meta, RenderBlocks renderer, IBlockAccess world){
        Tessellator tessellator = Tessellator.instance;
        double min = 0, max = 1;
        tessellator.addTranslation(x, y, z);

        if (ClientProxy.renderPass == 0) {
            IIcon icon = block.getIcon(0, 0);

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

            tessellator.setColorOpaque(Colours.oreColour(meta)[0], Colours.oreColour(meta)[1], Colours.oreColour(meta)[2]);

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
}