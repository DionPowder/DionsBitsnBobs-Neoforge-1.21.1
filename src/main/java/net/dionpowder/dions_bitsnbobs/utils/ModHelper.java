package net.dionpowder.dions_bitsnbobs.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModHelper {

    public static Item getItemFromOtherMod(String namespaceAndName) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.parse(namespaceAndName));
    }

}
