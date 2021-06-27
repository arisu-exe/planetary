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

public class BrimshineBlock extends MushroomBlock {
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D);

    public BrimshineBlock(Properties properties) {
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
    public boolean growMushroom(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        world.removeBlock(pos, false);
        ConfiguredFeature<?, ?> configuredfeature = FeaturesPlanetary.Features.HUGE_BRIMSHINE;

        if (configuredfeature.place(world, world.getChunkSource().getGenerator(), rand, pos)) {
            return true;
        } else {
            world.setBlock(pos, state, 3);
            return false;
        }
    }
}
