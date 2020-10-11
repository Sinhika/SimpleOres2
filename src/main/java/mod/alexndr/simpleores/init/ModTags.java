package mod.alexndr.simpleores.init;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags
{

    public static class Items
    {
        public static final Tag<Item> INGOTS_COPPER = forgeTag("ingots/copper");
        public static final Tag<Item> INGOTS_TIN = forgeTag("ingots/tin");
        public static final Tag<Item> INGOTS_MYTHRIL = forgeTag("ingots/mythril");
        public static final Tag<Item> INGOTS_ADAMANTIUM = forgeTag("ingots/adamantium");
        public static final Tag<Item> GEMS_ONYX = forgeTag("gems/onyx");

        public static final Tag<Item> ORES_MYTHRIL = forgeTag("ores/mythril");
        public static final Tag<Item> ORES_ADAMANTIUM = forgeTag("ores/adamantium");
        
        public static final Tag<Item> DUSTS_MYTHRIL = forgeTag("dusts/mythril");
        public static final Tag<Item> DUSTS_ADAMANTIUM = forgeTag("dusts/adamantium");
        
        public static final Tag<Item> CHUNKS_MYTHRIL = silentsTag("chunks/mythril");
        public static final Tag<Item> CHUNKS_ADAMANTIUM = silentsTag("chunks/adamantium");
        
        private static Tag<Item> silentsTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("silents_mechanisms", name));
        }
        
        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end subclass Items
    
    
} // end class ModTags
