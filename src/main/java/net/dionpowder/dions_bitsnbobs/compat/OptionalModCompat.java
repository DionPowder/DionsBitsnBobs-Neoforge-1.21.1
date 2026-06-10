package net.dionpowder.dions_bitsnbobs.compat;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.neoforged.bus.api.IEventBus;

public class OptionalModCompat {
    public static void register(IEventBus modEventBus) {
        if (!ModCompat.CREATE_CONFECTIONERY_LOADED) return;
        // register recipe types, events etc.
        DionsBitsnBobs.LOGGER.debug("Create Confectionery is loaded");
    }
}