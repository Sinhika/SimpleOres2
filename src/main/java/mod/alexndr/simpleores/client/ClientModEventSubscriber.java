package mod.alexndr.simpleores.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid=SimpleOres.MODID, bus=EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class ClientModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Client Mod Event Subscriber");

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) 
    {
        setupBowModelProperties(ModItems.mythril_bow.get());
        setupBowModelProperties(ModItems.onyx_bow.get());
        LOGGER.debug("bow model properties set.");
    } // end onFMLClientSetupEvent()

    private static void setupBowModelProperties(Item bow) 
    {
        ItemModelsProperties.func_239418_a_(bow, new ResourceLocation("pull"), (p0, p1, p2) -> {
            if (p2 == null) {
               return 0.0F;
            } else {
               return p2.getActiveItemStack() != p0 ? 0.0F : (float)(p0.getUseDuration() - p2.getItemInUseCount()) / 20.0F;
            }
         });
        ItemModelsProperties.func_239418_a_(bow, new ResourceLocation("pulling"), (p0, p1, p2) -> {
            return p2 != null && p2.isHandActive() && p2.getActiveItemStack() == p0 ? 1.0F : 0.0F;
         });
    }
} // end class
