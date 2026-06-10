package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class OrangeFrostingRecipe extends AbstractFrostingRecipe {
    public OrangeFrostingRecipe(ProcessingRecipeParams params) {
        super(ModRecipeTypes.ORANGE_FROSTING, params);
    }

    @Override
    public Block getFrostingBlock() {
        return ModFluids.ORANGE_FROSTING_BLOCK.get();
    }

    public static Builder<OrangeFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(OrangeFrostingRecipe::new, id);
    }

}
