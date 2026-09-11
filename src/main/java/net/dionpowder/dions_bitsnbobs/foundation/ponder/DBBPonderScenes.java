package net.dionpowder.dions_bitsnbobs.foundation.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlocks;
import net.dionpowder.dions_bitsnbobs.content.fluid.DBBFluids;
import net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes.BulkFrostingScene;
import net.dionpowder.dions_bitsnbobs.foundation.ponder.scenes.FoodSprinklingScene;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

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
                .addStoryBoard("food_sprinkling", FoodSprinklingScene::operate, AllCreatePonderTags.KINETIC_APPLIANCES);
        helper.forComponents(buckets)
                .addStoryBoard("bulk_frosting", BulkFrostingScene::operate);
        helper.forComponents(AllBlocks.ENCASED_FAN.getId())
                .addStoryBoard("bulk_frosting", BulkFrostingScene::operate);
    }
    
    
}