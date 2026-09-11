package net.dionpowder.dions_bitsnbobs.content.block.strawberry_bush;

import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import plus.dragons.createintegratedfarming.api.harvester.AreaHarvestContext;
import plus.dragons.createintegratedfarming.api.harvester.CustomHarvestBehaviour;

import javax.annotation.Nullable;

public class StrawberryBushHarvestBehaviour implements CustomHarvestBehaviour {
    
    @Override
    public void harvest(HarvesterMovementBehaviour behaviour, MovementContext context, BlockPos pos, BlockState state) {
        BlockState mature = getMatureState(context.world, pos);
        if (mature == null)
            return;
        behaviour.collectOrDropItem(context, createDrop(context.world));
        reset(context.world, pos, mature);
    }
    
    @Override
    public boolean harvestInArea(AreaHarvestContext context, BlockPos pos, BlockState state) {
        BlockState mature = getMatureState(context.level(), pos);
        if (mature == null)
            return false;
        context.collect(createDrop(context.level()));
        reset(context.level(), pos, mature);
        return true;
    }
    
    private static @Nullable BlockState getMatureState(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (!state.is(DBBBlocks.STRAWBERRY_BUSH.get()) || state.getValue(StrawberryBushBlock.AGE) != 3)
            return null;
        return state;
    }
    
    private static ItemStack createDrop(Level level) {
        return new ItemStack(DBBItems.STRAWBERRY.get(), 1 + level.random.nextInt(2));
    }
    
    private static void reset(Level level, BlockPos pos, BlockState state) {
        level.playSound(
                null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        level.setBlock(pos, state.setValue(StrawberryBushBlock.AGE, 1), 2);
    }
}
