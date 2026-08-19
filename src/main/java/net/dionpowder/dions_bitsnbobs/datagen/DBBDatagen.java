package net.dionpowder.dions_bitsnbobs.datagen;

import com.google.gson.JsonElement;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.datagen.recipes.SequencedAssemblyRecipeProvider;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.DBBAdvancements;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class DBBDatagen {
    public static void gatherDataHighPriority(GatherDataEvent event) {
        if (event.getMods().contains(DBB.MOD_ID)) addExtraRegistrateData();
    }
    
    public static void gatherData(GatherDataEvent event) {
        if (!event.getMods().contains(DBB.MOD_ID))
            return;
        
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        generator.addProvider(event.includeServer(), new DBBAdvancements(output, lookupProvider));
        generator.addProvider(event.includeServer(), new SequencedAssemblyRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new DBBVanillaRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new DBBDatapackProvider(output, lookupProvider));
        
        
        if (event.includeServer()) {
            DBBRecipeProvider.registerAllProcessing(generator, output, lookupProvider);
        }
    }
    
    private static void addExtraRegistrateData() {
        DatagenTags.addGenerators();
        
        DBB.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;
            
            DBBAdvancements.provideLang(langConsumer);
            //new TagLangGenerator(langConsumer).generate();
        });
    }
    
}
