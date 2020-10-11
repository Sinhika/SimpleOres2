package mod.alexndr.simpleores.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ModTags
{

    public static class Items
    {
        public static final ITag.INamedTag<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_MYTHRIL = forgeTag("ingots/mythril");
        public static final ITag.INamedTag<Item> INGOTS_ADAMANTIUM = forgeTag("ingots/adamantium");
        public static final ITag.INamedTag<Item> GEMS_ONYX = forgeTag("gems/onyx");
        
        public static final ITag.INamedTag<Item> DUSTS_MYTHRIL = forgeTag("dusts/mythril");
        public static final ITag.INamedTag<Item> DUSTS_ADAMANTIUM = forgeTag("dusts/adamantium");
        
        public static final ITag.INamedTag<Item> CHUNKS_MYTHRIL = silentsTag("chunks/mythril");
        public static final ITag.INamedTag<Item> CHUNKS_ADAMANTIUM = silentsTag("chunks/adamantium");
        
        private static ITag.INamedTag<Item> silentsTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", name));
        }
        
        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end subclass Items
    
    public static class Blocks 
    {
        public static final ITag.INamedTag<Block> ORES_MYTHRIL = forgeTag("ores/mythril");
        public static final ITag.INamedTag<Block> ORES_ADAMANTIUM = forgeTag("ores/adamantium");
       
        private static ITag.INamedTag<Block> forgeTag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end subclass Blocks
    
} // end class ModTags
