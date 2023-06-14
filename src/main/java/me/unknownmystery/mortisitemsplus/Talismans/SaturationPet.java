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

public class SaturationPet implements Listener {

    private final JavaPlugin plugin;
    private String petName;
    private String petLore1;
    private String petLore2;
    private String petLore3;
    private String petLore4;

    public SaturationPet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig3();
    }

    private void loadConfig3(){
        FileConfiguration config = plugin.getConfig();
        petName = ChatColor.translateAlternateColorCodes('&', config.getString("Saturation_Pet.display-name") + " ");
        petLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Saturation_Pet.lore1") + " ");
        petLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Saturation_Pet.lore2") + " ");
        petLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Saturation_Pet.lore3") + " ");
        petLore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Saturation_Pet.lore4") + " ");
        plugin.getLogger().info("Loaded talisman: Saturation Talisman");

    }
    public ItemStack saturationPet(){
        Recipe saturationPigPetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_saturation_pet"));
        if (saturationPigPetRecipe != null){
            return saturationPigPetRecipe.getResult();
        }
        ItemStack pigPet = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta pigpetMeta = pigPet.getItemMeta();
        pigpetMeta.setDisplayName(petName);
        pigpetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> pigpetLore = new ArrayList<>();
        pigpetLore.add(" ");
        pigpetLore.add(ChatColor.RED + "Rarity: " + ChatColor.GREEN + "COMMON");
        pigpetLore.add(ChatColor.DARK_PURPLE+ " ");
        pigpetLore.add(petLore1);
        pigpetLore.add(petLore2);
        pigpetLore.add(petLore3);
        pigpetLore.add(petLore4);
        pigpetMeta.setLore(pigpetLore);
        pigPet.setItemMeta(pigpetMeta);

        ShapedRecipe pigPetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "item_saturation_pet"), pigPet);
        pigPetRecipe.shape("PNP", "PHP", "PPP");
        pigPetRecipe.setIngredient('P', Material.DIAMOND_BLOCK);
        pigPetRecipe.setIngredient('N', Material.NETHER_STAR);
        pigPetRecipe.setIngredient('H', Material.ZOMBIE_HEAD);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "item_saturation_pet"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(pigPetRecipe);
        }

        return pigPet;
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
            if (item != null && item.isSimilar(saturationPet())) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place " + petName + " here!");
            }
        }
    }
    public void checkItem(Player player){
        ItemStack item = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta pigpetMeta = item.getItemMeta();
        pigpetMeta.setDisplayName(petName);
        pigpetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> pigpetLore = new ArrayList<>();
        pigpetLore.add(" ");
        pigpetLore.add(ChatColor.RED + "Rarity: " + ChatColor.GREEN + "COMMON");
        pigpetLore.add(ChatColor.DARK_PURPLE+ " ");
        pigpetLore.add(petLore1);
        pigpetLore.add(petLore2);
        pigpetLore.add(petLore3);
        pigpetLore.add(petLore4);
        pigpetMeta.setLore(pigpetLore);
        item.setItemMeta(pigpetMeta);

        if (player.getInventory().containsAtLeast(item, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0));
        }else{
            removeEffects(player);
        }
    }

    public void removeEffects(Player player){
        player.removePotionEffect(PotionEffectType.SATURATION);
    }
}
