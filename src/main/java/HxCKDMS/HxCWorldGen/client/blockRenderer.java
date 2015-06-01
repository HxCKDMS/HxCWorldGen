package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class blockRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        GL11.glEnable(GL11.GL_BLEND);

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(metadata)[0], Colours.blockColour(metadata)[1], Colours.blockColour(metadata)[2]);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z));
        return true;
    }

    public static void render(Block block, int x, int y, int z, int meta){
        Tessellator tessellator = Tessellator.instance;
        tessellator.addTranslation(x, y, z);

        double min = 0, max = 1;
        IIcon icon = block.getIcon(0, meta);
        if (TextureHandler.isDoSpecial()) tessellator.setColorOpaque(220,220,220);
        tessellator.setColorOpaque(Colours.blockColour(meta)[0], Colours.blockColour(meta)[1], Colours.blockColour(meta)[2]);

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