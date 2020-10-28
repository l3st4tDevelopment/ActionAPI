package com.l3tplay.actionapi.hooks;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class PlaceholderHook {

    public static String parsePlaceholders(Player player, String message) {
        return PlaceholderAPI.setPlaceholders(player, message);
    }
}
