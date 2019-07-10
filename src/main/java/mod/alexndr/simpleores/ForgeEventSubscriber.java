package mod.alexndr.simpleores;

import mod.alexndr.simpleores.generation.OreGeneration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = SimpleOres.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Forge Event Subscriber");

	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupOreGen();
        OreGeneration.setupNetherOreGen();
        LOGGER.debug("Common setup done");
    } // end onCommonSetup
} // end-class
