package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.dionpowder.dions_bitsnbobs.datagen.recipes.*;
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

public class DBBRecipeProvider extends RecipeProvider {
    
    static final List<ProcessingRecipeGen<?, ?, ?>> GENERATORS = new ArrayList<>();
    protected final List<GeneratedRecipe> all = new ArrayList<>();
    
    public DBBRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }
    
    public static void registerAllProcessing(DataGenerator gen, PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        GENERATORS.add(new CompactingRecipeProvider(output, registries));
        GENERATORS.add(new CrushingRecipeProvider(output, registries));
        GENERATORS.add(new DeployingRecipeProvider(output, registries));
        GENERATORS.add(new EmptyingRecipeProvider(output, registries));
        GENERATORS.add(new FillingRecipeProvider(output, registries));
        GENERATORS.add(new MixingRecipeProvider(output, registries));
        GENERATORS.add(new PressingRecipeProvider(output, registries));
        GENERATORS.add(new WashingRecipeProvider(output, registries));
        
        GENERATORS.add(new BlueberryFrostingRecipeProvider(output, registries));
        GENERATORS.add(new OrangeFrostingRecipeProvider(output, registries));
        GENERATORS.add(new PearFrostingRecipeProvider(output, registries));
        GENERATORS.add(new StrawberryFrostingRecipeProvider(output, registries));
        
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
