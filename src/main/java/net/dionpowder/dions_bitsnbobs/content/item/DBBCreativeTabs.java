package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static net.dionpowder.dions_bitsnbobs.DBB.*;

public class DBBCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_TAB = REGISTER.register("base_tab", () -> CreativeModeTab.builder()
            .title(Component.translatableWithFallback("itemGroup." + MOD_ID + ".base", NAME))
            .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .icon(DBBItems.STRAWBERRY::asStack)
            .build());

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
    
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        
        List<ItemProviderEntry<?, ?>> simpleExclusions = List.of(
                DBBBlocks.WILD_STRAWBERRY_BUSH
        );
        
        if (event.getTabKey().equals(DBBCreativeTabs.BASE_TAB.getKey()))
            for (var entry : REGISTRATE.getAll(Registries.ITEM)) {
                Item item = entry.get();
                
                boolean excluded = simpleExclusions.stream()
                        .anyMatch(exclusion -> exclusion.get().asItem() == item);
                
                if (excluded || item instanceof SequencedAssemblyItem) {
                    event.remove(
                            item.getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
                    );
                }
            }
    }
    
}
