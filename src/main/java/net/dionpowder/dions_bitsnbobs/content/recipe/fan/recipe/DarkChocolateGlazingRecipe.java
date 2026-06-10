package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DarkChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public DarkChocolateGlazingRecipe(ProcessingRecipeParams params) {super(ModRecipeTypes.DARK_CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate")).orElse(Blocks.AIR);
    }

    public static Builder<DarkChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(DarkChocolateGlazingRecipe::new, id);
    }

}
