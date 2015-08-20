package HxCKDMS.HxCWorldGen.blocks;

import HxCKDMS.HxCWorldGen.libs.Reference;
import HxCKDMS.HxCWorldGen.libs.TextureHandler;
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

    @Override
    public int getRenderType() {
        return Reference.ORE_RENDER_ID;
    }

    public BlockStorage(Material material, CreativeTabs creativeTabs) {
        super(material);
        setHardness(3F);
        setResistance(5F);
        setStepSound(Block.soundTypeMetal);
        setCreativeTab(creativeTabs);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        icons = new IIcon[2];
        icons[0] = iconRegister.registerIcon(TextureHandler.getTexturePath("metalBlock"));
        icons[1] = iconRegister.registerIcon(TextureHandler.getTexturePath("gemBlock"));
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        if (metadata < 9) return icons[0];
        return icons[1];
    }

    @Override
    public int damageDropped(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 13; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    public int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000;
        Green = (Green << 8) & 0x0000FF00;
        Blue = Blue & 0x000000FF;
        //0xFF000000 for 100% Alpha.
        return 0xFF000000 | Red | Green | Blue;
    }
}
