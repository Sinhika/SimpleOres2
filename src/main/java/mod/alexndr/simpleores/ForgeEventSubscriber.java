package mod.alexndr.simpleores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.loot.SimpleOresInjectionLookup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = SimpleOres.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
	@SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Forge Event Subscriber");
	private static final SimpleOresInjectionLookup lootLookupMap = new SimpleOresInjectionLookup();
	
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (SimpleOresConfig.addModLootToChests)
        {
            LootUtils.LootLoadHandler(SimpleOres.MODID, event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
    
	/**
	 * deal with copper bucket poking lava.
	 */
	@SubscribeEvent
	public static void FillBucket(final FillBucketEvent event)
	{
	    if (event.getEmptyBucket().getItem() == ModItems.copper_bucket.get()) 
	    {
	        if (event.getTarget().getType() == HitResult.Type.BLOCK) 
	        {
	            BlockHitResult rtResult = (BlockHitResult) event.getTarget();
	            BlockPos blockpos = rtResult.getBlockPos();
	            Direction direction = rtResult.getDirection();
	            BlockPos blockpos1 = blockpos.relative(direction);
	            if (event.getLevel().mayInteract(event.getEntity(), blockpos) 
	                && event.getEntity().mayUseItemAt(blockpos1, direction, event.getEmptyBucket()))
	            {
	                BlockState blockstate1 = event.getLevel().getBlockState(blockpos);
	                if (blockstate1.getBlock() instanceof LiquidBlock) 
	                {
	                    FluidState fluid = ((LiquidBlock) blockstate1.getBlock()).getFluidState(blockstate1);
	                    if (!fluid.isEmpty() && fluid.is(FluidTags.LAVA)) 
	                    {
	                        Item bucketItem = event.getEmptyBucket().getItem();
	                        event.getEntity().awardStat(Stats.ITEM_USED.get(bucketItem));
	                        SoundEvent soundevent = SoundEvents.LAVA_EXTINGUISH;
	                        event.getEntity().playSound(soundevent, 1.0F, 1.0F);
	                        event.setFilledBucket(ItemStack.EMPTY);
                            event.setResult(Result.ALLOW);
                            return;
                        }
                    } // end-if
                } // end-if
	        } // end-if
	    }
        event.setResult(Result.DEFAULT);
	} // end FillBucket()
    
} // end-class
