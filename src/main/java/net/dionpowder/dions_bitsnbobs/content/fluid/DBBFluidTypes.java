package net.dionpowder.dions_bitsnbobs.content.fluid;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class DBBFluidTypes {
    public static final ResourceLocation STRAWBERRY_FROSTING_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/strawberry_frosting_still");
    public static final ResourceLocation STRAWBERRY_FROSTING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/strawberry_frosting_flowing");

    public static final ResourceLocation ORANGE_FROSTING_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/orange_frosting_still");
    public static final ResourceLocation ORANGE_FROSTING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/orange_frosting_flowing");

    public static final ResourceLocation BLUEBERRY_FROSTING_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/blueberry_frosting_still");
    public static final ResourceLocation BLUEBERRY_FROSTING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/blueberry_frosting_flowing");

    public static final ResourceLocation PEAR_FROSTING_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/pear_frosting_still");
    public static final ResourceLocation PEAR_FROSTING_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/pear_frosting_flowing");

    public static final ResourceLocation DONUT_BATTER_STILL_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/donut_batter_still");
    public static final ResourceLocation DONUT_BATTER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("dions_bitsnbobs", "block/donut_batter_flowing");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, DBB.MOD_ID);

    public static final Supplier<FluidType> STRAWBERRY_FROSTING_FLUID_TYPE = registerFluidType("strawberry_frosting",
            new BaseFluidType(STRAWBERRY_FROSTING_STILL_RL, STRAWBERRY_FROSTING_FLOWING_RL, STRAWBERRY_FROSTING_FLOWING_RL, 0xFFF29AA3,
                    new Vector3f(242f / 255f, 154f / 255f, 163f / 255f),
                    FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL), true));

    public static final Supplier<FluidType> ORANGE_FROSTING_FLUID_TYPE = registerFluidType("orange_frosting",
            new BaseFluidType(ORANGE_FROSTING_STILL_RL, ORANGE_FROSTING_FLOWING_RL, ORANGE_FROSTING_FLOWING_RL, 0xFFFFB347,
                    new Vector3f(1.0f, 179f / 255f, 71f / 255f),
                    FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL), true));

    public static final Supplier<FluidType> BLUEBERRY_FROSTING_FLUID_TYPE = registerFluidType("blueberry_frosting",
            new BaseFluidType(BLUEBERRY_FROSTING_STILL_RL, BLUEBERRY_FROSTING_FLOWING_RL, BLUEBERRY_FROSTING_FLOWING_RL, 0xFF8B6FF7,
                    new Vector3f(139f / 255f, 111f / 255f, 247f / 255f),
                    FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL), true));

    public static final Supplier<FluidType> PEAR_FROSTING_FLUID_TYPE = registerFluidType("pear_frosting",
            new BaseFluidType(PEAR_FROSTING_STILL_RL, PEAR_FROSTING_FLOWING_RL, PEAR_FROSTING_FLOWING_RL, 0xFFB7E65A,
                    new Vector3f(183f / 255f, 230f / 255f, 90f / 255f),
                    FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL), true));

    public static final Supplier<FluidType> DONUT_BATTER_FLUID_TYPE = registerFluidType("donut_batter",
            new BaseFluidType(DONUT_BATTER_STILL_RL, DONUT_BATTER_FLOWING_RL, DONUT_BATTER_FLOWING_RL, 0xffffffff,
                    new Vector3f(0.97f, 0.94f, 0.78f),
                    FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL), false));

    private static Supplier<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}