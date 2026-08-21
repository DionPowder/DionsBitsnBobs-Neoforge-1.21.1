package net.dionpowder.dions_bitsnbobs.datagen.recipes;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.WashingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class WashingRecipeProvider extends WashingRecipeGen {
    public WashingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    MOSS_BLOCK = create("moss_block", b -> b
            .require(Ingredient.of(ItemTags.LOGS))
            .output(Items.MOSS_BLOCK)),

    INK_SAC = create("inc_sac", b -> b
            .require(Items.COAL)
            .output(0.8f, Items.INK_SAC)
            .output(0.3f, Items.INK_SAC)),

    REDSTONE = create("redstone", b -> b
            .require(AllItems.CINDER_FLOUR)
            .output(0.6f, Items.REDSTONE))

    ;

}
