package mod.alexndr.simpleores.content;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

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

	public CopperBucket(net.minecraft.world.level.material.Fluid containedFluidIn, Properties builder)
    {
        super(()->containedFluidIn, builder);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslatableComponent("tips.copper_bucket"))
                        .withStyle(ChatFormatting.GREEN));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn)
    {
        InteractionResultHolder<ItemStack> itemStackActionResult =
                super.use(worldIn, playerIn, handIn);

        // intercept result and correct bucket type.
        if (itemStackActionResult.getResult() == InteractionResult.CONSUME)
        {
            ItemStack newItemStack = ItemStack.EMPTY;

            Item itemBucket = itemStackActionResult.getObject().getItem();
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
                        new InteractionResultHolder<ItemStack>(InteractionResult.CONSUME,
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

//    @Override
//    protected ItemStack getEmptySuccessItem(ItemStack stack, Player playerEntity)
//    {
//        return !playerEntity.isCreative()
//                ? new ItemStack(ModItems.copper_bucket.get())
//                : stack;
//    }
}  // end class CopperBucket
