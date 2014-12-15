package HxCKDMS.HxCWorldGen.registry;

import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import cpw.mods.fml.common.registry.GameRegistry;
import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.creativeTabs.MWGcreativeTab;
import HxCKDMS.HxCWorldGen.items.ItemBlockOre;
import HxCKDMS.HxCWorldGen.items.ItemBlockStorage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRegistry {
    public static Block blockOre = new BlockOre(Material.rock, MWGcreativeTab.moreWorldGenTab);
    public static Block blockStorage = new BlockStorage(Material.iron, MWGcreativeTab.moreWorldGenTab);

    public static void preInit(){
        GameRegistry.registerBlock(blockOre, ItemBlockOre.class, "BlockOre");
        GameRegistry.registerBlock(blockStorage, ItemBlockStorage.class, "BlockStorage");
    }

}
