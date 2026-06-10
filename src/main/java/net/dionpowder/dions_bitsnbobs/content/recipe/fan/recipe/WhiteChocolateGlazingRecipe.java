package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WhiteChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public WhiteChocolateGlazingRecipe(ProcessingRecipeParams params) {super(ModRecipeTypes.WHITE_CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate")).orElse(Blocks.AIR);
    }

    public static Builder<WhiteChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(WhiteChocolateGlazingRecipe::new, id);
    }

}
