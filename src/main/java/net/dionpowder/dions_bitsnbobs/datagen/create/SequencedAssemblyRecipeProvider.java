package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class SequencedAssemblyRecipeProvider extends SequencedAssemblyRecipeGen {
    public SequencedAssemblyRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    COPPER_COMPONENT = create("copper_component", b -> b
            .require(AllBlocks.COPPER_CASING.get())
            .transitionTo(AllBlocks.COPPER_CASING.get())
            .addOutput(ModBlocks.COPPER_COMPONENT, 1)
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(PressingRecipe::new, rb -> rb)),

    TRAIN_COMPONENT = create("train_component", b -> b
            .require(AllBlocks.RAILWAY_CASING.get())
            .transitionTo(AllBlocks.RAILWAY_CASING.get())
            .addOutput(ModBlocks.TRAIN_COMPONENT, 1)
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM.get()))
            .addStep(PressingRecipe::new, rb -> rb))

    ;
}
