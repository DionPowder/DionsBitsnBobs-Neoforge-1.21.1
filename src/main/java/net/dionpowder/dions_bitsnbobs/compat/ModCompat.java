package net.dionpowder.dions_bitsnbobs.compat;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;

public enum ModCompat {
    CREATE_CONFECTIONERY(Mods.CREATE_CONFECTIONERY),
    INTEGRATED_FARMING(Mods.INTEGRATED_FARMING);
    
    private final String id;
    
    ModCompat(String id) {
        this.id = id;
    }
    
    public String id() {
        return id;
    }
    
    public boolean enabled() {
        return ModList.get().isLoaded(id);
    }
    
    public ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(id, path);
    }
    
    public ModLoadedCondition condition() {
        return new ModLoadedCondition(id);
    }
    
    public NotCondition invertedCondition() {
        return new NotCondition(new ModLoadedCondition(id));
    }
    
    public static class Mods {
        public static final String CREATE_CONFECTIONERY = "create_confectionery";
        public static final String INTEGRATED_FARMING = "create_integrated_farming";
    }
}