package net.dionpowder.dions_bitsnbobs.content.recipe.fan.type;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.theme.Color;
import net.dionpowder.dions_bitsnbobs.config.DionsBitsnBobsConfig;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.dionpowder.dions_bitsnbobs.utils.DBBTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

public class ChocolateGlazingType implements FanProcessingType {

    @SuppressWarnings("deprecation")
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        // add config check here
        if (!DionsBitsnBobsConfig.recipes().BULK_CHOCOLATE_GLAZING.get()) return false;
        var fluidState = level.getFluidState(pos);
        if (fluidState.getType().builtInRegistryHolder().is(DBBTags.Fluids.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING)) return true;
        var blockState = level.getBlockState(pos);
        return blockState.getBlock().builtInRegistryHolder().is(DBBTags.Blocks.FAN_PROCESSING_CATALYSTS_CHOCOLATE_GLAZING);
    }

    @Override
    public int getPriority() {
        return 1100;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        if (!DionsBitsnBobsConfig.recipes().BULK_CHOCOLATE_GLAZING.get())
            return false;
        var recipeManager = level.getRecipeManager();
        var input = new SingleRecipeInput(stack);
        return recipeManager
                .getRecipeFor(DBBRecipeTypes.CHOCOLATE_GLAZING.getType(), input, level)
                .isPresent();
    }

    @Override
    public @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        var recipeManager = level.getRecipeManager();
        var input = new SingleRecipeInput(stack);
        return recipeManager
                .getRecipeFor(DBBRecipeTypes.CHOCOLATE_GLAZING.getType(), input, level)
                .map(recipe -> RecipeApplier.applyRecipeOn(level, stack, recipe.value(), false))
                .orElse(null);
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0)
            return;
        Vector3f color = new Color(0x3d1906).asVectorF();
        level.addParticle(new DustParticleOptions(color, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
        Vector3f color2 = new Color(0x5c2306).asVectorF();
        level.addParticle(new DustParticleOptions(color2, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0x3d1906, 0x5c2306, random.nextFloat()));
        particleAccess.setAlpha(1f);
        //if (random.nextFloat() < 1 / 32f)
            //particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE, .125f);
        //if (random.nextFloat() < 1 / 32f)
            //particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE_POP, .125f);

    }

    @Override
    public void affectEntity(Entity entity, Level level) {

    }
}