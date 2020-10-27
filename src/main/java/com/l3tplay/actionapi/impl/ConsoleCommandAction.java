package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConsoleCommandAction implements IAction {

    @Override
    public void execute(Player player, String args) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args);
    }

    @Override
    public String getPrefix() {
        return "[ConsoleCommand]";
    }
}
