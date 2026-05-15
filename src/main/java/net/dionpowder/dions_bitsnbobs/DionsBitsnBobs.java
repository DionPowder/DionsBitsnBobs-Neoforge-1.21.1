package net.dionpowder.dions_bitsnbobs;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.utils.ModHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.fml.ModLoadingContext;
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
    public static final String NAME = "Create: Dion's Bits n' Bobs!";
    public static final String MOD_ID = "dions_bitsnbobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    // create
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(DionsBitsnBobs.MOD_ID);

    public DionsBitsnBobs(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        // create registrate system
        REGISTRATE.registerEventListeners(modEventBus);
        ModSetup.register(modEventBus, modLoadingContext);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ModHelper.registerFluidDispenseBehavior(ModFluids.STRAWBERRY_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.ORANGE_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.BLUEBERRY_FROSTING_BUCKET.get());
        ModHelper.registerFluidDispenseBehavior(ModFluids.PEAR_FROSTING_BUCKET.get());
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
