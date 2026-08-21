package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PearFrostingRecipe extends AbstractFrostingRecipe {
    public PearFrostingRecipe(ProcessingRecipeParams params) {
        super(DBBRecipeTypes.PEAR_FROSTING, params);
    }

    @Override
    public Block getFrostingBlock() {
        return DBBFluids.PEAR_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<PearFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(PearFrostingRecipe::new, id);
    }

}
