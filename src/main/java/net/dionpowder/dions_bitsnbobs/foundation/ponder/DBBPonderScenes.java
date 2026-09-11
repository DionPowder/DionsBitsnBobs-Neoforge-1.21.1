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
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.content.item.DBBItems;
import net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes.BulkFrostingScene;
import net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes.FoodSprinklingScene;
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
        helper.forComponents(DBBBlocks.FOOD_SPRINKLER.getId())
                .addStoryBoard("food_sprinkling", FoodSprinklingScene::operate);
        helper.forComponents(buckets)
                .addStoryBoard("bulk_frosting", BulkFrostingScene::operate);
        helper.forComponents(AllBlocks.ENCASED_FAN.getId())
                .addStoryBoard("bulk_frosting", BulkFrostingScene::operate);
    }
    
    
}