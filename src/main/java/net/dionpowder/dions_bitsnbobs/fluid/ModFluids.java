package net.dionpowder.dions_bitsnbobs.fluid;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
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
            () -> new BaseFlowingFluid.Source(ModFluids.BLACK_OPAL_WATER_PROPERTIES));
    // flowing
    public static final Supplier<FlowingFluid> FLOWING_STRAWBERRY_FROSTING = FLUIDS.register("flowing_strawberry_frosting",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BLACK_OPAL_WATER_PROPERTIES));
    // block
    public static final DeferredBlock<LiquidBlock> STRAWBERRY_FROSTING_BLOCK = ModBlocks.BLOCKS.register("strawberry_frosting_block",
            () -> new LiquidBlock(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    // bucket item
    public static final DeferredItem<Item> STRAWBERRY_FROSTING_BUCKET = ModItems.ITEMS.registerItem("strawberry_frosting_bucket",
            properties -> new BucketItem(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    // properties
    public static final BaseFlowingFluid.Properties BLACK_OPAL_WATER_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE, SOURCE_STRAWBERRY_FROSTING, FLOWING_STRAWBERRY_FROSTING)
            .slopeFindDistance(2).levelDecreasePerBlock(3)
            .block(ModFluids.STRAWBERRY_FROSTING_BLOCK).bucket(ModFluids.STRAWBERRY_FROSTING_BUCKET);

    // orange

    // blueberry

    // pear


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}