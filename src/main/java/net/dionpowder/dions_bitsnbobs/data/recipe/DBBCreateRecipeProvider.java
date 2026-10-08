package net.dionpowder.dions_bitsnbobs.data.recipe;

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.data.recipe.builders.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DBBCreateRecipeProvider extends RecipeProvider {
    
    static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();
    protected final List<GeneratedRecipe> all = new ArrayList<>();
    
    public DBBCreateRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }
    
    public static void registerAllProcessing(DataGenerator gen, PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        GENERATORS.add(new CompactingRecipeBuilder(output, registries));
        GENERATORS.add(new CrushingRecipeBuilder(output, registries));
        GENERATORS.add(new DeployingRecipeBuilder(output, registries));
        GENERATORS.add(new EmptyingRecipeBuilder(output, registries));
        GENERATORS.add(new FillingRecipeBuilder(output, registries));
        GENERATORS.add(new MixingRecipeBuilder(output, registries));
        GENERATORS.add(new PressingRecipeBuilder(output, registries));
        GENERATORS.add(new WashingRecipeBuilder(output, registries));
        
        GENERATORS.add(new BlueberryFrostingRecipeBuilder(output, registries));
        GENERATORS.add(new OrangeFrostingRecipeBuilder(output, registries));
        GENERATORS.add(new PearFrostingRecipeBuilder(output, registries));
        GENERATORS.add(new StrawberryFrostingRecipeBuilder(output, registries));
        GENERATORS.add(new CranberryFrostingRecipeBuilder(output, registries));
        GENERATORS.add(new FoodSprinklingRecipeBuilder(output, registries));
        
        gen.addProvider(true, new DataProvider() {
            @Override
            public @NotNull String getName() {
                return "Create: Dion's Bits 'n' Bobs! Processing Recipes";
            }
            @Override
            public @NotNull CompletableFuture<?> run(@NotNull CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream().map(gen -> gen.run(dc)).toArray(CompletableFuture[]::new));
            }
        });
    }
    
    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        all.forEach(c -> c.register(pRecipeOutput));
    }
    
    protected GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }
    
    @FunctionalInterface
    public interface GeneratedRecipe {
        void register(RecipeOutput output);
    }
    
}
