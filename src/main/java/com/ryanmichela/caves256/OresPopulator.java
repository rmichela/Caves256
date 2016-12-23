package com.ryanmichela.caves256;

import net.minecraft.server.v1_10_R1.Blocks;
import net.minecraft.server.v1_10_R1.CustomWorldSettingsFinal;
import net.minecraft.server.v1_10_R1.WorldGenMinable;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * Created by ryanmichela on 12/23/16.
 */
public class OresPopulator extends BlockPopulator {
    private final CustomWorldSettingsFinal worldSettings;

    public OresPopulator(CustomWorldSettingsFinal worldSettings) {
        this.worldSettings = worldSettings;
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        WorldGenMinable coal = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), worldSettings.ac);
        WorldGenMinable iron = new WorldGenMinable(Blocks.IRON_ORE.getBlockData(), worldSettings.ag);
        WorldGenMinable gold = new WorldGenMinable(Blocks.GOLD_ORE.getBlockData(), worldSettings.ak);
        WorldGenMinable redstone = new WorldGenMinable(Blocks.REDSTONE_ORE.getBlockData(), worldSettings.ao);
        WorldGenMinable diamond = new WorldGenMinable(Blocks.DIAMOND_ORE.getBlockData(), worldSettings.as);
        WorldGenMinable lapis = new WorldGenMinable(Blocks.LAPIS_ORE.getBlockData(), worldSettings.aw);

        WorldGenAdapterPopulator coalGen = new WorldGenAdapterPopulator(coal, worldSettings.ad, worldSettings.ae, worldSettings.af);
        WorldGenAdapterPopulator ironGen = new WorldGenAdapterPopulator(iron, worldSettings.ah, worldSettings.ai, worldSettings.aj);
        WorldGenAdapterPopulator goldGen = new WorldGenAdapterPopulator(gold, worldSettings.al, worldSettings.am, worldSettings.an);
        WorldGenAdapterPopulator redstoneGen = new WorldGenAdapterPopulator(redstone, worldSettings.ap, worldSettings.aq, worldSettings.ar);
        WorldGenAdapterPopulator diamondGen = new WorldGenAdapterPopulator(diamond, worldSettings.at, worldSettings.au, worldSettings.av);
        WorldGenAdapterPopulator lapisGen = new WorldGenAdapterPopulator(lapis, worldSettings.ax, worldSettings.ay, worldSettings.az);

        coalGen.populate(world, random, chunk);
        ironGen.populate(world, random, chunk);
        goldGen.populate(world, random, chunk);
        redstoneGen.populate(world, random, chunk);
        diamondGen.populate(world, random, chunk);
        lapisGen.populate(world, random, chunk);
    }
}
