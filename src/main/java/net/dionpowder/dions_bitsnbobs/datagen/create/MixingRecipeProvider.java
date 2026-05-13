package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class MixingRecipeProvider extends MixingRecipeGen {
    public MixingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    NETHERITE_DUST = create("netherite_dust", b -> b
            .require(AllItems.CINDER_FLOUR)
            .require(AllItems.POWDERED_OBSIDIAN)
            .requiresHeat(HeatCondition.SUPERHEATED)
            .output(ModItems.NETHERITE_DUST))

    ;

}
