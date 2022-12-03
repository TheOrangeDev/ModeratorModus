package me.fred.modmodus.logger;

import me.fred.modmodus.ModModus;
import org.bukkit.entity.Player;

public class Logger {
    public static void sendConsole(String text) {
        System.out.println(text);
    }

    public static void sendPlayerError(Player p, String text){
        p.sendMessage("[" + ModModus.name + "] §c" + text);
    }

    public static void sendPlayerMessage(Player p, String text){
        p.sendMessage("[" + ModModus.name + "] §r" + text);
    }
}
