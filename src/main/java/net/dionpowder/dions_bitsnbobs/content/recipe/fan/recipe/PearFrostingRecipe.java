package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PearFrostingRecipe extends AbstractFrostingRecipe {
    public PearFrostingRecipe(ProcessingRecipeParams params) {
        super(ModRecipeTypes.PEAR_FROSTING, params);
    }

    @Override
    public Block getFrostingBlock() {
        return ModFluids.PEAR_FROSTING_BLOCK.get();
    }

    public static Builder<PearFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(PearFrostingRecipe::new, id);
    }

}
