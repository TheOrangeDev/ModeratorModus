package me.fred.modmodus.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class GuiListener {
    public static void createInv(Player p) {
        Inventory help = Bukkit.getServer().createInventory(p, 4, "Player Selector");
        p.openInventory(help);
    }
}
