package mod.alexndr.simpleores.content;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;

public class CopperBucket extends BucketItem
{
    public CopperBucket(Properties builder)
    {
        super(Fluids.EMPTY, builder);
    }

    public CopperBucket(net.minecraft.fluid.Fluid containedFluidIn, Properties builder)
    {
        super(containedFluidIn, builder);
    }

    @Override
    protected ItemStack emptyBucket(ItemStack stack, PlayerEntity playerEntity)
    {
        return !playerEntity.playerAbilities.isCreativeMode
                ? new ItemStack(ModItems.copper_bucket)
                : stack;
    }
}  // end class CopperBucket
