package net.dionpowder.dions_bitsnbobs.item;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.block.ModBlocks;
import net.dionpowder.dions_bitsnbobs.item.custom.ChorusJamDonutItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DionsBitsnBobs.MOD_ID);

    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.STRAWBERRY)));

    public static final DeferredItem<Item> CHORUS_JAM_DONUT = ITEMS.register("chorus_jam_donut",
            () -> new ChorusJamDonutItem(new ChorusJamDonutItem.Properties().food(ModFoodProperties.CHORUS_JAM_DONUT)));

    public static void register(IEventBus eventBus) {
       ITEMS.register(eventBus);
    }
}
