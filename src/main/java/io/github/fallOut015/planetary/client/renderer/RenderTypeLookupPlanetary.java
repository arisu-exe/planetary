package io.github.fallOut015.planetary.client.renderer;

import io.github.fallOut015.planetary.block.BlocksPlanetary;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderTypeLookupPlanetary {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.PURPETAL.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.SPORESTONE_ROOTS.get(), RenderType.translucent());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.NEONDOT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.BRIMSHINE.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.SHROOMGLOW_LANTERN.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.CHERRY_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.MAPLE_SAPLING.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.CATTAILS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.CATTAILS_PLANT.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.MAPLE_TAP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.ICE_SLIME_BLOCK.get(), RenderType.translucent());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.SUCCULIGHT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.POTTED_SUCCULIGHT.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.SKYCAP.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(BlocksPlanetary.IVY.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlocksPlanetary.MANDRAKE.get(), RenderType.cutout());
    }
}