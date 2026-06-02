package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllTags;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
    }
}
