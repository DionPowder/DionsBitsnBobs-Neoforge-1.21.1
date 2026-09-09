package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

public class FoodSprinklerRenderer extends KineticBlockEntityRenderer<FoodSprinklerBlockEntity> {
    
    public FoodSprinklerRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
    
    @Override
    public boolean shouldRenderOffScreen(FoodSprinklerBlockEntity be) {
        return true;
    }
    
    @Override
    protected void renderSafe(FoodSprinklerBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                              int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);
        
        if (VisualizationManager.supportsVisualization(be.getLevel()))
            return;
        /*
        BlockState blockState = be.getBlockState();
        PressingBehaviour pressingBehaviour = be.getPressingBehaviour();
        float renderedHeadOffset =
                pressingBehaviour.getRenderedHeadOffset(partialTicks) * pressingBehaviour.mode.headOffset;
        
        SuperByteBuffer headRender = CachedBuffers.partialFacing(DBBPartialModels.FOOD_SPRINKLER_HEAD, blockState,
                blockState.getValue(HORIZONTAL_FACING));
        headRender.translate(0, -renderedHeadOffset, 0)
                .light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
         */
    }
    
    @Override
    protected BlockState getRenderedBlockState(FoodSprinklerBlockEntity be) {
        return shaft(getRotationAxisOf(be));
    }
    
}
