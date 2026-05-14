package net.dionpowder.dions_bitsnbobs.fluid;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation WATER_OVERLAY_RL = ResourceLocation.parse("block/water_overlay");

    public static final ResourceLocation STRAWBERRY_FROSTING_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/strawberry_frosting_still");
    public static final ResourceLocation STRAWBERRY_FROSTING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/strawberry_frosting_flowing");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, DionsBitsnBobs.MOD_ID);

    public static final Supplier<FluidType> STRAWBERRY_FROSTING_FLUID_TYPE = registerFluidType("strawberry_frosting",
            new BaseFluidType(STRAWBERRY_FROSTING_STILL_RL, STRAWBERRY_FROSTING_FLOWING_RL, WATER_OVERLAY_RL, 0xA1F29AA3,
                    new Vector3f(242f / 255f, 154f / 255f, 163f / 255f),
                    FluidType.Properties.create()));

    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}