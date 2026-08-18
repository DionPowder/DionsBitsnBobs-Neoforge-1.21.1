package net.dionpowder.dions_bitsnbobs;

import net.dionpowder.dions_bitsnbobs.content.block.DionsBitsnBobsBlocks;
import net.dionpowder.dions_bitsnbobs.compat.OptionalModCompat;
import net.dionpowder.dions_bitsnbobs.content.effect.DionsBitsnBobsEffects;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluidTypes;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsCreativeModeTabs;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.dionpowder.dions_bitsnbobs.content.potion.DionsBitsnBobsPotions;
import net.dionpowder.dions_bitsnbobs.content.recipe.DionsBitsnBobsRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.villager.DionsBitsnBobsVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;

public class DionsBitsnBobsSetup {
    public static void register(IEventBus modEventBus, ModLoadingContext modLoadingContext) {

        OptionalModCompat.register(modEventBus);
        // other register methods
        //DionsBitsnBobsCreativeModeTabs.register(modEventBus);

        DionsBitsnBobsItems.register(modEventBus);
        DionsBitsnBobsBlocks.register(modEventBus);

        //DionsBitsnBobsFluidTypes.register(modEventBus);
        DionsBitsnBobsFluids.register(modEventBus);

        DionsBitsnBobsRecipeTypes.register(modEventBus);

        DionsBitsnBobsEffects.register(modEventBus);
        DionsBitsnBobsPotions.register(modEventBus);

        DionsBitsnBobsVillagers.register(modEventBus);
    }
}
