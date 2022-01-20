package mod.alexndr.simpleores.generation;

import java.util.List;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
	public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = 
			OreGenUtils.BuildStandardOreTargetList(ModBlocks.tin_ore.get(), ModBlocks.deepslate_tin_ore.get());
			
	public static final List<OreConfiguration.TargetBlockState> ORE_MYTHRIL_TARGET_LIST = 
			OreGenUtils.BuildStandardOreTargetList(ModBlocks.mythril_ore.get(), ModBlocks.deepslate_mythril_ore.get());
	
	public static final List<OreConfiguration.TargetBlockState> ORE_ADAMANTIUM_TARGET_LIST = 
			OreGenUtils.BuildStandardOreTargetList(ModBlocks.adamantium_ore.get(), ModBlocks.deepslate_adamantium_ore.get());

	public static final List<OreConfiguration.TargetBlockState> ORE_ONYX_NETHERRACK_TARGET = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.onyx_ore.get(), true);
	public static final List<OreConfiguration.TargetBlockState> ORE_ONYX_ROCK_TARGET = 
			OreGenUtils.BuildNetherOreTargetList(ModBlocks.onyx_ore.get(), false);
	
    public static ConfiguredFeature<OreConfiguration, ?> ORE_TIN;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_TIN2;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_MYTHRIL;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_MYTHRIL2;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ADAMANTIUM;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ADAMANTIUM2;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ONYX;
    public static ConfiguredFeature<OreConfiguration, ?> ORE_ONYX_ROCK;

    public static PlacedFeature ORE_ONYX_ALL;
    public static PlacedFeature ORE_ONYX_IN_ROCK;
    public static PlacedFeature ORE_TIN_PLACER;
    public static PlacedFeature ORE_TIN_INTRUSION;
    public static PlacedFeature ORE_MYTHRIL_DEPOSIT;
    public static PlacedFeature ORE_MYTHRIL_INTRUSION;
    public static PlacedFeature ORE_ADAMANTIUM_DEPOSIT;
    public static PlacedFeature ORE_ADAMANTIUM_INTRUSION;
    
    
    /**
     * initialize nether Features.
     * 
     * @param evt
     */
    public static void initNetherFeatures()
    {
        if (! SimpleOresConfig.enableOnyxOre) return;
        
        ORE_ONYX = FeatureUtils.register("ore_onyx", 
        		OreGenUtils.ConfigureOreFeature(ORE_ONYX_NETHERRACK_TARGET, SimpleOresConfig.onyx_cfg.getVein_size(), 0.0F ));
        ORE_ONYX_ROCK = FeatureUtils.register("ore_onyx_rock", 
        		OreGenUtils.ConfigureOreFeature(ORE_ONYX_ROCK_TARGET, SimpleOresConfig.onyx_rock_cfg.getVein_size(), 0.0F ));
        		
        ORE_ONYX_ALL = PlacementUtils.register("ore_onyx_all", 
        		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.onyx_cfg, ORE_ONYX));
        ORE_ONYX_IN_ROCK = PlacementUtils.register("ore_onyx_in_rock", 
        		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.onyx_rock_cfg, ORE_ONYX_ROCK));
    } // end-initNetherFeatures()

    
    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    public static void initOverworldFeatures()
    {

         if (SimpleOresConfig.enableTinOre)
        {
            ORE_TIN = FeatureUtils.register("ore_tin", 
            		OreGenUtils.ConfigureOreFeature(ORE_TIN_TARGET_LIST, SimpleOresConfig.tin_cfg.getVein_size(), 0.0F));
            ORE_TIN2 = FeatureUtils.register("ore_tin2", 
            		OreGenUtils.ConfigureOreFeature(ORE_TIN_TARGET_LIST, SimpleOresConfig.tin_cfg2.getVein_size(), 0.0F));
            ORE_TIN_PLACER = PlacementUtils.register("ore_tin_placer", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.tin_cfg, ORE_TIN));
            ORE_TIN_INTRUSION = PlacementUtils.register("ore_tin_intrusion", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.tin_cfg2, ORE_TIN2));
        }
        if (SimpleOresConfig.enableMythrilOre)
        {
            ORE_MYTHRIL = FeatureUtils.register("ore_mythril", 
            		OreGenUtils.ConfigureOreFeature(ORE_MYTHRIL_TARGET_LIST, SimpleOresConfig.mythril_cfg.getVein_size(), 0.0F));
            ORE_MYTHRIL2 = FeatureUtils.register("ore_mythril2", 
            		OreGenUtils.ConfigureOreFeature(ORE_MYTHRIL_TARGET_LIST, SimpleOresConfig.mythril_cfg2.getVein_size(), 0.0F));
            ORE_MYTHRIL_DEPOSIT = PlacementUtils.register("ore_mythril_deposit", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.mythril_cfg, ORE_MYTHRIL));
            ORE_MYTHRIL_INTRUSION = PlacementUtils.register("ore_mythril_intrusion", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.mythril_cfg2, ORE_MYTHRIL2));
        }
        if (SimpleOresConfig.enableAdamantiumOre)
        {
            ORE_ADAMANTIUM = FeatureUtils.register("ore_adamantium", 
            		OreGenUtils.ConfigureOreFeature(ORE_ADAMANTIUM_TARGET_LIST, 
            										SimpleOresConfig.adamantium_cfg.getVein_size(), 0.5F));
			ORE_ADAMANTIUM2 = FeatureUtils.register("ore_adamantium2", 
					OreGenUtils.ConfigureOreFeature(ORE_ADAMANTIUM_TARGET_LIST, 
													SimpleOresConfig.adamantium_cfg2.getVein_size(), 0.0F));
            ORE_ADAMANTIUM_DEPOSIT = PlacementUtils.register("ore_adamantium_deposit", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.adamantium_cfg, ORE_ADAMANTIUM));
            ORE_ADAMANTIUM_INTRUSION = PlacementUtils.register("ore_adamantium_intrusion", 
            		OreGenUtils.ConfigurePlacedFeature(SimpleOresConfig.adamantium_cfg2, ORE_ADAMANTIUM2));
        }
    } // end-initOverworldFeatures()
    

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableOnyxOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ONYX_ALL);
        }
    } // end generateNetherOres()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableTinOre) {
           evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN_PLACER);
           evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN_INTRUSION);
        }
        if (SimpleOresConfig.enableMythrilOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_MYTHRIL_DEPOSIT);
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_MYTHRIL_INTRUSION);
        }
        if (SimpleOresConfig.enableAdamantiumOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ADAMANTIUM_DEPOSIT);
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ADAMANTIUM_INTRUSION);
        }
    } // end generateOverworldOres()
    

} // end class OreGeneration