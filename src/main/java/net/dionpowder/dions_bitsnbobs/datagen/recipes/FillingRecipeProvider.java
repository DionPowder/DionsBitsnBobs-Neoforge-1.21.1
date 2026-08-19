package net.dionpowder.dions_bitsnbobs.datagen.recipes;

import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class FillingRecipeProvider extends FillingRecipeGen {
    public FillingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    STAWBERRY_DONUT = create("strawberry_donut", b -> b
            .require(DBBItems.DONUT)
            .require(DBBFluids.STRAWBERRY_FROSTING.get(), 100)
            .output(DBBItems.STRAWBERRY_DONUT)),

    ORANGE_DONUT = create("orange_donut", b -> b
            .require(DBBItems.DONUT)
            .require(DBBFluids.ORANGE_FROSTING.get(), 100)
            .output(DBBItems.ORANGE_DONUT)),

    BLUEBERRY_DONUT = create("blueberry_donut", b -> b
            .require(DBBItems.DONUT)
            .require(DBBFluids.BLUEBERRY_FROSTING.get(), 100)
            .output(DBBItems.BLUEBERRY_DONUT)),

    PEAR_DONUT = create("pear_donut", b -> b
            .require(DBBItems.DONUT)
            .require(DBBFluids.PEAR_FROSTING.get(), 100)
            .output(DBBItems.PEAR_DONUT)),

    CHOCOLATE_DONUT = create("chocolate_donut", b -> b
            .require(DBBItems.DONUT)
            .require(AllFluids.CHOCOLATE.get(), 100)
            .output(DBBItems.CHOCOLATE_DONUT)),

    CHOCOLATE_STRAWBERRY_DONUT = create("chocolate_strawberry_donut", b -> b
            .require(DBBItems.CHOCOLATE_DONUT)
            .require(DBBFluids.STRAWBERRY_FROSTING.get(), 100)
            .output(DBBItems.CHOCOLATE_STRAWBERRY_DONUT)),

    CHOCOLATE_HONEY_DONUT = create("chocolate_honey_donut", b -> b
            .require(DBBItems.CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(DBBItems.CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_HONEY_DONUT = create("white_chocolate_honey_donut", b -> b
            .require(DBBItems.WHITE_CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(DBBItems.WHITE_CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_PEAR_DONUT = create("white_chocolate_pear_donut", b -> b
            .require(DBBItems.WHITE_CHOCOLATE_DONUT)
            .require(DBBFluids.PEAR_FROSTING.get(), 100)
            .output(DBBItems.WHITE_CHOCOLATE_PEAR_DONUT)),

    FILLED_DONUT_CAST = create("filled_donut_cast", b -> b
            .require(DBBBlocks.DONUT_CAST)
            .require(DBBFluids.DONUT_BATTER.get(), 250)
            .output(DBBBlocks.FILLED_DONUT_CAST))

    ;
}
