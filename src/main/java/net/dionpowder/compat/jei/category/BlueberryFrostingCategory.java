package net.dionpowder.compat.jei.category;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.fan.BlueberryFrostingRecipe;
import net.minecraft.client.gui.GuiGraphics;

public class BlueberryFrostingCategory extends ProcessingViaFanCategory.MultiOutput<BlueberryFrostingRecipe> {
    public BlueberryFrostingCategory(Info<BlueberryFrostingRecipe> info) {
        super(info);
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        GuiGameElement.of(ModFluids.BLUEBERRY_FROSTING_BLOCK.get().defaultBlockState())
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }
}
