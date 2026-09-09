package net.dionpowder.dions_bitsnbobs.content.block;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklerBlockEntity;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklerRenderer;
import net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler.FoodSprinklerVisual;

import static net.dionpowder.dions_bitsnbobs.DBB.REGISTRATE;

public class DBBBlockEntityTypes {
    
    public static final BlockEntityEntry<FoodSprinklerBlockEntity> FOOD_SPRINKLER = REGISTRATE
            .blockEntity("food_sprinkler", FoodSprinklerBlockEntity::new)
            .visual(() -> FoodSprinklerVisual::new)
            .validBlocks(DBBBlocks.FOOD_SPRINKLER)
            .renderer(() -> FoodSprinklerRenderer::new)
            .register();
    
    public static void register() {
    }
    
}
