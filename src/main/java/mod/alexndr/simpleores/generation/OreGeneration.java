package mod.alexndr.simpleores.generation;

import mod.alexndr.simplecorelib.world.OreGenUtils;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
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
        ORE_ONYX = OreGenUtils.buildNetherOreFeature(
                Feature.ORE, ModBlocks.onyx_ore.get().getDefaultState(),
                                SimpleOresConfig.onyx_cfg);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SimpleOres.MODID, "onyx_vein"), ORE_ONYX);
    } // end-initNetherFeatures()

    
    /**
     * initialize overworld Features.
     * 
     * @param evt
     */
    public static void initOverworldFeatures()
    {
        ORE_COPPER = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                ModBlocks.copper_ore.get().getDefaultState(), SimpleOresConfig.copper_cfg);
        ORE_TIN = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                ModBlocks.tin_ore.get().getDefaultState(), SimpleOresConfig.tin_cfg);
        ORE_MYTHRIL = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                ModBlocks.mythril_ore.get().getDefaultState(), SimpleOresConfig.mythril_cfg);
        ORE_ADAMANTIUM = OreGenUtils.buildOverworldOreFeature(Feature.ORE,
                ModBlocks.adamantium_ore.get().getDefaultState(), SimpleOresConfig.adamantium_cfg);
        
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SimpleOres.MODID, "onyx_vein"), ORE_COPPER);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SimpleOres.MODID, "tin_vein"), ORE_TIN);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SimpleOres.MODID, "mythril_vein"), ORE_MYTHRIL);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(SimpleOres.MODID, "adamantium_vein"), ORE_ADAMANTIUM);
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