package mod.alexndr.simpleores.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.simplecorelib.datagen.LootTableInjectorProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.RandomValueRange;
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
        LootPool.Builder foo = createChestPool(1, 1, 0.75F)
                .add(ItemLootEntry.lootTableItem(ModItems.copper_bucket.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_shears.get()).setWeight(3))
                .add(ItemLootEntry.lootTableItem(ModItems.copper_ingot.get()).setWeight(9)
                        .apply(SetCount.setCount(RandomValueRange.between(3, 5))))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_ingot.get()).setWeight(9)
                        .apply(SetCount.setCount(RandomValueRange.between(3, 5))))
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_ingot.get()).setWeight(6)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(SimpleOres.MODID, "abandoned_mineshaft", foo);

        // desert_pyramid
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_bow.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(3, 7))))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_gem.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 2))));
        addInjectionTable(SimpleOres.MODID, "desert_pyramid", foo);

        // jungle_temple
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(3, 7))))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_gem.get()).setWeight(1));
        addInjectionTable(SimpleOres.MODID, "jungle_temple", foo);

        // igloo_chest
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_nugget.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.copper_nugget.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_nugget.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(SimpleOres.MODID, "igloo_chest", foo);

        // bastion
        foo = createChestPool(1, 1, 0.25F)
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_helmet.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_chestplate.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_leggings.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_boots.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_pickaxe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_shovel.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_bow.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_shears.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.onyx_gem.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))));
        addInjectionTable(SimpleOres.MODID, "bastion", foo);

        // simple_dungeon
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.copper_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(SimpleOres.MODID, "simple_dungeon", foo);

        // spawn_bonus_chest
        foo = createChestPool(1, 1, 0.75F)
            .add(ItemLootEntry.lootTableItem(ModItems.copper_axe.get()).setWeight(3))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_shears.get()).setWeight(1));
        addInjectionTable(SimpleOres.MODID, "spawn_bonus_chest", foo);

        // buried_treasure
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_boots.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.mythril_ingot.get()).setWeight(5)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 4))))
                .add(ItemLootEntry.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetCount.setCount(RandomValueRange.between(1, 3))));
        addInjectionTable(SimpleOres.MODID, "buried_treasure", foo);
        
        // village_armorer
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.copper_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_helmet.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_chestplate.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_leggings.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_boots.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))));
        addInjectionTable(SimpleOres.MODID, "village_armorer", foo);

        // village_fletcher
        foo = createChestPool(1, 1, 0.25F)
            .add(ItemLootEntry.lootTableItem(ModItems.mythril_rod.get()).setWeight(1));
        addInjectionTable(SimpleOres.MODID, "village_fletcher", foo);

        // village_mason
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_bucket.get()).setWeight(1));
        addInjectionTable(SimpleOres.MODID, "village_mason", foo);

        // village_shepherd
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.tin_shears.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_shears.get()).setWeight(1));
        addInjectionTable(SimpleOres.MODID, "village_shepherd", foo);

        // village_toolsmith
        foo = createChestPool(1, 1, 0.50F)
            .add(ItemLootEntry.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_shovel.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
            .add(ItemLootEntry.lootTableItem(ModItems.copper_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))))
            .add(ItemLootEntry.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                    .apply(SetCount.setCount(RandomValueRange.between(2, 4))));
        addInjectionTable(SimpleOres.MODID, "village_toolsmith", foo);
       
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.50F)
                .add(ItemLootEntry.lootTableItem(ModItems.copper_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.copper_axe.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_sword.get()).setWeight(1))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_axe.get()).setWeight(2))
                .add(ItemLootEntry.lootTableItem(ModItems.copper_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))))
                .add(ItemLootEntry.lootTableItem(ModItems.tin_ingot.get()).setWeight(2)
                        .apply(SetCount.setCount(RandomValueRange.between(2, 3))));
        addInjectionTable(SimpleOres.MODID, "village_weaponsmith", foo);

        return tables;
    } // end getTables

} // end class
