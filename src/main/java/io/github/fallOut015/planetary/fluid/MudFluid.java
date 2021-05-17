package io.github.fallOut015.planetary.fluid;

import io.github.fallOut015.planetary.block.BlocksPlanetary;
import io.github.fallOut015.planetary.item.ItemsPlanetary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class MudFluid extends FlowingFluid {
    public Fluid getFlowing() {
        return FluidsPlanetary.FLOWING_MUD.get();
    }
    public Fluid getSource() {
        return FluidsPlanetary.MUD.get();
    }
    public Item getBucket() {
        return ItemsPlanetary.MUD_BUCKET.get();
    }

    @Override
    protected boolean canConvertToSource() {
        return false;
    }
    @Override
    protected void beforeDestroyingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.hasTileEntity() ? worldIn.getBlockEntity(pos) : null;
        Block.dropResources(state, worldIn, pos, tileentity);
    }
    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn) {
        return 4;
    }
    @Override
    protected int getDropOff(IWorldReader worldIn) {
        return 2;
    }
    @Override
    public boolean canBeReplacedWith(FluidState state, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(FluidTags.WATER);
    }
    @Override
    public int getTickDelay(IWorldReader p_205569_1_) {
        return 10;
    }
    @Override
    protected float getExplosionResistance() {
        return 150f;
    }
    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return BlocksPlanetary.MUD.get().defaultBlockState().setValue(LEVEL, Integer.valueOf(FlowingFluid.getLegacyLevel(state)));
    }
    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(new ResourceLocation("planetary", "block/mud_still"), new ResourceLocation("two", "block/mud_flow")).translationKey("block.two.mud").density(1500).build(this);
    }
    @Override
    public boolean isSame(Fluid fluidIn) {
        return fluidIn == FluidsPlanetary.MUD.get() || fluidIn == FluidsPlanetary.FLOWING_MUD.get();
    }

    public static class Flowing extends MudFluid {
        protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends MudFluid {
        public int getAmount(FluidState state) {
            return 8;
        }
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}