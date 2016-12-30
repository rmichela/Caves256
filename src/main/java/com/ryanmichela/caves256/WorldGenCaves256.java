//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ryanmichela.caves256;

import com.google.common.base.Objects;
import java.util.Random;
import net.minecraft.server.v1_11_R1.*;

public class WorldGenCaves256 extends WorldGenBase {
    private final int mixup;

    public WorldGenCaves256(int mixup) {
        this.mixup = mixup;
    }

    protected void a(long var1, int var3, int var4, ChunkSnapshot var5, double var6, double var8, double var10) {
        this.a(var1, var3, var4, var5, var6, var8, var10, 1.0F + this.f.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
    }

    protected void a(long var1, int var3, int var4, ChunkSnapshot chunkSnapshot, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
        double var19 = (double)(var3 * 16 + 8);
        double var21 = (double)(var4 * 16 + 8);
        float var23 = 0.0F;
        float var24 = 0.0F;
        Random var25 = new Random(var1 + mixup);
        if(var16 <= 0) {
            int var26 = this.e * 16 - 16;
            var16 = var26 - var25.nextInt(var26 / 4);
        }

        boolean var55 = false;
        if(var15 == -1) {
            var15 = var16 / 2;
            var55 = true;
        }

        int var27 = var25.nextInt(var16 / 2) + var16 / 4;

        for(boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
            double var29 = 1.5D + (double)(MathHelper.sin((float)var15 * 3.1415927F / (float)var16) * var12);
            double var31 = var29 * var17;
            float var33 = MathHelper.cos(var14);
            float var34 = MathHelper.sin(var14);
            var6 += (double)(MathHelper.cos(var13) * var33);
            var8 += (double)var34;
            var10 += (double)(MathHelper.sin(var13) * var33);
            if(var28) {
                var14 *= 0.92F;
            } else {
                var14 *= 0.7F;
            }

            var14 += var24 * 0.1F;
            var13 += var23 * 0.1F;
            var24 *= 0.9F;
            var23 *= 0.75F;
            var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
            var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
            if(!var55 && var15 == var27 && var12 > 1.0F && var16 > 0) {
                this.a(var25.nextLong(), var3, var4, chunkSnapshot, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
                this.a(var25.nextLong(), var3, var4, chunkSnapshot, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
                return;
            }

            if(var55 || var25.nextInt(4) != 0) {
                double var35 = var6 - var19;
                double var37 = var10 - var21;
                double var39 = (double)(var16 - var15);
                double var41 = (double)(var12 + 2.0F + 16.0F);
                if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
                    return;
                }

                if(var6 >= var19 - 16.0D - var29 * 2.0D && var10 >= var21 - 16.0D - var29 * 2.0D && var6 <= var19 + 16.0D + var29 * 2.0D && var10 <= var21 + 16.0D + var29 * 2.0D) {
                    int var56 = MathHelper.floor(var6 - var29) - var3 * 16 - 1;
                    int var36 = MathHelper.floor(var6 + var29) - var3 * 16 + 1;
                    int var57 = MathHelper.floor(var8 - var31) - 1;
                    int var38 = MathHelper.floor(var8 + var31) + 1;
                    int var58 = MathHelper.floor(var10 - var29) - var4 * 16 - 1;
                    int var40 = MathHelper.floor(var10 + var29) - var4 * 16 + 1;
                    if(var56 < 0) {
                        var56 = 0;
                    }

                    if(var36 > 16) {
                        var36 = 16;
                    }

                    if(var57 < 1) {
                        var57 = 1;
                    }

                    if(var38 > 248) {
                        var38 = 248;
                    }

                    if(var58 < 0) {
                        var58 = 0;
                    }

                    if(var40 > 16) {
                        var40 = 16;
                    }

                    boolean isInCave = false;

                    int x;
                    for(int var42 = var56; !isInCave && var42 < var36; ++var42) {
                        for(x = var58; !isInCave && x < var40; ++x) {
                            for(int var44 = var38 + 1; !isInCave && var44 >= var57 - 1; --var44) {
                                if(var44 >= 0 && var44 < 256) {
                                    IBlockData var45 = chunkSnapshot.a(var42, var44, x);
                                    if(var45.getBlock() == Blocks.FLOWING_WATER || var45.getBlock() == Blocks.WATER) {
                                        isInCave = true;
                                    }

                                    if(var44 != var57 - 1 && var42 != var56 && var42 != var36 - 1 && x != var58 && x != var40 - 1) {
                                        var44 = var57;
                                    }
                                }
                            }
                        }
                    }

                    if(!isInCave) {
                        BlockPosition.MutableBlockPosition blockPosition = new BlockPosition.MutableBlockPosition();

                        for(x = var56; x < var36; ++x) {
                            double var61 = ((double)(x + var3 * 16) + 0.5D - var6) / var29;

                            for(int z = var58; z < var40; ++z) {
                                double var47 = ((double)(z + var4 * 16) + 0.5D - var10) / var29;
                                boolean isGrassOrMycelium = false;
                                if(var61 * var61 + var47 * var47 < 1.0D) {
                                    for(int y = var38; y > var57; --y) {
                                        double var51 = ((double)(y - 1) + 0.5D - var8) / var31;
                                        if(var51 > -0.7D && var61 * var61 + var51 * var51 + var47 * var47 < 1.0D) {
                                            IBlockData selectedBlock = chunkSnapshot.a(x, y, z);
                                            IBlockData blockAbove = (IBlockData)Objects.firstNonNull(chunkSnapshot.a(x, y + 1, z), Blocks.AIR.getBlockData());
                                            if(selectedBlock.getBlock() == Blocks.GRASS || selectedBlock.getBlock() == Blocks.MYCELIUM) {
                                                isGrassOrMycelium = true;
                                            }

                                            if(this.canMakeCave(selectedBlock, blockAbove)) {
                                                if(y - 1 < 10) {
                                                    chunkSnapshot.a(x, y, z, Blocks.LAVA.getBlockData());
                                                } else {
                                                    chunkSnapshot.a(x, y, z, Blocks.AIR.getBlockData());
                                                    if(isGrassOrMycelium && chunkSnapshot.a(x, y - 1, z).getBlock() == Blocks.DIRT) {
                                                        blockPosition.c(x + var3 * 16, 0, z + var4 * 16);
                                                        chunkSnapshot.a(x, y - 1, z, this.g.getBiome(blockPosition).r.getBlock().getBlockData());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if(var55) {
                            break;
                        }
                    }
                }
            }
        }

    }

    protected boolean canMakeCave(IBlockData block, IBlockData blockAbove) {
        Block b = block.getBlock();
        return  b == Blocks.STONE ||
                b == Blocks.DIRT ||
                b == Blocks.GRASS ||
                b == Blocks.HARDENED_CLAY ||
                b == Blocks.STAINED_HARDENED_CLAY ||
                b == Blocks.SANDSTONE ||
                b == Blocks.RED_SANDSTONE ||
                b == Blocks.MYCELIUM ||
                b == Blocks.SNOW_LAYER ||
                b == Blocks.SAND ||
                b == Blocks.GRAVEL ||
                !blockAbove.getMaterial().isLiquid(); // == Water -> .isLiquid()
    }

    protected void a(World var1, int var2, int var3, int var4, int var5, ChunkSnapshot var6) {
        int var7 = this.f.nextInt(this.f.nextInt(this.f.nextInt(15) + 1) + 1);
        if(this.f.nextInt(4) != 0) { // 7 -> 4
            var7 = 0;
        }

        for(int var8 = 0; var8 < var7; ++var8) {
            double var9 = (double)(var2 * 16 + this.f.nextInt(16));
            double var11 = (double)this.f.nextInt(this.f.nextInt(250) + 8); // 120 -> 250
            double var13 = (double)(var3 * 16 + this.f.nextInt(16));
            int var15 = 1;
            if(this.f.nextInt(4) == 0) {
                this.a(this.f.nextLong(), var4, var5, var6, var9, var11, var13);
                var15 += this.f.nextInt(4);
            }

            for(int var16 = 0; var16 < var15; ++var16) {
                float var17 = this.f.nextFloat() * 6.2831855F;
                float var18 = (this.f.nextFloat() - 0.5F) * 2.0F / 8.0F;
                float var19 = this.f.nextFloat() * 2.0F + this.f.nextFloat();
                if(this.f.nextInt(10) == 0) {
                    var19 *= this.f.nextFloat() * this.f.nextFloat() * 3.0F + 1.0F;
                }

                this.a(this.f.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
            }
        }

    }
}
