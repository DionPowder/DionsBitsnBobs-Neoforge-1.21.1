package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonConfig extends ConfigBase {

    public final ConfigBool DONUT_SELLING = b(true,
            "villagerDonutSelling",
            Comments.villagerDonutSelling);

    @Override
    public String getName() {
        return "common";
    }

    static class Comments {
        static final String villagerDonutSelling = "If selling donuts to villagers should be enabled, " + "requires reload";
    }
}
