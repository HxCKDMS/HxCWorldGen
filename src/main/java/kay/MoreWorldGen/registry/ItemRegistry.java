package kay.MoreWorldGen.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.MoreWorldGen.creativeTabs.MWGcreativeTab;
import kay.MoreWorldGen.items.ItemGem;
import kay.MoreWorldGen.items.ItemIngot;
import net.minecraft.item.Item;

public class ItemRegistry {

    public static Item itemIngot = new ItemIngot(MWGcreativeTab.moreWorldGenTab);
    public static Item itemGem = new ItemGem(MWGcreativeTab.moreWorldGenTab);

    public static void preInit(){
        GameRegistry.registerItem(itemIngot, "ItemIngot");
        GameRegistry.registerItem(itemGem, "ItemGem");
    }
}
