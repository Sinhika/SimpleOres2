package mod.alexndr.simpleores.config;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraftforge.common.ForgeConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL SERVER.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 * @author Sinhika
 */
final class ServerConfig
{

	final ForgeConfigSpec.BooleanValue serverEnableCopperOre;
	final ForgeConfigSpec.BooleanValue serverEnableTinOre;
	final ForgeConfigSpec.BooleanValue serverEnableMythrilOre;
	final ForgeConfigSpec.BooleanValue serverEnableAdamantiumOre;
	final ForgeConfigSpec.BooleanValue serverEnableOnyxOre;

	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
		builder.push("general");
		serverEnableCopperOre = builder
				.comment("Enable copper ore generation?")
				.translation(SimpleOres.MODID + ".config.serverEnableCopperOre")
				.define("serverEnableCopperOre", true);
		serverEnableTinOre = builder
				.comment("Enable tin ore generation?")
				.translation(SimpleOres.MODID + ".config.serverEnableTinOre")
				.define("serverEnableTinOre", true);
		serverEnableMythrilOre = builder
				.comment("Enable mythril ore generation?")
				.translation(SimpleOres.MODID + ".config.serverEnableMythrilOre")
				.define("serverEnableMythrilOre", true);
		serverEnableAdamantiumOre = builder
				.comment("Enable adamantium ore generation?")
				.translation(SimpleOres.MODID + ".config.serverEnableAdamantiumOre")
				.define("serverEnableAdamantiumOre", true);
		serverEnableOnyxOre = builder
				.comment("Enable onyx ore generation?")
				.translation(SimpleOres.MODID + ".config.serverEnableOnyxOre")
				.define("serverEnableOnyxOre", true);
		builder.pop();
	} // end ctor

} // end class ServerConfig
