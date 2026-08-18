package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class BlueberryFrostingRecipe extends AbstractFrostingRecipe {
    public BlueberryFrostingRecipe(ProcessingRecipeParams params) {super(DBBRecipeTypes.BLUEBERRY_FROSTING, params);}

    @Override
    public Block getFrostingBlock() {
        return DBBFluids.BLUEBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<BlueberryFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(BlueberryFrostingRecipe::new, id);
    }

}
