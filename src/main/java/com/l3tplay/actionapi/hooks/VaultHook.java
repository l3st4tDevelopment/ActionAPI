package com.l3tplay.actionapi.hooks;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook {

    private Economy economy;

    public VaultHook() {
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return;
        }

        economy = rsp.getProvider();
    }

    public void depositBalance(Player player, double balance) {
        economy.depositPlayer(player, balance);
    }

    public void withdrawBalance(Player player, double balance) {
        economy.withdrawPlayer(player, balance);
    }
}
