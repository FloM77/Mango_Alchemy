package AT.MSev.MAlchemy.Items;

import AT.MSev.MAlchemy.GUIs.GUIAlchemyTable;
import AT.MSev.MAlchemy.Logic.Alchemist.Alchemist;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class AlchemyTable extends ItemBase {

    public AlchemyTable() {
        super(1, Material.CRAFTING_TABLE, "Alchemy Table", new ArrayList<String>() {{ add("You can craft mango alchemy"); add("potions on this table"); }} );
    }

    @Override
    @EventHandler
    protected ItemBase OnUse(PlayerInteractEvent e) {
        if(super.OnUse(e) instanceof AlchemyTable)
        {
            Alchemist alchemist = null;
            if((alchemist =  Alchemist.FromPlayer(e.getPlayer())) != null) {
                new GUIAlchemyTable(alchemist);
            }
        }
        return null;
    }
}
