package HxCKDMS.HxCWorldGen.registry;

import HxCKDMS.HxCCore.Registry.ModRegistry;
import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import HxCKDMS.HxCWorldGen.items.ItemGem;
import HxCKDMS.HxCWorldGen.items.ItemIngot;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
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
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 0), "iii", "iii", "iii", 'i', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 1), "iii", "iii", "iii", 'i', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 2), "iii", "iii", "iii", 'i', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 3), "iii", "iii", "iii", 'i', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 4), "iii", "iii", "iii", 'i', "ingotNickel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 5), "iii", "iii", "iii", 'i', "ingotChromium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 6), "iii", "iii", "iii", 'i', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 7), "iii", "iii", "iii", 'i', "ingotTitanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 8), "iii", "iii", "iii", 'i', "ingotPlatinum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 9), "iii", "iii", "iii", 'i', "gemPeridot"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 10), "iii", "iii", "iii", 'i', "gemRuby"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModRegistry.blockRegistry.get(BlockStorage.class), 1, 11), "iii", "iii", "iii", 'i', "gemSapphire"));

        //unblocking
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 0), "blockCopper"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 1), "blockTin"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 2), "blockSilver"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 3), "blockLead"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 4), "blockNickel"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 5), "blockChromium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 6), "blockAluminum"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 7), "blockTitanium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 9, 8), "blockPlatinum"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 9, 9), "blockPeridot"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 9, 10), "blockRuby"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 9, 11), "blockSapphire"));

        //smelting
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 0), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 0), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 1), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 1), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 2), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 2), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 3), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 3), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 4), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 4), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 5), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 5), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 6), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 6), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 7), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 7), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 8), new ItemStack(ModRegistry.itemRegistry.get(ItemIngot.class), 1, 8), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 9), new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 1, 9), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 10), new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 1, 10), 10F);
        GameRegistry.addSmelting(new ItemStack(ModRegistry.blockRegistry.get(BlockOre.class), 1, 11), new ItemStack(ModRegistry.itemRegistry.get(ItemGem.class), 1, 11), 10F);
    }
}
