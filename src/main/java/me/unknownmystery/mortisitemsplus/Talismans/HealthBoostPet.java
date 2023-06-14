package me.unknownmystery.mortisitemsplus.Talismans;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class HealthBoostPet implements Listener {
    private final JavaPlugin plugin;
    private String petName;
    private String petLore1;
    private String petLore2;
    private String petLore3;
    private String petLore4;

    public HealthBoostPet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig7();
    }

    private void loadConfig7(){
        FileConfiguration config = plugin.getConfig();
        petName = ChatColor.translateAlternateColorCodes('&', config.getString("HealthBoost_Pet.display-name") + " ");
        petLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("HealthBoost_Pet.lore1") + " ");
        petLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("HealthBoost_Pet.lore2") + " ");
        petLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("HealthBoost_Pet.lore3") + " ");
        petLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("HealthBoost_Pet.lore4") + " ");
        plugin.getLogger().info("Loaded talisman: Regeneration Talisman");

    }
    public ItemStack healthboostPet(){
        Recipe healthCreeperPetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_healthboost_pet"));
        if (healthCreeperPetRecipe != null){
            return healthCreeperPetRecipe.getResult();
        }
        ItemStack healthboostPet = new ItemStack(Material.CREEPER_HEAD);
        ItemMeta healthboostPetItemMeta = healthboostPet.getItemMeta();
        healthboostPetItemMeta.setDisplayName(petName);
        healthboostPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> healthboostPetLore = new ArrayList<>();
        healthboostPetLore.add(" ");
        healthboostPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_PURPLE + "RARE");
        healthboostPetLore.add(ChatColor.DARK_PURPLE+ " ");
        healthboostPetLore.add(petLore1);
        healthboostPetLore.add(petLore2);
        healthboostPetLore.add(petLore3);
        healthboostPetLore.add(petLore4);
        healthboostPetItemMeta.setLore(healthboostPetLore);
        healthboostPet.setItemMeta(healthboostPetItemMeta);

        ShapedRecipe healthboostPetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_healthboost_pet"), healthboostPet);
        healthboostPetRecipe.shape("PNP", "PHP", "PPP");
        healthboostPetRecipe.setIngredient('P', Material.DIAMOND_BLOCK);
        healthboostPetRecipe.setIngredient('N', Material.NETHER_STAR);
        healthboostPetRecipe.setIngredient('H', Material.CREEPER_HEAD);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_healthboost_pet"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(healthboostPetRecipe);
        }

        return healthboostPet;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        checkItem(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        removeEffects(player);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        checkItem(player);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack item = event.getItem();
            if (item != null && item.isSimilar(healthboostPet())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place " + petName + " here!");
            }
        }
    }
    public void checkItem(Player player){
        ItemStack item = new ItemStack(Material.CREEPER_HEAD);
        ItemMeta healthboostPetItemMeta = item.getItemMeta();
        healthboostPetItemMeta.setDisplayName(petName);
        healthboostPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> healthboostPetLore = new ArrayList<>();
        healthboostPetLore.add(" ");
        healthboostPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_PURPLE + "RARE");
        healthboostPetLore.add(ChatColor.DARK_PURPLE+ " ");
        healthboostPetLore.add(petLore1);
        healthboostPetLore.add(petLore2);
        healthboostPetLore.add(petLore3);
        healthboostPetLore.add(petLore4);
        healthboostPetItemMeta.setLore(healthboostPetLore);
        item.setItemMeta(healthboostPetItemMeta);

        if (player.getInventory().containsAtLeast(item, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
        }else{
            removeEffects(player);
        }
    }

    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.REGENERATION);
    }
}
