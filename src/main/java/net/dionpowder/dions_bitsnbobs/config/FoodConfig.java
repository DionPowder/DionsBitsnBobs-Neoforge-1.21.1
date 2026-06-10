package net.dionpowder.dions_bitsnbobs.config;

import net.createmod.catnip.config.ConfigBase;

public class FoodConfig extends ConfigBase {

    public final ConfigFloat CHORUS_DONUT_TELEPORT_CHANCE = f(1.0f,
            0.0f,
            1.0f,
            "chorusDonutTeleportChance",
            Comments.chorusDonutTeleportChance);

    @Override
    public String getName() {
        return "food";
    }

    static class Comments {
        static final String chorusDonutTeleportChance = "The chance for a chorus donut to teleport the player";
    }

}
