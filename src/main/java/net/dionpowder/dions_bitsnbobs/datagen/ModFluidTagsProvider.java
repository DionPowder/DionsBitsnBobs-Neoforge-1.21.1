package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Fluids.STRAWBERRY_FROSTING)
                .add(ModFluids.SOURCE_STRAWBERRY_FROSTING.get())
                .add(ModFluids.FLOWING_STRAWBERRY_FROSTING.get());
        tag(ModTags.Fluids.ORANGE_FROSTING)
                .add(ModFluids.SOURCE_ORANGE_FROSTING.get())
                .add(ModFluids.FLOWING_ORANGE_FROSTING.get());
        tag(ModTags.Fluids.BLUEBERRY_FROSTING)
                .add(ModFluids.SOURCE_BLUEBERRY_FROSTING.get())
                .add(ModFluids.FLOWING_BLUEBERRY_FROSTING.get());
        tag(ModTags.Fluids.PEAR_FROSTING)
                .add(ModFluids.SOURCE_PEAR_FROSTING.get())
                .add(ModFluids.FLOWING_PEAR_FROSTING.get());
        tag(ModTags.Fluids.DONUT_BATTER)
                .add(ModFluids.SOURCE_DONUT_BATTER.get())
                .add(ModFluids.FLOWING_DONUT_BATTER.get());

        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING)
                .add(ModFluids.SOURCE_STRAWBERRY_FROSTING.get());
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_ORANGE_FROSTING)
                .add(ModFluids.SOURCE_ORANGE_FROSTING.get());
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_BLUEBERRY_FROSTING)
                .add(ModFluids.SOURCE_BLUEBERRY_FROSTING.get());
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)
                .add(ModFluids.SOURCE_PEAR_FROSTING.get());

        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource());
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        tag(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));
    }
}
