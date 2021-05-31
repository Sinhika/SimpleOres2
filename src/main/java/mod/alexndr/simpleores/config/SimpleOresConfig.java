package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import mod.alexndr.simplecorelib.config.SimpleConfig;

public class SimpleOresConfig extends SimpleConfig
{
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

}  // end class SimpleOresConfig
