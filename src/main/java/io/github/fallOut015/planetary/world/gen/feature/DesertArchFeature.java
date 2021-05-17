package io.github.fallOut015.planetary.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class DesertArchFeature extends Feature<NoFeatureConfig> {
    public DesertArchFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        double w = rand.nextInt(9) + 8;
        double h = rand.nextInt(5) + 4;

        double rotation = Math.toRadians(rand.nextInt(360));

        for(double x = 0; x < w + 1; ++ x) {
            double xoff = Math.cos(0.5 * Math.PI * (x / (w + 1))) * rotation;
            double zoff = Math.sin(0.5 * Math.PI * (x / (w + 1))) * rotation;

            BlockPos pos1 = new BlockPos(pos.getX() + x + xoff, pos.getY() + placement(x, w, h), pos.getZ() + zoff);
            BlockPos pos2 = new BlockPos(pos.getX() + (x - 1) + xoff, pos.getY() + placement(x - 1, w, h), pos.getZ() + zoff);

            if(x == 0) {
                BlockPos position = pos1.below();
                while(reader.isEmptyBlock(position = position.below())) { }

                BlockPos.betweenClosedStream(position, pos1.below()).forEach(blockPos -> {
                    if(reader.isEmptyBlock(blockPos)) {
                        reader.setBlock(blockPos, Blocks.SMOOTH_SANDSTONE.defaultBlockState(), 0);
                    }
                });
            } else {
                BlockPos.betweenClosedStream(pos2, pos1).forEach(blockPos -> {
                    if(reader.isEmptyBlock(blockPos)) {
                        reader.setBlock(blockPos, Blocks.SMOOTH_SANDSTONE.defaultBlockState(), 0);
                    }
                });

                if(x == w) {
                    BlockPos position = pos1.below();
                    while(reader.isEmptyBlock(position = position.below())) { }

                    BlockPos.betweenClosedStream(position, pos1.below()).forEach(blockPos -> {
                        if(reader.isEmptyBlock(blockPos)) {
                            reader.setBlock(blockPos, Blocks.SMOOTH_SANDSTONE.defaultBlockState(), 0);
                        }
                    });
                }
            }
        }

        return true;
    }

    private static double placement(double x, double w, double h) {
        return h * Math.sqrt(1d - (Math.pow(x - (w / 2d), 2d) / (Math.pow(w / 2d, 2d))));
    }
}