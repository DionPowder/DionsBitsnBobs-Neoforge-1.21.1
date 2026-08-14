package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.DionsBitsnBobsRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CaramelChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public CaramelChocolateGlazingRecipe(ProcessingRecipeParams params) {super(DionsBitsnBobsRecipeTypes.CARAMEL_CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel")).orElse(Blocks.AIR);
    }

    public static Builder<CaramelChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(CaramelChocolateGlazingRecipe::new, id);
    }

}
