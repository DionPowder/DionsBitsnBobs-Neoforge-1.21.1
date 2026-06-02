package net.dionpowder.dions_bitsnbobs.block;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.custom.DonutCast;
import net.dionpowder.dions_bitsnbobs.block.custom.StrawberryBush;
import net.dionpowder.dions_bitsnbobs.block.custom.WildStrawberryBush;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DionsBitsnBobs.MOD_ID);

    public static final DeferredBlock<Block> STRAWBERRY_CRATE = registerBlock(64, "strawberry_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    // components
    public static final DeferredBlock<Block> ANDESITE_COMPONENT = registerBlock(64, "andesite_component",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> BRASS_COMPONENT = registerBlock(64, "brass_component",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> COPPER_COMPONENT = registerBlock(64, "copper_component",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final DeferredBlock<Block> TRAIN_COMPONENT = registerBlock(64, "train_component",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    // bushes
    public static final DeferredBlock<Block> WILD_STRAWBERRY_BUSH = registerBlock(64, "wild_strawberry_bush",
            () -> new WildStrawberryBush(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush",
            () -> new StrawberryBush(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    // casts
    public static final DeferredBlock<Block> DONUT_CAST = registerBlock(8, "donut_cast",
            () -> new DonutCast(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion()));


    public static final DeferredBlock<Block> FILLED_DONUT_CAST = registerBlock(1, "filled_donut_cast",
            () -> new DonutCast(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS).noOcclusion()));

    private static<T extends Block> DeferredBlock<T> registerBlock(int stackSize, String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(stackSize, name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(int stacksize, String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stacksize)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
