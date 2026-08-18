package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DBB.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                // glass mining
                .addTag(Tags.Blocks.GLASS_BLOCKS)
                .addTag(Tags.Blocks.GLASS_BLOCKS_CHEAP)
                .addTag(Tags.Blocks.GLASS_BLOCKS_COLORLESS)
                .addTag(Tags.Blocks.GLASS_BLOCKS_TINTED)
                .addTag(Tags.Blocks.GLASS_PANES)
                .addTag(Tags.Blocks.GLASS_PANES_COLORLESS)
                // chipped
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "white_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "white_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "light_gray_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "light_gray_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "gray_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "gray_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "black_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "black_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "brown_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "brown_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "red_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "red_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "orange_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "orange_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "yellow_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "yellow_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "lime_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "lime_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "green_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "green_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "cyan_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "cyan_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "light_blue_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "light_blue_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "blue_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "blue_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "purple_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "purple_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "magenta_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "magenta_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "pink_stained_glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "pink_stained_glass"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "glass_pane"))
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("chipped", "glass"));

        tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource().defaultFluidState().createLegacyBlock().getBlock());
        tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));

    }
}
