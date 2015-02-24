package HxCKDMS.HxCWorldGen.registry;

import HxCKDMS.HxCCore.Registry.CommonModRegistry;
import HxCKDMS.HxCWorldGen.blocks.BlockOre;
import HxCKDMS.HxCWorldGen.blocks.BlockStorage;
import HxCKDMS.HxCWorldGen.items.ItemGem;
import HxCKDMS.HxCWorldGen.items.ItemIngot;
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
        OreDictionary.registerOre("oreCopper", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 0));
        OreDictionary.registerOre("oreTin", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 1));
        OreDictionary.registerOre("oreSilver", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 2));
        OreDictionary.registerOre("oreLead", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 3));
        OreDictionary.registerOre("oreNickel", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 4));
        OreDictionary.registerOre("oreChromium", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 5));
        OreDictionary.registerOre("oreAluminum", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 6));
        OreDictionary.registerOre("oreTitanium", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 7));
        OreDictionary.registerOre("orePlatinum", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 8));
        OreDictionary.registerOre("oreAventurine", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 9));
        OreDictionary.registerOre("oreRuby", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 10));
        OreDictionary.registerOre("oreSapphire", new ItemStack(CommonModRegistry.blockRegistry.get(BlockOre.class), 1, 11));

        //ingots
        OreDictionary.registerOre("ingotCopper", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 0));
        OreDictionary.registerOre("ingotTin", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 1));
        OreDictionary.registerOre("ingotSilver", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 2));
        OreDictionary.registerOre("ingotLead", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 3));
        OreDictionary.registerOre("ingotNickel", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 4));
        OreDictionary.registerOre("ingotChromium", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 5));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 6));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 7));
        OreDictionary.registerOre("ingotPlatinum", new ItemStack(CommonModRegistry.itemRegistry.get(ItemIngot.class), 1, 8));

        //gems
        OreDictionary.registerOre("gemPeridot", new ItemStack(CommonModRegistry.itemRegistry.get(ItemGem.class), 1, 9));
        OreDictionary.registerOre("gemRuby", new ItemStack(CommonModRegistry.itemRegistry.get(ItemGem.class), 1, 10));
        OreDictionary.registerOre("gemSapphire", new ItemStack(CommonModRegistry.itemRegistry.get(ItemGem.class), 1, 11));

        //Storage blocks
        OreDictionary.registerOre("blockCopper", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 0));
        OreDictionary.registerOre("blockTin", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 1));
        OreDictionary.registerOre("blockSilver", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 2));
        OreDictionary.registerOre("blockLead", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 3));
        OreDictionary.registerOre("blockNickel", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 4));
        OreDictionary.registerOre("blockChromium", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 5));
        OreDictionary.registerOre("blockAluminum", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 6));
        OreDictionary.registerOre("blockTitanium", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 7));
        OreDictionary.registerOre("blockPlatinum", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 8));
        OreDictionary.registerOre("blockPeridot", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 9));
        OreDictionary.registerOre("blockRuby", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 10));
        OreDictionary.registerOre("blockSapphire", new ItemStack(CommonModRegistry.blockRegistry.get(BlockStorage.class), 1, 11));

    }
}
