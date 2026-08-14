package net.dionpowder.dions_bitsnbobs.content.effect;

import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.dionpowder.dions_bitsnbobs.content.effect.custom.SugarRushEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DionsBitsnBobsEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, DionsBitsnBobs.MOD_ID);

    public static final Holder<MobEffect> SUGAR_RUSH_EFFECT = MOB_EFFECTS.register("sugar_rush",
            () -> new SugarRushEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "sugar_rush"), 0.6f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.BLOCK_BREAK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(DionsBitsnBobs.MOD_ID, "sugar_rush"), 1.0f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }


}
