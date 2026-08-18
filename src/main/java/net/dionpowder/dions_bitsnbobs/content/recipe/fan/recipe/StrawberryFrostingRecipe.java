package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DionsBitsnBobsRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class StrawberryFrostingRecipe extends AbstractFrostingRecipe {
    public StrawberryFrostingRecipe(ProcessingRecipeParams params) {super(DionsBitsnBobsRecipeTypes.STRAWBERRY_FROSTING, params);}

    @Override
    public Block getFrostingBlock() {
        return DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static StandardProcessingRecipe.Builder<StrawberryFrostingRecipe> builder(ResourceLocation id) {
        return new StandardProcessingRecipe.Builder<>(StrawberryFrostingRecipe::new, id);
    }

}
