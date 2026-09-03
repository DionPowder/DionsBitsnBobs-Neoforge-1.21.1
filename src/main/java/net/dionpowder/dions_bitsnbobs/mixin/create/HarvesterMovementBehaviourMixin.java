package net.dionpowder.dions_bitsnbobs.mixin.create;

import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import net.dionpowder.dions_bitsnbobs.content.block.strawberry_bush.StrawberryBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = HarvesterMovementBehaviour.class)
public class HarvesterMovementBehaviourMixin {
    @Inject(method = "cutCrop", at = @At("HEAD"), cancellable = true)
    private void onCutCrop(Level world, BlockPos pos, BlockState state, CallbackInfoReturnable<BlockState> cir) {
        if (state.getBlock() instanceof StrawberryBushBlock) {
            cir.setReturnValue(state.setValue(BlockStateProperties.AGE_3, 1));
        }
    }
}