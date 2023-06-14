package me.unknownmystery.mortisitemsplus.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LightningBowListener implements Listener {

    private final JavaPlugin plugin;

    private String bowName;
    private String bowLore1;
    private String bowLore2;
    private String bowLore3;
    private String bowLore4;
    private int cooldownSeconds;
    private Map<UUID, Long> cooldownMap;

    public LightningBowListener(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig7();
        this.cooldownMap = new HashMap<>();
    }

    private void loadConfig7() {
        FileConfiguration config = plugin.getConfig();
        bowName = ChatColor.translateAlternateColorCodes('&', config.getString("Lightning_Bow.display-name") + " ");
        bowLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Lightning_Bow.lore1") + " ");
        bowLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Lightning_Bow.lore2") + " ");
        bowLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Lightning_Bow.lore3") + " ");
        bowLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Lightning_Bow.lore4") + " ");
        cooldownSeconds = config.getInt("Lightning_Bow.cooldown", 5);
        plugin.getLogger().info("Loaded item: Lightning Bow");
    }

    public ItemStack lightningBow() {
        Recipe lightningBowRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_lightning_bow"));
        if (lightningBowRecipe != null) {
            return lightningBowRecipe.getResult();
        }

        ItemStack lightningBow = new ItemStack(Material.BOW);
        ItemMeta lightningBowMeta = lightningBow.getItemMeta();
        lightningBowMeta.setDisplayName(bowName);
        lightningBowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        lightningBowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        lightningBowMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        lightningBowMeta.setUnbreakable(true);
        lightningBowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lightningBowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lightningBowMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> lightningBowLore = new ArrayList<>();
        lightningBowLore.add(ChatColor.GREEN + " ");
        lightningBowLore.add(bowLore1);
        lightningBowLore.add(bowLore2);
        lightningBowLore.add(bowLore3);
        lightningBowLore.add(bowLore4);
        lightningBowMeta.setLore(lightningBowLore);
        lightningBow.setItemMeta(lightningBowMeta);

        ShapedRecipe lightningbowRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_lightning_bow"), lightningBow);
        lightningbowRecipe.shape(" N ", "PBP", " P ");
        lightningbowRecipe.setIngredient('N', Material.NETHER_STAR);
        lightningbowRecipe.setIngredient('P', Material.BLAZE_POWDER);
        lightningbowRecipe.setIngredient('B', Material.BOW);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_lightning_bow"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(lightningbowRecipe);
        }

        return lightningBow;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow && event.getEntity() instanceof Player) {
            Arrow arrow = (Arrow) event.getDamager();
            Player player = (Player) event.getEntity();
            if (arrow.getShooter() instanceof Player && isCustomBow(((Player) arrow.getShooter()).getEquipment().getItemInMainHand()) && player.hasPermission("mortisitemplus.lightningbow")) {
                if (hasCooldown(player)) {
                    event.setCancelled(true);
                    return;
                }
                player.getWorld().strikeLightning(player.getLocation());
                startCooldown(player);
            }
        }
    }

    private boolean isCustomBow(ItemStack item) {
        if (item == null || item.getType() != Material.BOW) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }

        String displayName = meta.getDisplayName();
        if (displayName == null || !displayName.equals(bowName)) {
            return false;
        }

        List<String> lore = meta.getLore();
        if (lore == null || !lore.contains(bowLore1) || !lore.contains(bowLore2) ||
                !lore.contains(bowLore3) || !lore.contains(bowLore4)) {
            return false;
        }

        return true;
    }

    private boolean hasCooldown(Player player) {
        UUID playerId = player.getUniqueId();
        if (cooldownMap.containsKey(playerId)) {
            long currentTime = System.currentTimeMillis();
            long cooldownTime = cooldownMap.get(playerId);
            long remainingTime = cooldownTime - currentTime;
            if (remainingTime > 0) {
                player.sendMessage(ChatColor.RED + "You must wait " + formatTime(remainingTime) + " before using this again.");
                return true;
            } else {
                cooldownMap.remove(playerId); // Remove expired cooldown
            }
        }
        return false;
    }


    private void startCooldown(Player player) {
        UUID playerId = player.getUniqueId();
        long cooldownTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(cooldownSeconds);
        cooldownMap.put(playerId, cooldownTime);

        new BukkitRunnable() {
            final Player cooldownPlayer = player; // Store the player reference in the Runnable

            @Override
            public void run() {
                cooldownMap.remove(playerId);
                cooldownPlayer.sendMessage(ChatColor.GREEN + "The Lightning Bow cooldown has ended. You can use it again.");
            }
        }.runTaskLater(plugin, cooldownSeconds * 20); // Convert seconds to ticks
    }


    private String formatTime(long millis) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long hours = TimeUnit.MILLISECONDS.toHours(millis) % 24;
        StringBuilder sb = new StringBuilder();
        if (hours > 0) {
            sb.append(hours).append("h ");
        }
        if (minutes > 0) {
            sb.append(minutes).append("m ");
        }
        sb.append(seconds).append("s");
        return sb.toString();
    }
}
