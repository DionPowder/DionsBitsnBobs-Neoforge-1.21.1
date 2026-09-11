package net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklerBlockEntity;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.phys.Vec3;

public class FoodSprinklingScene {
    
    public static void operate(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("food_sprinkling", "Food Sprinkling");
        scene.configureBasePlate(0, 0, 5);
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(5);
        
        ElementLink<WorldSectionElement> depot =
                scene.world().showIndependentSection(util.select().position(2, 1, 1), Direction.DOWN);
        scene.world().moveSection(depot, util.vector().of(0, 0, 1), 0);
        scene.idle(10);
        
        Selection sprinklerS = util.select().position(2, 3, 2);
        BlockPos sprinklerPos = util.grid().at(2, 3, 2);
        BlockPos depotPos = util.grid().at(2, 1, 1);
        scene.world().setKineticSpeed(sprinklerS, 0);
        scene.world().showSection(sprinklerS, Direction.DOWN);
        scene.idle(10);
        
        scene.world().showSection(util.select().fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 2, 3), Direction.SOUTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 3, 3), Direction.NORTH);
        scene.world().setKineticSpeed(sprinklerS, -32);
        scene.effects().indicateSuccess(sprinklerPos);
        scene.idle(10);
        
        Vec3 foodSprinklerSideWest = util.vector().blockSurface(sprinklerPos, Direction.WEST);
        scene.overlay().showText(60)
                .pointAt(foodSprinklerSideWest)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Food Sprinkler can process items provided beneath it");
        scene.idle(70);
        scene.overlay().showText(60)
                .pointAt(foodSprinklerSideWest.subtract(0, 2, 0))
                .placeNearTarget()
                .text("The Input items can be dropped or placed on a Depot under the Food Sprinkler");
        scene.idle(50);
        ItemStack whiteChocolateDonut = new ItemStack(DBBItems.WHITE_CHOCOLATE_DONUT.get());
        scene.world().createItemOnBeltLike(depotPos, Direction.NORTH, whiteChocolateDonut);
        Vec3 depotCenter = util.vector().centerOf(depotPos.south());
        scene.overlay().showControls(depotCenter, Pointing.UP, 30).withItem(whiteChocolateDonut);
        scene.idle(30);
        
        scene.overlay().showText(60)
                .pointAt(foodSprinklerSideWest)
                .attachKeyFrame()
                .placeNearTarget()
                .text("Additionally, the Food Sprinkler requires a valid item to sprinkle");
        scene.idle(40);
        
        Selection supplierS = util.select().fromTo(2, 4, 2, 2, 5, 2);
        scene.world().showSection(supplierS, Direction.DOWN);
        BlockPos chestPos = util.grid().at(2, 5, 2);
        Vec3 chestSideEast = util.vector().blockSurface(chestPos, Direction.EAST);
        scene.idle(30);
        scene.overlay().showControls(chestSideEast, Pointing.RIGHT, 30).withItem(DBBItems.BOTTLED_RAINBOW_SPRINKLES.asStack());
        scene.idle(10);
        Class<FoodSprinklerBlockEntity> foodSprinklerType = FoodSprinklerBlockEntity.class;
        scene.world().modifyBlockEntity(chestPos, ChestBlockEntity.class, chest -> chest.setItem(0, new ItemStack(DBBItems.BOTTLED_RAINBOW_SPRINKLES.get(), 16)));
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.inventory.setItem(0, new ItemStack(DBBItems.BOTTLED_RAINBOW_SPRINKLES.get(), 16)));
        scene.idle(20);
        
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().start());
        scene.idle(30);
        scene.world().removeItemsFromBelt(depotPos);
        ItemStack sprinkledDonut = DBBItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.asStack();
        scene.world().createItemOnBeltLike(depotPos, Direction.UP, sprinkledDonut);
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().finish());
        scene.idle(10);
        scene.overlay().showControls(depotCenter, Pointing.UP, 50).withItem(sprinkledDonut);
        scene.idle(60);
        
        scene.world().hideIndependentSection(depot, Direction.NORTH);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
        scene.idle(10);
        scene.world().showSection(util.select().fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
        scene.idle(20);
        BlockPos beltPos = util.grid().at(0, 1, 2);
        scene.overlay().showText(40)
                .pointAt(util.vector().blockSurface(beltPos, Direction.WEST))
                .placeNearTarget()
                .attachKeyFrame()
                .text("When items are provided on a belt...");
        scene.idle(30);
        
        ElementLink<BeltItemElement> donut = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, whiteChocolateDonut);
        scene.idle(15);
        ElementLink<BeltItemElement> donut2 = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, whiteChocolateDonut);
        scene.idle(15);
        scene.world().stallBeltItem(donut, true);
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().start());
        scene.overlay().showText(50)
                .pointAt(foodSprinklerSideWest)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Food Sprinkler will hold and process them automatically");
        scene.idle(30);
        scene.world().removeItemsFromBelt(sprinklerPos.below(2));
        donut = scene.world().createItemOnBelt(sprinklerPos.below(2), Direction.UP, sprinkledDonut);
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().finish());
        scene.world().stallBeltItem(donut, true);
        scene.overlay().showControls(depotCenter, Pointing.UP, 50).withItem(sprinkledDonut);
        scene.idle(15);
        scene.world().stallBeltItem(donut, false);
        scene.idle(15);
        scene.world().stallBeltItem(donut2, true);
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().start());
        scene.idle(30);
        scene.world().removeItemsFromBelt(sprinklerPos.below(2));
        donut2 = scene.world().createItemOnBelt(sprinklerPos.below(2), Direction.UP, sprinkledDonut);
        scene.world().modifyBlockEntity(sprinklerPos, foodSprinklerType, fpe -> fpe.getFoodSprinklingBehaviour().finish());
        scene.world().stallBeltItem(donut2, true);
        scene.idle(15);
        scene.world().stallBeltItem(donut2, false);
        
    }
    
}
