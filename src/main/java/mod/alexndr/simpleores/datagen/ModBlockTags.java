package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * BlockTagsProvider for SimpleOres. Mostly this is proof-of-concept, and guidance for other
 * mods on how to do tags with datagen.
 * 
 * @author Sinhika
 *
 */
public class ModBlockTags extends BlockTagsProvider
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
    } // end registerTags()
    
    private void registerBeaconTags()
    {
    	this.tag(TagUtils.modBlockTag("minecraft", "beacon_base_blocks"))
    		.add(Blocks.COPPER_BLOCK)
			.add(ModBlocks.adamantium_block.get())
			.add(ModBlocks.tin_block.get())
			.add(ModBlocks.mythril_block.get());
    }
    
    private void registerMiningTags()
    {
        this.tag(TagUtils.modBlockTag("minecraft", "mineable/pickaxe"))
        	.add(ModBlocks.adamantium_block.get())
        	.add(ModBlocks.adamantium_ore.get())
        	.add(ModBlocks.raw_adamantium_block.get())
        	.add(ModBlocks.tin_block.get())
        	.add(ModBlocks.tin_ore.get())
        	.add(ModBlocks.raw_tin_block.get())
        	.add(ModBlocks.mythril_block.get())
        	.add(ModBlocks.mythril_ore.get())
        	.add(ModBlocks.raw_mythril_block.get())
        	.add(ModBlocks.onyx_block.get())
        	.add(ModBlocks.onyx_ore.get());
    }
    
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
    
    private void registerOreTags()
    {
        this.tag(TagUtils.forgeBlockTag( "ores"))
                .addTag(TagUtils.forgeBlockTag( "ores/copper"))
                .addTag(TagUtils.forgeBlockTag( "ores/tin"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantine"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantite"))
                .addTag(TagUtils.forgeBlockTag( "ores/adamantium"))
                .addTag(TagUtils.forgeBlockTag( "ores/mithril"))
                .addTag(TagUtils.forgeBlockTag( "ores/mythril"))
                .addTag(TagUtils.forgeBlockTag( "ores/onyx"));

        // because vanilla copper hasn't been added to forge tags by default yet.
        this.tag(TagUtils.forgeBlockTag( "ores/copper"))
                .add(Blocks.COPPER_ORE)
                .add(Blocks.DEEPSLATE_COPPER_ORE);
        // end copper
        this.tag(TagUtils.forgeBlockTag( "ores/tin"))
                .add(ModBlocks.tin_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantium"))
                .add(ModBlocks.adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantine"))
                .add(ModBlocks.adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/adamantite"))
                .add(ModBlocks.adamantium_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/mythril"))
                .add(ModBlocks.mythril_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/mithril"))
                .add(ModBlocks.mythril_ore.get());
        this.tag(TagUtils.forgeBlockTag( "ores/onyx"))
                .add(ModBlocks.onyx_ore.get());
    } // end registerOreTags()

 } // end-class ModBlockTags