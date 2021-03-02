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
        LootPool.Builder foo = createChestPool(1, 1, 0.75F)
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
                .addEntry(ItemLootEntry.builder(ModBlocks.copper_ore.get()).weight(9)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(3, 5))))
                .addEntry(ItemLootEntry.builder(ModBlocks.tin_ore.get()).weight(9)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(3, 5))))
                .addEntry(ItemLootEntry.builder(ModBlocks.mythril_ore.get()).weight(6)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))))
                .addEntry(ItemLootEntry.builder(ModBlocks.adamantium_ore.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(1, 2))));
        addInjectionTable(SimpleOres.MODID, "abandoned_mineshaft", foo);

        // desert_pyramid
        foo = createChestPool(1, 1, 0.25F).addEntry(ItemLootEntry.builder(ModItems.mythril_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_ingot.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(3, 7))))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_ingot.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_gem.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(1, 2))));
        addInjectionTable(SimpleOres.MODID, "desert_pyramid", foo);

        // jungle_temple
        foo = createChestPool(1, 1, 0.25F).addEntry(ItemLootEntry.builder(ModItems.mythril_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_hoe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_hoe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_hoe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_ingot.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(1, 3))))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_ingot.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(3, 7))))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_gem.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "jungle_temple", foo);

        // igloo_chest
        foo = createChestPool(1, 1, 0.25F).addEntry(ItemLootEntry.builder(ModItems.copper_helmet.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_chestplate.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_leggings.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_boots.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_sword.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_axe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_shovel.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_helmet.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_chestplate.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_leggings.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_boots.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_sword.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_axe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shovel.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_bow.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "igloo_chest", foo);

        // nether
        foo = createChestPool(1, 1, 0.25F).addEntry(ItemLootEntry.builder(ModItems.onyx_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_gem.get()).weight(3)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))));
        addInjectionTable(SimpleOres.MODID, "nether", foo);

        // simple_dungeon
        foo = createChestPool(1, 1, 0.50F).addEntry(ItemLootEntry.builder(ModItems.copper_helmet.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_chestplate.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_leggings.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_boots.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_sword.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_axe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_shovel.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_helmet.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_chestplate.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_leggings.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_boots.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_sword.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_axe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shovel.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_bow.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_helmet.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_chestplate.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_leggings.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_boots.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_pickaxe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shovel.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.tin_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.copper_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.onyx_shears.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModBlocks.copper_ore.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
                .addEntry(ItemLootEntry.builder(ModBlocks.tin_ore.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
                .addEntry(ItemLootEntry.builder(ModBlocks.mythril_ore.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(1, 2))))
                .addEntry(ItemLootEntry.builder(ModBlocks.adamantium_ore.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.copper_ingot.get()).weight(3)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
                .addEntry(ItemLootEntry.builder(ModItems.tin_ingot.get()).weight(3)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
                .addEntry(ItemLootEntry.builder(ModItems.mythril_ingot.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))))
                .addEntry(ItemLootEntry.builder(ModItems.adamantium_ingot.get()).weight(1)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))));
        addInjectionTable(SimpleOres.MODID, "simple_dungeon", foo);

        // spawn_bonus_chest
        foo = createChestPool(1, 1, 0.75F)
            .addEntry(ItemLootEntry.builder(ModItems.copper_sword.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_axe.get()).weight(3))
            .addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_shovel.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_hoe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_sword.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_axe.get()).weight(2))
            .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_shovel.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_hoe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_bucket.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_shears.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "spawn_bonus_chest", foo);

        // village_armorer
        foo = createChestPool(1, 1, 0.50F).addEntry(ItemLootEntry.builder(ModItems.copper_helmet.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_chestplate.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_leggings.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_boots.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_helmet.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_chestplate.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_leggings.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_boots.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_ingot.get()).weight(3)
                    .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
            .addEntry(ItemLootEntry.builder(ModItems.tin_ingot.get()).weight(3)
                    .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))));
        addInjectionTable(SimpleOres.MODID, "village_armorer", foo);

        // village_fletcher
        foo = createChestPool(1, 1, 0.25F)
            .addEntry(ItemLootEntry.builder(ModItems.mythril_rod.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "village_fletcher", foo);

        // village_mason
        foo = createChestPool(1, 1, 0.50F).addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_bucket.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "village_mason", foo);

        // village_shepherd
        foo = createChestPool(1, 1, 0.50F)
            .addEntry(ItemLootEntry.builder(ModItems.tin_shears.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_shears.get()).weight(1));
        addInjectionTable(SimpleOres.MODID, "village_shepherd", foo);

        // village_toolsmith
        foo = createChestPool(1, 1, 0.50F)
            .addEntry(ItemLootEntry.builder(ModItems.copper_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_shovel.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_pickaxe.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_shovel.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_bucket.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.tin_shears.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_shears.get()).weight(1))
            .addEntry(ItemLootEntry.builder(ModItems.copper_ingot.get()).weight(3)
                    .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))))
            .addEntry(ItemLootEntry.builder(ModItems.tin_ingot.get()).weight(3)
                    .acceptFunction(SetCount.builder(RandomValueRange.of(2, 4))));
        addInjectionTable(SimpleOres.MODID, "village_toolsmith", foo);
       
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.50F)
                .addEntry(ItemLootEntry.builder(ModItems.copper_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.copper_axe.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.tin_sword.get()).weight(1))
                .addEntry(ItemLootEntry.builder(ModItems.tin_axe.get()).weight(2))
                .addEntry(ItemLootEntry.builder(ModItems.copper_ingot.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))))
                .addEntry(ItemLootEntry.builder(ModItems.tin_ingot.get()).weight(2)
                        .acceptFunction(SetCount.builder(RandomValueRange.of(2, 3))));
        addInjectionTable(SimpleOres.MODID, "village_weaponsmith", foo);

        return tables;
    } // end getTables

} // end class
