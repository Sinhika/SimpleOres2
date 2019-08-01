package mod.alexndr.simpleores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simpleores.config.ConfigHolder;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

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

    } // end SimpleOres()


} // end class SimpleOres
