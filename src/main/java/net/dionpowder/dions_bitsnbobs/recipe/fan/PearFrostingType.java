package net.dionpowder.dions_bitsnbobs.recipe.fan;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.theme.Color;
import net.dionpowder.dions_bitsnbobs.config.ServerConfig;
import net.dionpowder.dions_bitsnbobs.effect.ModEffects;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.AllAdvancements;
import net.dionpowder.dions_bitsnbobs.recipe.ModRecipeTypes;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

public class PearFrostingType implements FanProcessingType {

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        // add config check here
        if (!ServerConfig.BULK_FROSTING.get()) return false;
        var fluidState = level.getFluidState(pos);
        if (fluidState.getType().builtInRegistryHolder().is(ModTags.Fluids.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING)) return true;
        var blockState = level.getBlockState(pos);
        return blockState.getBlock().builtInRegistryHolder().is(ModTags.Blocks.FAN_PROCESSING_CATALYSTS_PEAR_FROSTING);
    }

    @Override
    public int getPriority() {
        return 1100;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        if (!ServerConfig.BULK_FROSTING.get())
            return false;
        var recipeManager = level.getRecipeManager();
        var input = new SingleRecipeInput(stack);
        return recipeManager
                .getRecipeFor(ModRecipeTypes.PEAR_FROSTING.getType(), input, level)
                .isPresent();
    }

    @Override
    public @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        var recipeManager = level.getRecipeManager();
        var input = new SingleRecipeInput(stack);
        return recipeManager
                .getRecipeFor(ModRecipeTypes.PEAR_FROSTING.getType(), input, level)
                .map(recipe -> RecipeApplier.applyRecipeOn(level, stack, recipe.value(), false))
                .orElse(null);
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0)
            return;
        Vector3f color = new Color(0xBAFA61).asVectorF();
        level.addParticle(new DustParticleOptions(color, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
        Vector3f color2 = new Color(0x9AD945).asVectorF();
        level.addParticle(new DustParticleOptions(color2, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0xBAFA61, 0x9AD945, random.nextFloat()));
        particleAccess.setAlpha(1f);
        //if (random.nextFloat() < 1 / 32f)
            //particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE, .125f);
        //if (random.nextFloat() < 1 / 32f)
            //particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE_POP, .125f);

    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (level.isClientSide) return;
        if (entity instanceof EnderMan || entity instanceof Blaze) entity.hurt(entity.damageSources().freeze(), 8);
        if (entity instanceof Player player) {
            if (!player.hasEffect(ModEffects.SUGAR_RUSH_EFFECT)){
                AllAdvancements.BULK_FROSTED.awardTo(player);
                player.addEffect(new MobEffectInstance(ModEffects.SUGAR_RUSH_EFFECT, 100, 0));
            }
        }
        if (entity.isOnFire()) {
            entity.clearFire();
            level.playSound(null, entity.blockPosition(), SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.NEUTRAL, 0.7F, 1.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
        }
    }
}