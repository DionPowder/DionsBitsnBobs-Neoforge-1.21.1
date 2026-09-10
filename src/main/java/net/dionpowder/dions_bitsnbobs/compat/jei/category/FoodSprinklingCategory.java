package net.dionpowder.dions_bitsnbobs.compat.jei.category;

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.animations.AnimatedFoodSprinkler;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklingRecipe;
import net.minecraft.client.gui.GuiGraphics;

public class FoodSprinklingCategory extends CreateRecipeCategory<FoodSprinklingRecipe> {
    
    private final AnimatedFoodSprinkler foodSprinkler = new AnimatedFoodSprinkler();
    
    public FoodSprinklingCategory(Info<FoodSprinklingRecipe> info) {
        super(info);
    }
    
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FoodSprinklingRecipe recipe, IFocusGroup focuses) {
        builder
                .addSlot(RecipeIngredientRole.INPUT, 27, 51)
                .setBackground(getRenderedSlot(), -1, -1)
                .addIngredients(recipe.getProcessedItem());
        builder
                .addSlot(RecipeIngredientRole.INPUT, 51, 5)
                .setBackground(getRenderedSlot(), -1, -1)
                .addIngredients(recipe.getRequiredSprinkleItem());
        
        
        builder
                .addSlot(RecipeIngredientRole.OUTPUT, 132, 51)
                .setBackground(getRenderedSlot(), -1, -1)
                .addItemStack(getResultItem(recipe));
    }
    
    @Override
    public void draw(FoodSprinklingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX, double mouseY) {
        AllGuiTextures.JEI_SHADOW.render(graphics, 62, 57);
        AllGuiTextures.JEI_DOWN_ARROW.render(graphics, 126, 29 + (recipe.getRollableResults().size() > 2 ? -19 : 0));
        foodSprinkler.draw(graphics, getBackground().getWidth() / 2 - 13, 22);
    }
    
}
