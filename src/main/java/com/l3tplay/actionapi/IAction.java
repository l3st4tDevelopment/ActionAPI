package com.l3tplay.actionapi;

import org.bukkit.entity.Player;

public interface IAction {

    void execute(Player player, String args);
    String getPrefix();

}
