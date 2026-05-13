package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class PressingRecipeProvider extends PressingRecipeGen {
    public PressingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    CHORUS_DONUT_TO_STRAWBERRY = create("chorus_donut_to_strawberry", b -> b
        .require(ModItems.CHORUS_JAM_DONUT)
        .output(ModItems.STRAWBERRY))

    ;
}
