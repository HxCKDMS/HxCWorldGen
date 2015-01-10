package HxCKDMS.HxCWorldGen.registry;

import net.minecraftforge.fml.common.registry.GameRegistry;
import HxCKDMS.HxCWorldGen.creativeTabs.MWGcreativeTab;
import HxCKDMS.HxCWorldGen.items.ItemGem;
import HxCKDMS.HxCWorldGen.items.ItemIngot;
import net.minecraft.item.Item;

public class ItemRegistry {

    public static Item itemIngot = new ItemIngot(MWGcreativeTab.moreWorldGenTab);
    public static Item itemGem = new ItemGem(MWGcreativeTab.moreWorldGenTab);

    public static void preInit(){
        GameRegistry.registerItem(itemIngot, "ItemIngot");
        GameRegistry.registerItem(itemGem, "ItemGem");
    }
}
