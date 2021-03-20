package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
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
        registerDustTags();
        registerOreChunkTags();
    }

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