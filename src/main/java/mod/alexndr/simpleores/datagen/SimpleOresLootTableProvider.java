package mod.alexndr.simpleores.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

/**
 * LootTableProvider for SimpleOres. Again, proof-of-concept.
 */
public class SimpleOresLootTableProvider extends BlockLootTableProvider
{

    public SimpleOresLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        standardDropTable(ModBlocks.adamantium_block.get());
        standardDropTable(ModBlocks.tin_block.get());
        standardDropTable(ModBlocks.mythril_block.get());
        standardDropTable(ModBlocks.raw_adamantium_block.get());
        standardDropTable(ModBlocks.raw_tin_block.get());
        standardDropTable(ModBlocks.raw_mythril_block.get());
        standardDropTable(ModBlocks.onyx_block.get());
        standardDropTable(ModBlocks.adamantium_bars.get());
        standardDropTable(ModBlocks.adamantium_brick_stairs.get());
        slabDropTable(ModBlocks.adamantium_brick_slab.get());
        standardDropTable(ModBlocks.adamantium_bricks.get());
        standardDropTable(ModBlocks.copper_bars.get());
        standardDropTable(ModBlocks.mythril_bars.get());
        standardDropTable(ModBlocks.mythril_brick_stairs.get());
        standardDropTable(ModBlocks.mythril_bricks.get());
        slabDropTable(ModBlocks.mythril_brick_slab.get());
        standardDropTable(ModBlocks.onyx_bars.get());
        standardDropTable(ModBlocks.onyx_brick_stairs.get());
        standardDropTable(ModBlocks.onyx_bricks.get());
        slabDropTable(ModBlocks.onyx_brick_slab.get());
        standardDropTable(ModBlocks.tin_bars.get());
        standardDropTable(ModBlocks.tin_brick_stairs.get());
        standardDropTable(ModBlocks.tin_bricks.get());
        slabDropTable(ModBlocks.tin_brick_slab.get());
        
        // doors
        doorDropTable(ModBlocks.adamantium_door.get());
        doorDropTable(ModBlocks.copper_door.get());
        doorDropTable(ModBlocks.mythril_door.get());
        doorDropTable(ModBlocks.onyx_door.get());
        doorDropTable(ModBlocks.tin_door.get());
        
        // ores
        multipleDropTable(ModBlocks.tin_ore.get(), ModItems.raw_tin.get(), 1, 3);
        specialDropTable(ModBlocks.mythril_ore.get(), ModItems.raw_mythril.get());
        specialDropTable(ModBlocks.adamantium_ore.get(), ModItems.raw_adamantium.get());
        multipleDropTable(ModBlocks.deepslate_tin_ore.get(), ModItems.raw_tin.get(), 1, 3);
        specialDropTable(ModBlocks.deepslate_mythril_ore.get(), ModItems.raw_mythril.get());
        specialDropTable(ModBlocks.deepslate_adamantium_ore.get(), ModItems.raw_adamantium.get());
        
        specialDropTable(ModBlocks.onyx_ore.get(), ModItems.onyx_gem.get());
        
        // pressure plates
        standardDropTable(ModBlocks.copper_pressure_plate.get());
        standardDropTable(ModBlocks.tin_pressure_plate.get());
        standardDropTable(ModBlocks.mythril_pressure_plate.get());
        standardDropTable(ModBlocks.adamantium_pressure_plate.get());
        standardDropTable(ModBlocks.onyx_pressure_plate.get());
        
        return tables;
    } // end getTables()
    
} // end-class SimpleOresLootTableProvider