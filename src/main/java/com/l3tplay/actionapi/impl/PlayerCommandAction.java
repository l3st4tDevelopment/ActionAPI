package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import org.bukkit.entity.Player;

public class PlayerCommandAction implements IAction {

    @Override
    public void execute(Player player, String args) {
        player.performCommand(args);
    }

    @Override
    public String getPrefix() {
        return "[PlayerCommand]";
    }
}
