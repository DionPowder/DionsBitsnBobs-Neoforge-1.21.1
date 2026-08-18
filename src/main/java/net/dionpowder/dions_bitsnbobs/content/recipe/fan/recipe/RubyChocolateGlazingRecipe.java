package net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class RubyChocolateGlazingRecipe extends AbstractChocolateGlazingRecipe {
    public RubyChocolateGlazingRecipe(ProcessingRecipeParams params) {super(DBBRecipeTypes.RUBY_CHOCOLATE_GLAZING, params);}

    @Override
    public Block getChocolateBlock() {
        return BuiltInRegistries.BLOCK.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate")).orElse(Blocks.AIR);
    }

    public static Builder<RubyChocolateGlazingRecipe> builder(ResourceLocation id) {
        return new Builder<>(RubyChocolateGlazingRecipe::new, id);
    }

}
