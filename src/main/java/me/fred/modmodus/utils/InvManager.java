package me.fred.modmodus.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InvManager {
    public static HashMap<UUID, ItemStack[]> inventory = new HashMap<>();

    public static void givePlayerModItems(Player p) {
        //Barrier
        giveBarrier(p);
        //self-options head
        giveSelfHead(p);
        //player-selector head
        giveOtherHead(p);
    }

    private static void giveBarrier(Player p) {
        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta em = exit.getItemMeta();
        em.setDisplayName("Modmodus verlassen");
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add("Rechtsklicke das Item, um den Modmodus zu verlassen.");
        em.setLore(menuLore);
        exit.setItemMeta(em);
        p.getInventory().setItem(8, exit);
    }

    private static void giveSelfHead(Player p) {
        ItemStack exit = new ItemStack(Material.BEACON);
        ItemMeta em = exit.getItemMeta();
        em.setDisplayName("Self Options");
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add("Rechtsklicke das Item, damit du deine eigenen Optionen öffnest.");
        em.setLore(menuLore);
        exit.setItemMeta(em);
        p.getInventory().setItem(0, exit);
    }

    private static void giveOtherHead(Player p) {
        ItemStack exit = new ItemStack(Material.COMPASS);
        ItemMeta em = exit.getItemMeta();
        em.setDisplayName("Player-Selector");
        ArrayList<String> menuLore = new ArrayList<>();
        menuLore.add("Rechtsklicke das Item, um einen Spieler auszuwählen.");
        em.setLore(menuLore);
        exit.setItemMeta(em);
        p.getInventory().setItem(4, exit);
    }
}
