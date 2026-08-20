package net.dionpowder.dions_bitsnbobs.foundation.ponder;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
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

import java.util.List;
import java.util.stream.Stream;

public class DBBPonderScenes {
    
    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        List<ResourceLocation> buckets = Stream.of(
                DBBFluids.STRAWBERRY_FROSTING,
                DBBFluids.ORANGE_FROSTING,
                DBBFluids.BLUEBERRY_FROSTING,
                DBBFluids.PEAR_FROSTING)
        .map(entry -> entry.getBucket()
                .map(bucket -> BuiltInRegistries.ITEM.getKey(bucket.asItem()))
                .orElseThrow())
        .toList();
        
        helper.forComponents(buckets)
                .addStoryBoard("frosting", DBBPonderScenes::frosting);
    }
    
    public static void frosting(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("frosting", "Frosting");
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
        var blockInFront = scene.world().makeSectionIndependent(util.select().position(3, 1, 2));
        scene.world().moveSection(blockInFront, util.vector().of(1, 1, 0), 0);
        var frosting = DBBFluids.STRAWBERRY_FROSTING.get().getSource().defaultFluidState().createLegacyBlock();
        scene.world().setBlock(util.grid().at(4, 2, 2), frosting, false);
        scene.idle(10);
        var airCurrent = util.select().fromTo(4, 2, 2, 1, 2, 2);
        scene.overlay()
                .showOutline(PonderPalette.RED, airCurrent, airCurrent, 20);
        scene.idle(40);
        ItemStack donut = new ItemStack(DBBItems.DONUT.get());
        ItemStack strawberryDonut = new ItemStack(DBBItems.STRAWBERRY_DONUT.get());
        var belt = util.select().fromTo(0, 1, 1, 2, 2, 4);
        scene.world().showSection(belt, Direction.DOWN);
        var transported = scene.world().createItemOnBelt(util.grid().at(2, 1, 3), Direction.SOUTH, donut);
        scene.overlay()
                .showText(80)
                .pointAt(util.vector().topOf(2, 1, 2))
                .attachKeyFrame()
                .text("Air from an encased fan passing through liquid frosting creates a bulk frosting setup");
        scene.idle(80);
        scene.world().changeBeltItemTo(transported, strawberryDonut);
        scene.idle(80);
    }
}
