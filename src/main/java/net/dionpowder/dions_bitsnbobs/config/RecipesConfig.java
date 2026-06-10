package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class RecipesConfig extends ConfigBase {

    public final ConfigBool BULK_FROSTING = b(true,
            "bulkFrosting",
            Comments.bulkFrosting);

    public final ConfigBool BULK_CHOCOLATE_GLAZING = b(true,
            "bulkChocolateGlazing",
            Comments.bulkChocolateGlazing);

    @Override
    public String getName() {
        return "recipes";
    }

    static class Comments {
        static final String bulkFrosting = "If Bulk Frosting should be enabled";
        static final String bulkChocolateGlazing = "If Bulk Chocolate Glazing should be enabled";
    }

}
