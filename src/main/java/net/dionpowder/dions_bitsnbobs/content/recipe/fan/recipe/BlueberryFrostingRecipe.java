package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class BlueberryFrostingRecipe extends AbstractFrostingRecipe {
    public BlueberryFrostingRecipe(ProcessingRecipeParams params) {super(ModRecipeTypes.BLUEBERRY_FROSTING, params);}

    @Override
    public Block getFrostingBlock() {
        return ModFluids.BLUEBERRY_FROSTING_BLOCK.get();
    }

    public static Builder<BlueberryFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(BlueberryFrostingRecipe::new, id);
    }

}
