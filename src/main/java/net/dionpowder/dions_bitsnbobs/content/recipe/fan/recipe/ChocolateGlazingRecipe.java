package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.DionsBitsnBobsRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public ChocolateGlazingRecipe(ProcessingRecipeParams params) {super(DionsBitsnBobsRecipeTypes.CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return AllFluids.CHOCOLATE.get().getSource().defaultFluidState().createLegacyBlock().getBlock();
        //return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate")).orElse(Blocks.AIR);
    }

    public static Builder<ChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(ChocolateGlazingRecipe::new, id);
    }

}
