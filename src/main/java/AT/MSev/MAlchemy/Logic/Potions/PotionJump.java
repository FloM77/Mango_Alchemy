package AT.MSev.MAlchemy.Logic.Potions;

import AT.MSev.MAlchemy.Items.ItemBase;
import AT.MSev.MAlchemy.Logic.Alchemist.Ingredient;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class PotionJump extends PotionBase {
    public PotionJump() {
        super(2, Material.GLASS_BOTTLE, "Jump Potion",
                new ArrayList<String>() {{add("Leap a short distance");}},
                new ArrayList<Ingredient>() {{ add(new Ingredient(Ingredient.Ingredients.Silverberry, 2));}},
        2);
    }

    @Override
    @EventHandler
    protected ItemBase OnUse(PlayerInteractEvent e) {
        if(super.OnUse(e) instanceof PotionJump)
        {
            Player p = e.getPlayer();
            p.setVelocity(p.getVelocity().clone().multiply(0.5).add(p.getLocation().getDirection().clone().multiply(1.2)));
            p.setFallDistance(0);
        }
        return null;
    }
}
