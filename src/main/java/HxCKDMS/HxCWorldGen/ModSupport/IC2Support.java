package HxCKDMS.HxCWorldGen.ModSupport;

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

import java.util.Collections;

public class IC2Support {
    public static void init() {
        NBTTagCompound c = new NBTTagCompound();
        c.setInteger("amount", 250);
        c.setInteger("minHeat", 500);

        for (int i = 0; i < Reference.RESOURCES.length; i++)
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemResource, 1, i), 1), new NBTTagCompound(), OreDictionary.getOres("dust" + Reference.RESOURCES[i].replace("Ingot", "").replace("Gem", "")).get(0));

        for (int i = 0; i < Reference.RESOURCES.length; i++)
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemFragment, 1, i), 1), new NBTTagCompound(), OreDictionary.getOres("dustTiny" + Reference.RESOURCES[i].replace("Ingot", "").replace("Gem", "")).get(0));

        for (int i = 0; i < Reference.ORES.length; i++)
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemOreChunk, 1, i), 1), new NBTTagCompound(), new ItemStack(ModRegistry.itemDust, 1, i));

        for (int i = 4; i < Reference.ORES.length; i++) {
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.blockOre, 1, i), 1), new NBTTagCompound(), new ItemStack(ModRegistry.itemCrushed, 2, i));
            Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemCrushed, 1, i), 1), new NBTTagCompound(), new ItemStack(ModRegistry.itemPureCrushed, 1, i), new ItemStack(OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getItem(), 5, OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getMetadata()), OreDictionary.getOres("dustStone").get(0));
            Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemPureCrushed, 1, i), 1), c, OreDictionary.getOres("dust" + Reference.ORES[i].replace("Ore", "")).get(0), new ItemStack(OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getItem(), 3, OreDictionary.getOres("dustTiny" + Reference.ORES[i].replace("Ore", "")).get(0).getMetadata()));
        }

        //Because AtomicStryker is a fucking idiot...
        try {
            Recipes.macerator.getRecipes().remove(new RecipeInputItemStack(new ItemStack(Blocks.netherrack, 1)), new RecipeOutput(new NBTTagCompound(), Collections.singletonList(new ItemStack(Blocks.netherrack))));
        } catch (Exception ignored) {}

        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Blocks.netherrack, 1)), new NBTTagCompound(), OreDictionary.getOres("dustNether").get(0));
        Recipes.compressor.addRecipe(new RecipeInputOreDict("dustZirconium", 9), new NBTTagCompound(), OreDictionary.getOres("gemZircon").get(0));
        Recipes.oreWashing.addRecipe(new RecipeInputOreDict("dustIlmenite", 1), new NBTTagCompound(), OreDictionary.getOres("dustTitanium").get(0), OreDictionary.getOres("dustZirconium").get(0));
        Recipes.oreWashing.addRecipe(new RecipeInputOreDict("dustNether", 1), new NBTTagCompound(), OreDictionary.getOres("dustSulfur").get(0), OreDictionary.getOres("dustStone").get(0));
    }
}
