package net.dionpowder.dions_bitsnbobs.item;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DionsBitsnBobs.MOD_ID);

    public static final Supplier<CreativeModeTab> BITSNBOBS_ITEMS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_blocks_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STRAWBERRY);
                    }).build());

    public static final Supplier<CreativeModeTab> BITSNBOBS_DONUTS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_donuts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHORUS_JAM_DONUT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "bitsnbobs_items_tab"))
                    .title(Component.translatable("creativetab.dions_bitsnbobs.donuts_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHORUS_JAM_DONUT);
                    }).build());

    public static final Supplier<CreativeModeTab> BITSNBOBS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bitsnbobs_blocks_tab",
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
