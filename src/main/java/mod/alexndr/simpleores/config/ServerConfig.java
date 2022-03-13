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

    final ForgeConfigSpec.BooleanValue serverEnableTinOre;
    final ForgeConfigSpec.IntValue serverTinVeinSize;
    final ForgeConfigSpec.IntValue serverTinVeinCount;
    final ForgeConfigSpec.IntValue serverTinBottomHeight;
    final ForgeConfigSpec.IntValue serverTinMaxHeight;
    
    final ForgeConfigSpec.BooleanValue serverEnableMythrilOre;
    final ForgeConfigSpec.IntValue serverMythrilVeinSize;
    final ForgeConfigSpec.IntValue serverMythrilVeinCount;
    final ForgeConfigSpec.IntValue serverMythrilBottomHeight;
    final ForgeConfigSpec.IntValue serverMythrilMaxHeight;
    
    final ForgeConfigSpec.BooleanValue serverEnableAdamantiumOre;
    final ForgeConfigSpec.IntValue serverAdamantiumVeinSize;
    final ForgeConfigSpec.IntValue serverAdamantiumVeinCount;
    final ForgeConfigSpec.IntValue serverAdamantiumBottomHeight;
    final ForgeConfigSpec.IntValue serverAdamantiumMaxHeight;
    
    final ForgeConfigSpec.BooleanValue serverEnableOnyxOre;
    final ForgeConfigSpec.IntValue serverOnyxVeinSize;
    final ForgeConfigSpec.IntValue serverOnyxVeinCount;
    final ForgeConfigSpec.IntValue serverOnyxBottomHeight;
    final ForgeConfigSpec.IntValue serverOnyxMaxHeight;

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
	    
	    builder.push("OreGeneration");
        serverEnableTinOre = builder
                .comment("Enable tin ore generation?")
                .translation(SimpleOres.MODID + ".config.enableTinOre")
                .define("EnableTinOre", true);
        serverEnableMythrilOre = builder
                .comment("Enable mythril ore generation?")
                .translation(SimpleOres.MODID + ".config.enableMythrilOre")
                .define("EnableMythrilOre", true);
        serverEnableAdamantiumOre = builder
                .comment("Enable adamantium ore generation?")
                .translation(SimpleOres.MODID + ".config.enableAdamantiumOre")
                .define("EnableAdamantiumOre", true);
        serverEnableOnyxOre = builder
                .comment("Enable onyx ore generation?")
                .translation(SimpleOres.MODID + ".config.enableOnyxOre")
                .define("EnableOnyxOre", true);
        
		builder.push("Tin");
        serverTinVeinSize = builder
                .comment("Tin ore vein size")
                .translation(SimpleOres.MODID + ".config.serverTinVeinSize")
                .defineInRange("TinVeinSize", 7, 1, Integer.MAX_VALUE);
        serverTinVeinCount = builder
                .comment("Tin ore vein count per chunk")
                .translation(SimpleOres.MODID + ".config.serverTinVeinCount")
                .defineInRange("TinVeinCount", 20, 1, Integer.MAX_VALUE);
        serverTinBottomHeight = builder
                .comment("Tin ore minimum height")
                .translation(SimpleOres.MODID + ".config.serverTinBottomHeight")
                .defineInRange("TinBottomHeight", 44, -63, 254);
        serverTinMaxHeight = builder
                .comment("Tin ore maximum height")
                .translation(SimpleOres.MODID + ".config.serverTinMaxHeight")
                .defineInRange("TinMaxHeight", 84, 1, 255);
        builder.pop();

        builder.push("Mythril");
        serverMythrilVeinSize = builder
                .comment("Mythril ore vein size")
                .translation(SimpleOres.MODID + ".config.serverMythrilVeinSize")
                .defineInRange("MythrilVeinSize", 4, 1, Integer.MAX_VALUE);
        serverMythrilVeinCount = builder
                .comment("Mythril ore vein count per chunk")
                .translation(SimpleOres.MODID + ".config.serverMythrilVeinCount")
                .defineInRange("MythrilVeinCount", 8, 1, Integer.MAX_VALUE);
        serverMythrilBottomHeight = builder
                .comment("Mythril ore minimum height")
                .translation(SimpleOres.MODID + ".config.serverMythrilBottomHeight")
                .defineInRange("MythrilBottomHeight", -63, -63, 254);
        serverMythrilMaxHeight = builder
                .comment("Mythril ore maximum height")
                .translation(SimpleOres.MODID + ".config.serverMythrilMaxHeight")
                .defineInRange("MythrilMaxHeight", 32, 1, 255);
        builder.pop();

        builder.push("Adamantium");
        serverAdamantiumVeinSize = builder
                .comment("Adamantium ore vein size")
                .translation(SimpleOres.MODID + ".config.serverAdamantiumVeinSize")
                .defineInRange("AdamantiumVeinSize", 4, 1, Integer.MAX_VALUE);
        serverAdamantiumVeinCount = builder
                .comment("Adamantium ore vein count per chunk")
                .translation(SimpleOres.MODID + ".config.serverAdamantiumVeinCount")
                .defineInRange("AdamantiumVeinCount", 4, 1, Integer.MAX_VALUE);
        serverAdamantiumBottomHeight = builder
                .comment("Adamantium ore minimum height")
                .translation(SimpleOres.MODID + ".config.serverAdamantiumBottomHeight")
                .defineInRange("AdamantiumBottomHeight", -63, -63, 254);
        serverAdamantiumMaxHeight = builder
                .comment("Adamantium ore maximum height")
                .translation(SimpleOres.MODID + ".config.serverAdamantiumMaxHeight")
                .defineInRange("AdamantiumMaxHeight", -16, 1, 255);
        builder.pop();

        builder.push("Onyx");
        serverOnyxVeinSize = builder
                .comment("Onyx ore vein size")
                .translation(SimpleOres.MODID + ".config.serverOnyxVeinSize")
                .defineInRange("OnyxVeinSize", 4, 1, Integer.MAX_VALUE);
        serverOnyxVeinCount = builder
                .comment("Onyx ore vein count per chunk")
                .translation(SimpleOres.MODID + ".config.serverOnyxVeinCount")
                .defineInRange("OnyxVeinCount", 5, 1, Integer.MAX_VALUE);
        serverOnyxBottomHeight = builder
                .comment("Onyx ore minimum height in rock only (netherrack goes full range)")
                .translation(SimpleOres.MODID + ".config.serverOnyxBottomHeight")
                .defineInRange("OnyxBottomHeight", 8, 1, 127);
        serverOnyxMaxHeight = builder
                .comment("Onyx ore maximum height in rock only (netherrack goes full range)")
                .translation(SimpleOres.MODID + ".config.serverOnyxMaxHeight")
                .defineInRange("OnyxMaxHeight", 64, 1, 128);
        builder.pop();
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
                .translation(SimpleOres.MODID + ".config.enableCopperBucket")
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
