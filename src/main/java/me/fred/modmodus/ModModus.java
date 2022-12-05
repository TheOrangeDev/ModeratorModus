package me.fred.modmodus;

import me.fred.modmodus.cmds.ModModusCMD;
import me.fred.modmodus.listener.Modlistener;
import me.fred.modmodus.listener.GuiListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModModus extends JavaPlugin {

    public static String name = "Mod Modus";
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Modlistener(), this);
        this.getCommand("modmodus").setExecutor(new ModModusCMD());
    }

    @Override
    public void onDisable() {

    }
}
