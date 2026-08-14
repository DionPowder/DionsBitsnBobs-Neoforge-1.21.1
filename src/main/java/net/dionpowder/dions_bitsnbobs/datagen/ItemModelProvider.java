package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(DionsBitsnBobsItems.NETHERITE_DUST.get());
        basicItem(DionsBitsnBobsItems.UNPROCESSED_NETHERITE_DUST.get());

        basicItem(DionsBitsnBobsItems.STRAWBERRY.get());

        basicItem(DionsBitsnBobsItems.UNCOOKED_DONUT.get());
        basicItem(DionsBitsnBobsItems.DONUT.get());
        basicItem(DionsBitsnBobsItems.SUGAR_DONUT.get());

        basicItem(DionsBitsnBobsItems.CHORUS_DONUT.get());
        basicItem(DionsBitsnBobsItems.BLUEBERRY_DONUT.get());
        basicItem(DionsBitsnBobsItems.PEAR_DONUT.get());
        basicItem(DionsBitsnBobsItems.STRAWBERRY_DONUT.get());
        basicItem(DionsBitsnBobsItems.ORANGE_DONUT.get());

        basicItem(DionsBitsnBobsItems.SPRINKLED_PEAR_DONUT.get());
        basicItem(DionsBitsnBobsItems.SPRINKLED_STRAWBERRY_DONUT.get());
        basicItem(DionsBitsnBobsItems.SPRINKLED_ORANGE_DONUT.get());

        basicItem(DionsBitsnBobsItems.CHOCOLATE_DONUT.get());
        basicItem(DionsBitsnBobsItems.DARK_CHOCOLATE_DONUT.get());
        basicItem(DionsBitsnBobsItems.CARAMEL_DONUT.get());
        basicItem(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT.get());
        basicItem(DionsBitsnBobsItems.RUBY_CHOCOLATE_DONUT.get());

        basicItem(DionsBitsnBobsItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get());
        basicItem(DionsBitsnBobsItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get());
        basicItem(DionsBitsnBobsItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get());

        basicItem(DionsBitsnBobsItems.CHOCOLATE_HONEY_DONUT.get());
        basicItem(DionsBitsnBobsItems.CHOCOLATE_STRAWBERRY_DONUT.get());
        basicItem(DionsBitsnBobsItems.WHITE_CHOCOLATE_HONEY_DONUT.get());
        basicItem(DionsBitsnBobsItems.WHITE_CHOCOLATE_PEAR_DONUT.get());
        basicItem(DionsBitsnBobsItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        basicItem(DionsBitsnBobsItems.EMPTY_SPRINKLES_BOTTLE.get());
        basicItem(DionsBitsnBobsItems.BOTTLED_RAINBOW_SPRINKLES.get());
        basicItem(DionsBitsnBobsItems.BOTTLED_WHITE_SPRINKLES.get());
        basicItem(DionsBitsnBobsItems.BOTTLED_GREEN_SPRINKLES.get());

        basicItem(DionsBitsnBobsFluids.STRAWBERRY_FROSTING_BUCKET.get());
        basicItem(DionsBitsnBobsFluids.ORANGE_FROSTING_BUCKET.get());
        basicItem(DionsBitsnBobsFluids.BLUEBERRY_FROSTING_BUCKET.get());
        basicItem(DionsBitsnBobsFluids.PEAR_FROSTING_BUCKET.get());
        basicItem(DionsBitsnBobsFluids.DONUT_BATTER_BUCKET.get());

    }
}
