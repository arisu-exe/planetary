package io.github.fallOut015.planetary.block;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class CattailsTopBlock extends AbstractTopPlantBlock implements ILiquidContainer {
    public static final BooleanProperty IN_WATER = BooleanProperty.create("in_water");
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D);

    public CattailsTopBlock(AbstractBlock.Properties builder) {
        super(builder, Direction.UP, SHAPE, true, 0.14d);

        this.registerDefaultState(this.stateDefinition.any().setValue(IN_WATER, Boolean.valueOf(true)).setValue(AGE, Integer.valueOf(0)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());

        boolean inTallWater = fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8;
        boolean aboveWater = context.getLevel().getFluidState(context.getClickedPos().below()).is(FluidTags.WATER);

        if(inTallWater) {
            return super.getStateForPlacement(context).setValue(IN_WATER, Boolean.valueOf(true));
        } else if(aboveWater) {
            return super.getStateForPlacement(context).setValue(IN_WATER, Boolean.valueOf(false));
        } else {
            return null;
        }
    }
    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(IN_WATER) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    @Override
    protected boolean canAttachToBlock(Block block) {
        return block != Blocks.MAGMA_BLOCK;
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(IN_WATER);

        super.createBlockStateDefinition(builder);
    }
    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.relative(this.growthDirection);
        int i = Math.min(state.getValue(AGE) + 1, 25);
        int j = this.getBlocksToGrowWhenBonemealed(rand);

        for(int k = 0; k < j && this.canGrowInto(worldIn.getBlockState(blockpos)); ++k) {
            boolean isair = false;
            if(worldIn.isEmptyBlock(blockpos)) {
                isair = true;
                if(worldIn.getFluidState(blockpos.below()).isEmpty()) {
                    return;
                }
            }
            worldIn.setBlockAndUpdate(blockpos, state.setValue(AGE, Integer.valueOf(i)).setValue(IN_WATER, !isair));
            blockpos = blockpos.relative(this.growthDirection);
            i = Math.min(i + 1, 25);
        }
    }


    @Override
    public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return !state.getValue(IN_WATER) && fluidIn == Fluids.WATER;
    }
    @Override
    public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return false;
    }
    @Override
    protected int getBlocksToGrowWhenBonemealed(Random rand) {
        return 1;
    }
    @SuppressWarnings("deprecation")
    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.is(Blocks.WATER) || state.isAir();
    }
    @SuppressWarnings("deprecation")
    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return (worldIn.getBlockState(pos.below()).is(Blocks.WATER) && worldIn.getBlockState(pos).isAir()) || super.isValidBonemealTarget(worldIn, pos, state, isClient);
    }
    @Override
    protected Block getBodyBlock() {
        return BlocksPlanetary.CATTAILS_PLANT.get();
    }
}
