package AT.MSev.MAlchemy;

import AT.MSev.MAlchemy.Items.ItemBase;
import AT.MSev.MAlchemy.Logic.Alchemist.Alchemist;
import AT.MSev.MAlchemy.Utils.NBTManager;
import net.minecraft.server.v1_13_R2.NBTTagInt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Handler implements Listener {
    @EventHandler
    void OnBlockPlace(BlockPlaceEvent e)
    {
        if(ItemBase.GetFromIS(e.getItemInHand()) != null)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    void OnJoin(PlayerJoinEvent e)
    {
        new Alchemist(e.getPlayer());
        ItemBase.GetFromId(1).Give(e.getPlayer(), 1);
    }

    @EventHandler
    void OnInventoryClick(InventoryClickEvent e)
    {
        NBTTagInt craftid = null;
        if((craftid = (NBTTagInt) NBTManager.GetTag(e.getCurrentItem(),"craftid"))!=null)
        {
            e.setCancelled(true);
        }
    }
}
