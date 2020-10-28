package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public abstract class MessageAction implements IAction {

    private final String prefix;

    @Override
    public void execute(Player player, String args) {
        getAudience(player).sendMessage(MiniMessage.get().parse(args));
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    protected abstract Audience getAudience(Player player);
}
