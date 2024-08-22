package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import mod.alexndr.simpleores.SimpleOres;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class SimpleOresConfig extends SimpleConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private final static ModConfigSpec.BooleanValue serverAddModLootToChests;
    public static final ModConfigSpec.IntValue serverCopperBucketMeltTemperature;
    public static final ModConfigSpec.IntValue serverCopperBucketFireTemperature;
    public static final ModConfigSpec.BooleanValue serverEnableCopperBucketMilking;

    private static final ModConfigSpec.IntValue serverCopperArmorDurability;
    private static final ModConfigSpec.IntValue serverTinArmorDurability;
    private static final ModConfigSpec.IntValue serverMythrilArmorDurability;
    private static final ModConfigSpec.IntValue serverAdamantiumArmorDurability;
    private static final ModConfigSpec.IntValue serverOnyxArmorDurability;

    static {
        // general
        BUILDER.push("General");
        serverAddModLootToChests = BUILDER.comment("Add SimpleOres items to chest loot?")
                .translation(SimpleOres.MODID + ".config.addModLootToChests")
                .define("AddModLootToChests", true);
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
        serverCopperArmorDurability = BUILDER.comment("Base durability for copper armor")
                .translation(SimpleOres.MODID + ".config.copperArmorDurability")
                .defineInRange("copperArmorDurability", 8, 1, 99);
        serverTinArmorDurability = BUILDER.comment("Base durability for tin armor")
                .translation(SimpleOres.MODID + ".config.tinArmorDurability")
                .defineInRange("tinArmorDurability", 9, 1, 99);
        serverMythrilArmorDurability = BUILDER.comment("Base durability for mythril armor")
                .translation(SimpleOres.MODID + ".config.mythrilArmorDurability")
                .defineInRange("mythrilArmorDurability", 22, 1, 99);
        serverAdamantiumArmorDurability = BUILDER.comment("Base durability for adamantium armor")
                .translation(SimpleOres.MODID + ".config.adamantiumArmorDurability")
                .defineInRange("adamantiumArmorDurability", 28, 1, 99);
        serverOnyxArmorDurability = BUILDER.comment("Base durability for onyx armor")
                .translation(SimpleOres.MODID + ".config.onyxArmorDurability")
                .defineInRange("onyxArmorDurability", 45, 1, 99);

        BUILDER.pop();
    } // end-static block

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean addModLootToChests = true;
    public static boolean enableCopperBucketMilking = true;
    public static int copperBucketMeltTemperature = 1000;
    public static int copperBucketFireTemperature = 9999;

    // armor
    public static int copperArmorDurability = 8;
    public static int tinArmorDurability = 9;
    public static int mythrilArmorDurability = 22;
    public static int adamantiumArmorDurability = 28;
    public static int onyxArmorDurability = 45;

    public static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.STARTUP)
        {
            // common/server stuff
            addModLootToChests = serverAddModLootToChests.get();
            enableCopperBucketMilking = serverEnableCopperBucketMilking.get();
            copperBucketMeltTemperature = serverCopperBucketMeltTemperature.get();
            copperBucketFireTemperature = serverCopperBucketFireTemperature.get();

            copperArmorDurability = serverCopperArmorDurability.get();
            tinArmorDurability = serverTinArmorDurability.get();
            mythrilArmorDurability = serverMythrilArmorDurability.get();
            adamantiumArmorDurability = serverAdamantiumArmorDurability.get();
            onyxArmorDurability = serverOnyxArmorDurability.get();
        }
    } // end onLoad()


}  // end class SimpleOresConfig
