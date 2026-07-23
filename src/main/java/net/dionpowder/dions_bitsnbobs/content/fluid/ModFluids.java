package net.dionpowder.dions_bitsnbobs.content.fluid;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, DionsBitsnBobs.MOD_ID);

    // strawberry

    // source
    public static final Supplier<FlowingFluid> SOURCE_STRAWBERRY_FROSTING = FLUIDS.register("strawberry_frosting",
            () -> new BaseFlowingFluid.Source(ModFluids.STRAWBERRY_FROSTING_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_STRAWBERRY_FROSTING = FLUIDS.register("flowing_strawberry_frosting",
            () -> new BaseFlowingFluid.Flowing(ModFluids.STRAWBERRY_FROSTING_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> STRAWBERRY_FROSTING_BLOCK = ModBlocks.BLOCKS.register("strawberry_frosting_block",
            () -> new LiquidBlock(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<BucketItem> STRAWBERRY_FROSTING_BUCKET = ModItems.ITEMS.registerItem("strawberry_frosting_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties STRAWBERRY_FROSTING_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE, SOURCE_STRAWBERRY_FROSTING, FLOWING_STRAWBERRY_FROSTING)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .block(ModFluids.STRAWBERRY_FROSTING_BLOCK).bucket(ModFluids.STRAWBERRY_FROSTING_BUCKET);

    // orange

    // source
    public static final Supplier<FlowingFluid> SOURCE_ORANGE_FROSTING = FLUIDS.register("orange_frosting",
            () -> new BaseFlowingFluid.Source(ModFluids.ORANGE_FROSTING_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_ORANGE_FROSTING = FLUIDS.register("flowing_orange_frosting",
            () -> new BaseFlowingFluid.Flowing(ModFluids.ORANGE_FROSTING_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> ORANGE_FROSTING_BLOCK = ModBlocks.BLOCKS.register("orange_frosting_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ORANGE_FROSTING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<BucketItem> ORANGE_FROSTING_BUCKET = ModItems.ITEMS.registerItem("orange_frosting_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_ORANGE_FROSTING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties ORANGE_FROSTING_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.ORANGE_FROSTING_FLUID_TYPE, SOURCE_ORANGE_FROSTING, FLOWING_ORANGE_FROSTING)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .block(ModFluids.ORANGE_FROSTING_BLOCK).bucket(ModFluids.ORANGE_FROSTING_BUCKET);

    // blueberry

    // source
    public static final Supplier<FlowingFluid> SOURCE_BLUEBERRY_FROSTING = FLUIDS.register("blueberry_frosting",
            () -> new BaseFlowingFluid.Source(ModFluids.BLUEBERRY_FROSTING_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_BLUEBERRY_FROSTING = FLUIDS.register("flowing_blueberry_frosting",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BLUEBERRY_FROSTING_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> BLUEBERRY_FROSTING_BLOCK = ModBlocks.BLOCKS.register("blueberry_frosting_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BLUEBERRY_FROSTING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<BucketItem> BLUEBERRY_FROSTING_BUCKET = ModItems.ITEMS.registerItem("blueberry_frosting_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_BLUEBERRY_FROSTING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties BLUEBERRY_FROSTING_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.BLUEBERRY_FROSTING_FLUID_TYPE, SOURCE_BLUEBERRY_FROSTING, FLOWING_BLUEBERRY_FROSTING)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .block(ModFluids.BLUEBERRY_FROSTING_BLOCK).bucket(ModFluids.BLUEBERRY_FROSTING_BUCKET);

    // pear

    // source
    public static final Supplier<FlowingFluid> SOURCE_PEAR_FROSTING = FLUIDS.register("pear_frosting",
            () -> new BaseFlowingFluid.Source(ModFluids.PEAR_FROSTING_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_PEAR_FROSTING = FLUIDS.register("flowing_pear_frosting",
            () -> new BaseFlowingFluid.Flowing(ModFluids.PEAR_FROSTING_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> PEAR_FROSTING_BLOCK = ModBlocks.BLOCKS.register("pear_frosting_block",
            () -> new LiquidBlock(ModFluids.SOURCE_PEAR_FROSTING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<BucketItem> PEAR_FROSTING_BUCKET = ModItems.ITEMS.registerItem("pear_frosting_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_PEAR_FROSTING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties PEAR_FROSTING_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.PEAR_FROSTING_FLUID_TYPE, SOURCE_PEAR_FROSTING, FLOWING_PEAR_FROSTING)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .block(ModFluids.PEAR_FROSTING_BLOCK).bucket(ModFluids.PEAR_FROSTING_BUCKET);

    // batter
    public static final Supplier<FlowingFluid> SOURCE_DONUT_BATTER = FLUIDS.register("donut_batter",
            () -> new BaseFlowingFluid.Source(ModFluids.DONUT_BATTER_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_DONUT_BATTER = FLUIDS.register("flowing_donut_batter",
            () -> new BaseFlowingFluid.Flowing(ModFluids.DONUT_BATTER_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> DONUT_BATTER_BLOCK = ModBlocks.BLOCKS.register("donut_batter_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DONUT_BATTER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<BucketItem> DONUT_BATTER_BUCKET = ModItems.ITEMS.registerItem("donut_batter_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_DONUT_BATTER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties DONUT_BATTER_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.DONUT_BATTER_FLUID_TYPE, SOURCE_DONUT_BATTER, FLOWING_DONUT_BATTER)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .tickRate(30)
            .block(ModFluids.DONUT_BATTER_BLOCK).bucket(ModFluids.DONUT_BATTER_BUCKET);

    // register fluid interactions
    public static void registerFluidInteractions() {
        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                ModFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.RED_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                ModFluidTypes.ORANGE_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.ORANGE_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                ModFluidTypes.BLUEBERRY_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.BLUE_TERRACOTTA.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(
                ModFluidTypes.PEAR_FROSTING_FLUID_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.LIME_TERRACOTTA.defaultBlockState()));

    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}