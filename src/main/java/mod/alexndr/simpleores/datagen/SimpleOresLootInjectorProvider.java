package mod.alexndr.simpleores.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class SimpleOresLootInjectorProvider extends LootTableInjectorProvider
{

    public SimpleOresLootInjectorProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables()
    {
        tables.clear();
        
        // abandoned mineshaft
        LootPool.Builder foo = createChestPool(1,1, 0.50F)
                .addEntry(ItemLootEntry.builder(ModItems.copper_bucket.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.copper_sword.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.copper_axe.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.copper_shovel.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.tin_sword.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.tin_axe.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shovel.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shears.get()).weight(3))
                .addEntry(ItemLootEntry.builder(ModBlocks.copper_ore.get())
                            .weight(9).acceptFunction(SetCount.builder(RandomValueRange.of(3, 5))))
                .addEntry(ItemLootEntry.builder(ModBlocks.tin_ore.get())
                        .weight(9).acceptFunction(SetCount.builder(RandomValueRange.of(3, 5))))
                .addEntry(ItemLootEntry.builder(ModBlocks.mythril_ore.get())
                        .weight(6).acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))))
                .addEntry(ItemLootEntry.builder(ModBlocks.adamantium_ore.get())
                        .weight(1).acceptFunction(SetCount.builder(RandomValueRange.of(1, 2))));
        addInjectionTable(SimpleOres.MODID, "abandoned_mineshaft", foo);
        
        return tables;
    }

} // end class
