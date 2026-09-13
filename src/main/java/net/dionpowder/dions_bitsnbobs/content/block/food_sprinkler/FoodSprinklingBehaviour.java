package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.belt.BeltHelper;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.math.VecHelper;
import net.dionpowder.dions_bitsnbobs.config.DBBConfig;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodSprinklingBehaviour extends BeltProcessingBehaviour {
    
    private final FoodSprinklerBlockEntity foodSprinkler;
    public static final int CYCLE = 320;
    
    public int prevRunningTicks;
    public int runningTicks;
    public int ticksWithoutProcessing = 0;
    public State state = State.WAITING;
    
    public enum State {
        WAITING,
        RUNNING;
    }
    
    public FoodSprinklingBehaviour(FoodSprinklerBlockEntity foodSprinkler) {
        super(foodSprinkler);
        this.foodSprinkler = foodSprinkler;
        whenItemEnters(this::onItemReceived);
        whileItemHeld(this::whenItemHeld);
    }
    
    @Override
    public void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        state = State.values()[compound.getInt("State")];
        prevRunningTicks = runningTicks = compound.getInt("Ticks");
        super.read(compound, registries, clientPacket);
    }
    
    @Override
    public void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        compound.putInt("State", state.ordinal());
        compound.putInt("Ticks", runningTicks);
        super.write(compound, registries, clientPacket);
    }
    
    @Override
    public void tick() {
        super.tick();
        if (blockEntity.getLevel().isClientSide && state == State.RUNNING) {
            spawnSprinklingParticles();
        }
        if (blockEntity.getLevel() == null || blockEntity.getLevel().isClientSide)
            return;
        if (state == State.RUNNING) {
            ticksWithoutProcessing++;
            if (ticksWithoutProcessing > 5) {
                ticksWithoutProcessing = 0;
                finish();
            }
        }
    }
    
    protected ProcessingResult onItemReceived(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler) {
        if (foodSprinkler.getSpeed() == 0 || foodSprinkler.redstoneLocked)
            return ProcessingResult.PASS;
        if (foodSprinkler.inventory.isEmpty())
            return ProcessingResult.HOLD;

        if (getRecipe(transported.stack) == null)
            return ProcessingResult.PASS;

        start();
        return ProcessingResult.HOLD;
    }

    protected ProcessingResult whenItemHeld(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler) {
        ticksWithoutProcessing = 0;
        
        if (foodSprinkler.getSpeed() == 0 || foodSprinkler.redstoneLocked)
            return ProcessingResult.PASS;
        if (foodSprinkler.inventory.isEmpty())
            return ProcessingResult.HOLD;
        
        RecipeHolder<? extends Recipe<?>> recipeHolder = getRecipe(transported.stack);
        if (recipeHolder == null)
            return ProcessingResult.PASS;

        if (state == State.WAITING) {
            start();
            return ProcessingResult.HOLD;
        }

        prevRunningTicks = runningTicks;
        runningTicks += getRunningTickSpeed();

        if (runningTicks < CYCLE / 2)
            return ProcessingResult.HOLD;

        if (prevRunningTicks >= CYCLE / 2)
            return runningTicks >= CYCLE ? ProcessingResult.PASS : ProcessingResult.HOLD;

        int availableIngredients = foodSprinkler.inventory.getItem(0).getCount();
        int stackSize = transported.stack.getCount();
        int toProcess = canProcessInBulk(transported.stack)
                ? Math.min(stackSize, availableIngredients)
                : 1;

        List<ItemStack> outputs =
                RecipeApplier.applyRecipeOn(blockEntity.getLevel(), transported.stack.copyWithCount(toProcess), recipeHolder.value(), false);

        List<TransportedItemStack> collect =
                outputs.stream()
                        .map(stack -> {
                            TransportedItemStack copy = transported.copy();
                            boolean centered = BeltHelper.isItemUpright(stack);
                            copy.stack = stack;
                            copy.locked = true;
                            copy.angle = centered ? 180 : Create.RANDOM.nextInt(360);
                            return copy;
                        })
                        .map(t -> {
                            t.locked = false;
                            return t;
                        })
                        .collect(Collectors.toList());
        
        transported.clearFanProcessingData();
        
        TransportedItemStack left = transported.copy();
        left.stack.shrink(toProcess);
        
        if (collect.isEmpty()) {
            handler.handleProcessingOnItem(transported, TransportedItemStackHandlerBehaviour.TransportedResult.convertTo(left));
        } else {
            handler.handleProcessingOnItem(transported, TransportedItemStackHandlerBehaviour.TransportedResult.convertToAndLeaveHeld(collect, left));
        }
        
        foodSprinkler.inventory.getItem(0).shrink(toProcess);
        foodSprinkler.notifyUpdate();

        for (ItemStack result : outputs) {
            if (!result.isEmpty()) {
                foodSprinkler.onSprinkled(result);
                break;
            }
        }

        finish();
        return ProcessingResult.HOLD;
    }
    
    public void spawnSprinklingParticles() {
        Level level = blockEntity.getLevel();
        if (level == null || !level.isClientSide) return;
        
        ItemStack ingredient = foodSprinkler.inventory.getItem(0);
        if (ingredient.isEmpty()) return;
        
        float speed = foodSprinkler.getSpeed();
        float absSpeed = Math.abs(speed);
        float direction = speed > 0 ? 1f : -1f;
        int particleCount = 4;
        float radius = 0.25f;
        
        float angleOffset = runningTicks * (absSpeed / 256f) * direction;
        
        for (int i = 0; i < particleCount; i++) {
            float angle = (float) Math.toRadians(angleOffset + (i * (360f / particleCount)));
            
            Vec3 origin = VecHelper.getCenterOf(blockEntity.getBlockPos())
                    .add(0, -0.5, 0);
            
            double x = origin.x + radius * Math.cos(angle);
            double z = origin.z + radius * Math.sin(angle);
            double y = origin.y;
            
            level.addParticle(
                    new ItemParticleOption(ParticleTypes.ITEM, ingredient),
                    x, y, z,
                    0, -0.05 - (absSpeed / 2048f), 0
            );
        }
    }
    
    public void start() {
        state = State.RUNNING;
        prevRunningTicks = 0;
        runningTicks = 0;
        foodSprinkler.sendData();
    }
    
    public void finish() {
        state = State.WAITING;
        prevRunningTicks = 0;
        runningTicks = 0;
        foodSprinkler.sendData();
    }
    
    public int getRunningTickSpeed() {
        float speed = foodSprinkler.getSpeed();
        if (speed == 0)
            return 0;
        return (int) Mth.lerp(Mth.clamp(Math.abs(speed) / 512f, 0, 1), 1, 60);
    }
    
    public boolean canProcessInBulk(ItemStack stack) {
        return DBBConfig.server().recipes.BULK_FOOD_SPRINKLING.get() || stack.getCount() == 1;
    }
    
    ItemStackHandler recipeInv = new ItemStackHandler(2);
    public RecipeHolder<? extends Recipe<? extends RecipeInput>> getRecipe(ItemStack stack) {
        Level level = foodSprinkler.getLevel();
        
        if (level == null)
            return null;

        recipeInv.setStackInSlot(0, stack);
        recipeInv.setStackInSlot(1, foodSprinkler.inventory.getItem(0));

        FoodSprinklerRecipeSearchEvent event = new FoodSprinklerRecipeSearchEvent(foodSprinkler, new RecipeWrapper(recipeInv));

        event.addRecipe(() -> SequencedAssemblyRecipe.getRecipe(level, event.getInventory(),
                DBBRecipeTypes.FOOD_SPRINKLING.getType(), FoodSprinklingRecipe.class), 100);
        event.addRecipe(() -> checkRecipe(event.getInventory(), level), 50);

        NeoForge.EVENT_BUS.post(event);
        return event.getRecipe();
    }
    
    private Optional<RecipeHolder<Recipe<RecipeInput>>> checkRecipe(RecipeInput inv, Level level) {
        return DBBRecipeTypes.FOOD_SPRINKLING.find(inv, level).filter(AllRecipeTypes.CAN_BE_AUTOMATED);
    }
    
}