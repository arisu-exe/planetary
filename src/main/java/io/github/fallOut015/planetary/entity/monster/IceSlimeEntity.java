package io.github.fallOut015.planetary.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class IceSlimeEntity extends SlimeEntity {
    public IceSlimeEntity(EntityType<? extends IceSlimeEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void dealDamage(LivingEntity target) {
        if(this.isAlive()) {
            int i = this.getSize();
            if (this.distanceToSqr(target) < 0.6D * (double)i * 0.6D * (double)i && this.canSee(target) && target.hurt(DamageSource.mobAttack(this), this.getAttackDamage())) {
                this.playSound(SoundEvents.SLIME_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.doEnchantDamageEffects(this, target);
                // make frozen
            }
        }
    }
    @Override
    protected int getJumpDelay() {
        return this.random.nextInt(30) + 20;
    }
    @Override
    protected IParticleData getParticleType() {
        return ParticleTypes.ITEM_SNOWBALL; // TODO change to icy slime ball
    }
    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            double x = this.getX() - this.getBbWidth() / 2 + this.random.nextInt((int) this.getBbWidth() + 1);
            double y = this.getY() - this.getBbHeight() / 2 + this.random.nextInt((int) this.getBbHeight() + 1);
            double z = this.getZ() - this.getBbWidth() / 2 + this.random.nextInt((int) this.getBbWidth() + 1);
            this.level.addParticle(ParticleTypes.CLOUD, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    @SuppressWarnings("deprecation")
    public static boolean canSpawn(EntityType<IceSlimeEntity> iceSlimeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (pos.getY() >= worldIn.getSeaLevel() / 2) {
            return randomIn.nextInt(10) == 0; // small chance of spawning above ground.
        }
        return true; // spawns underground.
    }
}