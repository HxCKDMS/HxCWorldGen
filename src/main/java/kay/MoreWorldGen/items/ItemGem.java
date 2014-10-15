package kay.MoreWorldGen.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kay.MoreWorldGen.util.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

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

public class ItemGem extends Item {
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public ItemGem(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);

    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){

        String name;

        switch(itemStack.getItemDamage()){
            case 9:
                name = "AventurineGem";
                break;
            case 10:
                name = "RubyGem";
                break;
            case 11:
                name = "SapphireGem";
                break;
            default:
                name = "error";
        }

        return name;
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        icons = new IIcon[256];
        icons[9] = iconRegister.registerIcon(Reference.MOD_ID + ":gemAventurine");
        icons[10] = iconRegister.registerIcon(Reference.MOD_ID + ":gemRuby");
        icons[11] = iconRegister.registerIcon(Reference.MOD_ID + ":gemSapphire");

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        return icons[metadata];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 9; i < 12; i++){
            list.add(new ItemStack(item,1,i));
        }
    }
}
