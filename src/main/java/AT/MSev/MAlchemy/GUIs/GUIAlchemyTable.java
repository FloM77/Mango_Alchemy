package AT.MSev.MAlchemy.GUIs;

import AT.MSev.MAlchemy.Logic.Alchemist.Alchemist;
import AT.MSev.MAlchemy.Logic.Potions.PotionBase;
import AT.MSev.MAlchemy.Logic.Potions.PotionJump;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GUIAlchemyTable {
    public Inventory GUI;

    public GUIAlchemyTable(Alchemist alchemist)
    {
        GUI = Bukkit.createInventory(null, 36);
        int count  = 0;
        for (PotionBase pb:
                PotionBase.All) {
            GUI.setItem(count, pb.Image(alchemist));
            count++;
        }

        alchemist.Parent.openInventory(GUI);
    }
}
