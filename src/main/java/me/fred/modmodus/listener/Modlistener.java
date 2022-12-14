package me.fred.modmodus.listener;

import me.fred.modmodus.cmds.ModModusCMD;
import me.fred.modmodus.utils.InvManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;


public class Modlistener implements Listener {
    @EventHandler
    public void onModInvClick(InventoryClickEvent event) {
        try {
            if (ModModusCMD.mods.contains((Player) event.getWhoClicked())) {
                int slot = event.getSlot();
                ItemStack item = event.getWhoClicked().getInventory().getItem(slot);

                if (item.getType() == Material.BARRIER)
                    ((Player) event.getWhoClicked()).performCommand("modmodus");
            }
        } catch (Exception e) {

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

    @EventHandler
    public void onDie(PlayerDeathEvent event) {
        if (ModModusCMD.mods.contains(event.getEntity())) {
            event.setKeepInventory(true);
            event.getDrops().clear();
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            if (e.getPlayer().getOpenInventory().getTitle().equals("??6Self Options")) return;
            if (ModModusCMD.mods.contains((Player) e.getPlayer())) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getItem().getType() == Material.BEACON) {
                        SelfOptionsGuiListener selfOptionsGuiListener = new SelfOptionsGuiListener();
                        selfOptionsGuiListener.openInventory((Player) e.getPlayer());
                    }
                    if (e.getItem().getType() == Material.BARRIER) {
                        e.getPlayer().performCommand("modmodus");
                    }
                    if (e.getItem().getType() == Material.COMPASS) {
                        PlayerSelectorGuiListener playerSelectorGuiListener = new PlayerSelectorGuiListener();
                        playerSelectorGuiListener.openInventory((Player) e.getPlayer());
                    }
                }
            }
        }catch (Exception exception) {

        }
    }
}
