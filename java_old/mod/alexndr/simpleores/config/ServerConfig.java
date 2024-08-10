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
public final class ServerConfig
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
    public final ForgeConfigSpec.IntValue serverCopperBucketMeltTemperature;
    public final ForgeConfigSpec.IntValue serverCopperBucketFireTemperature;
    public final ForgeConfigSpec.BooleanValue serverEnableCopperBucketMilking;

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
        serverEnableCopperBucketMilking = builder.comment("false disables milking cows with copper bucets")
                .translation(SimpleOres.MODID + ".config.enableCopperBucketMilking")
                .define("EnableCopperBucketMilking", true);
        serverCopperBucketMeltTemperature = builder.comment("liquids at temperature C or higher melt copper buckets")
                .translation(SimpleOres.MODID + ".config.copperBucketMeltTemperature")
                .defineInRange("CopperBucketMeltTemperature", 1000, -200, 5000);
        serverCopperBucketFireTemperature = builder.comment(
                "Copper is a good heat conductor. Liquids at this temp or higher set you on fire. Leave at 9999 to disable")
                .translation(SimpleOres.MODID + ".config.copperBucketFireTemperature")
                .defineInRange("CopperBucketSetYouOnFireTemperature", 9999, 300, 9999);
        
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
