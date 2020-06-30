package mod.alexndr.simpleores.content;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CopperBucket extends BucketItem
{
    public CopperBucket(Properties builder)
    {
    	// ForgeRegistries.FLUIDS.?
        super(() -> Fluids.EMPTY, builder);
    }

    public CopperBucket(Supplier<? extends Fluid> supplier, Properties builder) {
		super(supplier, builder);
	}

	public CopperBucket(net.minecraft.fluid.Fluid containedFluidIn, Properties builder)
    {
        super(()->containedFluidIn, builder);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tips.copper_bucket")).func_240699_a_(
                TextFormatting.GREEN));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ActionResult<ItemStack> itemStackActionResult =
                super.onItemRightClick(worldIn, playerIn, handIn);

        // intercept result and correct bucket type.
        if (itemStackActionResult.getType() == ActionResultType.CONSUME)
        {
            ItemStack newItemStack = ItemStack.EMPTY;

            Item itemBucket = itemStackActionResult.getResult().getItem();
            Item newBucket = fixBucketItem(itemBucket);

            if (newBucket != itemBucket)
            {
                if (newBucket == null) {
                    newItemStack = ItemStack.EMPTY;
                    // playerIn.playSound(SoundEvents.BLOCK_LAVA_EXTINGUISH, 1.0F, 1.0F);
                }
                else {
                    newItemStack = new ItemStack(newBucket);
                }
                itemStackActionResult =
                        new ActionResult<ItemStack>(ActionResultType.CONSUME,
                                                    newItemStack);
            } // end-if newBucket changed
        } // end-if Action CONSUME
        return itemStackActionResult;
    } // end onItemRightClick()

    private Item fixBucketItem(Item bucketIn)
    {
        if (bucketIn == Items.WATER_BUCKET)
        {
            return ModItems.copper_bucket_water.get();
        }
        if (bucketIn == Items.BUCKET)
        {
            // not sure how we would get here, but okay...
            return ModItems.copper_bucket.get();
        }
        if (bucketIn == Items.LAVA_BUCKET)
        {
            // really shouldn't have done that...
            return null;
        }
        return bucketIn;
    } // end fixBucketItem()

    @Override
    protected ItemStack emptyBucket(ItemStack stack, PlayerEntity playerEntity)
    {
        return !playerEntity.isCreative()
                ? new ItemStack(ModItems.copper_bucket.get())
                : stack;
    }
}  // end class CopperBucket
