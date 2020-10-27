package com.l3tplay.actionapi;

import com.l3tplay.actionapi.hooks.VaultHook;
import com.l3tplay.actionapi.impl.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActionManager {

    private final JavaPlugin plugin;

    private final Set<IAction> actions = new HashSet<>();
    @Getter private BukkitAudiences audiences;

    public ActionManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.audiences = BukkitAudiences.create(plugin);

        registerActionBarActions();
        registerMessageActions();
        registerVaultActions();
        actions.add(new ConsoleCommandAction());
        actions.add(new PlayerCommandAction());
        actions.add(new SoundAction());
    }

    public void executeAction(Player player, String action) {
        actions.stream().filter(actionObject -> action.startsWith(actionObject.getPrefix())).findAny().ifPresent(actionObject ->
            actionObject.execute(player, StringUtils.removeStart(action, actionObject.getPrefix()).trim().replace("%player", player.getName())));
    }

    public void executeActions(Player player, String[] actions) {
        for (String action : actions) {
            executeAction(player, action);
        }
    }

    public void executeActions(Player player, List<String> actions) {
        executeActions(player, actions.toArray(new String[0]));
    }


    // I don't like this. I'd like to change it but I can't think of another
    // way of not creating another class for broadcasts.
    private void registerMessageActions() {
        actions.add(new MessageAction("[Message]") {
            @Override
            protected Audience getAudience(Player player) {
                return audiences.player(player);
            }
        });

        actions.add(new MessageAction("[Broadcast]") {
            @Override
            protected Audience getAudience(Player player) {
                return audiences.all();
            }
        });
    }

    private void registerVaultActions() {
        if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
            return;
        }
        VaultHook hook = new VaultHook();

        actions.add(new VaultAction("[VaultTake]", hook) {
            @Override
            public void execute(Player player, String args) {
                vaultHook.withdrawBalance(player, Double.parseDouble(args));
            }
        });

        actions.add(new VaultAction("[VaultGive]", hook) {
            @Override
            public void execute(Player player, String args) {
                vaultHook.depositBalance(player, Double.parseDouble(args));
            }
        });
    }

    private void registerActionBarActions() {
        actions.add(new ActionBarAction("[ActionBarMessage]") {
            @Override
            protected Audience getAudience(Player player) {
                return audiences.player(player);
            }
        });
        actions.add(new ActionBarAction("[ActionBarBroadcast]") {
            @Override
            protected Audience getAudience(Player player) {
                return audiences.all();
            }
        });
    }

}
