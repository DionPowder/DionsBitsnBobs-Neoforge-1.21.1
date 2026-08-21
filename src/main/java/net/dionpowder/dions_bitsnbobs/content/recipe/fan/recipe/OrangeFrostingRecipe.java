package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class OrangeFrostingRecipe extends AbstractFrostingRecipe {
    public OrangeFrostingRecipe(ProcessingRecipeParams params) {
        super(DBBRecipeTypes.ORANGE_FROSTING, params);
    }

    @Override
    public Block getFrostingBlock() {
        return DBBFluids.ORANGE_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<OrangeFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(OrangeFrostingRecipe::new, id);
    }

}
