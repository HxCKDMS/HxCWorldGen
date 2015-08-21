package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Utils.LogHelper;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.smeltery.TinkerSmeltery;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TConstructMessages {
    private static int ID = Configurations.TConstructStartingID;

    private static final List<String> fluids = Arrays.asList("aluminum", "copper", "tin", "silver", "lead", "nickel", "platinum");

    public static void registerTinkerMats() {
        LogHelper.info("Tinkers' Construct Detected! Registering Tinkers' Materials!", Reference.MOD_NAME);
        for (LinkedHashMap<String, String> mat : TinkersConfigs.mats) {
            if (mat.get("Enabled").equals("true")) {
                Object[] data = new Object[18];
                data[0] = Integer.parseInt(mat.get("Id"));
                data[1] = mat.get("Name");
                data[2] = Integer.parseInt(mat.get("HarvestLevel"));
                data[3] = Integer.parseInt(mat.get("Durability"));
                data[4] = Integer.parseInt(mat.get("MiningSpeed"));
                data[5] = Integer.parseInt(mat.get("Attack"));
                data[6] = Float.parseFloat(mat.get("HandleModifier"));
                data[7] = Integer.parseInt(mat.get("Reinforced"));
                data[8] = Float.parseFloat(mat.get("Stonebound"));
                data[9] = mat.get("Style");
                if (!mat.get("Color").equals("0x00000000"))data[10] = Integer.parseInt(mat.get("Color"));
                else data[10] = Colours.getColourFromRGB(Colours.getColours(mat.get("Name")));
                data[11] = Integer.parseInt(mat.get("Bow_DrawSpeed"));
                data[12] = Float.parseFloat(mat.get("Bow_ProjectileSpeed"));
                data[13] = Float.parseFloat(mat.get("Projectile_Mass"));
                data[14] = Float.parseFloat(mat.get("Projectile_Fragility"));
                if (!mat.get("Name").equalsIgnoreCase("Aluminium"))data[15] = mat.get("Name").toLowerCase();
                else data[15] = "aluminum";
                data[16] = Integer.parseInt(mat.get("Id")) + 1;
                data[17] = Integer.parseInt(mat.get("Temperature"));
                if (!mat.get("Name").equalsIgnoreCase("Zirconia"))registerTinkerMat(data);
                else registerZirconia(data);
            }
        }
        registerTinkerRecipes();
        LogHelper.info("Completed registering Tinkers' Materials", Reference.MOD_NAME);
    }

    public static void registerTinkerMat(Object[] obs) {
        NBTTagCompound newMatTag = new NBTTagCompound();
        newMatTag.setInteger("Id", ID + (int) obs[0]);
        newMatTag.setString("Name", (String) obs[1]);
        newMatTag.setInteger("HarvestLevel", (int)obs[2]);
        newMatTag.setInteger("Durability", (int) obs[3]);
        newMatTag.setInteger("MiningSpeed", (int) obs[4]);
        newMatTag.setInteger("Attack", (int)obs[5]);
        newMatTag.setFloat("HandleModifier", (float) obs[6]);
        newMatTag.setInteger("Reinforced", (int) obs[7]);
        newMatTag.setFloat("Stonebound", (float)obs[8]);
        newMatTag.setString("Style", EnumChatFormatting.getValueByName((String) obs[9]).toString());
        newMatTag.setInteger("Color", (int) obs[10]);
        newMatTag.setInteger("Bow_DrawSpeed", (int)obs[11]);
        newMatTag.setFloat("Bow_ProjectileSpeed", (float) obs[12]);
        newMatTag.setFloat("Projectile_Mass", (float) obs[13]);
        newMatTag.setFloat("Projectile_Fragility", (float) obs[14]);
        FMLInterModComms.sendMessage("TConstruct", "addMaterial", newMatTag);

        if (!fluids.contains(obs[15])) {
            TinkerSmeltery.registerFluid((String) obs[15]);
        }

        NBTTagCompound newPartBuilderMat = new NBTTagCompound();
        newPartBuilderMat.setInteger("MaterialId", ID + (int) obs[0]);
        newPartBuilderMat.setInteger("Value", 1);
        NBTTagCompound item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, (int) obs[16])).writeToNBT(item);
        newPartBuilderMat.setTag("Item", item);
        FMLInterModComms.sendMessage("TConstruct", "addMaterialItem", newPartBuilderMat);

/* This part adds Smeltery casting. Give it a liquid, and which material to output. BAM toolpart casting. */
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("FluidName", obs[15] + ".molten");
        (new FluidStack(FluidRegistry.getFluid(obs[15] + ".molten"), 1)).writeToNBT(tag);
        tag.setInteger("MaterialId", ID + (int)obs[0]);
        FMLInterModComms.sendMessage("TConstruct", "addPartCastingMaterial", tag);

/* Smelting Block*/
        tag = new NBTTagCompound();
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Item", item);
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.blockStorage, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Block", item);
        (new FluidStack(FluidRegistry.getFluid(obs[15] + ".molten"), 144)).writeToNBT(tag);
        tag.setInteger("Temperature", (int) obs[17]);
        FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);

        tag = new NBTTagCompound();
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.blockStorage, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Item", item);
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.blockStorage, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Block", item);
        (new FluidStack(FluidRegistry.getFluid(obs[15] + ".molten"), 144*9)).writeToNBT(tag);
        tag.setInteger("Temperature", (int) obs[17]*5);
        FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
    }

    public static void registerZirconia(Object[] obs) {
        //Zirconia is the only non-meltable material I have for materials
        //Zircon won't be used as a mat
        NBTTagCompound newMatTag = new NBTTagCompound();
        newMatTag.setInteger("Id", ID + (int) obs[0]);
        newMatTag.setString("Name", (String) obs[1]);
        newMatTag.setInteger("HarvestLevel", (int) obs[2]);
        newMatTag.setInteger("Durability", (int) obs[3]);
        newMatTag.setInteger("MiningSpeed", (int) obs[4]);
        newMatTag.setInteger("Attack", (int)obs[5]);
        newMatTag.setFloat("HandleModifier", (float) obs[6]);
        newMatTag.setInteger("Reinforced", (int) obs[7]);
        newMatTag.setFloat("Stonebound", (float)obs[8]);
        newMatTag.setString("Style", EnumChatFormatting.getValueByName((String) obs[9]).toString());
        newMatTag.setInteger("Color", (int) obs[10]);
        newMatTag.setInteger("Bow_DrawSpeed", (int)obs[11]);
        newMatTag.setFloat("Bow_ProjectileSpeed", (float) obs[12]);
        newMatTag.setFloat("Projectile_Mass", (float) obs[13]);
        newMatTag.setFloat("Projectile_Fragility", (float) obs[14]);
        FMLInterModComms.sendMessage("TConstruct", "addMaterial", newMatTag);

        NBTTagCompound newPartBuilderMat = new NBTTagCompound();
        newPartBuilderMat.setInteger("MaterialId", ID + (int) obs[0]);
        newPartBuilderMat.setInteger("Value", 1);
        NBTTagCompound item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, 13)).writeToNBT(item);
        newPartBuilderMat.setTag("Item", item);
        FMLInterModComms.sendMessage("TConstruct", "addMaterialItem", newPartBuilderMat);

        /* This part adds mappigs, so that you can convert items to toolparts in the Part Builder.
           Stone Parts are used as the baseline for what exists */
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("MaterialId", ID + 13);
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, 13)).writeToNBT(item);
        tag.setTag("Item", item);

        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemFragment, 1, 13)).writeToNBT(item);
        tag.setTag("Shard", item);
        tag.setInteger("Value", 1);
        FMLInterModComms.sendMessage("TConstruct", "addPartBuilderMaterial", tag);
    }

    public static void registerTinkerRecipes() {
        for (int i = 0; i < 9; i++) {
            ItemStack stack = new ItemStack(ModRegistry.itemResource, 1, i);
            ItemStack nstack = new ItemStack(ModRegistry.itemFragment, 1, i);
            ItemStack bstack = new ItemStack(ModRegistry.blockStorage, 1, i);
            FluidStack fstack, nfstack, bfstack;
            if (stack.getUnlocalizedName().replace("Ingot", "").equalsIgnoreCase("aluminium")) fstack = new FluidStack(FluidRegistry.getFluid("aluminum.molten"), 144);
            else fstack = new FluidStack(FluidRegistry.getFluid(stack.getUnlocalizedName().replace("Ingot", "").toLowerCase() + ".molten"), 144);
            if (nstack.getUnlocalizedName().replace("Nugget", "").equalsIgnoreCase("aluminium")) nfstack = new FluidStack(FluidRegistry.getFluid("aluminum.molten"), 144/9);
            else nfstack = new FluidStack(FluidRegistry.getFluid(nstack.getUnlocalizedName().replace("Nugget", "").toLowerCase() + ".molten"), 144/9);
            if (bstack.getUnlocalizedName().replace("Block", "").equalsIgnoreCase("aluminium")) bfstack = new FluidStack(FluidRegistry.getFluid("aluminum.molten"), 144*9);
            else bfstack = new FluidStack(FluidRegistry.getFluid(bstack.getUnlocalizedName().replace("Block", "").toLowerCase() + ".molten"), 144*9);
            System.out.println("Ingot Casting : " + stack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getTableCasting().addCastingRecipe(stack, fstack, new ItemStack(TinkerSmeltery.metalPattern, 1, 0), false, 20, null);
            System.out.println("Nugget Casting : " + nstack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getTableCasting().addCastingRecipe(nstack, nfstack, new ItemStack(TinkerSmeltery.metalPattern, 1, 27), false, 20, null);
            System.out.println("Block Casting : " + bstack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getBasinCasting().addCastingRecipe(bstack, bfstack, null, true, 120, null);
        }
        for (int i = 9; i < 12; i++) {
            ItemStack stack = new ItemStack(ModRegistry.itemResource, 1, i);
            ItemStack nstack = new ItemStack(ModRegistry.itemFragment, 1, i);
            ItemStack bstack = new ItemStack(ModRegistry.blockStorage, 1, i);
            System.out.println("Gem Casting : " + stack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getTableCasting().addCastingRecipe(stack, new FluidStack(FluidRegistry.getFluid(stack.getUnlocalizedName().replace("Gem", "").toLowerCase() + ".molten"), 144), new ItemStack(TinkerSmeltery.metalPattern, 1, 26), false, 20, null);
            System.out.println("Gem Fragment Casting : " + nstack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getTableCasting().addCastingRecipe(nstack, new FluidStack(FluidRegistry.getFluid(nstack.getUnlocalizedName().replace("Fragment", "").toLowerCase() + ".molten"), 144 / 9), new ItemStack(TinkerSmeltery.metalPattern, 1, 27), false, 20, null);
            System.out.println("Gem Block Casting : " + bstack.getUnlocalizedName() + "registering!");
            TConstructRegistry.getBasinCasting().addCastingRecipe(bstack, new FluidStack(FluidRegistry.getFluid(bstack.getUnlocalizedName().replace("Block", "").toLowerCase() + ".molten"), 144/9), null, true, 120, null);
        }

        NBTTagCompound tag;
        NBTTagCompound item;
        ItemStack stack;
        String fluid;
        for (int i = 0; i < 12; i++) {
            if (Configurations.enableOreChunks) {
                tag = new NBTTagCompound();
                item = new NBTTagCompound();
                stack = new ItemStack(ModRegistry.itemOreChunk, 1, i);
                stack.writeToNBT(item);
                tag.setTag("Item", item);
                item = new NBTTagCompound();
                (new ItemStack(ModRegistry.blockStorage, 1, i)).writeToNBT(item);
                tag.setTag("Block", item);
                if (stack.getUnlocalizedName().replace("Chunk", "").equalsIgnoreCase("aluminium"))
                    fluid = "aluminum.molten";
                else fluid = stack.getUnlocalizedName().replace("Chunk", "").toLowerCase() + ".molten";
                (new FluidStack(FluidRegistry.getFluid(fluid), 144)).writeToNBT(tag);
                tag.setInteger("Temperature", 400);
                FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
            }
            tag = new NBTTagCompound();
            item = new NBTTagCompound();

            stack = new ItemStack(ModRegistry.itemFragment, 1, i);
            stack.writeToNBT(item);
            tag.setTag("Item", item);
            item = new NBTTagCompound();
            (new ItemStack(ModRegistry.blockStorage, 1, i)).writeToNBT(item);
            tag.setTag("Block", item);
            if (stack.getUnlocalizedName().replace("Nugget", "").replace("Fragment", "").equalsIgnoreCase("aluminium"))fluid = "aluminum.molten";
            else fluid = stack.getUnlocalizedName().replace("Nugget", "").replace("Fragment", "").toLowerCase() + ".molten";
            (new FluidStack(FluidRegistry.getFluid(fluid), 144/9)).writeToNBT(tag);
            tag.setInteger("Temperature", 400);
            FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
        }

        if (Configurations.enableOreChunks) {
            tag = new NBTTagCompound();
            item = new NBTTagCompound();
            stack = new ItemStack(ModRegistry.itemOreChunk, 1, 12);
            stack.writeToNBT(item);
            tag.setTag("Item", item);
            item = new NBTTagCompound();
            (new ItemStack(ModRegistry.blockStorage, 1, 7)).writeToNBT(item);
            tag.setTag("Block", item);
            (new FluidStack(FluidRegistry.getFluid("titanium.molten"), 144)).writeToNBT(tag);
            tag.setInteger("Temperature", 400);
            FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
        }
    }
}
