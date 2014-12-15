package HxCKDMS.HxCWorldGen.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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

public class OreDictionaryRegistry {
    public static void init(){
        //ores
        OreDictionary.registerOre("oreCopper", new ItemStack(BlockRegistry.blockOre, 1, 0));
        OreDictionary.registerOre("oreTin", new ItemStack(BlockRegistry.blockOre, 1, 1));
        OreDictionary.registerOre("oreSilver", new ItemStack(BlockRegistry.blockOre, 1, 2));
        OreDictionary.registerOre("oreLead", new ItemStack(BlockRegistry.blockOre, 1, 3));
        OreDictionary.registerOre("oreNickel", new ItemStack(BlockRegistry.blockOre, 1, 4));
        OreDictionary.registerOre("oreChromium", new ItemStack(BlockRegistry.blockOre, 1, 5));
        OreDictionary.registerOre("oreAluminium", new ItemStack(BlockRegistry.blockOre, 1, 6));
        OreDictionary.registerOre("oreTitanium", new ItemStack(BlockRegistry.blockOre, 1, 7));
        OreDictionary.registerOre("orePlatinum", new ItemStack(BlockRegistry.blockOre, 1, 8));
        OreDictionary.registerOre("oreAventurine", new ItemStack(BlockRegistry.blockOre, 1, 9));
        OreDictionary.registerOre("oreRuby", new ItemStack(BlockRegistry.blockOre, 1, 10));
        OreDictionary.registerOre("oreSapphire", new ItemStack(BlockRegistry.blockOre, 1, 11));

        //ingots
        OreDictionary.registerOre("ingotCopper", new ItemStack(ItemRegistry.itemIngot, 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(ItemRegistry.itemIngot, 1, 1));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ItemRegistry.itemIngot, 1, 2));
        OreDictionary.registerOre("ingotLead", new ItemStack(ItemRegistry.itemIngot, 1, 3));
        OreDictionary.registerOre("ingotNickel", new ItemStack(ItemRegistry.itemIngot, 1, 4));
        OreDictionary.registerOre("ingotChromium", new ItemStack(ItemRegistry.itemIngot, 1, 5));
        OreDictionary.registerOre("ingotAluminium", new ItemStack(ItemRegistry.itemIngot, 1, 6));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(ItemRegistry.itemIngot, 1, 7));
        OreDictionary.registerOre("ingotPlatinum", new ItemStack(ItemRegistry.itemIngot, 1, 8));

        //gems
        OreDictionary.registerOre("gemPeridot", new ItemStack(ItemRegistry.itemGem, 1, 9));
        OreDictionary.registerOre("gemRuby", new ItemStack(ItemRegistry.itemGem, 1, 10));
        OreDictionary.registerOre("gemSapphire", new ItemStack(ItemRegistry.itemGem, 1, 11));

        //Storage blocks
        OreDictionary.registerOre("blockCopper", new ItemStack(BlockRegistry.blockStorage, 1, 0));
        OreDictionary.registerOre("blockTin", new ItemStack(BlockRegistry.blockStorage, 1, 1));
        OreDictionary.registerOre("blockSilver", new ItemStack(BlockRegistry.blockStorage, 1, 2));
        OreDictionary.registerOre("blockLead", new ItemStack(BlockRegistry.blockStorage, 1, 3));
        OreDictionary.registerOre("blockNickel", new ItemStack(BlockRegistry.blockStorage, 1, 4));
        OreDictionary.registerOre("blockChromium", new ItemStack(BlockRegistry.blockStorage, 1, 5));
        OreDictionary.registerOre("blockAluminium", new ItemStack(BlockRegistry.blockStorage, 1, 6));
        OreDictionary.registerOre("blockTitanium", new ItemStack(BlockRegistry.blockStorage, 1, 7));
        OreDictionary.registerOre("blockPlatinum", new ItemStack(BlockRegistry.blockStorage, 1, 8));
        OreDictionary.registerOre("blockPeridot", new ItemStack(BlockRegistry.blockStorage, 1, 9));
        OreDictionary.registerOre("blockRuby", new ItemStack(BlockRegistry.blockStorage, 1, 10));
        OreDictionary.registerOre("blockSapphire", new ItemStack(BlockRegistry.blockStorage, 1, 11));

    }
}
