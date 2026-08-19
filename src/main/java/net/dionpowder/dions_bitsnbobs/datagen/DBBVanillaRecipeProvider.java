package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class DBBVanillaRecipeProvider extends net.minecraft.data.recipes.RecipeProvider implements IConditionBuilder {

    public DBBVanillaRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // shaped crafting
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DBBBlocks.STRAWBERRY_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', DBBItems.STRAWBERRY.get())
                .unlockedBy("has_strawberry", has(DBBItems.STRAWBERRY))
                //.save(recipeOutput, "dions_bitsnbobs:strawberry_crate");
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL)
                .pattern("CC")
                .pattern("CC")
                .define('C', Items.CHARCOAL)
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DBBBlocks.DONUT_CAST)
                .pattern("   ")
                .pattern("B B")
                .pattern("BBB")
                .define('B', Items.BRICK)
                .unlockedBy("has_brick", has(Items.BRICK))
                .save(recipeOutput);

        // shapeless crafting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DBBItems.STRAWBERRY.get(), 9)
                .requires(DBBBlocks.STRAWBERRY_CRATE)
                .unlockedBy("has_strawberry_crate", has(DBBBlocks.STRAWBERRY_CRATE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DBBItems.EMPTY_SPRINKLES_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.IRON_NUGGET)
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DBBItems.BOTTLED_RAINBOW_SPRINKLES, 3)
                .requires(DBBItems.EMPTY_SPRINKLES_BOTTLE)
                .requires(Items.SUGAR)
                .requires(Items.RED_DYE)
                .requires(Items.LIME_DYE)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_empty_spinkles_bottle", has(DBBItems.EMPTY_SPRINKLES_BOTTLE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DBBItems.BOTTLED_WHITE_SPRINKLES, 3)
                .requires(DBBItems.EMPTY_SPRINKLES_BOTTLE)
                .requires(Items.SUGAR)
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_empty_spinkles_bottle", has(DBBItems.EMPTY_SPRINKLES_BOTTLE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DBBItems.BOTTLED_GREEN_SPRINKLES, 3)
                .requires(DBBItems.EMPTY_SPRINKLES_BOTTLE)
                .requires(Items.SUGAR)
                .requires(Items.GREEN_DYE)
                .unlockedBy("has_empty_spinkles_bottle", has(DBBItems.EMPTY_SPRINKLES_BOTTLE))
                .save(recipeOutput);

        // furnace
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DBBItems.UNCOOKED_DONUT), RecipeCategory.FOOD, DBBItems.DONUT, 0.35f, 200)
                .unlockedBy("has_uncooked_donut", has(DBBItems.UNCOOKED_DONUT))
                .save(recipeOutput, "donut_smelting");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(DBBBlocks.FILLED_DONUT_CAST), RecipeCategory.FOOD, DBBBlocks.COOKED_DONUT_CAST, 0.35f, 200)
                .unlockedBy("has_filled_donut_cast", has(DBBBlocks.FILLED_DONUT_CAST))
                .save(recipeOutput, "filled_donut_cast_smelting");

        // campfire cooking
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(DBBItems.UNCOOKED_DONUT), RecipeCategory.FOOD, DBBItems.DONUT, 0.0f, 200)
                .unlockedBy("has_uncooked_donut", has(DBBItems.UNCOOKED_DONUT))
                .save(recipeOutput, "donut_campfire");

        // smoking
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DBBItems.UNCOOKED_DONUT), RecipeCategory.FOOD, DBBItems.DONUT, 0.35f, 100)
                .unlockedBy("has_uncooked_donut", has(DBBItems.UNCOOKED_DONUT))
                .save(recipeOutput, "donut_smoking");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(DBBBlocks.FILLED_DONUT_CAST), RecipeCategory.FOOD, DBBBlocks.COOKED_DONUT_CAST, 0.35f, 100)
                .unlockedBy("has_filled_donut_cast", has(DBBBlocks.FILLED_DONUT_CAST))
                .save(recipeOutput, "filled_donut_cast_smoking");

        // stone cutting (andesite component)
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ADJUSTABLE_CHAIN_GEARSHIFT, 4)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_BEARING, 4)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.CHUTE, 16)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.CLUTCH, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.GEARSHIFT, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.DEPOT, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ENCASED_CHAIN_DRIVE, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ANDESITE_FUNNEL, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.GEARBOX, 8)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.PORTABLE_STORAGE_INTERFACE, 4)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.SHAFT, 32)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ANDESITE_TUNNEL, 4)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ITEM_VAULT, 6)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.WEIGHTED_EJECTOR, 4)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_PRESS, 2)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_MIXER, 2)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.ENCASED_FAN, 2)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.ANDESITE_COMPONENT), RecipeCategory.MISC, AllBlocks.DEPLOYER, 2)
                .unlockedBy("has_andesite_component", has(DBBBlocks.ANDESITE_COMPONENT))
                .save(recipeOutput);

        // stone cutting (brass component)
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_ARM, 1)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.CLOCKWORK_BEARING, 4)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.SMART_OBSERVER, 2)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.THRESHOLD_SWITCH, 2)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_CRAFTER, 2)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.BRASS_FUNNEL, 4)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.BRASS_TUNNEL, 2)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.ROTATION_SPEED_CONTROLLER, 1)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.SEQUENCED_GEARSHIFT, 4)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.BRASS_COMPONENT), RecipeCategory.MISC, AllBlocks.SMART_CHUTE, 4)
                .unlockedBy("has_brass_component", has(DBBBlocks.BRASS_COMPONENT))
                .save(recipeOutput);

        // stone cutting (copper component)
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_TANK, 6)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_PIPE, 16)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.MECHANICAL_PUMP, 6)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.SMART_FLUID_PIPE, 4)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.FLUID_VALVE, 6)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.COPPER_VALVE_HANDLE, 4)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.HOSE_PULLEY, 2)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.ITEM_DRAIN, 4)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.PORTABLE_FLUID_INTERFACE, 4)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.STEAM_ENGINE, 2)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.COPPER_COMPONENT), RecipeCategory.MISC, AllBlocks.STEAM_WHISTLE, 8)
                .unlockedBy("has_copper_component", has(DBBBlocks.COPPER_COMPONENT))
                .save(recipeOutput);

        // stone cutting (train component)
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRAIN_CONTROLS, 2)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllItems.SCHEDULE, 8)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK, 32)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_STATION, 4)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_SIGNAL, 8)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DBBBlocks.TRAIN_COMPONENT), RecipeCategory.MISC, AllBlocks.TRACK_OBSERVER, 6)
                .unlockedBy("has_train_component", has(DBBBlocks.TRAIN_COMPONENT))
                .save(recipeOutput);

    }
}
