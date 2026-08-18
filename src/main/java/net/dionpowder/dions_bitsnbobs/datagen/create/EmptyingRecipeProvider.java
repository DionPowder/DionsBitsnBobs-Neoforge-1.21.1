package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.EmptyingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class EmptyingRecipeProvider extends EmptyingRecipeGen {
    public EmptyingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    DONUT_BATTER = create("donut_batter", b -> b
            .require(DBBBlocks.FILLED_DONUT_CAST)
            .output(DBBBlocks.DONUT_CAST)
            .output(DBBFluids.DONUT_BATTER.get(), 250))

    ;

}
