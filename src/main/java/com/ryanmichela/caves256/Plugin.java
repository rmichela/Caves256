package com.ryanmichela.caves256;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by ryanmichela on 10/5/16.
 */
public class Plugin extends JavaPlugin implements Listener {
    public void onEnable() {
        // create the plugin directory if it does not exist
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onWorldInit(WorldInitEvent event) {
        List<String> worlds = getConfig().getStringList("worlds");

        if(worlds.contains(event.getWorld().getName())) {
            getLogger().info("Attaching cave populator to world \"" + event.getWorld().getName() + "\"");
            event.getWorld().getPopulators().add(new Cave256Populator());
        }
    }
}
