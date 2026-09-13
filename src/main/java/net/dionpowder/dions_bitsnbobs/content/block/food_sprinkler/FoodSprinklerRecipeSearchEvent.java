package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class FoodSprinklerRecipeSearchEvent extends Event implements ICancellableEvent {
    private final FoodSprinklerBlockEntity foodSprinkler;
    private final RecipeWrapper inventory;
    @Nullable
    RecipeHolder<? extends Recipe<? extends RecipeInput>> recipe = null;
    private int maxPriority = 0;
    
    public FoodSprinklerRecipeSearchEvent(FoodSprinklerBlockEntity foodSprinkler, RecipeWrapper inventory) {
        this.foodSprinkler = foodSprinkler;
        this.inventory = inventory;
    }
    
    public FoodSprinklerBlockEntity getBlockEntity() {
        return foodSprinkler;
    }
    
    public RecipeWrapper getInventory() {
        return inventory;
    }
    
    // lazyness to not scan for recipes that aren't selected
    public boolean shouldAddRecipeWithPriority(int priority) {
        return !isCanceled() && priority > maxPriority;
    }
    
    @Nullable
    public RecipeHolder<? extends Recipe<? extends RecipeInput>> getRecipe() {
        if (isCanceled())
            return null;
        return recipe;
    }
    
    public void addRecipe(Supplier<Optional<? extends RecipeHolder<? extends Recipe<? extends RecipeInput>>>> recipeSupplier, int priority) {
        if (!shouldAddRecipeWithPriority(priority))
            return;
        recipeSupplier.get().ifPresent(newRecipe -> {
            this.recipe = newRecipe;
            maxPriority = priority;
        });
    }
}