package mod.alexndr.simpleores.client;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
        float baseFOV = event.getFov();
        float myNewFOV = 1.0F;
        
        ItemStack heldItemStack = event.getEntity().getMainHandItem();
        if (heldItemStack.isEmpty()) { 
            return;
        }
        Item heldItem = heldItemStack.getItem();
        int useRemaining = event.getEntity().getTicksUsingItem();
        if (heldItem instanceof BowItem)
        { 
            float zoom = 1.0F;
            if (heldItem instanceof MythrilBow) 
            {
                zoom = SimpleOresConfig.mythrilBowZoom;
            }
            else if (heldItem instanceof OnyxBow) 
            {
                zoom = SimpleOresConfig.onyxBowZoom;
            }
            else {
                return;
            }
            myNewFOV = baseFOV - (useRemaining * zoom / 20.0F);
            if (myNewFOV < baseFOV - zoom)
                myNewFOV = (baseFOV - zoom);
            event.setNewfov(myNewFOV);
        } 
    } // end fovEvent
} // end class
