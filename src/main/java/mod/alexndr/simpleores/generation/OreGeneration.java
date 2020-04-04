package mod.alexndr.simpleores.generation;

import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.biome.Biome;
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
        // for each biome type (cool, warm, icy, desert, etc...)
        for (BiomeManager.BiomeType biomeType: BiomeManager.BiomeType.values()) {

            // for each biome within that biome type
            for (BiomeManager.BiomeEntry biomeEntry: BiomeManager.getBiomes(biomeType)) {
                if (biomeEntry.biome.getCategory() == Biome.Category.THEEND) {
                    // We have no ores for the End dimension, so this if statement is just so that we skip biomes in that dimension.
                    continue;
                } else if (biomeEntry.biome.getCategory() == Biome.Category.NETHER) {
                    // Nether
                    if (SimpleOresConfig.enableOnyxOre)
                    {
                        biomeEntry.biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NETHERRACK,
                                        ModBlocks.onyx_ore.getDefaultState(),
                                        onyx_veinsize)
                                ).withPlacement(Placement.COUNT_RANGE.configure(onyx_cfg))
                        );
                    }
                } else {
                    // Overworld
                    if (SimpleOresConfig.enableCopperOre)
                    {
                        biomeEntry.biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.copper_ore.getDefaultState(),
                                        copper_veinsize)
                                ).withPlacement(Placement.COUNT_RANGE.configure(copper_cfg))
                        );
                    }

                    if (SimpleOresConfig.enableAdamantiumOre)
                    {
                        biomeEntry.biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.adamantium_ore.getDefaultState(),
                                        adamantium_veinsize)
                                ).withPlacement(Placement.COUNT_RANGE.configure(adamantium_cfg))
                        );
                    }

                    if (SimpleOresConfig.enableMythrilOre)
                    {
                        biomeEntry.biome.addFeature(
                                GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.mythril_ore.getDefaultState(),
                                        mythril_veinsize)
                                ).withPlacement(Placement.COUNT_RANGE.configure(mythril_cfg))
                        );
                    }

                    if (SimpleOresConfig.enableTinOre)
                    {
                        biomeEntry.biome.addFeature(
                                GenerationStage.Decoration.UNDERGROUND_ORES,
                                Feature.ORE.withConfiguration(new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.tin_ore.getDefaultState(),
                                        tin_veinsize)
                                ).withPlacement(Placement.COUNT_RANGE.configure(tin_cfg))
                        );
                    }
                }
            }
        }
    } // end setupOreGen()

}  // end class OreGeneration