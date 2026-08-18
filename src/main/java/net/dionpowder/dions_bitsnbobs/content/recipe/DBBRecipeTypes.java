package net.dionpowder.dions_bitsnbobs.content.recipe;

import com.mojang.serialization.Codec;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.lang.Lang;
import net.dionpowder.dions_bitsnbobs.DBB;
import net.dionpowder.dions_bitsnbobs.content.recipe.fan.recipe.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public enum DBBRecipeTypes implements IRecipeTypeInfo, StringRepresentable {
    STRAWBERRY_FROSTING(StrawberryFrostingRecipe::new),
    ORANGE_FROSTING(OrangeFrostingRecipe::new),
    BLUEBERRY_FROSTING(BlueberryFrostingRecipe::new),
    PEAR_FROSTING(PearFrostingRecipe::new),
    CHOCOLATE_GLAZING(ChocolateGlazingRecipe::new),
    DARK_CHOCOLATE_GLAZING(DarkChocolateGlazingRecipe::new),
    WHITE_CHOCOLATE_GLAZING(WhiteChocolateGlazingRecipe::new),
    CARAMEL_CHOCOLATE_GLAZING(CaramelChocolateGlazingRecipe::new),
    RUBY_CHOCOLATE_GLAZING(RubyChocolateGlazingRecipe::new),
    ;

    public final ResourceLocation id;
    public final Supplier<RecipeSerializer<?>> serializerSupplier;
    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializerObject;
    @Nullable
    private final DeferredHolder<RecipeType<?>, RecipeType<?>> typeObject;
    private final Supplier<RecipeType<?>> type;

    public static final Codec<DBBRecipeTypes> CODEC = StringRepresentable.fromEnum(DBBRecipeTypes::values);

    DBBRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier, Supplier<RecipeType<?>> typeSupplier, boolean registerType) {
        var name = Lang.asId(name());
        id = DBB.rl(name);
        this.serializerSupplier = serializerSupplier;
        serializerObject = DBBRecipeTypes.Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        if (registerType) {
            typeObject = DBBRecipeTypes.Registers.TYPE_REGISTER.register(name, typeSupplier);
            type = typeObject;
        } else {
            typeObject = null;
            type = typeSupplier;
        }
    }

    DBBRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier) {
        var name = Lang.asId(name());
        id = DBB.rl(name);
        this.serializerSupplier = serializerSupplier;
        serializerObject = DBBRecipeTypes.Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        typeObject = DBBRecipeTypes.Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
    }

    DBBRecipeTypes(StandardProcessingRecipe.Factory<?> processingFactory) {
        this(() -> new StandardProcessingRecipe.Serializer<>(processingFactory));
    }

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        ShapedRecipePattern.setCraftingSize(9, 9);
        DBBRecipeTypes.Registers.SERIALIZER_REGISTER.register(modEventBus);
        DBBRecipeTypes.Registers.TYPE_REGISTER.register(modEventBus);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I inv, Level level) {
        return level.getRecipeManager().getRecipeFor(getType(), inv, level);
    }

    @Override
    public @NotNull String getSerializedName() {
        return id.toString();
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, DBB.MOD_ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, DBB.MOD_ID);
    }
}