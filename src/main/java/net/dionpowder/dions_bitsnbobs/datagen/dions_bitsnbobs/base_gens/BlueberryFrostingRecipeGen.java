package net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.base_gens;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.recipe.fan.BlueberryFrostingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class BlueberryFrostingRecipeGen extends StandardProcessingRecipeGen<BlueberryFrostingRecipe> {

    public BlueberryFrostingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    @Override
    protected ModRecipeTypes getRecipeType() {
        return ModRecipeTypes.BLUEBERRY_FROSTING;
    }

}