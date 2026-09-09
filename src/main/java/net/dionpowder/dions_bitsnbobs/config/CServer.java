package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class CServer extends ConfigBase {
    
    public final CRecipes recipes = nested(0, CRecipes::new, Comments.recipes);
    public final CFood food = nested(0, CFood::new, Comments.food);
    public final CKinetics kinetics = nested(0, CKinetics::new, Comments.kinetics);

    @Override
    public String getName() {
        return "server";
    }

    static class Comments {
        static final String recipes = "Config options for recipe types";
        static String kinetics = "Parameters and abilities of Create Dion's Bits 'n' Bobs! kinetic mechanisms";
        static final String food = "Config options for food items";
    }
}
