package io.github.fallOut015.planetary.client.registry;

import io.github.fallOut015.planetary.client.renderer.entity.*;
import io.github.fallOut015.planetary.entity.EntitiesPlanetary;
import net.minecraft.client.renderer.entity.EvokerFangsRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderingRegistryPlanetary {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.CRIMP.get(), CrimpRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.JELLYFISH.get(), JellyfishRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.PENGUIN.get(), PenguinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.RED_PANDA.get(), RedPandaRenderer::new);

//        RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.BOAT_TWO.get(), BoatRendererTwo::new);

        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.MUMMIFIED_ZOMBIE.get(), MummifiedZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.ICE_SLIME.get(), IceSlimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesPlanetary.NETHER_FISH.get(), NetherFishRenderer::new);

//    	RenderingRegistry.registerEntityRenderingHandler(EntityType.WOLF, WolfRendererTwo::new); // TODO

//    	RenderingRegistry.registerEntityRenderingHandler(EntityTypeTwo.MAGMEEL, MagmeelRenderer::new);
    }
}
