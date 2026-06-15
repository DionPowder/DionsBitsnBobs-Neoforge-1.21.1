package net.dionpowder.dions_bitsnbobs.config;

import net.minecraft.Util;
import net.minecraft.util.Unit;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class DionsBitsnBobsConfig {
    private static final CommonConfig COMMON_CONFIG = new CommonConfig();
   // private static final CDPClientConfig CLIENT_CONFIG = new CDPClientConfig();
    private static final ServerConfig SERVER_CONFIG = new ServerConfig();
    private static ModConfigSpec COMMON_SPEC;
    //private static ModConfigSpec CLIENT_SPEC;
    private static ModConfigSpec SERVER_SPEC;

    public DionsBitsnBobsConfig(ModContainer container) {
        COMMON_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            COMMON_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.COMMON, spec));
        /*
        CLIENT_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            CLIENT_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.CLIENT, spec));
         */
        SERVER_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            SERVER_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.SERVER, spec));
    }

    public static CommonConfig common() {
        return COMMON_CONFIG;
    }

    public static CommonRecipesConfig commonRecipes() {
        return common().commonRecipes;
    }

    public static ServerConfig server() {
        return SERVER_CONFIG;
    }

    public static FoodConfig food() {
        return SERVER_CONFIG.food;
    }

    public static RecipesConfig recipes() {
        return SERVER_CONFIG.recipes;
    }

    @SubscribeEvent
    public void onLoad(ModConfigEvent.Loading event) {
        var spec = event.getConfig().getSpec();
        if (spec == COMMON_SPEC)
            COMMON_CONFIG.onLoad();
        /*
        else if (spec == CLIENT_SPEC)
            CLIENT_CONFIG.onLoad();
         */
        else if (spec == SERVER_SPEC)
            SERVER_CONFIG.onLoad();
    }

    @SubscribeEvent
    public void onReload(ModConfigEvent.Reloading event) {
        var spec = event.getConfig().getSpec();
        if (spec == COMMON_SPEC)
            COMMON_CONFIG.onReload();
        /*
        else if (spec == CLIENT_SPEC)
            CLIENT_CONFIG.onReload();
         */
        else if (spec == SERVER_SPEC)
            SERVER_CONFIG.onReload();
    }

}
