package mod.alexndr.simpleores;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import javax.annotation.Nonnull;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.alexndr.simplecorelib.config.FlagCondition;
import mod.alexndr.simpleores.config.ConfigHelper;
import mod.alexndr.simpleores.config.ConfigHolder;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.content.SimpleOresItemTier;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModTabGroups;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = SimpleOres.MODID, bus = MOD)
public final class ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Mod Event Subscriber");

    /**
     * @param event
     */
    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
//        event.enqueueWork(() -> {
//              OreGeneration.initNetherFeatures();
//              OreGeneration.initOverworldFeatures();
//        });
    	TierSortingRegistry.registerTier(SimpleOresItemTier.COPPER, new ResourceLocation(SimpleOres.MODID, "COPPER"), 
    									 List.of(Tiers.WOOD), List.of(Tiers.IRON));
    	TierSortingRegistry.registerTier(SimpleOresItemTier.TIN, new ResourceLocation(SimpleOres.MODID, "TIN"), 
				 						 List.of(Tiers.WOOD), List.of(Tiers.IRON));
    	TierSortingRegistry.registerTier(SimpleOresItemTier.MYTHRIL, new ResourceLocation(SimpleOres.MODID, "MYTHRIL"), 
				 						List.of(Tiers.STONE), List.of(Tiers.DIAMOND));
    	TierSortingRegistry.registerTier(SimpleOresItemTier.ADAMANTIUM, new ResourceLocation(SimpleOres.MODID, "ADAMANTIUM"), 
				 						List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
    	TierSortingRegistry.registerTier(SimpleOresItemTier.ONYX, new ResourceLocation(SimpleOres.MODID, "ONYX"), 
				 						List.of(Tiers.DIAMOND), List.of() );
    	
        LOGGER.debug("Common setup done");
    } // end onCommonSetup

    
    /**
     * This method will be called by Forge when it is time for the mod to register
     * its Items. This method will always be called after the Block registry method.
     */
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // We need to go over the entire registry so that we include any potential
        // Registry Overrides
        // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an
                // BlockItem automatically registered for them
                // .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block ->
                {
                    // Make the properties, and make it so that the item will be on our ItemGroup
                    // (CreativeTab)
                    final Item.Properties properties = new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });
        LOGGER.debug("Registered BlockItems");
    } // end onRegisterItems()

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event)
    {
        final ModConfig config = event.getConfig();

        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.SERVER_SPEC)
        {
            ConfigHelper.bakeServer(config);
        }
    } // onModConfigEvent

    @SubscribeEvent
    public static void onRegisterRecipeSerializers(@Nonnull final RegistryEvent.Register<RecipeSerializer<?>> event)
    {
        CraftingHelper.register(new FlagCondition.Serializer(SimpleOresConfig.INSTANCE,
                new ResourceLocation(SimpleOres.MODID, "flag")));

    } // end registerRecipeSerializers

} // end class ModEventSubscriber
