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
        //head
        giveHead(p);

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

    private static void giveHead(Player p) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName("Self Options");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Rechtsklicke das Item, um deine eigenen Optionen zu öffnen.");
        skull.setLore(lore);
        skull.setOwner(p.getName());
        item.setItemMeta(skull);
        p.getInventory().setItem(0, item);
    }

}
