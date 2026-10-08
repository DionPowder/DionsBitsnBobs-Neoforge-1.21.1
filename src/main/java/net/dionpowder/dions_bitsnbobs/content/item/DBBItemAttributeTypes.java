package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.logistics.item.filter.attribute.ItemAttributeType;
import com.simibubi.create.content.logistics.item.filter.attribute.SingletonItemAttribute;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.compat.ModCompat;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklingRecipe;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

public class DBBItemAttributeTypes {
    private static final DeferredRegister<ItemAttributeType> ITEM_ATTRIBUTES = DeferredRegister.create(CreateRegistries.ITEM_ATTRIBUTE_TYPE, DBB.MOD_ID);
    
    public static final Holder<ItemAttributeType> FROSTABLE = recipeBased("frostable",
            "Can be Frosted",
            "Cannot be Frosted",
            (stack, level) -> canBeFilledWith(stack, level,
                    DBBFluids.STRAWBERRY_FROSTING.get().getSource(),
                    DBBFluids.ORANGE_FROSTING.get().getSource(),
                    DBBFluids.BLUEBERRY_FROSTING.get().getSource(),
                    DBBFluids.PEAR_FROSTING.get().getSource(),
                    DBBFluids.CRANBERRY_FROSTING.get().getSource()));

    public static final Holder<ItemAttributeType> CHOCOLATE_GLAZEABLE = recipeBased("chocolate_glazeable",
            "Can be Chocolate Glazed",
            "Cannot be Chocolate Glazed",
            (stack, level) -> canBeFilledWith(stack, level, chocolateFluids()));
    
    public static final Holder<ItemAttributeType> SPRINKLEABLE = recipeBased("sprinkleable",
            "Can be Sprinkled",
            "Cannot be Sprinkled",
            (stack, level) -> level.getRecipeManager()
                    .getAllRecipesFor(DBBRecipeTypes.FOOD_SPRINKLING.<RecipeWrapper, FoodSprinklingRecipe>getType())
                    .stream()
                    .anyMatch(recipe -> recipe.value().getProcessedItem().test(stack)));
    
    private static Holder<ItemAttributeType> recipeBased(String name, String description, String invertedDescription, BiPredicate<ItemStack, Level> predicate) {
        String descriptionKey = "create.item_attributes." + DBB.MOD_ID + "." + name;
        String invertedDescriptionKey = descriptionKey + ".inverted";
        REGISTRATE.addRawLang(descriptionKey, description);
        REGISTRATE.addRawLang(invertedDescriptionKey, invertedDescription);
        return ITEM_ATTRIBUTES.register(name, () -> new SingletonItemAttribute.Type(
                type -> new SingletonItemAttribute(
                        type,
                        predicate,
                        DBB.MOD_ID + "." + name
                )
        ));
    }
    
    private static boolean canBeFilledWith(ItemStack stack, Level level, Fluid... fluids) {
        Collection<RecipeHolder<FillingRecipe>> fillingRecipes = level.getRecipeManager().getAllRecipesFor(AllRecipeTypes.FILLING.getType());
        for (RecipeHolder<FillingRecipe> holder : fillingRecipes) {
            FillingRecipe recipe = holder.value();
            if (!recipe.getIngredients().get(0).test(stack))
                continue;
            FluidIngredient fluidIngredient = recipe.getRequiredFluid().ingredient();
            for (Fluid fluid : fluids)
                if (fluidIngredient.test(new FluidStack(fluid, 1)))
                    return true;
        }
        return false;
    }

    private static Fluid[] chocolateFluids() {
        List<Fluid> fluids = new ArrayList<>();
        fluids.add(AllFluids.CHOCOLATE.get().getSource());
        if (ModCompat.CREATE_CONFECTIONERY.enabled()) {
            addConfectioneryFluid(fluids, "black_chocolate");
            addConfectioneryFluid(fluids, "white_chocolate");
            addConfectioneryFluid(fluids, "caramel");
            addConfectioneryFluid(fluids, "ruby_chocolate");
        }
        return fluids.toArray(Fluid[]::new);
    }

    private static void addConfectioneryFluid(List<Fluid> fluids, String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("create_confectionery", path);
        if (BuiltInRegistries.FLUID.containsKey(id))
            fluids.add(BuiltInRegistries.FLUID.get(id));
    }
    
    public static void register(IEventBus modEventBus) {
        ITEM_ATTRIBUTES.register(modEventBus);
    }
    
}
