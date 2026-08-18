package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.fluid.DionsBitsnBobsFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.dionpowder.dions_bitsnbobs.utils.DionsBitsnBobsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {


    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, DionsBitsnBobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(DionsBitsnBobsTags.Items.ROOTED_DIRT_MIXING)
                .add(Items.HANGING_ROOTS)
                .add(Items.DEAD_BUSH);

        tag(DionsBitsnBobsTags.Items.UNPROCESSED_COMPONENTS)
                .add(DionsBitsnBobsItems.UNPROCESSED_ANDESITE_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_BRASS_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_COPPER_COMPONENT.get())
                .add(DionsBitsnBobsItems.UNPROCESSED_TRAIN_COMPONENT.get());

        tag(DionsBitsnBobsTags.Items.BAKER_FROSTING_TRADES)
                .add(DionsBitsnBobsFluids.BLUEBERRY_FROSTING.get().getBucket())
                .add(DionsBitsnBobsFluids.PEAR_FROSTING.get().getBucket())
                .add(DionsBitsnBobsFluids.STRAWBERRY_FROSTING.get().getBucket())
                .add(DionsBitsnBobsFluids.ORANGE_FROSTING.get().getBucket());

        tag(DionsBitsnBobsTags.Items.BAKER_CHOCOLATE_TRADES)
                .add(AllFluids.CHOCOLATE.get().getBucket())
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel_bucket"));

    }
}
