package io.github.fallOut015.planetary.world.gen.feature;

import com.google.common.collect.ImmutableList;
import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.block.BlocksPlanetary;
import io.github.fallOut015.planetary.world.gen.placement.DecoratorsPlanetary;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
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

    public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_NEONDOT = FEATURES.register("huge_neondot", () -> new BigNeondotFeature(BigMushroomFeatureConfig.CODEC));
    public static final RegistryObject<Feature<BigMushroomFeatureConfig>> HUGE_BRIMSHINE = FEATURES.register("huge_brimshine", () -> new BigBrimshineFeature(BigMushroomFeatureConfig.CODEC));

    public static final RegistryObject<Feature<NoFeatureConfig>> CATTAILS = FEATURES.register("cattails", () -> new CattailsFeature(NoFeatureConfig.CODEC));



    public static void register(IEventBus bus) {
        FEATURES.register(bus);
    }

    public static final class Features {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MAPLE = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MAPLE_LOG), new SimpleBlockStateProvider(States.MAPLE_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY = Feature.TREE.configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CHERRY_LOG), new SimpleBlockStateProvider(States.CHERRY_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build());

        public static final ConfiguredFeature<?, ?> HUGE_NEONDOT = FeaturesPlanetary.HUGE_NEONDOT.get().configured(new BigMushroomFeatureConfig(new SimpleBlockStateProvider(States.NEONDOT_CAP), new SimpleBlockStateProvider(States.NEONDOT_STEM), 2));
        public static final ConfiguredFeature<?, ?> HUGE_BRIMSHINE = FeaturesPlanetary.HUGE_BRIMSHINE.get().configured(new BigMushroomFeatureConfig(new SimpleBlockStateProvider(States.BRIMSHINE_CAP), new SimpleBlockStateProvider(States.BRIMSHINE_STEM), 3));

        public static final ConfiguredFeature<?, ?> DESERT_STONE_REPLACER = MULTI_REPLACE_BLOCK.get().configured(Configs.DESERT_STONE_REPLACER_CONFIG).decorated(Placements.PLACE_ALL_TO_64);
        public static final ConfiguredFeature<?, ?> MUSHROOM_STONE_REPLACER = MULTI_REPLACE_BLOCK.get().configured(Configs.MUSHROOM_STONE_REPLACER_CONFIG).decorated(Placements.PLACE_ALL_TO_64);
        public static final ConfiguredFeature<?, ?> ICY_STONE_REPLACER = REPLACE_BLOCK.get().configured(Configs.ICY_STONE_REPLACER_CONFIG).decorated(Placements.PLACE_ALL_TO_64);

        public static final ConfiguredFeature<?, ?> DESERT_SANDSTONE_PLACER = REPLACE_BLOCK.get().configured(Configs.DESERT_SANDSTONE_PLACER_CONFIG).range(64).chance(2);

        public static final ConfiguredFeature<?, ?> ORE_DESERT_COAL = Feature.ORE.configured(new OreFeatureConfig(RuleTests.SMOOTH_SANDSTONE, States.DESERT_COAL_ORE, 19/*size*/)).range(128/*y max*/).squared().count(20 /*spread*/);
        public static final ConfiguredFeature<?, ?> ORE_DESERT_IRON = Feature.ORE.configured(new OreFeatureConfig(RuleTests.SMOOTH_SANDSTONE, States.DESERT_IRON_ORE, 11)).range(64).squared().count(20);
        public static final ConfiguredFeature<?, ?> ORE_DESERT_GOLD = Feature.ORE.configured(new OreFeatureConfig(RuleTests.SMOOTH_SANDSTONE, States.DESERT_GOLD_ORE, 11)).range(48).squared().count(20);

    //	public static final ConfiguredFeature<?, ?> ORE_DESERT_COPPER = register("ore_desert_copper", Feature.ORE.configured(new OreFeatureConfig(RuleTests.SMOOTH_SANDSTONE, States.DESERT_COPPER_ORE, 11)).range(48).squared().count()(20));

    	public static final ConfiguredFeature<?, ?> ORE_NETHER_GARNET = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, States.NETHER_GARNET_ORE, 17)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_NETHER_TOPAZ = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, States.NETHER_TOPAZ_ORE, 17)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_NETHER_LEAD = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, States.NETHER_LEAD_ORE, 17)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_NETHER_TITANIUM = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, States.NETHER_TITANIUM_ORE, 17)).range(128).squared().count(20);

    	public static final ConfiguredFeature<?, ?> ORE_OPAL = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.OPAL_ORE, 7)).range(8).squared().count(10);
    	public static final ConfiguredFeature<?, ?> ORE_TANZANITE = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.TANZANITE_ORE, 1)).range(16).squared();
    	public static final ConfiguredFeature<?, ?> ORE_RUBY = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.RUBY_ORE, 8)).range(16).squared();
    	public static final ConfiguredFeature<?, ?> ORE_TALC = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.TALC_ORE, 17)).range(128).squared().count(40);
    	public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.TIN_ORE, 11)).range(64).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_ALUMINUM = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.ALUMINUM_ORE, 9)).range(64).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_SILVER = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.SILVER_ORE, 7)).range(48).squared().count(10);
    	public static final ConfiguredFeature<?, ?> ORE_PYRITE = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.PYRITE_ORE, 9)).range(32).squared().count(2);

    	public static final ConfiguredFeature<?, ?> ORE_END_COBALT = Feature.ORE.configured(new OreFeatureConfig(RuleTests.END_STONE, States.END_COBALT_ORE, 7)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_END_JADE = Feature.ORE.configured(new OreFeatureConfig(RuleTests.END_STONE, States.END_JADE_ORE, 7)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_END_SAPPHIRE = Feature.ORE.configured(new OreFeatureConfig(RuleTests.END_STONE, States.END_SAPPHIRE_ORE, 7)).range(128).squared().count(20);
    	public static final ConfiguredFeature<?, ?> ORE_END_PLATINUM = Feature.ORE.configured(new OreFeatureConfig(RuleTests.END_STONE, States.END_PLATINUM_ORE, 5)).range(128).squared().count(20);

        public static final ConfiguredFeature<?, ?> SUCCULIGHT = Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.SUCCULIGHT), new SimpleBlockPlacer())).tries(10).noProjection().build());

        public static final ConfiguredFeature<?, ?> DESERT_ARCH = FeaturesPlanetary.DESERT_ARCH.get().configured(NoFeatureConfig.NONE).decorated(Placement.HEIGHTMAP_WORLD_SURFACE.configured(NoPlacementConfig.NONE).chance(64));
        public static final ConfiguredFeature<?, ?> BADLANDS_ARCH = FeaturesPlanetary.BADLANDS_ARCH.get().configured(NoFeatureConfig.NONE).decorated(Placement.HEIGHTMAP_WORLD_SURFACE.configured(NoPlacementConfig.NONE).chance(128));

        public static final ConfiguredFeature<?, ?> SWAMP_CATTAILS = FeaturesPlanetary.CATTAILS.get().configured(IFeatureConfig.NONE).decorated(Placements.CATTAILS_PLACEMENT).squared().decorated(Placement.COUNT_NOISE_BIASED.configured(new TopSolidWithNoiseConfig(120, 80.0D, 0.0D)));
    }

    public static final class Configs {
        public static final MultiReplaceBlockConfig DESERT_STONE_REPLACER_CONFIG = new MultiReplaceBlockConfig(States.STONE, States.SMOOTH_SANDSTONE, States.STONE, States.SAND);
        public static final MultiReplaceBlockConfig MUSHROOM_STONE_REPLACER_CONFIG = new MultiReplaceBlockConfig(States.STONE, States.SPORESTONE, States.STONE, States.SPORESTONE_SOIL);
        public static final ReplaceBlockConfig ICY_STONE_REPLACER_CONFIG = new ReplaceBlockConfig(States.STONE, States.PACKED_ICE);

        public static final ReplaceBlockConfig DESERT_SANDSTONE_PLACER_CONFIG = new ReplaceBlockConfig(States.SMOOTH_SANDSTONE, States.SANDSTONE);
        //public static final BlockWithContextConfig NEONDOT_CONFIG = new BlockWithContextConfig(States.NEONDOT, ImmutableList.of(States.SPORESTONE_SOIL), ImmutableList.of(States.CAVE_AIR), ImmutableList.of());
        //public static final BlockWithContextConfig BRIMSHINE_CONFIG = new BlockWithContextConfig(States.BRIMSHINE, ImmutableList.of(States.SPORESTONE_SOIL), ImmutableList.of(States.CAVE_AIR), ImmutableList.of());

        public static final BlockWithContextConfig SUCCULIGHT_CONFIG = new BlockWithContextConfig(States.SUCCULIGHT, ImmutableList.of(States.SAND), ImmutableList.of(States.CAVE_AIR), ImmutableList.of());
    }

    public static final class Placements {
        public static final ConfiguredPlacement<NoPlacementConfig> CATTAILS_PLACEMENT = Placement.TOP_SOLID_HEIGHTMAP.configured(IPlacementConfig.NONE);
        public static final ConfiguredPlacement<?> PLACE_ALL_TO_64 = DecoratorsPlanetary.PLACE_ALL_TO_64.get().configured(IPlacementConfig.NONE);
    }

    public static final class States {
        protected static final BlockState SUCCULIGHT = BlocksPlanetary.SUCCULIGHT.get().defaultBlockState();
        protected static final BlockState SAND = Blocks.SAND.defaultBlockState();
        protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
        protected static final BlockState SMOOTH_SANDSTONE = Blocks.SMOOTH_SANDSTONE.defaultBlockState();
        protected static final BlockState PACKED_ICE = Blocks.PACKED_ICE.defaultBlockState();
        protected static final BlockState SANDSTONE = Blocks.SANDSTONE.defaultBlockState();
        protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
        protected static final BlockState SPORESTONE = BlocksPlanetary.SPORESTONE.get().defaultBlockState();
        protected static final BlockState SPORESTONE_SOIL = BlocksPlanetary.SPORESTONE_SOIL.get().defaultBlockState();

        protected static final BlockState DESERT_COAL_ORE = BlocksPlanetary.DESERT_COAL_ORE.get().defaultBlockState();
        protected static final BlockState DESERT_IRON_ORE = BlocksPlanetary.DESERT_IRON_ORE.get().defaultBlockState();
        protected static final BlockState DESERT_GOLD_ORE = BlocksPlanetary.DESERT_GOLD_ORE.get().defaultBlockState();

        //protected static final BlockState DESERT_COPPER_ORE = BlocksPlanetary.DESERT_COPPER_ORE.get().defaultBlockState();

        protected static final BlockState END_COBALT_ORE = BlocksPlanetary.END_COBALT_ORE.get().defaultBlockState();
        protected static final BlockState END_JADE_ORE = BlocksPlanetary.END_JADE_ORE.get().defaultBlockState();
        protected static final BlockState OPAL_ORE = BlocksPlanetary.OPAL_ORE.get().defaultBlockState();
        protected static final BlockState TANZANITE_ORE = BlocksPlanetary.TANZANITE_ORE.get().defaultBlockState();
        protected static final BlockState NETHER_GARNET_ORE = BlocksPlanetary.NETHER_GARNET_ORE.get().defaultBlockState();
        protected static final BlockState NETHER_TOPAZ_ORE = BlocksPlanetary.NETHER_TOPAZ_ORE.get().defaultBlockState();
        protected static final BlockState END_SAPPHIRE_ORE = BlocksPlanetary.END_SAPPHIRE_ORE.get().defaultBlockState();
        protected static final BlockState RUBY_ORE = BlocksPlanetary.RUBY_ORE.get().defaultBlockState();

        protected static final BlockState TALC_ORE = BlocksPlanetary.TALC_ORE.get().defaultBlockState();
        protected static final BlockState NETHER_LEAD_ORE = BlocksPlanetary.NETHER_LEAD_ORE.get().defaultBlockState();
        protected static final BlockState TIN_ORE = BlocksPlanetary.TIN_ORE.get().defaultBlockState();
        protected static final BlockState ALUMINUM_ORE = BlocksPlanetary.ALUMINUM_ORE.get().defaultBlockState();
        protected static final BlockState SILVER_ORE = BlocksPlanetary.SILVER_ORE.get().defaultBlockState();
        protected static final BlockState END_PLATINUM_ORE = BlocksPlanetary.END_PLATINUM_ORE.get().defaultBlockState();
        protected static final BlockState NETHER_TITANIUM_ORE = BlocksPlanetary.NETHER_TITANIUM_ORE.get().defaultBlockState();
        protected static final BlockState PYRITE_ORE = BlocksPlanetary.PYRITE_ORE.get().defaultBlockState();

        protected static final BlockState CHERRY_LOG = BlocksPlanetary.CHERRY_LOG.get().defaultBlockState();
        protected static final BlockState CHERRY_LEAVES = BlocksPlanetary.CHERRY_LEAVES.get().defaultBlockState();
        protected static final BlockState MAPLE_LEAVES = BlocksPlanetary.MAPLE_LEAVES.get().defaultBlockState();
        protected static final BlockState MAPLE_LOG = BlocksPlanetary.MAPLE_LOG.get().defaultBlockState();
		protected static final BlockState NEONDOT_CAP = BlocksPlanetary.NEONDOT_CAP.get().defaultBlockState();
		protected static final BlockState NEONDOT_STEM = BlocksPlanetary.NEONDOT_STEM.get().defaultBlockState();
		protected static final BlockState BRIMSHINE_CAP = BlocksPlanetary.BRIMSHINE_CAP.get().defaultBlockState();
		protected static final BlockState BRIMSHINE_STEM = BlocksPlanetary.BRIMSHINE_STEM.get().defaultBlockState();

		protected static final BlockState NEONDOT = BlocksPlanetary.NEONDOT.get().defaultBlockState();
		protected static final BlockState BRIMSHINE = BlocksPlanetary.BRIMSHINE.get().defaultBlockState();
    }

    public static final class RuleTests {
        public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
        public static final RuleTest SMOOTH_SANDSTONE = new BlockMatchRuleTest(Blocks.SMOOTH_SANDSTONE);
        public static final RuleTest PACKED_ICE = new BlockMatchRuleTest(Blocks.PACKED_ICE);
    }
}