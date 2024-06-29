package mod.alexndr.simpleores.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.api.datagen.SimpleLootTableProvider;
import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();		
        
        // server providers
        gen.addProvider(event.includeServer(), new Recipes(packOutput));
        
        ModBlockTags blockTags = new ModBlockTags(packOutput, lookupProvider, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(),
        	new ModItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), 
        	new SimpleLootTableProvider(packOutput, List.of(
        		new LootTableProvider.SubProviderEntry(SimpleOresLootTableSubprovider::new, LootContextParamSets.BLOCK),
        		new LootTableProvider.SubProviderEntry(SimpleOresLootInjectorProvider::new, LootContextParamSets.CHEST)
        		)));
        
        // client providers
        gen.addProvider(event.includeClient(), new SimpleOresBlockStateProvider(packOutput, event.getExistingFileHelper()));
     } // end gatherData()

    
} // end-class SimpleModDataGenerator
