package mod.alexndr.simpleores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.loot.ChestLootHandler;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.generation.OreGeneration;
import mod.alexndr.simpleores.init.ModItems;
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
	private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Forge Event Subscriber");

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
	            BlockPos blockpos = rtResult.getPos();
	            Direction direction = rtResult.getFace();
	            BlockPos blockpos1 = blockpos.offset(direction);
	            if (event.getWorld().isBlockModifiable(event.getPlayer(), blockpos) 
	                && event.getPlayer().canPlayerEdit(blockpos1, direction, event.getEmptyBucket()))
	            {
	                BlockState blockstate1 = event.getWorld().getBlockState(blockpos);
	                if (blockstate1.getBlock() instanceof FlowingFluidBlock) 
	                {
	                    Fluid fluid = ((FlowingFluidBlock) blockstate1.getBlock()).getFluid();
	                    if (fluid != Fluids.EMPTY && fluid.isIn(FluidTags.LAVA)) 
	                    {
	                        Item bucketItem = event.getEmptyBucket().getItem();
	                        event.getPlayer().addStat(Stats.ITEM_USED.get(bucketItem));
	                        SoundEvent soundevent = SoundEvents.BLOCK_LAVA_EXTINGUISH;
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
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (SimpleOresConfig.addModLootToChests)
        {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) 
            {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                
                // village chests are a bit more complicated now, but use the old
                // village_blacksmith chest loot table anyway.
                if (file.startsWith("village/village_")) 
                {
                    String village = "village/";
                    file = file.substring(file.indexOf(village) + village.length());
                }
                else if (file.startsWith("stronghold_")) 
                {
                    file = "stronghold";
                }
                switch (file) {
                case "simple_dungeon":
                case "stronghold":
                case "woodland_mansion":
                case "shipwreck_supply":
                case "shipwreck_map":
                case "shipwreck_treasure":
                case "buried_treasure":
                case "pillager_outpost":
                case "underwater_ruin_small":
                case "underwater_ruin_big":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(SimpleOres.MODID, "simple_dungeon"));
                    break;
                case "nether_bridge":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(SimpleOres.MODID, "nether"));
                    break;
                case "village_weaponsmith":
                case "village_toolsmith":
                case "village_armorer":
                case "village_shepherd":
                case "village_mason":
                case "village_fletcher":
                case "desert_pyramid":
                case "abandoned_mineshaft":
                case "jungle_temple":
                case "spawn_bonus_chest":
                case "igloo_chest":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(SimpleOres.MODID, file));
                    break;
                default:
                    // cases deliberately ignored:
                    // dispensers, because you don't shoot ingots/ores/tools at people.
                    // other villagers
                    // the_end, because no end ores or metals.
                    break;
                } // end-switch
            } // end-if chest loot
            
        } // end-if config allows
    } // end LootLoad()
    
    
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
