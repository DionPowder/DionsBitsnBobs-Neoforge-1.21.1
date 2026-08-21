package net.dionpowder.dions_bitsnbobs.content.recipe;

import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.CranberryFrostingRecipe;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.type.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DBBFanProcessingTypes {
    private static final DeferredRegister<FanProcessingType> TYPES = DeferredRegister.create(CreateRegistries.FAN_PROCESSING_TYPE, DBB.MOD_ID);
    
    public static final DeferredHolder<FanProcessingType, StrawberryFrostingType> STRAWBERRY_FROSTING = TYPES.register("strawberry_frosting", StrawberryFrostingType::new);
    public static final DeferredHolder<FanProcessingType, OrangeFrostingType> ORANGE_FROSTING = TYPES.register("orange_frosting", OrangeFrostingType::new);
    public static final DeferredHolder<FanProcessingType, BlueberryFrostingType> BLUEBERRY_FROSTING = TYPES.register("blueberry_frosting", BlueberryFrostingType::new);
    public static final DeferredHolder<FanProcessingType, PearFrostingType> PEAR_FROSTING = TYPES.register("pear_frosting", PearFrostingType::new);
    public static final DeferredHolder<FanProcessingType, CranberryFrostingType> CRANBERRY_FROSTING = TYPES.register("cranberry_frosting", CranberryFrostingType::new);
    public static final DeferredHolder<FanProcessingType, ChocolateGlazingType> CHOCOLATE_GLAZING = TYPES.register("chocolate_glazing", ChocolateGlazingType::new);
    public static final DeferredHolder<FanProcessingType, DarkChocolateGlazingType> DAKR_CHOCOLATE_GLAZING = TYPES.register("dark_chocolate_glazing", DarkChocolateGlazingType::new);
    public static final DeferredHolder<FanProcessingType, WhiteChocolateGlazingType> WHITE_CHOCOLATE_GLAZING = TYPES.register("white_chocolate_glazing", WhiteChocolateGlazingType::new);
    public static final DeferredHolder<FanProcessingType, RubyChocolateGlazingType> RUBY_CHOCOLATE_GLAZING = TYPES.register("ruby_chocolate_glazing", RubyChocolateGlazingType::new);
    public static final DeferredHolder<FanProcessingType, CaramelChocolateGlazingType> CARAMEL_CHOCOLATE_GLAZING = TYPES.register("caramel_chocolate_glazing", CaramelChocolateGlazingType::new);
    
    public static void register(IEventBus modBus) {
        TYPES.register(modBus);
    }
}