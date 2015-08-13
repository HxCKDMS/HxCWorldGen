package HxCKDMS.HxCWorldGen.libs;

import HxCKDMS.HxCCore.api.Utils.LogHelper;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class TConstructMessages {
    private static int ID = Configurations.TConstructStartingID;

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
                if (!mat.get("Name").equalsIgnoreCase("Aluminium"))data[15] = mat.get("Name".toLowerCase());
                else data[15] = "Aluminum";
                data[16] = mat.get("Id") + 1;
                data[17] = Integer.parseInt(mat.get("Temperature"));
                if (!mat.get("Name").equalsIgnoreCase("Zirconia"))registerTinkerMat(data);
                else registerZirconia(data);
            }
        }
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

        try {
            Class<?> c = Class.forName("TinkerSmeltery.class");
            Method m = c.getDeclaredMethod("registerFluid", String.class);
            m.invoke(null, (String)obs[15]);
        } catch (Exception e) {
            LogHelper.warn("An error occurred in registering things to tinkers'.", Reference.MOD_NAME);
            e.printStackTrace();
        }

/* This part adds Smeltery casting. Give it a liquid, and which material to output. BAM toolpart casting. */
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("FluidName", obs[15] + ".molten");
        (new FluidStack(FluidRegistry.getFluid(obs[15] + ".molten"), 1)).writeToNBT(tag);
        tag.setInteger("MaterialId", ID + (int)obs[0]);
        FMLInterModComms.sendMessage("TConstruct", "addPartCastingMaterial", tag);

/* Smelting Block*/
        tag = new NBTTagCompound();
        NBTTagCompound item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Item", item);
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.blockStorage, 1, (int)obs[16])).writeToNBT(item);
        tag.setTag("Block", item);
        (new FluidStack(FluidRegistry.getFluid(obs[15] + ".molten"), 144)).writeToNBT(tag);
        tag.setInteger("Temperature", (int)obs[17]);
        FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
    }

    public static void registerZirconia(Object[] obs) {
        //Zirconia is the only non-meltable material I have for materials
        //Zircon won't be used as a mat
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
        tag.setInteger("MaterialId", ID+13);
        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemResource, 1, 13)).writeToNBT(item);
        tag.setTag("Item", item);

        item = new NBTTagCompound();
        (new ItemStack(ModRegistry.itemFragment, 1, 13)).writeToNBT(item);
        tag.setTag("Shard", item);
        tag.setInteger("Value", 1);
        FMLInterModComms.sendMessage("TConstruct", "addPartBuilderMaterial", tag);
    }
}
