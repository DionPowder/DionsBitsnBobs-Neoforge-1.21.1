package net.dionpowder.dions_bitsnbobs.content.item;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DBBCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DBB.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_ITEMS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DBBItems.STRAWBERRY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "bitsnbobs_blocks_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DBBFluids.STRAWBERRY_FROSTING.get().getBucket());
                        output.accept(DBBFluids.ORANGE_FROSTING.get().getBucket());
                        output.accept(DBBFluids.BLUEBERRY_FROSTING.get().getBucket());
                        output.accept(DBBFluids.PEAR_FROSTING.get().getBucket());
                        output.accept(DBBFluids.DONUT_BATTER.get().getBucket());

                        output.accept(DBBItems.EMPTY_SPRINKLES_BOTTLE);
                        output.accept(DBBItems.BOTTLED_RAINBOW_SPRINKLES);
                        output.accept(DBBItems.BOTTLED_WHITE_SPRINKLES);
                        output.accept(DBBItems.BOTTLED_GREEN_SPRINKLES);

                        output.accept(DBBItems.STRAWBERRY);

                        output.accept(DBBItems.NETHERITE_DUST);

                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_DONUTS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_donuts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DBBItems.CHORUS_DONUT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "bitsnbobs_items_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.donuts_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DBBItems.UNCOOKED_DONUT);
                        output.accept(DBBItems.DONUT);
                        output.accept(DBBItems.SUGAR_DONUT);

                        output.accept(DBBItems.CHORUS_DONUT);
                        output.accept(DBBItems.BLUEBERRY_DONUT);
                        output.accept(DBBItems.PEAR_DONUT);
                        output.accept(DBBItems.STRAWBERRY_DONUT);
                        output.accept(DBBItems.ORANGE_DONUT);

                        output.accept(DBBItems.SPRINKLED_PEAR_DONUT);
                        output.accept(DBBItems.SPRINKLED_STRAWBERRY_DONUT);
                        output.accept(DBBItems.SPRINKLED_ORANGE_DONUT);

                        output.accept(DBBItems.CHOCOLATE_DONUT);
                        output.accept(DBBItems.DARK_CHOCOLATE_DONUT);
                        output.accept(DBBItems.CARAMEL_DONUT);
                        output.accept(DBBItems.WHITE_CHOCOLATE_DONUT);
                        output.accept(DBBItems.RUBY_CHOCOLATE_DONUT);

                        output.accept(DBBItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT);
                        output.accept(DBBItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT);
                        output.accept(DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT);

                        output.accept(DBBItems.CHOCOLATE_HONEY_DONUT);
                        output.accept(DBBItems.CHOCOLATE_STRAWBERRY_DONUT);
                        output.accept(DBBItems.WHITE_CHOCOLATE_HONEY_DONUT);
                        output.accept(DBBItems.WHITE_CHOCOLATE_PEAR_DONUT);
                        output.accept(DBBItems.WHITE_CHOCOLATE_RUBY_DONUT);
                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DBBBlocks.STRAWBERRY_CRATE))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(DBBBlocks.STRAWBERRY_CRATE);
                        output.accept(DBBBlocks.ANDESITE_COMPONENT);
                        output.accept(DBBBlocks.BRASS_COMPONENT);
                        output.accept(DBBBlocks.COPPER_COMPONENT);
                        output.accept(DBBBlocks.TRAIN_COMPONENT);
                        output.accept(DBBBlocks.DONUT_CAST);
                        output.accept(DBBBlocks.FILLED_DONUT_CAST);
                        output.accept(DBBBlocks.COOKED_DONUT_CAST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
