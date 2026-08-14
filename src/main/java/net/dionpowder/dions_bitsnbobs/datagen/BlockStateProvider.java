package net.dionpowder.dions_bitsnbobs.datagen;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.DionsBitsnBobsBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DionsBitsnBobs.MOD_ID, exFileHelper);
    }

    private String blockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public ResourceLocation resourceFDBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    @Override
    protected void registerStatesAndModels() {
        // generate mod blocks
        crateBlock(DionsBitsnBobsBlocks.STRAWBERRY_CRATE.get(), "strawberry");
        componentBlock(DionsBitsnBobsBlocks.ANDESITE_COMPONENT.get(), "andesite");
        componentBlock(DionsBitsnBobsBlocks.BRASS_COMPONENT.get(), "brass");
        componentBlock(DionsBitsnBobsBlocks.COPPER_COMPONENT.get(), "copper");
        componentBlock(DionsBitsnBobsBlocks.TRAIN_COMPONENT.get(), "train");
        // generate mod block item models
        blockItem(DionsBitsnBobsBlocks.STRAWBERRY_CRATE);
        blockItem(DionsBitsnBobsBlocks.ANDESITE_COMPONENT);
        blockItem(DionsBitsnBobsBlocks.BRASS_COMPONENT);
        blockItem(DionsBitsnBobsBlocks.COPPER_COMPONENT);
        blockItem(DionsBitsnBobsBlocks.TRAIN_COMPONENT);
    }

    public void componentBlock(Block block, String componentName) {
        this.simpleBlock(block,
                models().cubeBottomTop(blockName(block), resourceFDBlock(componentName + "_component_side"), resourceFDBlock(componentName + "_component_top"), resourceFDBlock(componentName + "_component_top")));
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block,
                models().cubeBottomTop(blockName(block), resourceFDBlock(cropName + "_crate_side"), resourceFDBlock("crate_bottom"), resourceFDBlock(cropName + "_crate_top")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("dions_bitsnbobs:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("dions_bitsnbobs:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
