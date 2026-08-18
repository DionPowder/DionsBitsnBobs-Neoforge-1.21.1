package net.dionpowder.dions_bitsnbobs.content.block;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dionpowder.dions_bitsnbobs.content.block.custom.DonutCast;
import net.dionpowder.dions_bitsnbobs.content.block.custom.StrawberryBush;
import net.dionpowder.dions_bitsnbobs.content.block.custom.WildStrawberryBush;
import net.dionpowder.dions_bitsnbobs.content.item.DionsBitsnBobsItems;
import net.dionpowder.dions_bitsnbobs.utils.DionsBitsnBobsTags;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;

import static net.dionpowder.dions_bitsnbobs.DionsBitsnBobs.REGISTRATE;

public class DionsBitsnBobsBlocks {
    
    
    
    public static final BlockEntry<Block> STRAWBERRY_CRATE =
            REGISTRATE.block("strawberry_crate", Block::new)
                    .initialProperties(SharedProperties::wooden)
                    .properties(p -> p.mapColor(MapColor.WOOD)
                            .requiresCorrectToolForDrops())
                    .blockstate((c, p) -> p.simpleBlock(c.get(), AssetLookup.standardModel(c, p)))
                    .tag(Tags.Blocks.STORAGE_BLOCKS, DionsBitsnBobsTags.Blocks.STORAGE_BLOCKS_STRAWBERRY, BlockTags.MINEABLE_WITH_AXE)
                    .loot(RegistrateBlockLootTables::dropSelf)
                    .item()
                    .tag(Tags.Items.STORAGE_BLOCKS)
                    .build()
                    .register();
    
    public static final BlockEntry<WildStrawberryBush> WILD_STRAWBERRY_BUSH =
            REGISTRATE.block("wild_strawberry_bush", WildStrawberryBush::new)
                    .properties(p -> BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH))
                    .blockstate((c, p) -> p.simpleBlock(c.get(), AssetLookup.standardModel(c, p)))
                    .loot((lt, block) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
                        
                        lt.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                                .when(ExplosionCondition.survivesExplosion())
                                        .add(LootItem.lootTableItem(DionsBitsnBobsItems.STRAWBERRY.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))));
                    })
                    .simpleItem()
                    .register();
    
    public static final BlockEntry<StrawberryBush> STRAWBERRY_BUSH =
            REGISTRATE.block("strawberry_bush", StrawberryBush::new)
                    .properties(p -> BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH))
                    .blockstate((c, p) -> p.simpleBlock(c.get(), AssetLookup.standardModel(c, p)))
                    .loot((lt, block) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
                        
                        lt.add(block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(DionsBitsnBobsBlocks.STRAWBERRY_BUSH.get())
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                        ).add(LootItem.lootTableItem(DionsBitsnBobsItems.STRAWBERRY.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))
                        ).withPool(LootPool.lootPool().when(
                                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(DionsBitsnBobsBlocks.STRAWBERRY_BUSH.get())
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                        ).add(LootItem.lootTableItem(DionsBitsnBobsItems.STRAWBERRY.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE)))));
                    })
                    .simpleItem()
                    .register();
    
    public static final BlockEntry<Block>
        ANDESITE_COMPONENT = component("andesite_component"),
        BRASS_COMPONENT = component("brass_component"),
        COPPER_COMPONENT = component("copper_component"),
        TRAIN_COMPONENT = component("train_component");
    
    public static final BlockEntry<DonutCast>
        DONUT_CAST = donutCast("donut_cast", 8),
        FILLED_DONUT_CAST = donutCast("filled_donut_cast", 1),
        COOKED_DONUT_CAST = donutCast("cooked_donut_cast", 1);
    
    // shortcuts
    
    private static BlockEntry<Block> component(String name) {
        return REGISTRATE.block(name, Block::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.mapColor(MapColor.COLOR_GRAY)
                        .requiresCorrectToolForDrops())
                .blockstate((c, p) -> p.simpleBlock(c.get(), AssetLookup.standardModel(c, p)))
                .tag(BlockTags.MINEABLE_WITH_AXE, BlockTags.NEEDS_IRON_TOOL, AllTags.AllBlockTags.WRENCH_PICKUP.tag)
                .loot(RegistrateBlockLootTables::dropSelf)
                .simpleItem()
                .register();
    }
    
    private static BlockEntry<DonutCast> donutCast(String name, int stackSize) {
        return REGISTRATE.block(name, DonutCast::new)
                .properties(p -> BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion())
                .blockstate((c, p) -> p.simpleBlock(c.get(), AssetLookup.standardModel(c, p)))
                .loot(RegistrateBlockLootTables::dropSelf)
                .item()
                .properties(p -> p.stacksTo(stackSize))
                .build()
                .register();
    }

    public static void register(IEventBus eventBus){
    
    }
}
