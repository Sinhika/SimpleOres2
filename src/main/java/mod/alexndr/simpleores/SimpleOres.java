package mod.alexndr.simpleores;

import mod.alexndr.simpleores.client.ClientForgeEventSubscriber;
import mod.alexndr.simpleores.client.ClientModEventSubscriber;
import mod.alexndr.simpleores.config.SimpleOresClientConfig;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.CreativeTabs;
import mod.alexndr.simpleores.init.ModArmorMaterials;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimpleOres.MODID)
public class SimpleOres
{
    // modid
    public static final String MODID = "simpleores";

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public SimpleOres(IEventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.info("Hello from Simple Ores!");

        // Register Deferred Registers
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // register event listeners.
        modEventBus.addListener(ModEventSubscriber::onRegisterItems);
        modEventBus.addListener(SimpleOresConfig::onLoad);
        modEventBus.addListener(SimpleOresClientConfig::onLoad);
        modEventBus.addListener(ModEventSubscriber::onSendIMC);
        NeoForge.EVENT_BUS.addListener(ForgeEventSubscriber::onVillagerTrades);

        // client event listeners
        modEventBus.addListener(FMLClientSetupEvent.class,
                                ClientModEventSubscriber::onFMLClientSetupEvent);
        NeoForge.EVENT_BUS.addListener(ComputeFovModifierEvent.class,
                                        ClientForgeEventSubscriber::onFovEvent);

        // Register Configs
        modContainer.registerConfig(ModConfig.Type.STARTUP, SimpleOresConfig.SPEC);
//        modContainer.registerConfig(ModConfig.Type.COMMON, SimpleOresConfig.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, SimpleOresClientConfig.SPEC);

    } // end SimpleOres()

} // end class SimpleOres
