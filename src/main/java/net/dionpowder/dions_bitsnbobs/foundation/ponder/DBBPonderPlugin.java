package net.dionpowder.dions_bitsnbobs.foundation.ponder;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.minecraft.resources.ResourceLocation;

public class DBBPonderPlugin implements PonderPlugin {
    
    @Override
    public String getModId() {
        return DBB.MOD_ID;
    }
    
    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        DBBPonderScenes.register(helper);
    }
    
}
