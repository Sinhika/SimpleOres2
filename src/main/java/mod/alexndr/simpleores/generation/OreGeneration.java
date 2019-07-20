package mod.alexndr.simpleores.generation;

import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig copper_cfg = new CountRangeConfig(15, 40, 0, 128);
    private static final int copper_veinsize = 7;
    private static final CountRangeConfig tin_cfg = new CountRangeConfig(10, 20, 0, 70);
    private static final int tin_veinsize = 7;
    private static final CountRangeConfig mythril_cfg = new CountRangeConfig(4, 1, 0, 35);
    private static final int mythril_veinsize = 4;
    private static final CountRangeConfig adamantium_cfg = new CountRangeConfig(4, 1, 0, 20);
    private static final int adamantium_veinsize = 4;
    private static final CountRangeConfig onyx_cfg = new CountRangeConfig(7, 10, 0, 128);
    private static final int onyx_veinsize = 7;

    /**
     * called in setup to generate overworld ores; should respect config
     * entries.
     */
    public static void setupOreGen()
    {
        for (Biome biome: ForgeRegistries.BIOMES.getValues())
        {
            // we have no End ores, so skip those.
            if (  biome.getCategory() == Biome.Category.THEEND)
            {
                continue;
            }
            // Nether Ore generation.
            if ( biome.getCategory() == Biome.Category.NETHER )
            {
                if (SimpleOresConfig.enableOnyxOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                            OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                            ModBlocks.onyx_ore.getDefaultState(),
                                                            onyx_veinsize),
                                                     Placement.COUNT_RANGE, onyx_cfg));
                }

                // skip overworld generation, obviously.
                continue;
            } // end-if biome Category.NETHER

            // Overworld-type Ore generation
            if (SimpleOresConfig.enableCopperOre)
            {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                             OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                             ModBlocks.copper_ore
                                                                     .getDefaultState(),
                                                             copper_veinsize),
                                                     Placement.COUNT_RANGE,
                                                     copper_cfg));
            } // end if copper_ore
            if (SimpleOresConfig.enableAdamantiumOre)
            {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                             OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                             ModBlocks.adamantium_ore
                                                                     .getDefaultState(),
                                                             adamantium_veinsize),
                                                     Placement.COUNT_RANGE,
                                                     adamantium_cfg));
            } // end if adamantium ore
            if (SimpleOresConfig.enableMythrilOre)
            {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                             OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                             ModBlocks.mythril_ore
                                                                     .getDefaultState(),
                                                             mythril_veinsize),
                                                     Placement.COUNT_RANGE,
                                                     mythril_cfg));
            } // end if mythril
            if (SimpleOresConfig.enableTinOre)
            {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                                     new OreFeatureConfig(
                                                             OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                             ModBlocks.tin_ore
                                                                     .getDefaultState(),
                                                             tin_veinsize),
                                                     Placement.COUNT_RANGE,
                                                     tin_cfg));
            } // end if tin
        } // end-for biome in forge registry
    } // end setupOreGen()

}  // end class OreGeneration
