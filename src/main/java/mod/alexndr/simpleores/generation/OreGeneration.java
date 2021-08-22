package mod.alexndr.simpleores.generation;

import com.google.common.collect.ImmutableList;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(
				OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, 
						ModBlocks.tin_ore.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
						ModBlocks.deepslate_tin_ore.get().defaultBlockState()));

	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_MYTHRIL_TARGET_LIST = ImmutableList.of(
			OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, 
					ModBlocks.mythril_ore.get().defaultBlockState()),
			OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.deepslate_mythril_ore.get().defaultBlockState()));
	
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ADAMANTIUM_TARGET_LIST = ImmutableList.of(
			OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, 
					ModBlocks.adamantium_ore.get().defaultBlockState()),
			OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
					ModBlocks.deepslate_adamantium_ore.get().defaultBlockState()));
	
	
    public static ConfiguredFeature<?, ?> ORE_TIN;
    public static ConfiguredFeature<?, ?> ORE_MYTHRIL;
    public static ConfiguredFeature<?, ?> ORE_ADAMANTIUM;
    public static ConfiguredFeature<?, ?> ORE_ONYX;

    /**
     * initialize nether Features.
     * 
     * @param evt
     */
    public static void initNetherFeatures()
    {
        if (! SimpleOresConfig.enableOnyxOre) return;
        ORE_ONYX = OreGenUtils.buildNetherRockFeature(ModBlocks.onyx_ore.get().defaultBlockState(), SimpleOresConfig.onyx_cfg);
        
        OreGenUtils.registerFeature(SimpleOres.MODID, "onyx_vein", ORE_ONYX);
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
            ORE_TIN = OreGenUtils.buildOverworldOreFeature(ORE_TIN_TARGET_LIST, SimpleOresConfig.tin_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "tin_vein", ORE_TIN);
        }
        if (SimpleOresConfig.enableMythrilOre)
        {
            ORE_MYTHRIL = OreGenUtils.buildOverworldOreFeature(ORE_MYTHRIL_TARGET_LIST, SimpleOresConfig.mythril_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "mythril_vein", ORE_MYTHRIL);
        }
        if (SimpleOresConfig.enableAdamantiumOre)
        {
            ORE_ADAMANTIUM = OreGenUtils.buildOverworldOreFeature(ORE_ADAMANTIUM_TARGET_LIST, SimpleOresConfig.adamantium_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "adamantium_vein", ORE_ADAMANTIUM);
        }
    } // end-initOverworldFeatures()
    

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableOnyxOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ONYX);
        }
    } // end generateNetherOres()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableTinOre)
           evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN);
        if (SimpleOresConfig.enableMythrilOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_MYTHRIL);
        if (SimpleOresConfig.enableAdamantiumOre)
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ADAMANTIUM);
    } // end generateOverworldOres()
    

} // end class OreGeneration