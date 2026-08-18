package net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.base_gens;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.BlueberryFrostingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class BlueberryFrostingRecipeGen extends StandardProcessingRecipeGen<BlueberryFrostingRecipe> {

    public BlueberryFrostingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    @Override
    protected DBBRecipeTypes getRecipeType() {
        return DBBRecipeTypes.BLUEBERRY_FROSTING;
    }

}