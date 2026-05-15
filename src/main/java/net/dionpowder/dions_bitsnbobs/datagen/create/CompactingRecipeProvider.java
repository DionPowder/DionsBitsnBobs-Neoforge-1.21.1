package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllFluids;
import com.simibubi.create.api.data.recipe.CompactingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

public class CompactingRecipeProvider extends CompactingRecipeGen {
    public CompactingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    COBBLED_DEEPSLATE = create("cobbled_deepslate", b -> b
            .require(Items.COBBLESTONE)
            .require(Items.COBBLESTONE)
            .require(Fluids.LAVA, 100)
            .output(Items.COBBLED_DEEPSLATE)),

    TUFF = create("tuff", b -> b
            .require(Items.ANDESITE)
            .require(Items.DIORITE)
            .require(Fluids.LAVA, 50)
            .output(Items.TUFF, 2)),

    DRIPSTONE_BLOCK = create("dripstone_block", b -> b
            .require(Items.ANDESITE)
            .require(Items.TUFF)
            .require(Fluids.WATER, 250)
            .output(Items.DRIPSTONE_BLOCK, 2)),

    HONEYCOMB = create("honeycomb", b -> b
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(AllFluids.HONEY.get(), 100)
            .output(Items.HONEYCOMB)),

    EMERALD = create("emerald", b -> b
            .require(Items.COAL_BLOCK)
            .require(Items.LIME_DYE)
            .require(Fluids.LAVA, 250)
            .output(Items.EMERALD)),

    DIAMOND = create("diamond", b -> b
            .require(Items.COAL_BLOCK)
            .require(Fluids.LAVA, 250)
            .output(Items.DIAMOND))

    ;

}
