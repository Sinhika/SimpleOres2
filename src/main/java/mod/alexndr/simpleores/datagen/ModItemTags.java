package mod.alexndr.simpleores.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * ItemTagsProvider for SimpleOres.
 */
public class ModItemTags extends MiningItemTags
{

    public ModItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, SimpleOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
    	super.addTags(lookupProvider);
    	registerNuggetTags();
    	registerIngotTags();
    	registerRawMetalTags();
    	registerGemTags();
        registerDustTags();
        registerOreChunkTags();
    	registerMisc();
    	registerBlockItemTags();
    	registerDoorsSlabsAndStairs();
    	registerToolTags(ModItems.ITEMS);
    	registerArmorTags(ModItems.ITEMS);
    }

    
    @Override
	protected void registerOreTags() 
    {
    	super.registerOreTags();
    	
    	// register 'forge:ores' tags.
        this.tag(Tags.Items.ORES)
	        .addTag(TagUtils.cTag( "ores/tin"))
	        .addTag(TagUtils.cTag( "ores/adamantine"))
	        .addTag(TagUtils.cTag( "ores/adamantite"))
	        .addTag(TagUtils.cTag( "ores/adamantium"))
	        .addTag(TagUtils.cTag( "ores/mithril"))
	        .addTag(TagUtils.cTag( "ores/mythril"))
	        .addTag(TagUtils.cTag( "ores/onyx"));
	
		this.tag(TagUtils.cTag( "ores/tin"))
		        .add(ModBlocks.tin_ore.get().asItem())
		        .add(ModBlocks.deepslate_tin_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/adamantium"))
		        .add(ModBlocks.adamantium_ore.get().asItem())
		        .add(ModBlocks.deepslate_adamantium_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/adamantine"))
	        .add(ModBlocks.adamantium_ore.get().asItem())
	        .add(ModBlocks.deepslate_adamantium_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/adamantite"))
	        .add(ModBlocks.adamantium_ore.get().asItem())
	        .add(ModBlocks.deepslate_adamantium_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/mythril"))
		        .add(ModBlocks.mythril_ore.get().asItem())
		        .add(ModBlocks.deepslate_mythril_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/mithril"))
	        .add(ModBlocks.mythril_ore.get().asItem())
	        .add(ModBlocks.deepslate_mythril_ore.get().asItem());
		this.tag(TagUtils.cTag( "ores/onyx"))
		        .add(ModBlocks.onyx_ore.get().asItem());
		
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
		
	} // end registerOreTags

	private void registerDoorsSlabsAndStairs()
    {
    	this.tag(ItemTags.DOORS)
    		.add(ModBlocks.copper_door.get().asItem())
    		.add(ModBlocks.tin_door.get().asItem())
    		.add(ModBlocks.adamantium_door.get().asItem())
    		.add(ModBlocks.onyx_door.get().asItem())
    		.add(ModBlocks.mythril_door.get().asItem());
    	
    	this.tag(ItemTags.STAIRS)
    		.add(ModBlocks.adamantium_brick_stairs.get().asItem())
    		.add(ModBlocks.tin_brick_stairs.get().asItem())
    		.add(ModBlocks.mythril_brick_stairs.get().asItem())
    		.add(ModBlocks.onyx_brick_stairs.get().asItem());
    	
    	this.tag(ItemTags.STAIRS)
    		.add(ModBlocks.adamantium_brick_slab.get().asItem())
    		.add(ModBlocks.tin_brick_slab.get().asItem())
    		.add(ModBlocks.mythril_brick_slab.get().asItem())
    		.add(ModBlocks.onyx_brick_slab.get().asItem());
    }
    
    private void registerBlockItemTags()
    {
        this.tag(Tags.Items.STORAGE_BLOCKS)
	        .addTag(TagUtils.cTag("storage_blocks/raw_adamantium"))
	        .addTag(TagUtils.cTag("storage_blocks/adamantium"))
	        .addTag(TagUtils.cTag("storage_blocks/adamantine"))
	        .addTag(TagUtils.cTag("storage_blocks/adamantite"))
	        .addTag(TagUtils.cTag("storage_blocks/tin"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_tin"))
	        .addTag(TagUtils.cTag("storage_blocks/mythril"))
	        .addTag(TagUtils.cTag("storage_blocks/mithril"))
	        .addTag(TagUtils.cTag("storage_blocks/raw_mythril"))
	        .addTag(TagUtils.cTag("storage_blocks/onyx"));
    
	    this.tag(TagUtils.cTag("storage_blocks/raw_adamantium"))
	    	.add(ModBlocks.raw_adamantium_block.get().asItem());
	    this.tag(TagUtils.cTag("storage_blocks/adamantium"))
	            .add(ModBlocks.adamantium_block.get().asItem());
	    this.tag(TagUtils.cTag("storage_blocks/adamantine"))
	            .add(ModBlocks.adamantium_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/adamantite"))
	            .add(ModBlocks.adamantium_block.get().asItem());
	    this.tag(TagUtils.cTag("storage_blocks/raw_tin"))
			.add(ModBlocks.raw_tin_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/tin"))
	            .add(ModBlocks.tin_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/raw_mythril"))
	    .add(ModBlocks.raw_mythril_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/mythril"))
	            .add(ModBlocks.mythril_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/mithril"))
	            .add(ModBlocks.mythril_block.get().asItem());
	    this.tag(TagUtils.cTag( "storage_blocks/onyx"))
	            .add(ModBlocks.onyx_block.get().asItem());

    } // end registerBlockItemTags()
    
    private void registerNuggetTags()
    {
        this.tag(Tags.Items.NUGGETS)
	    	.addTag(TagUtils.cTag("nuggets/copper"))
			.addTag(TagUtils.cTag("nuggets/tin"))
	    	.addTag(TagUtils.cTag("nuggets/adamantine"))
	    	.addTag(TagUtils.cTag("nuggets/adamantite"))
	    	.addTag(TagUtils.cTag("nuggets/adamantium"))
	    	.addTag(TagUtils.cTag("nuggets/mithril"))
	    	.addTag(TagUtils.cTag("nuggets/mythril"));

        this.tag(TagUtils.cTag("nuggets/copper"))
    		.add(ModItems.copper_nugget.get());
        this.tag(TagUtils.cTag("nuggets/tin"))
        	.add(ModItems.tin_nugget.get());
        this.tag(TagUtils.cTag("nuggets/adamantine"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.cTag("nuggets/adamantite"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.cTag("nuggets/adamantium"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.cTag("nuggets/mythril"))
    		.add(ModItems.mythril_nugget.get());
        this.tag(TagUtils.cTag("nuggets/mithril"))
    		.add(ModItems.mythril_nugget.get());
    } // end registerNuggetTags()
    
    private void registerRawMetalTags()
    {
        this.tag(Tags.Items.RAW_MATERIALS)
			.addTag(TagUtils.cTag("raw_metals/tin"))
	    	.addTag(TagUtils.cTag("raw_metals/adamantine"))
	    	.addTag(TagUtils.cTag("raw_metals/adamantite"))
	    	.addTag(TagUtils.cTag("raw_metals/adamantium"))
	    	.addTag(TagUtils.cTag("raw_metals/mithril"))
	    	.addTag(TagUtils.cTag("raw_metals/mythril"));
        
        this.tag(TagUtils.cTag("raw_metals/tin"))
        	.add(ModItems.raw_tin.get());
        this.tag(TagUtils.cTag("raw_metals/adamantine"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.cTag("raw_metals/adamantite"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.cTag("raw_metals/adamantium"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.cTag("raw_metals/mythril"))
    		.add(ModItems.raw_mythril.get());
        this.tag(TagUtils.cTag("raw_metals/mithril"))
    		.add(ModItems.raw_mythril.get());
    	
    }
    
    private void registerGemTags()
    {
        this.tag(Tags.Items.GEMS)
        	.addTag(TagUtils.cTag("gems/onyx"));
        this.tag(TagUtils.cTag("gems/onyx"))
        	.add(ModItems.onyx_gem.get());
    }
    
    private void registerIngotTags()
    {
        this.tag(Tags.Items.INGOTS)
    		.addTag(TagUtils.cTag("ingots/tin"))
        	.addTag(TagUtils.cTag("ingots/adamantine"))
        	.addTag(TagUtils.cTag("ingots/adamantite"))
        	.addTag(TagUtils.cTag("ingots/adamantium"))
        	.addTag(TagUtils.cTag("ingots/mithril"))
        	.addTag(TagUtils.cTag("ingots/mythril"));
        
        this.tag(TagUtils.cTag("ingots/tin"))
        	.add(ModItems.tin_ingot.get());
        this.tag(TagUtils.cTag("ingots/adamantine"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.cTag("ingots/adamantite"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.cTag("ingots/adamantium"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.cTag("ingots/mythril"))
    		.add(ModItems.mythril_ingot.get());
        this.tag(TagUtils.cTag("ingots/mithril"))
    		.add(ModItems.mythril_ingot.get());
    	
    } // end registerIngotTags()
    
    
    private void registerDustTags()
    {
        this.tag(Tags.Items.DUSTS)
                .addTag(TagUtils.cTag("dusts/adamantine"))
                .addTag(TagUtils.cTag("dusts/adamantite"))
                .addTag(TagUtils.cTag("dusts/adamantium"))
                .addTag(TagUtils.cTag("dusts/mithril"))
                .addTag(TagUtils.cTag("dusts/mythril"))
                .addTag(TagUtils.cTag("dusts/copper"))
                .addTag(TagUtils.cTag("dusts/tin"));
        
        
        this.tag(TagUtils.cTag("dusts/adamantium"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.cTag("dusts/adamantine"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.cTag("dusts/adamantite"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.cTag("dusts/mythril"))
            .add(ModItems.mythril_dust.get());
        this.tag(TagUtils.cTag("dusts/mithril"))
            .add(ModItems.mythril_dust.get());
        this.tag(TagUtils.cTag("dusts/copper"))
            .add(ModItems.copper_dust.get());
        this.tag(TagUtils.cTag("dusts/tin"))
            .add(ModItems.tin_dust.get());
    } // end registerDustTags()
    
    private void registerMisc()
    {
    	this.tag(Tags.Items.RODS)
    		.addTag(TagUtils.cTag("rods/mythril"))
    		.addTag(TagUtils.cTag("rods/mithril"))
    		.addTag(TagUtils.cTag("rods/onyx"));
    	this.tag(TagUtils.cTag("rods/mythril"))
    		.add(ModItems.mythril_rod.get());
    	this.tag(TagUtils.cTag("rods/mithril"))
    		.add(ModItems.mythril_rod.get());
    	this.tag(TagUtils.cTag("rods/onyx"))
			.add(ModItems.onyx_rod.get());
    	
    	this.tag(Tags.Items.TOOLS_SHEARS)
    		.add(ModItems.copper_shears.get())
    		.add(ModItems.tin_shears.get())
    		.add(ModItems.mythril_shears.get())
    		.add(ModItems.adamantium_shears.get())
    		.add(ModItems.onyx_shears.get());
    		
    	
     } // end registerMisc()
    
    private void registerOreChunkTags()
    {
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantine"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantium"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/mithril"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/mythril"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/copper"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/tin"));
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/adamantium"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/adamantine"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/adamantite"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/mythril"))
            .add(ModItems.crushed_mythril_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/mithril"))
            .add(ModItems.crushed_mythril_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/copper"))
            .add(ModItems.crushed_copper_ore.get());
        this.tag(TagUtils.modTag("silents_mechanisms", "chunks/tin"))
            .add(ModItems.crushed_tin_ore.get());
    } // end registerOreChunkTags()
} // end class ModItemTags