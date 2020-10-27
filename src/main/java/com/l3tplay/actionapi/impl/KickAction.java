package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class KickAction implements IAction {

    @Override
    public void execute(Player player, String args) {
        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', args));
    }

    @Override
    public String getPrefix() {
        return "[Kick]";
    }
}
