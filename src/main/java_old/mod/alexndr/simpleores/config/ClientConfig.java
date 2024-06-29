package mod.alexndr.simpleores.config;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ClientConfig
{
    final ForgeConfigSpec.DoubleValue clientMythrilBowZoomFactor;
    final ForgeConfigSpec.DoubleValue clientOnyxBowZoomFactor;

    ClientConfig(final ForgeConfigSpec.Builder builder) 
    {
        builder.push("General");
        clientMythrilBowZoomFactor = builder.comment("scaled zoom when drawing mythril bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.mythril_bow_zoom_factor")
                .defineInRange("MythrilBowZoomFactor", 0.2D, 0D, 1.0D);
        clientOnyxBowZoomFactor = builder.comment("scaled zoom when drawing onyx bow (vanilla=0.165)")
                .translation(SimpleOres.MODID + ".config.onyx_bow_zoom_factor")
                .defineInRange("OnyxBowZoomFactor", 0.3D, 0D, 1.0D);

        builder.pop();
    }
} // end-class

