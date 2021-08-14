package mod.alexndr.simpleores.content;

import java.util.List;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

/**
 * Holds declarations for tool material tiers.
 * @author Sinhika
 *
 */
public final class SimpleOresTiers
{
	public static final Tag.Named<Block> COPPER_TAG = 
			BlockTags.createOptional(new ResourceLocation(SimpleOres.MODID, "needs_copper_tool"));
	public static final Tag.Named<Block> TIN_TAG = 
			BlockTags.createOptional(new ResourceLocation(SimpleOres.MODID, "needs_tin_tool"));
	public static final Tag.Named<Block> MYTHRIL_TAG = 
			BlockTags.createOptional(new ResourceLocation(SimpleOres.MODID, "needs_mythril_tool"));
	public static final Tag.Named<Block> ADAMANTIUM_TAG = 
			BlockTags.createOptional(new ResourceLocation(SimpleOres.MODID, "needs_adamantium_tool"));
	public static final Tag.Named<Block> ONYX_TAG = 
			BlockTags.createOptional(new ResourceLocation(SimpleOres.MODID, "needs_onyx_tool"));
	
	public static final Tier COPPER = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.STONE.getLevel(), 185, 4.0f, 1.0f, 8, COPPER_TAG,()->Ingredient.of(Items.COPPER_INGOT)),
			new ResourceLocation(SimpleOres.MODID, "copper"), List.of(Tiers.STONE), List.of(Tiers.IRON));
	
	public static final Tier TIN = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.STONE.getLevel(), 220, 3.5F, 1.0F, 8, TIN_TAG, ()->Ingredient.of( ModItems.tin_ingot.get())), 
			new ResourceLocation(SimpleOres.MODID, "tin"),List.of(Tiers.STONE), List.of(Tiers.IRON));
	
	public static final Tier MYTHRIL = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.IRON.getLevel(), 800, 8.0F, 3.0F, 12, MYTHRIL_TAG, ()->Ingredient.of( ModItems.mythril_ingot.get())),  
			new ResourceLocation(SimpleOres.MODID, "mythril"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
	
	public static final Tier ADAMANTIUM = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.IRON.getLevel(),1150, 14.0F, 3.0F, 3, ADAMANTIUM_TAG, ()->Ingredient.of( ModItems.adamantium_ingot.get())),
			new ResourceLocation(SimpleOres.MODID, "adamantium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
	
	public static final Tier ONYX = TierSortingRegistry.registerTier(
			new ForgeTier(Tiers.NETHERITE.getLevel(), 3280, 10.0F, 5.0F, 15, ONYX_TAG, ()->Ingredient.of( ModItems.onyx_gem.get())), 
			new ResourceLocation(SimpleOres.MODID, "onyx"),List.of(Tiers.DIAMOND), List.of() );

    
} // end class
