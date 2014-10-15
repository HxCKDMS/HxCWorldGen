package kay.MoreWorldGen.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.MoreWorldGen.blocks.BlockOre;
import kay.MoreWorldGen.creativeTabs.MWGcreativeTab;
import kay.MoreWorldGen.items.ItemBlockOre;
import kay.MoreWorldGen.items.ItemBlockStorage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRegistry {
    public static Block blockOre = new BlockOre(Material.rock, MWGcreativeTab.moreWorldGenTab);
    public static Block blockStorage = new BlockOre(Material.iron, MWGcreativeTab.moreWorldGenTab);

    public static void preInit(){
        GameRegistry.registerBlock(blockOre, ItemBlockOre.class, "BlockOre");
        GameRegistry.registerBlock(blockStorage, ItemBlockStorage.class, "BlockStorage");
    }

}
