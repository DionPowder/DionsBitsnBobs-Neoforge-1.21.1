package net.dionpowder.dions_bitsnbobs.content.item;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.mechanicalArm.AllArmInteractionPointTypes;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPoint;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPointType;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;

public class DBBArmInteractionPoints {
    
    static {
        register("food_sprinkler", new FoodSprinklerType());
    }
    
    private static <T extends ArmInteractionPointType> void register(String name, T type) {
        Registry.register(CreateBuiltInRegistries.ARM_INTERACTION_POINT_TYPE, DBB.rl(name), type);
    }
    
    @ApiStatus.Internal
    public static void init() {
    }
    
    public static class FoodSprinklerType extends ArmInteractionPointType {
        @Override
        public boolean canCreatePoint(Level level, BlockPos pos, BlockState state) {
            return DBBBlocks.FOOD_SPRINKLER.has(state);
        }
        
        @Override
        public ArmInteractionPoint createPoint(Level level, BlockPos pos, BlockState state) {
            return new FoodSprinklerPoint(this, level, pos, state);
        }
    }
    
    public static class FoodSprinklerPoint extends AllArmInteractionPointTypes.DepositOnlyArmInteractionPoint {
        public FoodSprinklerPoint(ArmInteractionPointType type, Level level, BlockPos pos, BlockState state) {
            super(type, level, pos, state);
        }
        
        @Override
        protected Vec3 getInteractionPositionVector() {
            return Vec3.atLowerCornerOf(pos)
                    .add(.5f, 1, .5f);
        }
    }
    
}
