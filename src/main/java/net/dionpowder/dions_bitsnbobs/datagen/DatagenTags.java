package net.dionpowder.dions_bitsnbobs.datagen;

import com.simibubi.create.AllFluids;
import com.simibubi.create.foundation.data.TagGen.CreateTagsProvider;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

public class DatagenTags {
    
    public static void addGenerators() {
        REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, DatagenTags::genBlockTags);
        REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, DatagenTags::genItemTags);
        REGISTRATE.addDataGenerator(ProviderType.FLUID_TAGS, DatagenTags::genFluidTags);
    }
    
    private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
        CreateTagsProvider<Item> prov = new CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);
        
        prov.tag(DBBTags.Items.ROOTED_DIRT_MIXING)
                .add(Items.HANGING_ROOTS)
                .add(Items.DEAD_BUSH);
        
        prov.tag(DBBTags.Items.UNPROCESSED_COMPONENTS)
                .add(DBBItems.UNPROCESSED_ANDESITE_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_BRASS_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_COPPER_COMPONENT.get())
                .add(DBBItems.UNPROCESSED_TRAIN_COMPONENT.get());
        
        prov.tag(DBBTags.Items.BAKER_FROSTING_TRADES)
                .add(DBBFluids.BLUEBERRY_FROSTING.get().getBucket())
                .add(DBBFluids.PEAR_FROSTING.get().getBucket())
                .add(DBBFluids.STRAWBERRY_FROSTING.get().getBucket())
                .add(DBBFluids.ORANGE_FROSTING.get().getBucket());
        
        prov.tag(DBBTags.Items.BAKER_CHOCOLATE_TRADES)
                .add(AllFluids.CHOCOLATE.get().getBucket())
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate_bucket"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel_bucket"));
        
    }
    
    private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
        CreateTagsProvider<Block> prov = new CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);
        
        prov.tag(BlockTags.MINEABLE_WITH_PICKAXE)
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
        
        prov.tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource().defaultFluidState().createLegacyBlock().getBlock());
        prov.tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        prov.tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        prov.tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        prov.tag(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));
        
    }
    
    private static void genFluidTags(RegistrateTagsProvider<Fluid> provIn) {
        CreateTagsProvider<Fluid> prov = new CreateTagsProvider<>(provIn, Fluid::builtInRegistryHolder);
        
        prov.tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)
                .add(AllFluids.CHOCOLATE.get().getSource());
        prov.tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_DARK_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "black_chocolate"));
        prov.tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_WHITE_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "white_chocolate"));
        prov.tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_CARAMEL_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "caramel"));
        prov.tag(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_RUBY_CHOCOLATE_GLAZING)
                .addOptional(ResourceLocation.fromNamespaceAndPath("create_confectionery", "ruby_chocolate"));
        
    }
    
}
