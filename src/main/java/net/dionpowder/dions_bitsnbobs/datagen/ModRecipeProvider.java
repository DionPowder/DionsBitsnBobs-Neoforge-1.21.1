package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRAWBERRY_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STRAWBERRY.get())
                .unlockedBy("has_strawberry", has(ModItems.STRAWBERRY))
                .save(recipeOutput, "dions_bitsnbobs:strawberry_crate_craft");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRAWBERRY.get(), 9)
                .requires(ModBlocks.STRAWBERRY_CRATE)
                .unlockedBy("has_strawberry_crate", has(ModBlocks.STRAWBERRY_CRATE))
                .save(recipeOutput, "dions_bitsnbobs:strawberry_craft");
    }
}
