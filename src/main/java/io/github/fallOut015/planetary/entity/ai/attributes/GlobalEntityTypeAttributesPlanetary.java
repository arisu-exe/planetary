package io.github.fallOut015.planetary.entity.ai.attributes;

import io.github.fallOut015.planetary.entity.EntitiesPlanetary;
import io.github.fallOut015.planetary.entity.monster.MummifiedZombieEntity;
import io.github.fallOut015.planetary.entity.passive.CrimpEntity;
import io.github.fallOut015.planetary.entity.passive.JellyfishEntity;
import io.github.fallOut015.planetary.entity.passive.PenguinEntity;
import io.github.fallOut015.planetary.entity.passive.RedPandaEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class GlobalEntityTypeAttributesPlanetary {
    public static void setup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.CRIMP.get(), CrimpEntity.applyAttributes().build());
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.JELLYFISH.get(), JellyfishEntity.applyAttributes().build());
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.PENGUIN.get(), PenguinEntity.applyAttributes().build());
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.RED_PANDA.get(), RedPandaEntity.applyAttributes().build());

        GlobalEntityTypeAttributes.put(EntitiesPlanetary.MUMMIFIED_ZOMBIE.get(), MummifiedZombieEntity.applyAttributes().build());
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.ICE_SLIME.get(), MonsterEntity.createMonsterAttributes().build()); // TODO give own stats.
        GlobalEntityTypeAttributes.put(EntitiesPlanetary.NETHER_FISH.get(), AbstractFishEntity.createMobAttributes().build()); // TODO give own stats.

        //GlobalEntityTypeAttributes.put(EntitiesPlanetary.MAGMEEL.get(), MagmeelEntity.applyAttributes().create());
    }
}
