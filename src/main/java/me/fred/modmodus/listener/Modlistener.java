package me.fred.modmodus.listener;

import me.fred.modmodus.cmds.ModModusCMD;
import me.fred.modmodus.utils.InvManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;


public class Modlistener implements Listener {
    @EventHandler
    public void onModInvClick(InventoryClickEvent event) {
        if (ModModusCMD.mods.contains((Player) event.getWhoClicked())) {
            int slot = event.getSlot();
            ItemStack item = event.getWhoClicked().getInventory().getItem(slot);

            if (item.getType() == Material.BARRIER)
                ((Player) event.getWhoClicked()).performCommand("modmodus");
            if (item.getType() == Material.PLAYER_HEAD) {
                if (item.getItemMeta().getDisplayName().equals("Self Options")) {
                    SelfOptionsGuiListener selfOptionsGuiListener = new SelfOptionsGuiListener();
                    selfOptionsGuiListener.openInventory(((Player) event.getWhoClicked()).getPlayer());
                } else {

                }
            }
        }
    }

    @EventHandler
    public void onModLeave(PlayerQuitEvent event) {
        if (ModModusCMD.mods.contains(Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer())) {
            ModModusCMD.mods.remove(Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer());
            Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer().getInventory().clear();
            ItemStack[] is = InvManager.inventory.get((Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer()).getUniqueId());
            int slot = -1;
            for (int i = 0; i < is.length; i++) {
                slot++;
                if (!(is[i] == null))
                    Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer().getInventory().setItem(slot, is[i]);

            }
            InvManager.inventory.remove((Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer()).getUniqueId());
            Bukkit.getServer().getOfflinePlayer(event.getPlayer().getUniqueId()).getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }
}
