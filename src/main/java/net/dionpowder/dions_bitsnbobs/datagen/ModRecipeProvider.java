package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // shaped crafting
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRAWBERRY_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STRAWBERRY.get())
                .unlockedBy("has_strawberry", has(ModItems.STRAWBERRY))
                //.save(recipeOutput, "dions_bitsnbobs:strawberry_crate");
                .save(recipeOutput);

        // shapeless crafting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRAWBERRY.get(), 9)
                .requires(ModBlocks.STRAWBERRY_CRATE)
                .unlockedBy("has_strawberry_crate", has(ModBlocks.STRAWBERRY_CRATE))
                .save(recipeOutput);

        // smoking
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.UNCOOKED_DONUT), RecipeCategory.FOOD, ModItems.DONUT, 0.35f, 100)
                .unlockedBy("has_uncooked_donut", has(ModItems.UNCOOKED_DONUT))
                .save(recipeOutput);

        // stone cutting
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_TANK, 6)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_PIPE, 16)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_PUMP, 6)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.SMART_FLUID_PIPE, 4)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_VALVE, 6)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.COPPER_VALVE_HANDLE, 4)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.HOSE_PULLEY, 2)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.ITEM_DRAIN, 4)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.PORTABLE_FLUID_INTERFACE, 4)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.STEAM_ENGINE, 2)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.STEAM_WHISTLE, 8)
                .unlockedBy("has_copper_component", has(ModBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRAIN_CONTROLS, 4)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllItems.SCHEDULE, 10)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK, 32)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_STATION, 4)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_SIGNAL, 8)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_OBSERVER, 6)
                .unlockedBy("has_train_component", has(ModBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

    }
}
