package mod.alexndr.simpleores.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo
 * It can be merged into the main ExampleModConfig class, but is separate because of personal preference and to keep the code organised
 */
public final class ConfigHelper
{

	// We store a reference to the ModConfigs here to be able to change the values in them from our code
	// (For example from a config GUI)
	private static ModConfig serverConfig;

//	public static void bakeClient(final ModConfig config) { }

	public static void bakeServer(final ModConfig config)
	{
		serverConfig = config;

		SimpleOresConfig.enableCopperOre = ConfigHolder.SERVER.serverEnableCopperOre.get();
		SimpleOresConfig.enableTinOre = ConfigHolder.SERVER.serverEnableTinOre.get();
		SimpleOresConfig.enableMythrilOre = ConfigHolder.SERVER.serverEnableMythrilOre.get();
		SimpleOresConfig.enableAdamantiumOre = ConfigHolder.SERVER.serverEnableAdamantiumOre.get();
		SimpleOresConfig.enableOnyxOre = ConfigHolder.SERVER.serverEnableOnyxOre.get();
	} // end bakeServer()

	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	} // end setValueAndSave()

} // end class ConfigHelper
