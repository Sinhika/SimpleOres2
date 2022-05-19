package mod.alexndr.simpleores.client;

import mod.alexndr.simplecorelib.api.client.ClientUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid=SimpleOres.MODID, bus=EventBusSubscriber.Bus.FORGE, value=Dist.CLIENT)
public class ClientForgeEventSubscriber
{
    //private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Client Forge Event Subscriber");

    /**
     * handle view zoom while drawing custom bows.
     * @param event
     */
    @SubscribeEvent
    public static void onFovEvent(FOVModifierEvent event) 
    {
        ClientUtils.handleFovEvent(event, p -> p instanceof MythrilBow, SimpleOresConfig.mythrilBowZoom);
        ClientUtils.handleFovEvent(event, p -> p instanceof OnyxBow, SimpleOresConfig.onyxBowZoom);
    } // end fovEvent
} // end class
