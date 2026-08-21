package net.dionpowder.dions_bitsnbobs.datagen.base_gens;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.CranberryFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.StrawberryFrostingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class CranberryFrostingRecipeGen extends StandardProcessingRecipeGen<CranberryFrostingRecipe> {

    public CranberryFrostingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    @Override
    protected DBBRecipeTypes getRecipeType() {
        return DBBRecipeTypes.CRANBERRY_FROSTING;
    }

}