package io.github.fallOut015.planetary.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class NetherFishEntity extends AbstractFishEntity {
    public NetherFishEntity(EntityType<? extends NetherFishEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected ItemStack getBucketItemStack() {
        return null;
    }
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.LAVA_POP;
    }
    @Override
    public boolean isOnFire() {
        return false;
    }
}