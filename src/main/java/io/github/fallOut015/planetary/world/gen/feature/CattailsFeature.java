package io.github.fallOut015.planetary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class CattailsFeature extends Feature<NoFeatureConfig> {
    public CattailsFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR, pos.getX(), pos.getZ());
        BlockPos blockpos = new BlockPos(pos.getX(), j, pos.getZ());
        if (world.getBlockState(blockpos).is(Blocks.WATER)) {
            //BlockState cattails = BlocksTwo.CATTAILS.getDefaultState();
            //BlockState cattails_plant = BlocksTwo.CATTAILS_PLANT.getDefaultState();
            int k = 1 + rand.nextInt(10);

            for(int l = 0; l <= k; ++l) {
				/*if (world.getBlockState(blockpos).isIn(Blocks.WATER) && world.getBlockState(blockpos.up()).isIn(Blocks.WATER) && cattails_plant.isValidPosition(world, blockpos)) {
					if (l == k) {
						//world.setBlockState(blockpos, cattails.with(KelpTopBlock.AGE, Integer.valueOf(rand.nextInt(4) + 20)), 2);
						++i;
					} else {
						//world.setBlockState(blockpos, cattails_plant, 2);
					}
	            } else if (l > 0) {*/
                //BlockPos blockpos1 = blockpos.down();
	            	/*if (cattails.isValidPosition(world, blockpos1) && !world.getBlockState(blockpos1.down()).isIn(Blocks.KELP)) {
	            		world.setBlockState(blockpos1, cattails.with(KelpTopBlock.AGE, Integer.valueOf(rand.nextInt(4) + 20)), 2);
	            		++i;
	            	}*/
                //break;
                //}

                blockpos = blockpos.above();
            }
        }

        return i > 0;
    }
}