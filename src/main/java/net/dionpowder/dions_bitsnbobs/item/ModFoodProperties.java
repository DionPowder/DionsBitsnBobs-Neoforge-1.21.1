package net.dionpowder.dions_bitsnbobs.item;

import net.dionpowder.dions_bitsnbobs.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).build();
    public static final FoodProperties UNCOOKED_DONUT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f)
            .alwaysEdible()
            .build();
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties SUGAR_DONUT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties FROSTING_DONUTS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties TOPPED_FROSTING_DONUTS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties CHOCOLATE_DONUTS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties TOPPED_CHOCOLATE_DONUTS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties DOUBLE_GLAZED_DONUTS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible().build();
    public static final FoodProperties SPRINKLES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f)
            .fast()
            .effect(() -> new MobEffectInstance(ModEffects.SUGAR_RUSH_EFFECT, 500, 0), 1.0f)
            .alwaysEdible()
            .build();
}
