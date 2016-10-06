package com.ryanmichela.caves256;

import com.google.common.collect.ImmutableMap;
import net.minecraft.server.v1_10_R1.*;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.craftbukkit.v1_10_R1.CraftChunk;
import org.bukkit.craftbukkit.v1_10_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_10_R1.util.CraftMagicNumbers;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * Created by ryanmichela on 10/5/16.
 *
 * This class makes a live CraftChunk look like a ChunkSnapshot, so that the stock terrain populators can be
 * implemented as BlockPopulators.
 */
public class ChunkSnapshotAdapter extends ChunkSnapshot {
    private CraftChunk chunk;

    public ChunkSnapshotAdapter(CraftChunk chunk) {
        this.chunk = chunk;
    }

    @Override
    public IBlockData a(int x, int y, int z) {
        return new BlockDataAdapter((CraftBlock)chunk.getBlock(x, y, z));
    }

    @Override
    public void a(int x, int y, int z, IBlockData nmsBlockData) {
        Block nmsBlock = nmsBlockData.getBlock();
        chunk.getBlock(x, y, z).setType(CraftMagicNumbers.getMaterial(nmsBlock));
    }

    @Override
    public int a(int i, int i1) {
        throw new NotImplementedException("a(int i, int i1)");
    }

    public class BlockDataAdapter implements IBlockData {
        private CraftBlock craftBlock;

        public BlockDataAdapter(CraftBlock craftBlock) {
            this.craftBlock = craftBlock;
        }

        @Override
        public Material getMaterial() {
            return CraftMagicNumbers.getBlock(craftBlock).getBlockData().getMaterial();
        }

        @Override
        public Block getBlock() {
            return CraftMagicNumbers.getBlock(craftBlock);
        }

        @Override
        public Collection<IBlockState<?>> r() {
            throw new NotImplementedException();
        }

        @Override
        public <T extends Comparable<T>> T get(IBlockState<T> iBlockState) {
            throw new NotImplementedException();
        }

        @Override
        public <T extends Comparable<T>, V extends T> IBlockData set(IBlockState<T> iBlockState, V v) {
            throw new NotImplementedException();
        }

        @Override
        public <T extends Comparable<T>> IBlockData a(IBlockState<T> iBlockState) {
            throw new NotImplementedException();
        }

        @Override
        public ImmutableMap<IBlockState<?>, Comparable<?>> s() {
            throw new NotImplementedException();
        }

        @Override
        public boolean a(World world, BlockPosition blockPosition, int i, int i1) {
            throw new NotImplementedException();
        }

        @Override
        public void doPhysics(World world, BlockPosition blockPosition, Block block) {
            throw new NotImplementedException();
        }

        @Override
        public boolean b() {
            throw new NotImplementedException();
        }

        @Override
        public boolean a(Entity entity) {
            throw new NotImplementedException();
        }

        @Override
        public int c() {
            throw new NotImplementedException();
        }

        @Override
        public int d() {
            throw new NotImplementedException();
        }

        @Override
        public boolean f() {
            throw new NotImplementedException();
        }

        @Override
        public MaterialMapColor g() {
            throw new NotImplementedException();
        }

        @Override
        public IBlockData a(EnumBlockRotation enumBlockRotation) {
            throw new NotImplementedException();
        }

        @Override
        public IBlockData a(EnumBlockMirror enumBlockMirror) {
            throw new NotImplementedException();
        }

        @Override
        public boolean h() {
            throw new NotImplementedException();
        }

        @Override
        public EnumRenderType i() {
            throw new NotImplementedException();
        }

        @Override
        public boolean k() {
            throw new NotImplementedException();
        }

        @Override
        public boolean l() {
            throw new NotImplementedException();
        }

        @Override
        public boolean m() {
            throw new NotImplementedException();
        }

        @Override
        public int a(IBlockAccess iBlockAccess, BlockPosition blockPosition, EnumDirection enumDirection) {
            throw new NotImplementedException();
        }

        @Override
        public boolean n() {
            throw new NotImplementedException();
        }

        @Override
        public int a(World world, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public float b(World world, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public float a(EntityHuman entityHuman, World world, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public int b(IBlockAccess iBlockAccess, BlockPosition blockPosition, EnumDirection enumDirection) {
            throw new NotImplementedException();
        }

        @Override
        public EnumPistonReaction o() {
            throw new NotImplementedException();
        }

        @Override
        public IBlockData b(IBlockAccess iBlockAccess, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public boolean p() {
            throw new NotImplementedException();
        }

        @Nullable
        @Override
        public AxisAlignedBB d(World world, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public void a(World world, BlockPosition blockPosition, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, @Nullable Entity entity) {
            throw new NotImplementedException();
        }

        @Override
        public AxisAlignedBB c(IBlockAccess iBlockAccess, BlockPosition blockPosition) {
            throw new NotImplementedException();
        }

        @Override
        public MovingObjectPosition a(World world, BlockPosition blockPosition, Vec3D vec3D, Vec3D vec3D1) {
            throw new NotImplementedException();
        }

        @Override
        public boolean q() {
            throw new NotImplementedException();
        }
    }
}
