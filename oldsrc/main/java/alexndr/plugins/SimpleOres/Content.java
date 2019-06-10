package alexndr.plugins.SimpleOres;

import alexndr.api.content.items.SimpleBucketType;
import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.logger.LogHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	// SimpleBucketType
	public static SimpleBucketType copperBucketType;
	
	// Tool Materials
	public static ToolMaterial toolCopper, toolTin, toolMythril,
			toolAdamantium, toolOnyx;

	// Armor Materials
	public static ArmorMaterial armorCopper, armorTin, armorMythril,
			armorAdamantium, armorOnyx;

	
	public static void preInitialize() 
	{
		setToolAndArmorStats();
		setBucketVariants();
		ModItems.configureSimpleItems();
		ModBlocks.configureBlocks(); // don't move this, as needs some items defined in doItems() first.
		ModItems.configureTools();
		ModItems.configureBows();
		ModItems.configureArmor();
	} // end preInitialize()


	/**
	 * completed config revision.
	 */
	public static void setToolAndArmorStats() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting Tool and Armor stats");
		
		// Tools
		toolCopper = EnumHelper.addToolMaterial("COPPER",
				Settings.copperTools.getHarvestLevel(),
				Settings.copperTools.getUses(),
				Settings.copperTools.getHarvestSpeed(),
				Settings.copperTools.getDamageVsEntity(),
				Settings.copperTools.getEnchantability());
		toolTin = EnumHelper.addToolMaterial("TIN",
				Settings.tinTools.getHarvestLevel(),
				Settings.tinTools.getUses(),
				Settings.tinTools.getHarvestSpeed(),
				Settings.tinTools.getDamageVsEntity(),
				Settings.tinTools.getEnchantability());
		toolMythril = EnumHelper.addToolMaterial("MYTHRIL",
				Settings.mythrilTools.getHarvestLevel(),
				Settings.mythrilTools.getUses(),
				Settings.mythrilTools.getHarvestSpeed(),
				Settings.mythrilTools.getDamageVsEntity(),
				Settings.mythrilTools.getEnchantability());
		toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM",
				Settings.adamantiumTools.getHarvestLevel(),
				Settings.adamantiumTools.getUses(),
				Settings.adamantiumTools.getHarvestSpeed(),
				Settings.adamantiumTools.getDamageVsEntity(),
				Settings.adamantiumTools.getEnchantability());
		toolOnyx = EnumHelper.addToolMaterial("ONYX",
				Settings.onyxTools.getHarvestLevel(),
				Settings.onyxTools.getUses(),
				Settings.onyxTools.getHarvestSpeed(),
				Settings.onyxTools.getDamageVsEntity(),
				Settings.onyxTools.getEnchantability());
		// Armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
		armorCopper = 
				EnumHelper.addArmorMaterial("COPPER", 
						"copper", Settings.copperArmor.getDurability(), 
						new int[] {
								Settings.copperArmor.getBootsReduction(),
								Settings.copperArmor.getLegsReduction(),
								Settings.copperArmor.getChestReduction(),
								Settings.copperArmor.getHelmReduction() },
						Settings.copperArmor.getEnchantability(), armorNoise, 0.0F );
		armorTin = EnumHelper.addArmorMaterial("TIN", "tin",
				Settings.tinArmor.getDurability(),
				new int[] { 
						Settings.tinArmor.getBootsReduction(),
						Settings.tinArmor.getLegsReduction(),
						Settings.tinArmor.getChestReduction(),
						Settings.tinArmor.getHelmReduction() },
				Settings.tinArmor.getEnchantability(), armorNoise, 0.0F);
		armorMythril = EnumHelper.addArmorMaterial("MYTHRIL","mythril",
				Settings.mythrilArmor.getDurability(), new int[] {
						Settings.mythrilArmor.getBootsReduction(),
						Settings.mythrilArmor.getLegsReduction(),
						Settings.mythrilArmor.getChestReduction(),
						Settings.mythrilArmor.getHelmReduction() },
				Settings.mythrilArmor.getEnchantability(), armorNoise, 0.0F );
		armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", "adamantium", 
				Settings.adamantiumArmor.getDurability(),
				new int[] { 
						Settings.adamantiumArmor.getBootsReduction(),
						Settings.adamantiumArmor.getLegsReduction(),
						Settings.adamantiumArmor.getChestReduction(),
						Settings.adamantiumArmor.getHelmReduction() },
				Settings.adamantiumArmor.getEnchantability(), armorNoise, 1.0F);
		armorOnyx = EnumHelper.addArmorMaterial("ONYX", "onyx",
				Settings.onyxArmor.getDurability(), new int[] {
						Settings.onyxArmor.getBootsReduction(),
						Settings.onyxArmor.getLegsReduction(),
						Settings.onyxArmor.getChestReduction(),
						Settings.onyxArmor.getHelmReduction() },
				Settings.onyxArmor.getEnchantability(), armorNoise, 2.0F);

	} // end setToolAndArmorStats()

	/**
	 * completed config revision.
	 */
	public static void setRepairMaterials() 
	{
		LogHelper.verbose(ModInfo.ID,
				"Setting Tool and Armor repair materials");
	
		if (Settings.copperIngot.isEnabled()) 
		{
			if (toolCopper != null) toolCopper.setRepairItem(new ItemStack(ModItems.copper_ingot));
			if (armorCopper != null)
				ArmorMaterialHelper.setRepairItem(armorCopper, new ItemStack(ModItems.copper_ingot));
		}
		if (Settings.tinIngot.isEnabled()) {
			if (toolTin != null) toolTin.setRepairItem(new ItemStack(ModItems.tin_ingot));
			if (armorTin != null)
				ArmorMaterialHelper.setRepairItem(armorTin, new ItemStack(ModItems.tin_ingot));
		}
		if (Settings.mythrilIngot.isEnabled()) {
			if (toolMythril != null) toolMythril.setRepairItem(new ItemStack(ModItems.mythril_ingot));
			if (armorMythril != null) 
				ArmorMaterialHelper.setRepairItem(armorMythril, new ItemStack(ModItems.mythril_ingot));
		}
		if (Settings.adamantiumIngot.isEnabled())
		{
			if (toolAdamantium != null) 
				toolAdamantium.setRepairItem(new ItemStack(ModItems.adamantium_ingot));
			if (armorAdamantium != null)
				ArmorMaterialHelper.setRepairItem(armorAdamantium, new ItemStack(ModItems.adamantium_ingot));
		}
		if (Settings.onyxGem.isEnabled()) {
			if (toolOnyx != null) toolOnyx.setRepairItem(new ItemStack(ModItems.onyx_gem));
			if (armorOnyx != null) 
				ArmorMaterialHelper.setRepairItem(armorOnyx, new ItemStack(ModItems.onyx_gem));
		}
	} // end setRepairMaterials()

	/**
	 * completed config revision.
	 */
	public static void setBucketVariants() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting bucket variants");
		if (Settings.copperBucket.isEnabled()) {
			copperBucketType = new SimpleBucketType("copper");
			copperBucketType.setDestroyOnLava(true);
		}
		Content.copperBucketType.addVariant("water", ModItems.copper_bucket_water, 
											FluidRegistry.WATER);
	}

	/**
	 * Add smelting recipes to GameRegistry.
	 */
	public static void addSmeltingRecipes() 
	{
		if (Settings.copperBucket.isEnabled() && Settings.copperIngot.isEnabled()) {
			GameRegistry.addSmelting(ModItems.copper_bucket, 
									new ItemStack(ModItems.copper_ingot, 3, 0), 0.0F);
		}
		if (Settings.copperIngot.isEnabled() && Settings.copperOre.isEnabled()) {
			GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(ModItems.copper_ingot, 1, 0),
					Settings.copperIngot.getSmeltingXP());
		}
		if (Settings.tinIngot.isEnabled() && Settings.tinOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(ModItems.tin_ingot, 1, 0), Settings.tinIngot.getSmeltingXP());
		if (Settings.mythrilIngot.isEnabled() && Settings.mythrilOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.mythril_ore, new ItemStack(ModItems.mythril_ingot, 1, 0), Settings.mythrilIngot.getSmeltingXP());
		if (Settings.adamantiumIngot.isEnabled())
			GameRegistry.addSmelting(ModBlocks.adamantium_ore, new ItemStack(ModItems.adamantium_ingot, 1, 0), Settings.adamantiumIngot.getSmeltingXP());
		if (Settings.onyxGem.isEnabled() && Settings.onyxOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.onyx_ore, new ItemStack(ModItems.onyx_gem, 1, 0), Settings.onyxGem.getSmeltingXP());
	} // end addSmeltingRecipes()

} // end class()
