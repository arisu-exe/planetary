package io.github.fallOut015.planetary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractBigMushroomFeature;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;

import java.util.Random;

public class BigBrimshineFeature extends AbstractBigMushroomFeature {
    public BigBrimshineFeature(Codec<BigMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected int getTreeRadiusForHeight(int p_225563_1_, int p_225563_2_, int p_225563_3_, int p_225563_4_) {
        return 0;
    }

    @Override
    protected void makeCap(IWorld p_225564_1_, Random p_225564_2_, BlockPos p_225564_3_, int p_225564_4_, BlockPos.Mutable p_225564_5_, BigMushroomFeatureConfig p_225564_6_) {

    }
    @Override
    protected int getTreeHeight(Random rand) {
        return 5; // stem height
    }

    @Override
    protected boolean isValidPosition(IWorld p_227209_1_, BlockPos p_227209_2_, int p_227209_3_, BlockPos.Mutable p_227209_4_, BigMushroomFeatureConfig p_227209_5_) {
        int i = p_227209_2_.getY();
        if (i >= 1 && i + p_227209_3_ + 1 < 255) {
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