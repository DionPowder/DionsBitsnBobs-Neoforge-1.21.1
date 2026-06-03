package net.dionpowder.dions_bitsnbobs.recipe;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;

import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.fan.BlueberryFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.OrangeFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.PearFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.StrawberryFrostingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BulkFrostingRecipes {


    public static void rebuild(RecipeManager manager) {
        List<RecipeHolder<?>> allRecipes = new ArrayList<>(manager.getRecipes());
        Collection<RecipeHolder<FillingRecipe>> fillingRecipes = manager.getAllRecipesFor(AllRecipeTypes.FILLING.getType());

        for (RecipeHolder<FillingRecipe> holder : fillingRecipes) {
            FillingRecipe recipe = holder.value();
            ResourceLocation sourceId = holder.id();
            FluidIngredient fluidIngredient = recipe.getRequiredFluid().ingredient();

            if (fluidIngredient.test(new FluidStack(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/strawberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                StrawberryFrostingRecipe newStrawberryFrostingRecipe = buildStrawberryDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newStrawberryFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(ModFluids.SOURCE_ORANGE_FROSTING.get(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/orange_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                OrangeFrostingRecipe newOrangeFrostingRecipe = buildOrangeDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newOrangeFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(ModFluids.SOURCE_BLUEBERRY_FROSTING.get(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/blueberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                BlueberryFrostingRecipe newBlueberryFrostingRecipe = buildBlueberryDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newBlueberryFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(ModFluids.SOURCE_PEAR_FROSTING.get(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/pear_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                PearFrostingRecipe newPearFrostingRecipe = buildPearDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newPearFrostingRecipe));
            }
        }

        manager.replaceRecipes(allRecipes);
    }

    // strawberry
    private static StrawberryFrostingRecipe buildStrawberryDerived(ResourceLocation id, FillingRecipe source) {
        var builder = StrawberryFrostingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // orange
    private static OrangeFrostingRecipe buildOrangeDerived(ResourceLocation id, FillingRecipe source) {
        var builder = OrangeFrostingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // blueberry
    private static BlueberryFrostingRecipe buildBlueberryDerived(ResourceLocation id, FillingRecipe source) {
        var builder = BlueberryFrostingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // pear
    private static PearFrostingRecipe buildPearDerived(ResourceLocation id, FillingRecipe source) {
        var builder = PearFrostingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

}