package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.STRAWBERRY_CRATE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ANDESITE_COMPONENT.get())
                .add(ModBlocks.BRASS_COMPONENT.get())
                .add(ModBlocks.COPPER_COMPONENT.get())
                .add(ModBlocks.TRAIN_COMPONENT.get())
                .add(ModBlocks.DONUT_CAST.get())
                .add(ModBlocks.FILLED_DONUT_CAST.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANDESITE_COMPONENT.get())
                .add(ModBlocks.BRASS_COMPONENT.get())
                .add(ModBlocks.COPPER_COMPONENT.get())
                .add(ModBlocks.TRAIN_COMPONENT.get());

        tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
                .add(ModBlocks.ANDESITE_COMPONENT.get())
                .add(ModBlocks.BRASS_COMPONENT.get())
                .add(ModBlocks.COPPER_COMPONENT.get())
                .add(ModBlocks.TRAIN_COMPONENT.get());

        tag(ModTags.Blocks.STORAGE_BLOCKS).add(ModBlocks.STRAWBERRY_CRATE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_STRAWBERRY).add(ModBlocks.STRAWBERRY_CRATE.get());

        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING)
                .add(ModFluids.STRAWBERRY_FROSTING_BLOCK.get());
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_ORANGE_FROSTING)
                .add(ModFluids.ORANGE_FROSTING_BLOCK.get());
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_BLUEBERRY_FROSTING)
                .add(ModFluids.BLUEBERRY_FROSTING_BLOCK.get());
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)
                .add(ModFluids.PEAR_FROSTING_BLOCK.get());

        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource().defaultFluidState().createLegacyBlock().getBlock());
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        tag(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));

    }
}
