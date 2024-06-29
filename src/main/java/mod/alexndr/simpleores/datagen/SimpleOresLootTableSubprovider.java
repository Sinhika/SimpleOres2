package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;

/**
 * LootTableProvider for SimpleOres. Again, proof-of-concept.
 */
public class SimpleOresLootTableSubprovider extends SimpleBlockLootSubProvider
{

 
    @Override
	protected void generate() 
    {
    	dropSelf(ModBlocks.adamantium_block.get());
    	dropSelf(ModBlocks.tin_block.get());
    	dropSelf(ModBlocks.mythril_block.get());
    	dropSelf(ModBlocks.raw_adamantium_block.get());
    	dropSelf(ModBlocks.raw_tin_block.get());
        dropSelf(ModBlocks.raw_mythril_block.get());
        dropSelf(ModBlocks.onyx_block.get());
        dropSelf(ModBlocks.adamantium_bars.get());
        dropSelf(ModBlocks.adamantium_brick_stairs.get());
        dropSlab(ModBlocks.adamantium_brick_slab.get());
        dropSelf(ModBlocks.adamantium_bricks.get());
        dropSelf(ModBlocks.copper_bars.get());
        dropSelf(ModBlocks.mythril_bars.get());
        dropSelf(ModBlocks.mythril_brick_stairs.get());
        dropSelf(ModBlocks.mythril_bricks.get());
        dropSlab(ModBlocks.mythril_brick_slab.get());
        dropSelf(ModBlocks.onyx_bars.get());
        dropSelf(ModBlocks.onyx_brick_stairs.get());
        dropSelf(ModBlocks.onyx_bricks.get());
        dropSlab(ModBlocks.onyx_brick_slab.get());
        dropSelf(ModBlocks.tin_bars.get());
        dropSelf(ModBlocks.tin_brick_stairs.get());
        dropSelf(ModBlocks.tin_bricks.get());
        dropSlab(ModBlocks.tin_brick_slab.get());
        
        // doors
        doorDropTable(ModBlocks.adamantium_door.get());
        doorDropTable(ModBlocks.copper_door.get());
        doorDropTable(ModBlocks.mythril_door.get());
        doorDropTable(ModBlocks.onyx_door.get());
        doorDropTable(ModBlocks.tin_door.get());
        
        // ores
        dropMultiItemsWithFortune(ModBlocks.tin_ore.get(), ModItems.raw_tin.get(), 1, 3);
        dropMultiItemsWithFortune(ModBlocks.mythril_ore.get(), ModItems.raw_mythril.get(), 1, 1);
        dropMultiItemsWithFortune(ModBlocks.adamantium_ore.get(), ModItems.raw_adamantium.get(), 1, 1);
        dropMultiItemsWithFortune(ModBlocks.deepslate_tin_ore.get(), ModItems.raw_tin.get(), 1, 3);
        dropMultiItemsWithFortune(ModBlocks.deepslate_mythril_ore.get(), ModItems.raw_mythril.get(), 1, 1);
        dropMultiItemsWithFortune(ModBlocks.deepslate_adamantium_ore.get(), ModItems.raw_adamantium.get(), 1, 1);
        
        dropMultiItemsWithFortune(ModBlocks.onyx_ore.get(), ModItems.onyx_gem.get(), 1, 1);
        
        // pressure plates
        dropSelf(ModBlocks.copper_pressure_plate.get());
        dropSelf(ModBlocks.tin_pressure_plate.get());
        dropSelf(ModBlocks.mythril_pressure_plate.get());
        dropSelf(ModBlocks.adamantium_pressure_plate.get());
        dropSelf(ModBlocks.onyx_pressure_plate.get());
        
    } // end getTables()
    
} // end-class SimpleOresLootTableProvider