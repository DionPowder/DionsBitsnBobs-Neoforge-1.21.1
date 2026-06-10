package net.dionpowder.dions_bitsnbobs.content.item.custom;

import net.dionpowder.dions_bitsnbobs.foundation.advancement.AllAdvancements;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SprinklesItemBase extends Item {
    public SprinklesItemBase(Properties properties) {super(properties);}

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            AllAdvancements.SUGAR_RUSH.awardTo(player);
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
