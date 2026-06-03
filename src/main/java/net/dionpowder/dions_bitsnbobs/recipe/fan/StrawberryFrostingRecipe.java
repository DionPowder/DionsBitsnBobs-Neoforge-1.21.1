package net.dionpowder.dions_bitsnbobs.recipe.fan;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class StrawberryFrostingRecipe extends StandardProcessingRecipe<SingleRecipeInput> {
    public StrawberryFrostingRecipe(ProcessingRecipeParams params) {
        super(ModRecipeTypes.STRAWBERRY_FROSTING, params);
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

    public static StandardProcessingRecipe.Builder<StrawberryFrostingRecipe> builder(ResourceLocation id) {
        return new StandardProcessingRecipe.Builder<>(StrawberryFrostingRecipe::new, id);
    }

}
