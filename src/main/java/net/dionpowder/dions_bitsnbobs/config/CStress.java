package net.dionpowder.dions_bitsnbobs.config;

import com.simibubi.create.api.stress.BlockStressValues;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleSupplier;
import net.createmod.catnip.config.ConfigBase;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.ModConfigSpec.Builder;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import org.jetbrains.annotations.Nullable;

public class CStress extends ConfigBase {
    protected final String modid;
    protected final Object2DoubleMap<ResourceLocation> defaultImpacts = new Object2DoubleOpenHashMap<>();
    protected final Object2DoubleMap<ResourceLocation> defaultCapacities = new Object2DoubleOpenHashMap<>();
    protected final Map<ResourceLocation, ConfigValue<Double>> impacts = new HashMap<>();
    protected final Map<ResourceLocation, ConfigValue<Double>> capacities = new HashMap<>();
    
    public CStress(String modid) {
        this.modid = modid;
    }
    
    protected int getVersion() {
        return 1;
    }
    
    @Override
    public void registerAll(Builder builder) {
        builder.comment(".", Comments.su, Comments.impact).push("impact");
        defaultImpacts.forEach((id, value) -> this.impacts.put(id, builder.define(id.getPath(), value)));
        builder.pop();
        
        builder.comment(".", Comments.su, Comments.capacity).push("capacity");
        defaultCapacities.forEach((id, value) -> this.capacities.put(id, builder.define(id.getPath(), value)));
        builder.pop();
        
        BlockStressValues.IMPACTS.registerProvider(this::getImpact);
        BlockStressValues.CAPACITIES.registerProvider(this::getCapacity);
    }
    
    @Override
    public String getName() {
        return "stressValues.v" + getVersion();
    }
    
    public @Nullable DoubleSupplier getImpact(Block block) {
        ResourceLocation id = RegisteredObjectsHelper.getKeyOrThrow(block);
        ConfigValue<Double> value = this.impacts.get(id);
        return value == null ? null : value::get;
    }
    
    public @Nullable DoubleSupplier getCapacity(Block block) {
        ResourceLocation id = RegisteredObjectsHelper.getKeyOrThrow(block);
        ConfigValue<Double> value = this.capacities.get(id);
        return value == null ? null : value::get;
    }
    
    public <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> setNoImpact() {
        return setImpact(0);
    }
    
    public <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> setImpact(double value) {
        return builder -> {
            validateOwningMod(builder);
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modid, builder.getName());
            defaultImpacts.put(id, value);
            return builder;
        };
    }
    
    public <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B, P>> setCapacity(double value) {
        return builder -> {
            validateOwningMod(builder);
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(modid, builder.getName());
            defaultCapacities.put(id, value);
            return builder;
        };
    }
    
    private void validateOwningMod(BlockBuilder<?, ?> builder) {
        if (!builder.getOwner().getModid().equals(modid)) {
            throw new IllegalStateException("Config only accepts blocks from " + modid);
        }
    }
    
    static class Comments {
        static String su = "[in Stress Units]";
        static String impact = "Configure the individual stress impact of mechanical blocks. Note that this cost is doubled for every speed increase it receives.";
        static String capacity = "Configure how much stress a source can accommodate for.";
    }
}