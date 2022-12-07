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

import java.util.Arrays;

//CREDITS https://www.spigotmc.org/wiki/creating-a-gui-inventory/
public class SelfOptionsGuiListener implements Listener{
    private final Inventory inv;

    public SelfOptionsGuiListener() {
        inv = Bukkit.createInventory(null, 9, "§6Self Options");
        initItems();

    }

    public void initItems() {
        inv.setItem(4 ,createGuiItem(Material.ENCHANTED_GOLDEN_APPLE, "Heilen", "Heile dich selbst!"));
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (ModModusCMD.mods.contains((Player) e.getWhoClicked())) {
            e.setCancelled(true);
            if (!e.getWhoClicked().getOpenInventory().getTitle().equals("§6Self Options")) return;

            final ItemStack clickedItem = e.getCurrentItem();

            if (clickedItem == null || clickedItem.getType().isAir()) return;

            final Player p = (Player) e.getWhoClicked();
            if (e.getRawSlot() == 4) {
                p.setHealth(20);
            }
        }
    }


}
