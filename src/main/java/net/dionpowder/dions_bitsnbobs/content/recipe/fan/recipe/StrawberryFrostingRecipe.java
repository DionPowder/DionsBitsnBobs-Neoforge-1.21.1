package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class StrawberryFrostingRecipe extends AbstractFrostingRecipe {
    public StrawberryFrostingRecipe(ProcessingRecipeParams params) {super(DBBRecipeTypes.STRAWBERRY_FROSTING, params);}

    @Override
    public Block getFrostingBlock() {
        return DBBFluids.STRAWBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static StandardProcessingRecipe.Builder<StrawberryFrostingRecipe> builder(ResourceLocation id) {
        return new StandardProcessingRecipe.Builder<>(StrawberryFrostingRecipe::new, id);
    }

}
