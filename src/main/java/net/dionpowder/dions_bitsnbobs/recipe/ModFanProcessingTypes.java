package net.dionpowder.dions_bitsnbobs.recipe;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;

import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.recipe.fan.BlueberryFrostingType;
import net.dionpowder.dions_bitsnbobs.recipe.fan.OrangeFrostingType;
import net.dionpowder.dions_bitsnbobs.recipe.fan.PearFrostingType;
import net.dionpowder.dions_bitsnbobs.recipe.fan.StrawberryFrostingType;
import net.minecraft.core.Registry;
import org.jetbrains.annotations.ApiStatus;

public class ModFanProcessingTypes {
    public static final StrawberryFrostingType STRAWBERRY_FROSTING_TYPE = register("strawberry_frosting", new StrawberryFrostingType());
    public static final OrangeFrostingType ORANGE_FROSTING_TYPE = register("orange_frosting", new OrangeFrostingType());
    public static final BlueberryFrostingType BLUEBERRY_FROSTING_TYPE = register("blueberry_frosting", new BlueberryFrostingType());
    public static final PearFrostingType PEAR_FROSTING_TYPE = register("pear_frosting", new PearFrostingType());

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("STRAWBERRY_FROSTING", STRAWBERRY_FROSTING_TYPE);
        map.put("ORANGE_FROSTING", ORANGE_FROSTING_TYPE);
        map.put("BLUEBERRY_FROSTING", BLUEBERRY_FROSTING_TYPE);
        map.put("PEAR_FROSTING", PEAR_FROSTING_TYPE);
        map.trim();
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, DionsBitsnBobs.rl(name), type);
    }

    @ApiStatus.Internal
    public static void init() {
    }
}