package net.dionpowder.dions_bitsnbobs.data.recipe;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.compat.ModCompat;
import net.dionpowder.dions_bitsnbobs.config.DBBConfig;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklingRecipe;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DBBRuntimeRecipeProvider {
    
    private static <R extends StandardProcessingRecipe<?>> R buildDerived(StandardProcessingRecipe.Builder<R> builder, List<Ingredient> ingredients, List<ProcessingOutput> outputs, int duration) {
        for (Ingredient ingredient : ingredients)
            builder.require(ingredient);
        for (ProcessingOutput output : outputs)
            builder.output(output.getChance(), output.getStack());
        builder.duration(duration);
        return builder.build();
    }

    public static void rebuild(RecipeManager manager) {
        List<RecipeHolder<?>> allRecipes = new ArrayList<>(manager.getRecipes());
        Collection<RecipeHolder<FillingRecipe>> fillingRecipes = manager.getAllRecipesFor(AllRecipeTypes.FILLING.getType());

        // dions bits n bobs generated recipes
        for (RecipeHolder<FillingRecipe> holder : fillingRecipes) {
            FillingRecipe recipe = holder.value();
            ResourceLocation sourceId = holder.id();
            FluidIngredient fluidIngredient = recipe.getRequiredFluid().ingredient();

            if (fluidIngredient.test(new FluidStack(DBBFluids.STRAWBERRY_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/strawberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(StrawberryFrostingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
            else if (fluidIngredient.test(new FluidStack(DBBFluids.ORANGE_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/orange_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(OrangeFrostingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
            else if (fluidIngredient.test(new FluidStack(DBBFluids.BLUEBERRY_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/blueberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(BlueberryFrostingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
            else if (fluidIngredient.test(new FluidStack(DBBFluids.PEAR_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/pear_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(PearFrostingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
            else if (fluidIngredient.test(new FluidStack(DBBFluids.CRANBERRY_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/cranberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(CranberryFrostingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
            else if (fluidIngredient.test(new FluidStack(AllFluids.CHOCOLATE.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(ChocolateGlazingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }

        }

        // create confectionery generated recipes
        if (ModCompat.CREATE_CONFECTIONERY.enabled()
            && BuiltInRegistries.FLUID.containsKey(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"))
            && BuiltInRegistries.FLUID.containsKey(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"))
            && BuiltInRegistries.FLUID.containsKey(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"))
            && BuiltInRegistries.FLUID.containsKey(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate")))
        {

            Fluid darkChocolate = BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
            Fluid whiteChocolate = BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
            Fluid caramel = BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
            Fluid rubyChocolate = BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));

            for (RecipeHolder<FillingRecipe> holder : fillingRecipes) {
                FillingRecipe recipe = holder.value();
                ResourceLocation sourceId = holder.id();
                FluidIngredient fluidIngredient = recipe.getRequiredFluid().ingredient();

                if (fluidIngredient.test(new FluidStack(darkChocolate, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/dark_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    allRecipes.add(new RecipeHolder<>(newId, buildDerived(DarkChocolateGlazingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
                }
                else if (fluidIngredient.test(new FluidStack(whiteChocolate, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/white_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    allRecipes.add(new RecipeHolder<>(newId, buildDerived(WhiteChocolateGlazingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
                }
                else if (fluidIngredient.test(new FluidStack(caramel, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/caramel_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    allRecipes.add(new RecipeHolder<>(newId, buildDerived(CaramelChocolateGlazingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
                }
                else if (fluidIngredient.test(new FluidStack(rubyChocolate, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/ruby_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    allRecipes.add(new RecipeHolder<>(newId, buildDerived(RubyChocolateGlazingRecipe.builder(newId), recipe.getIngredients(), recipe.getRollableResults(), recipe.getProcessingDuration())));
                }

            }
        }
        
        // generate recipes for food sprinkling from other mods
        if (DBBConfig.common().commonRecipes.GENERATE_FOOD_SPRINKLING_RECIPES.get()) {
            Collection<RecipeHolder<DeployerApplicationRecipe>> deployingRecipes = manager.getAllRecipesFor(AllRecipeTypes.DEPLOYING.getType());
            for (RecipeHolder<DeployerApplicationRecipe> holder : deployingRecipes) {
                ResourceLocation sourceId = holder.id();
                if (sourceId.getNamespace().equals(DBB.MOD_ID))
                    continue;
                
                DeployerApplicationRecipe recipe = holder.value();
                Ingredient processedItem = recipe.getProcessedItem();
                Ingredient heldItem = recipe.getRequiredHeldItem();
                
                if (!isFoodIngredient(processedItem) || !isFoodIngredient(heldItem))
                    continue;
                
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/food_sprinkling/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                allRecipes.add(new RecipeHolder<>(newId, buildDerived(FoodSprinklingRecipe.builder(newId), List.of(processedItem, heldItem), recipe.getRollableResults(), recipe.getProcessingDuration())));
            }
        }

        // config recipes
        if (DBBConfig.commonRecipes().DIAMOND_AUTOMATION.get()) {
            ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/compacting/diamond");
            var builder = new StandardProcessingRecipe.Builder<>(CompactingRecipe::new, newId);
            builder.require(Blocks.COAL_BLOCK);
            builder.require(Fluids.LAVA, 250);
            builder.output(Items.DIAMOND);
            allRecipes.add(new RecipeHolder<>(newId, builder.build()));
        }

        if (DBBConfig.commonRecipes().RENEWABLE_CREATE_STONES_TYPES.get()) {
            // asurine
            ResourceLocation newAsurineId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/mixing/asurine");
            var asurineBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newAsurineId);
            asurineBuilder.require(AllPaletteStoneTypes.ASURINE.getBaseBlock().get());
            asurineBuilder.require(Items.BASALT);
            asurineBuilder.requiresHeat(HeatCondition.HEATED);
            asurineBuilder.output(AllPaletteStoneTypes.ASURINE.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newAsurineId, asurineBuilder.build()));
            // crimsite
            ResourceLocation newCrimsiteId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/mixing/crimsite");
            var crimsiteBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newCrimsiteId);
            crimsiteBuilder.require(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get());
            crimsiteBuilder.require(Items.BLACKSTONE);
            crimsiteBuilder.requiresHeat(HeatCondition.HEATED);
            crimsiteBuilder.output(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newCrimsiteId, crimsiteBuilder.build()));
            // ochrum
            ResourceLocation newOchrumId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/mixing/ochrum");
            var ochrumBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newOchrumId);
            ochrumBuilder.require(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get());
            ochrumBuilder.require(Items.SANDSTONE);
            ochrumBuilder.requiresHeat(HeatCondition.HEATED);
            ochrumBuilder.output(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newOchrumId, ochrumBuilder.build()));
            // veridium
            ResourceLocation newVeridiumId = ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, "generated/mixing/veridium");
            var veridiumBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newVeridiumId);
            veridiumBuilder.require(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get());
            veridiumBuilder.require(Items.MOSSY_COBBLESTONE);
            veridiumBuilder.requiresHeat(HeatCondition.HEATED);
            veridiumBuilder.output(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newVeridiumId, veridiumBuilder.build()));
        }

        manager.replaceRecipes(allRecipes);
    }

    private static boolean isFoodIngredient(Ingredient ingredient) {
        ItemStack[] items = ingredient.getItems();
        if (items.length == 0)
            return false;

        for (ItemStack stack : items) {
            if (!stack.has(DataComponents.FOOD))
                return false;
        }

        return true;
    }
}