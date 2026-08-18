package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DBBBiomeModifiers;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DBBConfiguredFeatures;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DBBPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, DBBConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DBBPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DBBBiomeModifiers::bootstrap);

    public DatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DBB.MOD_ID));
    }
}