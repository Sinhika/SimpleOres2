package alexndr.plugins.SimpleOres;

import java.util.List;

import com.google.common.collect.Lists;

import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.OreGenerator;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ProxyCommon 
{
	public void preInit(FMLPreInitializationEvent event) 
	{
		//Configuration
		ContentRegistry.registerPlugin(SimpleOres.plugin);
		Settings.createOrLoadSettings(event);
		SimpleCoreAPI.tabPreInit();
		
		//Content
		Content.preInitialize();
	} // end preInit
	
    public void load(FMLInitializationEvent event)
    {
		//Content
		setTabIcons();
		Content.setRepairMaterials();
		setOreGenSettings();
		Content.addSmeltingRecipes();
    } // end load
    
    public void postInit(FMLPostInitializationEvent event) 
    { 
    } // end postInit()    

	private static void setTabIcons() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(ModBlocks.copper_ore), 
					Item.getItemFromBlock(ModBlocks.adamantium_block), 
					ModItems.mythril_ingot, ModItems.onyx_pickaxe, ModItems.copper_sword,
					Item.getItemFromBlock(Blocks.FURNACE));
		SimpleCoreAPI.setTabIcons(list);
	}
	
	/**
	 * completed config revision.
	 */
	private static void setOreGenSettings() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting ore gen parameters");
		if (Settings.copperOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, ModBlocks.copper_ore, Blocks.STONE, 
					Settings.copperOre.getSpawnRate(), Settings.copperOre.getVeinSize(), 
					Settings.copperOre.getMinHeight(), Settings.copperOre.getMaxHeight());
		}
		if (Settings.tinOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, ModBlocks.tin_ore, Blocks.STONE, 
					Settings.tinOre.getSpawnRate(), Settings.tinOre.getVeinSize(), 
					Settings.tinOre.getMinHeight(), Settings.tinOre.getMaxHeight());
		}
		if (Settings.mythrilOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, ModBlocks.mythril_ore, Blocks.STONE, 
					Settings.mythrilOre.getSpawnRate(), Settings.mythrilOre.getVeinSize(), 
					Settings.mythrilOre.getMinHeight(), Settings.mythrilOre.getMaxHeight());
		}
		if (Settings.adamantiumOre.isEnableOreGen()) {
		OreGenerator.registerOreForGen(0, ModBlocks.adamantium_ore, Blocks.STONE, 
				Settings.adamantiumOre.getSpawnRate(), 
				Settings.adamantiumOre.getVeinSize(), 
				Settings.adamantiumOre.getMinHeight(), 
				Settings.adamantiumOre.getMaxHeight());
		}
		if (Settings.onyxOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, ModBlocks.onyx_ore, Blocks.NETHERRACK, 
					Settings.onyxOre.getSpawnRate(), Settings.onyxOre.getVeinSize(), 
					Settings.onyxOre.getMinHeight(), Settings.onyxOre.getMaxHeight());
		}
	} // end setOreGenSettings()
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
    	 ModBlocks.register(event.getRegistry());
	} // end registerBlocks()

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) 
	{
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
        ModItems.registerOreDictionary();
        ModBlocks.registerOreDictionary();
	}

	public void registerItemRenderer(Plugin plugin, Item item, int meta, String id) {
	}
	
} // end class
