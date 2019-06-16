package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public final class ModTabGroups
{

    public static final ItemGroup MOD_ITEM_GROUP = new ModTabGroup(SimpleOres.MODID, () -> new ItemStack(ModItems.copper_ingot));

    public static final class ModTabGroup extends ItemGroup
    {

        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * @param name  String: mod id
         * @param iconSupplier
         */
        public ModTabGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier)
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

    } // end ModTabGroup()

}  // end class ModTabGroup
