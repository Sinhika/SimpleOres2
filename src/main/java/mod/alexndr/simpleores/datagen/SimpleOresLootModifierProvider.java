package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.datagen.SimpleLootModifierProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.loot.SimpleOresChestLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.concurrent.CompletableFuture;

public class SimpleOresLootModifierProvider extends SimpleLootModifierProvider
{

    public SimpleOresLootModifierProvider(PackOutput output,
                                          CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, SimpleOres.MODID);
    }

    /**
     * Call {@link #add} here, which will pass in the necessary information to write the jsons.
     */
    @Override protected void start()
    {
        AddNetherAliases(SimpleOresInjector.BASTION);
        AddStrongholdAliases(SimpleOresInjector.SIMPLE_DUNGEON);
        AddOceanAliases(SimpleOresInjector.SIMPLE_DUNGEON);
        this.add(BuiltInLootTables.ABANDONED_MINESHAFT, SimpleOresInjector.ABANDONED_MINESHAFT);
        this.add(BuiltInLootTables.BURIED_TREASURE, SimpleOresInjector.BURIED_TREASURE);
        this.add(BuiltInLootTables.DESERT_PYRAMID, SimpleOresInjector.DESERT_PYRAMID);
        this.add(BuiltInLootTables.IGLOO_CHEST, SimpleOresInjector.IGLOO_CHEST);
        this.add(BuiltInLootTables.JUNGLE_TEMPLE, SimpleOresInjector.JUNGLE_TEMPLE);
        this.add(BuiltInLootTables.RUINED_PORTAL, SimpleOresInjector.RUINED_PORTAL);
        this.add(BuiltInLootTables.SIMPLE_DUNGEON, SimpleOresInjector.SIMPLE_DUNGEON);
        this.add(BuiltInLootTables.SPAWN_BONUS_CHEST, SimpleOresInjector.SPAWN_BONUS_CHEST);

        // villagers
        this.add(BuiltInLootTables.VILLAGE_ARMORER, SimpleOresInjector.VILLAGE_ARMORER);
        this.add(BuiltInLootTables.VILLAGE_FLETCHER, SimpleOresInjector.VILLAGE_FLETCHER);
        this.add(BuiltInLootTables.VILLAGE_MASON, SimpleOresInjector.VILLAGE_MASON);
        this.add(BuiltInLootTables.VILLAGE_SHEPHERD, SimpleOresInjector.VILLAGE_SHEPHERD);
        this.add(BuiltInLootTables.VILLAGE_TOOLSMITH, SimpleOresInjector.VILLAGE_TOOLSMITH);
        this.add(BuiltInLootTables.VILLAGE_WEAPONSMITH, SimpleOresInjector.VILLAGE_WEAPONSMITH);

    } // end start()

    @Override protected void add(ResourceKey<LootTable> targetLootTable, ResourceKey<LootTable> customLootTable)
    {
        this.add(targetLootTable.location().getPath(),
                new SimpleOresChestLootModifier(getCondition(targetLootTable.location()), customLootTable));
    }


} // end class
