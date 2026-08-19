package net.dionpowder.dions_bitsnbobs.datagen.recipes;

import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class DeployingRecipeProvider extends DeployingRecipeGen {
    public DeployingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    COBBLED_DEEPSLATE = create("cobbled_deepslate", b -> b
            .require(Items.DEEPSLATE)
            .require(ItemTags.PICKAXES)
            .toolNotConsumed()
            .output(Items.COBBLED_DEEPSLATE)),

    SUGAR_DONUT = create("sugar_donut", b -> b
            .require(DBBItems.DONUT)
            .require(Items.SUGAR)
            .output(DBBItems.SUGAR_DONUT)),

    SPRINKLED_PEAR_DONUT = create("sprinkled_pear_donut", b -> b
            .require(DBBItems.PEAR_DONUT)
            .require(DBBItems.BOTTLED_WHITE_SPRINKLES)
            .output(DBBItems.SPRINKLED_PEAR_DONUT)),

    SPRINKLED_STRAWBERRY_DONUT = create("sprinkled_strawberry_donut", b -> b
            .require(DBBItems.STRAWBERRY_DONUT)
            .require(DBBItems.BOTTLED_GREEN_SPRINKLES)
            .output(DBBItems.SPRINKLED_STRAWBERRY_DONUT)),

    SPRINKLED_ORANGE_DONUT = create("sprinkled_orange_donut", b -> b
            .require(DBBItems.ORANGE_DONUT)
            .require(DBBItems.BOTTLED_WHITE_SPRINKLES)
            .output(DBBItems.SPRINKLED_ORANGE_DONUT)),

    SPRINKLED_WHITE_CHOCOLATE_DONUT = create("sprinkled_white_chocolate_donut", b -> b
            .require(DBBItems.WHITE_CHOCOLATE_DONUT)
            .require(DBBItems.BOTTLED_RAINBOW_SPRINKLES)
            .output(DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT)),

    STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = create("strawberry_topped_dark_chocolate_donut", b -> b
            .require(DBBItems.DARK_CHOCOLATE_DONUT)
            .require(DBBItems.STRAWBERRY)
            .output(DBBItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT))

    ;

}
