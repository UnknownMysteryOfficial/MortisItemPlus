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

public class AbsorptionPet implements Listener {
    private final JavaPlugin plugin;
    private String petName;
    private String petLore1;
    private String petLore2;
    private String petLore3;
    private String petLore4;

    public AbsorptionPet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig5();
    }

    private void loadConfig5(){
        FileConfiguration config = plugin.getConfig();
        petName = ChatColor.translateAlternateColorCodes('&', config.getString("Absorption_Pet.display-name") + " ");
        petLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Absorption_Pet.lore1") + " ");
        petLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Absorption_Pet.lore2") + " ");
        petLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Absorption_Pet.lore3") + " ");
        petLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Absorption_Pet.lore4") + " ");
        plugin.getLogger().info("Loaded talisman: Absorption Talisman");

    }
    public ItemStack absorptionPet(){
        Recipe absorptionPigPetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_absorption_pet"));
        if (absorptionPigPetRecipe != null){
            return absorptionPigPetRecipe.getResult();
        }
        ItemStack absorptionPet = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta absorptionPetItemMeta = absorptionPet.getItemMeta();
        absorptionPetItemMeta.setDisplayName(petName);
        absorptionPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> absorptionPetLore = new ArrayList<>();
        absorptionPetLore.add(" ");
        absorptionPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_GREEN + "UNCOMMON");
        absorptionPetLore.add(ChatColor.DARK_PURPLE+ " ");
        absorptionPetLore.add(petLore1);
        absorptionPetLore.add(petLore2);
        absorptionPetLore.add(petLore3);
        absorptionPetLore.add(petLore4);
        absorptionPetItemMeta.setLore(absorptionPetLore);
        absorptionPet.setItemMeta(absorptionPetItemMeta);

        ShapedRecipe absorptionPetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_absorption_pet"), absorptionPet);
        absorptionPetRecipe.shape("PNP", "PHP", "PPP");
        absorptionPetRecipe.setIngredient('P', Material.DIAMOND_BLOCK);
        absorptionPetRecipe.setIngredient('N', Material.NETHER_STAR);
        absorptionPetRecipe.setIngredient('H', Material.WITHER_SKELETON_SKULL);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_absorption_pet"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(absorptionPetRecipe);
        }

        return absorptionPet;
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
            if (item != null && item.isSimilar(absorptionPet())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place " + petName + " here!");
            }
        }
    }
    public void checkItem(Player player){
        ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta absorptionPetItemMeta = item.getItemMeta();
        absorptionPetItemMeta.setDisplayName(petName);
        absorptionPetItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> absorptionPetLore = new ArrayList<>();
        absorptionPetLore.add(" ");
        absorptionPetLore.add(ChatColor.RED + "Rarity: " + ChatColor.DARK_GREEN + "UNCOMMON");
        absorptionPetLore.add(ChatColor.DARK_PURPLE+ " ");
        absorptionPetLore.add(petLore1);
        absorptionPetLore.add(petLore2);
        absorptionPetLore.add(petLore3);
        absorptionPetLore.add(petLore4);
        absorptionPetItemMeta.setLore(absorptionPetLore);
        item.setItemMeta(absorptionPetItemMeta);

        if (player.getInventory().containsAtLeast(item, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 0));
        }else{
            removeEffects(player);
        }
    }

    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.ABSORPTION);
    }
}