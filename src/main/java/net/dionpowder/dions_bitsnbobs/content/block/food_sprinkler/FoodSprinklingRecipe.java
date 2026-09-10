package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import javax.annotation.ParametersAreNonnullByDefault;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;

import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
public class FoodSprinklingRecipe extends StandardProcessingRecipe<SingleRecipeInput> {
    
    public FoodSprinklingRecipe(ProcessingRecipeParams params) {
        super(DBBRecipeTypes.FOOD_SPRINKLING, params);
    }
    
    @Override
    public boolean matches(SingleRecipeInput inv, Level worldIn) {
        if (inv.isEmpty())
            return false;
        return ingredients.get(0)
                .test(inv.getItem(0));
    }
    
    @Override
    protected int getMaxInputCount() {
        return 2;
    }
    
    @Override
    protected int getMaxOutputCount() {
        return 1;
    }
    
    public Ingredient getProcessedItem() {
        if (ingredients.isEmpty())
            throw new IllegalStateException("Food Sprinkling Recipe has no sprinkle-able item");
        return ingredients.get(0);
    }
    
    public Ingredient getRequiredSprinkleItem() {
        if (ingredients.size() < 2)
            throw new IllegalStateException("Food Sprinkling Recipe has no sprinkle ingredient");
        return ingredients.get(1);
    }
    
}