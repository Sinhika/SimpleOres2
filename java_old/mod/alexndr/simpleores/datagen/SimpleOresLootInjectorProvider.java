package mod.alexndr.simpleores.datagen;

import java.util.function.BiConsumer;

import mod.alexndr.simplecorelib.api.datagen.LootTableInjectorProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class SimpleOresLootInjectorProvider extends LootTableInjectorProvider
{

    @Override
    public void generate(BiConsumer<ResourceLocation, Builder> bar) 
	{
        // abandoned mineshaft
        LootPool.Builder foo = createChestPool(1, 1, 0.75F)
                .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.tin_shears.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(9)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 5))))
                .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(6)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "abandoned_mineshaft"), foo);

        // desert_pyramid
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.mythril_bow.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "desert_pyramid"), foo);

        // jungle_temple
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7))))
                .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "jungle_temple"), foo);

        // igloo_chest
        foo = createChestPool(1, 1, 0.25F)
                .add(LootItem.lootTableItem(ModItems.mythril_nugget.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                .add(LootItem.lootTableItem(ModItems.tin_nugget.get()).setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "igloo_chest"), foo);

        // bastion
        foo = createChestPool(1, 1, 0.25F)
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
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "bastion"), foo);

        // ruined_portal
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.onyx_gem.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "ruined_portal"), foo);
        
        // simple_dungeon
        foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))))
                .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "simple_dungeon"), foo);

        // spawn_bonus_chest
        foo = createChestPool(1, 1, 0.75F)
            .add(LootItem.lootTableItem(ModItems.copper_axe.get()).setWeight(3))
            .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_shears.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "spawn_bonus_chest"), foo);

        // buried_treasure
        foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.mythril_sword.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.adamantium_boots.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.mythril_ingot.get()).setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                .add(LootItem.lootTableItem(ModItems.adamantium_ingot.get()).setWeight(1)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "buried_treasure"), foo);
        
        // village_armorer
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.copper_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_chestplate.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_boots.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_helmet.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_chestplate.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_leggings.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_boots.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_armorer"), foo);

        // village_fletcher
        foo = createChestPool(1, 1, 0.25F)
            .add(LootItem.lootTableItem(ModItems.mythril_rod.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_fletcher"), foo);

        // village_mason
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_mason"), foo);

        // village_shepherd
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.tin_shears.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_shears.get()).setWeight(1));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_shepherd"), foo);

        // village_toolsmith
        foo = createChestPool(1, 1, 0.50F)
            .add(LootItem.lootTableItem(ModItems.copper_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_shovel.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_pickaxe.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_shovel.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.copper_bucket.get()).setWeight(1))
            .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_toolsmith"), foo);
       
        // village_weaponsmith
        foo = createChestPool(1, 1, 0.50F)
                .add(LootItem.lootTableItem(ModItems.copper_sword.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.copper_axe.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.tin_sword.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.tin_axe.get()).setWeight(2))
                 .add(LootItem.lootTableItem(ModItems.tin_ingot.get()).setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3))));
        addInjectionTable(bar, getInjectionTableId(SimpleOres.MODID, "village_weaponsmith"), foo);

    } // end getTables


} // end class
