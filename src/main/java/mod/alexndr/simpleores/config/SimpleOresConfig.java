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
    // public static SimpleOresConfig INSTANCE = new SimpleOresConfig();
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

    private final static ModConfigSpec.BooleanValue serverAddModLootToChests;
    private static final ModConfigSpec.IntValue serverCopperBucketMeltTemperature;
    private static final ModConfigSpec.IntValue serverCopperBucketFireTemperature;
    private static final ModConfigSpec.BooleanValue serverEnableCopperBucketMilking;

    private static final ModConfigSpec.DoubleValue clientMythrilBowZoomFactor;
    private static final ModConfigSpec.DoubleValue clientOnyxBowZoomFactor;

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

        builder.push("Client");
        clientMythrilBowZoomFactor = builder.comment("scaled zoom when drawing mythril bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.mythril_bow_zoom_factor")
                .defineInRange("MythrilBowZoomFactor", 0.2D, 0D, 1.0D);
        clientOnyxBowZoomFactor = builder.comment("scaled zoom when drawing onyx bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.onyx_bow_zoom_factor")
                .defineInRange("OnyxBowZoomFactor", 0.3D, 0D, 1.0D);
        builder.pop();

    } // end-static block

    public static final ModConfigSpec SPEC = builder.build();

    public static boolean addModLootToChests;
    public static boolean enableCopperBucketMilking;
    public static int copperBucketMeltTemperature;
    public static int copperBucketFireTemperature;

    public static float mythrilBowZoom;
    public static float onyxBowZoom;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        // common/server stuff
        addModLootToChests = serverAddModLootToChests.getAsBoolean();
        enableCopperBucketMilking = serverEnableCopperBucketMilking.getAsBoolean();
        copperBucketMeltTemperature = serverCopperBucketMeltTemperature.getAsInt();
        copperBucketFireTemperature = serverCopperBucketFireTemperature.getAsInt();

        // client stuff
        mythrilBowZoom = clientMythrilBowZoomFactor.get().floatValue();
        onyxBowZoom = clientOnyxBowZoomFactor.get().floatValue();
    }
}  // end class SimpleOresConfig
