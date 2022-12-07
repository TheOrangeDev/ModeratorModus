package me.fred.modmodus.listener;

import me.fred.modmodus.cmds.ModModusCMD;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;

//CREDITS https://www.spigotmc.org/wiki/creating-a-gui-inventory/
public class PlayerSelectorGuiListener implements Listener{
    private final Inventory inv;

    public PlayerSelectorGuiListener() {
        inv = Bukkit.createInventory(null, 9, "§4Player Selector");
        initItems();

    }

    private static ArrayList<Player> selected_player = new ArrayList<>();
    public void initItems() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            inv.addItem(createGuiHead(p, "Auch bekannt als: " + p.getDisplayName()));
        }
    }

    protected ItemStack createGuiHead(Player p, String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName("Player-Selector");
        skull.setOwner(p.getName());
        skull.setLore(Arrays.asList(lore));
        item.setItemMeta(skull);

        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (ModModusCMD.mods.contains((Player) e.getWhoClicked())) {
            e.setCancelled(true);
            if (!e.getWhoClicked().getOpenInventory().getTitle().equals("§4Player Selector")) return;

            final ItemStack clickedItem = e.getCurrentItem();

            if (clickedItem == null || clickedItem.getType().isAir()) return;

            final Player p = (Player) e.getWhoClicked();

        }
    }




}
