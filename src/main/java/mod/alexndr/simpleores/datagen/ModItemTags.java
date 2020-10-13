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
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void registerTags()
    {
        registerDustTags();
        registerOreChunkTags();
    }

    private void registerDustTags()
    {
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts"))
                .addTag(TagUtils.forgeTag("dusts/adamantine"))
                .addTag(TagUtils.forgeTag("dusts/adamantite"))
                .addTag(TagUtils.forgeTag("dusts/adamantium"))
                .addTag(TagUtils.forgeTag("dusts/mithril"))
                .addTag(TagUtils.forgeTag("dusts/mythril"));
        
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/adamantium"))
            .add(ModItems.adamantium_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/adamantine"))
            .add(ModItems.adamantium_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/adamantite"))
            .add(ModItems.adamantium_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/mythril"))
            .add(ModItems.mythril_dust.get());
        this.getOrCreateBuilder(TagUtils.forgeTag("dusts/mithril"))
            .add(ModItems.mythril_dust.get());
    } // end registerDustTags()
    
    private void registerOreChunkTags()
    {
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantine"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantite"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/adamantium"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/mithril"))
            .addTag(TagUtils.modTag("silents_mechanisms", "chunks/mythril"));
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/adamantium"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/adamantine"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/adamantite"))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/mythril"))
            .add(ModItems.crushed_mythril_ore.get());
        this.getOrCreateBuilder(TagUtils.modTag("silents_mechanisms", "chunks/mithril"))
            .add(ModItems.crushed_mythril_ore.get());
    } // end registerOreChunkTags()
} // end class ModItemTags