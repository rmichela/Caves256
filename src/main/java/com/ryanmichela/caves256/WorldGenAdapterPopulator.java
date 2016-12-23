package com.ryanmichela.caves256;

import net.minecraft.server.v1_10_R1.BlockPosition;
import net.minecraft.server.v1_10_R1.WorldGenerator;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * Created by ryanmichela on 12/23/16.
 */
public class WorldGenAdapterPopulator extends BlockPopulator {
    private final WorldGenerator gen;
    private final int tries;
    private final int low;
    private final int high;

    public WorldGenAdapterPopulator(WorldGenerator gen, int tries, int low, int high) {
        this.gen = gen;
        this.tries = tries;
        this.low = low;
        this.high = high;
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        BlockPosition position = chunkToBlockPosition(chunk);
        net.minecraft.server.v1_10_R1.World nmsWorld = ((CraftWorld) world).getHandle();

        scatter(nmsWorld, random, position, tries, gen, low, high);
    }

    private BlockPosition chunkToBlockPosition(Chunk chunk) {
        return new BlockPosition(chunk.getX() * 16, 0, chunk.getZ() * 16);
    }

    private void scatter(net.minecraft.server.v1_10_R1.World world, Random random, BlockPosition startPoint, int tries,
                         WorldGenerator worldgenerator, int low, int high) {
        int l;

        if (high < low) {
            l = low;
            low = high;
            high = l;
        } else if (high == low) {
            if (low < 255) {
                ++high;
            } else {
                --low;
            }
        }

        for (l = 0; l < tries; ++l) {
            BlockPosition blockposition = startPoint.a(random.nextInt(16), random.nextInt(high - low) + low, random.nextInt(16));
            worldgenerator.generate(world, random, blockposition);
        }
    }
}
