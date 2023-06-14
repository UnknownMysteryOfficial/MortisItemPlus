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

public class SpeedPet implements Listener {
    private final JavaPlugin plugin;
    private String petName;
    private String petLore1;
    private String petLore2;
    private String petLore3;
    private String petLore4;

    public SpeedPet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig6();
    }

    private void loadConfig6(){
        FileConfiguration config = plugin.getConfig();
        petName = ChatColor.translateAlternateColorCodes('&', config.getString("Speed_Pet.display-name") + " ");
        petLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Speed_Pet.lore1") + " ");
        petLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Speed_Pet.lore2") + " ");
        petLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Speed_Pet.lore3") + " ");
        petLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Speed_Pet.lore4") + " ");
        plugin.getLogger().info("Loaded talisman: Speed Talisman");

    }
    public ItemStack speedPet(){
        Recipe speedSkeletonPetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_speed_pet"));
        if (speedSkeletonPetRecipe != null){
            return speedSkeletonPetRecipe.getResult();
        }
        ItemStack speedPet = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta speedPetItemMeta = speedPet.getItemMeta();
        speedPetItemMeta.setDisplayName(petName);
        speedPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> speedPetLore = new ArrayList<>();
        speedPetLore.add(" ");
        speedPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.GREEN + "COMMON");
        speedPetLore.add(ChatColor.DARK_PURPLE+ " ");
        speedPetLore.add(petLore1);
        speedPetLore.add(petLore2);
        speedPetLore.add(petLore3);
        speedPetLore.add(petLore4);
        speedPetItemMeta.setLore(speedPetLore);
        speedPet.setItemMeta(speedPetItemMeta);

        ShapedRecipe speedPetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_speed_pet"), speedPet);
        speedPetRecipe.shape("PNP", "PHP", "PPP");
        speedPetRecipe.setIngredient('P', Material.DIAMOND_BLOCK);
        speedPetRecipe.setIngredient('N', Material.NETHER_STAR);
        speedPetRecipe.setIngredient('H', Material.SKELETON_SKULL);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_speed_pet"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(speedPetRecipe);
        }

        return speedPet;
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
            if (item != null && item.isSimilar(speedPet())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place " + petName + " here!");
            }
        }
    }
    public void checkItem(Player player){
        ItemStack item = new ItemStack(Material.SKELETON_SKULL);
        ItemMeta speedPetItemMeta = item.getItemMeta();
        speedPetItemMeta.setDisplayName(petName);
        speedPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> speedPetLore = new ArrayList<>();
        speedPetLore.add(" ");
        speedPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.GREEN + "COMMON");
        speedPetLore.add(ChatColor.DARK_PURPLE+ " ");
        speedPetLore.add(petLore1);
        speedPetLore.add(petLore2);
        speedPetLore.add(petLore3);
        speedPetLore.add(petLore4);
        speedPetItemMeta.setLore(speedPetLore);
        item.setItemMeta(speedPetItemMeta);

        if (player.getInventory().containsAtLeast(item, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        }else{
            removeEffects(player);
        }
    }

    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.SPEED);
    }
}
