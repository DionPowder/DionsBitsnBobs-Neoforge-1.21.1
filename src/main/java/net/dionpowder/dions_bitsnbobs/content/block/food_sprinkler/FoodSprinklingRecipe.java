package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import javax.annotation.ParametersAreNonnullByDefault;

import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;

import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;
import com.simibubi.create.foundation.utility.CreateLang;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.AssemblyFoodSprinkling;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
public class FoodSprinklingRecipe extends StandardProcessingRecipe<SingleRecipeInput> implements IAssemblyRecipe {
    
    public FoodSprinklingRecipe(ProcessingRecipeParams params) {
        super(DBBRecipeTypes.FOOD_SPRINKLING, params);
    }

    public static Builder<FoodSprinklingRecipe> builder(ResourceLocation id) {
        return new Builder<>(FoodSprinklingRecipe::new, id);
    }

    @Override
    public boolean matches(SingleRecipeInput inv, Level worldIn) {
        if (inv.isEmpty())
            return false;
        return ingredients.get(0)
                .test(inv.getItem(0));
    }
    
    @Override
    protected int getMaxInputCount() {
        return 2;
    }
    
    @Override
    protected int getMaxOutputCount() {
        return 1;
    }
    
    public Ingredient getProcessedItem() {
        if (ingredients.isEmpty())
            throw new IllegalStateException("Food Sprinkling Recipe has no sprinkle-able item");
        return ingredients.get(0);
    }
    
    public Ingredient getRequiredSprinkleItem() {
        if (ingredients.size() < 2)
            throw new IllegalStateException("Food Sprinkling Recipe has no sprinkle ingredient");
        return ingredients.get(1);
    }
    
    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
        list.add(ingredients.get(1));
    }
    
    @Override
    @OnlyIn(Dist.CLIENT)
    public Component getDescriptionForAssembly() {
        ItemStack[] matchingStacks = ingredients.get(1)
                .getItems();
        if (matchingStacks.length == 0) {
            return Component.literal("Invalid");
        }
        return CreateLang.translateDirect("recipe.assembly.sprinkling_item",
                Component.translatable(matchingStacks[0].getDescriptionId()).getString());
    }
    
    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(DBBBlocks.FOOD_SPRINKLER.get());
    }
    
    @Override
    public Supplier<Supplier<SequencedAssemblySubCategory>> getJEISubCategory() {
        return () -> AssemblyFoodSprinkling::new;
    }
    
    
}