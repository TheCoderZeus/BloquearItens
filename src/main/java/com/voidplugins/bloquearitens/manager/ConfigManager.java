package com.voidplugins.bloquearitens.manager;

import com.voidplugins.bloquearitens.BloquearItens;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final BloquearItens plugin;
    private FileConfiguration config;

    public ConfigManager(BloquearItens plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        reloadConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public boolean isAutoActivateEnabled() {
        return config.getBoolean("auto-ativar", true);
    }

    public boolean isBlocked(String type) {
        return config.getBoolean("bloqueios." + type + ".ativado", true);
    }

    public String getMessage(String type) {
        String message = config.getString("bloqueios." + type + ".mensagem", "&cVocê não tem permissão para fazer isso!");
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public boolean isWorldAllowed(String worldName) {
        return config.getStringList("mundos-permitidos").contains(worldName);
    }
}