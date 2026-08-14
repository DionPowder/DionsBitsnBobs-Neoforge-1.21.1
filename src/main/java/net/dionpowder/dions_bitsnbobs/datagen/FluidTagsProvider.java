package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.utils.DionsBitsnBobsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FluidTagsProvider extends net.minecraft.data.tags.FluidTagsProvider {
    public FluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DionsBitsnBobsTags.Fluids.STRAWBERRY_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_STRAWBERRY_FROSTING.get())
                .add(DionsBitsnBobsFluids.FLOWING_STRAWBERRY_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.ORANGE_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_ORANGE_FROSTING.get())
                .add(DionsBitsnBobsFluids.FLOWING_ORANGE_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.BLUEBERRY_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_BLUEBERRY_FROSTING.get())
                .add(DionsBitsnBobsFluids.FLOWING_BLUEBERRY_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.PEAR_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_PEAR_FROSTING.get())
                .add(DionsBitsnBobsFluids.FLOWING_PEAR_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.DONUT_BATTER)
                .add(DionsBitsnBobsFluids.SOURCE_DONUT_BATTER.get())
                .add(DionsBitsnBobsFluids.FLOWING_DONUT_BATTER.get());

        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_STRAWBERRY_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_ORANGE_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_ORANGE_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_BLUEBERRY_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_BLUEBERRY_FROSTING.get());
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)
                .add(DionsBitsnBobsFluids.SOURCE_PEAR_FROSTING.get());

        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource());
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        tag(DionsBitsnBobsTags.Fluids.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));
    }
}
