package net.dionpowder.dions_bitsnbobs.compat.jei.category;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.AbstractFrostingRecipe;
import net.minecraft.client.gui.GuiGraphics;

public class FrostingCategory extends ProcessingViaFanCategory.MultiOutput<AbstractFrostingRecipe> {

    private AbstractFrostingRecipe currentRecipe;

    public FrostingCategory(Info<AbstractFrostingRecipe> info) {
        super(info);
    }

    @Override
    public void draw(AbstractFrostingRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics graphics, double mouseX, double mouseY) {
        this.currentRecipe = recipe;
        super.draw(recipe, slotsView, graphics, mouseX, mouseY);
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        if (currentRecipe == null) return;

        GuiGameElement.of(currentRecipe.getFrostingBlock().defaultBlockState())
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }
}