package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.DONUTS)
                .add(ModItems.UNCOOKED_DONUT.get())
                .add(ModItems.DONUT.get())
                .add(ModItems.SUGAR_DONUT.get())

                .add(ModItems.CHORUS_DONUT.get())
                .add(ModItems.BLUEBERRY_DONUT.get())
                .add(ModItems.PEAR_DONUT.get())
                .add(ModItems.STRAWBERRY_DONUT.get())
                .add(ModItems.ORANGE_DONUT.get())

                .add(ModItems.SPRINKLED_PEAR_DONUT.get())
                .add(ModItems.SPRINKLED_STRAWBERRY_DONUT.get())
                .add(ModItems.SPRINKLED_ORANGE_DONUT.get())

                .add(ModItems.CHOCOLATE_DONUT.get())
                .add(ModItems.DARK_CHOCOLATE_DONUT.get())
                .add(ModItems.CARAMEL_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_DONUT.get())
                .add(ModItems.RUBY_CHOCOLATE_DONUT.get())

                .add(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get())
                .add(ModItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get())
                .add(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get())

                .add(ModItems.CHOCOLATE_HONEY_DONUT.get())
                .add(ModItems.CHOCOLATE_STRAWBERRY_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_HONEY_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_PEAR_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        tag(ModTags.Items.SIMPLE_DONUTS)
                .add(ModItems.UNCOOKED_DONUT.get())
                .add(ModItems.DONUT.get())
                .add(ModItems.SUGAR_DONUT.get());

        tag(ModTags.Items.FROSTING_DONUTS)
                .add(ModItems.CHORUS_DONUT.get())
                .add(ModItems.BLUEBERRY_DONUT.get())
                .add(ModItems.PEAR_DONUT.get())
                .add(ModItems.STRAWBERRY_DONUT.get())
                .add(ModItems.ORANGE_DONUT.get());

        tag(ModTags.Items.TOPPED_FROSTING_DONUTS)
                .add(ModItems.SPRINKLED_PEAR_DONUT.get())
                .add(ModItems.SPRINKLED_STRAWBERRY_DONUT.get())
                .add(ModItems.SPRINKLED_ORANGE_DONUT.get());

        tag(ModTags.Items.CHOCOLATE_DONUTS)
                .add(ModItems.CHOCOLATE_DONUT.get())
                .add(ModItems.DARK_CHOCOLATE_DONUT.get())
                .add(ModItems.CARAMEL_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_DONUT.get())
                .add(ModItems.RUBY_CHOCOLATE_DONUT.get());

        tag(ModTags.Items.TOPPED_CHOCOLATE_DONUTS)
                .add(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get())
                .add(ModItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get())
                .add(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get());

        tag(ModTags.Items.DOUBLE_GLAZED_DONUTS)
                .add(ModItems.CHOCOLATE_HONEY_DONUT.get())
                .add(ModItems.CHOCOLATE_STRAWBERRY_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_HONEY_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_PEAR_DONUT.get())
                .add(ModItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        tag(ModTags.Items.SPRINKLES)
                .add(ModItems.EMPTY_SPRINKLES_BOTTLE.get())
                .add(ModItems.BOTTLED_RAINBOW_SPRINKLES.get())
                .add(ModItems.BOTTLED_WHITE_SPRINKLES.get())
                .add(ModItems.BOTTLED_GREEN_SPRINKLES.get());

        tag(ModTags.Items.ADVANCEMENT_GLAZED_DONUT)
                .addTag(ModTags.Items.FROSTING_DONUTS)
                .addTag(ModTags.Items.CHOCOLATE_DONUTS);

        tag(ModTags.Items.ADVANCEMENT_TOPPED_DONUT)
                .addTag(ModTags.Items.TOPPED_FROSTING_DONUTS)
                .addTag(ModTags.Items.TOPPED_CHOCOLATE_DONUTS);

        tag(ModTags.Items.CROPS).add(ModItems.STRAWBERRY.get());
        tag(ModTags.Items.CROPS_STRAWBERRY).add(ModItems.STRAWBERRY.get());
        tag(ModTags.Items.FOODS)
                .add(ModItems.STRAWBERRY.get())
                .addTag(ModTags.Items.DONUTS);
        tag(ModTags.Items.FOODS_STRAWBERRY).add(ModItems.STRAWBERRY.get());
        tag(ModTags.Items.FOODS_DONUTS).addTag(ModTags.Items.DONUTS);

        tag(ModTags.Items.ROOTED_DIRT_MIXING)
                .add(Items.HANGING_ROOTS)
                .add(Items.DEAD_BUSH);
    }
}
