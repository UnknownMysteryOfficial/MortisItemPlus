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

public class SteelBornSet {

    private final JavaPlugin plugin;
    private String sbheartdisplay;
    private String lore1;
    private String lore2;
    private String lore3;
    private String lore4;
    private String crafter;
    private String crafterlore1;
    private String crafterlore2;
    private String crafterlore3;
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



    public SteelBornSet(JavaPlugin plugin) {
        this.plugin = plugin;
        loadConfig2();
    }

    private void loadConfig2(){
        FileConfiguration config = plugin.getConfig();
        sbheartdisplay = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.display-name") + " ");
        lore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.lore1") + " ");
        lore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.lore2") + " ");
        lore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.lore3") + " ");
        lore4 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.lore4") + " ");
        crafter = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.crafter") + " ");
        crafterlore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.crafter-lore1") + " ");
        crafterlore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.crafter-lore2") + " ");
        crafterlore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.crafter-lore3") + " ");
        axedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.axe-name") + " ");
        axelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.axe-lore1") + " ");
        axelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.axe-lore2") + " ");
        axelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.axe-lore3") + " ");
        pickaxedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.pickaxe-name") + " ");
        pickaxelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.pickaxe-lore1") + " ");
        pickaxelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.pickaxe-lore2") + " ");
        pickaxelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.pickaxe-lore3") + " ");
        shoveldisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.shovel-name") + " ");
        shovellore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.shovel-lore1") + " ");
        shovellore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.shovel-lore2") + " ");
        shovellore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.shovel-lore3") + " ");
        hoedisplayname = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.hoe-name") + " ");
        hoelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.hoe-lore1") + " ");
        hoelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.hoe-lore2") + " ");
        hoelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.hoe-lore3") + " ");
        helmet = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dh-displayname") + " ");
        helmetlore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dh-lore1") + " ");
        helmetlore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dh-lore2") + " ");
        helmetlore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dh-lore3") + " ");
        chestplate = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dcp-displayname") + " ");
        chestplatelore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dcp-lore1") + " ");
        chestplatelore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dcp-lore2") + " ");
        chestplatelore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dcp-lore3") + " ");
        leggings = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dl-displayname") + " ");
        leggingslore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dl-lore1") + " ");
        leggingslore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dl-lore2") + " ");
        leggingslore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.dl-lore3") + " ");
        boots = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.db-displayname") + " ");
        bootslore1 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.db-lore1") + " ");
        bootslore2 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.db-lore2") + " ");
        bootslore3 = ChatColor.translateAlternateColorCodes('&', config.getString("SteelBorn.db-lore3") + " ");
        plugin.getLogger().info("Loaded Item set: SteelBorn");
    }

    public ItemStack steelbornSet() {
        Recipe steelBornEnchantedBookRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_book"));
        if (steelBornEnchantedBookRecipe != null){
            return steelBornEnchantedBookRecipe.getResult();
        }
        Recipe steelBornHeartRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_heart"));
        if (steelBornHeartRecipe != null){
            return steelBornHeartRecipe.getResult();
        }
        Recipe steelBornSwordRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_sword"));
        if (steelBornSwordRecipe != null){
            return steelBornSwordRecipe.getResult();
        }
        Recipe steelBornAxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_axe"));
        if (steelBornAxeRecipe != null){
            return steelBornAxeRecipe.getResult();
        }
        Recipe steelBornPickAxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_pickaxe"));
        if (steelBornPickAxeRecipe != null){
            return steelBornPickAxeRecipe.getResult();
        }
        Recipe steelBornShovelRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_shovel"));
        if (steelBornShovelRecipe != null){
            return steelBornShovelRecipe.getResult();
        }
        Recipe steelBornHoeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_hoe"));
        if (steelBornHoeRecipe != null){
            return steelBornHoeRecipe.getResult();
        }
        Recipe steelBornHelmetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_helmet"));
        if (steelBornHelmetRecipe != null){
            return steelBornHelmetRecipe.getResult();
        }
        Recipe steelBornCgestplateRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_chestplate"));
        if (steelBornCgestplateRecipe != null){
            return steelBornCgestplateRecipe.getResult();
        }
        Recipe steelBornLeggingsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_leggings"));
        if (steelBornLeggingsRecipe != null){
            return steelBornLeggingsRecipe.getResult();
        }
        Recipe steelBornBootsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_boots"));
        if (steelBornBootsRecipe != null){
            return steelBornBootsRecipe.getResult();
        }

        // Enchantment Book:
        ItemStack steelbornenchantedbook = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta steelbornenchantedbookmeta = steelbornenchantedbook.getItemMeta();
        steelbornenchantedbookmeta.setDisplayName(ChatColor.RED + "SteelBorn Book");
        ArrayList<String> enchantedbookLore = new ArrayList<>();
        enchantedbookLore.add(ChatColor.GOLD + " ");
        enchantedbookLore.add(ChatColor.GOLD + "SteelBorn Books were used");
        enchantedbookLore.add(ChatColor.GOLD + "to craft steelborn ingots");
        enchantedbookLore.add(ChatColor.GOLD + "that contains enchants.");
        steelbornenchantedbookmeta.setLore(enchantedbookLore);
        steelbornenchantedbook.setItemMeta(steelbornenchantedbookmeta);

        ShapedRecipe steelbornenchantedbookRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_book"), steelbornenchantedbook);
        steelbornenchantedbookRecipe.shape(" D ", "DFD", " D ");
        steelbornenchantedbookRecipe.setIngredient('D', Material.IRON_INGOT);
        steelbornenchantedbookRecipe.setIngredient('F', Material.BOOK);

        Recipe existingRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_book"));
        if (existingRecipe == null) {
            Bukkit.addRecipe(steelbornenchantedbookRecipe);
        }

        //SteelBorn Ingot (Used to craft the armor set)
        ItemStack steelbornHeart = new ItemStack(Material.IRON_NUGGET);
        ItemMeta steelbornHeartItemMeta = steelbornHeart.getItemMeta();
        steelbornHeartItemMeta.setDisplayName(ChatColor.GREEN + " ");
        steelbornHeartItemMeta.setDisplayName(crafter);
        ArrayList<String> sbhlore = new ArrayList<>();
        sbhlore.add(ChatColor.RED + " ");
        sbhlore.add(crafterlore1);
        sbhlore.add(crafterlore2);
        sbhlore.add(crafterlore3);
        steelbornHeartItemMeta.setLore(sbhlore);
        steelbornHeart.setItemMeta(steelbornHeartItemMeta);

        ShapedRecipe steelborningotRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_ingot"), steelbornHeart);
        steelborningotRecipe.shape("ENE", "NIN", "ENE");
        steelborningotRecipe.setIngredient('N', Material.IRON_NUGGET);
        steelborningotRecipe.setIngredient('I', Material.IRON_INGOT);
        steelborningotRecipe.setIngredient('E', new RecipeChoice.ExactChoice(steelbornenchantedbook));

        Recipe ingotRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_ingot"));
        if (ingotRecipe == null) {
            Bukkit.addRecipe(steelborningotRecipe);
        }

        //SteelBorn Sword:
        ItemStack steelbornSword = new ItemStack(Material.IRON_SWORD);
        ItemMeta steelbornSwordItemMeta = steelbornSword.getItemMeta();
        steelbornSwordItemMeta.setDisplayName(sbheartdisplay);
        steelbornSwordItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        steelbornSwordItemMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        steelbornSwordItemMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        steelbornSwordItemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 5, true);
        steelbornSwordItemMeta.setUnbreakable(true);
        steelbornSwordItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornSwordItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        steelbornSwordItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> sbheartlore = new ArrayList<>();
        sbheartlore.add(ChatColor.GOLD + " ");
        sbheartlore.add(lore1);
        sbheartlore.add(lore2);
        sbheartlore.add(lore3);
        sbheartlore.add(lore4);
        sbheartlore.add(ChatColor.GOLD + " ");
        sbheartlore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+14");
        sbheartlore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        steelbornSwordItemMeta.setLore(sbheartlore);
        steelbornSword.setItemMeta(steelbornSwordItemMeta);

        ShapedRecipe steelbornswordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_sword"), steelbornSword);
        steelbornswordRecipe.shape(" I ", " I ", " S ");
        steelbornswordRecipe.setIngredient('I', new RecipeChoice.ExactChoice(steelbornHeart));
        steelbornswordRecipe.setIngredient('S', Material.STICK);

        Recipe swordRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_sword"));
        if (swordRecipe == null) {
            Bukkit.addRecipe(steelbornswordRecipe);
        }

        // SteelBorn Axe
        ItemStack steelbornAxe = new ItemStack(Material.IRON_AXE);
        ItemMeta steelbornaxeMeta = steelbornAxe.getItemMeta();
        steelbornaxeMeta.setDisplayName(axedisplayname);
        steelbornaxeMeta.setUnbreakable(true);
        steelbornaxeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornaxeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        steelbornaxeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        steelbornaxeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        steelbornaxeMeta.addEnchant(Enchantment.LUCK, 3, true);
        ArrayList<String> steelbornaxelore = new ArrayList<>();
        steelbornaxelore.add(ChatColor.RED + " ");
        steelbornaxelore.add(axelore1);
        steelbornaxelore.add(axelore2);
        steelbornaxelore.add(axelore3);
        steelbornaxelore.add(ChatColor.RED + " ");
        steelbornaxelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+15.25");
        steelbornaxelore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        steelbornaxeMeta.setLore(steelbornaxelore);
        steelbornAxe.setItemMeta(steelbornaxeMeta);

        ShapedRecipe steelbornaxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_axe"), steelbornAxe);
        steelbornaxeRecipe.shape(" NN", " SN", " S ");
        steelbornaxeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));
        steelbornaxeRecipe.setIngredient('S', Material.STICK);

        Recipe axeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_axe"));
        if (axeRecipe == null) {
            Bukkit.addRecipe(steelbornaxeRecipe);
        }

        // SteelBorn Pickaxe
        ItemStack steelbornpickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta steelbornpickaxeMeta = steelbornpickaxe.getItemMeta();
        steelbornpickaxeMeta.setDisplayName(pickaxedisplayname);
        steelbornpickaxeMeta.setUnbreakable(true);
        steelbornpickaxeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornpickaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornpickaxeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        steelbornpickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        steelbornpickaxeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        steelbornpickaxeMeta.addEnchant(Enchantment.LUCK, 3, true);
        ArrayList<String> steelbornpickaxelore = new ArrayList<>();
        steelbornpickaxelore.add(ChatColor.RED + " ");
        steelbornpickaxelore.add(pickaxelore1);
        steelbornpickaxelore.add(pickaxelore2);
        steelbornpickaxelore.add(pickaxelore3);
        steelbornpickaxelore.add(ChatColor.RED + " ");
        steelbornpickaxelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+11.25");
        steelbornpickaxelore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1.2");
        steelbornpickaxeMeta.setLore(steelbornpickaxelore);
        steelbornpickaxe.setItemMeta(steelbornpickaxeMeta);

        ShapedRecipe steelbornpickaxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_pickaxe"), steelbornpickaxe);
        steelbornpickaxeRecipe.shape("NNN", " S ", " S ");
        steelbornpickaxeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));
        steelbornpickaxeRecipe.setIngredient('S', Material.STICK);

        Recipe pickaxeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_pickaxe"));
        if (pickaxeRecipe == null) {
            Bukkit.addRecipe(steelbornpickaxeRecipe);
        }

        // SteelBorn Shovel
        ItemStack steelbornshovel = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta steelbornshovelMeta = steelbornshovel.getItemMeta();
        steelbornshovelMeta.setDisplayName(shoveldisplayname);
        steelbornshovelMeta.setUnbreakable(true);
        steelbornshovelMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornshovelMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornshovelMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        steelbornshovelMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        steelbornshovelMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        steelbornshovelMeta.addEnchant(Enchantment.LUCK, 3, true);
        ArrayList<String> steelbornshovellore = new ArrayList<>();
        steelbornshovellore.add(ChatColor.RED + " ");
        steelbornshovellore.add(shovellore1);
        steelbornshovellore.add(shovellore2);
        steelbornshovellore.add(shovellore3);
        steelbornshovellore.add(ChatColor.RED + " ");
        steelbornshovellore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+11.85");
        steelbornshovellore.add(ChatColor.RED + "Attack Speed: " + ChatColor.GREEN + "+1");
        steelbornshovelMeta.setLore(steelbornshovellore);
        steelbornshovel.setItemMeta(steelbornshovelMeta);

        ShapedRecipe steelbornshovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_shovel"), steelbornshovel);
        steelbornshovelRecipe.shape(" N ", " S ", " S ");
        steelbornshovelRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));
        steelbornshovelRecipe.setIngredient('S', Material.STICK);

        Recipe shovelRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_shovel"));
        if (shovelRecipe == null) {
            Bukkit.addRecipe(steelbornshovelRecipe);
        }

        // SteelBorn Hoe
        ItemStack steelbornhoe = new ItemStack(Material.IRON_HOE);
        ItemMeta steelbornhoeMeta = steelbornhoe.getItemMeta();
        steelbornhoeMeta.setDisplayName(hoedisplayname);
        steelbornhoeMeta.setUnbreakable(true);
        steelbornhoeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornhoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornhoeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        steelbornhoeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        steelbornhoeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        steelbornhoeMeta.addEnchant(Enchantment.LUCK, 3, true);
        ArrayList<String> steelbornhoelore = new ArrayList<>();
        steelbornhoelore.add(ChatColor.RED + " ");
        steelbornhoelore.add(hoelore1);
        steelbornhoelore.add(hoelore2);
        steelbornhoelore.add(hoelore3);
        steelbornhoelore.add(ChatColor.RED + " ");
        steelbornhoelore.add(ChatColor.RED + "Damage: " + ChatColor.GREEN + "+7.25");
        steelbornhoelore.add(ChatColor.RED + "Attack Damage: " + ChatColor.GREEN + "+4");
        steelbornhoeMeta.setLore(steelbornhoelore);
        steelbornhoe.setItemMeta(steelbornhoeMeta);

        ShapedRecipe steelbornhoeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_hoe"), steelbornhoe);
        steelbornhoeRecipe.shape("NN ", " S ", " S ");
        steelbornhoeRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));
        steelbornhoeRecipe.setIngredient('S', Material.STICK);

        Recipe hoeRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_hoe"));
        if (hoeRecipe == null) {
            Bukkit.addRecipe(steelbornhoeRecipe);
        }

        // SteelBorn Helmet
        ItemStack steelbornhelmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta steelbornhelmetMeta = steelbornhelmet.getItemMeta();
        steelbornhelmetMeta.setDisplayName(helmet);
        steelbornhelmetMeta.setUnbreakable(true);
        steelbornhelmetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornhelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornhelmetMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowhelmetlore = new ArrayList<>();
        shadowhelmetlore.add(ChatColor.RED + " ");
        shadowhelmetlore.add(helmetlore1);
        shadowhelmetlore.add(helmetlore2);
        shadowhelmetlore.add(helmetlore3);
        shadowhelmetlore.add(ChatColor.RED + " ");
        shadowhelmetlore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+3");
        shadowhelmetlore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        steelbornhelmetMeta.setLore(shadowhelmetlore);
        steelbornhelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        steelbornhelmetMeta.addEnchant(Enchantment.THORNS, 2, true);
        steelbornhelmetMeta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        steelbornhelmetMeta.addEnchant(Enchantment.OXYGEN, 3,true);
        steelbornhelmet.setItemMeta(steelbornhelmetMeta);

        ShapedRecipe steelbornhelmetRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_helmet"), steelbornhelmet);
        steelbornhelmetRecipe.shape("NNN", "N N", "   ");
        steelbornhelmetRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));

        Recipe helmetRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_helmet"));
        if (helmetRecipe == null) {
            Bukkit.addRecipe(steelbornhelmetRecipe);
        }

        // SteelBorn ChestPlate
        ItemStack shadowChestPlate = new ItemStack(Material.IRON_CHESTPLATE);
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
        shadowChestPlateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        shadowChestPlateMeta.addEnchant(Enchantment.THORNS, 2, true);
        shadowChestPlate.setItemMeta(shadowChestPlateMeta);

        ShapedRecipe steelbornChestplateRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_chestplate"), shadowChestPlate);
        steelbornChestplateRecipe.shape("N N", "NNN", "NNN");
        steelbornChestplateRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));

        Recipe chestplateRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_chestplate"));
        if (chestplateRecipe == null) {
            Bukkit.addRecipe(steelbornChestplateRecipe);
        }

        // SteelBorn Leggings
        ItemStack steelbornleggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta steelbornleggingsMeta = steelbornleggings.getItemMeta();
        steelbornleggingsMeta.setDisplayName(leggings);
        steelbornleggingsMeta.setUnbreakable(true);
        steelbornleggingsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornleggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornleggingsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> steelbornlegingslore = new ArrayList<>();
        steelbornlegingslore.add(ChatColor.RED + " ");
        steelbornlegingslore.add(leggingslore1);
        steelbornlegingslore.add(leggingslore2);
        steelbornlegingslore.add(leggingslore3);
        steelbornlegingslore.add(ChatColor.RED + " ");
        steelbornlegingslore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+6");
        steelbornlegingslore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        steelbornleggingsMeta.setLore(steelbornlegingslore);
        steelbornleggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        steelbornleggingsMeta.addEnchant(Enchantment.THORNS, 5, true);
        steelbornleggings.setItemMeta(steelbornleggingsMeta);

        ShapedRecipe steelbornleggingsRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_leggings"), steelbornleggings);
        steelbornleggingsRecipe.shape("NNN", "N N", "N N");
        steelbornleggingsRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));

        Recipe leggingsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_leggings"));
        if (leggingsRecipe == null) {
            Bukkit.addRecipe(steelbornleggingsRecipe);
        }

        // SteelBorn Boots
        ItemStack steelbornboots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta steelbornbootsMeta = steelbornboots.getItemMeta();
        steelbornbootsMeta.setDisplayName(boots);
        steelbornbootsMeta.setUnbreakable(true);
        steelbornbootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        steelbornbootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        steelbornbootsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> shadowbootslore = new ArrayList<>();
        shadowbootslore.add(ChatColor.RED + " ");
        shadowbootslore.add(bootslore1);
        shadowbootslore.add(bootslore2);
        shadowbootslore.add(bootslore3);
        shadowbootslore.add(ChatColor.RED + " ");
        shadowbootslore.add(ChatColor.RED + "Armor: " + ChatColor.GREEN + "+3");
        shadowbootslore.add(ChatColor.RED + "Toughness: " + ChatColor.GREEN + "+2");
        steelbornbootsMeta.setLore(shadowbootslore);
        steelbornbootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        steelbornbootsMeta.addEnchant(Enchantment.THORNS, 3, true);
        steelbornbootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
        steelbornbootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        steelbornbootsMeta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
        steelbornboots.setItemMeta(steelbornbootsMeta);

        ShapedRecipe shadowbootsRecipe = new ShapedRecipe(new NamespacedKey(plugin, "steel_born_boots"), steelbornboots);
        shadowbootsRecipe.shape("   ", "N N", "N N");
        shadowbootsRecipe.setIngredient('N', new RecipeChoice.ExactChoice(steelbornHeart));

        Recipe bootsRecipe = Bukkit.getRecipe(new NamespacedKey(plugin, "steel_born_boots"));
        if (bootsRecipe == null) {
            Bukkit.addRecipe(shadowbootsRecipe);
        }

        return steelbornHeart;
    }
}
