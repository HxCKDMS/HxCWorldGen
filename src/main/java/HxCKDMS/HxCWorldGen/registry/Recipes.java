package HxCKDMS.HxCWorldGen.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/*
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
*/


public class Recipes {
    public static void PreInit(){
        //blocking
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 0), "iii", "iii", "iii", 'i', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 1), "iii", "iii", "iii", 'i', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 2), "iii", "iii", "iii", 'i', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 3), "iii", "iii", "iii", 'i', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 4), "iii", "iii", "iii", 'i', "ingotNickel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 5), "iii", "iii", "iii", 'i', "ingotChromium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 6), "iii", "iii", "iii", 'i', "ingotAluminium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 7), "iii", "iii", "iii", 'i', "ingotTitanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 8), "iii", "iii", "iii", 'i', "ingotPlatinum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 9), "iii", "iii", "iii", 'i', "gemPeridot"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 10), "iii", "iii", "iii", 'i', "gemRuby"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.blockStorage, 1, 11), "iii", "iii", "iii", 'i', "gemSapphire"));

        //unblocking
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 0), "blockCopper"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 1), "blockTin"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 2), "blockSilver"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 3), "blockLead"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 4), "blockNickel"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 5), "blockChromium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 6), "blockAluminium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 7), "blockTitanium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemIngot, 9, 8), "blockPlatinum"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemGem, 9, 9), "blockPeridot"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemGem, 9, 10), "blockRuby"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemRegistry.itemGem, 9, 11), "blockSapphire"));

        //smelting
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 0), new ItemStack(ItemRegistry.itemIngot, 1, 0), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 1), new ItemStack(ItemRegistry.itemIngot, 1, 1), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 2), new ItemStack(ItemRegistry.itemIngot, 1, 2), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 3), new ItemStack(ItemRegistry.itemIngot, 1, 3), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 4), new ItemStack(ItemRegistry.itemIngot, 1, 4), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 5), new ItemStack(ItemRegistry.itemIngot, 1, 5), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 6), new ItemStack(ItemRegistry.itemIngot, 1, 6), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 7), new ItemStack(ItemRegistry.itemIngot, 1, 7), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 8), new ItemStack(ItemRegistry.itemIngot, 1, 8), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 9), new ItemStack(ItemRegistry.itemGem, 1, 9), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 10), new ItemStack(ItemRegistry.itemGem, 1, 10), 10F);
        GameRegistry.addSmelting(new ItemStack(BlockRegistry.blockOre, 1, 11), new ItemStack(ItemRegistry.itemGem, 1, 11), 10F);
    }
}
