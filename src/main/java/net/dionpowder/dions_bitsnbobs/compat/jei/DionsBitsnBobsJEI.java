package net.dionpowder.dions_bitsnbobs.compat.jei;

import com.simibubi.create.AllFluids;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.*;
import net.dionpowder.dions_bitsnbobs.compat.jei.widget.FanProcessingIcon;
import net.dionpowder.dions_bitsnbobs.config.DionsBitsnBobsConfig;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.AbstractChocolateGlazingRecipe;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.AbstractFrostingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class DionsBitsnBobsJEI implements IModPlugin {
    private static final ResourceLocation ID = DBB.rl("jei_plugin");

    private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();
    public static IJeiRuntime runtime;

    private void loadFrostingCategory() {
        CreateRecipeCategory<?>

                frosting = builder(AbstractFrostingRecipe.class)
                .addTypedRecipes(DBBRecipeTypes.STRAWBERRY_FROSTING)
                .addTypedRecipes(DBBRecipeTypes.ORANGE_FROSTING)
                .addTypedRecipes(DBBRecipeTypes.BLUEBERRY_FROSTING)
                .addTypedRecipes(DBBRecipeTypes.PEAR_FROSTING)
                .addTypedRecipes(DBBRecipeTypes.CRANBERRY_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_frosting"))
                .icon(new FrostingIcon())
                .emptyBackground(178, 72)
                .build("fan_frosting", FrostingCategory::new);
    }

    private void loadChocolateCategory() {
        CreateRecipeCategory<?>

                chocolate_glazing = builder(AbstractChocolateGlazingRecipe.class)
                .addTypedRecipes(DBBRecipeTypes.CHOCOLATE_GLAZING)
                .addTypedRecipes(DBBRecipeTypes.DARK_CHOCOLATE_GLAZING)
                .addTypedRecipes(DBBRecipeTypes.WHITE_CHOCOLATE_GLAZING)
                .addTypedRecipes(DBBRecipeTypes.CARAMEL_CHOCOLATE_GLAZING)
                .addTypedRecipes(DBBRecipeTypes.RUBY_CHOCOLATE_GLAZING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_chocolate_glazing"))
                .icon(new ChocolateIcon())
                .emptyBackground(178, 72)
                .build("fan_chocolate_glazing", ChocolateGlazingCategory::new);
    }

    // frosting icon
    protected static class FrostingIcon extends FanProcessingIcon {
        private ItemStack[] catalystStacks;

        @Override
        protected ItemStack getCatalyst() {
            if (catalystStacks == null) {
                catalystStacks = new ItemStack[]{
                        new ItemStack(DBBFluids.STRAWBERRY_FROSTING.get().getBucket()),
                        new ItemStack(DBBFluids.BLUEBERRY_FROSTING.get().getBucket()),
                        new ItemStack(DBBFluids.ORANGE_FROSTING.get().getBucket()),
                        new ItemStack(DBBFluids.PEAR_FROSTING.get().getBucket()),
                        new ItemStack(DBBFluids.CRANBERRY_FROSTING.get().getBucket()),
                };
            }
            return catalystStacks[(AnimationTickHolder.getTicks() / 20) % catalystStacks.length];
        }
    }

    // chocolate icon
    protected static class ChocolateIcon extends FanProcessingIcon {
        Item chocolateBucket = AllFluids.CHOCOLATE.get().getBucket();
        private ItemStack[] catalystStacks;

        @Override
        protected ItemStack getCatalyst() {
            if (catalystStacks == null) {
                catalystStacks = new ItemStack[]{
                        new ItemStack(chocolateBucket),
                        new ItemStack(BuiltInRegistries.ITEM.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate_bucket")).orElse(chocolateBucket)),
                        new ItemStack(BuiltInRegistries.ITEM.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate_bucket")).orElse(chocolateBucket)),
                        new ItemStack(BuiltInRegistries.ITEM.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel_bucket")).orElse(chocolateBucket)),
                        new ItemStack(BuiltInRegistries.ITEM.getOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate_bucket")).orElse(chocolateBucket)),
                };
            }
            return catalystStacks[(AnimationTickHolder.getTicks() / 20) % catalystStacks.length];
        }
    }

    // builders
    private <T extends Recipe<? extends RecipeInput>> CategoryBuilder<T> builder(Class<T> recipeClass) {
        return new CategoryBuilder<>(recipeClass);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        allCategories.clear();
        if (DionsBitsnBobsConfig.recipes().BULK_FROSTING.get()) {loadFrostingCategory();}
        if (DionsBitsnBobsConfig.recipes().BULK_CHOCOLATE_GLAZING.get()) {loadChocolateCategory();}
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
