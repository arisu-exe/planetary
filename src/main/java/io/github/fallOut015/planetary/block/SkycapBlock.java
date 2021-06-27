package io.github.fallOut015.planetary.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class SkycapBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty ATTACHED = BlockStateProperties.ATTACHED;
    //public static final BooleanProperty STEM = BlockStateProperties.EXTENDED; // change to stem
    protected static final VoxelShape CAP = Block.box(2.0D, 6.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    protected static final VoxelShape STEM = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 12.0D, 9.0D);
    protected static final VoxelShape PARTIAL_STEM = Block.box(7.0D, 2.0D, 7.0D, 9.0D, 12.0D, 9.0D);
    protected static final VoxelShape NORTH_STEM = Block.box(7.0D, 2.0D, 0.0D, 9.0D, 4.0D, 9.0D); // fix
    protected static final VoxelShape EAST_STEM = Block.box(0.0D, 2.0D, 7.0D, 9.0D, 4.0D, 9.0D);
    protected static final VoxelShape SOUTH_STEM = Block.box(7.0D, 2.0D, 7.0D, 9.0D, 4.0D, 0.0D);
    protected static final VoxelShape WEST_STEM = Block.box(7.0D, 2.0D, 7.0D, 9.0D, 4.0D, 0.0D); // TODO fix
    protected static final VoxelShape NONATTACHED_SHAPE = VoxelShapes.or(CAP, STEM);
    protected static final VoxelShape ATTACHED_SHAPE = VoxelShapes.or(CAP, PARTIAL_STEM);

    public SkycapBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ATTACHED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(state.getValue(ATTACHED)) {
            switch((state.getValue(FACING))) {
                case NORTH:
                    return VoxelShapes.or(ATTACHED_SHAPE, NORTH_STEM);
                case EAST:
                    return VoxelShapes.or(ATTACHED_SHAPE, EAST_STEM);
                case SOUTH:
                    return VoxelShapes.or(ATTACHED_SHAPE, SOUTH_STEM);
                case WEST:
                    return VoxelShapes.or(ATTACHED_SHAPE, WEST_STEM);
            }
        }
        return NONATTACHED_SHAPE;
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        switch(context.getClickedFace()) {
            case UP:
            case DOWN: // TODO check for a face to attach to
                return BlocksPlanetary.SKYCAP.get().defaultBlockState();
            case NORTH:
                return BlocksPlanetary.SKYCAP.get().getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(ATTACHED, true);
            case EAST:
                return BlocksPlanetary.SKYCAP.get().getStateDefinition().any().setValue(FACING, Direction.EAST).setValue(ATTACHED, true);
            case SOUTH:
                return BlocksPlanetary.SKYCAP.get().getStateDefinition().any().setValue(FACING, Direction.SOUTH).setValue(ATTACHED, true);
            case WEST:
                return BlocksPlanetary.SKYCAP.get().getStateDefinition().any().setValue(FACING, Direction.WEST).setValue(ATTACHED, true);
        }

        return super.getStateForPlacement(context);
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, ATTACHED);
    }
    private boolean canAttachTo(IBlockReader blockReader, BlockPos blockPos, Direction direction) {
        return !blockReader.getBlockState(blockPos).isAir();
    }
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        return this.canAttachTo(worldIn, pos.relative(direction.getOpposite()), direction);
    }
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing.getOpposite() == stateIn.getValue(FACING) && !stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}