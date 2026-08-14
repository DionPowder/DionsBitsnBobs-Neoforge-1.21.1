package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.dionpowder.dions_bitsnbobs.utils.DionsBitsnBobsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {


    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DionsBitsnBobsTags.Items.DONUTS)
                .add(DionsBitsnBobsItems.UNCOOKED_DONUT.get())
                .add(DionsBitsnBobsItems.DONUT.get())
                .add(DionsBitsnBobsItems.SUGAR_DONUT.get())

                .add(DionsBitsnBobsItems.CHORUS_DONUT.get())
                .add(DionsBitsnBobsItems.BLUEBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.ORANGE_DONUT.get())

                .add(DionsBitsnBobsItems.SPRINKLED_PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_ORANGE_DONUT.get())

                .add(DionsBitsnBobsItems.CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.DARK_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.CARAMEL_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.RUBY_CHOCOLATE_DONUT.get())

                .add(DionsBitsnBobsItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get())

                .add(DionsBitsnBobsItems.CHOCOLATE_HONEY_DONUT.get())
                .add(DionsBitsnBobsItems.CHOCOLATE_STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_HONEY_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        tag(DionsBitsnBobsTags.Items.SIMPLE_DONUTS)
                .add(DionsBitsnBobsItems.UNCOOKED_DONUT.get())
                .add(DionsBitsnBobsItems.DONUT.get())
                .add(DionsBitsnBobsItems.SUGAR_DONUT.get());

        tag(DionsBitsnBobsTags.Items.FROSTING_DONUTS)
                .add(DionsBitsnBobsItems.CHORUS_DONUT.get())
                .add(DionsBitsnBobsItems.BLUEBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.ORANGE_DONUT.get());

        tag(DionsBitsnBobsTags.Items.TOPPED_FROSTING_DONUTS)
                .add(DionsBitsnBobsItems.SPRINKLED_PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_ORANGE_DONUT.get());

        tag(DionsBitsnBobsTags.Items.CHOCOLATE_DONUTS)
                .add(DionsBitsnBobsItems.CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.DARK_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.CARAMEL_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.RUBY_CHOCOLATE_DONUT.get());

        tag(DionsBitsnBobsTags.Items.TOPPED_CHOCOLATE_DONUTS)
                .add(DionsBitsnBobsItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get())
                .add(DionsBitsnBobsItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get());

        tag(DionsBitsnBobsTags.Items.DOUBLE_GLAZED_DONUTS)
                .add(DionsBitsnBobsItems.CHOCOLATE_HONEY_DONUT.get())
                .add(DionsBitsnBobsItems.CHOCOLATE_STRAWBERRY_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_HONEY_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_PEAR_DONUT.get())
                .add(DionsBitsnBobsItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        tag(DionsBitsnBobsTags.Items.SPRINKLES)
                .add(DionsBitsnBobsItems.BOTTLED_RAINBOW_SPRINKLES.get())
                .add(DionsBitsnBobsItems.BOTTLED_WHITE_SPRINKLES.get())
                .add(DionsBitsnBobsItems.BOTTLED_GREEN_SPRINKLES.get());

        tag(DionsBitsnBobsTags.Items.ADVANCEMENT_GLAZED_DONUT)
                .addTag(DionsBitsnBobsTags.Items.FROSTING_DONUTS)
                .addTag(DionsBitsnBobsTags.Items.CHOCOLATE_DONUTS);

        tag(DionsBitsnBobsTags.Items.ADVANCEMENT_TOPPED_DONUT)
                .addTag(DionsBitsnBobsTags.Items.TOPPED_FROSTING_DONUTS)
                .addTag(DionsBitsnBobsTags.Items.TOPPED_CHOCOLATE_DONUTS);

        tag(DionsBitsnBobsTags.Items.CROPS).add(DionsBitsnBobsItems.STRAWBERRY.get());
        tag(DionsBitsnBobsTags.Items.CROPS_STRAWBERRY).add(DionsBitsnBobsItems.STRAWBERRY.get());
        tag(DionsBitsnBobsTags.Items.FOODS)
                .add(DionsBitsnBobsItems.STRAWBERRY.get())
                .addTag(DionsBitsnBobsTags.Items.DONUTS);
        tag(DionsBitsnBobsTags.Items.FOODS_STRAWBERRY).add(DionsBitsnBobsItems.STRAWBERRY.get());
        tag(DionsBitsnBobsTags.Items.FOODS_DONUTS).addTag(DionsBitsnBobsTags.Items.DONUTS);

        tag(DionsBitsnBobsTags.Items.ROOTED_DIRT_MIXING)
                .add(Items.HANGING_ROOTS)
                .add(Items.DEAD_BUSH);

        tag(DionsBitsnBobsTags.Items.UNPROCESSED_COMPONENTS)
                .add(DionsBitsnBobsItems.UNPROCESSED_ANDESITE_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_BRASS_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_COPPER_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_TRAIN_COMPONENT.get());

        tag(DionsBitsnBobsTags.Items.BAKER_FROSTING_TRADES)
                .add(DionsBitsnBobsFluids.BLUEBERRY_FROSTING_BUCKET.get())
                .add(DionsBitsnBobsFluids.PEAR_FROSTING_BUCKET.get())
                .add(DionsBitsnBobsFluids.STRAWBERRY_FROSTING_BUCKET.get())
                .add(DionsBitsnBobsFluids.ORANGE_FROSTING_BUCKET.get());

        tag(DionsBitsnBobsTags.Items.BAKER_CHOCOLATE_TRADES)
                .add(AllFluids.CHOCOLATE.get().getBucket())
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel_bucket"));

    }
}
