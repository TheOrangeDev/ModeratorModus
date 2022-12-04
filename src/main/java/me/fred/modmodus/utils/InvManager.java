package me.fred.modmodus.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InvManager {
    public static HashMap<UUID, ItemStack[]> inventory = new HashMap<>();

    public static void givePlayerModItems(Player p) {
        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta em = exit.getItemMeta();
        em.setDisplayName("Modmodus verlassen");
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add("Rechtsklicke das Item, um den Modmodus zu verlassen.");
        em.setLore(menuLore);

        exit.setItemMeta(em);
        p.getInventory().setItem(8, exit);
    }

}
