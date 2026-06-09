package net.dionpowder.dions_bitsnbobs.compat.jei;

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dionpowder.dions_bitsnbobs.compat.jei.category.*;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.compat.jei.widget.FanProcessingIcon;
import net.dionpowder.dions_bitsnbobs.config.ServerConfig;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.recipe.fan.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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

                frosting = builder(AbstractFrostingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.STRAWBERRY_FROSTING)
                .addTypedRecipes(ModRecipeTypes.ORANGE_FROSTING)
                .addTypedRecipes(ModRecipeTypes.BLUEBERRY_FROSTING)
                .addTypedRecipes(ModRecipeTypes.PEAR_FROSTING)
                .catalystStack(ProcessingViaFanCategory.getFan("fan_frosting"))
                .icon(new FrostingIcon())
                .emptyBackground(178, 72)
                .build("fan_frosting", FrostingCategory::new);

    }

    // frosting icon
    protected static class FrostingIcon extends FanProcessingIcon {
        private ItemStack[] catalystStacks;

        @Override
        protected ItemStack getCatalyst() {
            if (catalystStacks == null) {
                catalystStacks = new ItemStack[]{
                        new ItemStack(ModFluids.STRAWBERRY_FROSTING_BUCKET.get()),
                        new ItemStack(ModFluids.ORANGE_FROSTING_BUCKET.get()),
                        new ItemStack(ModFluids.BLUEBERRY_FROSTING_BUCKET.get()),
                        new ItemStack(ModFluids.PEAR_FROSTING_BUCKET.get())
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
        // register frosting recipe to JEI if enabled in config
        if (ServerConfig.BULK_FROSTING.get()) {loadCategories();}
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
