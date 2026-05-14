package net.dionpowder.dions_bitsnbobs.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class SugarRushEffect extends MobEffect {

    public SugarRushEffect(MobEffectCategory category, int color) {
        super(MobEffectCategory.BENEFICIAL, 0xFFFFFF);
    }



    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        // Add existing effect: Effect, Duration (in ticks), Amplifier (0 is level 1)
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0));
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
