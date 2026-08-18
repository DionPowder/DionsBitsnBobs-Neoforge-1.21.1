package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DionsBitsnBobsRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class OrangeFrostingRecipe extends AbstractFrostingRecipe {
    public OrangeFrostingRecipe(ProcessingRecipeParams params) {
        super(DionsBitsnBobsRecipeTypes.ORANGE_FROSTING, params);
    }

    @Override
    public Block getFrostingBlock() {
        return DionsBitsnBobsFluids.ORANGE_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<OrangeFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(OrangeFrostingRecipe::new, id);
    }

}
