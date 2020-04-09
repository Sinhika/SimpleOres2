package mod.alexndr.simpleores.config;

import net.minecraft.world.gen.placement.CountRangeConfig;

public class SimpleOresConfig
{
    public static boolean enableCopperOre = true;
    public static boolean enableTinOre = true;
    public static boolean enableMythrilOre = true;
    public static boolean enableAdamantiumOre = true;
    public static boolean enableOnyxOre = true;

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    public static  CountRangeConfig copper_cfg = new CountRangeConfig(15, 40, 0, 128);
    public static  int copper_veinsize = 7;
    public static  CountRangeConfig tin_cfg = new CountRangeConfig(10, 20, 0, 70);
    public static  int tin_veinsize = 7;
    public static  CountRangeConfig mythril_cfg = new CountRangeConfig(4, 1, 0, 35);
    public static  int mythril_veinsize = 4;
    public static  CountRangeConfig adamantium_cfg = new CountRangeConfig(4, 1, 0, 20);
    public static  int adamantium_veinsize = 4;
    public static  CountRangeConfig onyx_cfg = new CountRangeConfig(5, 0, 0, 128);
    public static  int onyx_veinsize = 7;

}  // end class SimpleOresConfig
