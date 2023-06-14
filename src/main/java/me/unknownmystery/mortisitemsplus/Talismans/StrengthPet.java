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

public class StrengthPet implements Listener {
    private final JavaPlugin plugin;
    private String petName;
    private String petLore1;
    private String petLore2;
    private String petLore3;
    private String petLore4;

    public StrengthPet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig4();
    }

    private void loadConfig4(){
        FileConfiguration config = plugin.getConfig();
        petName = ChatColor.translateAlternateColorCodes('&', config.getString("Strength_Pet.display-name") + " ");
        petLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Strength_Pet.lore1") + " ");
        petLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Strength_Pet.lore2") + " ");
        petLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Strength_Pet.lore3") + " ");
        petLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Strength_Pet.lore4") + " ");
        plugin.getLogger().info("Loaded talisman: Strength Talisman");
    }
    public ItemStack strengthPet(){
        Recipe strengthDragonPetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_strength_pet"));
        if (strengthDragonPetRecipe != null){
            return strengthDragonPetRecipe.getResult();
        }
        ItemStack strengthPet = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta strengthPetItemMeta = strengthPet.getItemMeta();
        strengthPetItemMeta.setDisplayName(petName);
        strengthPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> strengthPetLore = new ArrayList<>();
        strengthPetLore.add(" ");
        strengthPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_PURPLE + "RARE");
        strengthPetLore.add(ChatColor.DARK_PURPLE+ " ");
        strengthPetLore.add(petLore1);
        strengthPetLore.add(petLore2);
        strengthPetLore.add(petLore3);
        strengthPetLore.add(petLore4);
        strengthPetItemMeta.setLore(strengthPetLore);
        strengthPet.setItemMeta(strengthPetItemMeta);

        ShapedRecipe strengthPetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_strength_pet"), strengthPet);
        strengthPetRecipe.shape("PNP", "PHP", "PPP");
        strengthPetRecipe.setIngredient('P', Material.DIAMOND_BLOCK);
        strengthPetRecipe.setIngredient('N', Material.NETHER_STAR);
        strengthPetRecipe.setIngredient('H', Material.DRAGON_HEAD);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_strength_pet"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(strengthPetRecipe);
        }

        return strengthPet;
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
            if (item != null && item.isSimilar(strengthPet())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place " + petName + " here!");
            }
        }
    }
    public void checkItem(Player player){
        ItemStack item = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta strengthPetItemMeta = item.getItemMeta();
        strengthPetItemMeta.setDisplayName(petName);
        strengthPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> strengthPetLore = new ArrayList<>();
        strengthPetLore.add(" ");
        strengthPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_PURPLE + "RARE");
        strengthPetLore.add(ChatColor.DARK_PURPLE+ " ");
        strengthPetLore.add(petLore1);
        strengthPetLore.add(petLore2);
        strengthPetLore.add(petLore3);
        strengthPetLore.add(petLore4);
        strengthPetItemMeta.setLore(strengthPetLore);
        item.setItemMeta(strengthPetItemMeta);

        if (player.getInventory().containsAtLeast(item, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3));
        }else{
            removeEffects(player);
        }
    }

    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    }
}
