package net.dionpowder.dions_bitsnbobs.content.block;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.dionpowder.dions_bitsnbobs.DBB;

public class DBBPartialModels {
    
    public static final PartialModel
            
            FOOD_SPRINKLER_HEAD = block("food_sprinkler/head");
    
    private static PartialModel block(String path) {
        return PartialModel.of(DBB.rl("block/" + path));
    }
    
    public static void init() {
        // init static fields
    }
    
}
