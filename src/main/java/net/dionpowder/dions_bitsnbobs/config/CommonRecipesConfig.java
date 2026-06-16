package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonRecipesConfig extends ConfigBase {

    public final ConfigBool DIAMOND_AUTOMATION= b(false,
            "diamondAutomation",
            Comments.diamondAutomation);

    @Override
    public String getName() {
        return "recipes";
    }

    static class Comments {
        static final String diamondAutomation = "If automating diamonds should be enabled, requires reload";

    }

}
