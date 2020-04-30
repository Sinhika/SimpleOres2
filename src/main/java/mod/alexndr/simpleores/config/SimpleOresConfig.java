package mod.alexndr.simpleores.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simpleores.api.config.ISimpleConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;

public class SimpleOresConfig implements ISimpleConfig
{
    private static Map<String, Boolean> flags = new HashMap<>();
    
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
    
    public static SimpleOresConfig INSTANCE = new SimpleOresConfig();
    
    @Override
    public boolean getFlag(String n)
    {
        Boolean obj = flags.get(n);
        return obj != null && obj;
    }

    @Override
    public void clear() {
        flags.clear();
    }

    @Override
    public void putFlag(String n, boolean val)
    {
        flags.put(n, val);
    }

}  // end class SimpleOresConfig
