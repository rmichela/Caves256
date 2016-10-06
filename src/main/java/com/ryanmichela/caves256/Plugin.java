package com.ryanmichela.caves256;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

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
        List<Map<?, ?>> worlds = getConfig().getMapList("worlds");
        for (Map<?, ?> world : worlds) {
            if (world.get("name").equals(event.getWorld().getName())) {
                getLogger().info("Attaching cave populator to world \"" + event.getWorld().getName() + "\"");
                for (int i = 0; i < Integer.parseInt(world.get("iterations").toString()); i++) {
                    event.getWorld().getPopulators().add(new Cave256Populator(i));
                }
            }
        }
    }
}
