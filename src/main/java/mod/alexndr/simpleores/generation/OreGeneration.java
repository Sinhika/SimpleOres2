package mod.alexndr.simpleores.generation;

import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Ore generation master-class for SimpleOres.
 */
public class OreGeneration
{
    /** 
     * generate nether ores.
     */
    public static void generateNetherOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableOnyxOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ORE_ONYX_ALL.getHolder().get());
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_DECORATION, ModFeatures.ORE_ONYX_IN_ROCK.getHolder().get());
        }
    } // end generateNetherOres()
    
    /**
     * generate overworld ores.
     */
    public static void generateOverworldOres(BiomeLoadingEvent evt)
    {
        if (SimpleOresConfig.enableTinOre) {
           evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_TIN_PLACER.getHolder().get());
           evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_TIN_INTRUSION.getHolder().get());
        }
        if (SimpleOresConfig.enableMythrilOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_MYTHRIL_DEPOSIT.getHolder().get());
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_MYTHRIL_INTRUSION.getHolder().get());
        }
        if (SimpleOresConfig.enableAdamantiumOre) {
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_ADAMANTIUM_DEPOSIT.getHolder().get());
            evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.ORE_ADAMANTIUM_INTRUSION.getHolder().get());
        }
    } // end generateOverworldOres()
    

} // end class ModFeatures