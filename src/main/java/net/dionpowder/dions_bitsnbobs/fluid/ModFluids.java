package net.dionpowder.dions_bitsnbobs.fluid;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.dionpowder.dions_bitsnbobs.DionsBitsnBobs;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class ModFluids {
    private static final CreateRegistrate REGISTRATE = DionsBitsnBobs.registrate();

    public static void register() {
        DionsBitsnBobs.LOGGER.info("Registering fluids for " + DionsBitsnBobs.NAME);
       // fluids();
    }

    public static FluidEntry<BaseFlowingFluid.Flowing> STRAWBERRY_FROSTING;

}
