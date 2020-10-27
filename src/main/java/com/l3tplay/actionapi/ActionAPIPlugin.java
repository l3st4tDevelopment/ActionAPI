package com.l3tplay.actionapi;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ActionAPIPlugin extends JavaPlugin {

    @Getter private ActionManager actionManager;

    @Override
    public void onEnable() {
        this.actionManager = new ActionManager(this);
    }

    public static ActionAPIPlugin getInstance() {
        return (ActionAPIPlugin) Bukkit.getPluginManager().getPlugin("ActionAPI");
    }
}
