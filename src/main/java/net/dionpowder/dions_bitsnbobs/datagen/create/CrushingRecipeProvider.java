package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.CrushingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class CrushingRecipeProvider extends CrushingRecipeGen {
    public CrushingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DBB.MOD_ID);
    }

    GeneratedRecipe

    WITHER_SKELETON_SKULL = create("wither_skeleton_skull", b -> b
            .require(Items.BLACKSTONE)
            .duration(1000)
            .output(0.005f, Items.WITHER_SKELETON_SKULL)),

    CINDER_FLOUR = create("cinder_flour", b -> b
            .require(Items.NETHER_BRICK)
            .duration(600)
            .output(0.8f, AllItems.CINDER_FLOUR)),

    LIME_DYE = create("lime_dye", b -> b
            .require(Items.WHEAT_SEEDS)
            .duration(300)
            .output(0.75f, Items.LIME_DYE)),

    POINTED_DRIPSTONE = create("pointed_dripstone", b -> b
            .require(Items.DRIPSTONE_BLOCK)
            .duration(600)
            .output(Items.POINTED_DRIPSTONE, 3)
            .output(0.5f, Items.POINTED_DRIPSTONE))

    ;
}
