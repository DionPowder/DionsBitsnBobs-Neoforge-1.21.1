package net.dionpowder.dions_bitsnbobs.content.item;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.DionsBitsnBobsBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DionsBitsnBobsCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DionsBitsnBobs.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_ITEMS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DionsBitsnBobsItems.STRAWBERRY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_blocks_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get().getBucket());
                        output.accept(DionsBitsnBobsFluids.ORANGE_FROSTING.get().getBucket());
                        output.accept(DionsBitsnBobsFluids.BLUEBERRY_FROSTING.get().getBucket());
                        output.accept(DionsBitsnBobsFluids.PEAR_FROSTING.get().getBucket());
                        output.accept(DionsBitsnBobsFluids.DONUT_BATTER.get().getBucket());

                        output.accept(DionsBitsnBobsItems.EMPTY_SPRINKLES_BOTTLE);
                        output.accept(DionsBitsnBobsItems.BOTTLED_RAINBOW_SPRINKLES);
                        output.accept(DionsBitsnBobsItems.BOTTLED_WHITE_SPRINKLES);
                        output.accept(DionsBitsnBobsItems.BOTTLED_GREEN_SPRINKLES);

                        output.accept(DionsBitsnBobsItems.STRAWBERRY);

                        output.accept(DionsBitsnBobsItems.NETHERITE_DUST);

                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_DONUTS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_donuts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DionsBitsnBobsItems.CHORUS_DONUT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_items_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.donuts_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DionsBitsnBobsItems.UNCOOKED_DONUT);
                        output.accept(DionsBitsnBobsItems.DONUT);
                        output.accept(DionsBitsnBobsItems.SUGAR_DONUT);

                        output.accept(DionsBitsnBobsItems.CHORUS_DONUT);
                        output.accept(DionsBitsnBobsItems.BLUEBERRY_DONUT);
                        output.accept(DionsBitsnBobsItems.PEAR_DONUT);
                        output.accept(DionsBitsnBobsItems.STRAWBERRY_DONUT);
                        output.accept(DionsBitsnBobsItems.ORANGE_DONUT);

                        output.accept(DionsBitsnBobsItems.SPRINKLED_PEAR_DONUT);
                        output.accept(DionsBitsnBobsItems.SPRINKLED_STRAWBERRY_DONUT);
                        output.accept(DionsBitsnBobsItems.SPRINKLED_ORANGE_DONUT);

                        output.accept(DionsBitsnBobsItems.CHOCOLATE_DONUT);
                        output.accept(DionsBitsnBobsItems.DARK_CHOCOLATE_DONUT);
                        output.accept(DionsBitsnBobsItems.CARAMEL_DONUT);
                        output.accept(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT);
                        output.accept(DionsBitsnBobsItems.RUBY_CHOCOLATE_DONUT);

                        output.accept(DionsBitsnBobsItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT);
                        output.accept(DionsBitsnBobsItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT);
                        output.accept(DionsBitsnBobsItems.SPRINKLED_WHITE_CHOCOLATE_DONUT);

                        output.accept(DionsBitsnBobsItems.CHOCOLATE_HONEY_DONUT);
                        output.accept(DionsBitsnBobsItems.CHOCOLATE_STRAWBERRY_DONUT);
                        output.accept(DionsBitsnBobsItems.WHITE_CHOCOLATE_HONEY_DONUT);
                        output.accept(DionsBitsnBobsItems.WHITE_CHOCOLATE_PEAR_DONUT);
                        output.accept(DionsBitsnBobsItems.WHITE_CHOCOLATE_RUBY_DONUT);
                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DionsBitsnBobsBlocks.STRAWBERRY_CRATE))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DionsBitsnBobsBlocks.STRAWBERRY_CRATE);
                        output.accept(DionsBitsnBobsBlocks.ANDESITE_COMPONENT);
                        output.accept(DionsBitsnBobsBlocks.BRASS_COMPONENT);
                        output.accept(DionsBitsnBobsBlocks.COPPER_COMPONENT);
                        output.accept(DionsBitsnBobsBlocks.TRAIN_COMPONENT);
                        output.accept(DionsBitsnBobsBlocks.DONUT_CAST);
                        output.accept(DionsBitsnBobsBlocks.FILLED_DONUT_CAST);
                        output.accept(DionsBitsnBobsBlocks.COOKED_DONUT_CAST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
