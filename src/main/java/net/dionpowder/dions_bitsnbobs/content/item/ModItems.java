package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.custom.ChorusDonutItem;
import net.dionpowder.dions_bitsnbobs.content.item.custom.SprinklesItemBase;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DionsBitsnBobs.MOD_ID);

    public static final DeferredItem<Item> NETHERITE_DUST = ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_NETHERITE_DUST = ITEMS.register("unprocessed_netherite_dust",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_MAGMA_BLOCK = ITEMS.register("unprocessed_magma_block",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_ANDESITE_COMPONENT = ITEMS.register("unprocessed_andesite_component",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_BRASS_COMPONENT = ITEMS.register("unprocessed_brass_component",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_COPPER_COMPONENT = ITEMS.register("unprocessed_copper_component",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> UNPROCESSED_TRAIN_COMPONENT = ITEMS.register("unprocessed_train_component",
            () -> new SequencedAssemblyItem(new SequencedAssemblyItem.Properties()));

    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.STRAWBERRY)));

    // simple donuts
    public static final DeferredItem<Item> UNCOOKED_DONUT = ITEMS.register("uncooked_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.UNCOOKED_DONUT)));

    public static final DeferredItem<Item> DONUT = ITEMS.register("donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DONUT)));

    public static final DeferredItem<Item> SUGAR_DONUT = ITEMS.register("sugar_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SUGAR_DONUT)));

    // frosting donuts
    public static final DeferredItem<Item> CHORUS_DONUT = ITEMS.register("chorus_donut",
            () -> new ChorusDonutItem(new ChorusDonutItem.Properties().food(ModFoodProperties.FROSTING_DONUTS)));

    public static final DeferredItem<Item> BLUEBERRY_DONUT = ITEMS.register("blueberry_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FROSTING_DONUTS)));

    public static final DeferredItem<Item> PEAR_DONUT = ITEMS.register("pear_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FROSTING_DONUTS)));

    public static final DeferredItem<Item> STRAWBERRY_DONUT = ITEMS.register("strawberry_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FROSTING_DONUTS)));

    public static final DeferredItem<Item> ORANGE_DONUT = ITEMS.register("orange_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FROSTING_DONUTS)));

    // topped frosting donuts
    public static final DeferredItem<Item> SPRINKLED_PEAR_DONUT = ITEMS.register("sprinkled_pear_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_FROSTING_DONUTS)));

    public static final DeferredItem<Item> SPRINKLED_STRAWBERRY_DONUT = ITEMS.register("sprinkled_strawberry_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_FROSTING_DONUTS)));

    public static final DeferredItem<Item> SPRINKLED_ORANGE_DONUT = ITEMS.register("sprinkled_orange_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_FROSTING_DONUTS)));

    // chocolate donuts
    public static final DeferredItem<Item> CHOCOLATE_DONUT = ITEMS.register("chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> DARK_CHOCOLATE_DONUT = ITEMS.register("dark_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> CARAMEL_DONUT = ITEMS.register("caramel_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> WHITE_CHOCOLATE_DONUT = ITEMS.register("white_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> RUBY_CHOCOLATE_DONUT = ITEMS.register("ruby_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHOCOLATE_DONUTS)));

    // topped chocolate donuts
    public static final DeferredItem<Item> STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = ITEMS.register("strawberry_topped_dark_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT = ITEMS.register("blueberry_topped_white_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_CHOCOLATE_DONUTS)));

    public static final DeferredItem<Item> SPRINKLED_WHITE_CHOCOLATE_DONUT = ITEMS.register("sprinkled_white_chocolate_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOPPED_CHOCOLATE_DONUTS)));

    // double glazed donuts
    public static final DeferredItem<Item> CHOCOLATE_HONEY_DONUT = ITEMS.register("chocolate_honey_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOUBLE_GLAZED_DONUTS)));

    public static final DeferredItem<Item> CHOCOLATE_STRAWBERRY_DONUT = ITEMS.register("chocolate_strawberry_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOUBLE_GLAZED_DONUTS)));

    public static final DeferredItem<Item> WHITE_CHOCOLATE_HONEY_DONUT = ITEMS.register("white_chocolate_honey_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOUBLE_GLAZED_DONUTS)));

    public static final DeferredItem<Item> WHITE_CHOCOLATE_PEAR_DONUT = ITEMS.register("white_chocolate_pear_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOUBLE_GLAZED_DONUTS)));

    public static final DeferredItem<Item> WHITE_CHOCOLATE_RUBY_DONUT = ITEMS.register("white_chocolate_ruby_donut",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOUBLE_GLAZED_DONUTS)));

    // sprinkles
    public static final DeferredItem<Item> EMPTY_SPRINKLES_BOTTLE = ITEMS.register("empty_sprinkles_bottle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BOTTLED_RAINBOW_SPRINKLES = ITEMS.register("bottled_rainbow_sprinkles",
            () -> new SprinklesItemBase(new SprinklesItemBase.Properties().food(ModFoodProperties.SPRINKLES)));

    public static final DeferredItem<Item> BOTTLED_WHITE_SPRINKLES = ITEMS.register("bottled_white_sprinkles",
            () -> new SprinklesItemBase(new SprinklesItemBase.Properties().food(ModFoodProperties.SPRINKLES)));

    public static final DeferredItem<Item> BOTTLED_GREEN_SPRINKLES = ITEMS.register("bottled_green_sprinkles",
            () -> new SprinklesItemBase(new SprinklesItemBase.Properties().food(ModFoodProperties.SPRINKLES)));

    public static void register(IEventBus eventBus) {
       ITEMS.register(eventBus);
    }
}
