package net.dionpowder.dions_bitsnbobs.recipe.fan;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
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
