package net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.base_gens;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.PearFrostingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class PearFrostingRecipeGen extends StandardProcessingRecipeGen<PearFrostingRecipe> {

    public PearFrostingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    @Override
    protected ModRecipeTypes getRecipeType() {
        return ModRecipeTypes.PEAR_FROSTING;
    }

}