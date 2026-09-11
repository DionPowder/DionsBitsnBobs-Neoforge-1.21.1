package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.dionpowder.dions_bitsnbobs.content.block.DBBPartialModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

public class FoodSprinklerRenderer extends KineticBlockEntityRenderer<FoodSprinklerBlockEntity> {
    
    public FoodSprinklerRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
    
    @Override
    protected void renderSafe(FoodSprinklerBlockEntity foodSprinkler, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                              int light, int overlay) {
        super.renderSafe(foodSprinkler, partialTicks, ms, buffer, light, overlay);
        
        if (VisualizationManager.supportsVisualization(foodSprinkler.getLevel()))
            return;
        
        BlockState blockState = foodSprinkler.getBlockState();
        SuperByteBuffer headRender = CachedBuffers.partialFacing(DBBPartialModels.FOOD_SPRINKLER_HEAD, blockState,
                blockState.getValue(HORIZONTAL_FACING));

        float speed = foodSprinkler.getRenderedHeadRotationSpeed(partialTicks);
        float time = AnimationTickHolder.getRenderTime(foodSprinkler.getLevel());
        float angle = ((time * speed * 6 / 10f) % 360) / 180 * (float) Math.PI;

        headRender.rotateCentered(angle, Direction.UP)
                .translate(0, -0, 0)
                .light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
        
    }
    
    @Override
    protected BlockState getRenderedBlockState(FoodSprinklerBlockEntity be) {
        return shaft(getRotationAxisOf(be));
    }
    
}
