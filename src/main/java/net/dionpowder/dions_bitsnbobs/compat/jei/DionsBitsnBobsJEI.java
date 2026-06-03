package net.dionpowder.dions_bitsnbobs.compat.jei;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.BlueberryFrostingCategory;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.OrangeFrostingCategory;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.PearFrostingCategory;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.StrawberryFrostingCategory;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.recipe.fan.BlueberryFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.OrangeFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.PearFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.recipe.fan.StrawberryFrostingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class DionsBitsnBobsJEI implements IModPlugin {
    private static final ResourceLocation ID = DionsBitsnBobs.rl("jei_plugin");

    private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();
    public static IJeiRuntime runtime;

    private void loadCategories() {
        allCategories.clear();

        CreateRecipeCategory<?>

                strawberry_frosting = builder(StrawberryFrostingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.STRAWBERRY_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_strawberry_frosting"))
                .doubleItemIcon(AllItems.PROPELLER.get(), ModFluids.STRAWBERRY_FROSTING_BUCKET)
                .emptyBackground(178, 72)
                .build("fan_strawberry_frosting", StrawberryFrostingCategory::new),

                orange_frosting = builder(OrangeFrostingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.ORANGE_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_orange_frosting"))
                .doubleItemIcon(AllItems.PROPELLER.get(), ModFluids.ORANGE_FROSTING_BUCKET)
                .emptyBackground(178, 72)
                .build("fan_orange_frosting", OrangeFrostingCategory::new),

                blueberry_frosting = builder(BlueberryFrostingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.BLUEBERRY_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_blueberry_frosting"))
                .doubleItemIcon(AllItems.PROPELLER.get(), ModFluids.BLUEBERRY_FROSTING_BUCKET)
                .emptyBackground(178, 72)
                .build("fan_blueberry_frosting", BlueberryFrostingCategory::new),

                pear_frosting = builder(PearFrostingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.PEAR_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_pear_frosting"))
                .doubleItemIcon(AllItems.PROPELLER.get(), ModFluids.PEAR_FROSTING_BUCKET)
                .emptyBackground(178, 72)
                .build("fan_pear_frosting", PearFrostingCategory::new);

    }

    private <T extends Recipe<? extends RecipeInput>> CategoryBuilder<T> builder(Class<T> recipeClass) {
        return new CategoryBuilder<>(recipeClass);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(allCategories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        allCategories.forEach(c -> c.registerRecipes(registration));
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    private class CategoryBuilder<T extends Recipe<?>> extends CreateRecipeCategory.Builder<T> {
        public CategoryBuilder(Class<? extends T> recipeClass) {
            super(recipeClass);
        }

        @Override
        public @NotNull CreateRecipeCategory<T> build(ResourceLocation id, CreateRecipeCategory.Factory<T> factory) {
            CreateRecipeCategory<T> category = super.build(id, factory);
            allCategories.add(category);
            return category;
        }
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime runtime) {
        DionsBitsnBobsJEI.runtime = runtime;
    }
}
