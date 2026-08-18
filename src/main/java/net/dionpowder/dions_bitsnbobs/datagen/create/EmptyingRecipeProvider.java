package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.EmptyingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.DionsBitsnBobsBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class EmptyingRecipeProvider extends EmptyingRecipeGen {
    public EmptyingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    DONUT_BATTER = create("donut_batter", b -> b
            .require(DionsBitsnBobsBlocks.FILLED_DONUT_CAST)
            .output(DionsBitsnBobsBlocks.DONUT_CAST)
            .output(DionsBitsnBobsFluids.DONUT_BATTER.get(), 250))

    ;

}
