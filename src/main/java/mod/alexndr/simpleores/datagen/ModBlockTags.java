package mod.alexndr.simpleores.datagen;

import java.util.List;

import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * BlockTagsProvider for SimpleOres. Mostly this is proof-of-concept, and guidance for other
 * mods on how to do tags with datagen.
 * 
 * @author Sinhika
 *
 */
public class ModBlockTags extends MiningBlockTags
{
    public ModBlockTags(DataGenerator generatorIn, @javax.annotation.Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, SimpleOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        registerOreTags();
        registerStorageBlockTags();
        registerMiningTags();
        registerBeaconTags();
        registerDoorsSlabsAndStairs();
        registerMiscTags();
    } // end registerTags()
    
    private void registerMiscTags()
    {
        this.tag(TagUtils.modBlockTag("minecraft", "pressure_plates"))
            .add(ModBlocks.copper_pressure_plate.get())
            .add(ModBlocks.tin_pressure_plate.get())
            .add(ModBlocks.mythril_pressure_plate.get())
            .add(ModBlocks.adamantium_pressure_plate.get())
            .add(ModBlocks.onyx_pressure_plate.get());
    }
    
    private void registerDoorsSlabsAndStairs()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "doors"))
    		.add(ModBlocks.copper_door.get())
    		.add(ModBlocks.tin_door.get())
    		.add(ModBlocks.adamantium_door.get())
    		.add(ModBlocks.onyx_door.get())
    		.add(ModBlocks.mythril_door.get());
    	
    	this.tag(TagUtils.modBlockTag("minecraft","stairs"))
    		.add(ModBlocks.adamantium_brick_stairs.get())
    		.add(ModBlocks.tin_brick_stairs.get())
    		.add(ModBlocks.mythril_brick_stairs.get())
    		.add(ModBlocks.onyx_brick_stairs.get());
    	
    	this.tag(TagUtils.modBlockTag("minecraft","slabs"))
			.add(ModBlocks.adamantium_brick_slab.get())
			.add(ModBlocks.tin_brick_slab.get())
			.add(ModBlocks.mythril_brick_slab.get())
			.add(ModBlocks.onyx_brick_slab.get());
    }
    
    private void registerBeaconTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "beacon_base_blocks"))
    		.add(Blocks.COPPER_BLOCK)
			.add(ModBlocks.adamantium_block.get())
			.add(ModBlocks.tin_block.get())
			.add(ModBlocks.mythril_block.get());
    }
    
    @Override
    protected void registerMiningTags()
    {
        // all the registered blocks are mineable.
        List<Block> mineables = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        
        // do nothing; super() generates all the vanilla blocktags, and we don't want that.
     	registerMineableTags(mineables, 
     			List.of(ModBlocks.tin_ore.get(), ModBlocks.deepslate_tin_ore.get(), ModBlocks.tin_block.get(), ModBlocks.raw_tin_block.get(),
     	     			ModBlocks.tin_bars.get(), ModBlocks.tin_brick_stairs.get(), ModBlocks.tin_bricks.get(), ModBlocks.tin_door.get(), 
     	     			ModBlocks.copper_bars.get(), ModBlocks.copper_door.get(), ModBlocks.tin_brick_slab.get()), // 1 stone
     			List.of(ModBlocks.adamantium_block.get(), ModBlocks.adamantium_ore.get(), ModBlocks.deepslate_adamantium_ore.get(), 
     					ModBlocks.raw_adamantium_block.get(), ModBlocks.mythril_block.get(), ModBlocks.mythril_ore.get(), 
     					ModBlocks.deepslate_mythril_ore.get(), ModBlocks.raw_mythril_block.get(), ModBlocks.adamantium_brick_slab.get(),
     					ModBlocks.mythril_brick_slab.get(),
     	     			ModBlocks.adamantium_bars.get(), ModBlocks.adamantium_bricks.get(), ModBlocks.adamantium_brick_stairs.get(), ModBlocks.adamantium_door.get(),
     	     			ModBlocks.mythril_bars.get(), ModBlocks.mythril_brick_stairs.get(), ModBlocks.mythril_bricks.get(), ModBlocks.mythril_door.get()), // 2 - iron
     			List.of(ModBlocks.onyx_block.get(), ModBlocks.onyx_ore.get(), ModBlocks.onyx_bars.get(), ModBlocks.onyx_brick_stairs.get(), 
     					ModBlocks.onyx_bricks.get(), ModBlocks.onyx_door.get(), ModBlocks.onyx_brick_slab.get()), // 3 - diamond
     			List.of()); // 4 - netherite
     			
    } // end registerMiningTags()
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/raw_adamantium"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantium"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantine"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantite"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/copper"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/raw_copper"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/tin"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/raw_tin"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/mythril"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/mithril"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/raw_mythril"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/onyx"));
        
        // because they haven't been added to forge by default yet.
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/copper"))
        	.add(Blocks.COPPER_BLOCK);
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/raw_copper"))
    		.add(Blocks.RAW_COPPER_BLOCK);
        // end-copper
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_adamantium"))
        	.add(ModBlocks.raw_adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/adamantium"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/adamantine"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/adamantite"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/raw_tin"))
    		.add(ModBlocks.raw_tin_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/tin"))
                .add(ModBlocks.tin_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/raw_mythril"))
        .add(ModBlocks.raw_mythril_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/mythril"))
                .add(ModBlocks.mythril_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/mithril"))
                .add(ModBlocks.mythril_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/onyx"))
                .add(ModBlocks.onyx_block.get());
    } // end registerStorageBlockTags
    
    @Override
    protected void registerOreTags()
    {
    	// register "forge:ores" tags
        this.tag(TagUtils.forgeBlockTag( "ores"))
                .addTag(TagUtils.forgeBlockTag( "ores/tin"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantine"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantite"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantium"))
                .addTag(TagUtils.forgeBlockTag( "ores/mithril"))
                .addTag(TagUtils.forgeBlockTag( "ores/mythril"))
                .addTag(TagUtils.forgeBlockTag( "ores/onyx"));

        this.tag(TagUtils.forgeBlockTag( "ores/tin"))
                .add(ModBlocks.tin_ore.get())
                .add(ModBlocks.deepslate_tin_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantium"))
                .add(ModBlocks.adamantium_ore.get())
        		.add(ModBlocks.deepslate_adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantine"))
	        .add(ModBlocks.adamantium_ore.get())
			.add(ModBlocks.deepslate_adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantite"))
	        .add(ModBlocks.adamantium_ore.get())
			.add(ModBlocks.deepslate_adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/mythril"))
                .add(ModBlocks.mythril_ore.get())
                .add(ModBlocks.deepslate_mythril_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/mithril"))
	        .add(ModBlocks.mythril_ore.get())
	        .add(ModBlocks.deepslate_mythril_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/onyx"))
                .add(ModBlocks.onyx_ore.get());
        
        // register forge ore_rates tags.
        this.registerOreRateTags( List.of(), // sparse 
        		List.of(ModBlocks.adamantium_ore.get(), ModBlocks.deepslate_adamantium_ore.get(),
        				ModBlocks.mythril_ore.get(), ModBlocks.deepslate_mythril_ore.get(),
        				ModBlocks.onyx_ore.get()), // singular 
        		List.of(ModBlocks.tin_ore.get(), ModBlocks.deepslate_tin_ore.get())); // dense
        
        // register forge:ores_in_ground tags
        this.registerOresInGroundTags( List.of(ModBlocks.adamantium_ore.get(), ModBlocks.mythril_ore.get(),
        		ModBlocks.tin_ore.get()), // stone ores
        		List.of(ModBlocks.deepslate_adamantium_ore.get(), ModBlocks.deepslate_mythril_ore.get(),
        				ModBlocks.deepslate_tin_ore.get()), // deepslate ores
        		List.of(ModBlocks.onyx_ore.get()));  // netherrack ores
    } // end registerOreTags()

 } // end-class ModBlockTags