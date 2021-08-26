package mod.alexndr.simpleores.config;

import mod.alexndr.simplecorelib.config.ModOreConfig;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo It can be merged into the main ExampleModConfig class, but is
 *         separate because of personal preference and to keep the code
 *         organised
 */
public final class ConfigHelper
{
//      public static void bakeClient(final ModConfig config) { }

    public static void bakeServer(final ModConfig config)
    {
        SimpleOresConfig.addModLootToChests = ConfigHolder.SERVER.serverAddModLootToChests.get();

        SimpleOresConfig.enableTinOre = ConfigHolder.SERVER.serverEnableTinOre.get();
        SimpleOresConfig.tin_cfg = new ModOreConfig(ModOreConfig.TRIANGLE, ConfigHolder.SERVER.serverTinVeinSize.get(),
        		ConfigHolder.SERVER.serverTinVeinCount.get(), 
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverTinBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverTinMaxHeight.get()));

        SimpleOresConfig.enableMythrilOre = ConfigHolder.SERVER.serverEnableMythrilOre.get();
        SimpleOresConfig.mythril_cfg = new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverMythrilVeinSize.get(),
        		ConfigHolder.SERVER.serverMythrilVeinCount.get(), 
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverMythrilBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverMythrilMaxHeight.get()));

        SimpleOresConfig.enableAdamantiumOre = ConfigHolder.SERVER.serverEnableAdamantiumOre.get();
        SimpleOresConfig.adamantium_cfg = new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverAdamantiumVeinSize.get(),
        		ConfigHolder.SERVER.serverAdamantiumVeinCount.get(), 
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverAdamantiumBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverAdamantiumMaxHeight.get()));
        
        SimpleOresConfig.enableOnyxOre = ConfigHolder.SERVER.serverEnableOnyxOre.get();
        SimpleOresConfig.onyx_cfg = new ModOreConfig(ModOreConfig.FULL_RANGE, ConfigHolder.SERVER.serverOnyxVeinSize.get(),
        		ConfigHolder.SERVER.serverOnyxVeinCount.get(),VerticalAnchor.bottom(), VerticalAnchor.top());
        SimpleOresConfig.onyx_rock_cfg = new ModOreConfig(ModOreConfig.UNIFORM, ConfigHolder.SERVER.serverOnyxVeinSize.get(),
        		ConfigHolder.SERVER.serverOnyxVeinCount.get(), 
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverOnyxBottomHeight.get()),
        		VerticalAnchor.absolute(ConfigHolder.SERVER.serverOnyxMaxHeight.get()));
        		
        // recipe flags
        SimpleOresConfig.INSTANCE.putFlag("aesthetics_enabled", ConfigHolder.SERVER.serverEnableAesthetics.get());
        SimpleOresConfig.INSTANCE.putFlag("copper_tools", ConfigHolder.SERVER.serverEnableCopperTools.get());
        SimpleOresConfig.INSTANCE.putFlag("tin_tools", ConfigHolder.SERVER.serverEnableTinTools.get());
        SimpleOresConfig.INSTANCE.putFlag("mythril_tools", ConfigHolder.SERVER.serverEnableMythrilTools.get());
        SimpleOresConfig.INSTANCE.putFlag("adamantium_tools", ConfigHolder.SERVER.serverEnableAdamantiumTools.get());
        SimpleOresConfig.INSTANCE.putFlag("onyx_tools", ConfigHolder.SERVER.serverEnableOnyxTools.get());

        SimpleOresConfig.INSTANCE.putFlag("copper_bucket", ConfigHolder.SERVER.serverEnableCopperBucket.get());
        SimpleOresConfig.INSTANCE.putFlag("mod_bows", ConfigHolder.SERVER.serverEnableModBows.get());

        SimpleOresConfig.INSTANCE.putFlag("copper_armor", ConfigHolder.SERVER.serverEnableCopperArmor.get());
        SimpleOresConfig.INSTANCE.putFlag("tin_armor", ConfigHolder.SERVER.serverEnableTinArmor.get());
        SimpleOresConfig.INSTANCE.putFlag("mythril_armor", ConfigHolder.SERVER.serverEnableMythrilArmor.get());
        SimpleOresConfig.INSTANCE.putFlag("adamantium_armor", ConfigHolder.SERVER.serverEnableAdamantiumArmor.get());
        SimpleOresConfig.INSTANCE.putFlag("onyx_armor", ConfigHolder.SERVER.serverEnableOnyxArmor.get());

    } // end bakeServer()

    @SuppressWarnings("unused")
    private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
    {
        modConfig.getConfigData().set(path, newValue);
        modConfig.save();
    } // end setValueAndSave()

    public static void bakeClient(final ModConfig config)
    {
    } // end bakeClient

} // end class ConfigHelper
