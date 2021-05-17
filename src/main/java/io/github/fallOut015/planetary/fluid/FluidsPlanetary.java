package io.github.fallOut015.planetary.fluid;

import io.github.fallOut015.planetary.MainPlanetary;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidsPlanetary {
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MainPlanetary.MODID);



    public static final RegistryObject<MudFluid.Source> MUD = FLUIDS.register("mud", () -> new MudFluid.Source());
    public static final RegistryObject<MudFluid.Flowing> FLOWING_MUD = FLUIDS.register("flowing_mud", () -> new MudFluid.Flowing());



    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }
}