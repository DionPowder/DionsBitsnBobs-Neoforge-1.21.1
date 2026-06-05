package net.dionpowder.dions_bitsnbobs.datagen.create;


import com.simibubi.create.AllFluids;
import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.concurrent.CompletableFuture;

public class MixingRecipeProvider extends MixingRecipeGen {
    public MixingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    NETHERITE_DUST = create("netherite_dust", b -> b
            .require(AllItems.CINDER_FLOUR)
            .require(AllItems.POWDERED_OBSIDIAN)
            .requiresHeat(HeatCondition.SUPERHEATED)
            .output(ModItems.NETHERITE_DUST)),

    PHANTOM_MEMBRANE = create("phantom_membrane", b -> b
            .require(Items.FEATHER)
            .require(Items.STRING)
            .require(Items.WHITE_DYE)
            .requiresHeat(HeatCondition.HEATED)
            .output(Items.PHANTOM_MEMBRANE)),

    DIRT = create("dirt", b -> b
            .require(Items.COARSE_DIRT)
            .require(Items.COARSE_DIRT)
            .requiresHeat(HeatCondition.HEATED)
            .output(Items.DIRT, 2)
            .output(0.5f, Items.FLINT, 2)),

    ASURINE = create("asurine", b -> b
            .require(AllPaletteStoneTypes.ASURINE.getBaseBlock().get())
            .require(Items.BASALT)
            .requiresHeat(HeatCondition.HEATED)
            .output(AllPaletteStoneTypes.ASURINE.getBaseBlock().get(), 2)),

    CRIMSITE = create("crimsite", b -> b
            .require(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get())
            .require(Items.BLACKSTONE)
            .requiresHeat(HeatCondition.HEATED)
            .output(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get(), 2)),

    OCHRUM = create("ochrum", b -> b
            .require(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get())
            .require(Items.SANDSTONE)
            .requiresHeat(HeatCondition.HEATED)
            .output(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get(), 2)),

    VERIDIUM = create("veridium", b -> b
            .require(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get())
            .require(Items.MOSSY_COBBLESTONE)
            .requiresHeat(HeatCondition.HEATED)
            .output(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get(), 2)),

    COARSE_DIRT = create("coarse_dirt", b -> b
            .require(Items.DIRT)
            .require(Items.GRAVEL)
            .output(Items.COARSE_DIRT, 2)),

    LAPIS_LAZULI = create("lapis_lazuli", b -> b
            .require(Items.QUARTZ)
            .require(Items.BLUE_DYE)
            .requiresHeat(HeatCondition.HEATED)
            .output(Items.LAPIS_LAZULI)),

    ROOTED_DIRT = create("rooted_dirt", b -> b
            .require(Items.DIRT)
            .require(Ingredient.of(ModTags.Items.ROOTED_DIRT_MIXING))
            .output(Items.ROOTED_DIRT)),

    STRAWBERRY_FROSTING = create("strawberry_frosting", b -> b
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(Items.SUGAR)
            .require(ModItems.STRAWBERRY)
            .require(ModItems.STRAWBERRY)
            .require(ModItems.STRAWBERRY)
            .require(Fluids.WATER, 150)
            .requiresHeat(HeatCondition.HEATED)
            .output(ModFluids.SOURCE_STRAWBERRY_FROSTING.get(), 250)),

    DONUT_BATTER = create("donut_batter", b -> b
            .require(Tags.Fluids.MILK, 400)
            .require(AllItems.WHEAT_FLOUR)
            .require(AllItems.WHEAT_FLOUR)
            .require(Items.SUGAR)
            .require(Ingredient.of(Tags.Items.EGGS))
            .requiresHeat(HeatCondition.HEATED)
            .duration(100)
            .output(ModFluids.SOURCE_DONUT_BATTER.get(), 500))

    ;

}
