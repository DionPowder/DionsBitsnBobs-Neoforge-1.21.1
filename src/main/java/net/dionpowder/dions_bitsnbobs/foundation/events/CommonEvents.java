package net.dionpowder.dions_bitsnbobs.foundation.events;

import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklerBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber
public class CommonEvents {
    
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        FoodSprinklerBlockEntity.registerCapabilities(event);
    }
    
}
