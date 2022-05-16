package mod.alexndr.simpleores.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.api.client.ClientUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        ClientUtils.setupBowModelProperties(ModItems.mythril_bow.get());
        ClientUtils.setupBowModelProperties(ModItems.onyx_bow.get());
        LOGGER.debug("bow model properties set.");
        
        // doors with see-through windows.
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.adamantium_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.copper_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.tin_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.onyx_door.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.mythril_door.get(), (layer) -> layer 
                == RenderType.cutout());
        
        // bars, which are see-through between the bars, obviously.
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.copper_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.tin_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.onyx_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.adamantium_bars.get(), (layer) -> layer 
                == RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.mythril_bars.get(), (layer) -> layer 
                == RenderType.cutout());

    } // end onFMLClientSetupEvent()

 } // end class
