package net.dionpowder.dions_bitsnbobs.effect;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DionsBitsnBobs.MOD_ID);

    public static final Holder<MobEffect> SUGAR_RUSH_EFFECT = MOB_EFFECTS.register("sugar_rush",
            () -> new SugarRushEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }


}
