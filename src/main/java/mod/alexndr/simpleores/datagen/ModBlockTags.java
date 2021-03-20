package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
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
    } // end registerTags()
    
    private void registerStorageBlockTags()
    {
        this.tag(TagUtils.forgeBlockTag("storage_blocks"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantium"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantine"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/adamantite"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/copper"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/tin"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/mythril"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/mithril"))
            .addTag(TagUtils.forgeBlockTag("storage_blocks/onyx"));
        
        this.tag(TagUtils.forgeBlockTag("storage_blocks/adamantium"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag("storage_blocks/adamantine"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/adamantite"))
                .add(ModBlocks.adamantium_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/copper"))
                .add(ModBlocks.copper_block.get());
        this.tag(TagUtils.forgeBlockTag( "storage_blocks/tin"))
                .add(ModBlocks.tin_block.get());
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

        this.tag(TagUtils.forgeBlockTag( "ores/copper"))
                .add(ModBlocks.copper_ore.get());
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