package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
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
            .require(DionsBitsnBobsItems.DONUT)
            .require(Items.SUGAR)
            .output(DionsBitsnBobsItems.SUGAR_DONUT)),

    SPRINKLED_PEAR_DONUT = create("sprinkled_pear_donut", b -> b
            .require(DionsBitsnBobsItems.PEAR_DONUT)
            .require(DionsBitsnBobsItems.BOTTLED_WHITE_SPRINKLES)
            .output(DionsBitsnBobsItems.SPRINKLED_PEAR_DONUT)),

    SPRINKLED_STRAWBERRY_DONUT = create("sprinkled_strawberry_donut", b -> b
            .require(DionsBitsnBobsItems.STRAWBERRY_DONUT)
            .require(DionsBitsnBobsItems.BOTTLED_GREEN_SPRINKLES)
            .output(DionsBitsnBobsItems.SPRINKLED_STRAWBERRY_DONUT)),

    SPRINKLED_ORANGE_DONUT = create("sprinkled_orange_donut", b -> b
            .require(DionsBitsnBobsItems.ORANGE_DONUT)
            .require(DionsBitsnBobsItems.BOTTLED_WHITE_SPRINKLES)
            .output(DionsBitsnBobsItems.SPRINKLED_ORANGE_DONUT)),

    SPRINKLED_WHITE_CHOCOLATE_DONUT = create("sprinkled_white_chocolate_donut", b -> b
            .require(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT)
            .require(DionsBitsnBobsItems.BOTTLED_RAINBOW_SPRINKLES)
            .output(DionsBitsnBobsItems.SPRINKLED_WHITE_CHOCOLATE_DONUT)),

    STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT = create("strawberry_topped_dark_chocolate_donut", b -> b
            .require(DionsBitsnBobsItems.DARK_CHOCOLATE_DONUT)
            .require(DionsBitsnBobsItems.STRAWBERRY)
            .output(DionsBitsnBobsItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT))

    ;

}
