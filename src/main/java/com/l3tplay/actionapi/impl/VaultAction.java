package com.l3tplay.actionapi.impl;

import com.l3tplay.actionapi.IAction;
import com.l3tplay.actionapi.hooks.VaultHook;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class VaultAction implements IAction {

    private final String prefix;
    protected final VaultHook vaultHook;

    @Override
    public String getPrefix() {
        return prefix;
    }
}
