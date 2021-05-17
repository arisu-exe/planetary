package io.github.fallOut015.planetary.block;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FlowerPotBlockPlanetary extends FlowerPotBlock {
    public FlowerPotBlockPlanetary(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> block, Properties properties) {
        super(emptyPot, block, properties);

        if(emptyPot != null) {
            emptyPot.get().addPlant(this.getContent().getRegistryName(), () -> this);
        }
    }
}