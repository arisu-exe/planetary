package io.github.fallOut015.planetary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class MultiReplaceBlockFeature extends Feature<MultiReplaceBlockConfig> {
    public MultiReplaceBlockFeature(Codec<MultiReplaceBlockConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, MultiReplaceBlockConfig config) {
        if(seedReader.getBlockState(pos.above()).isAir(seedReader, pos)) {
            if(seedReader.getBlockState(pos).is(config.target2.getBlock())) {
                seedReader.setBlock(pos, config.state2, 2);
            }
        } else if(seedReader.getBlockState(pos).is(config.target1.getBlock())) {
            seedReader.setBlock(pos, config.state1, 2);
        }

        return false;
    }
}