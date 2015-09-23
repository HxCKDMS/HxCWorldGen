package HxCKDMS.HxCWorldGen.ModSupport;

import HxCKDMS.HxCWorldGen.libs.Configurations;
import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import HxCKDMS.HxCWorldGen.libs.Reference;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.RecipeOutput;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class IC2Support {
    public static void init() {
        NBTTagCompound c = new NBTTagCompound();
        c.setInteger("amount", 250);
        c.setInteger("minHeat", 500);

        if (Configurations.enableOreChunks)
            for (int i = 0; i < Reference.ORES.length; i++)
                Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemOreChunk, 1, i), 1), new NBTTagCompound(), OreDictionary.getOres("crushed" + Reference.ORES[i].replace("Ore", "")).get(0));

        for (int i = 4; i < Reference.ORES.length; i++) {
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.blockOre, 1, i), 1), new NBTTagCompound(), new ItemStack(ModRegistry.itemCrushed, 2, i));
            Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemCrushed, 1, i), 1), new NBTTagCompound(), new ItemStack(ModRegistry.itemPureCrushed, 1, i), new ItemStack(OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getItem(), 5, OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getMetadata()), OreDictionary.getOres("dustStone").get(0));
            Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemPureCrushed, 1, i), 1), c, OreDictionary.getOres("dust" + Reference.ORES[i].replace("Ore", "")).get(0), new ItemStack(OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getItem(), 3, OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getMetadata()));
        }

        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.netherrack, 1)), new NBTTagCompound(), OreDictionary.getOres("dustNether").get(0));
        Recipes.compressor.addRecipe(new RecipeInputOreDict("dustZirconium", 9), new NBTTagCompound(), OreDictionary.getOres("gemZircon").get(0));
        Recipes.oreWashing.addRecipe(new RecipeInputOreDict("dustIlmenite", 1), new NBTTagCompound(), OreDictionary.getOres("dustTitanium").get(0), OreDictionary.getOres("dustZirconium").get(0));
        Recipes.oreWashing.addRecipe(new RecipeInputOreDict("dustNether", 1), new NBTTagCompound(), OreDictionary.getOres("dustSulfur").get(0), OreDictionary.getOres("dustStone").get(0));
    }
}
