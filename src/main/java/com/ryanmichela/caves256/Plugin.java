package com.ryanmichela.caves256;

import net.minecraft.server.v1_10_R1.CustomWorldSettingsFinal;
import net.minecraft.server.v1_10_R1.WorldData;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
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

                // Attach an ore populator
                net.minecraft.server.v1_10_R1.World nmsWorld = ((CraftWorld) event.getWorld()).getHandle();
                String configGeneratorSettings = nmsWorld.getServer().getServer().getPropertyManager().getString("generator-settings", "");
                event.getWorld().getPopulators().add(new OresPopulator(CustomWorldSettingsFinal.CustomWorldSettings.a(configGeneratorSettings).b()));

                // Attach a cave populator after the ore populator, so caves cut through ore
                for (int i = 0; i < Integer.parseInt(world.get("iterations").toString()); i++) {
                    event.getWorld().getPopulators().add(new Cave256Populator(i));
                }

                // Disable standard ore and cave generation
                CustomWorldSettingsFinal.CustomWorldSettings worldSettings = CustomWorldSettingsFinal.CustomWorldSettings.a(nmsWorld.getWorldData().getGeneratorOptions());
                worldSettings.s = false; // useCaves
                worldSettings.ae = 0; // coalCount
                worldSettings.ai = 0; // ironCount
                worldSettings.am = 0; // goldCount
                worldSettings.aq = 0; // redstoneCount
                worldSettings.au = 0; // diamondCount
                worldSettings.ay = 0; // lapisCount
                String settingsJson = worldSettings.toString();
                setGeneratorOptions(nmsWorld.getWorldData(), settingsJson);
            }
        }
    }

    private void setGeneratorOptions(WorldData wd, String json) {
        ReflectionUtil.setProtectedValue(wd, "g", json);
    }
}
