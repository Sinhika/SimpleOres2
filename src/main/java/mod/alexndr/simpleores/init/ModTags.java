package mod.alexndr.simpleores.init;

import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{

    public static class Items
    {
        public static final TagKey<Item> INGOTS_COPPER = TagUtils.cTag("ingots/copper");
        public static final TagKey<Item> INGOTS_TIN = TagUtils.cTag("ingots/tin");
        public static final TagKey<Item> INGOTS_MYTHRIL = TagUtils.cTag("ingots/mythril");
        public static final TagKey<Item> INGOTS_ADAMANTIUM = TagUtils.cTag("ingots/adamantium");
        public static final TagKey<Item> GEMS_ONYX = TagUtils.cTag("gems/onyx");

        public static final TagKey<Item> ORES_TIN = TagUtils.cTag("ores/tin");
        public static final TagKey<Item> ORES_MYTHRIL = TagUtils.cTag("ores/mythril");
        public static final TagKey<Item> ORES_ADAMANTIUM = TagUtils.cTag("ores/adamantium");
        
        public static final TagKey<Item> DUSTS_TIN = TagUtils.cTag("dusts/tin");
        public static final TagKey<Item> DUSTS_MYTHRIL = TagUtils.cTag("dusts/mythril");
        public static final TagKey<Item> DUSTS_ADAMANTIUM = TagUtils.cTag("dusts/adamantium");
        
        public static final TagKey<Item> CHUNKS_TIN = TagUtils.silentsTag("chunks/tin");
        public static final TagKey<Item> CHUNKS_MYTHRIL = TagUtils.silentsTag("chunks/mythril");
        public static final TagKey<Item> CHUNKS_ADAMANTIUM = TagUtils.silentsTag("chunks/adamantium");
     } // end subclass Items
    
    public static class Blocks 
    {
        public static final TagKey<Block> ORES_TIN = TagUtils.cBlockTag("ores/tin");
        public static final TagKey<Block> ORES_MYTHRIL = TagUtils.cBlockTag("ores/mythril");
        public static final TagKey<Block> ORES_ADAMANTIUM = TagUtils.cBlockTag("ores/adamantium");

    } // end subclass Blocks
    
} // end class ModTags
