package mod.alexndr.simpleores.init;

import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SimpleOres.MODID);

    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_TIN =
            CONFIGURED_FEATURES.register("ore_tin", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.tin_ore.get(), ModBlocks.deepslate_tin_ore.get()),
                            SimpleOresConfig.tin_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_TIN2=
            CONFIGURED_FEATURES.register("ore_tin2", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.tin_ore.get(), ModBlocks.deepslate_tin_ore.get()),
                            SimpleOresConfig.tin_cfg2));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_MYTHRIL =
            CONFIGURED_FEATURES.register("ore_mythril", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.mythril_ore.get(), ModBlocks.deepslate_mythril_ore.get()),
                            SimpleOresConfig.mythril_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_MYTHRIL2 =
            CONFIGURED_FEATURES.register("ore_mythril2", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.mythril_ore.get(), ModBlocks.deepslate_mythril_ore.get()),
                            SimpleOresConfig.mythril_cfg2));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ADAMANTIUM =
            CONFIGURED_FEATURES.register("ore_adamantium", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.adamantium_ore.get(), ModBlocks.deepslate_adamantium_ore.get()),
                            SimpleOresConfig.adamantium_cfg));
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ADAMANTIUM2 =
            CONFIGURED_FEATURES.register("ore_adamantium2", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildStandardOreTargetList(ModBlocks.adamantium_ore.get(), ModBlocks.deepslate_adamantium_ore.get()),
                            SimpleOresConfig.adamantium_cfg2));
    
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ONYX =
            CONFIGURED_FEATURES.register("ore_onyx", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.onyx_ore.get(), true),
                            SimpleOresConfig.onyx_cfg));
                            
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_ONYX_ROCK = 
            CONFIGURED_FEATURES.register("ore_onyx_rock", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            OreGenUtils.BuildNetherOreTargetList(ModBlocks.onyx_ore.get(), false),
                            SimpleOresConfig.onyx_rock_cfg));


  
    /** PlacedFeature registry */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SimpleOres.MODID);
    
    public static RegistryObject<PlacedFeature> ORE_ONYX_ALL = PLACED_FEATURES.register("ore_onyx_all", 
                    ()-> OreGenUtils.createPlacedOreFeature(ORE_ONYX.getHolder().get(), SimpleOresConfig.onyx_cfg));
    public static RegistryObject<PlacedFeature> ORE_ONYX_IN_ROCK = PLACED_FEATURES.register("ore_onyx_in_rock", 
            ()-> OreGenUtils.createPlacedOreFeature(ORE_ONYX_ROCK.getHolder().get(), SimpleOresConfig.onyx_rock_cfg));

} // end class
