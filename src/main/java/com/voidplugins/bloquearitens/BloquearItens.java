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
        
        try {
            this.configManager = new ConfigManager(this);
            getServer().getPluginManager().registerEvents(new BlockListener(this), this);
            
            getLogger().info("Plugin ativado com sucesso!");
            getLogger().info("Recursos carregados:");
            getLogger().info(" - Sistema de bloqueio de baús");
            getLogger().info(" - Sistema de bloqueio de bancadas");
            getLogger().info(" - Sistema de bloqueio de bigornas");
            getLogger().info(" - Sistema de bloqueio de pistões");
            getLogger().info(" - Sistema de bloqueio de alavancas");
            getLogger().info(" - Sistema de bloqueio de botões");
            getLogger().info(" - Sistema de bloqueio de placas");
            
        } catch (Exception e) {
            getLogger().severe("Erro ao inicializar: " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin desativado!");
    }

    public static BloquearItens getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public void reloadPlugin() {
        configManager.reloadConfig();
        getLogger().info("Configurações recarregadas!");
    }
}