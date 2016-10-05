package com.ryanmichela.caves256;

import net.minecraft.server.v1_10_R1.ChunkSnapshot;
import net.minecraft.server.v1_10_R1.IBlockData;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.craftbukkit.v1_10_R1.CraftChunk;

/**
 * Created by ryanmichela on 10/5/16.
 */
public class ChunkAdapter extends ChunkSnapshot {
    private CraftChunk chunk;

    public ChunkAdapter(CraftChunk chunk) {
        this.chunk = chunk;
    }

    @Override
    public IBlockData a(int i, int i1, int i2) {
        throw new NotImplementedException("a(int i, int i1, int i2)");
    }

    @Override
    public void a(int i, int i1, int i2, IBlockData iBlockData) {
        throw new NotImplementedException("a(int i, int i1, int i2, IBlockData iBlockData)");
    }

    @Override
    public int a(int i, int i1) {
        throw new NotImplementedException("a(int i, int i1)");
    }
}
