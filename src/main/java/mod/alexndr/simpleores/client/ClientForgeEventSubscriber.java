package mod.alexndr.simpleores.client;

import mod.alexndr.simplecorelib.api.client.ClientUtils;
import mod.alexndr.simpleores.config.SimpleOresClientConfig;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
public class ClientForgeEventSubscriber
{
    //private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Client Forge Event Subscriber");

    /**
     * handle view zoom while drawing custom bows.
     * @param event
     */
    public static void onFovEvent(ComputeFovModifierEvent event)
    {
        ClientUtils.handleFovEvent(event, p -> p instanceof MythrilBow, SimpleOresClientConfig.mythrilBowZoom);
        ClientUtils.handleFovEvent(event, p -> p instanceof OnyxBow, SimpleOresClientConfig.onyxBowZoom);
    } // end fovEvent
} // end class
