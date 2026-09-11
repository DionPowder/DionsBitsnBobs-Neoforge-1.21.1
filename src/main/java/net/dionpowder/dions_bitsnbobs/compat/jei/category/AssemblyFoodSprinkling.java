package net.dionpowder.dions_bitsnbobs.compat.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.sequenced.SequencedRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.animations.AnimatedFoodSprinkler;
import net.minecraft.client.gui.GuiGraphics;

public class AssemblyFoodSprinkling extends SequencedAssemblySubCategory {
    
    AnimatedFoodSprinkler foodSprinkler;
    
    public AssemblyFoodSprinkling() {
        super(25);
        foodSprinkler = new AnimatedFoodSprinkler();
    }
    
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SequencedRecipe<?> recipe, IFocusGroup focuses, int x) {
        IRecipeSlotBuilder slot = builder
                .addSlot(RecipeIngredientRole.INPUT, x + 4, 15)
                .setBackground(CreateRecipeCategory.getRenderedSlot(), -1, -1)
                .addIngredients(recipe.getRecipe().getIngredients().get(1));
    }
    
    @Override
    public void draw(SequencedRecipe<?> recipe, GuiGraphics graphics, double mouseX, double mouseY, int index) {
        PoseStack ms = graphics.pose();
        foodSprinkler.offset = index;
        ms.pushPose();
        ms.translate(-7, 50, 0);
        ms.scale(.75f, .75f, .75f);
        foodSprinkler.draw(graphics, getWidth() / 2, 0);
        ms.popPose();
    }
    
}