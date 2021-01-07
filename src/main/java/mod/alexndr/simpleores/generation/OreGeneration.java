package mod.alexndr.simpleores.generation;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
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
        if (! SimpleOresConfig.enableOnyxOre) return;
        ORE_ONYX = OreGenUtils.buildNetherOreFeature(
                Feature.ORE, ModBlocks.onyx_ore.get().getDefaultState(),
                                SimpleOresConfig.onyx_cfg);
        OreGenUtils.registerFeature(SimpleOres.MODID, "onyx_vein", ORE_ONYX);
    } // end-initNetherFeatures()

    
    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    public static void initOverworldFeatures()
    {
        if (SimpleOresConfig.enableCopperOre) {
            ORE_COPPER = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                    ModBlocks.copper_ore.get().getDefaultState(), SimpleOresConfig.copper_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "copper_vein", ORE_COPPER);
        }
        if (SimpleOresConfig.enableTinOre)
        {
            ORE_TIN = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                    ModBlocks.tin_ore.get().getDefaultState(), SimpleOresConfig.tin_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "tin_vein", ORE_TIN);
        }
        if (SimpleOresConfig.enableMythrilOre)
        {
            ORE_MYTHRIL = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                    ModBlocks.mythril_ore.get().getDefaultState(), SimpleOresConfig.mythril_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "mythril_vein", ORE_MYTHRIL);
        }
        if (SimpleOresConfig.enableAdamantiumOre)
        {
            ORE_ADAMANTIUM = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                    ModBlocks.adamantium_ore.get().getDefaultState(), SimpleOresConfig.adamantium_cfg);
            OreGenUtils.registerFeature(SimpleOres.MODID, "adamantium_vein", ORE_ADAMANTIUM);
        }
    } // end-initOverworldFeatures()
    

    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableOnyxOre) 
            evt.getGeneration().withFeature(Decoration.UNDERGROUND_DECORATION, OreGeneration.ORE_ONYX);
    } // end generateNetherOres()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableCopperOre)
            evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_COPPER);
        if (SimpleOresConfig.enableTinOre)
           evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN);
        if (SimpleOresConfig.enableMythrilOre)
            evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_MYTHRIL);
        if (SimpleOresConfig.enableAdamantiumOre)
            evt.getGeneration().withFeature(Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ADAMANTIUM);
    } // end generateOverworldOres()
    

} // end class OreGeneration