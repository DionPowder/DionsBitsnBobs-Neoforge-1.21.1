package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class CranberryFrostingRecipe extends AbstractFrostingRecipe {
    public CranberryFrostingRecipe(ProcessingRecipeParams params) {super(DBBRecipeTypes.CRANBERRY_FROSTING, params);}

    @Override
    public Block getFrostingBlock() {
        return DBBFluids.CRANBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<CranberryFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(CranberryFrostingRecipe::new, id);
    }

}
