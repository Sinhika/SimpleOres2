package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import mod.alexndr.simpleores.SimpleOres;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = SimpleOres.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SimpleOresClientConfig extends SimpleConfig
{
    // public static SimpleOresConfig INSTANCE = new SimpleOresConfig();
    private static final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue clientMythrilBowZoomFactor;
    private static final ModConfigSpec.DoubleValue clientOnyxBowZoomFactor;

    static {
        builder.push("Zooms");
        clientMythrilBowZoomFactor = builder.comment("scaled zoom when drawing mythril bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.mythril_bow_zoom_factor")
                .defineInRange("MythrilBowZoomFactor", 0.2D, 0D, 1.0D);
        clientOnyxBowZoomFactor = builder.comment("scaled zoom when drawing onyx bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.onyx_bow_zoom_factor")
                .defineInRange("OnyxBowZoomFactor", 0.3D, 0D, 1.0D);
        builder.pop();

    } // end-static block

    public static final ModConfigSpec SPEC = builder.build();

    public static float mythrilBowZoom;
    public static float onyxBowZoom;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        // client stuff
        mythrilBowZoom = clientMythrilBowZoomFactor.get().floatValue();
        onyxBowZoom = clientOnyxBowZoomFactor.get().floatValue();
    }
}  // end class SimpleOresConfig
