package net.dionpowder.dions_bitsnbobs.config;

import net.minecraft.Util;
import net.minecraft.util.Unit;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class DBBConfig {
    private static final CCommon COMMON_CONFIG = new CCommon();
    private static final CClient CLIENT_CONFIG = new CClient();
    private static final CServer SERVER_CONFIG = new CServer();
    private static ModConfigSpec COMMON_SPEC;
    private static ModConfigSpec CLIENT_SPEC;
    private static ModConfigSpec SERVER_SPEC;

    public DBBConfig(ModContainer container) {
        COMMON_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            COMMON_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.COMMON, spec));
        
        CLIENT_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            CLIENT_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.CLIENT, spec));
        
        SERVER_SPEC = Util.make(new ModConfigSpec.Builder().configure(builder -> {
            SERVER_CONFIG.registerAll(builder);
            return Unit.INSTANCE;
        }).getValue(), spec -> container.registerConfig(Type.SERVER, spec));
    }
    
    public static CClient client() {return CLIENT_CONFIG;}
    
    public static CFluidFogSettings fluidFogSettingsConfig() {return client().fluidFogSettings;}

    public static CCommon common() {
        return COMMON_CONFIG;
    }

    public static CCRecipes commonRecipes() {
        return common().commonRecipes;
    }

    public static CServer server() {
        return SERVER_CONFIG;
    }

    public static CFood food() {
        return SERVER_CONFIG.food;
    }

    public static CRecipes recipes() {
        return SERVER_CONFIG.recipes;
    }

    @SubscribeEvent
    public void onLoad(ModConfigEvent.Loading event) {
        var spec = event.getConfig().getSpec();
        if (spec == COMMON_SPEC)
            COMMON_CONFIG.onLoad();
        
        else if (spec == CLIENT_SPEC)
            CLIENT_CONFIG.onLoad();
         
        else if (spec == SERVER_SPEC)
            SERVER_CONFIG.onLoad();
    }

    @SubscribeEvent
    public void onReload(ModConfigEvent.Reloading event) {
        var spec = event.getConfig().getSpec();
        if (spec == COMMON_SPEC)
            COMMON_CONFIG.onReload();
        
        else if (spec == CLIENT_SPEC)
            CLIENT_CONFIG.onReload();
         
        else if (spec == SERVER_SPEC)
            SERVER_CONFIG.onReload();
    }

}
