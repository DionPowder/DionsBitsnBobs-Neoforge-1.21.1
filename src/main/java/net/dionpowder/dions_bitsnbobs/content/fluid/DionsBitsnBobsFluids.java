package net.dionpowder.dions_bitsnbobs.content.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.dionpowder.dions_bitsnbobs.utils.DionsBitsnBobsTags;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.dionpowder.dions_bitsnbobs.DionsBitsnBobs.REGISTRATE;

public class DionsBitsnBobsFluids {
    
    
    public static final FluidEntry<BaseFlowingFluid.Flowing> STRAWBERRY_FROSTING =
            REGISTRATE.standardFluid("strawberry_frosting", SolidRenderedPlaceableFluidType.create(0xFFF29AA3, () -> 1f / 8f))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3).slopeFindDistance(2))
                    .tag(DionsBitsnBobsTags.Fluids.STRAWBERRY_FROSTING, DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .tag(DionsBitsnBobsTags.Blocks.FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING)
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
                    .build()
                    .bucket()
                    .onRegister(DionsBitsnBobsFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS)
                    .build()
                    .register();
    
    public static final FluidEntry<BaseFlowingFluid.Flowing> ORANGE_FROSTING =
            REGISTRATE.standardFluid("orange_frosting", SolidRenderedPlaceableFluidType.create(0xFFFFB347, () -> 1f / 8f))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3).slopeFindDistance(2))
                    .tag(DionsBitsnBobsTags.Fluids.ORANGE_FROSTING, DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_ORANGE_FROSTING)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .tag(DionsBitsnBobsTags.Blocks.FAN_PROCESSING_CATALYSTS_ORANGE_FROSTING)
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_ORANGE))
                    .build()
                    .bucket()
                    .onRegister(DionsBitsnBobsFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS)
                    .build()
                    .register();
    
    public static final FluidEntry<BaseFlowingFluid.Flowing> BLUEBERRY_FROSTING =
            REGISTRATE.standardFluid("blueberry_frosting", SolidRenderedPlaceableFluidType.create(0xFF8B6FF7, () -> 1f / 8f))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3).slopeFindDistance(2))
                    .tag(DionsBitsnBobsTags.Fluids.BLUEBERRY_FROSTING, DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_BLUEBERRY_FROSTING)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .tag(DionsBitsnBobsTags.Blocks.FAN_PROCESSING_CATALYSTS_BLUEBERRY_FROSTING)
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_BLUE))
                    .build()
                    .bucket()
                    .onRegister(DionsBitsnBobsFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS)
                    .build()
                    .register();
    
    public static final FluidEntry<BaseFlowingFluid.Flowing> PEAR_FROSTING =
            REGISTRATE.standardFluid("pear_frosting", SolidRenderedPlaceableFluidType.create(0xFFB7E65A, () -> 1f / 8f))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3).slopeFindDistance(2))
                    .tag(DionsBitsnBobsTags.Fluids.PEAR_FROSTING, DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .tag(DionsBitsnBobsTags.Blocks.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN))
                    .build()
                    .bucket()
                    .onRegister(DionsBitsnBobsFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS)
                    .build()
                    .register();
    
    public static final FluidEntry<BaseFlowingFluid.Flowing> DONUT_BATTER =
            REGISTRATE.standardFluid("donut_batter", SolidRenderedPlaceableFluidType.create(0xffffffff, () -> 1f / 8f))
                    .fluidProperties(p -> p.levelDecreasePerBlock(3).slopeFindDistance(2).tickRate(30))
                    .tag(DionsBitsnBobsTags.Fluids.PEAR_FROSTING)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN))
                    .build()
                    .bucket()
                    .onRegister(DionsBitsnBobsFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS)
                    .build()
                    .register();
    
    
    
    public static void register(IEventBus eventBus) {
    
    }
    

    
    public static void registerFluidInteractions() {

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                DionsBitsnBobsFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.RED_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                DionsBitsnBobsFluidTypes.ORANGE_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.ORANGE_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                DionsBitsnBobsFluidTypes.BLUEBERRY_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.BLUE_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                DionsBitsnBobsFluidTypes.PEAR_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.LIME_TERRACOTTA.defaultBlockState()));

    }

    // register custom fluids to be able to be picked up with dispensers
    private static final DispenseItemBehavior DEFAULT = new DefaultDispenseItemBehavior();
    private static final DispenseItemBehavior DISPENSE_FLUID = new DefaultDispenseItemBehavior(){
        @Override
        protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
            DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
            BlockPos pos = pSource.pos().relative(pSource.state().getValue(DispenserBlock.FACING));
            Level level = pSource.level();
            if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)) {
                return new ItemStack(Items.BUCKET);
            }
            return DEFAULT.dispense(pSource, pStack);
        }
    };

    public static void registerFluidDispenseBehavior(BucketItem bucket) {
        DispenserBlock.registerBehavior(bucket, DISPENSE_FLUID);
    }
    
    
    public static abstract class TintedFluidType extends FluidType {
        
        protected static final int NO_TINT = 0xffffffff;
        private final ResourceLocation stillTexture;
        private final ResourceLocation flowingTexture;
        
        public TintedFluidType(Properties properties, ResourceLocation stillTexture, ResourceLocation flowingTexture) {
            super(properties);
            this.stillTexture = stillTexture;
            this.flowingTexture = flowingTexture;
        }
        
        @Override
        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
            consumer.accept(new IClientFluidTypeExtensions() {
                
                @Override
                public ResourceLocation getStillTexture() {
                    return stillTexture;
                }
                
                @Override
                public ResourceLocation getFlowingTexture() {
                    return flowingTexture;
                }
                
                @Override
                public int getTintColor(FluidStack stack) {
                    return TintedFluidType.this.getTintColor(stack);
                }
                
                @Override
                public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
                    return TintedFluidType.this.getTintColor(state, getter, pos);
                }
                
                @Override
                public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                                        int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                    Vector3f customFogColor = TintedFluidType.this.getCustomFogColor();
                    return customFogColor == null ? fluidFogColor : customFogColor;
                }
                
                @Override
                public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick,
                                            float nearDistance, float farDistance, FogShape shape) {
                    float modifier = TintedFluidType.this.getFogDistanceModifier();
                    float baseWaterFog = 96.0f;
                    if (modifier != 1f) {
                        RenderSystem.setShaderFogShape(FogShape.CYLINDER);
                        RenderSystem.setShaderFogStart(-8);
                        RenderSystem.setShaderFogEnd(baseWaterFog * modifier);
                    }
                }
                
            });
        }
        
        protected abstract int getTintColor(FluidStack stack);
        
        protected abstract int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos);
        
        protected Vector3f getCustomFogColor() {
            return null;
        }
        
        protected float getFogDistanceModifier() {
            return 1f;
        }
        
    }
    
    private static class SolidRenderedPlaceableFluidType extends TintedFluidType {
        
        private Vector3f fogColor;
        private Supplier<Float> fogDistance;
        
        public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }
        
        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                                                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }
        
        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }
        
        /*
         * Removing alpha from tint prevents optifine from forcibly applying biome
         * colors to modded fluids (this workaround only works for fluids in the solid
         * render layer)
         */
        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }
        
        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }
        
        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }
        
    }
    
}