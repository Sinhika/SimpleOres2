package mod.alexndr.simpleores.content;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.UniversalBucket;

import javax.annotation.Nonnull;

public class CopperBucket extends UniversalBucket
{
    public CopperBucket(Properties properties)
    {
        super(properties, Fluid.BUCKET_VOLUME, new ItemStack(ModItems.empty_copper_bucket), false);
    }

}  // end class CopperBucket
