package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Reference;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        IIcon icon = block.getIcon(0, metadata);

        int[] colour = Colours.getColours(Reference.RESOURCES[metadata].replace("Ingot", "Block").replace("Gem", "Block"));
        
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(colour[0], colour[1], colour[2]);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z),renderer);
        return true;
    }

    public static void render(Block block, int x, int y, int z, int metadata, RenderBlocks renderer){
        int[] colour = Colours.getColours(Reference.RESOURCES[metadata].replace("Ingot", "Block").replace("Gem", "Block"));
        renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colour[0] / 255F, colour[1] / 255F, colour[2] / 255F);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return Reference.BLOCK_RENDER_ID;
    }
}