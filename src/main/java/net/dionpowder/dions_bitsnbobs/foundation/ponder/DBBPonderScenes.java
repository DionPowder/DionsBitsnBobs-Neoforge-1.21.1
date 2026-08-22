package net.dionpowder.dions_bitsnbobs.foundation.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.placard.PlacardBlock;
import com.simibubi.create.content.decoration.placard.PlacardBlockEntity;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.AttachFace;

import java.util.List;
import java.util.stream.Stream;

public class DBBPonderScenes {
    
    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        List<ResourceLocation> buckets = Stream.of(
                        DBBFluids.STRAWBERRY_FROSTING,
                        DBBFluids.ORANGE_FROSTING,
                        DBBFluids.BLUEBERRY_FROSTING,
                        DBBFluids.CRANBERRY_FROSTING,
                        DBBFluids.PEAR_FROSTING)
                .map(entry -> entry.getBucket()
                        .map(bucket -> BuiltInRegistries.ITEM.getKey(bucket.asItem()))
                        .orElseThrow())
                .toList();
        
        helper.forComponents(buckets)
                .addStoryBoard("bulk_frosting", DBBPonderScenes::bulkFrosting);
        helper.forComponents(AllBlocks.ENCASED_FAN.getId())
                .addStoryBoard("bulk_frosting", DBBPonderScenes::bulkFrosting);
    }
    
    public static void bulkFrosting(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("bulk_frosting", "Bulk Frosting");
        scene.configureBasePlate(1, 0, 5);
        var base = util.select().layer(0)
                .add(util.select().position(6, 3, 1));
        scene.world().showSection(base, Direction.UP);
        scene.idle(5);
        var fan = util.select().fromTo(5, 2, 1, 6, 2, 2);
        scene.world().showSection(fan, Direction.DOWN);
        scene.idle(5);
        var fanBase = util.select().fromTo(4, 1, 2, 5, 1, 2);
        scene.world().showSection(fanBase, Direction.UP);
        scene.idle(10);
        var strawberryInFront = scene.world().makeSectionIndependent(util.select().position(3, 1, 2));
        scene.world().moveSection(strawberryInFront, util.vector().of(1, 1, 0), 0);
        scene.world().setBlock(util.grid().at(4, 2, 2), DBBFluids.STRAWBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock(), false);
        scene.idle(10);
        var airCurrent = util.select().fromTo(4, 2, 2, 1, 2, 2);
        scene.overlay()
                .showOutline(PonderPalette.RED, airCurrent, airCurrent, 20);
        scene.overlay()
                .showText(60)
                .pointAt(util.vector().topOf(5, 2, 2))
                .attachKeyFrame()
                .text("Airflow passing through Frosting creates a Frosting setup");
        scene.idle(40);
        ItemStack donut = new ItemStack(DBBItems.DONUT.get());
        ItemStack strawberryDonut = new ItemStack(DBBItems.STRAWBERRY_DONUT.get());
        var belt = util.select().fromTo(0, 1, 0, 2, 2, 4);
        scene.world().showSection(belt, Direction.DOWN);
        var transported = scene.world().createItemOnBelt(util.grid().at(2, 1, 3), Direction.SOUTH, donut);
        scene.overlay().showControls(util.vector().topOf(util.grid().at(2, 1, 3)), Pointing.DOWN, 30)
                .withItem(donut);
        scene.idle(90);
        scene.world().changeBeltItemTo(transported, strawberryDonut);
        scene.idle(10);
        scene.overlay()
                .showText(60)
                .pointAt(util.vector().topOf(2, 1, 1))
                .attachKeyFrame()
                .text("Items that can be filled with Frosting will automatically be converted");
        scene.world().setKineticSpeed(belt, -0.5f);
        scene.idle(60);
        scene.world().setKineticSpeed(belt, -10);
        scene.idle(40);
        scene.overlay().showControls(util.vector().centerOf(util.grid().at(2, 1, 0)), Pointing.RIGHT, 30)
                .withItem(strawberryDonut);
        scene.idle(40);
        scene.overlay()
                .showText(60)
                .pointAt(util.vector().topOf(4, 2, 2))
                .attachKeyFrame()
                .text("Different Frosting will process different filling recipes");
        scene.idle(70);
        // placards
        var placard = AllBlocks.PLACARD.getDefaultState()
                .setValue(PlacardBlock.FACE, AttachFace.WALL)
                .setValue(PlacardBlock.FACING, Direction.NORTH);
        var placardPos0 = util.grid().at(5, 2, 1);
        var placardPos1 = util.grid().at(1, 1, 1);
        scene.world().setBlock(placardPos0, placard, false);
        scene.world().setBlock(placardPos1, placard, false);
        // show pear
        scene.world().hideIndependentSection(strawberryInFront, Direction.UP);
        scene.idle(15);
        ItemStack pearBucket = new ItemStack(DBBFluids.PEAR_FROSTING.get().getBucket());
        ItemStack pearDonut = new ItemStack(DBBItems.PEAR_DONUT.get());
        scene.world().modifyBlockEntity(placardPos0, PlacardBlockEntity.class, it -> it.setHeldItem(pearBucket));
        scene.world().modifyBlockEntity(placardPos1, PlacardBlockEntity.class, it -> it.setHeldItem(pearDonut));
        scene.overlay().showControls(util.vector().topOf(util.grid().at(4, 2, 2)), Pointing.DOWN, 30)
                .withItem(pearBucket);
        var pearInFront = scene.world().makeSectionIndependent(util.select().position(3, 1, 3));
        scene.world().moveSection(pearInFront, util.vector().of(1, 1, -1), 0);
        scene.world().setBlock(util.grid().at(4, 2, 2), DBBFluids.PEAR_FROSTING.get().getSource().defaultFluidState().createLegacyBlock(), false);
        scene.idle(40);
        // show blueberry
        scene.world().hideIndependentSection(pearInFront, Direction.UP);
        scene.idle(15);
        ItemStack blueberryBucket = new ItemStack(DBBFluids.BLUEBERRY_FROSTING.get().getBucket());
        ItemStack blueberryDonut = new ItemStack(DBBItems.BLUEBERRY_DONUT.get());
        scene.world().modifyBlockEntity(placardPos0, PlacardBlockEntity.class, it -> it.setHeldItem(blueberryBucket));
        scene.world().modifyBlockEntity(placardPos1, PlacardBlockEntity.class, it -> it.setHeldItem(blueberryDonut));
        scene.overlay().showControls(util.vector().topOf(util.grid().at(4, 2, 2)), Pointing.DOWN, 30)
                .withItem(blueberryBucket);
        var blueberryInFront = scene.world().makeSectionIndependent(util.select().position(4, 1, 3));
        scene.world().moveSection(blueberryInFront, util.vector().of(0, 1, -1), 0);
        scene.world().setBlock(util.grid().at(4, 2, 2), DBBFluids.BLUEBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock(), false);
        scene.idle(40);
        // show orange
        scene.world().hideIndependentSection(blueberryInFront, Direction.UP);
        scene.idle(15);
        ItemStack orangeBucket = new ItemStack(DBBFluids.ORANGE_FROSTING.get().getBucket());
        ItemStack orangeDonut = new ItemStack(DBBItems.ORANGE_DONUT.get());
        scene.world().modifyBlockEntity(placardPos0, PlacardBlockEntity.class, it -> it.setHeldItem(orangeBucket));
        scene.world().modifyBlockEntity(placardPos1, PlacardBlockEntity.class, it -> it.setHeldItem(orangeDonut));
        scene.overlay().showControls(util.vector().topOf(util.grid().at(4, 2, 2)), Pointing.DOWN, 30)
                .withItem(orangeBucket);
        var orangeInFront = scene.world().makeSectionIndependent(util.select().position(4, 1, 4));
        scene.world().moveSection(orangeInFront, util.vector().of(0, 1, -2), 0);
        scene.world().setBlock(util.grid().at(4, 2, 2), DBBFluids.ORANGE_FROSTING.get().getSource().defaultFluidState().createLegacyBlock(), false);
        scene.idle(40);
        // show cranberry
        scene.world().hideIndependentSection(orangeInFront, Direction.UP);
        scene.idle(15);
        ItemStack cranberryBucket = new ItemStack(DBBFluids.CRANBERRY_FROSTING.get().getBucket());
        ItemStack cranberryDonut = new ItemStack(DBBItems.CRANBERRY_DONUT.get());
        scene.world().modifyBlockEntity(placardPos0, PlacardBlockEntity.class, it -> it.setHeldItem(cranberryBucket));
        scene.world().modifyBlockEntity(placardPos1, PlacardBlockEntity.class, it -> it.setHeldItem(cranberryDonut));
        scene.overlay().showControls(util.vector().topOf(util.grid().at(4, 2, 2)), Pointing.DOWN, 30)
                .withItem(cranberryBucket);
        var cranberryInFront = scene.world().makeSectionIndependent(util.select().position(3, 1, 4));
        scene.world().moveSection(cranberryInFront, util.vector().of(1, 1, -2), 0);
        scene.world().setBlock(util.grid().at(4, 2, 2), DBBFluids.CRANBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock(), false);
        scene.idle(40);
        scene.markAsFinished();
    }
}