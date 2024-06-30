package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.SimpleCoreLib;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import mod.alexndr.simpleores.SimpleOres;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = SimpleOres.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SimpleOresConfig extends SimpleConfig
{
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

    private final static ModConfigSpec.BooleanValue serverAddModLootToChests;
    public static final ModConfigSpec.IntValue serverCopperBucketMeltTemperature;
    public static final ModConfigSpec.IntValue serverCopperBucketFireTemperature;
    public static final ModConfigSpec.BooleanValue serverEnableCopperBucketMilking;

    public static final ModConfigSpec.IntValue serverCopperArmorDurability;
    public static final ModConfigSpec.IntValue serverTinArmorDurability;
    public static final ModConfigSpec.IntValue serverMythrilArmorDurability;
    public static final ModConfigSpec.IntValue serverAdamantiumArmorDurability;
    public static final ModConfigSpec.IntValue serverOnyxArmorDurability;

    static {
        // general
        builder.push("General");
        serverAddModLootToChests = builder.comment("Add SimpleOres items to chest loot?")
                .translation(SimpleOres.MODID + ".config.addModLootToChests")
                .define("AddModLootToChests", true);
        builder.pop();
        builder.push("Buckets");
        serverEnableCopperBucketMilking = builder.comment("false disables milking cows with copper buckets")
                .translation(SimpleOres.MODID + ".config.enableCopperBucketMilking")
                .define("EnableCopperBucketMilking", true);
        serverCopperBucketMeltTemperature = builder.comment("liquids at temperature C or higher melt copper buckets")
                .translation(SimpleOres.MODID + ".config.copperBucketMeltTemperature")
                .defineInRange("CopperBucketMeltTemperature", 1000, -200, 5000);
        serverCopperBucketFireTemperature = builder.comment(
                        "Copper is a good heat conductor. Liquids at this temp or higher set you on fire. Leave at 9999 to disable")
                .translation(SimpleOres.MODID + ".config.copperBucketFireTemperature")
                .defineInRange("CopperBucketSetYouOnFireTemperature", 9999, 300, 9999);
        builder.pop();
        builder.push("Armor");
        serverCopperArmorDurability = builder.comment("Base durability for copper armor")
                .translation(SimpleOres.MODID + ".config.copperArmorDurability")
                .defineInRange("copperArmorDurability", 8, 1, 99);
        serverTinArmorDurability = builder.comment("Base durability for tin armor")
                .translation(SimpleOres.MODID + ".config.tinArmorDurability")
                .defineInRange("tinArmorDurability", 9, 1, 99);
        serverMythrilArmorDurability = builder.comment("Base durability for mythril armor")
                .translation(SimpleOres.MODID + ".config.mythrilArmorDurability")
                .defineInRange("mythrilArmorDurability", 22, 1, 99);
        serverAdamantiumArmorDurability = builder.comment("Base durability for adamantium armor")
                .translation(SimpleOres.MODID + ".config.adamantiumArmorDurability")
                .defineInRange("adamantiumArmorDurability", 28, 1, 99);
        serverOnyxArmorDurability = builder.comment("Base durability for onyx armor")
                .translation(SimpleOres.MODID + ".config.onyxArmorDurability")
                .defineInRange("onyxArmorDurability", 45, 1, 99);

        builder.pop();
    } // end-static block

    public static final ModConfigSpec SPEC = builder.build();
    // public static SimpleOresConfig INSTANCE = new SimpleOresConfig();

    public static boolean addModLootToChests;
    public static boolean enableCopperBucketMilking;
    public static int copperBucketMeltTemperature;
    public static int copperBucketFireTemperature;

    // armor
    public static int copperArmorDurability;
    public static int tinArmorDurability;
    public static int mythrilArmorDurability;
    public static int adamantiumArmorDurability;
    public static int onyxArmorDurability;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        // common/server stuff
        addModLootToChests = serverAddModLootToChests.getAsBoolean();
        enableCopperBucketMilking = serverEnableCopperBucketMilking.getAsBoolean();
        copperBucketMeltTemperature = serverCopperBucketMeltTemperature.getAsInt();
        copperBucketFireTemperature = serverCopperBucketFireTemperature.getAsInt();

        copperArmorDurability = serverCopperArmorDurability.getAsInt();
        tinArmorDurability = serverTinArmorDurability.getAsInt();
        mythrilArmorDurability = serverMythrilArmorDurability.getAsInt();
        adamantiumArmorDurability = serverAdamantiumArmorDurability.getAsInt();
        onyxArmorDurability = serverOnyxArmorDurability.getAsInt();
    } // end onLoad()


}  // end class SimpleOresConfig
