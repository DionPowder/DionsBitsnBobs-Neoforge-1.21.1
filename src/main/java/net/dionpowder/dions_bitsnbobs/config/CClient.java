package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CClient extends ConfigBase {

    public final CFluidFogSettings fluidFogSettings = nested(0, CFluidFogSettings::new, Comments.fluidFogSettings);
    
    @Override
    public String getName() {
        return "client";
    }

    static class Comments {
        static final String fluidFogSettings = "Config options for fluid visuals";
    }
}
