package net.dionpowder.dions_bitsnbobs.content.villager;

import com.google.common.collect.ImmutableSet;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, DionsBitsnBobs.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, DionsBitsnBobs.MOD_ID);

    public static final Holder<PoiType> BAKER_POI = POI_TYPES.register("baker_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.STRAWBERRY_CRATE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> BAKER = VILLAGER_PROFESSIONS.register("baker",
            () -> new VillagerProfession("baker", holder -> holder.value() == BAKER_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == BAKER_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
