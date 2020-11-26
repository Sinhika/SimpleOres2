package mod.alexndr.simpleores.init;

import mod.alexndr.simplecorelib.helpers.TagUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

public class ModTags
{

    public static class Items
    {
        public static final ITag.INamedTag<Item> INGOTS_COPPER = TagUtils.forgeTag("ingots/copper");
        public static final ITag.INamedTag<Item> INGOTS_TIN = TagUtils.forgeTag("ingots/tin");
        public static final ITag.INamedTag<Item> INGOTS_MYTHRIL = TagUtils.forgeTag("ingots/mythril");
        public static final ITag.INamedTag<Item> INGOTS_ADAMANTIUM = TagUtils.forgeTag("ingots/adamantium");
        public static final ITag.INamedTag<Item> GEMS_ONYX = TagUtils.forgeTag("gems/onyx");

        public static final ITag.INamedTag<Item> ORES_TIN = TagUtils.forgeTag("ores/tin");
        public static final ITag.INamedTag<Item> ORES_MYTHRIL = TagUtils.forgeTag("ores/mythril");
        public static final ITag.INamedTag<Item> ORES_ADAMANTIUM = TagUtils.forgeTag("ores/adamantium");
        
        public static final ITag.INamedTag<Item> DUSTS_TIN = TagUtils.forgeTag("dusts/tin");
        public static final ITag.INamedTag<Item> DUSTS_MYTHRIL = TagUtils.forgeTag("dusts/mythril");
        public static final ITag.INamedTag<Item> DUSTS_ADAMANTIUM = TagUtils.forgeTag("dusts/adamantium");
        
        public static final ITag.INamedTag<Item> CHUNKS_TIN = TagUtils.silentsTag("chunks/tin");
        public static final ITag.INamedTag<Item> CHUNKS_MYTHRIL = TagUtils.silentsTag("chunks/mythril");
        public static final ITag.INamedTag<Item> CHUNKS_ADAMANTIUM = TagUtils.silentsTag("chunks/adamantium");
        
         
     } // end subclass Items
    
    public static class Blocks 
    {
        public static final ITag.INamedTag<Block> ORES_TIN = TagUtils.forgeBlockTag("ores/tin");
        public static final ITag.INamedTag<Block> ORES_MYTHRIL = TagUtils.forgeBlockTag("ores/mythril");
        public static final ITag.INamedTag<Block> ORES_ADAMANTIUM = TagUtils.forgeBlockTag("ores/adamantium");
    } // end subclass Blocks
    
} // end class ModTags
