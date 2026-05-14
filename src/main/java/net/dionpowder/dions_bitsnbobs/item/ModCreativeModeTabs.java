package net.dionpowder.dions_bitsnbobs.item;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DionsBitsnBobs.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_ITEMS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_blocks_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.NETHERITE_DUST);

                        output.accept(ModItems.STRAWBERRY);

                        output.accept(ModItems.EMPTY_SPRINKLES_BOTTLE);
                        output.accept(ModItems.BOTTLED_RAINBOW_SPRINKLES);
                        output.accept(ModItems.BOTTLED_WHITE_SPRINKLES);
                        output.accept(ModItems.BOTTLED_GREEN_SPRINKLES);

                        output.accept(ModFluids.STRAWBERRY_FROSTING_BUCKET);
                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_DONUTS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_donuts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHORUS_DONUT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_items_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.donuts_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.UNCOOKED_DONUT);
                        output.accept(ModItems.DONUT);
                        output.accept(ModItems.SUGAR_DONUT);

                        output.accept(ModItems.CHORUS_DONUT);
                        output.accept(ModItems.BLUEBERRY_DONUT);
                        output.accept(ModItems.PEAR_DONUT);
                        output.accept(ModItems.STRAWBERRY_DONUT);
                        output.accept(ModItems.ORANGE_DONUT);

                        output.accept(ModItems.SPRINKLED_PEAR_DONUT);
                        output.accept(ModItems.SPRINKLED_STRAWBERRY_DONUT);
                        output.accept(ModItems.SPRINKLED_ORANGE_DONUT);

                        output.accept(ModItems.CHOCOLATE_DONUT);
                        output.accept(ModItems.DARK_CHOCOLATE_DONUT);
                        output.accept(ModItems.CARAMEL_DONUT);
                        output.accept(ModItems.WHITE_CHOCOLATE_DONUT);
                        output.accept(ModItems.RUBY_CHOCOLATE_DONUT);

                        output.accept(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT);
                        output.accept(ModItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT);
                        output.accept(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT);

                        output.accept(ModItems.CHOCOLATE_HONEY_DONUT);
                        output.accept(ModItems.CHOCOLATE_STRAWBERRY_DONUT);
                        output.accept(ModItems.WHITE_CHOCOLATE_HONEY_DONUT);
                        output.accept(ModItems.WHITE_CHOCOLATE_PEAR_DONUT);
                        output.accept(ModItems.WHITE_CHOCOLATE_RUBY_DONUT);
                    }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BITSNBOBS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STRAWBERRY_CRATE))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STRAWBERRY_CRATE);
                        output.accept(ModBlocks.COPPER_COMPONENT);
                        output.accept(ModBlocks.TRAIN_COMPONENT);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
