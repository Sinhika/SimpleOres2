package mod.alexndr.simpleores.api.datagen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ILootFunctionConsumer;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.StandaloneLootEntry;
import net.minecraft.world.storage.loot.ValidationResults;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.MatchTool;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;

/**
 * A LootTableProvider class with helper functions. Based on work by sciwhiz12
 * on the BaseDefense module.
 * 
 * @author Sinhika
 *
 */
public abstract class AbstractLootTableProvider extends LootTableProvider
{
    protected final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = new ArrayList<>();
    
    private static final ILootCondition.IBuilder SILK_TOUCH = 
            MatchTool.builder(ItemPredicate.Builder.create()
                         .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));

    public AbstractLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected abstract List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables();

    protected void standardDropTable(Block b)
    {
        blockTable(b, LootTable.builder().addLootPool(createStandardDrops(b)));
    }

    protected void specialDropTable(Block b, Item ii)
    {
        blockTable(b, LootTable.builder().addLootPool(createItemWithFortuneDrops(b, ii)));
    }
    
    void blockTable(Block b, LootTable.Builder lootTable) 
    {
        addTable(b.getLootTable(), lootTable, LootParameterSets.BLOCK);
    }

    void addTable(ResourceLocation path, LootTable.Builder lootTable, LootParameterSet paramSet) 
    {
        tables.add(Pair.of(() -> (lootBuilder) -> lootBuilder.accept(path, lootTable), paramSet));
    }

    LootPool.Builder createStandardDrops(IItemProvider itemProvider)
    {
        return LootPool.builder().rolls(ConstantRange.of(1)).acceptCondition(SurvivesExplosion.builder())
                .addEntry(ItemLootEntry.builder(itemProvider));
    }

    LootPool.Builder createItemWithFortuneDrops(Block blockIn, Item itemIn)
    {
        return droppingWithSilkTouch(blockIn, withExplosionDecay(blockIn,
                ItemLootEntry.builder(itemIn).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
    }
    
    static <T> T withExplosionDecay(IItemProvider itemIn, ILootFunctionConsumer<T> consumer)
    {
        return (T) (consumer.acceptFunction(ExplosionDecay.builder()));
    }

     @SuppressWarnings({ "unchecked", "rawtypes" })
    static LootPool.Builder dropping(Block blockIn, ILootCondition.IBuilder builderIn,
            LootEntry.Builder<?> entryBuilderIn)
    {
        return LootPool.builder().rolls(ConstantRange.of(1))
                .addEntry(
                        ((StandaloneLootEntry.Builder) ItemLootEntry.builder(blockIn)
                                .acceptCondition(builderIn))
                                .alternatively(entryBuilderIn));
    }

    static LootPool.Builder droppingWithSilkTouch(Block blockIn, LootEntry.Builder<?> builderIn)
    {
        return dropping(blockIn, SILK_TOUCH, builderIn);
    }

    
    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults validationtracker)
    {
        map.forEach((loc, table) -> LootTableManager.func_215302_a(validationtracker, loc, table, map::get));
    }
   
    
} // end class AbstractLootTableProvider
