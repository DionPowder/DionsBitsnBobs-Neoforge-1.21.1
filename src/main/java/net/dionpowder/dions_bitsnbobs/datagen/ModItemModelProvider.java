package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NETHERITE_DUST.get());
        basicItem(ModItems.UNPROCESSED_NETHERITE_DUST.get());

        basicItem(ModItems.STRAWBERRY.get());

        basicItem(ModItems.UNCOOKED_DONUT.get());
        basicItem(ModItems.DONUT.get());
        basicItem(ModItems.SUGAR_DONUT.get());

        basicItem(ModItems.CHORUS_DONUT.get());
        basicItem(ModItems.BLUEBERRY_DONUT.get());
        basicItem(ModItems.PEAR_DONUT.get());
        basicItem(ModItems.STRAWBERRY_DONUT.get());
        basicItem(ModItems.ORANGE_DONUT.get());

        basicItem(ModItems.SPRINKLED_PEAR_DONUT.get());
        basicItem(ModItems.SPRINKLED_STRAWBERRY_DONUT.get());
        basicItem(ModItems.SPRINKLED_ORANGE_DONUT.get());

        basicItem(ModItems.CHOCOLATE_DONUT.get());
        basicItem(ModItems.DARK_CHOCOLATE_DONUT.get());
        basicItem(ModItems.CARAMEL_DONUT.get());
        basicItem(ModItems.WHITE_CHOCOLATE_DONUT.get());
        basicItem(ModItems.RUBY_CHOCOLATE_DONUT.get());

        basicItem(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get());
        basicItem(ModItems.BLUEBERRY_TOPPED_WHITE_CHOCOLATE_DONUT.get());
        basicItem(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get());

        basicItem(ModItems.CHOCOLATE_HONEY_DONUT.get());
        basicItem(ModItems.CHOCOLATE_STRAWBERRY_DONUT.get());
        basicItem(ModItems.WHITE_CHOCOLATE_HONEY_DONUT.get());
        basicItem(ModItems.WHITE_CHOCOLATE_PEAR_DONUT.get());
        basicItem(ModItems.WHITE_CHOCOLATE_RUBY_DONUT.get());

        basicItem(ModItems.EMPTY_SPRINKLES_BOTTLE.get());
        basicItem(ModItems.BOTTLED_RAINBOW_SPRINKLES.get());
        basicItem(ModItems.BOTTLED_WHITE_SPRINKLES.get());
        basicItem(ModItems.BOTTLED_GREEN_SPRINKLES.get());

    }
}
