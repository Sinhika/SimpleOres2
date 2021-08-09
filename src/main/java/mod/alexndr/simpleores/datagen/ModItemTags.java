package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * ItemTagsProvider for SimpleOres.
 */
public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator generatorIn, @javax.annotation.Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, new ModBlockTags(generatorIn, existingFileHelper), SimpleOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
    	registerNuggetTags();
    	registerIngotTags();
    	registerRawMetalTags();
    	registerGemTags();
        registerDustTags();
        registerOreChunkTags();
    	registerMisc();
    }

    private void registerNuggetTags()
    {
        this.tag(TagUtils.forgeTag("nuggets"))
	    	.addTag(TagUtils.forgeTag("nuggets/copper"))
			.addTag(TagUtils.forgeTag("nuggets/tin"))
	    	.addTag(TagUtils.forgeTag("nuggets/adamantine"))
	    	.addTag(TagUtils.forgeTag("nuggets/adamantite"))
	    	.addTag(TagUtils.forgeTag("nuggets/adamantium"))
	    	.addTag(TagUtils.forgeTag("nuggets/mithril"))
	    	.addTag(TagUtils.forgeTag("nuggets/mythril"));

        this.tag(TagUtils.forgeTag("nuggets/copper"))
    		.add(ModItems.copper_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/tin"))
        	.add(ModItems.tin_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/adamantine"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/adamantite"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/adamantium"))
    		.add(ModItems.adamantium_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/mythril"))
    		.add(ModItems.mythril_nugget.get());
        this.tag(TagUtils.forgeTag("nuggets/mithril"))
    		.add(ModItems.mythril_nugget.get());
    } // end registerNuggetTags()
    
    private void registerRawMetalTags()
    {
        this.tag(TagUtils.forgeTag("raw_metals"))
	    	.addTag(TagUtils.forgeTag("raw_metals/copper"))
			.addTag(TagUtils.forgeTag("raw_metals/tin"))
	    	.addTag(TagUtils.forgeTag("raw_metals/adamantine"))
	    	.addTag(TagUtils.forgeTag("raw_metals/adamantite"))
	    	.addTag(TagUtils.forgeTag("raw_metals/adamantium"))
	    	.addTag(TagUtils.forgeTag("raw_metals/mithril"))
	    	.addTag(TagUtils.forgeTag("raw_metals/mythril"));
        
        this.tag(TagUtils.forgeTag("raw_metals/copper"))
    		.add(Items.RAW_COPPER);
        this.tag(TagUtils.forgeTag("raw_metals/tin"))
        	.add(ModItems.raw_tin.get());
        this.tag(TagUtils.forgeTag("raw_metals/adamantine"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.forgeTag("raw_metals/adamantite"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.forgeTag("raw_metals/adamantium"))
    		.add(ModItems.raw_adamantium.get());
        this.tag(TagUtils.forgeTag("raw_metals/mythril"))
    		.add(ModItems.raw_mythril.get());
        this.tag(TagUtils.forgeTag("raw_metals/mithril"))
    		.add(ModItems.raw_mythril.get());
    	
    }
    
    private void registerGemTags()
    {
        this.tag(TagUtils.forgeTag("gems"))
        	.addTag(TagUtils.forgeTag("gems/onyx"));
        this.tag(TagUtils.forgeTag("gems/onyx"))
        	.add(ModItems.onyx_gem.get());
    }
    
    private void registerIngotTags()
    {
        this.tag(TagUtils.forgeTag("ingots"))
        	.addTag(TagUtils.forgeTag("ingots/copper"))		// TODO: remove when Forge adds it.
    		.addTag(TagUtils.forgeTag("ingots/tin"))
        	.addTag(TagUtils.forgeTag("ingots/adamantine"))
        	.addTag(TagUtils.forgeTag("ingots/adamantite"))
        	.addTag(TagUtils.forgeTag("ingots/adamantium"))
        	.addTag(TagUtils.forgeTag("ingots/mithril"))
        	.addTag(TagUtils.forgeTag("ingots/mythril"));
        
        // TODO: remove when Forge adds this.
        this.tag(TagUtils.forgeTag("ingots/copper"))
    		.add(Items.COPPER_INGOT);
        // end TODO copper
        this.tag(TagUtils.forgeTag("ingots/tin"))
        	.add(ModItems.tin_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/adamantine"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/adamantite"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/adamantium"))
    		.add(ModItems.adamantium_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/mythril"))
    		.add(ModItems.mythril_ingot.get());
        this.tag(TagUtils.forgeTag("ingots/mithril"))
    		.add(ModItems.mythril_ingot.get());
    	
    } // end registerIngotTags()
    
    
    private void registerDustTags()
    {
        this.tag(TagUtils.forgeTag("dusts"))
                .addTag(TagUtils.forgeTag("dusts/adamantine"))
                .addTag(TagUtils.forgeTag("dusts/adamantite"))
                .addTag(TagUtils.forgeTag("dusts/adamantium"))
                .addTag(TagUtils.forgeTag("dusts/mithril"))
                .addTag(TagUtils.forgeTag("dusts/mythril"))
                .addTag(TagUtils.forgeTag("dusts/copper"))
                .addTag(TagUtils.forgeTag("dusts/tin"));
        
        
        this.tag(TagUtils.forgeTag("dusts/adamantium"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.forgeTag("dusts/adamantine"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.forgeTag("dusts/adamantite"))
            .add(ModItems.adamantium_dust.get());
        this.tag(TagUtils.forgeTag("dusts/mythril"))
            .add(ModItems.mythril_dust.get());
        this.tag(TagUtils.forgeTag("dusts/mithril"))
            .add(ModItems.mythril_dust.get());
        this.tag(TagUtils.forgeTag("dusts/copper"))
            .add(ModItems.copper_dust.get());
        this.tag(TagUtils.forgeTag("dusts/tin"))
            .add(ModItems.tin_dust.get());
    } // end registerDustTags()
    
    private void registerMisc()
    {
    	this.tag(TagUtils.forgeTag("rods"))
    		.addTag(TagUtils.forgeTag("rods/mythril"))
    		.addTag(TagUtils.forgeTag("rods/mithril"))
    		.addTag(TagUtils.forgeTag("rods/onyx"));
    	this.tag(TagUtils.forgeTag("rods/mythril"))
    		.add(ModItems.mythril_rod.get());
    	this.tag(TagUtils.forgeTag("rods/mithril"))
    		.add(ModItems.mythril_rod.get());
    	this.tag(TagUtils.forgeTag("rods/onyx"))
			.add(ModItems.onyx_rod.get());
    	
    	this.tag(TagUtils.forgeTag("shears"))
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