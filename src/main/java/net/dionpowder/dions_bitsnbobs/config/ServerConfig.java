package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class ServerConfig extends ConfigBase {

    public final RecipesConfig recipes = nested(0, RecipesConfig::new, Comments.recipes);
    public final FoodConfig food = nested(0, FoodConfig::new, Comments.food);

    @Override
    public String getName() {
        return "server";
    }

    static class Comments {
        static final String recipes = "Config options for recipe types";
        static final String food = "Config options for food items";
    }
}
