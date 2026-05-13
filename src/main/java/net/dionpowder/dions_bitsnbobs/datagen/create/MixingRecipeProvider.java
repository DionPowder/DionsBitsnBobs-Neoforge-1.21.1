package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class MixingRecipeProvider extends MixingRecipeGen {
    public MixingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    //GeneratedRecipe
}
