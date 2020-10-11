package mod.alexndr.simpleores.datagen;

import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;

/**
 * BlockTagsProvider for SimpleOres. Mostly this is proof-of-concept, and guidance for other
 * mods on how to do tags with datagen.
 * 
 * @author Sinhika
 *
 */
public class ModBlockTags extends BlockTagsProvider
{
    public ModBlockTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerTags()
    {
        registerOreTags();
        registerStorageBlockTags();
    } // end registerTags()
    
    private void registerStorageBlockTags()
    {
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantium")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantine")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantite")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/copper")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/tin")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/mythril")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/mithril")))
            .add(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/onyx")));
        
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantium")))
                .add(ModBlocks.adamantium_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantine")))
                .add(ModBlocks.adamantium_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/adamantite")))
                .add(ModBlocks.adamantium_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/copper")))
                .add(ModBlocks.copper_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/tin")))
                .add(ModBlocks.tin_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/mythril")))
                .add(ModBlocks.mythril_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/mithril")))
                .add(ModBlocks.mythril_block.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "storage_blocks/onyx")))
                .add(ModBlocks.onyx_block.get());

    } // end registerStorageBlockTags
    
    private void registerOreTags()
    {
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/copper")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/tin")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantine")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantite")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantium")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/mithril")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/mythril")))
                .add(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/onyx")));

        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/copper")))
                .add(ModBlocks.copper_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/tin")))
                .add(ModBlocks.tin_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantium")))
                .add(ModBlocks.adamantium_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantine")))
                .add(ModBlocks.adamantium_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/adamantite")))
                .add(ModBlocks.adamantium_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/mythril")))
                .add(ModBlocks.mythril_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/mithril")))
                .add(ModBlocks.mythril_ore.get());
        this.getBuilder(new BlockTags.Wrapper(new ResourceLocation("forge", "ores/onyx")))
                .add(ModBlocks.onyx_ore.get());
    } // end registerOreTags()

 } // end-class ModBlockTags