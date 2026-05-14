package net.dionpowder.dions_bitsnbobs;

import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.effect.ModEffects;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.item.ModCreativeModeTabs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;

public class ModSetup {
    public static void register(IEventBus modEventBus, ModLoadingContext modLoadingContext) {

        // other register methods
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluids.register(modEventBus);

        ModEffects.register(modEventBus);
    }
}
