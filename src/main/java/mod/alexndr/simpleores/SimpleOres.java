package mod.alexndr.simpleores;

import mod.alexndr.simpleores.config.ConfigHolder;
import mod.alexndr.simpleores.generation.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimpleOres.MODID)
public class SimpleOres
{
	// modid 
	public static final String MODID = "simpleores";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public SimpleOres()
    {
    	LOGGER.info("Hello from Simple Ores!");
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    } // end SimpleOres()

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupOreGen();
        OreGeneration.setupNetherOreGen();
        LOGGER.debug("Common setup done");
    } // end onCommonSetup
} // end class SimpleOres
