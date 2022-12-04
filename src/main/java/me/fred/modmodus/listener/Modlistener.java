package me.fred.modmodus.listener;

import me.fred.modmodus.cmds.ModModusCMD;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class Modlistener implements Listener {
    @EventHandler
    public void onPlaceEvent(BlockPlaceEvent event) {
        if (ModModusCMD.mods.contains(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onRightClick(InventoryClickEvent event) {
        if (ModModusCMD.mods.contains((Player) event.getWhoClicked())) {
            int slot = event.getSlot();
            ItemStack item = event.getWhoClicked().getInventory().getItem(slot);

            if (item.getType() == Material.BARRIER)
                ((Player) event.getWhoClicked()).performCommand("modmodus");
        }
    }
}
