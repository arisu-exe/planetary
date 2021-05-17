package io.github.fallOut015.planetary.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;

public class PurpetalBlock extends FlowerBlock {
    public PurpetalBlock(Properties p_i49984_3_) {
        super(Effects.LEVITATION, 10, p_i49984_3_);
    }

    protected boolean mayPlaceOn(BlockState state, net.minecraft.world.IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.END_STONE;
    };
}