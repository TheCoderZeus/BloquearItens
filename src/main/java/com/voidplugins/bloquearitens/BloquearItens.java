package com.voidplugins.bloquearitens;

import com.voidplugins.bloquearitens.listeners.BlockListener;
import com.voidplugins.bloquearitens.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BloquearItens extends JavaPlugin {
    private static BloquearItens instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("Desativado");
    }

    public static BloquearItens getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public void reloadPlugin() {
        configManager.reloadConfig();
    }

}
