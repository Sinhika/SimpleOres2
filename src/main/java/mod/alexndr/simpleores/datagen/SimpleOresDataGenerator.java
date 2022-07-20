package mod.alexndr.simpleores.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = SimpleOres.MODID, bus = MOD)
public class SimpleOresDataGenerator
{

    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new Recipes(gen));
        gen.addProvider(event.includeServer(),new SilentsRecipes(gen));
        gen.addProvider(event.includeServer(),new ModBlockTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(),new ModItemTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(),new SimpleOresLootTableProvider(gen));
        gen.addProvider(event.includeServer(),new SimpleOresLootInjectorProvider(gen));
        
        gen.addProvider(event.includeClient(),new SimpleOresBlockStateProvider(gen, event.getExistingFileHelper()));
     } // end gatherData()

    
} // end-class SimpleModDataGenerator
