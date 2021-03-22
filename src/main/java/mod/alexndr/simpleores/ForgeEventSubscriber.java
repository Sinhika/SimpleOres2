package mod.alexndr.simpleores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.helpers.LootUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.generation.OreGeneration;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.loot.SimpleOresInjectionLookup;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;
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
	        if (event.getTarget().getType() == RayTraceResult.Type.BLOCK) 
	        {
	            BlockRayTraceResult rtResult = (BlockRayTraceResult) event.getTarget();
	            BlockPos blockpos = rtResult.getBlockPos();
	            Direction direction = rtResult.getDirection();
	            BlockPos blockpos1 = blockpos.relative(direction);
	            if (event.getWorld().mayInteract(event.getPlayer(), blockpos) 
	                && event.getPlayer().mayUseItemAt(blockpos1, direction, event.getEmptyBucket()))
	            {
	                BlockState blockstate1 = event.getWorld().getBlockState(blockpos);
	                if (blockstate1.getBlock() instanceof FlowingFluidBlock) 
	                {
	                    Fluid fluid = ((FlowingFluidBlock) blockstate1.getBlock()).getFluid();
	                    if (fluid != Fluids.EMPTY && fluid.is(FluidTags.LAVA)) 
	                    {
	                        Item bucketItem = event.getEmptyBucket().getItem();
	                        event.getPlayer().awardStat(Stats.ITEM_USED.get(bucketItem));
	                        SoundEvent soundevent = SoundEvents.LAVA_EXTINGUISH;
	                        event.getPlayer().playSound(soundevent, 1.0F, 1.0F);
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
	
	
    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.Category.NETHER) 
        {
            OreGeneration.generateNetherOres(evt);
        }
        else if (evt.getCategory() != Biome.Category.THEEND)
        {
            OreGeneration.generateOverworldOres(evt);
        }
    } // end onBiomeLoading()
    
} // end-class
