package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CCRecipes extends ConfigBase {

    public final ConfigBool DIAMOND_AUTOMATION= b(false,
            "diamondAutomation",
            Comments.diamondAutomation);

    public final ConfigBool RENEWABLE_CREATE_STONES_TYPES = b(true,
            "renewableCreateStoneTypes",
            Comments.renewableCreateStoneTypes);
    
    public final ConfigBool GENERATE_FOOD_SPRINKLING_RECIPES = b(true,
            "generateFoodSprinklingRecipes",
            Comments.generateFoodSprinklingRecipes);

    @Override
    public String getName() {
        return "recipes";
    }

    static class Comments {
        static final String diamondAutomation = "If automating diamonds should be enabled";
        static final String renewableCreateStoneTypes = "If automating create stone types such as crimsite should be enabled";
        static final String generateFoodSprinklingRecipes = "If valid recipes from other mods should generate recipes for the Food Sprinkler";
    }

}
