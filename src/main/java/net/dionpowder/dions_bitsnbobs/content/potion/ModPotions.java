package net.dionpowder.dions_bitsnbobs.content.potion;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, DionsBitsnBobs.MOD_ID);

    public static final Holder<Potion> SUGAR_RUSH_POTION = POTIONS.register("sugar_rush_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SUGAR_RUSH_EFFECT, 1800, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
