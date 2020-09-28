package mod.alexndr.simpleores.init;

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
        
        private static ITag.INamedTag<Item> forgeTag(String name) {
            return ItemTags.makeWrapperTag("forge:" + name);
        }
    } // end class Items
    
    
    
} // end class ModTags
