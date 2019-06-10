package alexndr.plugins.SimpleOres;

import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleBow;
import alexndr.api.content.items.SimpleBowEffects;
import alexndr.api.content.items.SimpleBucket;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShears;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
	// SIMPLE ITEMS
	// ingots
	public static SimpleItem copper_ingot = new SimpleItem("copper_ingot", SimpleOres.plugin);
	public static SimpleItem tin_ingot = new SimpleItem("tin_ingot", SimpleOres.plugin);
	public static SimpleItem mythril_ingot = new SimpleItem("mythril_ingot", SimpleOres.plugin);
	public static SimpleItem adamantium_ingot = new SimpleItem("adamantium_ingot", SimpleOres.plugin);
	public static SimpleItem onyx_gem = new SimpleItem("onyx_gem", SimpleOres.plugin);

	// parts
	public static SimpleItem mythril_rod = new SimpleItem("mythril_rod", SimpleOres.plugin);
	public static SimpleItem onyx_rod = new SimpleItem("onyx_rod", SimpleOres.plugin);

	// buckets
	public static SimpleBucket copper_bucket
		= new SimpleBucket("copper_bucket", SimpleOres.plugin, null, Content.copperBucketType);
	public static SimpleBucket copper_bucket_water
		= new SimpleBucket("copper_bucket_water", SimpleOres.plugin, 
							new ItemStack(copper_bucket), Content.copperBucketType);
	
	// TOOLS & WEAPONS
	// bows
	public static SimpleBow mythril_bow = new SimpleBow("mythril_bow", SimpleOres.plugin, 750);
	public static SimpleBow onyx_bow = new SimpleBow("onyx_bow", SimpleOres.plugin, 1000);
	
	// swords
	public static SimpleSword copper_sword = 
		new SimpleSword("copper_sword", SimpleOres.plugin, Content.toolCopper);
	public static SimpleSword tin_sword = 
		new SimpleSword("tin_sword", SimpleOres.plugin, Content.toolTin);
	public static SimpleSword mythril_sword = 
		new SimpleSword("mythril_sword", SimpleOres.plugin, Content.toolMythril);
	public static SimpleSword adamantium_sword = 
		new SimpleSword("adamantium_sword", SimpleOres.plugin, Content.toolAdamantium);
	public static SimpleSword onyx_sword = 
		new SimpleSword("onyx_sword", SimpleOres.plugin, Content.toolOnyx);
			
	// pickaxes
	public static SimplePickaxe copper_pickaxe = 
		new SimplePickaxe("copper_pickaxe", SimpleOres.plugin, Content.toolCopper);
	public static SimplePickaxe tin_pickaxe = 
		new SimplePickaxe("tin_pickaxe", SimpleOres.plugin, Content.toolTin);
	public static SimplePickaxe mythril_pickaxe = 
		new SimplePickaxe("mythril_pickaxe", SimpleOres.plugin, Content.toolMythril);
	public static SimplePickaxe adamantium_pickaxe = 
		new SimplePickaxe("adamantium_pickaxe", SimpleOres.plugin, Content.toolAdamantium);
	public static SimplePickaxe onyx_pickaxe =  
		new SimplePickaxe("onyx_pickaxe", SimpleOres.plugin, Content.toolOnyx);
	
	// axes
	public static SimpleAxe copper_axe = 
		new SimpleAxe("copper_axe", SimpleOres.plugin, Content.toolCopper, 7.0F, -3.1F);
	public static SimpleAxe tin_axe = 
		new SimpleAxe("tin_axe", SimpleOres.plugin, Content.toolTin, 6.0F, -3.0F);
	public static SimpleAxe mythril_axe = 
		new SimpleAxe("mythril_axe", SimpleOres.plugin, Content.toolMythril, 8.0F, -3.2F);
	public static SimpleAxe adamantium_axe = 
		new SimpleAxe("adamantium_axe", SimpleOres.plugin, Content.toolAdamantium, 8.0F, -3.0F);
	public static SimpleAxe onyx_axe = 
		new SimpleAxe("onyx_axe", SimpleOres.plugin, Content.toolOnyx, 9.0F, -3.0F);
	
	// shovels
	public static SimpleShovel copper_shovel = 
		new SimpleShovel("copper_shovel", SimpleOres.plugin, Content.toolCopper);
	public static SimpleShovel tin_shovel = 
		new SimpleShovel("tin_shovel", SimpleOres.plugin, Content.toolTin);
	public static SimpleShovel mythril_shovel = 
		new SimpleShovel("mythril_shovel", SimpleOres.plugin,Content.toolMythril);
	public static SimpleShovel adamantium_shovel = 
		new SimpleShovel("adamantium_shovel", SimpleOres.plugin,Content.toolAdamantium);
	public static SimpleShovel onyx_shovel = 
			new SimpleShovel("onyx_shovel", SimpleOres.plugin, Content.toolOnyx);
	
	// hoes
	public static SimpleHoe copper_hoe = 
		new SimpleHoe("copper_hoe", SimpleOres.plugin, Content.toolCopper);
	public static SimpleHoe tin_hoe = new SimpleHoe("tin_hoe", SimpleOres.plugin, Content.toolTin);
	public static SimpleHoe mythril_hoe = 
		new SimpleHoe("mythril_hoe", SimpleOres.plugin, Content.toolMythril);
	public static SimpleHoe adamantium_hoe = 
		new SimpleHoe("adamantium_hoe", SimpleOres.plugin, Content.toolAdamantium);
	public static SimpleHoe onyx_hoe = 
		new SimpleHoe("onyx_hoe", SimpleOres.plugin, Content.toolOnyx);
	
	// shears
	public static SimpleShears copper_shears = 
		new SimpleShears("copper_shears", SimpleOres.plugin,Content.toolCopper);
	public static SimpleShears tin_shears = 
		new SimpleShears("tin_shears", SimpleOres.plugin, Content.toolTin);
	public static SimpleShears mythril_shears = 
		new SimpleShears("mythril_shears", SimpleOres.plugin, Content.toolMythril);
	public static SimpleShears adamantium_shears = 
		new SimpleShears("adamantium_shears", SimpleOres.plugin, Content.toolAdamantium);
	public static SimpleShears onyx_shears = 
		new SimpleShears("onyx_shears", SimpleOres.plugin, Content.toolOnyx);
	
	// ARMOR
	// copper
	public static SimpleArmor copper_helmet = 
			new SimpleArmor("copper_helmet", SimpleOres.plugin, Content.armorCopper, 
							EntityEquipmentSlot.HEAD);
	public static SimpleArmor copper_leggings = 
			new SimpleArmor("copper_leggings", SimpleOres.plugin, Content.armorCopper, 
					EntityEquipmentSlot.LEGS); 
	public static SimpleArmor copper_chestplate = 
			new SimpleArmor("copper_chestplate", SimpleOres.plugin, Content.armorCopper, 
					EntityEquipmentSlot.CHEST); 
	public static SimpleArmor copper_boots = 
			new SimpleArmor("copper_boots", SimpleOres.plugin,Content.armorCopper, 
					EntityEquipmentSlot.FEET); 

	public static SimpleArmor tin_helmet = 
			new SimpleArmor("tin_helmet", SimpleOres.plugin, Content.armorTin,
					EntityEquipmentSlot.HEAD);
	public static SimpleArmor tin_leggings = 
			new SimpleArmor("tin_leggings", SimpleOres.plugin, Content.armorTin, 
					EntityEquipmentSlot.LEGS); 
	public static SimpleArmor tin_chestplate = 
			new SimpleArmor("tin_chestplate", SimpleOres.plugin, Content.armorTin, 
					EntityEquipmentSlot.CHEST); 
	public static SimpleArmor tin_boots = 
			new SimpleArmor("tin_boots", SimpleOres.plugin,Content.armorTin, 
					EntityEquipmentSlot.FEET); 

	public static SimpleArmor mythril_helmet = 
			new SimpleArmor("mythril_helmet", SimpleOres.plugin,Content.armorMythril, 
					EntityEquipmentSlot.HEAD);
	public static SimpleArmor mythril_leggings = 
			new SimpleArmor("mythril_leggings", SimpleOres.plugin, Content.armorMythril, 
					EntityEquipmentSlot.LEGS); 
	public static SimpleArmor mythril_chestplate = 
			new SimpleArmor("mythril_chestplate", SimpleOres.plugin, Content.armorMythril, 
					EntityEquipmentSlot.CHEST); 
	public static SimpleArmor mythril_boots = 
			new SimpleArmor("mythril_boots", SimpleOres.plugin,Content.armorMythril, 
					EntityEquipmentSlot.FEET); 

	public static SimpleArmor adamantium_helmet = 
			new SimpleArmor("adamantium_helmet", SimpleOres.plugin, Content.armorAdamantium, 
							EntityEquipmentSlot.HEAD);
	public static SimpleArmor adamantium_leggings = 
			new SimpleArmor("adamantium_leggings", SimpleOres.plugin, Content.armorAdamantium, 
					EntityEquipmentSlot.LEGS); 
	public static SimpleArmor adamantium_chestplate = 
			new SimpleArmor("adamantium_chestplate", SimpleOres.plugin, Content.armorAdamantium, 
					EntityEquipmentSlot.CHEST); 
	public static SimpleArmor adamantium_boots = 
			new SimpleArmor("adamantium_boots", SimpleOres.plugin,Content.armorAdamantium, 
					EntityEquipmentSlot.FEET); 

	public static SimpleArmor onyx_helmet = 
			new SimpleArmor("onyx_helmet", SimpleOres.plugin, Content.armorOnyx,
							 EntityEquipmentSlot.HEAD);
	public static SimpleArmor onyx_leggings = 
			new SimpleArmor("onyx_leggings", SimpleOres.plugin, Content.armorOnyx, 
					EntityEquipmentSlot.LEGS); 
	public static SimpleArmor onyx_chestplate = 
			new SimpleArmor("onyx_chestplate", SimpleOres.plugin, Content.armorOnyx, 
					EntityEquipmentSlot.CHEST); 
	public static SimpleArmor onyx_boots = 
			new SimpleArmor("onyx_boots", SimpleOres.plugin,Content.armorOnyx, 
					EntityEquipmentSlot.FEET); 

/**
 * register Items with Forge.
 * 
 * @param registry Forge item registry interface.
 */
public static void register(IForgeRegistry<Item> registry) 
{
	if (Settings.copperIngot.isEnabled()) registry.register(copper_ingot);
	if (Settings.tinIngot.isEnabled()) registry.register(tin_ingot);
	if (Settings.mythrilIngot.isEnabled()) registry.register(mythril_ingot);
	if (Settings.adamantiumIngot.isEnabled()) registry.register(adamantium_ingot);
	if (Settings.onyxGem.isEnabled()) registry.register(onyx_gem);
	if (Settings.mythrilRod.isEnabled()) registry.register(mythril_rod);
	if (Settings.onyxRod.isEnabled()) registry.register(onyx_rod);
	if (Settings.mythrilBow.isEnabled()) registry.register(mythril_bow);
	if (Settings.onyxBow.isEnabled()) registry.register(onyx_bow);
	if (Settings.copperBucket.isEnabled()){
		registry.registerAll(copper_bucket, copper_bucket_water);
	}
	if (Settings.copperTools.isEnabled())
	{
		registry.registerAll(copper_sword, copper_pickaxe, copper_axe, copper_shovel, 
							 copper_hoe, copper_shears);
	} // end copperTools.enabled
	if (Settings.tinTools.isEnabled())
	{
		registry.registerAll(tin_sword, tin_pickaxe, tin_axe, tin_shovel, 
				 tin_hoe, tin_shears);
	} // end tinTools.enabled
	if (Settings.mythrilTools.isEnabled())
	{
		registry.registerAll(mythril_sword, mythril_pickaxe, mythril_axe, mythril_shovel, 
				 mythril_hoe, mythril_shears);
	} // end-if mythril tools enabled.
	if (Settings.adamantiumTools.isEnabled())
	{
		registry.registerAll(adamantium_sword, adamantium_pickaxe, adamantium_axe, adamantium_shovel, 
				 adamantium_hoe, adamantium_shears);
	} // end-if adamantium tools enabled.
	if (Settings.onyxTools.isEnabled()) 
	{
		registry.registerAll(onyx_sword, onyx_pickaxe, onyx_axe, onyx_shovel, 
				 onyx_hoe, onyx_shears);
	} // end-if onyx tools enabled
	
	if (Settings.copperArmor.isEnabled()) 
	{
		registry.registerAll(copper_helmet, copper_leggings, copper_chestplate, copper_boots);
	} 
	if (Settings.tinArmor.isEnabled()) 
	{
		registry.registerAll(tin_helmet, tin_leggings, tin_chestplate, tin_boots);
	}
	if (Settings.mythrilArmor.isEnabled()) 
	{
		registry.registerAll(mythril_helmet, mythril_leggings, mythril_chestplate, mythril_boots);
	}
	if (Settings.adamantiumArmor.isEnabled())
	{
		registry.registerAll(adamantium_helmet, adamantium_leggings, adamantium_chestplate, adamantium_boots);
	}
	if (Settings.onyxArmor.isEnabled())
	{
		registry.registerAll(onyx_helmet, onyx_leggings, onyx_chestplate, onyx_boots);
	}
} // end register()


/**
 * register Item models with Forge.
 */
public static void registerModels() 
{
	if (Settings.copperIngot.isEnabled()) copper_ingot.registerItemModel();
	if (Settings.tinIngot.isEnabled())	tin_ingot.registerItemModel();
	if (Settings.mythrilIngot.isEnabled())	mythril_ingot.registerItemModel();
	if (Settings.adamantiumIngot.isEnabled()) adamantium_ingot.registerItemModel();
	if (Settings.onyxGem.isEnabled())	onyx_gem.registerItemModel();
	if (Settings.mythrilRod.isEnabled()) mythril_rod.registerItemModel();
	if (Settings.onyxRod.isEnabled()) onyx_rod.registerItemModel();
	if (Settings.mythrilBow.isEnabled()) mythril_bow.registerItemModel();
	if (Settings.onyxBow.isEnabled()) onyx_bow.registerItemModel();
	
	if (Settings.copperBucket.isEnabled())
	{
		copper_bucket.registerItemModel();
		copper_bucket_water.registerItemModel();
	}
	if (Settings.copperTools.isEnabled())
	{
		copper_sword.registerItemModel(); 
		copper_pickaxe.registerItemModel(); 
		copper_axe.registerItemModel(); 
		copper_shovel.registerItemModel(); 
		copper_hoe.registerItemModel(); 
		copper_shears.registerItemModel();
	} // end copperTools.enabled
	if (Settings.tinTools.isEnabled())
	{
		tin_sword.registerItemModel(); 
		tin_pickaxe.registerItemModel(); 
		tin_axe.registerItemModel(); 
		tin_shovel.registerItemModel(); 
		tin_hoe.registerItemModel(); 
		tin_shears.registerItemModel();
	} // end tinTools.enabled
	if (Settings.mythrilTools.isEnabled())
	{
		mythril_sword.registerItemModel(); 
		mythril_pickaxe.registerItemModel(); 
		mythril_axe.registerItemModel(); 
		mythril_shovel.registerItemModel(); 
		mythril_hoe.registerItemModel(); 
		mythril_shears.registerItemModel();
	} // end-if mythril tools enabled.
	if (Settings.adamantiumTools.isEnabled())
	{
		adamantium_sword.registerItemModel(); 
		adamantium_pickaxe.registerItemModel(); 
		adamantium_axe.registerItemModel(); 
		adamantium_shovel.registerItemModel(); 
		adamantium_hoe.registerItemModel(); 
		adamantium_shears.registerItemModel();
	} // end-if adamantium tools enabled.
	if (Settings.onyxTools.isEnabled()) 
	{
		onyx_sword.registerItemModel(); 
		onyx_pickaxe.registerItemModel(); 
		onyx_axe.registerItemModel(); 
		onyx_shovel.registerItemModel(); 
		onyx_hoe.registerItemModel(); 
		onyx_shears.registerItemModel();
	} // end-if onyx tools enabled
	if (Settings.copperArmor.isEnabled()) 
	{
		copper_helmet.registerItemModel();
		copper_leggings.registerItemModel();
		copper_chestplate.registerItemModel();
		copper_boots.registerItemModel();
	} 
	if (Settings.tinArmor.isEnabled()) 
	{
		tin_helmet.registerItemModel();
		tin_leggings.registerItemModel();
		tin_chestplate.registerItemModel();
		tin_boots.registerItemModel();
	}
	if (Settings.mythrilArmor.isEnabled()) 
	{
		mythril_helmet.registerItemModel();
		mythril_leggings.registerItemModel();
		mythril_chestplate.registerItemModel();
		mythril_boots.registerItemModel();
	}
	if (Settings.adamantiumArmor.isEnabled())
	{
		adamantium_helmet.registerItemModel();
		adamantium_leggings.registerItemModel();
		adamantium_chestplate.registerItemModel();
		adamantium_boots.registerItemModel();
	}
	if (Settings.onyxArmor.isEnabled())
	{
		onyx_helmet.registerItemModel();
		onyx_leggings.registerItemModel();
		onyx_chestplate.registerItemModel();
		onyx_boots.registerItemModel();
	}
} // end registerModels()

/**
 * register ingots and suchlike with the ore dictionary.
 */
public static void registerOreDictionary()
{
	LogHelper.verbose(ModInfo.ID, "Registering ore dictionary entries.");
	
	// ore dictionary registrations
	if (Settings.copperIngot.isEnabled())
		OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.copper_ingot));
	if (Settings.tinIngot.isEnabled())
		OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.tin_ingot));
	if (Settings.mythrilIngot.isEnabled()) {
		OreDictionary.registerOre("ingotMythril", new ItemStack(ModItems.mythril_ingot));
		OreDictionary.registerOre("ingotMithril", new ItemStack(ModItems.mythril_ingot));
	}
	if (Settings.adamantiumIngot.isEnabled()) {
		OreDictionary.registerOre("ingotAdamantium", new ItemStack(ModItems.adamantium_ingot));
		OreDictionary.registerOre("ingotAdamantite", new ItemStack(ModItems.adamantium_ingot));
		OreDictionary.registerOre("ingotAdamantine", new ItemStack(ModItems.adamantium_ingot));
	}
	if (Settings.onyxGem.isEnabled())
		OreDictionary.registerOre("gemOnyx", new ItemStack(ModItems.onyx_gem));
} // end registerOreDictionary()

/**
 * Configure simple items.
 */
public static void configureSimpleItems() 
{
	LogHelper.verbose(ModInfo.ID, "Configuring ingots and misc items");
	
	if (Settings.copperIngot.isEnabled()) {
		copper_ingot.setConfigEntry(Settings.copperIngot)
					.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.tinIngot.isEnabled()) {
		tin_ingot.setConfigEntry(Settings.tinIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.mythrilIngot.isEnabled()) {
		mythril_ingot.setConfigEntry(Settings.mythrilIngot)
	                .setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.adamantiumIngot.isEnabled()) {
		adamantium_ingot.setConfigEntry(Settings.adamantiumIngot)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.onyxGem.isEnabled()) {
		onyx_gem.setConfigEntry(Settings.onyxGem)
			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.mythrilRod.isEnabled()) {
		mythril_rod.setConfigEntry(Settings.mythrilRod)
					.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	if (Settings.onyxRod.isEnabled()) {
		onyx_rod.setConfigEntry(Settings.onyxRod)
	                .setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin));
	}
	// bucket re-write.
	if (Settings.copperBucket.isEnabled())
	{
		// empty copper bucket
		copper_bucket.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		// copper bucket filled with water
		copper_bucket_water.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	}
	LogHelper.verbose(ModInfo.ID, "Configured ingots and misc items");
} // end configureSimpleItems()


public static void configureBows()
{
	LogHelper.verbose(ModInfo.ID, "Configuring bows");
	if (Settings.mythrilBow.isEnabled()) 
	{
		mythril_bow.setEffect(SimpleBowEffects.damageEffect,
						Settings.mythrilBow.getDamageModifier())
				.setEffect(SimpleBowEffects.efficiencyEffect,
						Settings.mythrilBow.getEfficiencyChance())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.addToolTip("tips.efficiencyTooltip", TextFormatting.GREEN)
				.setRepairMaterial(new ItemStack(mythril_rod))
				.setZoomAmount(Settings.mythrilBow.getZoomAmount())
				.setConfigEntry(Settings.mythrilBow)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.onyxBow.isEnabled())
	{
		onyx_bow.setEffect(SimpleBowEffects.damageEffect,
						Settings.onyxBow.getDamageModifier())
				.setEffect(SimpleBowEffects.critFlameEffect)
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.addToolTip("tips.flameTooltip", TextFormatting.GREEN)
				.setRepairMaterial(new ItemStack(onyx_rod))
				.setZoomAmount(Settings.onyxBow.getZoomAmount())
				.setConfigEntry(Settings.onyxBow)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
} // end configureBows()

public static void configureTools() 
{
	LogHelper.verbose(ModInfo.ID, "Configuring tools");
	if (Settings.copperTools.isEnabled())
	{
		copper_sword.setConfigEntry(Settings.copperTools)
			.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		copper_pickaxe.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		copper_axe.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		copper_shovel.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		copper_hoe.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		copper_shears.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	} // end-if copper tools enabled
	
	if (Settings.tinTools.isEnabled())
	{
		tin_sword.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		tin_pickaxe.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		tin_axe.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
				
		tin_shovel.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		tin_hoe.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		tin_shears.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	} // end-if tin tools enabled
	
	if (Settings.mythrilTools.isEnabled())
	{
		mythril_sword.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		
		mythril_pickaxe.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		mythril_axe.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		
		mythril_shovel.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		mythril_hoe .setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		mythril_shears.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	} // end-if mythril tools enabled.
	
	if (Settings.adamantiumTools.isEnabled())
	{
		adamantium_sword.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		adamantium_pickaxe.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		adamantium_axe.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		adamantium_shovel.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		adamantium_hoe.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		adamantium_shears.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	} // end-if adamantium tools enabled.
	
	if (Settings.onyxTools.isEnabled()) 
	{
		onyx_sword.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		onyx_pickaxe.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		onyx_axe.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		onyx_shovel.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		onyx_hoe.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
		onyx_shears.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
	} // end-if onyx tools enabled
} // end configureTools()

/**
 * updated config revision complete.
 */
public static void configureArmor() 
{
	LogHelper.verbose(ModInfo.ID, "Configuring armors");
	if (Settings.copperArmor.isEnabled()) 
	{
		copper_helmet.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		copper_chestplate.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		copper_leggings.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		copper_boots.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	} 
	if (Settings.tinArmor.isEnabled()) 
	{
		tin_helmet.setType("tin").setConfigEntry(Settings.tinArmor)
								 .setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		tin_chestplate.setConfigEntry(Settings.tinArmor).setType("tin")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		tin_leggings.setConfigEntry(Settings.tinArmor)
				.setType("tin").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		tin_boots.setConfigEntry(Settings.tinArmor)
				.setType("tin").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.mythrilArmor.isEnabled()) 
	{
		mythril_helmet.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		mythril_chestplate.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		mythril_leggings.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		mythril_boots.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.adamantiumArmor.isEnabled())
	{
		adamantium_helmet.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		adamantium_chestplate.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		adamantium_leggings.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		adamantium_boots.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
	if (Settings.onyxArmor.isEnabled())
	{
		onyx_helmet.setConfigEntry(Settings.onyxArmor)
				.setType("onyx").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
				.setUnlocalizedName("onyx_helmet");
		onyx_chestplate.setConfigEntry(Settings.onyxArmor).setType("onyx")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		onyx_leggings.setConfigEntry(Settings.onyxArmor).setType("onyx")
				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
		onyx_boots.setConfigEntry(Settings.onyxArmor)
				.setType("onyx").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
	}
} // end configureArmor()

} // end class
