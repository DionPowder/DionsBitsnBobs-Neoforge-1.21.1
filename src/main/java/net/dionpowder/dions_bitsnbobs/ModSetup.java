package net.dionpowder.dions_bitsnbobs;

import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.compat.OptionalModCompat;
import net.dionpowder.dions_bitsnbobs.content.effect.ModEffects;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluidTypes;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.item.ModCreativeModeTabs;
import net.dionpowder.dions_bitsnbobs.content.item.ModItems;
import net.dionpowder.dions_bitsnbobs.content.potion.ModPotions;
import net.dionpowder.dions_bitsnbobs.content.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.content.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;

public class ModSetup {
    public static void register(IEventBus modEventBus, ModLoadingContext modLoadingContext) {

        OptionalModCompat.register(modEventBus);
        // other register methods
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModRecipeTypes.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModVillagers.register(modEventBus);
    }
}
