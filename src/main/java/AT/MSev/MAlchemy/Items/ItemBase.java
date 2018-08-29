package AT.MSev.MAlchemy.Items;

import AT.MSev.MAlchemy.MAlchemy;
import AT.MSev.MAlchemy.Utils.EUT;
import AT.MSev.MAlchemy.Utils.NBTManager;
import net.minecraft.server.v1_13_R2.NBTBase;
import net.minecraft.server.v1_13_R2.NBTTagString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;

public class ItemBase implements Listener {

    static ArrayList<ItemBase> All = new ArrayList<ItemBase>();
    ItemStack Item;
    protected int Id;

    public ItemBase(int id, Material appearance, String itemName, ArrayList<String> lore) {
        Id = id;
        Item = new ItemStack(appearance);
        EUT.ItemRename(Item, itemName);
        if (lore != null) {
            EUT.ItemRelore(Item, lore);
        }
        SetTag("name", new NBTTagString(itemName));
        All.add(this);
        Bukkit.getPluginManager().registerEvents(this, MAlchemy.plugin);
    }

    public void SetRecipe(ShapedRecipe recipe) {
        Bukkit.getServer().addRecipe(recipe);
    }

    public void SetTag(String key, NBTBase tag) {
        Item = NBTManager.AddItemNBT(Item, key, tag);
    }

    public Boolean TagEquals(String key, NBTBase check) {
        return NBTManager.GetTag(Item, key).equals(check);
    }

    public ItemStack GetItem() {
        return Item;
    }

    static public ItemBase GetFromIS(ItemStack is) {
        for (ItemBase ib :
                All) {
            if (ib.TagEquals("name", NBTManager.GetTag(is, "name"))) {
                return ib;
            }
        }
        return null;
    }

    static public ItemBase GetFromId(int id)
    {
        for (ItemBase ib :
                All) {
            if (ib.Id == id) {
                return ib;
            }
        }
        return null;
    }

    public void Give(Player player, int amount)
    {
        for(int i = 0;i<amount;i++)
            player.getInventory().addItem(GetItem());
    }

    @EventHandler
    protected ItemBase OnUse(PlayerInteractEvent e)
    {
        ItemBase ib = null;
        if( (ib = GetFromIS(e.getItem())) !=null)
        {
            return ib;
        }
        return null;
    }
}
