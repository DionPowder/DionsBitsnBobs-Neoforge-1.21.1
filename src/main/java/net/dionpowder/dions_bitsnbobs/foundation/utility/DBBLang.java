package net.dionpowder.dions_bitsnbobs.foundation.utility;

import com.simibubi.create.Create;
import net.createmod.catnip.lang.LangBuilder;
import net.createmod.catnip.lang.LangNumberFormat;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.ApiStatus;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

@ApiStatus.Internal
public class DBBLang {
    public static LangBuilder builder() {
        return new LangBuilder(DBB.MOD_ID);
    }
    
    public static LangBuilder number(double d) {
        return builder().text(LangNumberFormat.format(d));
    }
    
    public static LangBuilder text(String text) {
        return builder().text(text);
    }
    
    public static LangBuilder translate(String key, Object... args) {
        return builder().translate(key, args);
    }
    
    public static MutableComponent translateDirect(String key, Object... args) {
        Object[] args1 = LangBuilder.resolveBuilders(args);
        return Component.translatable(DBB.MOD_ID + "." + key, args1);
    }
    
    public static LangBuilder description(String category, ResourceLocation location, Object... args) {
        return builder().add(Component.translatable(Util.makeDescriptionId(category, location), args));
    }
    
    public static LangBuilder description(String category, ResourceLocation location, String suffix, Object... args) {
        return builder().add(Component.translatable(Util.makeDescriptionId(category, location) + "." + suffix, args));
    }
    
    public static LangBuilder description(Holder<?> holder, Object... args) {
        var key = holder.getKey();
        if (key == null)
            throw new IllegalArgumentException("Can not build description for unregistered object: " + holder);
        return description(key.registry().getPath(), key.location(), args);
    }
    
    public static LangBuilder description(Holder<?> holder, String suffix, Object... args) {
        var key = holder.getKey();
        if (key == null)
            throw new IllegalArgumentException("Can not build description for unregistered object: " + holder);
        return description(key.registry().getPath(), key.location(), suffix, args);
    }
    
    public static LangBuilder block(BlockState state) {
        return builder().add(state.getBlock().getName());
    }
    
    public static LangBuilder item(ItemStack stack) {
        return builder().add(stack.getHoverName().copy());
    }
    
    public static LangBuilder fluid(FluidStack stack) {
        return builder().add(stack.getHoverName().copy());
    }
    
    public static void addLangToRegistrate() {
        REGISTRATE.addRawLang("entity.minecraft.villager.dions_bitsnbobs.baker", "Baker");
        REGISTRATE.addRawLang("entity.minecraft.villager.baker", "Baker");
        REGISTRATE.addRawLang("item.minecraft.potion.effect.sugar_rush_potion", "Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.splash_potion.effect.sugar_rush_potion", "Splash Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.lingering_potion.effect.sugar_rush_potion", "Lingering Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.tipped_arrow.effect.sugar_rush_potion", "Arrow of Sugar Rush");
        REGISTRATE.addRawLang("effect.dions_bitsnbobs.sugar_rush", "Sugar Rush");
        REGISTRATE.addRawLang("effect.dions_bitsnbobs.sugar_rush.description", "Increases movement and mining speed; higher levels increase both stats further.");
        REGISTRATE.addRawLang("dions_bitsnbobs.recipe.food_sprinkling", "Food Sprinkling");
        REGISTRATE.addRawLang("dions_bitsnbobs.recipe.fan_frosting", "Bulk Frosting");
        REGISTRATE.addRawLang("dions_bitsnbobs.recipe.fan_chocolate_glazing", "Bulk Chocolate Glazing");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.donuts", "Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.simple_donuts", "Simple Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.frosting_donuts", "Frosting Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.topped_frosting_donuts", "Topped Frosting Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.chocolate_donuts", "Chocolate Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.topped_chocolate_donuts", "Topped Chocolate Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.double_glazed_donuts", "Double Glazed Donuts");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.sprinkles", "Sprinkles");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.advancement_glazed_donut", "Advancement Glazed Donut");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.advancement_topped_donut", "Advancement Topped Donut");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.rooted_dirt_mixing", "Rooted Dirt Mixing");
        REGISTRATE.addRawLang("tag.dions_bitsnbobs.unprocessed_components", "Unprocessed Components");
        REGISTRATE.addRawLang("dions_bitsnbobs.recipe.assembly.sprinkling_item", "Sprinkle %1$s");
        REGISTRATE.addRawLang("dions_bitsnbobs.tooltip.food_sprinkler.locked", "[Redstone Locked]");
    }
    
}