package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;

public class SimpleOresConfig extends SimpleConfig
{
    public static SimpleOresConfig INSTANCE = new SimpleOresConfig();

    //public static boolean enableCopperOre;
    public static boolean enableTinOre;
    public static boolean enableMythrilOre;
    public static boolean enableAdamantiumOre;
    public static boolean enableOnyxOre;
    public static boolean addModLootToChests;
    
    public static float mythrilBowZoom;
    public static float onyxBowZoom;
    
//    public static Lazy<ModOreConfig> tin_cfg = Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.TRIANGLE, ConfigHolder.SERVER.serverTinVeinSize.get(),
//            ConfigHolder.SERVER.serverTinVeinCount.get(), true, 
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverTinBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverTinMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> tin_cfg2= Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverTinVeinSize.get(),
//                    ConfigHolder.SERVER.serverTinVeinCount.get()/2, true, 
//                    VerticalAnchor.absolute(0), VerticalAnchor.absolute(72)));
//    
    // public static Lazy<ModOreConfig> tin_vein = Lazy.of(
    // ()->new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverTinVeinSize.get(),
        //  ConfigHolder.SERVER.serverTinVeinCount.get()/2, true, 
        //  VerticalAnchor.absolute(-40), VerticalAnchor.absolute(0)));
    // not used yet.

//    public static Lazy<ModOreConfig> mythril_cfg = Lazy.of( 
//            ()->new ModOreConfig(ModOreConfig.TRIANGLE, ConfigHolder.SERVER.serverMythrilVeinSize.get(),
//            ConfigHolder.SERVER.serverMythrilVeinCount.get(), true, 
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverMythrilBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverMythrilMaxHeight.get())));
//            
//    public static Lazy<ModOreConfig> mythril_cfg2 = Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverMythrilVeinSize.get(),
//            ConfigHolder.SERVER.serverMythrilVeinCount.get()/2, true, 
//            VerticalAnchor.bottom(), VerticalAnchor.absolute(35)));
//    
//    public static Lazy<ModOreConfig> adamantium_cfg = Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.TRIANGLE, 
//            ConfigHolder.SERVER.serverAdamantiumVeinSize.get(),
//            ConfigHolder.SERVER.serverAdamantiumVeinCount.get(), true, 
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverAdamantiumBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverAdamantiumMaxHeight.get())));
//    
//    public static Lazy<ModOreConfig> adamantium_cfg2 = Lazy.of(
//            ()-> new ModOreConfig(ModOreConfig.UNIFORM, 
//            ConfigHolder.SERVER.serverAdamantiumVeinSize.get(),
//            ConfigHolder.SERVER.serverAdamantiumVeinCount.get(), true, 
//            VerticalAnchor.bottom(), VerticalAnchor.absolute(20)));
//    
//    public static Lazy<ModOreConfig> onyx_cfg = Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.FULL_RANGE, ConfigHolder.SERVER.serverOnyxVeinSize.get(),
//            ConfigHolder.SERVER.serverOnyxVeinCount.get(), true, VerticalAnchor.bottom(), VerticalAnchor.top()));
//    
//    public static Lazy<ModOreConfig> onyx_rock_cfg = Lazy.of(
//            ()->new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverOnyxVeinSize.get(),
//            ConfigHolder.SERVER.serverOnyxVeinCount.get(), true,
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverOnyxBottomHeight.get()),
//            VerticalAnchor.absolute(ConfigHolder.SERVER.serverOnyxMaxHeight.get())));
    
}  // end class SimpleOresConfig
