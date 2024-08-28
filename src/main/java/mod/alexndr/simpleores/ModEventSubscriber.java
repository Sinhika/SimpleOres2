package mod.alexndr.simpleores;

import de.cech12.bucketlib.api.BucketLibApi;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Mod Event Subscriber");

    public static void onSendIMC(RegisterCapabilitiesEvent evt)
    {
        BucketLibApi.registerBucket(evt, ModItems.copper_bucket.getId());
    } // end onSendIMC
    
    
    /**
     * This method will be called by Forge when it is time for the mod to register
     * its Items. This method will always be called after the Block registry method.
     */
    public static void onRegisterItems(RegisterEvent event)
    {
        // Create the new BlockItem with the block and it's properties
        // Register the BlockItem
        event.register(Registries.ITEM, helper ->
        {
            // Automatically register BlockItems for all our normal Blocks
            ModBlocks.BLOCKS.getEntries().stream()
                    .map(DeferredHolder::get)
                    // You can do extra filtering here if you don't want some blocks to have an BlockItem
                    // automatically registered for them
                    .filter(block -> needsItemBlock(block))
                    // Register the BlockItem for the block
                    .forEach(block ->
                    {
                        helper.register(BuiltInRegistries.BLOCK.getKey(block),
                                new BlockItem(block, new Item.Properties()));
//                        LOGGER.debug("Registered " + BuiltInRegistries.BLOCK.getKey(block));
                    });
            LOGGER.debug("Registered BlockItems");

            // now register DoubleHigh blocks Items.
            ModBlocks.BLOCKS.getEntries().stream()
                    .map(DeferredHolder::get)
                    // You can do extra filtering here if you don't want some blocks to have an BlockItem
                    // automatically registered for them
                    .filter(block -> needsDoubleHighBlock(block))
                    // Register the BlockItem for the block
                    .forEach(block ->
                    {
                        helper.register(BuiltInRegistries.BLOCK.getKey(block),
                                new DoubleHighBlockItem(block, new Item.Properties()));
//                      LOGGER.debug("Registered " + BuiltInRegistries.BLOCK.getKey(block));
                    });
            LOGGER.debug("Registered doublehighblockitems");
        });
    } // end onRegisterItems()

    // DoorItems have to be handled differently, so we filter them out.
    static boolean needsItemBlock(Block block)
    {
        return (! (block instanceof DoorBlock));
    } // end needsItemBlock()

    static boolean needsDoubleHighBlock(Block block)
    {
        return (block instanceof DoorBlock);
    }
} // end class ModEventSubscriber
