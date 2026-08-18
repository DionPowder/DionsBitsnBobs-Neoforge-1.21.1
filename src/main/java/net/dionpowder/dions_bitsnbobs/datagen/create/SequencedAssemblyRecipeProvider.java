package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

public class SequencedAssemblyRecipeProvider extends SequencedAssemblyRecipeGen {
    public SequencedAssemblyRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    ANDESITE_COMPONENT = create("andesite_component", b -> b
            .require(AllBlocks.ANDESITE_CASING)
            .transitionTo(DBBItems.UNPROCESSED_ANDESITE_COMPONENT)
            .addOutput(DBBBlocks.ANDESITE_COMPONENT, 85)
            .addOutput(AllBlocks.ANDESITE_CASING, 6)
            .addOutput(AllItems.PRECISION_MECHANISM, 3)
            .addOutput(AllItems.ELECTRON_TUBE, 3)
            .addOutput(DBBItems.NETHERITE_DUST, 3)
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(DBBItems.NETHERITE_DUST))
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 1000))
            .addStep(PressingRecipe::new, rb -> rb)),

    BRASS_COMPONENT = create("brass_component", b -> b
            .require(AllBlocks.BRASS_CASING)
            .transitionTo(DBBItems.UNPROCESSED_BRASS_COMPONENT)
            .addOutput(DBBBlocks.BRASS_COMPONENT, 85)
            .addOutput(AllBlocks.BRASS_CASING, 6)
            .addOutput(AllItems.PRECISION_MECHANISM, 3)
            .addOutput(AllItems.ELECTRON_TUBE, 3)
            .addOutput(DBBItems.NETHERITE_DUST, 3)
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(DBBItems.NETHERITE_DUST))
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 1000))
            .addStep(PressingRecipe::new, rb -> rb)),

    COPPER_COMPONENT = create("copper_component", b -> b
            .require(AllBlocks.COPPER_CASING)
            .transitionTo(DBBItems.UNPROCESSED_COPPER_COMPONENT)
            .addOutput(DBBBlocks.COPPER_COMPONENT, 85)
            .addOutput(AllBlocks.COPPER_CASING, 6)
            .addOutput(AllItems.PRECISION_MECHANISM, 3)
            .addOutput(AllItems.ELECTRON_TUBE, 3)
            .addOutput(DBBItems.NETHERITE_DUST, 3)
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(DBBItems.NETHERITE_DUST))
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 1000))
            .addStep(PressingRecipe::new, rb -> rb)),

    TRAIN_COMPONENT = create("train_component", b -> b
            .require(AllBlocks.RAILWAY_CASING)
            .transitionTo(DBBItems.UNPROCESSED_TRAIN_COMPONENT)
            .addOutput(DBBBlocks.TRAIN_COMPONENT, 85)
            .addOutput(AllBlocks.RAILWAY_CASING, 6)
            .addOutput(AllItems.PRECISION_MECHANISM, 3)
            .addOutput(AllItems.ELECTRON_TUBE, 3)
            .addOutput(DBBItems.NETHERITE_DUST, 3)
            .loops(1)
            .addStep(CuttingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.PRECISION_MECHANISM))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(DBBItems.NETHERITE_DUST))
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 1000))
            .addStep(PressingRecipe::new, rb -> rb)),

    NETHERITE_SCRAP = create("netherite_scrap", b -> b
            .require(DBBItems.NETHERITE_DUST)
            .transitionTo(DBBItems.UNPROCESSED_NETHERITE_DUST)
            .addOutput(Items.NETHERITE_SCRAP, 120)
            .addOutput(AllItems.POWDERED_OBSIDIAN, 8)
            .addOutput(AllItems.CINDER_FLOUR, 8)
            .loops(5)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.EXP_NUGGET))
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 500))
            .addStep(PressingRecipe::new, rb -> rb)),

    MAGMA_BLOCK = create("magma_block", b -> b
            .require(Blocks.COBBLESTONE)
            .transitionTo(DBBItems.UNPROCESSED_MAGMA_BLOCK)
            .addOutput(Blocks.MAGMA_BLOCK, 95)
            .addOutput(Blocks.COBBLESTONE, 5)
            .loops(5)
            .addStep(FillingRecipe::new, rb -> rb.require(Fluids.LAVA, 500))
            .addStep(PressingRecipe::new, rb -> rb)
            .addStep(PressingRecipe::new, rb -> rb))

    ;
}
