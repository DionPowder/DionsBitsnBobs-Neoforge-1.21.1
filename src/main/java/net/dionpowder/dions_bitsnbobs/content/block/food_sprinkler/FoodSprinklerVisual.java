package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.simibubi.create.content.kinetics.base.RotatingInstance;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.simibubi.create.foundation.render.AllInstanceTypes;
import dev.engine_room.flywheel.api.instance.Instance;
import dev.engine_room.flywheel.api.visual.DynamicVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import dev.engine_room.flywheel.lib.visual.SimpleDynamicVisual;
import net.dionpowder.dions_bitsnbobs.content.block.DBBPartialModels;
import net.minecraft.core.Direction;

import java.util.function.Consumer;

public class FoodSprinklerVisual extends ShaftVisual<FoodSprinklerBlockEntity> implements SimpleDynamicVisual {
    
    private final RotatingInstance foodSprinklerHead;
    private final FoodSprinklerBlockEntity foodSprinkler;
    
    public FoodSprinklerVisual(VisualizationContext context, FoodSprinklerBlockEntity blockEntity, float partialTick) {
        super(context, blockEntity, partialTick);
        this.foodSprinkler = blockEntity;
        
        foodSprinklerHead = instancerProvider().instancer(AllInstanceTypes.ROTATING, Models.partial(DBBPartialModels.FOOD_SPRINKLER_HEAD))
                .createInstance();
        
        foodSprinklerHead.setRotationAxis(Direction.Axis.Y);
        
        animate(partialTick);
    }
    
    @Override
    public void beginFrame(DynamicVisual.Context ctx) {
        animate(ctx.partialTick());
    }
    
    private void animate(float pt) {
        transformHead(pt);
    }
    
    private void transformHead(float pt) {
        float speed = foodSprinkler.getRenderedHeadRotationSpeed(pt);
        
        foodSprinklerHead.setPosition(getVisualPosition())
                .nudge(0, 0, 0)
                .setRotationalSpeed(speed * 2 * RotatingInstance.SPEED_MULTIPLIER)
                .setChanged();
    }
    
    @Override
    public void updateLight(float partialTick) {
        super.updateLight(partialTick);
        relight(foodSprinklerHead);
    }
    
    @Override
    protected void _delete() {
        super._delete();
        foodSprinklerHead.delete();
    }
    
    @Override
    public void collectCrumblingInstances(Consumer<Instance> consumer) {
        super.collectCrumblingInstances(consumer);
        consumer.accept(foodSprinklerHead);
    }
}
