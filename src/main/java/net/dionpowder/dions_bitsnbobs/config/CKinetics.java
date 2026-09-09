package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;
import net.dionpowder.dions_bitsnbobs.DBB;

public class CKinetics extends ConfigBase {
    
    public final CStress stressValues = nested(1, () -> new CStress(DBB.MOD_ID), Comments.stress);
    
    @Override
    public String getName() {
        return "kinetics";
    }
    
    private static class Comments {
        static String stress = "Fine tune the kinetic stats of individual components";
    }
    
}