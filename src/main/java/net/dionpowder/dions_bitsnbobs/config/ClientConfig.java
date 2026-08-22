package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class ClientConfig extends ConfigBase {

    public final ClientFluidFogSettingsConfig fluidFogSettings = nested(0, ClientFluidFogSettingsConfig::new, Comments.fluidFogSettings);
    
    @Override
    public String getName() {
        return "client";
    }

    static class Comments {
        static final String fluidFogSettings = "Config options for fluid visuals";
    }
}
