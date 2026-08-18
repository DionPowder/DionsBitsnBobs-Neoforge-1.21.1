package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.DionsBitsnBobsBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class FillingRecipeProvider extends FillingRecipeGen {
    public FillingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    STAWBERRY_DONUT = create("strawberry_donut", b -> b
            .require(DionsBitsnBobsItems.DONUT)
            .require(DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.STRAWBERRY_DONUT)),

    ORANGE_DONUT = create("orange_donut", b -> b
            .require(DionsBitsnBobsItems.DONUT)
            .require(DionsBitsnBobsFluids.ORANGE_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.ORANGE_DONUT)),

    BLUEBERRY_DONUT = create("blueberry_donut", b -> b
            .require(DionsBitsnBobsItems.DONUT)
            .require(DionsBitsnBobsFluids.BLUEBERRY_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.BLUEBERRY_DONUT)),

    PEAR_DONUT = create("pear_donut", b -> b
            .require(DionsBitsnBobsItems.DONUT)
            .require(DionsBitsnBobsFluids.PEAR_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.PEAR_DONUT)),

    CHOCOLATE_DONUT = create("chocolate_donut", b -> b
            .require(DionsBitsnBobsItems.DONUT)
            .require(AllFluids.CHOCOLATE.get(), 100)
            .output(DionsBitsnBobsItems.CHOCOLATE_DONUT)),

    CHOCOLATE_STRAWBERRY_DONUT = create("chocolate_strawberry_donut", b -> b
            .require(DionsBitsnBobsItems.CHOCOLATE_DONUT)
            .require(DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.CHOCOLATE_STRAWBERRY_DONUT)),

    CHOCOLATE_HONEY_DONUT = create("chocolate_honey_donut", b -> b
            .require(DionsBitsnBobsItems.CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(DionsBitsnBobsItems.CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_HONEY_DONUT = create("white_chocolate_honey_donut", b -> b
            .require(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(DionsBitsnBobsItems.WHITE_CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_PEAR_DONUT = create("white_chocolate_pear_donut", b -> b
            .require(DionsBitsnBobsItems.WHITE_CHOCOLATE_DONUT)
            .require(DionsBitsnBobsFluids.PEAR_FROSTING.get(), 100)
            .output(DionsBitsnBobsItems.WHITE_CHOCOLATE_PEAR_DONUT)),

    FILLED_DONUT_CAST = create("filled_donut_cast", b -> b
            .require(DionsBitsnBobsBlocks.DONUT_CAST)
            .require(DionsBitsnBobsFluids.DONUT_BATTER.get(), 250)
            .output(DionsBitsnBobsBlocks.FILLED_DONUT_CAST))

    ;
}
