package AT.MSev.MAlchemy;

import AT.MSev.MAlchemy.Items.AlchemyTable;
import AT.MSev.MAlchemy.Logic.Potions.PotionJump;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MAlchemy extends JavaPlugin {
    public static NamespacedKey key;
    public static Plugin plugin;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());
        plugin = this;
        //Items and crafting
        //Alchemy Table
        AlchemyTable alchemyTable = new AlchemyTable();
        ShapedRecipe alchemyTableRecipe = new ShapedRecipe(key, alchemyTable.GetItem());
        alchemyTableRecipe.shape("DOD", "BCB", "DOD");
        alchemyTableRecipe.setIngredient('D', Material.DIAMOND);
        alchemyTableRecipe.setIngredient('O', Material.OBSIDIAN);
        alchemyTableRecipe.setIngredient('B', Material.GLASS_BOTTLE);
        alchemyTableRecipe.setIngredient('C', Material.CRAFTING_TABLE);
        alchemyTable.SetRecipe(alchemyTableRecipe);
        //

        new PotionJump();

        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
}
