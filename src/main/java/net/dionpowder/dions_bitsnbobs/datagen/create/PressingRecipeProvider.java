package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllItems;
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

    UNCOOKED_DONUT = create("uncooked_donut", b -> b
        .require(AllItems.DOUGH)
        .output(ModItems.UNCOOKED_DONUT))

    ;
}
