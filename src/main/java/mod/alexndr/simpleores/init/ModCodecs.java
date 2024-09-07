package mod.alexndr.simpleores.init;

import com.mojang.serialization.MapCodec;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.loot.SimpleOresChestLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModCodecs
{
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, SimpleOres.MODID);


    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> CHEST_LOOT
            = GLM.register("chest_loot", () -> SimpleOresChestLootModifier.CODEC);
} // end class
