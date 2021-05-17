package io.github.fallOut015.planetary.item;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.block.BlocksPlanetary;
import io.github.fallOut015.planetary.entity.EntitiesPlanetary;
import io.github.fallOut015.planetary.fluid.FluidsPlanetary;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsPlanetary {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainPlanetary.MODID);



    // Building Blocks
    public static final RegistryObject<Item> CHERRY_PLANKS = ITEMS.register("cherry_planks", () -> new BlockItem(BlocksPlanetary.CHERRY_PLANKS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> MAPLE_PLANKS = ITEMS.register("maple_planks", () -> new BlockItem(BlocksPlanetary.MAPLE_PLANKS.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
//	public static final RegistryObject<Item> NEONDOT_PLANKS = ITEMS.register(BlocksTwo.NEONDOT_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
//	public static final RegistryObject<Item> BRIMSHINE_PLANKS = ITEMS.register(BlocksTwo.BRIMSHINE_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

    public static final RegistryObject<Item> CHERRY_LOG = ITEMS.register(BlocksPlanetary.CHERRY_LOG, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> MAPLE_LOG = ITEMS.register(BlocksPlanetary.MAPLE_LOG, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
//	public static final RegistryObject<Item> NEONDOT_STEM = ITEMS.register(BlocksTwo.NEONDOT_STEM, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
//	public static final RegistryObject<Item> BRIMSHINE_STEM = ITEMS.register(BlocksTwo.BRIMSHINE_STEM, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final RegistryObject<Item> STRIPPED_CHERRY_LOG = ITEMS.register(BlocksPlanetary.STRIPPED_CHERRY_LOG, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> STRIPPED_MAPLE_LOG = ITEMS.register(BlocksPlanetary.STRIPPED_MAPLE_LOG, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);

	public static final RegistryObject<Item> CHERRY_WOOD = ITEMS.register(BlocksPlanetary.CHERRY_WOOD, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> MAPLE_WOOD = ITEMS.register(BlocksPlanetary.MAPLE_WOOD, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);

	public static final RegistryObject<Item> STRIPPED_CHERRY_WOOD = ITEMS.register(BlocksPlanetary.STRIPPED_CHERRY_WOOD, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> STRIPPED_MAPLE_WOOD = ITEMS.register(BlocksPlanetary.STRIPPED_MAPLE_WOOD, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);

	public static final RegistryObject<Item> CHERRY_SLAB = ITEMS.register(BlocksPlanetary.CHERRY_SLAB, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> MAPLE_SLAB = ITEMS.register(BlocksPlanetary.MAPLE_SLAB, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);

	public static final RegistryObject<Item> CHERRY_STAIRS = ITEMS.register(BlocksPlanetary.CHERRY_STAIRS, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);
	public static final RegistryObject<Item> MAPLE_STAIRS = ITEMS.register(BlocksPlanetary.MAPLE_STAIRS, new Item.Properties()/*.tab(ItemGroup.BUILDING_BLOCKS)*/);

    public static final RegistryObject<Item> END_COBALT_ORE = ITEMS.register(BlocksPlanetary.END_COBALT_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> END_JADE_ORE = ITEMS.register(BlocksPlanetary.END_JADE_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> OPAL_ORE = ITEMS.register(BlocksPlanetary.OPAL_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TANZANITE_ORE = ITEMS.register(BlocksPlanetary.TANZANITE_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> NETHER_GARNET_ORE = ITEMS.register(BlocksPlanetary.NETHER_GARNET_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> NETHER_TOPAZ_ORE = ITEMS.register(BlocksPlanetary.NETHER_TOPAZ_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> END_SAPPHIRE_ORE = ITEMS.register(BlocksPlanetary.END_SAPPHIRE_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> RUBY_ORE = ITEMS.register(BlocksPlanetary.RUBY_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));

	public static final RegistryObject<Item> COBALT_BLOCK = ITEMS.register(BlocksPlanetary.COBALT_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> JADE_BLOCK = ITEMS.register(BlocksPlanetary.JADE_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> OPAL_BLOCK = ITEMS.register(BlocksPlanetary.OPAL_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TANZANITE_BLOCK = ITEMS.register(BlocksPlanetary.TANZANITE_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> GARNET_BLOCK = ITEMS.register(BlocksPlanetary.GARNET_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TOPAZ_BLOCK = ITEMS.register(BlocksPlanetary.TOPAZ_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> SAPPHIRE_BLOCK = ITEMS.register(BlocksPlanetary.SAPPHIRE_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> RUBY_BLOCK = ITEMS.register(BlocksPlanetary.RUBY_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));

	public static final RegistryObject<Item> TALC_ORE = ITEMS.register(BlocksPlanetary.TALC_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> NETHER_LEAD_ORE = ITEMS.register(BlocksPlanetary.NETHER_LEAD_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TIN_ORE = ITEMS.register(BlocksPlanetary.TIN_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> ALUMINUM_ORE = ITEMS.register(BlocksPlanetary.ALUMINUM_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> SILVER_ORE = ITEMS.register(BlocksPlanetary.SILVER_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> END_PLATINUM_ORE = ITEMS.register(BlocksPlanetary.END_PLATINUM_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> NETHER_TITANIUM_ORE = ITEMS.register(BlocksPlanetary.NETHER_TITANIUM_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> PYRITE_ORE = ITEMS.register(BlocksPlanetary.PYRITE_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));

	public static final RegistryObject<Item> TALC_BLOCK = ITEMS.register(BlocksPlanetary.TALC_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> LEAD_BLOCK = ITEMS.register(BlocksPlanetary.LEAD_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TIN_BLOCK = ITEMS.register(BlocksPlanetary.TIN_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> ALUMINUM_BLOCK = ITEMS.register(BlocksPlanetary.ALUMINUM_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> SILVER_BLOCK = ITEMS.register(BlocksPlanetary.SILVER_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> PLATINUM_BLOCK = ITEMS.register(BlocksPlanetary.PLATINUM_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> TITANIUM_BLOCK = ITEMS.register(BlocksPlanetary.TITANIUM_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> PYRITE_BLOCK = ITEMS.register(BlocksPlanetary.PYRITE_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> STEEL_BLOCK = ITEMS.register(BlocksPlanetary.STEEL_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> HARDENED_STEEL_BLOCK = ITEMS.register(BlocksPlanetary.HARDENED_STEEL_BLOCK, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));

    public static final RegistryObject<Item> DESERT_COAL_ORE = ITEMS.register(BlocksPlanetary.DESERT_COAL_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> DESERT_IRON_ORE = ITEMS.register(BlocksPlanetary.DESERT_IRON_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> DESERT_GOLD_ORE = ITEMS.register(BlocksPlanetary.DESERT_GOLD_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));
	public static final RegistryObject<Item> DESERT_COPPER_ORE = ITEMS.register(BlocksPlanetary.DESERT_COPPER_ORE, new Item.Properties().tab(ItemGroup.BUILDING_BLOCKS));

    public static final RegistryObject<Item> SPORESTONE = ITEMS.register("sporestone", () -> new BlockItem(BlocksPlanetary.SPORESTONE.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> SPORESTONE_SOIL = ITEMS.register("sporestone_soil", () -> new BlockItem(BlocksPlanetary.SPORESTONE_SOIL.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> PURPETAL_STEM = ITEMS.register("purpetal_stem", () -> new BlockItem(BlocksPlanetary.PURPETAL_STEM.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PURPETAL_PETAL = ITEMS.register("purpetal_petal", () -> new BlockItem(BlocksPlanetary.PURPETAL_PETAL.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PURPETAL_PISTOL = ITEMS.register("purpetal_pistol", () -> new BlockItem(BlocksPlanetary.PURPETAL_PISTOL.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    // Decoration
    public static final RegistryObject<Item> SPORESTONE_ROOTS = ITEMS.register("sporestone_roots", () -> new BlockItem(BlocksPlanetary.SPORESTONE_ROOTS.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> NEONDOT = ITEMS.register("neondot", () -> new BlockItem(BlocksPlanetary.NEONDOT.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BRIMSHINE = ITEMS.register("brimshine", () -> new BlockItem(BlocksPlanetary.BRIMSHINE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> SHROOMGLOW = ITEMS.register("shroomglow", () -> new BlockItem(BlocksPlanetary.SHROOMGLOW.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> SHROOMGLOW_LANTERN = ITEMS.register("shroomglow_lantern", () -> new BlockItem(BlocksPlanetary.SHROOMGLOW_LANTERN.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> PURPETAL = ITEMS.register("purpetal", () -> new BlockItem(BlocksPlanetary.PURPETAL.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> CHERRY_LEAVES = ITEMS.register(BlocksPlanetary.CHERRY_LEAVES, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);
	public static final RegistryObject<Item> MAPLE_LEAVES = ITEMS.register(BlocksPlanetary.MAPLE_LEAVES, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);
	public static final RegistryObject<Item> NEONDOT_CAP = ITEMS.register(BlocksPlanetary.NEONDOT_CAP, new Item.Properties().tab(ItemGroup.DECORATIONS));
	public static final RegistryObject<Item> BRIMSHINE_CAP = ITEMS.register(BlocksPlanetary.BRIMSHINE_CAP, new Item.Properties().tab(ItemGroup.DECORATIONS));

	public static final RegistryObject<Item> CHERRY_FENCE = ITEMS.register(BlocksPlanetary.CHERRY_FENCE, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);
	public static final RegistryObject<Item> MAPLE_FENCE = ITEMS.register(BlocksPlanetary.MAPLE_FENCE, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);

	public static final RegistryObject<Item> CHERRY_SIGN = ITEMS.register(BlocksPlanetary.CHERRY_SIGN, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);
	public static final RegistryObject<Item> MAPLE_SIGN = ITEMS.register(BlocksPlanetary.MAPLE_SIGN, new Item.Properties()/*.tab(ItemGroup.DECORATIONS)*/);

    public static final RegistryObject<Item> CHERRY_SAPLING = ITEMS.register("cherry_sapling", () -> new BlockItem(BlocksPlanetary.CHERRY_SAPLING.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
    public static final RegistryObject<Item> MAPLE_SAPLING = ITEMS.register("maple_sapling", () -> new BlockItem(BlocksPlanetary.MAPLE_SAPLING.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> SUCCULIGHT = ITEMS.register("succulight", () -> new BlockItem(BlocksPlanetary.SUCCULIGHT.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> CATTAILS = ITEMS.register("cattails", () -> new BlockItem(BlocksPlanetary.CATTAILS.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> MAPLE_TAP = ITEMS.register("maple_tap", () -> new BlockItem(BlocksPlanetary.MAPLE_TAP.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> ICE_SLIME_BLOCK = ITEMS.register("ice_slime_block", () -> new BlockItem(BlocksPlanetary.ICE_SLIME_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<Item> SKYCAP = ITEMS.register("skycap", () -> new BlockItem(BlocksPlanetary.SKYCAP.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    // Redstone
    public static final RegistryObject<Item> CHERRY_PRESSURE_PLATE = ITEMS.register(BlocksPlanetary.CHERRY_PRESSURE_PLATE, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);
	public static final RegistryObject<Item> MAPLE_PRESSURE_PLATE = ITEMS.register(BlocksPlanetary.MAPLE_PRESSURE_PLATE, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);

    public static final RegistryObject<Item> CHERRY_TRAPDOOR = ITEMS.register(BlocksPlanetary.CHERRY_TRAPDOOR, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);
	public static final RegistryObject<Item> MAPLE_TRAPDOOR = ITEMS.register(BlocksPlanetary.MAPLE_TRAPDOOR, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);

	public static final RegistryObject<Item> CHERRY_FENCE_GATE = ITEMS.register(BlocksPlanetary.CHERRY_FENCE_GATE, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);
	public static final RegistryObject<Item> MAPLE_FENCE_GATE = ITEMS.register(BlocksPlanetary.MAPLE_FENCE_GATE, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);

	public static final RegistryObject<Item> CHERRY_BUTTON = ITEMS.register(BlocksPlanetary.CHERRY_BUTTON, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);
	public static final RegistryObject<Item> MAPLE_BUTTON = ITEMS.register(BlocksPlanetary.MAPLE_BUTTON, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);

	public static final RegistryObject<Item> CHERRY_DOOR = ITEMS.register(BlocksPlanetary.CHERRY_DOOR, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);
	public static final RegistryObject<Item> MAPLE_DOOR = ITEMS.register(BlocksPlanetary.MAPLE_DOOR, new Item.Properties()/*.tab(ItemGroup.REDSTONE)*/);

    // Transporation
    public static final RegistryObject<Item> MAPLE_BOAT = ITEMS.register("maple_boat", () -> new BoatItem(null, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new BoatItem(null, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> CRIMSON_BOAT = ITEMS.register("crimson_boat", () -> new BoatItem(null, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> WARPED_BOAT = ITEMS.register("warped_boat", () -> new BoatItem(null, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));

    public static final RegistryObject<Item> OBSIDIAN_BOAT = ITEMS.register("obsidian_boat", () -> new BoatItem(null, new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_TRANSPORTATION)));

    // neondot and brimshine boats

    // Misc
    public static final RegistryObject<Item> COBALT = ITEMS.register("cobalt", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> OPAL = ITEMS.register("opal", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> TANZANITE = ITEMS.register("tanzanite", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> CELESTIUM = ITEMS.register("celestium", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> TALC = ITEMS.register("talc", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> PYRITE_INGOT = ITEMS.register("pyrite_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> STARSTONE = ITEMS.register("starstone", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> URU_INGOT = ITEMS.register("uru_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> HARDENED_STEEL_INGOT = ITEMS.register("hardened_steel_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> MUD_BUCKET = ITEMS.register("mud_bucket", () -> new BucketItem(() -> FluidsPlanetary.MUD.get(), new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> ICE_SLIME_BALL = ITEMS.register("ice_slime_ball", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<Item> CRIMP_SPAWN_EGG = ITEMS.register("crimp_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.CRIMP.get(), 2892067, 7084570, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> ICE_SLIME_SPAWN_EGG = ITEMS.register("ice_slime_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.ICE_SLIME.get(), 14606335, 16382719, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> JELLYFISH_SPAWN_EGG = ITEMS.register("jellyfish_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.JELLYFISH.get(), 2461380, 8443135, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> MUMMIFIED_ZOMBIE_SPAWN_EGG = ITEMS.register("mummified_zombie_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.MUMMIFIED_ZOMBIE.get(), 3490609, 13487798, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.PENGUIN.get(), 1250583, 16316656, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new SpawnEggItem(EntitiesPlanetary.RED_PANDA.get(), 3215619, 13847826, new Item.Properties().tab(ItemGroup.TAB_MISC)));

    // Tools
    // Steel and Hardened Steel tools

    // Combat
    // Steel and Hardened Steel weapons



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}