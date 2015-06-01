package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

public class ingotRenderer implements IItemRenderer {
    Minecraft mc = Minecraft.getMinecraft();
    ItemRenderer itemRenderer = new ItemRenderer(mc);
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Tessellator tessellator = Tessellator.instance;
        IIcon icon = item.getIconIndex();
        int metadata = item.getItemDamageForDisplay();
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.addVertexWithUV(0.5, 1.5, 1.25, icon.getMinU(), icon.getMinV()); //Bottom left texture
        tessellator.addVertexWithUV(0.5, 0.5, 1.25, icon.getMinU(), icon.getMaxV()); //Top left
        tessellator.addVertexWithUV(1.5, 0.5, 1.25, icon.getMaxU(), icon.getMaxV()); //Top right
        tessellator.addVertexWithUV(1.5, 1.5, 1.25, icon.getMaxU(), icon.getMinV()); //Bottom right
        tessellator.draw();
    }
}