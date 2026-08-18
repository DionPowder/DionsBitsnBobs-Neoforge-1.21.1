package net.dionpowder.dions_bitsnbobs.compat;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.neoforged.bus.api.IEventBus;

public class OptionalModCompat {
    public static void register(IEventBus modEventBus) {
        if (!ModCompat.CREATE_CONFECTIONERY_LOADED) return;
        // register recipe types, events etc.
        DBB.LOGGER.debug("Create Confectionery is loaded");
    }
}