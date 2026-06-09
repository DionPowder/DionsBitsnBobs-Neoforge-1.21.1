package net.dionpowder.dions_bitsnbobs.recipe.fan;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
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
