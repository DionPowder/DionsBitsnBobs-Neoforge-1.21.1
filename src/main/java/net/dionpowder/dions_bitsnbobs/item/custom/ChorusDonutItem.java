package net.dionpowder.dions_bitsnbobs.item.custom;

import net.dionpowder.dions_bitsnbobs.config.ServerConfig;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.AllAdvancements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ChorusFruitItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class ChorusDonutItem extends Item{
    public ChorusDonutItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        ItemStack itemstack = super.finishUsingItem(stack, level, entityLiving);
        // check config
        if (!(level instanceof ServerLevel serverLevel)) {
            return itemstack;
        }

        double chance = ServerConfig.CHORUS_DONUT_TELEPORT_CHANCE.get();

        if (chance <= 0.0) {
            return itemstack;
        }

        if (level.random.nextDouble() >= chance) {
            return itemstack;
        }

        if (!level.isClientSide) {
            for (int i = 0; i < 16; i++) {
                double d0 = entityLiving.getX() + (entityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                double d1 = Mth.clamp(
                        entityLiving.getY() + (double) (entityLiving.getRandom().nextInt(16) - 8),
                        (double) level.getMinBuildHeight(),
                        (double) (level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1)
                );
                double d2 = entityLiving.getZ() + (entityLiving.getRandom().nextDouble() - 0.5) * 16.0;
                if (entityLiving.isPassenger()) {
                    entityLiving.stopRiding();
                }

                Vec3 vec3 = entityLiving.position();
                net.neoforged.neoforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.neoforged.neoforge.event.EventHooks.onChorusFruitTeleport(entityLiving, d0, d1, d2);
                if (event.isCanceled()) return itemstack;
                if (entityLiving.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(entityLiving));
                    SoundSource soundsource;
                    SoundEvent soundevent;
                    if (entityLiving instanceof Fox) {
                        soundevent = SoundEvents.FOX_TELEPORT;
                        soundsource = SoundSource.NEUTRAL;
                    } else {
                        soundevent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                        soundsource = SoundSource.PLAYERS;
                    }

                    level.playSound(null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(), soundevent, soundsource);
                    entityLiving.resetFallDistance();
                    break;
                }
            }

            if (entityLiving instanceof Player player) {
                AllAdvancements.CHORUS_DONUT.awardTo(player);
                player.resetCurrentImpulseContext();
                player.getCooldowns().addCooldown(this, 20);
            }
        }

        return itemstack;
    }
}
