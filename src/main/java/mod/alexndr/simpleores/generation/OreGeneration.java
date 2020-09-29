package mod.alexndr.simpleores.generation;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    protected static ConfiguredFeature<?, ?> ORE_COPPER;
    protected static ConfiguredFeature<?, ?> ORE_TIN;
    protected static ConfiguredFeature<?, ?> ORE_MYTHRIL;
    protected static ConfiguredFeature<?, ?> ORE_ADAMANTIUM;
    protected static ConfiguredFeature<?, ?> ORE_ONYX;

    /**
     * Do we care about this biome? Yes, if overworld or nether, no if THEEND. Also
     * init relevant Features, if they are null.
     */
    public static boolean checkAndInitBiome(BiomeLoadingEvent evt)
    {
        if (evt.getCategory() == Biome.Category.NETHER)
        {
            initNetherFeatures();
            return true;
        }
        else if (evt.getCategory() != Biome.Category.THEEND)
        {
            initOverworldFeatures();
            return true;
        }
        return false;
    } // end checkBiome

    /**
     * initialize nether Features.
     * 
     * @param evt
     */
    protected static void initNetherFeatures()
    {
        if (ORE_ONYX != null) return;
        
        ORE_ONYX = OreGenUtils.buildNetherOreFeature(ModBlocks.onyx_ore.get().getDefaultState(),
                SimpleOresConfig.onyx_cfg);
    } // end-initNetherFeatures()

    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    protected static void initOverworldFeatures()
    {
        if (ORE_COPPER == null)
        {
            ORE_COPPER = OreGenUtils.buildOverworldOreFeature(
                    ModBlocks.copper_ore.get().getDefaultState(), SimpleOresConfig.copper_cfg); 
        }
        
        if (ORE_TIN == null)
        {
            ORE_TIN = OreGenUtils.buildOverworldOreFeature(
                    ModBlocks.tin_ore.get().getDefaultState(), SimpleOresConfig.tin_cfg); 
        }
        
        if (ORE_MYTHRIL == null)
        {
            ORE_MYTHRIL = OreGenUtils.buildOverworldOreFeature(
                    ModBlocks.mythril_ore.get().getDefaultState(), SimpleOresConfig.mythril_cfg); 
        }
       
        if (ORE_ADAMANTIUM == null)
        {
            ORE_ADAMANTIUM = OreGenUtils.buildOverworldOreFeature(
                    ModBlocks.adamantium_ore.get().getDefaultState(), SimpleOresConfig.adamantium_cfg); 
        }
    } // end-initOverworldFeatures()

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ONYX);
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