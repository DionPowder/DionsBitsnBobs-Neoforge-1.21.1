package net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.base_gens;

import com.simibubi.create.api.data.recipe.StandardProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.OrangeFrostingRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class OrangeFrostingRecipeGen extends StandardProcessingRecipeGen<OrangeFrostingRecipe> {

    public OrangeFrostingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    @Override
    protected ModRecipeTypes getRecipeType() {
        return ModRecipeTypes.ORANGE_FROSTING;
    }

}