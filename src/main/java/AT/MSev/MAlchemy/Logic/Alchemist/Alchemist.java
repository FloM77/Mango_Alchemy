package AT.MSev.MAlchemy.Logic.Alchemist;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Alchemist {
    public static ArrayList<Alchemist> All = new ArrayList<Alchemist>();

    public Alchemist(Player player)
    {
        Parent = player;
        Inventory = new Pouch();
        Boolean inAll = false;

        for (Alchemist alchemist:
             All) {
            if(alchemist.Parent == player)
            {
                inAll = true;
            }
        }

        if(!inAll)
        All.add(this);
    }

    public static Alchemist FromPlayer(Player player)
    {
        for (Alchemist alchemist:
             All) {
            if(alchemist.Parent == player)
            {
                return alchemist;
            }
        }
        return null;
    }

    public Player Parent;
    public Pouch Inventory;
}
