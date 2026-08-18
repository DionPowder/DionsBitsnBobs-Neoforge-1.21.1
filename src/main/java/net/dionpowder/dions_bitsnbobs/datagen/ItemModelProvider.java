package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DBB.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(DBBItems.NETHERITE_DUST.get());
        basicItem(DBBItems.UNPROCESSED_NETHERITE_DUST.get());

        basicItem(DBBItems.STRAWBERRY.get());

        basicItem(DBBItems.UNCOOKED_DONUT.get());
        basicItem(DBBItems.DONUT.get());
        basicItem(DBBItems.SUGAR_DONUT.get());

        basicItem(DBBItems.CHORUS_DONUT.get());
        basicItem(DBBItems.BLUEBERRY_DONUT.get());
        basicItem(DBBItems.PEAR_DONUT.get());
        basicItem(DBBItems.STRAWBERRY_DONUT.get());
        basicItem(DBBItems.ORANGE_DONUT.get());

        basicItem(DBBItems.SPRINKLED_PEAR_DONUT.get());
        basicItem(DBBItems.SPRINKLED_STRAWBERRY_DONUT.get());
        basicItem(DBBItems.SPRINKLED_ORANGE_DONUT.get());

        basicItem(DBBItems.CHOCOLATE_DONUT.get());
        basicItem(DBBItems.DARK_CHOCOLATE_DONUT.get());
        basicItem(DBBItems.CARAMEL_DONUT.get());
        basicItem(DBBItems.WHITE_CHOCOLATE_DONUT.get());
        basicItem(DBBItems.RUBY_CHOCOLATE_DONUT.get());

        basicItem(DBBItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get());
        basicItem(DBBItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get());
        basicItem(DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get());

        basicItem(DBBItems.CHOCOLATE_HONEY_DONUT.get());
        basicItem(DBBItems.CHOCOLATE_STRAWBERRY_DONUT.get());
        basicItem(DBBItems.WHITE_CHOCOLATE_HONEY_DONUT.get());
        basicItem(DBBItems.WHITE_CHOCOLATE_PEAR_DONUT.get());
        basicItem(DBBItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        basicItem(DBBItems.EMPTY_SPRINKLES_BOTTLE.get());
        basicItem(DBBItems.BOTTLED_RAINBOW_SPRINKLES.get());
        basicItem(DBBItems.BOTTLED_WHITE_SPRINKLES.get());
        basicItem(DBBItems.BOTTLED_GREEN_SPRINKLES.get());

        basicItem(DBBFluids.STRAWBERRY_FROSTING.get().getBucket());
        basicItem(DBBFluids.ORANGE_FROSTING.get().getBucket());
        basicItem(DBBFluids.BLUEBERRY_FROSTING.get().getBucket());
        basicItem(DBBFluids.PEAR_FROSTING.get().getBucket());
        basicItem(DBBFluids.DONUT_BATTER.get().getBucket());

    }
}
