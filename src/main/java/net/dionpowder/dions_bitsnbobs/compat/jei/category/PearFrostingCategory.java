package net.dionpowder.dions_bitsnbobs.compat.jei.category;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.fan.PearFrostingRecipe;
import net.minecraft.client.gui.GuiGraphics;

public class PearFrostingCategory extends ProcessingViaFanCategory.MultiOutput<PearFrostingRecipe> {
    public PearFrostingCategory(Info<PearFrostingRecipe> info) {
        super(info);
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        GuiGameElement.of(ModFluids.PEAR_FROSTING_BLOCK.get().defaultBlockState())
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }
}
