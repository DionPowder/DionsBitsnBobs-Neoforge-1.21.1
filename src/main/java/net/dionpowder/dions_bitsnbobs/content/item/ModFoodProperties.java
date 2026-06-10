package net.dionpowder.dions_bitsnbobs.content.item;

import net.dionpowder.dions_bitsnbobs.content.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodProperties UNCOOKED_DONUT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f)
            .alwaysEdible()
            .build();
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4f).alwaysEdible().build();
    public static final FoodProperties SUGAR_DONUT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).alwaysEdible().build();
    public static final FoodProperties FROSTING_DONUTS = new FoodProperties.Builder().nutrition(8).saturationModifier(0.5f).alwaysEdible().build();
    public static final FoodProperties TOPPED_FROSTING_DONUTS = new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).alwaysEdible().build();
    public static final FoodProperties CHOCOLATE_DONUTS = new FoodProperties.Builder().nutrition(9).saturationModifier(0.5f).alwaysEdible().build();
    public static final FoodProperties TOPPED_CHOCOLATE_DONUTS = new FoodProperties.Builder().nutrition(11).saturationModifier(0.5f).alwaysEdible().build();
    public static final FoodProperties DOUBLE_GLAZED_DONUTS = new FoodProperties.Builder().nutrition(14).saturationModifier(0.6f).alwaysEdible().build();
    public static final FoodProperties SPRINKLES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f)
            .fast()
            .effect(() -> new MobEffectInstance(ModEffects.SUGAR_RUSH_EFFECT, 300, 0), 1.0f)
            .alwaysEdible()
            .build();
}
