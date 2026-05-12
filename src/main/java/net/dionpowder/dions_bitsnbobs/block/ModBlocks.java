package net.dionpowder.dions_bitsnbobs.block;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.custom.StrawberryBush;
import net.dionpowder.dions_bitsnbobs.block.custom.WildStrawberryBush;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DionsBitsnBobs.MOD_ID);

    public static final DeferredBlock<Block> STRAWBERRY_CRATE = registerBlock("strawberry_crate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
                    ));

    public static final DeferredBlock<Block> WILD_STRAWBERRY_BUSH = registerBlock("wild_strawberry_bush",
            () -> new WildStrawberryBush(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    public static final DeferredBlock<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush",
            () -> new StrawberryBush(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));

    private static<T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
