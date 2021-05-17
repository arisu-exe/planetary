package io.github.fallOut015.planetary.block;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class CattailsBlock extends AbstractBodyPlantBlock implements ILiquidContainer {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 16.0D, 16.0D, 16.0D);

    public CattailsBlock(AbstractBlock.Properties properties) {
        super(properties, Direction.UP, SHAPE, true);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }
    @Override
    public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return false;
    }
    @Override
    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BlocksPlanetary.CATTAILS.get();
    }
}
