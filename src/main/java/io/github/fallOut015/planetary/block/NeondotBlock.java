package io.github.fallOut015.planetary.block;

import io.github.fallOut015.planetary.world.gen.feature.FeaturesPlanetary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class NeondotBlock extends MushroomBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    public NeondotBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == BlocksPlanetary.SPORESTONE_SOIL.get();
    }
    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = worldIn.getBlockState(pos.below());
        return worldIn.getRawBrightness(pos, 0) < 8 && blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
    }
    public boolean growMushroom(ServerWorld level, BlockPos pos, BlockState state, Random random) {
        level.removeBlock(pos, false);
        ConfiguredFeature<?, ?> configuredfeature = FeaturesPlanetary.Features.HUGE_NEONDOT;

        if (configuredfeature.place(level, level.getChunkSource().getGenerator(), random, pos)) {
            return true;
        } else {
            level.setBlock(pos, state, 3);
            return false;
        }
    }
    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.growMushroom(worldIn, pos, state, rand);
    }
}
