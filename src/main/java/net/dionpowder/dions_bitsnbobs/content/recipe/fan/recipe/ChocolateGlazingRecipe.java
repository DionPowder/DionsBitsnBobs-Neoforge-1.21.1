package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public ChocolateGlazingRecipe(ProcessingRecipeParams params) {super(DBBRecipeTypes.CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return AllFluids.CHOCOLATE.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
    }

    public static Builder<ChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(ChocolateGlazingRecipe::new, id);
    }

}
