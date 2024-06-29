package mod.alexndr.simpleores;

import mod.alexndr.simpleores.config.SimpleOresClientConfig;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.CreativeTabs;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.neoforged.bus.EventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
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

    public SimpleOres(EventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.info("Hello from Simple Ores!");

        // register event listeners.
        modEventBus.addListener(ModEventSubscriber::onRegisterItems);
        modEventBus.addListener(ModEventSubscriber::onSendIMC);
        modEventBus.addListener(ForgeEventSubscriber::onVillagerTrades);

        // Register Deferred Registers (Does not need to be before Configs)
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        
        // Register Configs
        modContainer.registerConfig(ModConfig.Type.COMMON, SimpleOresConfig.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, SimpleOresClientConfig.SPEC);

    } // end SimpleOres()

} // end class SimpleOres
