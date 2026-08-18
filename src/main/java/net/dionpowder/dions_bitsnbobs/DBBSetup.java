package net.dionpowder.dions_bitsnbobs;

import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.compat.OptionalModCompat;
import net.dionpowder.dions_bitsnbobs.content.effect.DBBEffects;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.content.potion.DBBPotions;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.villager.DBBVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;

public class DBBSetup {
    public static void register(IEventBus modEventBus, ModLoadingContext modLoadingContext) {

        OptionalModCompat.register(modEventBus);
        // other register methods
        //DBBCreativeModeTabs.register(modEventBus);

        DBBItems.register(modEventBus);
        DBBBlocks.register(modEventBus);

        //DBBFluidTypes.register(modEventBus);
        DBBFluids.register(modEventBus);

        DBBRecipeTypes.register(modEventBus);

        DBBEffects.register(modEventBus);
        DBBPotions.register(modEventBus);

        DBBVillagers.register(modEventBus);
    }
}
