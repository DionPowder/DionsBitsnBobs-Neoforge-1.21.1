package net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
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
import net.minecraft.world.item.Items;
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
        
        Selection pressS = util.select().position(2, 3, 2);
        BlockPos pressPos = util.grid().at(2, 3, 2);
        BlockPos depotPos = util.grid().at(2, 1, 1);
        scene.world().setKineticSpeed(pressS, 0);
        scene.world().showSection(pressS, Direction.DOWN);
        scene.idle(10);
        
        scene.world().showSection(util.select().fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 2, 3), Direction.SOUTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 3, 3), Direction.NORTH);
        scene.world().setKineticSpeed(pressS, -32);
        scene.effects().indicateSuccess(pressPos);
        scene.idle(10);
        
        Vec3 pressSide = util.vector().blockSurface(pressPos, Direction.WEST);
        scene.overlay().showText(60)
                .pointAt(pressSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Food Sprinkler can process items provided beneath it");
        scene.idle(70);
        scene.overlay().showText(60)
                .pointAt(pressSide.subtract(0, 2, 0))
                .placeNearTarget()
                .text("The Input items can be dropped or placed on a Depot under the Food Sprinkler");
        scene.idle(50);
        ItemStack whiteChocolateDonut = new ItemStack(DBBItems.WHITE_CHOCOLATE_DONUT.get());
        scene.world().createItemOnBeltLike(depotPos, Direction.NORTH, whiteChocolateDonut);
        Vec3 depotCenter = util.vector().centerOf(depotPos.south());
        scene.overlay().showControls(depotCenter, Pointing.UP, 30).withItem(whiteChocolateDonut);
        scene.idle(10);
        
        Class<FoodSprinklerBlockEntity> type = FoodSprinklerBlockEntity.class;
        scene.world().modifyBlockEntity(pressPos, type, fpe -> fpe.getFoodSprinklingBehaviour()
                .start());
        scene.idle(30);
        scene.world().removeItemsFromBelt(depotPos);
        ItemStack sheet = AllItems.COPPER_SHEET.asStack();
        scene.world().createItemOnBeltLike(depotPos, Direction.UP, sheet);
        scene.idle(10);
        scene.overlay().showControls(depotCenter, Pointing.UP, 50).withItem(sheet);
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
        
        ElementLink<BeltItemElement> ingot = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, whiteChocolateDonut);
        scene.idle(15);
        ElementLink<BeltItemElement> ingot2 = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, whiteChocolateDonut);
        scene.idle(15);
        scene.world().stallBeltItem(ingot, true);
        scene.world().modifyBlockEntity(pressPos, type, fpe -> fpe.getFoodSprinklingBehaviour()
                .start());
        
        scene.overlay().showText(50)
                .pointAt(pressSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Press will hold and process them automatically");
        
        scene.idle(30);
        scene.world().modifyBlockEntity(pressPos, type, fpe -> fpe.getFoodSprinklingBehaviour());
                //.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), whiteChocolateDonut));
        scene.world().removeItemsFromBelt(pressPos.below(2));
        ingot = scene.world().createItemOnBelt(pressPos.below(2), Direction.UP, sheet);
        scene.world().stallBeltItem(ingot, true);
        scene.idle(15);
        scene.world().stallBeltItem(ingot, false);
        scene.idle(15);
        scene.world().stallBeltItem(ingot2, true);
        scene.world().modifyBlockEntity(pressPos, type, fpe -> fpe.getFoodSprinklingBehaviour()
                .start());
        scene.idle(30);
        scene.world().modifyBlockEntity(pressPos, type, fpe -> fpe.getFoodSprinklingBehaviour());
            //.makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), whiteChocolateDonut));
        scene.world().removeItemsFromBelt(pressPos.below(2));
        ingot2 = scene.world().createItemOnBelt(pressPos.below(2), Direction.UP, sheet);
        scene.world().stallBeltItem(ingot2, true);
        scene.idle(15);
        scene.world().stallBeltItem(ingot2, false);
        
    }
    
}
