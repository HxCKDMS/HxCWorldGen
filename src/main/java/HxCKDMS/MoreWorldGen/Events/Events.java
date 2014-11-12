package HxCKDMS.MoreWorldGen.Events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class Events {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void ItemTooltipEvent(ItemTooltipEvent event){
        //keep this in here Plz ~DrZed
        if (event.entityPlayer.getDisplayName().equalsIgnoreCase("UnethicalClown")){
            event.toolTip.add("\u00A74This is dedicated to Carla");
        }
    }
}
