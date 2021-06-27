package io.github.fallOut015.planetary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractBigMushroomFeature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;

import java.util.Random;

public class BigNeondotFeature extends AbstractBigMushroomFeature {
    Direction facing;

    public BigNeondotFeature(Codec<BigMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected int getTreeRadiusForHeight(int i1, int i2, int i3, int i4) {
        int i = 0;
        if (i4 < i2 && i4 >= i2 - 3) {
            i = i3;
        } else if (i4 == i2) {
            i = i3;
        }
        return i;
    }
    @Override
    protected void makeCap(IWorld world, Random rand, BlockPos pos, int i4, BlockPos.Mutable mutable, BigMushroomFeatureConfig config) {
        // i4 is cap offset

        for(int i = i4 - 2; i <= i4; ++i) {
            int j = i < i4 ? config.foliageRadius : config.foliageRadius - 1;

            // j is radius

            for(int l = -j; l <= j; ++l) {
                for(int i1 = -j; i1 <= j; ++i1) {
                    boolean flag = l == -j;
                    boolean flag1 = l == j;
                    boolean flag2 = i1 == -j;
                    boolean flag3 = i1 == j;
                    boolean flag4 = flag || flag1;
                    boolean flag5 = flag2 || flag3;
                    if (i >= i4 || flag4 != flag5) {
                        mutable.set(pos).move(l, i, i1).move(this.facing);
                        if (world.getBlockState(mutable).canBeReplacedByLeaves(world, mutable)) {
                            if(rand.nextInt(5) == 0) {
                                //this.setBlockState(world, mutable, BlocksTwo.SHROOMGLOW.getDefaultState());
                            } else {
                                this.setBlock(world, mutable, config.stemProvider.getState(rand, pos));
                            }
                            // change to assigning one dot per face.
                        }
                    }
                }
            }
        }
    }
    @Override
    protected void placeTrunk(IWorld world, Random rand, BlockPos pos, BigMushroomFeatureConfig config, int i5, BlockPos.Mutable mutable) {
        for(int i = 0; i < i5; ++ i) {
            if(i >= 4) {
                mutable.set(pos).move(this.facing).move(Direction.UP, i);
            } else {
                mutable.set(pos).move(Direction.UP, i);
            }
            if (world.getBlockState(mutable).canBeReplacedByLogs(world, mutable)) {
                this.setBlock(world, mutable, config.stemProvider.getState(rand, pos));
                if(i == 0 || i == 1 || i == 3) {
                    if(i == 0) {
                        // TODO change to algorithm
                        this.setBlock(world, mutable.relative(this.facing).north(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.relative(this.facing).east(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.relative(this.facing).south(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.relative(this.facing).west(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.north(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.east(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.south(), config.stemProvider.getState(rand, pos));
                        this.setBlock(world, mutable.west(), config.stemProvider.getState(rand, pos));
                    }
                    this.setBlock(world, mutable.relative(this.facing), config.stemProvider.getState(rand, pos));
                }
            }
        }
    }
    @Override
    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, BigMushroomFeatureConfig config) {
        int i = this.getTreeHeight(rand); // stem height from 6 to 7.
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        if (!this.isValidPosition(worldIn, pos, i, blockpos$mutable, config)) {
            return false; // TODO for placeable on sporestone soil
        } else {
            this.facing = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
            this.makeCap(worldIn, rand, pos, i, blockpos$mutable, config); // place cap
            this.placeTrunk(worldIn, rand, pos, config, i, blockpos$mutable); // place stems
            return true;
        }
    }
    @Override
    protected int getTreeHeight(Random rand) {
        return rand.nextInt(2) + 6; // 6 or 7
        // Returns height (amount of stems place vertically)
    }
    @Override
    protected boolean isValidPosition(IWorld p_227209_1_, BlockPos p_227209_2_, int p_227209_3_, BlockPos.Mutable p_227209_4_, BigMushroomFeatureConfig p_227209_5_) {
        int i = p_227209_2_.getY();
        if (i >= 1 && i + p_227209_3_ + 1 < 256) {
            Block block = p_227209_1_.getBlockState(p_227209_2_.below()).getBlock();
			/*if (block != BlocksTwo.SPORESTONE_SOIL) {
				return false;
			} else {*/
            for(int j = 0; j <= p_227209_3_; ++j) {
                int k = this.getTreeRadiusForHeight(-1, -1, p_227209_5_.foliageRadius, j);

                for(int l = -k; l <= k; ++l) {
                    for(int i1 = -k; i1 <= k; ++i1) {
                        BlockState blockstate = p_227209_1_.getBlockState(p_227209_4_.set(p_227209_2_).move(l, j, i1));
                        if (!blockstate.isAir(p_227209_1_, p_227209_4_) && !blockstate.is(BlockTags.LEAVES)) {
                            return false;
                        }
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }
}