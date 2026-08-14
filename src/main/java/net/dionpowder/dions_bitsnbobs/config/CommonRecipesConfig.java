package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonRecipesConfig extends ConfigBase {

    public final ConfigBool DIAMOND_AUTOMATION= b(false,
            "diamondAutomation",
            Comments.diamondAutomation);

    public final ConfigBool RENEWABLE_CREATE_STONES_TYPES = b(true,
            "renewableCreateStoneTypes",
            Comments.renewableCreateStoneTypes);

    @Override
    public String getName() {
        return "recipes";
    }

    static class Comments {
        static final String diamondAutomation = "If automating diamonds should be enabled";
        static final String renewableCreateStoneTypes = "If automating create stone types such as crimsite should be enabled";

    }

}
