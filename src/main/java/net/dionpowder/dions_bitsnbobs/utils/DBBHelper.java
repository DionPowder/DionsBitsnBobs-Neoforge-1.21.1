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

import static net.dionpowder.dions_bitsnbobs.DBBEvents.randomBetween;

public class DBBHelper {

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
