package me.fred.modmodus;

import me.fred.modmodus.cmds.ModModusCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModModus extends JavaPlugin {

    public static String name = "Mod Modus";
    @Override
    public void onEnable() {
        this.getCommand("modmodus").setExecutor(new ModModusCMD());
    }

    @Override
    public void onDisable() {

    }
}
