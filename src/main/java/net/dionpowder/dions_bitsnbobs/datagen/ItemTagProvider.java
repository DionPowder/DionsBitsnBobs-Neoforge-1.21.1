package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
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
        super(output, lookupProvider, blockTags, DBB.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(DBBTags.Items.ROOTED_DIRT_MIXING)
                .add(Items.HANGING_ROOTS)
                .add(Items.DEAD_BUSH);

        tag(DBBTags.Items.UNPROCESSED_COMPONENTS)
                .add(DBBItems.UNPROCESSED_ANDESITE_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_BRASS_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_COPPER_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_TRAIN_COMPONENT.get());

        tag(DBBTags.Items.BAKER_FROSTING_TRADES)
                .add(DBBFluids.BLUEBERRY_FROSTING.get().getBucket())
                .add(DBBFluids.PEAR_FROSTING.get().getBucket())
                .add(DBBFluids.STRAWBERRY_FROSTING.get().getBucket())
                .add(DBBFluids.ORANGE_FROSTING.get().getBucket());

        tag(DBBTags.Items.BAKER_CHOCOLATE_TRADES)
                .add(AllFluids.CHOCOLATE.get().getBucket())
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel_bucket"));

    }
}
