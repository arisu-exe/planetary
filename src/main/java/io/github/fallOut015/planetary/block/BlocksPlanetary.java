package io.github.fallOut015.planetary.block;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.block.trees.CherryTree;
import io.github.fallOut015.planetary.block.trees.MapleTree;
import io.github.fallOut015.planetary.fluid.FluidsPlanetary;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksPlanetary {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MainPlanetary.MODID);



    public static final RegistryObject<Block> MUD = BLOCKS.register("mud", () -> new FlowingFluidBlock(FluidsPlanetary.MUD, Block.Properties.of(Material.WATER).noCollission().strength(150f).noDrops()));

    public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> NEONDOT_PLANKS = BLOCKS.register("neondot_planks", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN).strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BRIMSHINE_PLANKS = BLOCKS.register("brimshine_planks", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0f, 3.0f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> createLogBlock(MaterialColor.TERRACOTTA_PINK, MaterialColor.STONE));
    public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", () -> createLogBlock(MaterialColor.SAND, MaterialColor.TERRACOTTA_BROWN));

    public static final RegistryObject<Block> NEONDOT_STEM = BLOCKS.register("neondot_stem", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BRIMSHINE_STEM = BLOCKS.register("brimshine_stem", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE).strength(1.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () -> createLogBlock(MaterialColor.TERRACOTTA_PINK, MaterialColor.TERRACOTTA_PINK));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log", () -> createLogBlock(MaterialColor.SAND, MaterialColor.SAND));

    // stripped neondot stem
    // stripped brimshine stem

    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.SAND).strength(2.0f).sound(SoundType.WOOD)));

    // stripped neondot hyphae
    // stripped brimshine hyphae

    public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.STONE).strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0f).sound(SoundType.WOOD)));

    // neondot hyphae
    // brimshine hyphae

    public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));

    public static final RegistryObject<Block> NEONDOT_CAP = BLOCKS.register("neondot_cap", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_PURPLE).strength(0.8f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> BRIMSHINE_CAP = BLOCKS.register("brimshine_cap", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(0.8f).sound(SoundType.WOOL)));

    public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_SLAB = BLOCKS.register("maple_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // neondot slab
    // brimshine slab

    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register("maple_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    // neondot pressure plate
    // brimshine pressure plate

    public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_FENCE = BLOCKS.register("maple_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // neondot fence
    // brimshine fence

    public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = BLOCKS.register("maple_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));

    // neondot trapdoor
    // brimshine trapdoor

    public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = BLOCKS.register("maple_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // neondot fence gate
    // brimshine fence gate

    public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> new StairsBlock(CHERRY_PLANKS.get()::defaultBlockState, Block.Properties.copy(CHERRY_PLANKS.get())));
    public static final RegistryObject<Block> MAPLE_STAIRS = BLOCKS.register("maple_stairs", () -> new StairsBlock(MAPLE_PLANKS.get()::defaultBlockState, Block.Properties.copy(MAPLE_PLANKS.get())));

    // neondot stairs
    // brimshine stairs

    public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MAPLE_BUTTON = BLOCKS.register("maple_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    // neondot button
    // brimshine button

    public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> MAPLE_DOOR = BLOCKS.register("maple_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));

    // neondot door
    // brimshine door

    public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign", () -> new StandingSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodTypePlanetary.CHERRY));
    public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign", () -> new StandingSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodTypePlanetary.MAPLE));

    // neondot sign
    // brimshine sign

    public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign", () -> new WallSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_PINK).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(CHERRY_SIGN.get()), WoodTypePlanetary.CHERRY));
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign", () -> new WallSignBlock(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(MAPLE_SIGN.get()), WoodTypePlanetary.MAPLE));

    // neondot wall sign
    // brimshine wall sign

    public static final RegistryObject<Block> CRACKED_SAND = BLOCKS.register("cracked_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND).strength(1.0f)));

    public static final RegistryObject<Block> SPORESTONE = BLOCKS.register("sporestone", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.0f, 4.0f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> SPORESTONE_SOIL = BLOCKS.register("sporestone_soil", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.GRASS).strength(1.0f, 4.0f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> SPORESTONE_ROOTS = BLOCKS.register("sporestone_roots", () -> new SporestoneRootsBlock(Block.Properties.of(Material.GRASS, MaterialColor.GRASS).strength(0.2f).noOcclusion()));

    // make dots glow
    public static final RegistryObject<Block> NEONDOT = BLOCKS.register("neondot", () -> new NeondotBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS).lightLevel(state -> 4).emissiveRendering((s, l, p) -> true)));
    public static final RegistryObject<Block> BRIMSHINE = BLOCKS.register("brimshine", () -> new BrimshineBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS).lightLevel(state -> 4).emissiveRendering((s, l, p) -> true)));

    public static final RegistryObject<Block> POTTED_NEONDOT = BLOCKS.register("potted_neondot", () -> new FlowerPotBlockPlanetary(() -> (FlowerPotBlock) Blocks.FLOWER_POT, NEONDOT, Block.Properties.of(Material.DECORATION).strength(0).noOcclusion().lightLevel(state -> 3)));
    public static final RegistryObject<Block> POTTED_BRIMSHINE = BLOCKS.register("potted_brimshine", () -> new FlowerPotBlockPlanetary(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BRIMSHINE, Block.Properties.of(Material.DECORATION).strength(0).noOcclusion().lightLevel(state -> 3)));

    // make shroomglow glow
    public static final RegistryObject<Block> SHROOMGLOW = BLOCKS.register("shroomglow", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5f).sound(SoundType.WOOL).lightLevel(state -> 8)));
    public static final RegistryObject<Block> SHROOMGLOW_LANTERN = BLOCKS.register("shroomglow_lantern", () -> new LanternBlock(Block.Properties.of(Material.METAL).strength(3.5F).sound(SoundType.LANTERN).lightLevel(state -> 12).noOcclusion()));

    public static final RegistryObject<Block> BRIMSTONE = BLOCKS.register("brimstone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(0.75F, 1.5F).harvestLevel(0).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> DESERT_COAL_ORE = BLOCKS.register("desert_coal_ore", () -> new OreBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.COAL_ORE.getHarvestLevel(Blocks.COAL_ORE.defaultBlockState()))) {
        protected int xpOnDrop(java.util.Random rand) {
            return MathHelper.nextInt(rand, 0, 3);
        };
    });
    public static final RegistryObject<Block> DESERT_IRON_ORE = BLOCKS.register("desert_iron_ore", () -> new OreBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.IRON_ORE.getHarvestLevel(Blocks.IRON_ORE.defaultBlockState()))));
    public static final RegistryObject<Block> DESERT_GOLD_ORE = BLOCKS.register("desert_gold_ore", () -> new OreBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(Blocks.GOLD_ORE.getHarvestLevel(Blocks.GOLD_ORE.defaultBlockState()))));
    public static final RegistryObject<Block> DESERT_COPPER_ORE = BLOCKS.register("desert_copper_ore", () -> new OreBlock(Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static final RegistryObject<Block> END_COBALT_ORE = BLOCKS.register("end_cobalt_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> END_JADE_ORE = BLOCKS.register("end_jade_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(4).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> OPAL_ORE = BLOCKS.register("opal_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> TANZANITE_ORE = BLOCKS.register("tanzanite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> NETHER_GARNET_ORE = BLOCKS.register("nether_garnet_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> NETHER_TOPAZ_ORE = BLOCKS.register("nether_topaz_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> END_SAPPHIRE_ORE = BLOCKS.register("end_sapphire_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(6).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> OPAL_BLOCK = BLOCKS.register("opal_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TANZANITE_BLOCK = BLOCKS.register("tanzanite_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GARNET_BLOCK = BLOCKS.register("garnet_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_PINK).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("topaz_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_RED).strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TALC_ORE = BLOCKS.register("talc_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> NETHER_LEAD_ORE = BLOCKS.register("nether_lead_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> END_PLATINUM_ORE = BLOCKS.register("end_platinum_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(5).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> NETHER_TITANIUM_ORE = BLOCKS.register("nether_titanium_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(4).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> PYRITE_ORE = BLOCKS.register("pyrite_ore", () -> new OreBlock(Block.Properties.of(Material.STONE).strength(3.0f, 3.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> TALC_BLOCK = BLOCKS.register("talc_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.SNOW).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(15.0F, 16.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PYRITE_BLOCK = BLOCKS.register("pyrite_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.GOLD).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> HARDENED_STEEL_BLOCK = BLOCKS.register("hardened_steel_block", () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PURPETAL = BLOCKS.register("purpetal", () -> new PurpetalBlock(Block.Properties.of(Material.GRASS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> PURPETAL_STEM = BLOCKS.register("purpetal_stem", () -> new RotatedPillarBlock(Block.Properties.of(Material.GRASS)));
    public static final RegistryObject<Block> PURPETAL_PETAL = BLOCKS.register("purpetal_petal", () -> new Block(Block.Properties.of(Material.GRASS)));
    public static final RegistryObject<Block> PURPETAL_PISTOL = BLOCKS.register("purpetal_pistol", () -> new Block(Block.Properties.of(Material.GRASS)));

    public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new SaplingBlock(new CherryTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> new SaplingBlock(new MapleTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = BLOCKS.register("potted_cherry_sapling", () -> new FlowerPotBlockPlanetary(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHERRY_SAPLING, Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", () -> new FlowerPotBlockPlanetary(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAPLE_SAPLING, Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));

    public static final RegistryObject<Block> SUCCULIGHT = BLOCKS.register("succulight", () -> new SucculightBlock(Effects.NIGHT_VISION, 5, Block.Properties.of(Material.CACTUS).noOcclusion().noCollission().lightLevel(state -> 6)));
    public static final RegistryObject<Block> POTTED_SUCCULIGHT = BLOCKS.register("potted_succulight", () -> new FlowerPotBlockPlanetary(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUCCULIGHT, Block.Properties.of(Material.DECORATION).strength(0).noOcclusion().lightLevel(state -> 5)));

    public static final RegistryObject<Block> CATTAILS = BLOCKS.register("cattails", () -> new CattailsTopBlock(AbstractBlock.Properties.of(Material.WATER_PLANT).noCollission().instabreak().sound(SoundType.WET_GRASS)));
    public static final RegistryObject<Block> CATTAILS_PLANT = BLOCKS.register("cattails_plant", () -> new CattailsBlock(AbstractBlock.Properties.of(Material.WATER_PLANT).noCollission().instabreak().sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> MAPLE_TAP = BLOCKS.register("maple_tap", () -> new MapleTapBlock(Block.Properties.of(Material.METAL)));

    public static final RegistryObject<Block> ICE_SLIME_BLOCK = BLOCKS.register("ice_slime_block", () -> new IceSlimeBlock(Block.Properties.of(Material.CLAY, MaterialColor.ICE).friction(1.98F).sound(SoundType.SLIME_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> SKYCAP = BLOCKS.register("skycap", () -> new SkycapBlock(AbstractBlock.Properties.of(Material.GRASS, MaterialColor.COLOR_BLUE).instabreak()));

    public static final RegistryObject<Block> IVY = BLOCKS.register("ivy", () -> new IvyBlock(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT).noCollission().randomTicks().strength(0.2F).sound(SoundType.VINE).noOcclusion()));
    public static final RegistryObject<Block> MANDRAKE = BLOCKS.register("mandrake", () -> new Block(AbstractBlock.Properties.of(Material.PLANT).strength(4.0f).noCollission().noOcclusion()));



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, (state) -> {
            return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
}