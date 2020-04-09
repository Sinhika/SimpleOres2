package mod.alexndr.simpleores.config;

import net.minecraft.world.gen.placement.CountRangeConfig;

public class SimpleOresConfig
{
    public static boolean enableCopperOre;
    public static boolean enableTinOre;
    public static boolean enableMythrilOre;
    public static boolean enableAdamantiumOre;
    public static boolean enableOnyxOre;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static  CountRangeConfig copper_cfg;
    public static  int copper_veinsize = 7;
    public static  CountRangeConfig tin_cfg;
    public static  int tin_veinsize = 7;
    public static  CountRangeConfig mythril_cfg;
    public static  int mythril_veinsize = 4;
    public static  CountRangeConfig adamantium_cfg;
    public static  int adamantium_veinsize = 4;
    public static  CountRangeConfig onyx_cfg;
    public static  int onyx_veinsize = 7;

}  // end class SimpleOresConfig
