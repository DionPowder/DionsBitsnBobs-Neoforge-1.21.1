package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FluidTagsProvider extends net.minecraft.data.tags.FluidTagsProvider {
    public FluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, DBB.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource());
        tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));
    }
}
