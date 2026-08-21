package net.dionpowder.dions_bitsnbobs.datagen.recipes;

import com.simibubi.create.api.data.recipe.PressingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class PressingRecipeProvider extends PressingRecipeGen {
    public PressingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    DONUT = create("donut", b -> b
            .require(DBBBlocks.COOKED_DONUT_CAST)
            .output(DBBBlocks.DONUT_CAST)
            .output(DBBItems.DONUT))

    ;
}
