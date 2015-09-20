package HxCKDMS.HxCWorldGen.creativeTabs;

import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MWGcreativeTab {
    public static CreativeTabs moreWorldGenTab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModRegistry.blockOre);
        }
    };
}
