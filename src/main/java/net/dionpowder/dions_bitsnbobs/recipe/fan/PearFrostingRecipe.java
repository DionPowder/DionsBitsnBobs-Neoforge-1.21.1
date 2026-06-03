package net.dionpowder.dions_bitsnbobs.recipe.fan;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class PearFrostingRecipe extends StandardProcessingRecipe<SingleRecipeInput> {
    public PearFrostingRecipe(ProcessingRecipeParams params) {
        super(ModRecipeTypes.PEAR_FROSTING, params);
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return getIngredients().getFirst().test(input.item());
    }

    public static Builder<PearFrostingRecipe> builder(ResourceLocation id) {
        return new Builder<>(PearFrostingRecipe::new, id);
    }

}
