package net.dionpowder.dions_bitsnbobs.content.recipe;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;

import com.simibubi.create.content.kinetics.mixer.CompactingRecipe;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.compat.ModCompat;
import net.dionpowder.dions_bitsnbobs.config.DionsBitsnBobsConfig;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

public class BulkRecipeGen {


    public static void rebuild(RecipeManager manager) {
        List<RecipeHolder<?>> allRecipes = new ArrayList<>(manager.getRecipes());
        Collection<RecipeHolder<FillingRecipe>> fillingRecipes = manager.getAllRecipesFor(AllRecipeTypes.FILLING.getType());

        // dions bits n bobs generated recipes
        for (RecipeHolder<FillingRecipe> holder : fillingRecipes) {
            FillingRecipe recipe = holder.value();
            ResourceLocation sourceId = holder.id();
            FluidIngredient fluidIngredient = recipe.getRequiredFluid().ingredient();

            if (fluidIngredient.test(new FluidStack(DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/strawberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                StrawberryFrostingRecipe newStrawberryFrostingRecipe = buildStrawberryDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newStrawberryFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(DionsBitsnBobsFluids.ORANGE_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/orange_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                OrangeFrostingRecipe newOrangeFrostingRecipe = buildOrangeDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newOrangeFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(DionsBitsnBobsFluids.BLUEBERRY_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/blueberry_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                BlueberryFrostingRecipe newBlueberryFrostingRecipe = buildBlueberryDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newBlueberryFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(DionsBitsnBobsFluids.PEAR_FROSTING.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/pear_frosting/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                PearFrostingRecipe newPearFrostingRecipe = buildPearDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newPearFrostingRecipe));
            }
            else if (fluidIngredient.test(new FluidStack(AllFluids.CHOCOLATE.get().getSource(), 1))) {
                ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                ChocolateGlazingRecipe newChocolateGlazingRecipe = buildChocolateDerived(newId, recipe);
                allRecipes.add(new RecipeHolder<>(newId, newChocolateGlazingRecipe));
            }

        }

        // create confectionery generated recipes
        if (ModCompat.CREATE_CONFECTIONERY_LOADED
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
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/dark_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    DarkChocolateGlazingRecipe newDarkChocolateGlazingRecipe = buildDarkChocolateDerived(newId, recipe);
                    allRecipes.add(new RecipeHolder<>(newId, newDarkChocolateGlazingRecipe));
                }
                else if (fluidIngredient.test(new FluidStack(whiteChocolate, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/white_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    WhiteChocolateGlazingRecipe newWhiteChocolateGlazingRecipe = buildWhiteChocolateDerived(newId, recipe);
                    allRecipes.add(new RecipeHolder<>(newId, newWhiteChocolateGlazingRecipe));
                }
                else if (fluidIngredient.test(new FluidStack(caramel, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/caramel_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    CaramelChocolateGlazingRecipe newCaramelChocolateGlazingRecipe = buildCaramelChocolateDerived(newId, recipe);
                    allRecipes.add(new RecipeHolder<>(newId, newCaramelChocolateGlazingRecipe));
                }
                else if (fluidIngredient.test(new FluidStack(rubyChocolate, 1))) {
                    ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/ruby_chocolate_glazing/" + sourceId.getNamespace() + "/" + sourceId.getPath());
                    RubyChocolateGlazingRecipe newRubyChocolateGlazingRecipe = buildRubyChocolateDerived(newId, recipe);
                    allRecipes.add(new RecipeHolder<>(newId, newRubyChocolateGlazingRecipe));
                }

            }
        }

        // config recipes
        if (DionsBitsnBobsConfig.commonRecipes().DIAMOND_AUTOMATION.get()) {
            ResourceLocation newId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/compacting/diamond");
            var builder = new StandardProcessingRecipe.Builder<>(CompactingRecipe::new, newId);
            builder.require(Blocks.COAL_BLOCK);
            builder.require(Fluids.LAVA, 250);
            builder.output(Items.DIAMOND);
            allRecipes.add(new RecipeHolder<>(newId, builder.build()));
        }

        if (DionsBitsnBobsConfig.commonRecipes().RENEWABLE_CREATE_STONES_TYPES.get()) {
            // asurine
            ResourceLocation newAsurineId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/mixing/asurine");
            var asurineBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newAsurineId);
            asurineBuilder.require(AllPaletteStoneTypes.ASURINE.getBaseBlock().get());
            asurineBuilder.require(Items.BASALT);
            asurineBuilder.requiresHeat(HeatCondition.HEATED);
            asurineBuilder.output(AllPaletteStoneTypes.ASURINE.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newAsurineId, asurineBuilder.build()));
            // crimsite
            ResourceLocation newCrimsiteId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/mixing/crimsite");
            var crimsiteBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newCrimsiteId);
            crimsiteBuilder.require(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get());
            crimsiteBuilder.require(Items.BLACKSTONE);
            crimsiteBuilder.requiresHeat(HeatCondition.HEATED);
            crimsiteBuilder.output(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newCrimsiteId, crimsiteBuilder.build()));
            // ochrum
            ResourceLocation newOchrumId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/mixing/ochrum");
            var ochrumBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newOchrumId);
            ochrumBuilder.require(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get());
            ochrumBuilder.require(Items.SANDSTONE);
            ochrumBuilder.requiresHeat(HeatCondition.HEATED);
            ochrumBuilder.output(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newOchrumId, ochrumBuilder.build()));
            // veridium
            ResourceLocation newVeridiumId = ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "generated/mixing/veridium");
            var veridiumBuilder = new StandardProcessingRecipe.Builder<>(MixingRecipe::new, newVeridiumId);
            veridiumBuilder.require(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get());
            veridiumBuilder.require(Items.MOSSY_COBBLESTONE);
            veridiumBuilder.requiresHeat(HeatCondition.HEATED);
            veridiumBuilder.output(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get(), 2);
            allRecipes.add(new RecipeHolder<>(newVeridiumId, veridiumBuilder.build()));
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

    // chocolate
    private static ChocolateGlazingRecipe buildChocolateDerived(ResourceLocation id, FillingRecipe source) {
        var builder = ChocolateGlazingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // dark chocolate
    private static DarkChocolateGlazingRecipe buildDarkChocolateDerived(ResourceLocation id, FillingRecipe source) {
        var builder = DarkChocolateGlazingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // white chocolate
    private static WhiteChocolateGlazingRecipe buildWhiteChocolateDerived(ResourceLocation id, FillingRecipe source) {
        var builder = WhiteChocolateGlazingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // caramel
    private static CaramelChocolateGlazingRecipe buildCaramelChocolateDerived(ResourceLocation id, FillingRecipe source) {
        var builder = CaramelChocolateGlazingRecipe.builder(id);

        for (Ingredient ingredient : source.getIngredients()) {
            builder.require(ingredient);
        }

        for (ProcessingOutput output : source.getRollableResults()) {
            builder.output(output.getChance(), output.getStack());
        }

        builder.duration(source.getProcessingDuration());
        return builder.build();
    }

    // ruby
    private static RubyChocolateGlazingRecipe buildRubyChocolateDerived(ResourceLocation id, FillingRecipe source) {
        var builder = RubyChocolateGlazingRecipe.builder(id);

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