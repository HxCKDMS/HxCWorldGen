package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 0 = Copper
 1 = Tin
 2 = Silver
 3 = Lead
 4 = Nickel
 5 = Chromium
 6 = Aluminium
 7 = Titanium / Ilmenite
 8 = Platinum
 9 = Aventurine
 10 = Ruby
 11 = Sapphire
 12 = Rutile //blocks
 12 = Zircon //items
 13 = Zirconia //items
 **/

public class BlockStorage extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockStorage(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setStepSound(Block.soundTypeMetal);
        setCreativeTab(creativeTabs);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        icons = new IIcon[256];
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockCopper");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockTin");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockSilver");
        icons[3] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockLead");
        icons[4] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockNickel");
        icons[5] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockChromium");
        icons[6] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockAluminium");
        icons[7] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockTitanium");
        icons[8] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockPlatinum");
        icons[9] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockAventurine");
        icons[10] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockRuby");
        icons[11] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockSapphire");
        icons[12] = iconRegister.registerIcon(Reference.MOD_ID + ":BlockZirconium");
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return icons[metadata];
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 12; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
