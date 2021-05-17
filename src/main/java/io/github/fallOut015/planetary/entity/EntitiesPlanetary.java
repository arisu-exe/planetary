package io.github.fallOut015.planetary.entity;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.entity.monster.IceSlimeEntity;
import io.github.fallOut015.planetary.entity.monster.MummifiedZombieEntity;
import io.github.fallOut015.planetary.entity.monster.NetherFishEntity;
import io.github.fallOut015.planetary.entity.passive.CrimpEntity;
import io.github.fallOut015.planetary.entity.passive.JellyfishEntity;
import io.github.fallOut015.planetary.entity.passive.PenguinEntity;
import io.github.fallOut015.planetary.entity.passive.RedPandaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitiesPlanetary {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MainPlanetary.MODID);



    public static final RegistryObject<EntityType<CrimpEntity>> CRIMP = ENTITIES.register("crimp", () -> EntityType.Builder.of(CrimpEntity::new, EntityClassification.CREATURE).sized(0.6875f, 1f).build("crimp"));
    public static final RegistryObject<EntityType<JellyfishEntity>> JELLYFISH = ENTITIES.register("jellyfish", () -> EntityType.Builder.of(JellyfishEntity::new, EntityClassification.CREATURE).sized(0.75f, 0.75f).build("jellyfish"));
    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITIES.register("penguin", () -> EntityType.Builder.of(PenguinEntity::new, EntityClassification.CREATURE).sized(0.5f, 0.8f).build("penguin"));
    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA = ENTITIES.register("red_panda", () -> EntityType.Builder.of(RedPandaEntity::new, EntityClassification.CREATURE).sized(0.6875f, 1f).build("red_panda"));
    public static final RegistryObject<EntityType<MummifiedZombieEntity>> MUMMIFIED_ZOMBIE = ENTITIES.register("mummified_zombie", () -> EntityType.Builder.of(MummifiedZombieEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.95F).build("mummified_zombie"));
    public static final RegistryObject<EntityType<IceSlimeEntity>> ICE_SLIME = ENTITIES.register("ice_slime", () -> EntityType.Builder.of(IceSlimeEntity::new, EntityClassification.MONSTER).sized(2.04F, 2.04F).build("ice_slime"));
    public static final RegistryObject<EntityType<NetherFishEntity>> NETHER_FISH = ENTITIES.register("nether_fish", () -> EntityType.Builder.of(NetherFishEntity::new, EntityClassification.MONSTER).sized(2.04f, 2.04f).build("nether_fish"));
    //public static final RegistryObject<EntityType<BoatEntityTwo>> BOAT_TWO = ENTITIES.register("boat_two", () -> EntityType.Builder.of(BoatEntityTwo::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10).build("boat_two"));
    //public static final RegistryObject<EntityType<MagmeelEntity>> MAGMEEL = ENTITIES.register("magmeel", () -> EntityType.Builder.of(MagmeelEntity::new, EntityClassification.MONSTER).size(0.5f, 0.5f).build("magmeel"));



    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
