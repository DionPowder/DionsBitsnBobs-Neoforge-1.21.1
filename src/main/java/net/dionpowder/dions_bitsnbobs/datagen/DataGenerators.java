package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.datagen.create.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = DionsBitsnBobs.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // generates loot tables
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        // generates recipes
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        // generate create recipes
        generator.addProvider(event.includeServer(), new CompactingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new CrushingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new DeployingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new FillingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new MixingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new PressingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new SequencedAssemblyRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new WashingRecipeProvider(packOutput, lookupProvider));

        // generates tags
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModDatapackProvider(packOutput, lookupProvider));
    }
}