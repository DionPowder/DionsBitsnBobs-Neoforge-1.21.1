package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class PressingRecipeProvider extends PressingRecipeGen {
    public PressingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    DONUT = create("donut", b -> b
            .require(ModBlocks.COOKED_DONUT_CAST)
            .output(ModBlocks.DONUT_CAST)
            .output(ModItems.DONUT))

    ;
}
