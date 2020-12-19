package mod.alexndr.simpleores.generation;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModFeatures;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    public static ConfiguredFeature<?, ?> ORE_COPPER;
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
        ORE_ONYX = OreGenUtils.buildNetherOreFeature(
                                ModFeatures.ONYX_VEIN.get(), ModBlocks.onyx_ore.get().getDefaultState(),
                                SimpleOresConfig.onyx_cfg);
    } // end-initNetherFeatures()

    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    public static void initOverworldFeatures()
    {
        ORE_COPPER = OreGenUtils.buildOverworldOreFeature(ModFeatures.COPPER_VEIN.get(),
                ModBlocks.copper_ore.get().getDefaultState(), SimpleOresConfig.copper_cfg);
        ORE_TIN = OreGenUtils.buildOverworldOreFeature(ModFeatures.TIN_VEIN.get(),
                ModBlocks.tin_ore.get().getDefaultState(), SimpleOresConfig.tin_cfg);
        ORE_MYTHRIL = OreGenUtils.buildOverworldOreFeature(ModFeatures.MYTHRIL_VEIN.get(),
                ModBlocks.mythril_ore.get().getDefaultState(), SimpleOresConfig.mythril_cfg);
        ORE_ADAMANTIUM = OreGenUtils.buildOverworldOreFeature(ModFeatures.ADAMANTIUM_VEIN.get(),
                ModBlocks.adamantium_ore.get().getDefaultState(), SimpleOresConfig.adamantium_cfg);
    } // end-initOverworldFeatures()

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ONYX);
    } // end generateNetherOres()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_COPPER);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_MYTHRIL);
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ADAMANTIUM);
    } // end generateOverworldOres()
    

} // end class OreGeneration