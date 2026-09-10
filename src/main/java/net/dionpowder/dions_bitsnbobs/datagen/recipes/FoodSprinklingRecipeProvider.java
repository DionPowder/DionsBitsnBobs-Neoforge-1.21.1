package net.dionpowder.dions_bitsnbobs.datagen.recipes;

import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.datagen.base_gens.FoodSprinklingRecipeGen;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class FoodSprinklingRecipeProvider extends FoodSprinklingRecipeGen {
    public FoodSprinklingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    GeneratedRecipe
    
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
    
    SPRINKLED_CRANBERRY_DONUT = create("sprinkled_cranberry_donut", b -> b
            .require(DBBItems.CRANBERRY_DONUT)
            .require(DBBItems.BOTTLED_GREEN_SPRINKLES)
            .output(DBBItems.SPRINKLED_CRANBERRY_DONUT)),
    
    SPRINKLED_WHITE_CHOCOLATE_DONUT = create("sprinkled_white_chocolate_donut", b -> b
            .require(DBBItems.WHITE_CHOCOLATE_DONUT)
            .require(DBBItems.BOTTLED_RAINBOW_SPRINKLES)
            .output(DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT)),
    
    STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = create("strawberry_topped_dark_chocolate_donut", b -> b
            .require(DBBItems.DARK_CHOCOLATE_DONUT)
            .require(DBBTags.Items.FOODS_STRAWBERRY)
            .output(DBBItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT))

    ;
}
