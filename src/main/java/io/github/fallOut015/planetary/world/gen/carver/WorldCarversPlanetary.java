package io.github.fallOut015.planetary.world.gen.carver;

import io.github.fallOut015.planetary.MainPlanetary;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldCarversPlanetary {
    private static final DeferredRegister<WorldCarver<?>> WORLD_CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, MainPlanetary.MODID);

    public static final RegistryObject<CavernWorldCarver> CAVERN = WORLD_CARVERS.register("cavern", () -> new CavernWorldCarver(ProbabilityConfig.CODEC, 128));
    // huge cave ^
    // slightly bigger cave
    // carvers for specific underground biomes
    public static final RegistryObject<WideCaveWorldCarver> WIDE_CAVE = WORLD_CARVERS.register("wide_cave", () -> new WideCaveWorldCarver(ProbabilityConfig.CODEC, 128));
    // crater

    public static void register(IEventBus bus) {
        WORLD_CARVERS.register(bus);
    }
}