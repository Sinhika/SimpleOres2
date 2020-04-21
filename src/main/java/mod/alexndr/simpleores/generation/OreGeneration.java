package mod.alexndr.simpleores.generation;

import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{

    /**
     * called in setup to generate overworld ores; should respect config entries.
     */
    public static void setupOreGen()
    {
        for (Biome biome : ForgeRegistries.BIOMES.getValues())
        {
            if (biome.getCategory() == Biome.Category.THEEND)
            {
                // We have no ores for the End dimension, so this if statement is just so that
                // we skip biomes in that dimension.
                continue;
            }
            else if (biome.getCategory() == Biome.Category.NETHER)
            {
                // Nether
                if (SimpleOresConfig.enableOnyxOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                                         new OreFeatureConfig(
                                                                OreFeatureConfig.FillerBlockType.NETHERRACK,
                                                                ModBlocks.onyx_ore.get().getDefaultState(),
                                                                SimpleOresConfig.onyx_veinsize),
                                                         Placement.COUNT_RANGE, SimpleOresConfig.onyx_cfg));
                }
            } // end-else NETHER
            else
            {
                // Overworld
                if (SimpleOresConfig.enableCopperOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                                         new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                                 ModBlocks.copper_ore.get().getDefaultState(),
                                                                 SimpleOresConfig.copper_veinsize),
                                                         Placement.COUNT_RANGE,
                                                         SimpleOresConfig.copper_cfg));
                }

                if (SimpleOresConfig.enableAdamantiumOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                                         new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                                 ModBlocks.adamantium_ore.get().getDefaultState(),
                                                                 SimpleOresConfig.adamantium_veinsize),
                                                         Placement.COUNT_RANGE,
                                                         SimpleOresConfig.adamantium_cfg));
                }

                if (SimpleOresConfig.enableMythrilOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                                         new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                                 ModBlocks.mythril_ore.get().getDefaultState(),
                                                                 SimpleOresConfig.mythril_veinsize),
                                                         Placement.COUNT_RANGE,
                                                         SimpleOresConfig.mythril_cfg));
                }

                if (SimpleOresConfig.enableTinOre)
                {
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            Biome.createDecoratedFeature(Feature.ORE,
                                                         new OreFeatureConfig(
                                                                 OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                                 ModBlocks.tin_ore.get().getDefaultState(),
                                                                 SimpleOresConfig.tin_veinsize),
                                                         Placement.COUNT_RANGE,
                                                         SimpleOresConfig.tin_cfg));
                }
            } // end-else all others
        } // end-for Biome
    } // end setupOreGen()

} // end class OreGeneration