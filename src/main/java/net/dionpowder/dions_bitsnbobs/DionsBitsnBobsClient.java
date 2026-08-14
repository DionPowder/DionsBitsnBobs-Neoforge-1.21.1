package net.dionpowder.dions_bitsnbobs;

import net.dionpowder.dions_bitsnbobs.content.fluid.BaseFluidType;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluidTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = DionsBitsnBobs.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = DionsBitsnBobs.MOD_ID, value = Dist.CLIENT)
public class DionsBitsnBobsClient {
    public DionsBitsnBobsClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
       event.enqueueWork(() -> {
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.SOURCE_STRAWBERRY_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.FLOWING_STRAWBERRY_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.SOURCE_ORANGE_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.FLOWING_ORANGE_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.SOURCE_BLUEBERRY_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.FLOWING_BLUEBERRY_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.SOURCE_PEAR_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.FLOWING_PEAR_FROSTING.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.SOURCE_DONUT_BATTER.get(), RenderType.TRANSLUCENT);
           ItemBlockRenderTypes.setRenderLayer(DionsBitsnBobsFluids.FLOWING_DONUT_BATTER.get(), RenderType.TRANSLUCENT);
       });
    }

    @SubscribeEvent
    public static void onClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(((BaseFluidType) DionsBitsnBobsFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                DionsBitsnBobsFluidTypes.STRAWBERRY_FROSTING_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) DionsBitsnBobsFluidTypes.ORANGE_FROSTING_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                DionsBitsnBobsFluidTypes.ORANGE_FROSTING_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) DionsBitsnBobsFluidTypes.BLUEBERRY_FROSTING_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                DionsBitsnBobsFluidTypes.BLUEBERRY_FROSTING_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) DionsBitsnBobsFluidTypes.PEAR_FROSTING_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                DionsBitsnBobsFluidTypes.PEAR_FROSTING_FLUID_TYPE.get());
        event.registerFluidType(((BaseFluidType) DionsBitsnBobsFluidTypes.DONUT_BATTER_FLUID_TYPE.get()).getClientFluidTypeExtensions(),
                DionsBitsnBobsFluidTypes.DONUT_BATTER_FLUID_TYPE.get());
    }
}
