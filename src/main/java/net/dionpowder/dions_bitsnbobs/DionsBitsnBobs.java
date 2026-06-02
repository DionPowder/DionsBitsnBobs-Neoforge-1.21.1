package net.dionpowder.dions_bitsnbobs;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.dionpowder.dions_bitsnbobs.config.CommonConfig;
import net.dionpowder.dions_bitsnbobs.config.ServerConfig;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.AllAdvancements;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.AllTriggers;
import net.dionpowder.dions_bitsnbobs.utils.ModHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DionsBitsnBobs.MOD_ID)
public class DionsBitsnBobs {
    public static final String NAME = "Create: Dion's Bits 'n' Bobs!";
    public static final String MOD_ID = "dions_bitsnbobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    // create
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(DionsBitsnBobs.MOD_ID);

    public DionsBitsnBobs(IEventBus modEventBus, ModContainer modContainer) {
        // add listeners
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(DionsBitsnBobs::onRegister);

        NeoForge.EVENT_BUS.register(this);
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);

        // create registrate system
        REGISTRATE.registerEventListeners(modEventBus);
        ModSetup.register(modEventBus, modLoadingContext);

    }

    // Register advancements
    public static void onRegister(final RegisterEvent event) {
        if (event.getRegistry() == BuiltInRegistries.TRIGGER_TYPES) {
            AllAdvancements.register();
            AllTriggers.register();
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModHelper.registerFluidDispenseBehavior(ModFluids.STRAWBERRY_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.ORANGE_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.BLUEBERRY_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.PEAR_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.DONUT_BATTER_BUCKET.get());
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
