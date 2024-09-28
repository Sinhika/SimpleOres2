package mod.alexndr.simpleores.content;

import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * Holds declarations for tool material tiers.
 * @author Sinhika
 *
 */
public final class SimpleOresTiers
{
//	public static final TagKey<Block> NEEDS_COPPER_TOOL =
//			BlockTags.create(new ResourceLocation(SimpleOres.MODID, "needs_copper_tool"));
//	public static final TagKey<Block> NEEDS_TIN_TOOL =
//			BlockTags.create(new ResourceLocation(SimpleOres.MODID, "needs_tin_tool"));
//	public static final TagKey<Block> NEEDS_MYTHRIL_TOOL =
//			BlockTags.create(new ResourceLocation(SimpleOres.MODID, "needs_mythril_tool"));
//	public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOL =
//			BlockTags.create(new ResourceLocation(SimpleOres.MODID, "needs_adamantium_tool"));
//	public static final TagKey<Block> NEEDS_ONYX_TOOL =
//			BlockTags.create(new ResourceLocation(SimpleOres.MODID, "needs_onyx_tool"));
	
	public static final Tier COPPER = new SimpleTier(
			BlockTags.INCORRECT_FOR_STONE_TOOL,
			SimpleOresConfig.copperToolRecord.uses(), SimpleOresConfig.copperToolRecord.speedBonus(),
			SimpleOresConfig.copperToolRecord.attackDamageBonus(), SimpleOresConfig.copperToolRecord.enchantability(),
			()->Ingredient.of(Items.COPPER_INGOT)
	);

	public static final Tier TIN = new SimpleTier(
			BlockTags.INCORRECT_FOR_STONE_TOOL,
			SimpleOresConfig.tinToolRecord.uses(), SimpleOresConfig.tinToolRecord.speedBonus(),
			SimpleOresConfig.tinToolRecord.attackDamageBonus(), SimpleOresConfig.tinToolRecord.enchantability(),
			()->Ingredient.of( ModItems.tin_ingot.get())
	);

	public static final Tier MYTHRIL = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			SimpleOresConfig.mythrilToolRecord.uses(), SimpleOresConfig.mythrilToolRecord.speedBonus(),
			SimpleOresConfig.mythrilToolRecord.attackDamageBonus(), SimpleOresConfig.mythrilToolRecord.enchantability(),
			()->Ingredient.of( ModItems.mythril_ingot.get())
	);

	public static final Tier ADAMANTIUM = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			SimpleOresConfig.adamantiumToolRecord.uses(), SimpleOresConfig.adamantiumToolRecord.speedBonus(),
			SimpleOresConfig.adamantiumToolRecord.attackDamageBonus(), SimpleOresConfig.adamantiumToolRecord.enchantability(),
			()->Ingredient.of( ModItems.adamantium_ingot.get())
	);

	public static final Tier ONYX = new SimpleTier(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			SimpleOresConfig.onyxToolRecord.uses(), SimpleOresConfig.onyxToolRecord.speedBonus(),
			SimpleOresConfig.onyxToolRecord.attackDamageBonus(), SimpleOresConfig.onyxToolRecord.enchantability(),
			()->Ingredient.of( ModItems.onyx_gem.get())
	);

} // end class
