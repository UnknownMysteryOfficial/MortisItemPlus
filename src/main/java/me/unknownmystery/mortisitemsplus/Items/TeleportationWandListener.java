package me.unknownmystery.mortisitemsplus.Items;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderPearl;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeleportationWandListener implements Listener {

    private final JavaPlugin plugin;
    private String wandName;
    private String wandLore1;
    private String wandLore2;
    private String wandLore3;
    private int cooldownSeconds;
    private Map<Player, Long> cooldownMap;

    public TeleportationWandListener(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
        cooldownMap = new HashMap<>();
    }

    private void loadConfig() {
        FileConfiguration config = plugin.getConfig();
        wandName = ChatColor.translateAlternateColorCodes('&', config.getString("Teleport_Wand.display-name") + " ");
        wandLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Teleport_Wand.lore1") + " ");
        wandLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Teleport_Wand.lore2") + " ");
        wandLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Teleport_Wand.lore3") + " ");
        cooldownSeconds = config.getInt("Teleport_Wand.cooldown", 5);
        plugin.getLogger().info("Loaded item: Teleportation Wand");
    }

    public ItemStack createTeleportWandRecipe() {
        Recipe teleportWandRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_teleport_wand"));
        if (teleportWandRecipe != null) {
            return teleportWandRecipe.getResult();
        }

        ItemStack teleportWand = new ItemStack(Material.BLAZE_ROD);
        ItemMeta wandMeta = teleportWand.getItemMeta();
        wandMeta.setDisplayName(wandName);
        wandMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wandMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> wandLore = new ArrayList<>();
        wandLore.add(ChatColor.RED + " ");
        wandLore.add(wandLore1);
        wandLore.add(wandLore2);
        wandLore.add(wandLore3);
        wandMeta.setLore(wandLore);
        teleportWand.setItemMeta(wandMeta);

        NamespacedKey wandKey = new NamespacedKey(plugin, "item_teleport_wand");
        ShapedRecipe wandRecipe = new ShapedRecipe(wandKey, teleportWand);
        wandRecipe.shape(" E ", " R ", " R ");
        wandRecipe.setIngredient('E', Material.ENDER_PEARL);
        wandRecipe.setIngredient('R', Material.BLAZE_ROD);

        Recipe existingRecipe = Bukkit.getRecipe(wandKey);
        if (existingRecipe == null) {
            Bukkit.addRecipe(wandRecipe);
        }

        return teleportWand;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return; // Only execute the teleportation logic on right-click actions
        }

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.BLAZE_ROD && isTeleportWand(item) && player.hasPermission("mortisitemplus.teleportationwand")) {
            if (!canUseWand(player)) {
                player.sendMessage(ChatColor.RED + "You must wait before using the teleportation wand again.");
                return;
            }

            player.launchProjectile(EnderPearl.class); // Throws an ender pearl

            startCooldown(player);
        }
    }

    private boolean isTeleportWand(ItemStack item) {
        if (item == null || item.getType() != Material.BLAZE_ROD) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }

        String displayName = meta.getDisplayName();
        if (displayName == null || !displayName.equals(wandName)) {
            return false;
        }

        List<String> lore = meta.getLore();
        if (lore == null || !lore.equals(getTeleportWandLore())) {
            return false;
        }

        return true;
    }

    private List<String> getTeleportWandLore() {
        ArrayList<String> wandLore = new ArrayList<>();
        wandLore.add(ChatColor.RED + " ");
        wandLore.add(wandLore1);
        wandLore.add(wandLore2);
        wandLore.add(wandLore3);
        return wandLore;
    }

    private boolean canUseWand(Player player) {
        if (cooldownMap.containsKey(player)) {
            long lastUseTime = cooldownMap.get(player);
            long currentTime = System.currentTimeMillis();
            long cooldownMillis = cooldownSeconds * 1000;
            return currentTime - lastUseTime >= cooldownMillis;
        }
        return true;
    }

    private void startCooldown(Player player) {
        cooldownMap.put(player, System.currentTimeMillis());
    }
}
