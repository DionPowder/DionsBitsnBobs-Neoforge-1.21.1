package net.dionpowder.dions_bitsnbobs.foundation.advancement;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import com.google.common.collect.Sets;

import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.PackOutput.PathProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import static net.dionpowder.dions_bitsnbobs.foundation.advancement.CreateAdvancement.TaskType.*;

public class DBBAdvancements implements DataProvider {

    public static final List<CreateAdvancement> ENTRIES = new ArrayList<>();
    public static final CreateAdvancement START = null,

    ROOT = create("root", b -> b.icon(DBBItems.STRAWBERRY)
            .title("Create: Dion's Bits n' Bobs!")
            .description("Explore extra food and automation options!")
            .awardedForFree()
            .special(NORMAL)),

    // Donut branch
    UNCOOKED_DONUT = create("uncooked_donut", b -> b.icon(DBBBlocks.FILLED_DONUT_CAST)
            .title("It's a Start")
            .description("Fill your first donut cast")
            .whenIconCollected()
            .after(ROOT)
            .special(NORMAL)),

    DONUT = create("donut", b -> b.icon(DBBItems.DONUT)
            .title("We're Getting Somewhere")
            .description("Press your first donut")
            .whenIconCollected()
            .after(UNCOOKED_DONUT)
            .special(NORMAL)),

    GLAZED_DONUT = create("glazed_donut", b -> b.icon(DBBItems.STRAWBERRY_DONUT)
            .title("Nearing Perfection")
            .description("Glaze your first donut")
            .whenItemCollected(DBBTags.Items.ADVANCEMENT_GLAZED_DONUT)
            .after(DONUT)
            .special(NORMAL)),

    CHORUS_DONUT = create("chorus_donut", b -> b.icon(DBBItems.CHORUS_DONUT)
            .title("What Just Happened")
            .description("Teleport after eating a chorus donut")
            .after(GLAZED_DONUT)
            .special(SECRET)),

    TOPPED_DONUT = create("topped_donut", b -> b.icon(DBBItems.BOTTLED_RAINBOW_SPRINKLES)
            .title("Top It Off")
            .description("Apply some toppings to your donut")
            .whenItemCollected(DBBTags.Items.ADVANCEMENT_TOPPED_DONUT)
            .after(GLAZED_DONUT)
            .special(NORMAL)),

    DOUBLE_GLAZED_DONUT = create("double_glazed_donut", b -> b.icon(DBBItems.CHOCOLATE_STRAWBERRY_DONUT)
            .title("Perfection Achieved")
            .description("Double glaze your first donut")
            .whenItemCollected(DBBTags.Items.DOUBLE_GLAZED_DONUTS)
            .after(GLAZED_DONUT)
            .special(EXPERT)),

    ALL_DONUTS = create("all_donuts", b -> b.icon(DBBItems.WHITE_CHOCOLATE_RUBY_DONUT)
            .title("A Donut Empire")
            .description("Collect all the different donuts")
            .whenItemCollected(DBBItems.DONUT)
            .whenItemCollected(DBBItems.SUGAR_DONUT)
            .whenItemCollected(DBBItems.CHORUS_DONUT)
            .whenItemCollected(DBBItems.BLUEBERRY_DONUT)
            .whenItemCollected(DBBItems.PEAR_DONUT)
            .whenItemCollected(DBBItems.STRAWBERRY_DONUT)
            .whenItemCollected(DBBItems.ORANGE_DONUT)
            .whenItemCollected(DBBItems.SPRINKLED_PEAR_DONUT)
            .whenItemCollected(DBBItems.SPRINKLED_STRAWBERRY_DONUT)
            .whenItemCollected(DBBItems.SPRINKLED_ORANGE_DONUT)
            .whenItemCollected(DBBItems.CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.DARK_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.CARAMEL_DONUT)
            .whenItemCollected(DBBItems.WHITE_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.RUBY_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT)
            .whenItemCollected(DBBItems.CHOCOLATE_HONEY_DONUT)
            .whenItemCollected(DBBItems.CHOCOLATE_STRAWBERRY_DONUT)
            .whenItemCollected(DBBItems.WHITE_CHOCOLATE_HONEY_DONUT)
            .whenItemCollected(DBBItems.WHITE_CHOCOLATE_PEAR_DONUT)
            .whenItemCollected(DBBItems.WHITE_CHOCOLATE_RUBY_DONUT)
            .after(DOUBLE_GLAZED_DONUT)
            .special(CHALLENGE)),

    // Netherite dust branch
    NETHERITE_DUST = create("netherite_dust", b -> b.icon(DBBItems.NETHERITE_DUST)
            .title("Illegal Substances")
            .description("Mix your first netherite dust")
            .whenIconCollected()
            .after(ROOT)
            .special(NOISY)),

    ALL_COMPONENTS = create("all_components", b -> b.icon(DBBBlocks.BRASS_COMPONENT)
            .title("Component Mania")
            .description("Create all the different components")
            .whenItemCollected(DBBBlocks.ANDESITE_COMPONENT)
            .whenItemCollected(DBBBlocks.BRASS_COMPONENT)
            .whenItemCollected(DBBBlocks.COPPER_COMPONENT)
            .whenItemCollected(DBBBlocks.TRAIN_COMPONENT)
            .after(NETHERITE_DUST)
            .special(CHALLENGE)),

    // Strawberry branch
    STRAWBERRY = create("strawberry", b -> b.icon(DBBItems.STRAWBERRY)
            .title("Sweet Tooth")
            .description("Collect your first strawberries")
            .whenIconCollected()
            .after(ROOT)
            .special(NORMAL)),

    STRAWBERRY_BUSH = create("strawberry_bush", b -> b.icon(DBBBlocks.WILD_STRAWBERRY_BUSH)
            .title("Ready To Farm")
            .description("Place your first strawberry bush")
            .whenBlockPlaced(DBBBlocks.STRAWBERRY_BUSH.get())
            .after(STRAWBERRY)
            .special(NORMAL)),

    STRAWBERRY_FROSTING = create("strawberry_frosting", b -> b.icon(DBBFluids.STRAWBERRY_FROSTING.get().getBucket())
            .title("More Sugar")
            .description("Mix your first strawberry frosting bucket")
            .whenIconCollected()
            .after(STRAWBERRY)
            .special(EXPERT)),

    BULK_FROSTED = create("bulk_frosted", b -> b.icon(Items.SUGAR)
            .title("Sugar Infused")
            .description("Get bulk frosted by an encased fan")
            .after(STRAWBERRY_FROSTING)
            .special(SECRET)),

    // Sprinkles branch
    SPRINKLES = create("sprinkles", b -> b.icon(DBBItems.BOTTLED_WHITE_SPRINKLES)
            .title("Sprinkles")
            .description("Craft your first sprinkles")
            .whenItemCollected(DBBTags.Items.SPRINKLES)
            .after(ROOT)
            .special(NORMAL)),

    SUGAR_RUSH = create("sugar_rush", b -> b.icon(Items.SUGAR)
            .title("Sugar Rush")
            .description("Eat some sprinkles and see what happens")
            .after(SPRINKLES)
            .special(NOISY));

    private static CreateAdvancement create(String id, UnaryOperator<CreateAdvancement.Builder> b) {
        return new CreateAdvancement(id, b);
    }

    // Datagen

    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public DBBAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        this.output = output;
        this.registries = registries;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return this.registries.thenCompose(provider -> {
            PathProvider pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "advancement");
            List<CompletableFuture<?>> futures = new ArrayList<>();

            Set<ResourceLocation> set = Sets.newHashSet();
            Consumer<AdvancementHolder> consumer = (advancement) -> {
                ResourceLocation id = advancement.id();
                if (!set.add(id))
                    throw new IllegalStateException("Duplicate advancement " + id);
                Path path = pathProvider.json(id);
                LOGGER.info("Saving advancement {}", id);
                futures.add(DataProvider.saveStable(cache, provider, Advancement.CODEC, advancement.value(), path));
            };

            for (CreateAdvancement advancement : ENTRIES)
                advancement.save(consumer, provider);

            return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        });
    }

    @Override
    public String getName() {
        return "Create: Dion's Bits n' Bobs Advancements";
    }

    public static void provideLang(BiConsumer<String, String> consumer) {
        for (CreateAdvancement advancement : ENTRIES)
            advancement.provideLang(consumer);
    }

    public static void register() {
    }

}