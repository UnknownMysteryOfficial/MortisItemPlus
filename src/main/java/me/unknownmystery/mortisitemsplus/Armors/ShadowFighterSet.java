package me.unknownmystery.mortisitemsplus.Armors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ShadowFighterSet {

    private final JavaPlugin plugin;

    private String displayName;

    private String lore1;
    private String lore2;
    private String lore3;
    private String lore4;
    private String lore5;
    private String lore6;
    private String crafter;
    private String crafterLore1;
    private String crafterLore2;
    private String crafterLore3;
    private String axedisplayname;
    private String axelore1;
    private String axelore2;
    private String axelore3;
    private String pickaxedisplayname;
    private String pickaxelore1;
    private String pickaxelore2;
    private String pickaxelore3;
    private String shoveldisplayname;
    private String shovellore1;
    private String shovellore2;
    private String shovellore3;
    private String hoedisplayname;
    private String hoelore1;
    private String hoelore2;
    private String hoelore3;
    private String helmet;
    private String helmetlore1;
    private String helmetlore2;
    private String helmetlore3;
    private String chestplate;
    private String chestplatelore1;
    private String chestplatelore2;
    private String chestplatelore3;
    private String leggings;
    private String leggingslore1;
    private String leggingslore2;
    private String leggingslore3;
    private String boots;
    private String bootslore1;
    private String bootslore2;
    private String bootslore3;





    public ShadowFighterSet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
        shadowfightSword();
    }

    private void loadConfig(){
        FileConfiguration config = plugin.getConfig();
        crafter = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.crafter") + " ");
        crafterLore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.crafter-lore1") + " ");
        crafterLore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.crafter-lore2") + " ");
        crafterLore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.crafter-lore3") + " ");
        lore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore1") + " ");
        lore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore2") + " ");
        lore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore3") + " ");
        lore4 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore4") + " ");
        lore5 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore5") + " ");
        lore6 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.lore6") + " ");
        displayName = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.display-name") + " ");
        axedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.axe-name") + " ");
        axelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.axe-lore1") + " ");
        axelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.axe-lore2") + " ");
        axelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.axe-lore3") + " ");
        pickaxedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.pickaxe-name") + " ");
        pickaxelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.pickaxe-lore1") + " ");
        pickaxelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.pickaxe-lore2") + " ");
        pickaxelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.pickaxe-lore3") + " ");
        shoveldisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.shovel-name") + " ");
        shovellore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.shovel-lore1") + " ");
        shovellore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.shovel-lore2") + " ");
        shovellore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.shovel-lore3") + " ");
        hoedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.hoe-name") + " ");
        hoelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.hoe-lore1") + " ");
        hoelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.hoe-lore2") + " ");
        hoelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.hoe-lore3") + " ");
        helmet = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dh-displayname") + " ");
        helmetlore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dh-lore1") + " ");
        helmetlore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dh-lore2") + " ");
        helmetlore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dh-lore3") + " ");
        chestplate = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dcp-displayname") + " ");
        chestplatelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dcp-lore1") + " ");
        chestplatelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dcp-lore2") + " ");
        chestplatelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dcp-lore3") + " ");
        leggings = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dl-displayname") + " ");
        leggingslore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dl-lore1") + " ");
        leggingslore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dl-lore2") + " ");
        leggingslore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.dl-lore3") + " ");
        boots = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.db-displayname") + " ");
        bootslore1 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.db-lore1") + " ");
        bootslore2 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.db-lore2") + " ");
        bootslore3 = ChatColor.translateAlternateColorCodes('&', config.getString("Shadow_Fighter.db-lore3") + " ");
        plugin.getLogger().info("Loaded set: Shadow Fighter");
    }

    public ItemStack shadowfightSword(){
        Recipe enchantedBookRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_book_recipe"));
        if (enchantedBookRecipe != null){
            return enchantedBookRecipe.getResult();
        }
        Recipe shadowDiamondRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_diamond_recipe"));
        if (shadowDiamondRecipe != null){
            return shadowDiamondRecipe.getResult();
        }
        Recipe shadowAxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_axe_recipe"));
        if (shadowAxeRecipe != null){
            return shadowAxeRecipe.getResult();
        }
        Recipe shadowPickAxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_pickaxe_recipe"));
        if (shadowPickAxeRecipe != null){
            return shadowPickAxeRecipe.getResult();
        }
        Recipe shadowShovelRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_shovel_recipe"));
        if (shadowShovelRecipe != null){
            return shadowShovelRecipe.getResult();
        }
        Recipe shadowHoeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_hoe_recipe"));
        if (shadowHoeRecipe != null){
            return shadowHoeRecipe.getResult();
        }
        Recipe shadowHelmetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_helmet_recipe"));
        if (shadowHelmetRecipe != null){
            return shadowHelmetRecipe.getResult();
        }
        Recipe shadowChestPlateRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_chestplate_recipe"));
        if (shadowChestPlateRecipe != null){
            return shadowChestPlateRecipe.getResult();
        }
        Recipe shadowLeggingsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_leggings_recipe"));
        if (shadowLeggingsRecipe != null){
            return shadowLeggingsRecipe.getResult();
        }
        Recipe shadowBootsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_boots_recipe"));
        if (shadowBootsRecipe != null){
            return shadowBootsRecipe.getResult();
        }
        // Enchantment Book:
        ItemStack enchantedbook = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta enchantedbookmeta = enchantedbook.getItemMeta();
        enchantedbookmeta.setDisplayName(ChatColor.RED + "Shadow Book");
        ArrayList<String> enchantedbookLore = new ArrayList<>();
        enchantedbookLore.add(ChatColor.GOLD + " ");
        enchantedbookLore.add(ChatColor.GOLD + "Shadow Books were used");
        enchantedbookLore.add(ChatColor.GOLD + "to craft shadow diamond");
        enchantedbookLore.add(ChatColor.GOLD + "that contains enchants.");
        enchantedbookmeta.setLore(enchantedbookLore);
        enchantedbook.setItemMeta(enchantedbookmeta);

        ShapedRecipe enchantedbookRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_book_recipe"), enchantedbook);
        enchantedbookRecipe.shape(" D ", "DFD", " D ");
        enchantedbookRecipe.setIngredient('D', Material.FLINT);
        enchantedbookRecipe.setIngredient('F', Material.BOOK);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_book_recipe"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(enchantedbookRecipe);
        }
        // Shadow Diamond:
        ItemStack shadowdiamond = new ItemStack(Material.FLINT);
        ItemMeta shadowdiamondmeta = shadowdiamond.getItemMeta();
        shadowdiamondmeta.setDisplayName(crafter);
        shadowdiamondmeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        shadowdiamondmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> shadowdiamondLore = new ArrayList<>();
        shadowdiamondLore.add(ChatColor.GOLD + " ");
        shadowdiamondLore.add(crafterLore1);
        shadowdiamondLore.add(crafterLore2);
        shadowdiamondLore.add(crafterLore3);
        shadowdiamondmeta.setLore(shadowdiamondLore);
        shadowdiamond.setItemMeta(shadowdiamondmeta);

        ShapedRecipe shadowdiamodRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_diamond_recipe"), shadowdiamond);
        shadowdiamodRecipe.shape("EDE", "DFD", "EDE");
        shadowdiamodRecipe.setIngredient('D', Material.DIAMOND);
        shadowdiamodRecipe.setIngredient('F', Material.FLINT);
        shadowdiamodRecipe.setIngredient('E', new RecipeChoice.ExactChoice(enchantedbook));

        Recipe diamondRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_diamond_recipe"));
        if (diamondRecipe == null) {
            Bukkit.addRecipe(shadowdiamodRecipe);
        }

        // Shadow Diamond Sword:
        ItemStack shadowsword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta shadowmeta = shadowsword.getItemMeta();
        shadowmeta.setDisplayName(displayName);
        shadowmeta.setUnbreakable(true);
        shadowmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        shadowmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> swordlore = new ArrayList<>();
        swordlore.add(lore1);
        swordlore.add(lore2);
        swordlore.add(lore3);
        swordlore.add(lore4);
        swordlore.add(lore5);
        swordlore.add(lore6);
        swordlore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+24.5");
        swordlore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        shadowmeta.setLore(swordlore);
        shadowmeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        shadowmeta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
        shadowmeta.addEnchant(Enchantment.SWEEPING_EDGE, 10, true);
        shadowmeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        shadowsword.setItemMeta(shadowmeta);

        ShapedRecipe shadowswordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_sword_recipe"), shadowsword);
        shadowswordRecipe.shape(" N ", " N ", " S ");
        shadowswordRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));
        shadowswordRecipe.setIngredient('S', Material.STICK);

        Recipe swordRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_sword_recipe"));
        if (swordRecipe == null) {
            Bukkit.addRecipe(shadowswordRecipe);
        }

        // Shadow Axe
        ItemStack shadowaxe = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta shadowaxeMeta = shadowaxe.getItemMeta();
        shadowaxeMeta.setDisplayName(axedisplayname);
        shadowaxeMeta.setUnbreakable(true);
        shadowaxeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowaxeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        shadowaxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        shadowaxeMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        shadowaxeMeta.addEnchant(Enchantment.LUCK, 5, true);
        ArrayList<String> shadowaxelore = new ArrayList<>();
        shadowaxelore.add(ChatColor.RED + " ");
        shadowaxelore.add(axelore1);
        shadowaxelore.add(axelore2);
        shadowaxelore.add(axelore3);
        shadowaxelore.add(ChatColor.RED + " ");
        shadowaxelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+21.5");
        shadowaxelore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        shadowaxeMeta.setLore(shadowaxelore);
        shadowaxe.setItemMeta(shadowaxeMeta);

        ShapedRecipe shadowaxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_axe_recipe"), shadowaxe);
        shadowaxeRecipe.shape(" NN", " SN", " S ");
        shadowaxeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));
        shadowaxeRecipe.setIngredient('S', Material.STICK);

        Recipe axeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_axe_recipe"));
        if (axeRecipe == null) {
            Bukkit.addRecipe(shadowaxeRecipe);
        }

        // Shadow Pickaxe
        ItemStack shadowpickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta shadowpickaxeMeta = shadowpickaxe.getItemMeta();
        shadowpickaxeMeta.setDisplayName(pickaxedisplayname);
        shadowpickaxeMeta.setUnbreakable(true);
        shadowpickaxeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowpickaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowpickaxeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        shadowpickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        shadowpickaxeMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        shadowpickaxeMeta.addEnchant(Enchantment.LUCK, 5, true);
        ArrayList<String> shadowpickaxelore = new ArrayList<>();
        shadowpickaxelore.add(ChatColor.RED + " ");
        shadowpickaxelore.add(pickaxelore1);
        shadowpickaxelore.add(pickaxelore2);
        shadowpickaxelore.add(pickaxelore3);
        shadowpickaxelore.add(ChatColor.RED + " ");
        shadowpickaxelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+17.5");
        shadowpickaxelore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1.2");
        shadowpickaxeMeta.setLore(shadowpickaxelore);
        shadowpickaxe.setItemMeta(shadowpickaxeMeta);

        ShapedRecipe shadowpickaxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_pickaxe_recipe"), shadowpickaxe);
        shadowpickaxeRecipe.shape("NNN", " S ", " S ");
        shadowpickaxeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));
        shadowpickaxeRecipe.setIngredient('S', Material.STICK);

        Recipe pickaxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_pickaxe_recipe"));
        if (pickaxeRecipe == null) {
            Bukkit.addRecipe(shadowpickaxeRecipe);
        }

        // Shadow Shovel
        ItemStack shadowshovel = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta shadowshovelMeta = shadowshovel.getItemMeta();
        shadowshovelMeta.setDisplayName(shoveldisplayname);
        shadowshovelMeta.setUnbreakable(true);
        shadowshovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowshovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowshovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        shadowshovelMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        shadowshovelMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        shadowshovelMeta.addEnchant(Enchantment.LUCK, 5, true);
        ArrayList<String> shadowshovellore = new ArrayList<>();
        shadowshovellore.add(ChatColor.RED + " ");
        shadowshovellore.add(shovellore1);
        shadowshovellore.add(shovellore2);
        shadowshovellore.add(shovellore3);
        shadowshovellore.add(ChatColor.RED + " ");
        shadowshovellore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+18");
        shadowshovellore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        shadowshovelMeta.setLore(shadowshovellore);
        shadowshovel.setItemMeta(shadowshovelMeta);

        ShapedRecipe shadowshovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_shovel_recipe"), shadowshovel);
        shadowshovelRecipe.shape(" N ", " S ", " S ");
        shadowshovelRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));
        shadowshovelRecipe.setIngredient('S', Material.STICK);

        Recipe shovelRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_shovel_recipe"));
        if (shovelRecipe == null) {
            Bukkit.addRecipe(shadowshovelRecipe);
        }

        // Shadow Hoe
        ItemStack shadowhoe = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta shadowhoeMeta = shadowhoe.getItemMeta();
        shadowhoeMeta.setDisplayName(hoedisplayname);
        shadowhoeMeta.setUnbreakable(true);
        shadowhoeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowhoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowhoeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        shadowhoeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        shadowhoeMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        shadowhoeMeta.addEnchant(Enchantment.LUCK, 5, true);
        ArrayList<String> shadowhoelore = new ArrayList<>();
        shadowhoelore.add(ChatColor.RED + " ");
        shadowhoelore.add(hoelore1);
        shadowhoelore.add(hoelore2);
        shadowhoelore.add(hoelore3);
        shadowhoelore.add(ChatColor.RED + " ");
        shadowhoelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+13.5");
        shadowhoelore.add(ChatColor.RED + "Attack Damage: " + ChatColor.GREEN + "+4");
        shadowhoeMeta.setLore(shadowhoelore);
        shadowhoe.setItemMeta(shadowhoeMeta);

        ShapedRecipe shadowhoeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_hoe_recipe"), shadowhoe);
        shadowhoeRecipe.shape("NN ", " S ", " S ");
        shadowhoeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));
        shadowhoeRecipe.setIngredient('S', Material.STICK);

        Recipe hoeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_hoe_recipe"));
        if (hoeRecipe == null) {
            Bukkit.addRecipe(shadowhoeRecipe);
        }

        // Shadow Helmet
        ItemStack shadowhelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta shadowhelmetMeta = shadowhelmet.getItemMeta();
        shadowhelmetMeta.setDisplayName(helmet);
        shadowhelmetMeta.setUnbreakable(true);
        shadowhelmetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowhelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowhelmetMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowhelmetlore = new ArrayList<>();
        shadowhelmetlore.add(ChatColor.RED + " ");
        shadowhelmetlore.add(helmetlore1);
        shadowhelmetlore.add(helmetlore2);
        shadowhelmetlore.add(helmetlore3);
        shadowhelmetlore.add(ChatColor.RED + " ");
        shadowhelmetlore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+3");
        shadowhelmetlore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        shadowhelmetMeta.setLore(shadowhelmetlore);
        shadowhelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        shadowhelmetMeta.addEnchant(Enchantment.THORNS, 5, true);
        shadowhelmetMeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
        shadowhelmetMeta.addEnchant(Enchantment.OXYGEN, 5,true);
        shadowhelmet.setItemMeta(shadowhelmetMeta);

        ShapedRecipe shadowhelmetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_helmet_recipe"), shadowhelmet);
        shadowhelmetRecipe.shape("NNN", "N N", "   ");
        shadowhelmetRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));

        Recipe helmetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_helmet_recipe"));
        if (helmetRecipe == null) {
            Bukkit.addRecipe(shadowhelmetRecipe);
        }

        // Shadow ChestPlate
        ItemStack shadowChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta shadowChestPlateMeta = shadowChestPlate.getItemMeta();
        shadowChestPlateMeta.setDisplayName(chestplate);
        shadowChestPlateMeta.setUnbreakable(true);
        shadowChestPlateMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowChestPlateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowChestPlateMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowchestplatelore = new ArrayList<>();
        shadowchestplatelore.add(ChatColor.RED + " ");
        shadowchestplatelore.add(chestplatelore1);
        shadowchestplatelore.add(chestplatelore2);
        shadowchestplatelore.add(chestplatelore3);
        shadowchestplatelore.add(ChatColor.RED + " ");
        shadowchestplatelore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+8");
        shadowchestplatelore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        shadowChestPlateMeta.setLore(shadowchestplatelore);
        shadowChestPlateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        shadowChestPlateMeta.addEnchant(Enchantment.THORNS, 5, true);
        shadowChestPlate.setItemMeta(shadowChestPlateMeta);

        ShapedRecipe shadowChestplateRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_chestplate_recipe"), shadowChestPlate);
        shadowChestplateRecipe.shape("N N", "NNN", "NNN");
        shadowChestplateRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));

        Recipe chestplateRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_chestplate_recipe"));
        if (chestplateRecipe == null) {
            Bukkit.addRecipe(shadowChestplateRecipe);
        }

        // Shadow Leggings
        ItemStack shadowleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta shadowleggingsMeta = shadowleggings.getItemMeta();
        shadowleggingsMeta.setDisplayName(leggings);
        shadowleggingsMeta.setUnbreakable(true);
        shadowleggingsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowleggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowleggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowlegingslore = new ArrayList<>();
        shadowlegingslore.add(ChatColor.RED + " ");
        shadowlegingslore.add(leggingslore1);
        shadowlegingslore.add(leggingslore2);
        shadowlegingslore.add(leggingslore3);
        shadowlegingslore.add(ChatColor.RED + " ");
        shadowlegingslore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+6");
        shadowlegingslore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        shadowleggingsMeta.setLore(shadowlegingslore);
        shadowleggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        shadowleggingsMeta.addEnchant(Enchantment.THORNS, 5, true);
        shadowleggings.setItemMeta(shadowleggingsMeta);

        ShapedRecipe shadowleggingsRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_leggings_recipe"), shadowleggings);
        shadowleggingsRecipe.shape("NNN", "N N", "N N");
        shadowleggingsRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));

        Recipe leggingsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_leggings_recipe"));
        if (leggingsRecipe == null) {
            Bukkit.addRecipe(shadowleggingsRecipe);
        }

        // Shadow Boots
        ItemStack shadowboots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta shadowbootsMeta = shadowboots.getItemMeta();
        shadowbootsMeta.setDisplayName(boots);
        shadowbootsMeta.setUnbreakable(true);
        shadowbootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        shadowbootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        shadowbootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowbootslore = new ArrayList<>();
        shadowbootslore.add(ChatColor.RED + " ");
        shadowbootslore.add(bootslore1);
        shadowbootslore.add(bootslore2);
        shadowbootslore.add(bootslore3);
        shadowbootslore.add(ChatColor.RED + " ");
        shadowbootslore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+3");
        shadowbootslore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        shadowbootsMeta.setLore(shadowbootslore);
        shadowbootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        shadowbootsMeta.addEnchant(Enchantment.THORNS, 5, true);
        shadowbootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);
        shadowbootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
        shadowbootsMeta.addEnchant(Enchantment.SOUL_SPEED, 5, true);
        shadowboots.setItemMeta(shadowbootsMeta);

        ShapedRecipe shadowbootsRecipe = new ShapedRecipe(new NamespacedKey(plugin, "shadow_boots_recipe"), shadowboots);
        shadowbootsRecipe.shape("   ", "N N", "N N");
        shadowbootsRecipe.setIngredient('N', new RecipeChoice.ExactChoice(shadowdiamond));

        Recipe bootsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "shadow_boots_recipe"));
        if (bootsRecipe == null) {
            Bukkit.addRecipe(shadowbootsRecipe);
        }

        return enchantedbook;
    }
}
