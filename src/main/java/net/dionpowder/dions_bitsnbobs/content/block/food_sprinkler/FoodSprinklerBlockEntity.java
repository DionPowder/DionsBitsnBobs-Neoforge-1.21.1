package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.item.ItemHelper;
import com.simibubi.create.foundation.utility.CreateLang;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.block.DBBBlockEntityTypes;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.AdvancementBehaviour;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.CreateAdvancement;
import net.dionpowder.dions_bitsnbobs.foundation.advancement.DBBAdvancements;
import net.dionpowder.dions_bitsnbobs.foundation.utility.DBBLang;
import net.dionpowder.dions_bitsnbobs.foundation.utility.DBBTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import java.util.List;

public class FoodSprinklerBlockEntity extends KineticBlockEntity implements Clearable {
    
    public FoodSprinklerInventory inventory;
    protected FoodSprinklingBehaviour behaviour;
    protected boolean redstoneLocked;
    private int donutsSprinkled;

    public FoodSprinklerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        inventory = new FoodSprinklerInventory(1, this);
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DBBBlockEntityTypes.FOOD_SPRINKLER.get(), (be, context) -> be.inventory);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        behaviour = new FoodSprinklingBehaviour(this);
        behaviours.add(behaviour);
        behaviours.add(new AdvancementBehaviour(this, DBBAdvancements.AUTOMATED_TOPPINGS, DBBAdvancements.TOPPING_FACTORY));
    }

    public FoodSprinklingBehaviour getFoodSprinklingBehaviour() {
        return behaviour;
    }

    public void award(CreateAdvancement advancement) {
        AdvancementBehaviour advancementBehaviour = getBehaviour(AdvancementBehaviour.TYPE);
        if (advancementBehaviour != null)
            advancementBehaviour.awardPlayer(advancement);
    }

    public void onSprinkled(ItemStack result) {
        award(DBBAdvancements.AUTOMATED_TOPPINGS);
        if (result.is(DBBTags.Items.ADVANCEMENT_TOPPED_DONUT)) {
            donutsSprinkled += result.getCount();
            if (donutsSprinkled >= 1000) {
                award(DBBAdvancements.TOPPING_FACTORY);
                donutsSprinkled = 0;
            }
        }
    }

    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(compound, registries, clientPacket);
        inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
        redstoneLocked = compound.getBoolean("Powered");
        donutsSprinkled = compound.getInt("DonutsSprinkled");
    }

    @Override
    public void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(compound, registries, clientPacket);
        compound.put("Inventory", inventory.serializeNBT(registries));
        compound.putBoolean("Powered", redstoneLocked);
        if (getBehaviour(AdvancementBehaviour.TYPE).isOwnerPresent())
            compound.putInt("DonutsSprinkled", donutsSprinkled);
    }
    
    public void redstoneUpdate() {
        if (level.isClientSide)
            return;
        boolean blockPowered = level.hasNeighborSignal(worldPosition);
        if (blockPowered == redstoneLocked)
            return;
        redstoneLocked = blockPowered;
        if (redstoneLocked && behaviour.state == FoodSprinklingBehaviour.State.RUNNING)
            behaviour.finish();
        sendData();
    }
    
    public void lock() {
        redstoneLocked = true;
    }
    
    @Override
    protected AABB createRenderBoundingBox() {
        return super.createRenderBoundingBox().inflate(3);
    }
    
    @Override
    public void clearContent() {
        inventory.clearContent();
    }
    
    @Override
    public void destroy() {
        super.destroy();
        ItemHelper.dropContents(level, worldPosition, inventory);
    }
    
    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        boolean added = super.addToGoggleTooltip(tooltip, isPlayerSneaking);
        
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stackInSlot = inventory.getStackInSlot(i);
            if (stackInSlot.isEmpty())
                continue;
            CreateLang.text("")
                    .add(Component.translatable(stackInSlot.getDescriptionId())
                            .withStyle(ChatFormatting.GRAY))
                    .add(CreateLang.text(" x" + stackInSlot.getCount())
                            .style(ChatFormatting.GREEN))
                    .forGoggles(tooltip, 0);
            added = true;
        }
        
        if (redstoneLocked) {
            DBBLang.translate("tooltip.food_sprinkler.locked")
                    .style(ChatFormatting.RED)
                    .forGoggles(tooltip);
            added = true;
        }
        
        return added;
    }
    
    public float getRenderedHeadRotationSpeed(float partialTicks) {
        float speed = getSpeed();
        if (behaviour.state == FoodSprinklingBehaviour.State.RUNNING) {
            return speed;
        }
        return speed / 4;
    }
    
}