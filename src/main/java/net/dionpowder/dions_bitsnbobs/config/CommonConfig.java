package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonConfig extends ConfigBase {

    public final ConfigBool DONUT_SELLING = b(true,
            "villagerDonutSelling",
            Comments.villagerDonutSelling);

    public final ConfigBool DIAMOND_RECIPE = b(false,
            "diamondRecipe",
            Comments.diamondRecipe);

    @Override
    public String getName() {
        return "common";
    }

    static class Comments {
        static final String villagerDonutSelling = "If selling donuts to villagers should be enabled, " + "requires reload";
        static final String diamondRecipe = "If producing diamonds is enabled, " + "requires reload";
    }
}
