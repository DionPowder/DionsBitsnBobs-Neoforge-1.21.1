package net.dionpowder.dions_bitsnbobs.datagen.create;

import com.simibubi.create.api.data.recipe.DeployingRecipeGen;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class DeployingRecipeProvider extends DeployingRecipeGen {
    public DeployingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, DionsBitsnBobs.MOD_ID);
    }

    GeneratedRecipe

    SUGAR_DONUT = create("sugar_donut", b -> b
            .require(ModItems.DONUT)
            .require(Items.SUGAR)
            .output(ModItems.SUGAR_DONUT)),

    SPRINKLED_WHITE_CHOCOLATE_DONUT = create("sprinkled_white_chocolate_donut", b -> b
            .require(ModItems.WHITE_CHOCOLATE_DONUT)
            .require(ModItems.BOTTLED_RAINBOW_SPRINKLES)
            .output(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT))

    ;

}
