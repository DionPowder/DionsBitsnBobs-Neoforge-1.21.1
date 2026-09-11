package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CRecipes extends ConfigBase {

    public final ConfigBool BULK_FROSTING = b(true,
            "bulkFrosting",
            Comments.bulkFrosting);

    public final ConfigBool BULK_CHOCOLATE_GLAZING = b(true,
            "bulkChocolateGlazing",
            Comments.bulkChocolateGlazing);
    
    public final ConfigBool BULK_FOOD_SPRINKLING = b(false,
            "bulkFoodSprinkling",
            Comments.bulkFoodSprinkling);

    @Override
    public String getName() {
        return "recipes";
    }

    static class Comments {
        static final String bulkFrosting = "If Bulk Frosting should be enabled";
        static final String bulkChocolateGlazing = "If Bulk Chocolate Glazing should be enabled";
        static final String bulkFoodSprinkling = "Allow the Food Sprinkler to process entire stacks at a time";

    }

}
