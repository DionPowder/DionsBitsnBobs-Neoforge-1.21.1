package net.dionpowder.dions_bitsnbobs.content.recipe;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;

import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.type.*;
import net.minecraft.core.Registry;
import org.jetbrains.annotations.ApiStatus;

public class DionsBitsnBobsFanProcessingTypes {
    public static final StrawberryFrostingType STRAWBERRY_FROSTING_TYPE = register("strawberry_frosting", new StrawberryFrostingType());
    public static final OrangeFrostingType ORANGE_FROSTING_TYPE = register("orange_frosting", new OrangeFrostingType());
    public static final BlueberryFrostingType BLUEBERRY_FROSTING_TYPE = register("blueberry_frosting", new BlueberryFrostingType());
    public static final PearFrostingType PEAR_FROSTING_TYPE = register("pear_frosting", new PearFrostingType());
    public static final ChocolateGlazingType CHOCOLATE_GLAZING_TYPE = register("chocolate_glazing", new ChocolateGlazingType());
    public static final DarkChocolateGlazingType DARK_CHOCOLATE_GLAZING_TYPE = register("dark_chocolate_glazing", new DarkChocolateGlazingType());
    public static final WhiteChocolateGlazingType WHITE_CHOCOLATE_GLAZING_TYPE = register("white_chocolate_glazing", new WhiteChocolateGlazingType());
    public static final CaramelChocolateGlazingType CARAMEL_CHOCOLATE_GLAZING_TYPE = register("caramel_chocolate_glazing", new CaramelChocolateGlazingType());
    public static final RubyChocolateGlazingType RUBY_CHOCOLATE_GLAZING_TYPE = register("ruby_chocolate_glazing", new RubyChocolateGlazingType());

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("STRAWBERRY_FROSTING", STRAWBERRY_FROSTING_TYPE);
        map.put("ORANGE_FROSTING", ORANGE_FROSTING_TYPE);
        map.put("BLUEBERRY_FROSTING", BLUEBERRY_FROSTING_TYPE);
        map.put("PEAR_FROSTING", PEAR_FROSTING_TYPE);
        map.put("CHOCOLATE_GLAZING", CHOCOLATE_GLAZING_TYPE);
        map.put("DARK_CHOCOLATE_GLAZING", DARK_CHOCOLATE_GLAZING_TYPE);
        map.put("WHITE_CHOCOLATE_GLAZING", WHITE_CHOCOLATE_GLAZING_TYPE);
        map.put("CARAMEL_CHOCOLATE_GLAZING", CARAMEL_CHOCOLATE_GLAZING_TYPE);
        map.put("RUBY_CHOCOLATE_GLAZING", RUBY_CHOCOLATE_GLAZING_TYPE);
        map.trim();
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, DionsBitsnBobs.rl(name), type);
    }

    @ApiStatus.Internal
    public static void init() {
    }
}