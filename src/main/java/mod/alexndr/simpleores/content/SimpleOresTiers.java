package mod.alexndr.simpleores.content;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
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
			185, 4.0f, 1.0f, 8, ()->Ingredient.of(Items.COPPER_INGOT)
	);

	public static final Tier TIN = new SimpleTier(
			BlockTags.INCORRECT_FOR_STONE_TOOL,
			220, 3.5F, 1.0F, 8, ()->Ingredient.of( ModItems.tin_ingot.get())
	);

	public static final Tier MYTHRIL = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			800, 8.0F, 3.0F, 12,  ()->Ingredient.of( ModItems.mythril_ingot.get())
	);

	public static final Tier ADAMANTIUM = new SimpleTier(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			1150, 14.0F, 3.0F, 3, ()->Ingredient.of( ModItems.adamantium_ingot.get())
	);

	public static final Tier ONYX = new SimpleTier(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3280, 10.0F, 5.0F, 15,
			()->Ingredient.of( ModItems.onyx_gem.get())
	);

} // end class
