package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class DeployingRecipeProvider extends DeployingRecipeGen {
    public DeployingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    COBBLED_DEEPSLATE = create("cobbled_deepslate", b -> b
            .require(Items.DEEPSLATE)
            .require(ItemTags.PICKAXES)
            .toolNotConsumed()
            .output(Items.COBBLED_DEEPSLATE)),

    SUGAR_DONUT = create("sugar_donut", b -> b
            .require(ModItems.DONUT)
            .require(Items.SUGAR)
            .output(ModItems.SUGAR_DONUT)),

    SPRINKLED_PEAR_DONUT = create("sprinkled_pear_donut", b -> b
            .require(ModItems.PEAR_DONUT)
            .require(ModItems.BOTTLED_WHITE_SPRINKLES)
            .output(ModItems.SPRINKLED_PEAR_DONUT)),

    SPRINKLED_STRAWBERRY_DONUT = create("sprinkled_strawberry_donut", b -> b
            .require(ModItems.STRAWBERRY_DONUT)
            .require(ModItems.BOTTLED_GREEN_SPRINKLES)
            .output(ModItems.SPRINKLED_STRAWBERRY_DONUT)),

    SPRINKLED_ORANGE_DONUT = create("sprinkled_orange_donut", b -> b
            .require(ModItems.ORANGE_DONUT)
            .require(ModItems.BOTTLED_WHITE_SPRINKLES)
            .output(ModItems.SPRINKLED_ORANGE_DONUT)),

    SPRINKLED_WHITE_CHOCOLATE_DONUT = create("sprinkled_white_chocolate_donut", b -> b
            .require(ModItems.WHITE_CHOCOLATE_DONUT)
            .require(ModItems.BOTTLED_RAINBOW_SPRINKLES)
            .output(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT)),

    STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = create("strawberry_topped_dark_chocolate_donut", b -> b
            .require(ModItems.DARK_CHOCOLATE_DONUT)
            .require(ModItems.STRAWBERRY)
            .output(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT))

    ;

}
