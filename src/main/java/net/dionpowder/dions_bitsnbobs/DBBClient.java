package net.dionpowder.dions_bitsnbobs;

import net.createmod.ponder.foundation.PonderIndex;
import net.dionpowder.dions_bitsnbobs.foundation.ponder.DBBPonderPlugin;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = DBB.MOD_ID, dist = Dist.CLIENT)
public class DBBClient {
    
    public DBBClient(IEventBus modEventBus) {
        onCtorClient(modEventBus);
    }
    
    public static void onCtorClient(IEventBus modEventBus) {
        IEventBus neoEventBus = NeoForge.EVENT_BUS;
        modEventBus.addListener(DBBClient::clientInit);
    }
    
    public static void clientInit(final FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new DBBPonderPlugin());
    }

}
