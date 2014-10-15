package HxCKDMS.MoreWorldGen.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import HxCKDMS.MoreWorldGen.creativeTabs.MWGcreativeTab;
import HxCKDMS.MoreWorldGen.items.ItemGem;
import HxCKDMS.MoreWorldGen.items.ItemIngot;
import net.minecraft.item.Item;

public class ItemRegistry {

    public static Item itemIngot = new ItemIngot(MWGcreativeTab.moreWorldGenTab);
    public static Item itemGem = new ItemGem(MWGcreativeTab.moreWorldGenTab);

    public static void preInit(){
        GameRegistry.registerItem(itemIngot, "ItemIngot");
        GameRegistry.registerItem(itemGem, "ItemGem");
    }
}
