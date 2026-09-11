package net.dionpowder.dions_bitsnbobs.compat.jei.category.animations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.block.DBBPartialModels;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Direction;

public class AnimatedFoodSprinkler extends AnimatedKinetics {
    
    @Override
    public void draw(GuiGraphics graphics, int xOffset, int yOffset) {
        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        matrixStack.translate(xOffset, yOffset, 100);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-15.5f));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5f));
        int scale = 20;
        
        blockElement(shaft(Direction.Axis.Z))
                .rotateBlock(0, 0, getCurrentAngle() * 2)
                .scale(scale)
                .render(graphics);
        
        blockElement(DBBBlocks.FOOD_SPRINKLER.getDefaultState())
                .scale(scale)
                .render(graphics);
        
        matrixStack.pushPose();
        
        blockElement(DBBPartialModels.FOOD_SPRINKLER_HEAD)
                .rotateBlock(0, getCurrentAngle() * 2, 0)
                .atLocal(0, 0, 0)
                .scale(scale)
                .render(graphics);
        
        matrixStack.popPose();
        
        blockElement(AllBlocks.DEPOT.getDefaultState())
                .atLocal(0, 2, 0)
                .scale(scale)
                .render(graphics);
        
        matrixStack.popPose();
        
    }
    
}
