package mod.alexndr.simpleores;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EventBusSubscriber(modid = SimpleOres.MODID, bus = MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Mod Event Subscriber");

	/**
	 * This method will be called by Forge when it is time for the mod to register its Blocks.
	 * This method will always be called before the Item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		// Register all your blocks inside this registerAll call
		event.getRegistry().registerAll( );
		LOGGER.debug("Registered Blocks");
		// TODO
	}

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
		final ModConfig config = event.getConfig();
		// TODO
	}

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.registerAll( );

		// We need to go over the entire registry so that we include any potential Registry Overrides
		for (final Block block : ForgeRegistries.BLOCKS.getValues()) {

			final ResourceLocation blockRegistryName = block.getRegistryName();
			Preconditions.checkNotNull(blockRegistryName, "Registry Name of Block \"" + block + "\" is null! This is not allowed!");

			// Check that the blocks is from our mod, if not, continue to the next block
			if (!blockRegistryName.getNamespace().equals(SimpleOres.MODID)) {
				continue;
			}

			// If you have blocks that don't have a corresponding ItemBlock, uncomment this code and create an Interface - or even better an Annotation - called NoAutomaticItemBlock with no methods and implement it on your blocks that shouldn't have ItemBlocks
//			if (!(block instanceof NoAutomaticItemBlock)) {
//				continue;
//			}

			// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
			// final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP);

			// Create the new BlockItem with the block and it's properties
			final BlockItem blockItem = new BlockItem(block, properties);
			// Setup the new BlockItem with the block's registry name and register it
			registry.register(setup(blockItem, blockRegistryName));
		}
		LOGGER.debug("Registered Items");
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name)
	{
		return setup(entry, new ResourceLocation(SimpleOres.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) 
	{
		entry.setRegistryName(registryName);
		return entry;
	}

} // end class ModEventSubscriber
