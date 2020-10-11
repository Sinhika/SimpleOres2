package mod.alexndr.simpleores.datagen;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

/**
 * ItemTagsProvider for SimpleOres.
 */
public class ModItemTags extends ItemTagsProvider
{

    public ModItemTags(DataGenerator generatorIn)
    {
        super(generatorIn);
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
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts")))
                .add(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantine")))
                .add(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantite")))
                .add(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantium")))
                .add(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/mithril")))
                .add(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/mythril")));
        
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantium")))
            .add(ModItems.adamantium_dust.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantine")))
            .add(ModItems.adamantium_dust.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/adamantite")))
            .add(ModItems.adamantium_dust.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/mythril")))
            .add(ModItems.mythril_dust.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("forge", "dusts/mithril")))
            .add(ModItems.mythril_dust.get());
    } // end registerDustTags()
    
    private void registerOreChunkTags()
    {
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks")))
            .add(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantine")))
            .add(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantite")))
            .add(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantium")))
            .add(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/mithril")))
            .add(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/mythril")));
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantium")))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantine")))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/adamantite")))
            .add(ModItems.crushed_adamantium_ore.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/mythril")))
            .add(ModItems.crushed_mythril_ore.get());
        this.getBuilder(new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", "chunks/mithril")))
            .add(ModItems.crushed_mythril_ore.get());
    } // end registerOreChunkTags()
} // end class ModItemTags