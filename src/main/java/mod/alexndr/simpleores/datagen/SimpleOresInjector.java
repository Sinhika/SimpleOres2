package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.datagen.SimpleLootInjectorSubProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class SimpleOresInjector extends SimpleLootInjectorSubProvider
{
    public static final ResourceKey<LootTable> ABANDONED_MINESHAFT =
            getInjectionTableId(SimpleOres.MODID, "abandoned_mineshaft");
    public static final ResourceKey<LootTable> BASTION =
            getInjectionTableId(SimpleOres.MODID, "bastion");
    public static final ResourceKey<LootTable> BURIED_TREASURE =
            getInjectionTableId(SimpleOres.MODID, "buried_treasure");
    public static final ResourceKey<LootTable> DESERT_PYRAMID =
            getInjectionTableId(SimpleOres.MODID, "desert_pyramid");
    public static final ResourceKey<LootTable> IGLOO_CHEST =
            getInjectionTableId(SimpleOres.MODID, "igloo_chest");
    public static final ResourceKey<LootTable> JUNGLE_TEMPLE =
            getInjectionTableId(SimpleOres.MODID, "jungle_temple");
    public static final ResourceKey<LootTable> RUINED_PORTAL =
            getInjectionTableId(SimpleOres.MODID, "ruined_portal");
    public static final ResourceKey<LootTable> SIMPLE_DUNGEON =
            getInjectionTableId(SimpleOres.MODID, "simple_dungeon");
    public static final ResourceKey<LootTable> SPAWN_BONUS_CHEST =
            getInjectionTableId(SimpleOres.MODID, "spawn_bonus_chest");
    public static final ResourceKey<LootTable> VILLAGE_ARMORER =
            getInjectionTableId(SimpleOres.MODID, "village_armorer");
    public static final ResourceKey<LootTable> VILLAGE_FLETCHER =
            getInjectionTableId(SimpleOres.MODID, "village_fletcher");
    public static final ResourceKey<LootTable> VILLAGE_MASON =
            getInjectionTableId(SimpleOres.MODID, "village_mason");
    public static final ResourceKey<LootTable> VILLAGE_SHEPHERD =
            getInjectionTableId(SimpleOres.MODID, "village_shepherd");
    public static final ResourceKey<LootTable> VILLAGE_TOOLSMITH =
            getInjectionTableId(SimpleOres.MODID, "village_toolsmith");
    public static final ResourceKey<LootTable> VILLAGE_WEAPONSMITH =
            getInjectionTableId(SimpleOres.MODID, "village_weaponsmith");

    @Override public void generate(HolderLookup.@NotNull Provider pRegistries,
                                   BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pGenerator)
    {
        pGenerator.accept(ABANDONED_MINESHAFT, LootTable.lootTable()
                .withPool(createChestPool("abandoned_mineshaft", 1, 1, 0.75F)
                        .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.tin_shears.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(9)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
                        .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                        .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));

        pGenerator.accept(BASTION, LootTable.lootTable().withPool(
                createChestPool("bastion", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.onyx_helmet.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_chestplate.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_leggings.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_boots.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_axe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_shovel.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_bow.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_shears.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))));

        pGenerator.accept(BURIED_TREASURE, LootTable.lootTable().withPool(
                createChestPool("buried_treasure", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.mythril_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.adamantium_boots.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))));

        pGenerator.accept(DESERT_PYRAMID, LootTable.lootTable().withPool(
                createChestPool("desert_pyramid", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.mythril_bow.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                        .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                        .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));

        pGenerator.accept(IGLOO_CHEST, LootTable.lootTable().withPool(
                createChestPool("igloo_chest", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.mythril_nugget.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(ModItems.tin_nugget.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))));

        pGenerator.accept(JUNGLE_TEMPLE, LootTable.lootTable().withPool(
                createChestPool( "jungle_temple", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                        .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1))));

        pGenerator.accept(RUINED_PORTAL, LootTable.lootTable().withPool(
                createChestPool("ruined_portal", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1))));

        pGenerator.accept(SIMPLE_DUNGEON, LootTable.lootTable().withPool(
                createChestPool("simple_dungeon", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                        .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                        .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))));

        pGenerator.accept(SPAWN_BONUS_CHEST, LootTable.lootTable().withPool(
                createChestPool( "buried_treasure", 1, 1, 0.75F)
                        .add(LootItem.lootTableItem(ModItems.copper_axe.get()).setWeight(3))
                        .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_shears.get()).setWeight(1))));

        pGenerator.accept(VILLAGE_ARMORER, LootTable.lootTable().withPool(
                createChestPool("village_armorer", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.copper_helmet.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_chestplate.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_leggings.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_boots.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_helmet.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_chestplate.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_leggings.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_boots.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))));

        pGenerator.accept(VILLAGE_FLETCHER, LootTable.lootTable().withPool(
                createChestPool("village_fletcher", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.mythril_rod.get()).setWeight(1))));

        pGenerator.accept(VILLAGE_MASON, LootTable.lootTable().withPool(
                createChestPool("village_mason", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))));

        pGenerator.accept(VILLAGE_SHEPHERD, LootTable.lootTable().withPool(
                createChestPool("village_shepherd", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.tin_shears.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_shears.get()).setWeight(1))));

        pGenerator.accept(VILLAGE_TOOLSMITH, LootTable.lootTable().withPool(
                createChestPool("village_toolsmith", 1, 1, 0.50F)
                    .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
                    .add(LootItem.lootTableItem(ModItems.copper_shovel.get()).setWeight(1))
                    .add(LootItem.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
                    .add(LootItem.lootTableItem(ModItems.tin_shovel.get()).setWeight(1))
                    .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
                    .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))));

        pGenerator.accept(VILLAGE_WEAPONSMITH, LootTable.lootTable().withPool(
                createChestPool("village_weaponsmith", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.copper_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.copper_axe.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_sword.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ModItems.tin_axe.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))));

    } // end generate()
} // end class
