package net.dionpowder.dions_bitsnbobs;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.dionpowder.dions_bitsnbobs.config.DionsBitsnBobsConfig;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBCreativeModeTabs;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.DBBAdvancements;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.DBBTriggers;
import net.dionpowder.dions_bitsnbobs.content.recipe.BulkRecipeGen;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBFanProcessingTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DBB.MOD_ID)
public class DBB {
    public static final String NAME = "Create: Dion's Bits 'n' Bobs!";
    public static final String MOD_ID = "dions_bitsnbobs";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(DBB.MOD_ID);

    public DBB(IEventBus modEventBus, ModContainer modContainer) {
        REGISTRATE.registerEventListeners(modEventBus);
        REGISTRATE.defaultCreativeTab(DBBCreativeModeTabs.BITSNBOBS_ITEMS_TAB, "bitsnbobs_items_tab");

        NeoForge.EVENT_BUS.register(this);
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        // register config
        modEventBus.register(new DionsBitsnBobsConfig(modContainer));
        
        DBBSetup.register(modEventBus, modLoadingContext);
        
        // add listeners
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(DBB::onRegister);

    }

    // Register advancements
    public static void onRegister(final RegisterEvent event) {
        DBBFanProcessingTypes.init();
        if (event.getRegistry() == BuiltInRegistries.TRIGGER_TYPES) {
            DBBAdvancements.register();
            DBBTriggers.register();
        }
    }

    @SubscribeEvent
    public void onAddReloadListeners(AddReloadListenerEvent event) {
        RecipeManager manager = event.getServerResources().getRecipeManager();

        event.addListener(new SimplePreparableReloadListener<Void>() {
            @Override
            protected Void prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
                return null;
            }

            @Override
            protected void apply(Void object, ResourceManager resourceManager, ProfilerFiller profiler) {
                BulkRecipeGen.rebuild(manager);
            }
        });
    }


    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(DBB.MOD_ID, path);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        DBBFluids.registerFluidInteractions();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
