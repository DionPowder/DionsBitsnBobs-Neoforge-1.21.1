package net.dionpowder.dions_bitsnbobs.utils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;
import static net.dionpowder.dions_bitsnbobs.DBBEvents.randomBetween;

public class DBBHelper {
    
    public static void addLangToRegistrate() {
        REGISTRATE.addRawLang("entity.minecraft.villager.dions_bitsnbobs.baker", "Baker");
        REGISTRATE.addRawLang("entity.minecraft.villager.baker", "Baker");
        REGISTRATE.addRawLang("item.minecraft.potion.effect.sugar_rush_potion", "Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.splash_potion.effect.sugar_rush_potion", "Splash Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.lingering_potion.effect.sugar_rush_potion", "Lingering Potion of Sugar Rush");
        REGISTRATE.addRawLang("item.minecraft.tipped_arrow.effect.sugar_rush_potion", "Arrow of Sugar Rush");
        REGISTRATE.addRawLang("effect.dions_bitsnbobs.sugar_rush", "Sugar Rush");
        REGISTRATE.addRawLang("effect.dions_bitsnbobs.sugar_rush.description", "Increases movement and mining speed; higher levels increase both stats further.");
        REGISTRATE.addRawLang("create.recipe.fan_frosting", "Bulk Frosting");
        REGISTRATE.addRawLang("create.recipe.fan_chocolate_glazing", "Bulk Chocolate Glazing");
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
    }

    // standard villager sell trades
    public static Int2ObjectMap<List<VillagerTrades.ItemListing>> getStandardSellTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

        trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(DBBHelper.getRandomItemFromTag(DBBTags.Items.ADVANCEMENT_GLAZED_DONUT, randomSource), randomBetween(randomSource, 8, 12)),
                new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
        trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(DBBHelper.getRandomItemFromTag(DBBTags.Items.ADVANCEMENT_TOPPED_DONUT, randomSource), randomBetween(randomSource, 6, 10)),
                new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
        trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(DBBHelper.getRandomItemFromTag(DBBTags.Items.DOUBLE_GLAZED_DONUTS, randomSource), randomBetween(randomSource, 4, 8)),
                new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));

        return trades;
    }

    // get random item from tag
    public static Item getRandomItemFromTag(TagKey<Item> tag, RandomSource random) {
        List<Item> items = BuiltInRegistries.ITEM
                .getTag(tag)
                .map(named -> named.stream()
                        .map(Holder::value)
                        .toList())
                .orElse(List.of());

        if (items.isEmpty())
            return Items.AIR;

        return items.get(random.nextInt(items.size()));
    }

}
