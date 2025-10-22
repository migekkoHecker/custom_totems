package com.example.customtotems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Player;

public final class CustomTotems extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("✅ CustomTotems plugin enabled!");
    }

    @EventHandler
    public void onTotemUse(EntityResurrectEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack totem = player.getInventory().getItemInMainHand();
        if (totem.getType() != Material.TOTEM_OF_UNDYING) {
            totem = player.getInventory().getItemInOffHand();
            if (totem.getType() != Material.TOTEM_OF_UNDYING) return;
        }

        // Apply your custom potion effects
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 1));  // 30s Speed 2
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 20, 2));  // 20s Regen 3
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 15, 1));  // 15s Resistance 2

        player.getWorld().playSound(player.getLocation(), "minecraft:item.totem.use", 1f, 1f);
        player.sendMessage("§aYour Custom Totem saved you!");
    }
}
