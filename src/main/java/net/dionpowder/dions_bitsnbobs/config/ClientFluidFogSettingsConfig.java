package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class ClientFluidFogSettingsConfig extends ConfigBase {
    
    public final ConfigFloat FROSTING_TRANSPARENCY_MULTIPLIER = f(1,
            .125f,
            256,
            "frosting",
            Comments.frostingTransparencyMultiplier);
    
    public final ConfigFloat DONUT_BATTER_TRANSPARENCY_MULTIPLIER = f(1,
            .125f,
            256,
            "donut_batter", Comments.donutBatterTransparencyMultiplier);

    @Override
    public String getName() {
        return "fluidFogSettings";
    }

    static class Comments {
        static String frostingTransparencyMultiplier = "The vision range through frosting will be multiplied by this factor";
        static String donutBatterTransparencyMultiplier = "The vision range though donut batter will be multiplied by this factor";
    }

}
