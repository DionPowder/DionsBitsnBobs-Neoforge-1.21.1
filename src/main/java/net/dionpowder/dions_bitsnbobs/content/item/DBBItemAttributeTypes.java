package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.logistics.item.filter.attribute.ItemAttributeType;
import com.simibubi.create.content.logistics.item.filter.attribute.SingletonItemAttribute;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBFanProcessingTypes;
import net.minecraft.core.Holder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
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
