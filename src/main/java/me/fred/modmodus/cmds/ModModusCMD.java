package me.fred.modmodus.cmds;

import me.fred.modmodus.logger.Logger;
import me.fred.modmodus.utils.InvManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class ModModusCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender p, Command command, String label, String[] args) {
        if (!(p instanceof ConsoleCommandSender)) {
            if (p.hasPermission("modmodus.use")) {
                if (mods.contains(p)) {
                    mods.remove(p);
                    Logger.sendPlayerMessage((Player) p, "Du bist nun nicht mehr im Modmodus!");

                    ((Player) p).getInventory().clear();
                    ItemStack[] is = InvManager.inventory.get(((Player) p).getUniqueId());
                    int slot = -1;
                    for (int i = 0; i < is.length; i++) {
                        slot++;
                        if (!(is[i] == null))
                            ((Player) p).getInventory().setItem(slot, is[i]);

                    }
                    InvManager.inventory.remove(((Player) p).getUniqueId());
                    ((Player) p).setGameMode(GameMode.SURVIVAL);
                } else {
                    mods.add((Player) p);
                    Logger.sendPlayerMessage((Player) p, "Du bist im Modmodus!");

                    InvManager.inventory.put(((Player) p).getUniqueId(), ((Player) p).getInventory().getContents());
                    ((Player) p).getInventory().clear();
                    InvManager.givePlayerModItems(((Player) p).getPlayer());
                    ((Player) p).setGameMode(GameMode.ADVENTURE);
                    ((Player) p).setAllowFlight(true);
                    ((Player) p).setFlying(true);
                }
            } else {
                Logger.sendPlayerError((Player) p, "Du darfst das nicht!");
            }
        } else {
            Logger.sendConsole("Führe den CMD ingame aus!");
        }
        return true;
    }

    public static ArrayList<Player> mods = new ArrayList<>();

}
