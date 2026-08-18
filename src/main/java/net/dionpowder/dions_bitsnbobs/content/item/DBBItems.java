package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.dionpowder.dions_bitsnbobs.content.item.custom.ChorusDonutItem;
import net.dionpowder.dions_bitsnbobs.content.item.custom.SprinklesItem;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

public class DBBItems {
    
    public static final ItemEntry<Item> STRAWBERRY = REGISTRATE.item("strawberry", Item::new)
            .tag(Tags.Items.CROPS, Tags.Items.FOODS, DBBTags.Items.FOODS_STRAWBERRY, DBBTags.Items.CROPS_STRAWBERRY)
            .properties(p -> p.food(DBBFoodProperties.STRAWBERRY))
            .register();
    
    public static final ItemEntry<Item> UNCOOKED_DONUT = REGISTRATE.item("uncooked_donut", Item::new)
            .tag(DBBTags.Items.SIMPLE_DONUTS, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
            .properties(p -> p.food(DBBFoodProperties.UNCOOKED_DONUT))
            .register();
    
    public static final ItemEntry<Item> DONUT = REGISTRATE.item("donut", Item::new)
            .tag(DBBTags.Items.SIMPLE_DONUTS, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
            .properties(p -> p.food(DBBFoodProperties.DONUT))
            .register();
    
    public static final ItemEntry<Item> SUGAR_DONUT = REGISTRATE.item("sugar_donut", Item::new)
            .tag(DBBTags.Items.SIMPLE_DONUTS, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
            .properties(p -> p.food(DBBFoodProperties.SUGAR_DONUT))
            .register();
    
    public static final ItemEntry<ChorusDonutItem> CHORUS_DONUT = REGISTRATE.item("chorus_donut", ChorusDonutItem::new)
            .tag(DBBTags.Items.FROSTING_DONUTS, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
            .properties(p -> p.food(DBBFoodProperties.FROSTING_DONUTS))
            .register();

    // register items with create registrate system
    public static final ItemEntry<SequencedAssemblyItem>
            UNPROCESSED_NETHERITE_DUST = sequencedIngredient("unprocessed_netherite_dust"),
            UNPROCESSED_MAGMA_BLOCK = sequencedIngredient("unprocessed_magma_block"),
            UNPROCESSED_ANDESITE_COMPONENT = sequencedIngredient("unprocessed_andesite_component"),
            UNPROCESSED_BRASS_COMPONENT = sequencedIngredient("unprocessed_brass_component"),
            UNPROCESSED_COPPER_COMPONENT = sequencedIngredient("unprocessed_copper_component"),
            UNPROCESSED_TRAIN_COMPONENT = sequencedIngredient("unprocessed_train_component");
    
    public static final ItemEntry<Item>
            NETHERITE_DUST = ingredient("netherite_dust"),
            EMPTY_SPRINKLES_BOTTLE = ingredient("empty_sprinkles_bottle");
    
    public static final ItemEntry<Item>
            BLUEBERRY_DONUT = frostingDonuts("blueberry_donut"),
            STRAWBERRY_DONUT = frostingDonuts("strawberry_donut"),
            PEAR_DONUT = frostingDonuts("pear_donut"),
            ORANGE_DONUT = frostingDonuts("orange_donut");
    
    public static final ItemEntry<Item>
            SPRINKLED_PEAR_DONUT = toppedFrostingDonuts("sprinkled_pear_donut"),
            SPRINKLED_STRAWBERRY_DONUT = toppedFrostingDonuts("sprinkled_strawberry_donut"),
            SPRINKLED_ORANGE_DONUT = toppedFrostingDonuts("sprinkled_orange_donut");
    
    public static final ItemEntry<Item>
            CHOCOLATE_DONUT = chocolateDonuts("chocolate_donut"),
            DARK_CHOCOLATE_DONUT = chocolateDonuts("dark_chocolate_donut"),
            WHITE_CHOCOLATE_DONUT = chocolateDonuts("white_chocolate_donut"),
            RUBY_CHOCOLATE_DONUT = chocolateDonuts("ruby_chocolate_donut"),
            CARAMEL_DONUT = chocolateDonuts("caramel_donut");
    
    public static final ItemEntry<Item>
            STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = toppedChocolateDonuts("strawberry_topped_dark_chocolate_donut"),
            BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT = toppedChocolateDonuts("blueberry_topped_white_chocolate_donut"),
            SPRINKLED_WHITE_CHOCOLATE_DONUT = toppedChocolateDonuts("sprinkled_white_chocolate_donut");
    
    public static final ItemEntry<Item>
            CHOCOLATE_HONEY_DONUT = doubleGlazedDonuts("chocolate_honey_donut"),
            CHOCOLATE_STRAWBERRY_DONUT = doubleGlazedDonuts("chocolate_strawberry_donut"),
            WHITE_CHOCOLATE_HONEY_DONUT = doubleGlazedDonuts("white_chocolate_honey_donut"),
            WHITE_CHOCOLATE_PEAR_DONUT = doubleGlazedDonuts("white_chocolate_pear_donut"),
            WHITE_CHOCOLATE_RUBY_DONUT = doubleGlazedDonuts("white_chocolate_ruby_donut");

    public static final ItemEntry<SprinklesItem>
            BOTTLED_RAINBOW_SPRINKLES = sprinkles("bottled_rainbow_sprinkles"),
            BOTTLED_WHITE_SPRINKLES = sprinkles("bottled_white_sprinkles"),
            BOTTLED_GREEN_SPRINKLES = sprinkles("bottled_green_sprinkles");
    
    // shortcuts

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }
    
    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }
    
    private static ItemEntry<Item> frostingDonuts(String name) {
        return REGISTRATE.item(name, Item::new)
                .properties(p -> p.food(DBBFoodProperties.FROSTING_DONUTS))
                .tag(DBBTags.Items.FROSTING_DONUTS, DBBTags.Items.ADVANCEMENT_GLAZED_DONUT, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
                .register();
    }
    
    private static ItemEntry<Item> toppedFrostingDonuts(String name) {
        return REGISTRATE.item(name, Item::new)
                .properties(p -> p.food(DBBFoodProperties.TOPPED_FROSTING_DONUTS))
                .tag(DBBTags.Items.TOPPED_FROSTING_DONUTS, DBBTags.Items.ADVANCEMENT_TOPPED_DONUT, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
                .register();
    }
    
    private static ItemEntry<Item> chocolateDonuts(String name) {
        return REGISTRATE.item(name, Item::new)
                .properties(p -> p.food(DBBFoodProperties.CHOCOLATE_DONUTS))
                .tag(DBBTags.Items.CHOCOLATE_DONUTS, DBBTags.Items.ADVANCEMENT_GLAZED_DONUT, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
                .register();
    }
    
    private static ItemEntry<Item> toppedChocolateDonuts(String name) {
        return REGISTRATE.item(name, Item::new)
                .properties(p -> p.food(DBBFoodProperties.TOPPED_CHOCOLATE_DONUTS))
                .tag(DBBTags.Items.TOPPED_CHOCOLATE_DONUTS, DBBTags.Items.ADVANCEMENT_TOPPED_DONUT, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
                .register();
    }
    
    private static ItemEntry<Item> doubleGlazedDonuts(String name) {
        return REGISTRATE.item(name, Item::new)
                .properties(p -> p.food(DBBFoodProperties.DOUBLE_GLAZED_DONUTS))
                .tag(DBBTags.Items.DOUBLE_GLAZED_DONUTS, Tags.Items.FOODS, DBBTags.Items.FOODS_DONUTS, DBBTags.Items.DONUTS)
                .register();
    }

    private static ItemEntry<SprinklesItem> sprinkles(String name) {
        return REGISTRATE.item(name, SprinklesItem::new)
                .properties(p -> p.food(DBBFoodProperties.SPRINKLES))
                .tag(DBBTags.Items.SPRINKLES)
                .register();
    }

    public static void register(IEventBus eventBus) {
    
    }
}
