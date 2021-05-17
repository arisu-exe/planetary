package io.github.fallOut015.planetary;

import io.github.fallOut015.planetary.block.BlocksPlanetary;
import io.github.fallOut015.planetary.client.registry.RenderingRegistryPlanetary;
import io.github.fallOut015.planetary.client.renderer.RenderTypeLookupPlanetary;
import io.github.fallOut015.planetary.entity.EntitiesPlanetary;
import io.github.fallOut015.planetary.entity.ai.attributes.GlobalEntityTypeAttributesPlanetary;
import io.github.fallOut015.planetary.fluid.FluidsPlanetary;
import io.github.fallOut015.planetary.item.ItemsPlanetary;
import io.github.fallOut015.planetary.world.gen.carver.WorldCarversPlanetary;
import io.github.fallOut015.planetary.world.gen.feature.FeaturesPlanetary;
import io.github.fallOut015.planetary.world.gen.placement.DecoratorsPlanetary;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Mod(MainPlanetary.MODID)
public class MainPlanetary  {
    public static final String MODID = "planetary";

    public MainPlanetary() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        BlocksPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemsPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntitiesPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        DecoratorsPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        FeaturesPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        FluidsPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
        WorldCarversPlanetary.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {
        /*String[] paths = {
                "../src/main/resources/assets/planetary/blockstates",
                "../src/main/resources/assets/planetary/models/block",
                "../src/main/resources/assets/planetary/models/item",
        };
        for(String path : paths) {
            try {
                Files.walk(Paths.get(path)).filter(Files::isRegularFile).forEach(file -> {
                    try {
                        List<String> lines = Files.readAllLines(file.toAbsolutePath(), Charset.defaultCharset());
                        for(int i = 0; i < lines.size(); ++ i) {
                            lines.set(i, lines.get(i).replace("two", "planetary"));
                        }
                        Files.write(file.toAbsolutePath(), lines);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                });
            } catch(final IOException exception) {
                exception.printStackTrace();
            }
        }*/
        GlobalEntityTypeAttributesPlanetary.setup(event);
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookupPlanetary.doClientStuff(event);
        RenderingRegistryPlanetary.doClientStuff(event);
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void onBiomeLoad(final BiomeLoadingEvent biomeLoadingEvent) {
            switch(biomeLoadingEvent.getCategory()) {
                case DESERT:
                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.RAW_GENERATION).add(() -> FeaturesPlanetary.Features.DESERT_STONE_REPLACER);

                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).clear();
                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> FeaturesPlanetary.Features.DESERT_SANDSTONE_PLACER);
                    //biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_COAL);
                    //biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_GOLD);
                    //biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> FeaturesTwo.ORE_DESERT_IRON);

                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_DECORATION).add(() -> FeaturesPlanetary.Features.SUCCULIGHT);

                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_STRUCTURES).add(() -> Features.FOSSIL.chance(1));

                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.TOP_LAYER_MODIFICATION).add(() -> FeaturesPlanetary.Features.DESERT_ARCH);

                    break;
                case MESA:
                    biomeLoadingEvent.getGeneration().getFeatures(GenerationStage.Decoration.TOP_LAYER_MODIFICATION).add(() -> FeaturesPlanetary.Features.BADLANDS_ARCH);

                    break;
            }
        }
    }
}