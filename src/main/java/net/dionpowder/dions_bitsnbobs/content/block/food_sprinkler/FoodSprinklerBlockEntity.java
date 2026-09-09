package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FoodSprinklerBlockEntity extends KineticBlockEntity {
    
    public int runningTicks;
    public boolean running;
    
    public FoodSprinklerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        
    }
    
    /*
    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        
        float stressAtBase = calculateStressApplied();
        if (IRotate.StressImpact.isEnabled() && !Mth.equal(stressAtBase, 0)) {
            tooltip.add(CommonComponents.EMPTY);
            addStressImpactStats(tooltip, stressAtBase);
        }
        
        return true;
    }
     */
    
    public float getRenderedHeadOffset(float partialTicks) {
        return 0f;
    }
    
    public float getRenderedHeadRotationSpeed(float partialTicks) {
        float speed = getSpeed();
        if (running) {
            if (runningTicks < 15) {
                return speed;
            }
            if (runningTicks <= 20) {
                return speed * 2;
            }
            return speed;
        }
        return speed / 2;
    }
    
}
