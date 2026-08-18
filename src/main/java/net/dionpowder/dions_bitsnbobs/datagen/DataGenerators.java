package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.datagen.create.*;
import net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.BlueberryFrostingRecipeProvider;
import net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.OrangeFrostingRecipeProvider;
import net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.PearFrostingRecipeProvider;
import net.dionpowder.dions_bitsnbobs.datagen.dions_bitsnbobs.StrawberryFrostingRecipeProvider;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.DionsBitsnBobsAdvancements;
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

        // generates recipes
        generator.addProvider(event.includeServer(), new RecipeProvider(packOutput, lookupProvider));
        // generate create recipes
        generator.addProvider(event.includeServer(), new CompactingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new CrushingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new DeployingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new EmptyingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new FillingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new MixingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new PressingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new SequencedAssemblyRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new WashingRecipeProvider(packOutput, lookupProvider));
        // generate dions_bitsnbobs recipes
        generator.addProvider(event.includeServer(), new StrawberryFrostingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new OrangeFrostingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new BlueberryFrostingRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new PearFrostingRecipeProvider(packOutput, lookupProvider));

        // advancements
        generator.addProvider(event.includeServer(), new DionsBitsnBobsAdvancements(packOutput, lookupProvider));

        // generates tags
        BlockTagsProvider blockTagsProvider = new BlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new FluidTagsProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new DatapackProvider(packOutput, lookupProvider));
    }
}