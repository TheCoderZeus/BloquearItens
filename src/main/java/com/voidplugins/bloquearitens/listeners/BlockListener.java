package com.voidplugins.bloquearitens.listeners;

import com.voidplugins.bloquearitens.BloquearItens;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener implements Listener {
    private final BloquearItens plugin;

    public BlockListener(BloquearItens plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!plugin.getConfigManager().isAutoActivateEnabled()) {
            return;
        }

        if (!plugin.getConfigManager().isWorldAllowed(event.getPlayer().getWorld().getName())) {
            return;
        }

        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (block == null) return;

        if ((block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST) 
                && plugin.getConfigManager().isBlocked("bau") 
                && !player.hasPermission("bloquearitens.bypass.bau")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("bau"));
            return;
        }

        if (block.getType() == Material.WORKBENCH 
                && plugin.getConfigManager().isBlocked("craftingtable")
                && !player.hasPermission("bloquearitens.bypass.craftingtable")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("craftingtable"));
            return;
        }

        if (block.getType() == Material.ANVIL 
                && plugin.getConfigManager().isBlocked("bigorna")
                && !player.hasPermission("bloquearitens.bypass.bigorna")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("bigorna"));
            return;
        }

        if (block.getType() == Material.DISPENSER 
                && plugin.getConfigManager().isBlocked("dispensador")
                && !player.hasPermission("bloquearitens.bypass.dispensador")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("dispensador"));
            return;
        }

        if (block.getType() == Material.DROPPER 
                && plugin.getConfigManager().isBlocked("dropper")
                && !player.hasPermission("bloquearitens.bypass.dropper")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("dropper"));
            return;
        }

        if (block.getType() == Material.HOPPER 
                && plugin.getConfigManager().isBlocked("funil")
                && !player.hasPermission("bloquearitens.bypass.funil")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("funil"));
            return;
        }

        if ((block.getType() == Material.FENCE_GATE || block.getType() == Material.IRON_FENCE)
                && plugin.getConfigManager().isBlocked("portao")
                && !player.hasPermission("bloquearitens.bypass.portao")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("portao"));
            return;
        }

        if ((block.getType() == Material.WOODEN_DOOR || block.getType() == Material.IRON_DOOR_BLOCK)
                && plugin.getConfigManager().isBlocked("porta")
                && !player.hasPermission("bloquearitens.bypass.porta")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("porta"));
            return;
        }

        if ((block.getType() == Material.LEVER && plugin.getConfigManager().isBlocked("alavanca") 
                && !player.hasPermission("bloquearitens.bypass.alavanca")) ||
            (block.getType() == Material.STONE_BUTTON || block.getType() == Material.WOOD_BUTTON) 
                && plugin.getConfigManager().isBlocked("botao")
                && !player.hasPermission("bloquearitens.bypass.botao")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage(
                block.getType() == Material.LEVER ? "alavanca" : "botao"));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!plugin.getConfigManager().isAutoActivateEnabled()) {
            return;
        }

        if (!plugin.getConfigManager().isWorldAllowed(event.getPlayer().getWorld().getName())) {
            return;
        }

        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (block.getType() == Material.TNT 
                && plugin.getConfigManager().isBlocked("tnt")
                && !player.hasPermission("bloquearitens.bypass.tnt")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("tnt"));
            return;
        }

        if ((block.getType() == Material.REDSTONE_WIRE || block.getType() == Material.REDSTONE_TORCH_ON 
                || block.getType() == Material.REDSTONE_TORCH_OFF || block.getType() == Material.REDSTONE_BLOCK)
                && plugin.getConfigManager().isBlocked("redstone")
                && !player.hasPermission("bloquearitens.bypass.redstone")) {
            event.setCancelled(true);
            player.sendMessage(plugin.getConfigManager().getMessage("redstone"));
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRedstone(BlockRedstoneEvent event) {
        if (!plugin.getConfigManager().isAutoActivateEnabled()) {
            return;
        }

        if (!plugin.getConfigManager().isWorldAllowed(event.getBlock().getWorld().getName())) {
            return;
        }

        Block block = event.getBlock();

        if (plugin.getConfigManager().isBlocked("redstone")) {
            event.setNewCurrent(0);
            return;
        }

        if (plugin.getConfigManager().isBlocked("pistao")) {
            if (block.getType() == Material.PISTON_BASE || 
                block.getType() == Material.PISTON_STICKY_BASE ||
                block.getType() == Material.PISTON_EXTENSION || 
                block.getType() == Material.PISTON_MOVING_PIECE) {
                event.setNewCurrent(event.getOldCurrent());
            }
        }

        if (plugin.getConfigManager().isBlocked("placas")) {
            if (block.getType() == Material.STONE_PLATE || 
                block.getType() == Material.WOOD_PLATE ||
                block.getType() == Material.GOLD_PLATE || 
                block.getType() == Material.IRON_PLATE) {
                event.setNewCurrent(event.getOldCurrent());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityExplode(EntityExplodeEvent event) {
        if (!plugin.getConfigManager().isAutoActivateEnabled()) {
            return;
        }

        if (!plugin.getConfigManager().isWorldAllowed(event.getLocation().getWorld().getName())) {
            return;
        }

        if (plugin.getConfigManager().isBlocked("tnt")) {
            Entity entity = event.getEntity();
            if (entity.getType() == EntityType.PRIMED_TNT || 
                entity.getType() == EntityType.MINECART_TNT) {
                event.setCancelled(true);
            }
        }
    }
}