package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import mod.alexndr.simpleores.SimpleOres;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class SimpleOresConfig extends SimpleConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue serverAddModLootToChests;
    private static final ModConfigSpec.BooleanValue serverShowTestBucket;

    public static final ModConfigSpec.IntValue serverCopperBucketMeltTemperature;
    public static final ModConfigSpec.IntValue serverCopperBucketFireTemperature;
    public static final ModConfigSpec.BooleanValue serverEnableCopperBucketMilking;

    // armor properties - Copper
    private static final ModConfigSpec.IntValue serverCopperBaseDefense;
    private static final ModConfigSpec.IntValue serverCopperEnchantability;
    private static final ModConfigSpec.IntValue serverCopperArmorDurability;
    private static final ModConfigSpec.DoubleValue serverCopperToughness;
    private static final ModConfigSpec.DoubleValue serverCopperKnockback;
    
    // armor properties - Tin
    private static final ModConfigSpec.IntValue serverTinBaseDefense;
    private static final ModConfigSpec.IntValue serverTinEnchantability;
    private static final ModConfigSpec.IntValue serverTinArmorDurability;
    private static final ModConfigSpec.DoubleValue serverTinToughness;
    private static final ModConfigSpec.DoubleValue serverTinKnockback;

    // armor properties - Mythril
    private static final ModConfigSpec.IntValue serverMythrilBaseDefense;
    private static final ModConfigSpec.IntValue serverMythrilEnchantability;
    private static final ModConfigSpec.IntValue serverMythrilArmorDurability;
    private static final ModConfigSpec.DoubleValue serverMythrilToughness;
    private static final ModConfigSpec.DoubleValue serverMythrilKnockback;

    // armor properties - Adamantium
    private static final ModConfigSpec.IntValue serverAdamantiumBaseDefense;
    private static final ModConfigSpec.IntValue serverAdamantiumEnchantability;
    private static final ModConfigSpec.IntValue serverAdamantiumArmorDurability;
    private static final ModConfigSpec.DoubleValue serverAdamantiumToughness;
    private static final ModConfigSpec.DoubleValue serverAdamantiumKnockback;

    // armor properties - Onyx
    private static final ModConfigSpec.IntValue serverOnyxBaseDefense;
    private static final ModConfigSpec.IntValue serverOnyxEnchantability;
    private static final ModConfigSpec.IntValue serverOnyxArmorDurability;
    private static final ModConfigSpec.DoubleValue serverOnyxToughness;
    private static final ModConfigSpec.DoubleValue serverOnyxKnockback;

    // tool properties - Copper
    private static final ModConfigSpec.IntValue serverCopperUses;
    private static final ModConfigSpec.DoubleValue serverCopperSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverCopperAttackBonus;
    private static final ModConfigSpec.IntValue serverCopperToolEnchantabilty;

    // tool properties - Tin
    private static final ModConfigSpec.IntValue serverTinUses;
    private static final ModConfigSpec.DoubleValue serverTinSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverTinAttackBonus;
    private static final ModConfigSpec.IntValue serverTinToolEnchantabilty;

    // tool properties - Mythril
    private static final ModConfigSpec.IntValue serverMythrilUses;
    private static final ModConfigSpec.DoubleValue serverMythrilSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverMythrilAttackBonus;
    private static final ModConfigSpec.IntValue serverMythrilToolEnchantabilty;

    // tool properties - Adamantium
    private static final ModConfigSpec.IntValue serverAdamantiumUses;
    private static final ModConfigSpec.DoubleValue serverAdamantiumSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverAdamantiumAttackBonus;
    private static final ModConfigSpec.IntValue serverAdamantiumToolEnchantabilty;

    // tool properties - Onyx
    private static final ModConfigSpec.IntValue serverOnyxUses;
    private static final ModConfigSpec.DoubleValue serverOnyxSpeedBonus;
    private static final ModConfigSpec.DoubleValue serverOnyxAttackBonus;
    private static final ModConfigSpec.IntValue serverOnyxToolEnchantabilty;

    static {
        // general
        BUILDER.push("General");
        serverAddModLootToChests = BUILDER.comment("Add SimpleOres items to chest loot?")
                .translation(SimpleOres.MODID + ".config.addModLootToChests")
                .define("AddModLootToChests", true);
        serverShowTestBucket = BUILDER.comment("Show Texture Test Bucket in Creative Tab?")
                        .define("ShowTestBucket", false);
        BUILDER.pop();
        BUILDER.push("Buckets");
        serverEnableCopperBucketMilking = BUILDER.comment("false disables milking cows with copper buckets")
                .translation(SimpleOres.MODID + ".config.enableCopperBucketMilking")
                .define("EnableCopperBucketMilking", true);
        serverCopperBucketMeltTemperature = BUILDER.comment("liquids at temperature C or higher melt copper buckets")
                .translation(SimpleOres.MODID + ".config.copperBucketMeltTemperature")
                .defineInRange("CopperBucketMeltTemperature", 1000, -200, 5000);
        serverCopperBucketFireTemperature = BUILDER.comment(
                        "Copper is a good heat conductor. Liquids at this temp or higher set you on fire. Leave at 9999 to disable")
                .translation(SimpleOres.MODID + ".config.copperBucketFireTemperature")
                .defineInRange("CopperBucketSetYouOnFireTemperature", 9999, 300, 9999);
        BUILDER.pop();
        BUILDER.push("Armor");
        BUILDER.push("Copper");
        serverCopperBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("CopperBodyDefense", 3, 1, 20);
        serverCopperEnchantability = BUILDER.comment("Copper Armor Enchantability")
                .defineInRange("CopperArmorEnchantibility", 8, 1, 99);
        serverCopperArmorDurability = BUILDER.comment("Base durability for Copper armor")
                .defineInRange("CopperArmorDurability", 8, 1, 99);
        serverCopperToughness = BUILDER.comment("Toughness for Copper armor")
                .defineInRange("CopperToughness", 0.0, 0.0, 10.0);
        serverCopperKnockback = BUILDER.comment("Knockback Resistance for Copper armor")
                .defineInRange("CopperKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("Tin");
        serverTinBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("TinBodyDefense", 3, 1, 20);
        serverTinEnchantability = BUILDER.comment("Tin Armor Enchantability")
                .defineInRange("TinArmorEnchantibility",87, 1, 99);
        serverTinArmorDurability = BUILDER.comment("Base durability for Tin armor")
                .defineInRange("TinArmorDurability", 9, 1, 99);
        serverTinToughness = BUILDER.comment("Toughness for Tin armor")
                .defineInRange("TinToughness", 0.0, 0.0, 10.0);
        serverTinKnockback = BUILDER.comment("Knockback Resistance for Tin armor")
                .defineInRange("TinKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("Mythril");
        serverMythrilBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("MythrilBodyDefense", 4, 1, 20);
        serverMythrilEnchantability = BUILDER.comment("Mythril Armor Enchantability")
                .defineInRange("MythrilArmorEnchantibility", 12, 1, 99);
        serverMythrilArmorDurability = BUILDER.comment("Base durability for Mythril armor")
                .defineInRange("MythrilArmorDurability", 22, 1, 99);
        serverMythrilToughness = BUILDER.comment("Toughness for Mythril armor")
                .defineInRange("MythrilToughness", 0.0, 0.0, 10.0);
        serverMythrilKnockback = BUILDER.comment("Knockback Resistance for Mythril armor")
                .defineInRange("MythrilKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("Adamantium");
        serverAdamantiumBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("AdamantiumBodyDefense", 8, 1, 20);
        serverAdamantiumEnchantability = BUILDER.comment("Adamantium Armor Enchantability")
                .defineInRange("AdamantiumArmorEnchantibility", 3, 1, 99);
        serverAdamantiumArmorDurability = BUILDER.comment("Base durability for Adamantium armor")
                .defineInRange("AdamantiumArmorDurability", 28, 1, 99);
        serverAdamantiumToughness = BUILDER.comment("Toughness for Adamantium armor")
                .defineInRange("AdamantiumToughness", 1.0, 0.0, 10.0);
        serverAdamantiumKnockback = BUILDER.comment("Knockback Resistance for Adamantium armor")
                .defineInRange("AdamantiumKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.push("Onyx");
        serverOnyxBaseDefense = BUILDER.comment("Body Defense - base from which other defense values are calculated")
                .defineInRange("OnyxBodyDefense", 11, 1, 20);
        serverOnyxEnchantability = BUILDER.comment("Onyx Armor Enchantability")
                .defineInRange("OnyxArmorEnchantibility", 15, 1, 99);
        serverOnyxArmorDurability = BUILDER.comment("Base durability for Onyx armor")
                .defineInRange("OnyxArmorDurability", 45, 1, 99);
        serverOnyxToughness = BUILDER.comment("Toughness for Onyx armor")
                .defineInRange("OnyxToughness", 2.0, 0.0, 10.0);
        serverOnyxKnockback = BUILDER.comment("Knockback Resistance for Onyx armor")
                .defineInRange("OnyxKnockback", 0.0, 0.0, 10.0);
        BUILDER.pop();
        BUILDER.pop();
        BUILDER.push("Tool & Weapon Properties");
        BUILDER.push("Copper");
        serverCopperUses = BUILDER.comment("Uses before Copper tool breaks, aka Durability")
                .defineInRange("CopperUses", 185, 1, 9999);
        serverCopperSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Copper added to base tool speed")
                .defineInRange("CopperSpeedBonus", 4.0, 0.0, 99.0);
        serverCopperAttackBonus = BUILDER.comment("Copper Attack Damage Bonus to base tool damage")
                .defineInRange("CopperAttackBonus", 1.0, -1.0, 99.0);
        serverCopperToolEnchantabilty = BUILDER.comment("Copper tool enchantability")
                .defineInRange("CopperToolEnchantabilty", 8, 0, 99);
        BUILDER.pop();
        BUILDER.push("Tin");
        serverTinUses = BUILDER.comment("Uses before Tin tool breaks, aka Durability")
                .defineInRange("TinUses", 220, 1, 9999);
        serverTinSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Tin added to base tool speed")
                .defineInRange("TinSpeedBonus", 3.5, 0.0, 99.0);
        serverTinAttackBonus = BUILDER.comment("Tin Attack Damage Bonus to base tool damage")
                .defineInRange("TinAttackBonus", 1.0, -1.0, 99.0);
        serverTinToolEnchantabilty = BUILDER.comment("Tin tool enchantability")
                .defineInRange("TinToolEnchantabilty", 8, 0, 99);
        BUILDER.pop();
        BUILDER.push("Mythril");
        serverMythrilUses = BUILDER.comment("Uses before Mythril tool breaks, aka Durability")
                .defineInRange("MythrilUses", 800, 1, 9999);
        serverMythrilSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Mythril added to base tool speed")
                .defineInRange("MythrilSpeedBonus", 8.0, 0.0, 99.0);
        serverMythrilAttackBonus = BUILDER.comment("Mythril Attack Damage Bonus to base tool damage")
                .defineInRange("MythrilAttackBonus", 3.0, -1.0, 99.0);
        serverMythrilToolEnchantabilty = BUILDER.comment("Mythril tool enchantability")
                .defineInRange("MythrilToolEnchantabilty", 12, 0, 99);
        BUILDER.pop();
        BUILDER.push("Adamantium");
        serverAdamantiumUses = BUILDER.comment("Uses before Adamantium tool breaks, aka Durability")
                .defineInRange("AdamantiumUses", 1150, 1, 9999);
        serverAdamantiumSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Adamantium added to base tool speed")
                .defineInRange("AdamantiumSpeedBonus", 14.0, 0.0, 99.0);
        serverAdamantiumAttackBonus = BUILDER.comment("Adamantium Attack Damage Bonus to base tool damage")
                .defineInRange("AdamantiumAttackBonus", 3.0, -1.0, 99.0);
        serverAdamantiumToolEnchantabilty = BUILDER.comment("Adamantium tool enchantability")
                .defineInRange("AdamantiumToolEnchantabilty",3, 0, 99);
        BUILDER.pop();
        BUILDER.push("Onyx");
        serverOnyxUses = BUILDER.comment("Uses before Onyx tool breaks, aka Durability")
                .defineInRange("OnyxUses", 3200, 1, 9999);
        serverOnyxSpeedBonus = BUILDER.comment("Speed (efficiency) bonus for Onyx added to base tool speed")
                .defineInRange("OnyxSpeedBonus", 10.0, 0.0, 99.0);
        serverOnyxAttackBonus = BUILDER.comment("Onyx Attack Damage Bonus to base tool damage")
                .defineInRange("OnyxAttackBonus", 5.0, -1.0, 99.0);
        serverOnyxToolEnchantabilty = BUILDER.comment("Onyx tool enchantability")
                .defineInRange("OnyxToolEnchantabilty", 15, 0, 99);
        BUILDER.pop();

        BUILDER.pop();
    } // end-static block

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean addModLootToChests = true;
    public static boolean ShowTestBucket = false;
    public static boolean enableCopperBucketMilking = true;
    public static int copperBucketMeltTemperature = 1000;
    public static int copperBucketFireTemperature = 9999;

    // armor
    public static ArmorProperties copperArmorRecord;
    public static ArmorProperties tinArmorRecord;
    public static ArmorProperties mythrilArmorRecord;
    public static ArmorProperties adamantiumArmorRecord;
    public static ArmorProperties onyxArmorRecord;

    public static ToolProperties copperToolRecord;
    public static ToolProperties tinToolRecord;
    public static ToolProperties mythrilToolRecord;
    public static ToolProperties adamantiumToolRecord;
    public static ToolProperties onyxToolRecord;

    public static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.STARTUP)
        {
            // common/server stuff
            addModLootToChests = serverAddModLootToChests.get();
            ShowTestBucket = serverShowTestBucket.get();
            enableCopperBucketMilking = serverEnableCopperBucketMilking.get();
            copperBucketMeltTemperature = serverCopperBucketMeltTemperature.get();
            copperBucketFireTemperature = serverCopperBucketFireTemperature.get();

            // armor materials
            copperArmorRecord = new ArmorProperties(serverCopperArmorDurability.get(), serverCopperBaseDefense.get(),
                    serverCopperEnchantability.get(), (float) serverCopperToughness.getAsDouble(),
                    (float) serverCopperKnockback.getAsDouble());
            tinArmorRecord = new ArmorProperties(serverTinArmorDurability.get(), serverTinBaseDefense.get(),
                    serverTinEnchantability.get(), (float) serverTinToughness.getAsDouble(),
                    (float) serverTinKnockback.getAsDouble());
            mythrilArmorRecord = new ArmorProperties(serverMythrilArmorDurability.get(), serverMythrilBaseDefense.get(),
                    serverMythrilEnchantability.get(), (float) serverMythrilToughness.getAsDouble(),
                    (float) serverMythrilKnockback.getAsDouble());
            adamantiumArmorRecord = new ArmorProperties(serverAdamantiumArmorDurability.get(), serverAdamantiumBaseDefense.get(),
                    serverAdamantiumEnchantability.get(), (float) serverAdamantiumToughness.getAsDouble(),
                    (float) serverAdamantiumKnockback.getAsDouble());
            onyxArmorRecord = new ArmorProperties(serverOnyxArmorDurability.get(), serverOnyxBaseDefense.get(),
                    serverOnyxEnchantability.get(), (float) serverOnyxToughness.getAsDouble(),
                    (float) serverOnyxKnockback.getAsDouble());
            
            // tool materials
            copperToolRecord = new ToolProperties(serverCopperUses.get(), (float) serverCopperSpeedBonus.getAsDouble(),
                    (float) serverCopperAttackBonus.getAsDouble(), serverCopperToolEnchantabilty.get());
            tinToolRecord = new ToolProperties(serverTinUses.get(), (float) serverTinSpeedBonus.getAsDouble(),
                    (float) serverTinAttackBonus.getAsDouble(), serverTinToolEnchantabilty.get());
            mythrilToolRecord = new ToolProperties(serverMythrilUses.get(), (float) serverMythrilSpeedBonus.getAsDouble(),
                    (float) serverMythrilAttackBonus.getAsDouble(), serverMythrilToolEnchantabilty.get());
            adamantiumToolRecord = new ToolProperties(serverAdamantiumUses.get(), (float) serverAdamantiumSpeedBonus.getAsDouble(),
                    (float) serverAdamantiumAttackBonus.getAsDouble(), serverAdamantiumToolEnchantabilty.get());
            onyxToolRecord = new ToolProperties(serverOnyxUses.get(), (float) serverOnyxSpeedBonus.getAsDouble(),
                    (float) serverOnyxAttackBonus.getAsDouble(), serverOnyxToolEnchantabilty.get());

        }
    } // end onLoad()


}  // end class SimpleOresConfig
