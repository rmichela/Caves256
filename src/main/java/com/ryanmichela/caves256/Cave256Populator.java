package com.ryanmichela.caves256;

import org.bukkit.Chunk;
import org.bukkit.World;
import net.minecraft.server.v1_10_R1.ChunkSnapshot;
import org.bukkit.craftbukkit.v1_10_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * Created by ryanmichela on 10/5/16.
 */
public class Cave256Populator extends BlockPopulator {
    private static WorldGenCaves256 caveGen = new WorldGenCaves256();

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        net.minecraft.server.v1_10_R1.World nmsWorld = ((CraftWorld) world).getHandle();
        int x = chunk.getX();
        int z = chunk.getZ();
        ChunkSnapshot nmsSnapshot = new ChunkSnapshotAdapter((CraftChunk)chunk);

        caveGen.a(nmsWorld, x, z, nmsSnapshot);
    }
}
