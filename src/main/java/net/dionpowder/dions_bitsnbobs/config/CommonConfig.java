package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonConfig extends ConfigBase {

    public final ConfigBool DONUT_SELLING = b(true,
            "villagerDonutSelling",
            Comments.villagerDonutSelling);

    //public final ConfigInt PATCH_TRIES = i(12,
            //1,
            //64,
            //"strawberryBushPatchTries",
            //Comments.strawberryBushPatchTries);

    public final CommonRecipesConfig commonRecipes = nested(0, CommonRecipesConfig::new, Comments.commonRecipes);

    @Override
    public String getName() {
        return "common";
    }

    static class Comments {
        static final String villagerDonutSelling = "If selling donuts to villagers should be enabled, " + "requires reload";
        //static final String strawberryBushPatchTries = "The amount of tries for generating strawberry bush patches";
        static final String commonRecipes = "Config options for recipes generated during reloads";
    }
}
