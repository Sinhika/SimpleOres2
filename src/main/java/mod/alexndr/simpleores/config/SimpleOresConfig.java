package mod.alexndr.simpleores.config;

import java.util.HashMap;
import java.util.Map;

import mod.alexndr.simplecorelib.config.ISimpleConfig;
import mod.alexndr.simplecorelib.config.ModOreConfig;

public class SimpleOresConfig implements ISimpleConfig
{
    private static Map<String, Boolean> flags = new HashMap<>();
    
    public static boolean enableCopperOre;
    public static boolean enableTinOre;
    public static boolean enableMythrilOre;
    public static boolean enableAdamantiumOre;
    public static boolean enableOnyxOre;
    public static boolean addModLootToChests;
    
    //  MinHeight, MaxHeightBase, MaxHeight
    public static ModOreConfig copper_cfg;
    public static ModOreConfig tin_cfg;
    public static ModOreConfig mythril_cfg;
    public static ModOreConfig adamantium_cfg;
    public static ModOreConfig onyx_cfg;
    
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
