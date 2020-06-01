package mod.alexndr.simpleores.api.content;

import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeBlockState;

public class SimpleShearsItem extends ShearsItem
{

    public SimpleShearsItem(Properties builder)
    {
        super(builder);
    }

    /**
     * Called when this item is used when targetting a Block
     */
    @Override
    public ActionResultType onItemUse(ItemUseContext context)
    {
        // what block are we clicking on?
        BlockPos pos = context.getPos();
        ItemStack stack = context.getItem();
        PlayerEntity player = context.getPlayer();
        World worldIn = context.getWorld();
        
        // there are no shears, there is only Null...
        if (stack.isEmpty()) {
            return ActionResultType.PASS;
        }
        // can we do stuff to this block?
        if (!player.canPlayerEdit(pos, context.getFace(), stack))
        {
            return ActionResultType.PASS;
        }
        // tell me about the block we clicked on.
        IForgeBlockState targetBlock = worldIn.getBlockState(pos);
        // is it a pumpkin? Then carve it!
        if (targetBlock.getBlockState().getBlock() instanceof PumpkinBlock)
        {
            if (!worldIn.isRemote) 
            {
                Direction direction = context.getFace();
                Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                worldIn.setBlockState(pos, Blocks.CARVED_PUMPKIN.getDefaultState().with(CarvedPumpkinBlock.FACING, direction1), 11);
                ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX() + 0.5D + (double)direction1.getXOffset() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction1.getZOffset() * 0.65D, new ItemStack(Items.PUMPKIN_SEEDS, 4));
                itementity.setMotion(0.05D * (double)direction1.getXOffset() + worldIn.rand.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction1.getZOffset() + worldIn.rand.nextDouble() * 0.02D);
                worldIn.addEntity(itementity);
                stack.damageItem(1, player, (p_220282_1_) -> {
                   p_220282_1_.sendBreakAnimation(context.getHand());
                });
             }
            
        }
        return super.onItemUse(context);
    } // end onItemUse()

     
} // end-class

