package io.github.fallOut015.planetary.world.gen.feature;

import com.google.common.collect.ImmutableList;
import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.block.BlocksPlanetary;
import io.github.fallOut015.planetary.world.gen.placement.DecoratorsPlanetary;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeaturesPlanetary {
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MainPlanetary.MODID);



    public static final RegistryObject<Feature<ReplaceBlockConfig>> REPLACE_BLOCK = FEATURES.register("replace_block", () -> new ReplaceBlockFeature(ReplaceBlockConfig.CODEC));
    public static final RegistryObject<Feature<MultiReplaceBlockConfig>> MULTI_REPLACE_BLOCK = FEATURES.register("multi_replace_block", () -> new MultiReplaceBlockFeature(MultiReplaceBlockConfig.CODEC));
    public static final RegistryObject<Feature<NoFeatureConfig>> DESERT_ARCH = FEATURES.register("desert_arch", () -> new DesertArchFeature(NoFeatureConfig.CODEC));
    public static final RegistryObject<Feature<NoFeatureConfig>> BADLANDS_ARCH = FEATURES.register("badlands_arch", () -> new BadlandsArchFeature(NoFeatureConfig.CODEC));



    public static void register(IEventBus bus) {
        FEATURES.register(bus);
    }

    public static final class Features {
        public static final ConfiguredFeature<?, ?> DESERT_STONE_REPLACER = MULTI_REPLACE_BLOCK.get().configured(Configs.DESERT_STONE_REPLACER_CONFIG).decorated(Placements.PLACE_ALL_TO_64);
        public static final ConfiguredFeature<?, ?> DESERT_SANDSTONE_PLACER = REPLACE_BLOCK.get().configured(Configs.DESERT_SANDSTONE_PLACER_CONFIG).range(64).chance(2);

        //public static final ConfiguredFeature<?, ?> ORE_DESERT_COAL = register("ore_desert_coal", Feature.ORE.configured(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_COAL_ORE, 19/*size*/)).range(128/*y max*/).square().count(20 /*spread*/));
        //public static final ConfiguredFeature<?, ?> ORE_DESERT_IRON = register("ore_desert_iron", Feature.ORE.configured(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_IRON_ORE, 11)).range(64).square().count(20));
        //public static final ConfiguredFeature<?, ?> ORE_DESERT_GOLD = register("ore_desert_gold", Feature.ORE.configured(new OreFeatureConfig(FeaturesTwo.RuleTests.SMOOTH_SANDSTONE, FeaturesTwo.States.DESERT_GOLD_ORE, 11)).range(48).square().count(20));

        public static final ConfiguredFeature<?, ?> SUCCULIGHT = Feature.SIMPLE_BLOCK.configured(FeaturesPlanetary.Configs.SUCCULIGHT_CONFIG).decorated(net.minecraft.world.gen.feature.Features.Placements.FIRE).count(10);

        public static final ConfiguredFeature<?, ?> DESERT_ARCH = FeaturesPlanetary.DESERT_ARCH.get().configured(NoFeatureConfig.NONE).decorated(Placement.HEIGHTMAP_WORLD_SURFACE.configured(NoPlacementConfig.NONE).chance(64));
        public static final ConfiguredFeature<?, ?> BADLANDS_ARCH = FeaturesPlanetary.BADLANDS_ARCH.get().configured(NoFeatureConfig.NONE).decorated(Placement.HEIGHTMAP_WORLD_SURFACE.configured(NoPlacementConfig.NONE).chance(128));
    }

    public static final class Configs {
        public static final MultiReplaceBlockConfig DESERT_STONE_REPLACER_CONFIG = new MultiReplaceBlockConfig(States.STONE, States.SMOOTH_SANDSTONE, States.STONE, States.SAND);
        public static final ReplaceBlockConfig DESERT_SANDSTONE_PLACER_CONFIG = new ReplaceBlockConfig(States.SMOOTH_SANDSTONE, States.SANDSTONE);
        public static final BlockWithContextConfig SUCCULIGHT_CONFIG = new BlockWithContextConfig(States.SUCCULIGHT, ImmutableList.of(States.SAND), ImmutableList.of(States.CAVE_AIR), ImmutableList.of());
    }

    public static final class Placements {
        public static final ConfiguredPlacement<?> PLACE_ALL_TO_64 = DecoratorsPlanetary.PLACE_ALL_TO_64.get().configured(IPlacementConfig.NONE);
    }

    public static final class States { // values of block states.
        protected static final BlockState SUCCULIGHT = BlocksPlanetary.SUCCULIGHT.get().defaultBlockState();
        protected static final BlockState SAND = Blocks.SAND.defaultBlockState();
        protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
        protected static final BlockState SMOOTH_SANDSTONE = Blocks.SMOOTH_SANDSTONE.defaultBlockState();
        protected static final BlockState SANDSTONE = Blocks.SANDSTONE.defaultBlockState();
        protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
        //protected static final BlockState DESERT_COAL_ORE = BlocksTwo.DESERT_COAL_ORE.getDefaultState();
        //protected static final BlockState DESERT_IRON_ORE = BlocksTwo.DESERT_IRON_ORE.getDefaultState();
        //protected static final BlockState DESERT_GOLD_ORE = BlocksTwo.DESERT_GOLD_ORE.getDefaultState();
    }
}