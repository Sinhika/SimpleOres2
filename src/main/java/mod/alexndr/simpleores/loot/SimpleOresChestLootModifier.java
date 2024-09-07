package mod.alexndr.simpleores.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.alexndr.simplecorelib.api.loot.AbstractChestLootModifier;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class SimpleOresChestLootModifier extends AbstractChestLootModifier
{
    public static final MapCodec<SimpleOresChestLootModifier> CODEC =
            RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst)
                    .and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable")
                            .forGetter((m) -> m.lootTable))
                    .apply(inst, SimpleOresChestLootModifier::new));

    public SimpleOresChestLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable)
    {
        super(conditionsIn, lootTable);
    }

    @Override  @NotNull
    protected ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot,
                                                                    LootContext context)
    {
        if (SimpleOresConfig.addModLootToChests) {
            return super.doApply(generatedLoot, context);
        }
        else {
            return generatedLoot;
        }
    }

    @Override @NotNull
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return ModCodecs.CHEST_LOOT.get();
    }
} // end class
