package io.github.fallOut015.planetary.entity.passive;

import io.github.fallOut015.planetary.client.renderer.entity.PenguinRenderer;
import io.github.fallOut015.planetary.entity.EntitiesPlanetary;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PenguinEntity extends AnimalEntity {
    private static final DataParameter<ItemStack> FISH = EntityDataManager.defineId(PenguinEntity.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(PenguinEntity.class, DataSerializers.INT);
    // penguins have a separate pose for when swimming
    // penguins guard their babies
    // eat fish and feed to babies
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.SALMON, Items.COD);

    public PenguinEntity(EntityType<? extends PenguinEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity p_241840_2_) {
        return EntitiesPlanetary.PENGUIN.get().create(serverWorld);
    }

    public static AttributeModifierMap.MutableAttribute applyAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.19F).add(Attributes.MAX_HEALTH, 5.0D);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(FISH, ItemStack.EMPTY);
        this.entityData.define(VARIANT, 0);
    }
    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);

        ItemStack fish = ItemStack.EMPTY;
        fish.deserializeNBT((CompoundNBT) nbt.get("FISH"));
        this.entityData.set(FISH, fish);
        this.entityData.set(VARIANT, nbt.getInt("VARIANT"));
    }
    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);

        nbt.put("FISH", this.entityData.get(FISH).serializeNBT());
        nbt.putInt("VARIANT", this.entityData.get(VARIANT).intValue());
    }
    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        /*this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, true, TEMPTATION_ITEMS) {
            @Override
            public boolean canContinueToUse() {
                return this.mob instanceof PenguinEntity && !((PenguinEntity) this.mob).hasFish() && super.canContinueToUse();
            }
            @Override
            public boolean canUse() {
                return this.mob instanceof PenguinEntity && !((PenguinEntity) this.mob).hasFish() && super.canUse();
            }
        });*/
        //this.goalSelector.addGoal(3, new PenguinEntity.FeedChildGoal(this, 1.0D, 10));
        //this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));
        //this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1.0D));
        //this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 10.0F));
        //this.goalSelector.addGoal(8, new PanicGoal(this, 1.75D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractFishEntity.class, false));
    }
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
        this.setVariant(this.random.nextInt(PenguinRenderer.TEXTURE.length));

        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public boolean hasFish() {
        return !this.entityData.get(FISH).isEmpty();
    }
    public ItemStack getFish() {
        return this.entityData.get(FISH);
    }
    public void setFish(ItemStack fish) {
        if(fish.getItem() == Items.SALMON || fish.getItem() == Items.COD) {
            this.entityData.set(FISH, fish);
        }
    }
    public ItemStack removeFish() {
        ItemStack stack = this.getFish();
        this.entityData.set(FISH, ItemStack.EMPTY);
        return stack;
    }
    public int getVariant() {
        return this.entityData.get(VARIANT).intValue();
    }
    public void setVariant(int value) {
        this.entityData.set(VARIANT, value);
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity playerEntity, Hand hand) {
        if(!this.isBaby() && playerEntity.getItemInHand(hand).getItem() == Items.SALMON || playerEntity.getItemInHand(hand).getItem() == Items.COD) {
            this.setFish(new ItemStack(playerEntity.getItemInHand(hand).getItem()));
            playerEntity.getItemInHand(hand).shrink(1);
        } else if(playerEntity.getItemInHand(hand).isEmpty() && this.hasFish()) {
            playerEntity.setItemInHand(hand, this.getFish());
            this.removeFish();
        }

        return ActionResultType.CONSUME;
    }
    @Override
    public void push(Entity entityIn) {
        if(this.hasFish()) {
            if(entityIn instanceof PenguinEntity && entityIn.getType() == EntitiesPlanetary.PENGUIN.get() && ((PenguinEntity) entityIn).isBaby()) {
                ((PenguinEntity) entityIn).setFish(this.removeFish());
            }
        } else {
            if(entityIn.getType() == EntityType.SALMON) {
                entityIn.remove();
                this.setFish(new ItemStack(Items.SALMON));
            } else if(entityIn.getType() == EntityType.COD) {
                entityIn.remove();
                this.setFish(new ItemStack(Items.COD));
            }
        }

        super.push(entityIn);
    }

    public class FeedChildGoal extends Goal {
        protected final PenguinEntity creature;
        private final double speed;
        private final double distance;
        private final PathNavigator navigator;

        public FeedChildGoal(CreatureEntity creatureIn, double speedIn, double distanceIn) {
            this.creature = (PenguinEntity) creatureIn;
            this.speed = speedIn;
            this.distance = distanceIn;
            this.navigator = creatureIn.getNavigation();

            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.creature.hasFish();
        }
        @Override
        public boolean canContinueToUse() {
            return this.creature.hasFish();
        }
        @Override
        public void tick() {
            // Find the nearest child penguin with the least health.
            float minhealth = this.creature.getMaxHealth();
            @Nullable Entity target = null;
            for(PenguinEntity penguin : this.creature.level.getEntities(EntitiesPlanetary.PENGUIN.get(), new AxisAlignedBB(new BlockPos(this.creature.position())).inflate(this.distance), penguin -> penguin.isBaby())) {
                if(penguin.getHealth() < minhealth) {
                    minhealth = penguin.getHealth();
                    target = penguin;
                }
            }
            if(target != null) {
                this.navigator.moveTo(this.navigator.createPath(target, (int) this.distance), this.speed);
            }

            super.tick();
        }
    }
}