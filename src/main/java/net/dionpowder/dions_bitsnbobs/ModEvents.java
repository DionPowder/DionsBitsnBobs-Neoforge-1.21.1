package net.dionpowder.dions_bitsnbobs;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dionpowder.dions_bitsnbobs.config.CommonConfig;
import net.dionpowder.dions_bitsnbobs.config.DionsBitsnBobsConfig;
import net.dionpowder.dions_bitsnbobs.content.fluid.ModFluids;
import net.dionpowder.dions_bitsnbobs.content.item.ModItems;
import net.dionpowder.dions_bitsnbobs.content.potion.ModPotions;
import net.dionpowder.dions_bitsnbobs.utils.ModHelper;
import net.dionpowder.dions_bitsnbobs.content.villager.ModVillagers;
import net.dionpowder.dions_bitsnbobs.utils.ModTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
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
                    new ItemStack(ModHelper.getRandomItemFromTag(ModTags.Items.BAKER_FROSTING_TRADES, randomSource), 1), 2, 10, 0.05f));
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 2, 4)),
                    new ItemStack(ModHelper.getRandomItemFromTag(ModTags.Items.BAKER_CHOCOLATE_TRADES, randomSource), 1), 2, 10, 0.05f));
            // tier 4
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 3, 5)),
                    new ItemStack(ModHelper.getRandomItemFromTag(ModTags.Items.ADVANCEMENT_GLAZED_DONUT, randomSource), randomBetween(randomSource, 10, 14)), 8, 15, 0.05f));
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 3, 5)),
                    new ItemStack(ModHelper.getRandomItemFromTag(ModTags.Items.ADVANCEMENT_TOPPED_DONUT, randomSource), randomBetween(randomSource, 8, 12)), 8, 15, 0.05f));
            // tier 5
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, randomBetween(randomSource, 4, 6)),
                    new ItemStack(ModHelper.getRandomItemFromTag(ModTags.Items.DOUBLE_GLAZED_DONUTS, randomSource), randomBetween(randomSource, 6, 8)), 6, 20, 0.05f));

        }

        if (!DionsBitsnBobsConfig.common().DONUT_SELLING.get()) return;

        // donut selling
        if(event.getType() == VillagerProfession.FARMER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.BUTCHER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.ARMORER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.CLERIC) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.CARTOGRAPHER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.FISHERMAN) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.FLETCHER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.LEATHERWORKER) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.LIBRARIAN) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.SHEPHERD) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.MASON) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.TOOLSMITH) {
            ModHelper.getStandardSellTrades(event);
        }

        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            ModHelper.getStandardSellTrades(event);
        }

    }

    public static int randomBetween(RandomSource random, int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BOTTLED_RAINBOW_SPRINKLES.get(), ModPotions.SUGAR_RUSH_POTION);
        builder.addMix(Potions.AWKWARD, ModItems.BOTTLED_WHITE_SPRINKLES.get(), ModPotions.SUGAR_RUSH_POTION);
        builder.addMix(Potions.AWKWARD, ModItems.BOTTLED_GREEN_SPRINKLES.get(), ModPotions.SUGAR_RUSH_POTION);
    }

}
