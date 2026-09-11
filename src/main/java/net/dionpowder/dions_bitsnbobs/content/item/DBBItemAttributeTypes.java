package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.logistics.item.filter.attribute.ItemAttributeType;
import com.simibubi.create.content.logistics.item.filter.attribute.SingletonItemAttribute;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBFanProcessingTypes;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

public class DBBItemAttributeTypes {
    private static final DeferredRegister<ItemAttributeType> ITEM_ATTRIBUTES = DeferredRegister.create(CreateRegistries.ITEM_ATTRIBUTE_TYPE, DBB.MOD_ID);
    
    
    public static final Holder<ItemAttributeType> FROSTABLE = fanProcessing("frostable",
            "Can be Frosted",
            "Cannot be Frosted",
            DBBFanProcessingTypes.STRAWBERRY_FROSTING,
            DBBFanProcessingTypes.ORANGE_FROSTING,
            DBBFanProcessingTypes.BLUEBERRY_FROSTING,
            DBBFanProcessingTypes.PEAR_FROSTING,
            DBBFanProcessingTypes.CRANBERRY_FROSTING);
    
    public static final Holder<ItemAttributeType> CHOCOLATE_GLAZEABLE = fanProcessing("chocolate_glazeable",
            "Can be Chocolate Glazed",
            "Cannot be Chocolate Glazed",
            DBBFanProcessingTypes.CHOCOLATE_GLAZING,
            DBBFanProcessingTypes.DAKR_CHOCOLATE_GLAZING,
            DBBFanProcessingTypes.WHITE_CHOCOLATE_GLAZING,
            DBBFanProcessingTypes.RUBY_CHOCOLATE_GLAZING,
            DBBFanProcessingTypes.CARAMEL_CHOCOLATE_GLAZING);
    
    public static final Holder<ItemAttributeType> SPRINKLEABLE = recipeBased("sprinkleable",
            "Can be Sprinkled",
            "Cannot be Sprinkled",
            (stack, level) -> {
                var input = new SingleRecipeInput(stack);
                return DBBRecipeTypes.FOOD_SPRINKLING.find(input, level)
                        .filter(recipe -> recipe.value().getIngredients().get(0).test(stack))
                        .isPresent();
            });
    
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
    
    private static Holder<ItemAttributeType> fanProcessing(String name, String description, String invertedDescription, Supplier<? extends FanProcessingType>... processingTypes) {
        String descriptionKey = "create.item_attributes." + DBB.MOD_ID + "." + name;
        String invertedDescriptionKey = descriptionKey + ".inverted";
        REGISTRATE.addRawLang(descriptionKey, description);
        REGISTRATE.addRawLang(invertedDescriptionKey, invertedDescription);
        return ITEM_ATTRIBUTES.register(name, () -> new SingletonItemAttribute.Type(
                type -> new SingletonItemAttribute(
                        type,
                        (stack, level) -> Arrays.stream(processingTypes).anyMatch(s -> s.get().canProcess(stack, level)),
                        DBB.MOD_ID + "." + name
                )
        ));
    }
    
    public static void register(IEventBus modEventBus) {
        ITEM_ATTRIBUTES.register(modEventBus);
    }
    
}
