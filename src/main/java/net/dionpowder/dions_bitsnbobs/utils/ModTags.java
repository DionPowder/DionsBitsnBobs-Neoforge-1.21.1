package net.dionpowder.dions_bitsnbobs.utils;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS = commonBlockTag("storage_blocks");
        public static final TagKey<Block> STORAGE_BLOCKS_STRAWBERRY = commonBlockTag("storage_blocks/strawberry");

        public static final TagKey<Block> FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING = createTag("fan_processing_catalysts_strawberry_frosting");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, name));
        }

        private static TagKey<Block> commonBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Items {
        public static final TagKey<Item> DONUTS = createTag("donuts");
        public static final TagKey<Item> SIMPLE_DONUTS = createTag("simple_donuts");
        public static final TagKey<Item> FROSTING_DONUTS = createTag("frosting_donuts");
        public static final TagKey<Item> TOPPED_FROSTING_DONUTS = createTag("topped_frosting_donuts");
        public static final TagKey<Item> CHOCOLATE_DONUTS = createTag("chocolate_donuts");
        public static final TagKey<Item> TOPPED_CHOCOLATE_DONUTS = createTag("topped_chocolate_donuts");
        public static final TagKey<Item> DOUBLE_GLAZED_DONUTS = createTag("double_glazed_donuts");
        public static final TagKey<Item> SPRINKLES = createTag("sprinkles");

        public static final TagKey<Item> ADVANCEMENT_GLAZED_DONUT = createTag("advancement_glazed_donut");
        public static final TagKey<Item> ADVANCEMENT_TOPPED_DONUT = createTag("advancement_topped_donut");

        public static final TagKey<Item> CROPS = commonItemTag("crops");
        public static final TagKey<Item> CROPS_STRAWBERRY = commonItemTag("crops/strawberry");
        public static final TagKey<Item> FOODS = commonItemTag("foods");
        public static final TagKey<Item> FOODS_STRAWBERRY = commonItemTag("foods/strawberry");
        public static final TagKey<Item> FOODS_DONUTS = commonItemTag("foods/donuts");

        public static final TagKey<Item> ROOTED_DIRT_MIXING = createTag("rooted_dirt_mixing");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, name));
        }

        private static TagKey<Item> commonItemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

    }

    public static class Fluids {
        public static final TagKey<Fluid> FAN_PROCESSING_CATALYSTS_STRAWBERRY_FROSTING = createTag("fan_processing_catalysts_strawberry_frosting");

        private static TagKey<Fluid> createTag(String name) {
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, name));
        }

        private static TagKey<Fluid> commonItemTag(String path) {
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

    }
}