package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DionsBitsnBobsBiomeModifiers;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DionsBitsnBobsConfiguredFeatures;
import net.dionpowder.dions_bitsnbobs.content.worldgen.DionsBitsnBobsPlacedFeatures;
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
            .add(Registries.CONFIGURED_FEATURE, DionsBitsnBobsConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DionsBitsnBobsPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DionsBitsnBobsBiomeModifiers::bootstrap);

    public DatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DionsBitsnBobs.MOD_ID));
    }
}