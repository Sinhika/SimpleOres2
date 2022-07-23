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

    final ForgeConfigSpec.BooleanValue serverEnableCopperTools;
    final ForgeConfigSpec.BooleanValue serverEnableTinTools;
    final ForgeConfigSpec.BooleanValue serverEnableMythrilTools;
    final ForgeConfigSpec.BooleanValue serverEnableAdamantiumTools;
    final ForgeConfigSpec.BooleanValue serverEnableOnyxTools;
    
    final ForgeConfigSpec.BooleanValue serverEnableCopperBucket;
    final ForgeConfigSpec.BooleanValue serverEnableModBows;

    final ForgeConfigSpec.BooleanValue serverEnableCopperArmor;
    final ForgeConfigSpec.BooleanValue serverEnableTinArmor;
    final ForgeConfigSpec.BooleanValue serverEnableMythrilArmor;
    final ForgeConfigSpec.BooleanValue serverEnableAdamantiumArmor;
    final ForgeConfigSpec.BooleanValue serverEnableOnyxArmor;
    
    final ForgeConfigSpec.BooleanValue serverAddModLootToChests;
    final ForgeConfigSpec.BooleanValue serverEnableAesthetics;

	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
	    builder.push("General");
	    serverAddModLootToChests = builder.comment("Add SimpleOres items to chest loot?")
                .translation(SimpleOres.MODID + ".config.addModLootToChests")
                .define("AddModLootToChests", true);
        serverEnableAesthetics = builder.comment("Enable Simple Ores aesthetic blocks?")
                .translation(SimpleOres.MODID + "config.EnableAesthetics")
                .define("EnableAestheticsBlocks", true);
	    builder.pop();
	    
        builder.push("Tools");
        serverEnableCopperTools = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableCopperTools")
                .define("EnableCopperTools", true);
        serverEnableTinTools = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableTinTools")
                .define("EnableTinTools", true);
        serverEnableMythrilTools = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableMythrilTools")
                .define("EnableMythrilTools", true);
        serverEnableAdamantiumTools = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableAdamantiumTools")
                .define("EnableAdamantiumTools", true);
        serverEnableOnyxTools = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableOnyxTools")
                .define("EnableOnyxTools", true);
        serverEnableCopperBucket = builder.comment("false disables recipes")
                 .translation(SimpleOres.MODID + ".config.enableCopperBucket")
                  .define("EnableCopperBucket", true);
        serverEnableModBows = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableModBows")
                 .define("EnableModBows", true);
        builder.pop();
        
        builder.push("Armor");
        serverEnableCopperArmor = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableCopperArmor")
                .define("EnableCopperArmor", true);
        serverEnableTinArmor = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableTinArmor")
                .define("EnableTinArmor", true);
        serverEnableMythrilArmor = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableMythrilArmor")
                .define("EnableMythrilArmor", true);
        serverEnableAdamantiumArmor = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableAdamantiumArmor")
                .define("EnableAdamantiumArmor", true);
        serverEnableOnyxArmor = builder.comment("false disables recipes")
                .translation(SimpleOres.MODID + ".config.enableOnyxArmor")
                .define("EnableOnyxArmor", true);
        builder.pop();
        
	} // end ctor

} // end class ServerConfig
