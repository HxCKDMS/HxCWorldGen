package HxCKDMS.HxCWorldGen.Proxy;

import HxCKDMS.HxCWorldGen.registry.BlockRegistry;
import HxCKDMS.HxCWorldGen.registry.ItemRegistry;
import HxCKDMS.HxCWorldGen.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy{

    /**
    0 = Copper
    1 = Tin
    2 = Silver
    3 = Lead
    4 = Nickel
    5 = Chromium
    6 = Aluminium
    7 = Titanium
    8 = Platinum
    9 = Aventurine
    10 = Ruby
    11 = Sapphire
    **/

    @Override
    public void init() {
        Item ore = Item.getItemFromBlock(BlockRegistry.blockOre);
        Item storage = Item.getItemFromBlock(BlockRegistry.blockStorage);

        Minecraft mc = Minecraft.getMinecraft();
        ItemModelMesher mesher = mc.getRenderItem().getItemModelMesher();
        mesher.register(ore, 0, new ModelResourceLocation(Reference.MOD_ID + ":BlockOre", "inventory"));
        mesher.register(storage, 0, new ModelResourceLocation(Reference.MOD_ID + ":BlockStorage", "inventory"));
        mesher.register(ItemRegistry.itemIngot, 0, new ModelResourceLocation(Reference.MOD_ID + ":ItemIngot", "inventory"));
        mesher.register(ItemRegistry.itemGem, 0, new ModelResourceLocation(Reference.MOD_ID + ":ItemGem", "inventory"));
        ModelBakery.addVariantName(ore, "Tin", "Silver", "Lead", "Nickel", "Chromium", "Aluminium", "Titanium", "Platinum", "Aventurine", "Ruby", "Sapphire");
        ModelBakery.addVariantName(storage, "Tin", "Silver", "Lead", "Nickel", "Chromium", "Aluminium", "Titanium", "Platinum", "Aventurine", "Ruby", "Sapphire");

        ModelBakery.addVariantName(ItemRegistry.itemIngot, "Tin","Silver","Lead","Nickel","Chromium","Aluminium","Titanium","Platinum");
        ModelBakery.addVariantName(ItemRegistry.itemGem, "Aventurine", "Ruby", "Sapphire");
        super.init();
    }
}
