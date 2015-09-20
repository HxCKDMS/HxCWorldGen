package HxCKDMS.HxCWorldGen.ModSupport;

import HxCKDMS.HxCWorldGen.libs.ModRegistry;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class IC2Support {
    public static void init() {
        for (int i = 0; i < 13; i++)
            Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemOreChunk, 1, i), 1),
                    new NBTTagCompound(), new ItemStack(ModRegistry.itemDust, 1, i));
        Recipes.oreWashing.addRecipe(new RecipeInputItemStack(new ItemStack(ModRegistry.itemDust, 1, 7), 1),
                ((new NBTTagCompound()).setInteger("minHeat", 400)).setInteger("amount", 250), new ItemStack(ModRegistry.itemDust, 1, 14), new ItemStack(ModRegistry.itemDust, 1, 13));
    }
}
