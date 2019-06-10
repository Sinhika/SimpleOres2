package alexndr.plugins.SimpleOres;

import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	// Ore Blocks
	public static SimpleBlock copper_ore = 
			new SimpleBlock("copper_ore", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock tin_ore = 
			new SimpleBlock("tin_ore", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock mythril_ore = 
			new SimpleBlock("mythril_ore", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock adamantium_ore = 
			new SimpleBlock("adamantium_ore", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	public static SimpleBlock onyx_ore = 
			new SimpleBlock("onyx_ore", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.ORE).setStepSound(SoundType.STONE);
	
	// Metal Blocks
	public static SimpleBlock copper_block = 
			new SimpleBlock("copper_block", SimpleOres.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock tin_block = 
			new SimpleBlock("tin_block", SimpleOres.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock mythril_block = 
			new SimpleBlock("mythril_block", SimpleOres.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock adamantium_block = 
			new SimpleBlock("adamantium_block", SimpleOres.plugin, Material.IRON,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.METAL);
	public static SimpleBlock onyx_block = 
			new SimpleBlock("onyx_block", SimpleOres.plugin, Material.ROCK,
			ContentCategories.Block.GENERAL).setStepSound(SoundType.STONE);

	/**
	 * Register blocks with Forge.
	 * 
	 * @param registry Forge block registry interface.
	 */
	public static void register(IForgeRegistry<Block> registry) 
	{
		if (Settings.copperOre.isEnabled()) registry.register(copper_ore);
		if (Settings.tinOre.isEnabled()) registry.register(tin_ore);
		if (Settings.mythrilOre.isEnabled()) registry.register(mythril_ore);
		if (Settings.adamantiumOre.isEnabled()) registry.register(adamantium_ore);
		if (Settings.onyxOre.isEnabled()) registry.register(onyx_ore);
		
		if (Settings.copperBlock.isEnabled()) registry.register(copper_block);
		if (Settings.tinBlock.isEnabled()) registry.register(tin_block);
		if (Settings.mythrilBlock.isEnabled()) registry.register(mythril_block);
		if (Settings.adamantiumBlock.isEnabled()) registry.register(adamantium_block);
		if (Settings.onyxBlock.isEnabled()) registry.register(onyx_block);
	} // end register()

	/**
	 * register ItemBlocks with Forge.
	 * 
	 * @param registry Forge item registry interface.
	 */
	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		if (Settings.copperOre.isEnabled()) registry.register(copper_ore.createItemBlock());
		if (Settings.tinOre.isEnabled()) registry.register(tin_ore.createItemBlock());
		if (Settings.mythrilOre.isEnabled()) registry.register(mythril_ore.createItemBlock());
		if (Settings.adamantiumOre.isEnabled()) registry.register(adamantium_ore.createItemBlock());
		if (Settings.onyxOre.isEnabled()) registry.register(onyx_ore.createItemBlock());
		
		if (Settings.copperBlock.isEnabled()) registry.register(copper_block.createItemBlock());
		if (Settings.tinBlock.isEnabled()) registry.register(tin_block.createItemBlock());
		if (Settings.mythrilBlock.isEnabled()) registry.register(mythril_block.createItemBlock());
		if (Settings.adamantiumBlock.isEnabled()) registry.register(adamantium_block.createItemBlock());
		if (Settings.onyxBlock.isEnabled()) registry.register(onyx_block.createItemBlock());
	} // end registerItemBlocks()

	
	/**
	 * register models of ItemBlocks with Forge.
	 */
	public static void registerModels() 
	{
		if (Settings.copperOre.isEnabled()) 
			copper_ore.registerItemModel(Item.getItemFromBlock(copper_ore));
		if (Settings.tinOre.isEnabled())
			tin_ore.registerItemModel(Item.getItemFromBlock(tin_ore));
		if (Settings.mythrilOre.isEnabled())
			mythril_ore.registerItemModel(Item.getItemFromBlock(mythril_ore));
		if (Settings.adamantiumOre.isEnabled())
			adamantium_ore.registerItemModel(Item.getItemFromBlock(adamantium_ore));
		if (Settings.onyxOre.isEnabled())
			onyx_ore.registerItemModel(Item.getItemFromBlock(onyx_ore));
		
		if (Settings.copperBlock.isEnabled())
			copper_block.registerItemModel(Item.getItemFromBlock(copper_block));
		if (Settings.tinBlock.isEnabled())
			tin_block.registerItemModel(Item.getItemFromBlock(tin_block));
		if (Settings.mythrilBlock.isEnabled())
			mythril_block.registerItemModel(Item.getItemFromBlock(mythril_block));
		if (Settings.adamantiumBlock.isEnabled())
			adamantium_block.registerItemModel(Item.getItemFromBlock(adamantium_block));
		if (Settings.onyxBlock.isEnabled())
			onyx_block.registerItemModel(Item.getItemFromBlock(onyx_block));
	} // end registerModels
	
	/**
	 * ore dictionary registrations for blocks.
	 */
	public static void registerOreDictionary()
	{
		if (Settings.copperOre.isEnabled())
			OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.copper_ore));
		if (Settings.tinOre.isEnabled())
			OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.tin_ore));
		if (Settings.mythrilOre.isEnabled()) 
		{
			OreDictionary.registerOre("oreMythril", new ItemStack(ModBlocks.mythril_ore));
			OreDictionary.registerOre("oreMithril", new ItemStack(ModBlocks.mythril_ore));
		}
		if (Settings.adamantiumOre.isEnabled())
		{
			OreDictionary.registerOre("oreAdamantium", new ItemStack(ModBlocks.adamantium_ore));
			OreDictionary.registerOre("oreAdamantite", new ItemStack(ModBlocks.adamantium_ore));
			OreDictionary.registerOre("oreAdamantine", new ItemStack(ModBlocks.adamantium_ore));
		}
		if (Settings.onyxOre.isEnabled())
			OreDictionary.registerOre("oreOnyx", new ItemStack(ModBlocks.onyx_ore));
		if (Settings.copperBlock.isEnabled())
			OreDictionary.registerOre("blockCopper", new ItemStack(ModBlocks.copper_block));
		if (Settings.tinBlock.isEnabled())
			OreDictionary.registerOre("blockTin", new ItemStack(ModBlocks.tin_block));
		if (Settings.mythrilBlock.isEnabled()) {
			OreDictionary.registerOre("blockMythril", new ItemStack(ModBlocks.mythril_block));
			OreDictionary.registerOre("blockMithril", new ItemStack(ModBlocks.mythril_block));
		}
		if (Settings.adamantiumBlock.isEnabled()) {
			OreDictionary.registerOre("blockAdamantium", new ItemStack(ModBlocks.adamantium_block));
			OreDictionary.registerOre("blockAdamantite", new ItemStack(ModBlocks.adamantium_block));
			OreDictionary.registerOre("blockAdamantine", new ItemStack(ModBlocks.adamantium_block));
		}
		if (Settings.onyxBlock.isEnabled())
			OreDictionary.registerOre("blockOnyx", new ItemStack(ModBlocks.onyx_block));
	} // end registerOreDictionary()
	
	/**
	 * completed config revision
	 */
	public static void configureBlocks() 
	{
		LogHelper.verbose(ModInfo.ID, "Configuring blocks and ores");
		
		if (Settings.copperOre.isEnabled())
		{
			copper_ore.setConfigEntry(Settings.copperOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.tinOre.isEnabled()) { 
			tin_ore.setConfigEntry(Settings.tinOre)
					.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.mythrilOre.isEnabled()) {
			mythril_ore.setConfigEntry(Settings.mythrilOre)
			.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.adamantiumOre.isEnabled()) {
			adamantium_ore.setConfigEntry(Settings.adamantiumOre)
			.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.onyxOre.isEnabled()) {
			onyx_ore.setConfigEntry(Settings.onyxOre)
			.setDropItem(true).setItemToDrop(ModItems.onyx_gem).setQuantityToDrop(1)
			.setCreativeTab(TabHelper.blocksTab(SimpleCoreAPI.plugin));
		}
		if (Settings.copperBlock.isEnabled()) {
			copper_block.setConfigEntry(Settings.copperBlock)
						.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.tinBlock.isEnabled()) {
			tin_block.setConfigEntry(Settings.tinBlock)
						.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.mythrilBlock.isEnabled()) {
			mythril_block.setConfigEntry(Settings.mythrilBlock)
						.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.adamantiumBlock.isEnabled()) {
			adamantium_block.setConfigEntry(Settings.adamantiumBlock)
						.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
		if (Settings.onyxBlock.isEnabled()) {
			onyx_block.setConfigEntry(Settings.onyxBlock)
						.setCreativeTab(TabHelper.decorationsTab(SimpleCoreAPI.plugin));
		}
	} // end configureBlocks()

	
} // enc class
