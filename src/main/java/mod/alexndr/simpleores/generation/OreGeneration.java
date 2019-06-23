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
import net.minecraftforge.common.BiomeManager;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig adamantium_cfg = new CountRangeConfig(6, 1, 1, 30);
    private static final int adamantium_veinsize = 6;
    private static final CountRangeConfig copper_cfg = new CountRangeConfig(30, 1, 1, 90);
    private static final int copper_veinsize = 10;
    private static final CountRangeConfig mythril_cfg = new CountRangeConfig(10, 1, 1, 40);
    private static final int mythril_veinsize = 8;
    private static final CountRangeConfig onyx_cfg = new CountRangeConfig(10, 1, 10, 128);
    private static final int onyx_veinsize = 6;
    private static final CountRangeConfig tin_cfg = new CountRangeConfig(25, 1, 1, 90);
    private static final int tin_veinsize = 10;

    /**
     * called in setup to generate overworld ores; should respect config
     * entries.
     */
    public static void setupOreGen()
    {
        for (BiomeManager.BiomeType btype : BiomeManager.BiomeType.values() )
        {
                for (BiomeManager.BiomeEntry biomeEntry : BiomeManager.getBiomes(btype))
                {
                    if (SimpleOresConfig.enableCopperOre)
                    {
                        biomeEntry.biome.addFeature(
                            GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                    new OreFeatureConfig(
                                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                        ModBlocks.copper_ore.getDefaultState(), copper_veinsize),
                                                    Placement.COUNT_RANGE, copper_cfg));
                    } // end if copper_ore
                    if (SimpleOresConfig.enableAdamantiumOre)
                    {
                        biomeEntry.biome.addFeature(
                                GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                    new OreFeatureConfig(
                                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                        ModBlocks.adamantium_ore.getDefaultState(), adamantium_veinsize),
                                                    Placement.COUNT_RANGE, adamantium_cfg));
                    } // end if adamantium ore
                    if (SimpleOresConfig.enableMythrilOre)
                    {
                        biomeEntry.biome.addFeature(
                                GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                    new OreFeatureConfig(
                                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                        ModBlocks.mythril_ore.getDefaultState(), mythril_veinsize),
                                                    Placement.COUNT_RANGE, mythril_cfg));
                    } // end if mythril
                    if (SimpleOresConfig.enableTinOre)
                    {
                        biomeEntry.biome.addFeature(
                                GenerationStage.Decoration.UNDERGROUND_ORES,
                                Biome.createDecoratedFeature(Feature.ORE,
                                                    new OreFeatureConfig(
                                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                        ModBlocks.tin_ore.getDefaultState(), tin_veinsize),
                                                    Placement.COUNT_RANGE, tin_cfg));
                    } // end if tin
                } // end-for BiomeEntry
        } // end for BiomeType
    } // end setupOreGen()

    /**
     * called in setup to generate Nether ores.
     */
    public static void setupNetherOreGen()
    {
        if (SimpleOresConfig.enableOnyxOre)
        {
            Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(Feature.ORE,
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
                                     ModBlocks.onyx_ore.getDefaultState(), onyx_veinsize),
                                     Placement.COUNT_RANGE, onyx_cfg));
        }
    } // end setupNetherOreGen()

}  // end class OreGeneration
