package AT.MSev.MAlchemy.Logic.Potions;

import AT.MSev.MAlchemy.Items.ItemBase;
import AT.MSev.MAlchemy.Logic.Alchemist.Alchemist;
import AT.MSev.MAlchemy.Logic.Alchemist.Ingredient;
import AT.MSev.MAlchemy.Utils.EUT;
import AT.MSev.MAlchemy.Utils.NBTManager;
import net.minecraft.server.v1_13_R2.NBTTagInt;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PotionBase extends ItemBase {
    public static ArrayList<PotionBase> All = new ArrayList<PotionBase>();

    public PotionBase(int id, Material appearance, String itemName, ArrayList<String> lore, ArrayList<Ingredient> cost, int amount) {
        super(id, appearance, itemName, lore);
        Cost = cost;
        Amount = amount;
        All.add(this);
    }

    protected ArrayList<Ingredient> Cost;
    int Amount = 1;

    //When crafted
    public void Craft(Alchemist crafter)
    {
        if(crafter.Inventory.Contains(Cost))
        {
            for(int i=0;i<Amount;i++)
            crafter.Parent.getInventory().addItem(this.GetItem());

            for (Ingredient ing:
                 Cost) {
                crafter.Inventory.Remove(ing);
            }
        }
    }

    //How the item is displayed in the crafting interface
    public ItemStack Image(Alchemist crafter)
    {
        ItemStack item = new ItemStack(GetItem().getType(), Amount);
        EUT.ItemRename(item, "Craft: " + GetItem().getItemMeta().getDisplayName());
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("Ingredients");
        for (Ingredient ing:
             Cost) {
            ingredients.add(ing.Family + ":" + ing.Amount + " ; " + crafter.Inventory.GetAmount(ing.Family));
        }
        EUT.ItemRelore(item, ingredients);

        item = NBTManager.AddItemNBT(item, "craftid", new NBTTagInt(Id));

        return item;
    }
}
