package net.dionpowder.dions_bitsnbobs.content.block.food_sprinkler;

import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.belt.BeltHelper;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.math.VecHelper;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.config.DBBConfig;
import net.dionpowder.dions_bitsnbobs.content.recipe.DBBRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
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
        if (foodSprinkler.getSpeed() == 0)
            return ProcessingResult.PASS;
        if (!CanBeSprinkled(foodSprinkler.getLevel(), transported.stack))
            return ProcessingResult.PASS;
        if (foodSprinkler.inventory.isEmpty())
            return ProcessingResult.HOLD;
        
        Optional<RecipeHolder<FoodSprinklingRecipe>> recipe = getRecipe(foodSprinkler.getLevel(), transported.stack);
        if (recipe.isEmpty())
            return ProcessingResult.PASS;
        if (!recipe.get().value().getIngredients().get(1).test(foodSprinkler.inventory.getItem(0)))
            return ProcessingResult.PASS;
        
        start();
        return ProcessingResult.HOLD;
    }
    
    protected ProcessingResult whenItemHeld(TransportedItemStack transported, TransportedItemStackHandlerBehaviour handler) {
        ticksWithoutProcessing = 0;
        
        if (foodSprinkler.getSpeed() == 0)
            return ProcessingResult.PASS;
        if (foodSprinkler.inventory.isEmpty())
            return ProcessingResult.HOLD;
        
        Optional<RecipeHolder<FoodSprinklingRecipe>> recipe = getRecipe(foodSprinkler.getLevel(), transported.stack);
        if (recipe.isEmpty())
            return ProcessingResult.PASS;
        if (!recipe.get().value().getIngredients().get(1).test(foodSprinkler.inventory.getItem(0)))
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
        
        RecipeHolder<FoodSprinklingRecipe> matched = recipe.get();
        
        int availableIngredients = foodSprinkler.inventory.getItem(0).getCount();
        int stackSize = transported.stack.getCount();
        int toProcess = canProcessInBulk(transported.stack)
                ? Math.min(stackSize, availableIngredients)
                : 1;
        
        List<TransportedItemStack> collect =
                RecipeApplier.applyRecipeOn(blockEntity.getLevel(), transported.stack.copyWithCount(toProcess), matched.value(), false)
                        .stream()
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
            
            // Zero horizontal motion, only fall straight down
            // The spiral appearance comes from new particles spawning at the rotated position each tick
            level.addParticle(
                    new ItemParticleOption(ParticleTypes.ITEM, ingredient),
                    x, y, z,
                    0, -0.05 - (absSpeed / 2048f), 0
            );
        }
    }
    
    // recipe handling
    public void start() {
        state = State.RUNNING;
        prevRunningTicks = 0;
        runningTicks = 0;
        foodSprinkler.sendData();
    }
    
    // add a check here to see if there are any items left that can be processed, if so keep the visual going instead of creating hitches
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
    
    public static boolean CanBeSprinkled(Level world, ItemStack stack) {
        SingleRecipeInput input = new SingleRecipeInput(stack);
        return DBBRecipeTypes.FOOD_SPRINKLING.find(input, world).isPresent();
    }
    
    protected Optional<RecipeHolder<FoodSprinklingRecipe>> getRecipe(Level world, ItemStack stack) {
        var input = new SingleRecipeInput(stack);
        return DBBRecipeTypes.FOOD_SPRINKLING.find(input, world);
    }
    
}
