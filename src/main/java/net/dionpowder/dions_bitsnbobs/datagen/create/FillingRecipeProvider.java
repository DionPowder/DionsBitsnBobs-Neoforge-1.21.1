package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.FillingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class FillingRecipeProvider extends FillingRecipeGen {
    public FillingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    STAWBERRY_DONUT = create("strawberry_donut", b -> b
            .require(ModItems.DONUT)
            .require(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), 100)
            .output(ModItems.STRAWBERRY_DONUT)),

    ORANGE_DONUT = create("orange_donut", b -> b
            .require(ModItems.DONUT)
            .require(ModFluids.SOURCE_ORANGE_FROSTING.get(), 100)
            .output(ModItems.ORANGE_DONUT)),

    BLUEBERRY_DONUT = create("blueberry_donut", b -> b
            .require(ModItems.DONUT)
            .require(ModFluids.SOURCE_BLUEBERRY_FROSTING.get(), 100)
            .output(ModItems.BLUEBERRY_DONUT)),

    PEAR_DONUT = create("pear_donut", b -> b
            .require(ModItems.DONUT)
            .require(ModFluids.SOURCE_PEAR_FROSTING.get(), 100)
            .output(ModItems.PEAR_DONUT)),

    CHOCOLATE_DONUT = create("chocolate_donut", b -> b
            .require(ModItems.DONUT)
            .require(AllFluids.CHOCOLATE.get(), 100)
            .output(ModItems.CHOCOLATE_DONUT)),

    CHOCOLATE_STRAWBERRY_DONUT = create("chocolate_strawberry_donut", b -> b
            .require(ModItems.CHOCOLATE_DONUT)
            .require(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), 100)
            .output(ModItems.CHOCOLATE_STRAWBERRY_DONUT)),

    CHOCOLATE_HONEY_DONUT = create("chocolate_honey_donut", b -> b
            .require(ModItems.CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(ModItems.CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_HONEY_DONUT = create("white_chocolate_honey_donut", b -> b
            .require(ModItems.WHITE_CHOCOLATE_DONUT)
            .require(AllFluids.HONEY.get(), 100)
            .output(ModItems.WHITE_CHOCOLATE_HONEY_DONUT)),

    WHITE_CHOCOLATE_PEAR_DONUT = create("white_chocolate_pear_donut", b -> b
            .require(ModItems.WHITE_CHOCOLATE_DONUT)
            .require(ModFluids.SOURCE_PEAR_FROSTING.get(), 100)
            .output(ModItems.WHITE_CHOCOLATE_PEAR_DONUT)),

    FILLED_DONUT_CAST = create("filled_donut_cast", b -> b
            .require(ModBlocks.DONUT_CAST)
            .require(ModFluids.SOURCE_DONUT_BATTER.get(), 250)
            .output(ModBlocks.FILLED_DONUT_CAST))

    ;
}
