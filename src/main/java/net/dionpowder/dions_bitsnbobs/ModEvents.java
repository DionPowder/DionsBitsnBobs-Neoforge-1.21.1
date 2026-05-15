package net.dionpowder.dions_bitsnbobs;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dionpowder.dions_bitsnbobs.config.CommonConfig;
import net.dionpowder.dions_bitsnbobs.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.item.ModItems;
import net.dionpowder.dions_bitsnbobs.villager.ModVillagers;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = DionsBitsnBobs.MOD_ID)
public class ModEvents{

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.BAKER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // tier 1
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.STRAWBERRY, randomBetween(randomSource, 16, 24)),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.WHEAT, randomBetween(randomSource, 14, 20)),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(AllItems.WHEAT_FLOUR, randomBetween(randomSource, 10, 14)),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.COCOA_BEANS, randomBetween(randomSource, 12, 18)),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.SUGAR_CANE, randomBetween(randomSource, 10, 14)),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
            // tier 2
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.SUGAR, randomBetween(randomSource, 6, 12)),
                    new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(AllItems.DOUGH, randomBetween(randomSource, 6, 12)),
                    new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.DRAGON_BREATH, randomBetween(randomSource, 1, 3)),
                    new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.UNCOOKED_DONUT, randomBetween(randomSource, 8, 14)),
                    new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.DONUT, randomBetween(randomSource, 6, 10)),
                    new ItemStack(Items.EMERALD, 1), 12, 10, 0.05f));
            // tier 3
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModFluids.STRAWBERRY_FROSTING_BUCKET.get(), 1), 2, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModFluids.ORANGE_FROSTING_BUCKET.get(), 1), 2, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModFluids.BLUEBERRY_FROSTING_BUCKET.get(), 1), 2, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModFluids.PEAR_FROSTING_BUCKET.get(), 1), 2, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 1, 2)),
                    new ItemStack(AllFluids.CHOCOLATE.get().getBucket(), 1), 2, 10, 0.05f));
            // tier 4
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.BLUEBERRY_DONUT.get(), randomBetween(randomSource, 10, 14)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.ORANGE_DONUT.get(), randomBetween(randomSource, 10, 14)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.WHITE_CHOCOLATE_DONUT.get(), randomBetween(randomSource, 10, 14)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.RUBY_CHOCOLATE_DONUT.get(), randomBetween(randomSource, 10, 14)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.SPRINKLED_STRAWBERRY_DONUT.get(), randomBetween(randomSource, 8, 12)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.SPRINKLED_PEAR_DONUT.get(), randomBetween(randomSource, 8, 12)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.STRAWBERRY_TOPPED_DARK_CHOCOLATE_DONUT.get(), randomBetween(randomSource, 8, 12)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 3)),
                    new ItemStack(ModItems.SPRINKLED_WHITE_CHOCOLATE_DONUT.get(), randomBetween(randomSource, 8, 12)), 8, 15, 0.05f));
            // tier 5
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModItems.CHOCOLATE_HONEY_DONUT.get(), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModItems.WHITE_CHOCOLATE_HONEY_DONUT.get(), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModItems.CHOCOLATE_STRAWBERRY_DONUT.get(), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModItems.WHITE_CHOCOLATE_RUBY_DONUT.get(), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModItems.WHITE_CHOCOLATE_PEAR_DONUT.get(), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));

        }

        if (!CommonConfig.DONUT_SELLING.get()) return;

        // donut selling
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                        new ItemCost(ModItems.STRAWBERRY_DONUT, randomBetween(randomSource, 8, 12)),
                        new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
                trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                        new ItemCost(ModItems.ORANGE_DONUT, randomBetween(randomSource, 8, 12)),
                        new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
                trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                        new ItemCost(ModItems.PEAR_DONUT, randomBetween(randomSource, 8, 12)),
                        new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
                trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                        new ItemCost(ModItems.BLUEBERRY_DONUT, randomBetween(randomSource, 8, 12)),
                        new ItemStack(Items.EMERALD, 1), 5, 2, 0.05f));
            }

    }

    public static int randomBetween(RandomSource random, int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}
