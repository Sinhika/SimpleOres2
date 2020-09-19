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
        
        private static Tag<Item> forgeTag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    } // end class Items
    
    
    
} // end class ModTags
