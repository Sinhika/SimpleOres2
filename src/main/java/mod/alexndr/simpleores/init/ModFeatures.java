package mod.alexndr.simpleores.init;

import java.util.function.Supplier;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = 
            DeferredRegister.create(ForgeRegistries.FEATURES, SimpleOres.MODID);
    
    public static final RegistryObject<Feature<OreFeatureConfig>> COPPER_VEIN
        = createFeature("copper_vein", ()->new OreFeature(OreFeatureConfig.CODEC));
    public static final RegistryObject<Feature<OreFeatureConfig>> TIN_VEIN = createFeature("tin_vein",
            () -> new OreFeature(OreFeatureConfig.CODEC));
    public static final RegistryObject<Feature<OreFeatureConfig>> MYTHRIL_VEIN = createFeature("mythril_vein",
            () -> new OreFeature(OreFeatureConfig.CODEC));
    public static final RegistryObject<Feature<OreFeatureConfig>> ADAMANTIUM_VEIN = createFeature("adamantium_vein",
            () -> new OreFeature(OreFeatureConfig.CODEC));
    public static final RegistryObject<Feature<OreFeatureConfig>> ONYX_VEIN = createFeature("onyx_vein",
            () -> new OreFeature(OreFeatureConfig.CODEC));
    
    private static <F extends Feature<?>> RegistryObject<F> createFeature(String name, Supplier<F> feature)
    {
        return FEATURES.register(name, feature);
    }   
} // end class
