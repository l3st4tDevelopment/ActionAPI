package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundAction implements IAction {

    @Override
    public void execute(Player player, String args) {
        Sound sound = Sound.valueOf(args);
        player.playSound(player.getLocation(), sound, 1.0F, 1.0F);
    }

    @Override
    public String getPrefix() {
        return "[Sound]";
    }
}
