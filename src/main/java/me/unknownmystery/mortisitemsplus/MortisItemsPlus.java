package me.unknownmystery.mortisitemsplus;

import me.unknownmystery.mortisitemsplus.Armors.ShadowFighterSet;
import me.unknownmystery.mortisitemsplus.Armors.SteelBornSet;
import me.unknownmystery.mortisitemsplus.Items.LightningBowListener;
import me.unknownmystery.mortisitemsplus.Items.TeleportationWandListener;
import me.unknownmystery.mortisitemsplus.Talismans.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class MortisItemsPlus extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new SaturationPet(this), this);
        getServer().getPluginManager().registerEvents(new StrengthPet(this), this);
        getServer().getPluginManager().registerEvents(new AbsorptionPet(this), this);
        getServer().getPluginManager().registerEvents(new SpeedPet(this), this);
        getServer().getPluginManager().registerEvents(new HealthBoostPet(this), this);
        getServer().getPluginManager().registerEvents(new LightningBowListener(this), this);
        getServer().getPluginManager().registerEvents(new TeleportationWandListener(this), this);
        MortisItemsPlus plugin = this;
        ShadowFighterSet shadowFighterListener = new ShadowFighterSet(this);
        ItemStack shadowFighter = shadowFighterListener.shadowfightSword();
        SteelBornSet steelBornListener = new SteelBornSet(this);
        ItemStack steelBorn = steelBornListener.steelbornSet();
        SaturationPet pigsaturationPet = new SaturationPet(this);
        ItemStack pigPet = pigsaturationPet.saturationPet();
        StrengthPet dragonstrengthPet = new StrengthPet(this);
        ItemStack strengthPet = dragonstrengthPet.strengthPet();
        AbsorptionPet wskeletonabsorptionPet = new AbsorptionPet(this);
        ItemStack absorptionPet = wskeletonabsorptionPet.absorptionPet();
        SpeedPet skeletonspeedPet = new SpeedPet(this);
        ItemStack speedPet = skeletonspeedPet.speedPet();
        HealthBoostPet creeperhealthboostPet = new HealthBoostPet(this);
        ItemStack healthboostPet = creeperhealthboostPet.healthboostPet();
        LightningBowListener lightningBow = new LightningBowListener(this);
        ItemStack customlightningBow = lightningBow.lightningBow();
        TeleportationWandListener teleportWand = new TeleportationWandListener(this);
        ItemStack customteleportWand = teleportWand.createTeleportWandRecipe();
    }

        @Override
        public void onDisable () {
            // Plugin shutdown logic
    }
}