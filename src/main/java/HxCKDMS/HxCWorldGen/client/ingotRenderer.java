package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ingotRenderer implements IItemRenderer {
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        IIcon icon = item.getIconIndex();
        int metadata = item.getItemDamageForDisplay();
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.colour(metadata)[0], Colours.colour(metadata)[1], Colours.colour(metadata)[2]);
        tessellator.addVertexWithUV(0, 2, 1, icon.getMinU(), icon.getMaxV());
        tessellator.addVertexWithUV(4, 2, 1, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV(4, 1, 1, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV(1, 1, 1, icon.getMinU(), icon.getMinV());
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
}