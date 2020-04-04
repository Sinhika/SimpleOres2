package mod.alexndr.simpleores;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Preconditions;

import mod.alexndr.simpleores.config.ConfigHelper;
import mod.alexndr.simpleores.config.ConfigHolder;
import mod.alexndr.simpleores.content.CopperBucket;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import mod.alexndr.simpleores.content.SimpleMetalBlock;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import mod.alexndr.simpleores.content.SimpleOresItemTier;
import mod.alexndr.simpleores.generation.OreGeneration;
import mod.alexndr.simpleores.init.ModTabGroups;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = SimpleOres.MODID, bus = MOD)
public final class ModEventSubscriber 
{
	private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Mod Event Subscriber");

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupOreGen();
        LOGGER.debug("Common setup done");
    } // end onCommonSetup

	/**
	 * This method will be called by Forge when it is time for the mod to register its Blocks.
	 * This method will always be called before the Item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocks(final RegistryEvent.Register<Block> event)
	{
		// Register all your blocks inside this registerAll call
        event.getRegistry().registerAll(
                setup(new OreBlock(Block.Properties.create(Material.ROCK)
                             .hardnessAndResistance( 1.7F, 3.0F)
                             .harvestTool(ToolType.PICKAXE).harvestLevel(1)), "copper_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                             .hardnessAndResistance( 3.0F, 3.0F)
                             .harvestTool(ToolType.PICKAXE).harvestLevel(1)), "tin_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                             .hardnessAndResistance( 4.0F, 3.0F)
                             .harvestTool(ToolType.PICKAXE).harvestLevel(2)), "adamantium_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                             .hardnessAndResistance( 5.0F, 3.0F)
                             .harvestTool(ToolType.PICKAXE).harvestLevel(2)), "mythril_ore"),
				setup(new OreBlock(Block.Properties.create(Material.ROCK)
                             .hardnessAndResistance( 7.0F, 3.0F)
                             .harvestTool(ToolType.PICKAXE).harvestLevel(3)), "onyx_ore"),
				setup(new SimpleMetalBlock(Block.Properties.create(Material.IRON,
                                                         MaterialColor.ORANGE_TERRACOTTA)
							.hardnessAndResistance(3.0F, 6.0F)
                            .harvestTool(ToolType.PICKAXE).harvestLevel(0)), "copper_block"),
				setup(new SimpleMetalBlock(Block.Properties.create(Material.IRON)
							.hardnessAndResistance(4.0F, 6.0F)
                            .harvestTool(ToolType.PICKAXE).harvestLevel(0)), "tin_block"),
				setup(new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.BLUE)
							.hardnessAndResistance(7.0F, 6.0F)
                            .harvestTool(ToolType.PICKAXE).harvestLevel(0)), "mythril_block"),
				setup(new SimpleMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.GREEN)
							.hardnessAndResistance(7.0F, 12.0F)
                            .harvestTool(ToolType.PICKAXE).harvestLevel(0)), "adamantium_block"),
				setup(new Block(Block.Properties.create(Material.ROCK, MaterialColor.OBSIDIAN)
							.hardnessAndResistance(20.0F, 100.0F)
                            .harvestTool(ToolType.PICKAXE).harvestLevel(0)), "onyx_block")
        );
		LOGGER.debug("Registered Blocks");
	}

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();

		// ingots, nuggets, gems, parts
		registry.registerAll(
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_ingot"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_gem"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_nugget"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_rod"),
				setup(new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_rod")
		);

		// armors
		registry.registerAll(
				// copper
				setup(new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_helmet"),
				setup(new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_leggings"),
				setup(new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_chestplate"),
				setup(new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_boots"),

				// tin
				setup(new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_helmet"),
				setup(new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_leggings"),
				setup(new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_chestplate"),
				setup(new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_boots"),

				// mythril
				setup(new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_helmet"),
				setup(new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_leggings"),
				setup(new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_chestplate"),
				setup(new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_boots"),

				// adamantium
				setup(new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_helmet"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_leggings"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_chestplate"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_boots"),

				// onyx
				setup(new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.HEAD,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_helmet"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.LEGS,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_leggings"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.CHEST,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_chestplate"),
				setup(new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.FEET,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_boots")

		);

		// tools
		registry.registerAll(
				// axes
				setup(new AxeItem(SimpleOresItemTier.COPPER, 7.0F, -3.1F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_axe"),
				setup(new AxeItem(SimpleOresItemTier.TIN, 6.0F, -3.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_axe"),
				setup(new AxeItem(SimpleOresItemTier.MYTHRIL, 8.0F, -3.2F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_axe"),
				setup(new AxeItem(SimpleOresItemTier.ADAMANTIUM, 6.0F, -3.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_axe"),
				setup(new AxeItem(SimpleOresItemTier.ONYX, 9.0F, -3.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_axe"),

				// bows
				setup(new MythrilBow(new Item.Properties().maxDamage(750).group(ModTabGroups.MOD_ITEM_GROUP)),
					  "mythril_bow"),
				setup(new OnyxBow(new Item.Properties().maxDamage(1000).group(ModTabGroups.MOD_ITEM_GROUP)),
					  "onyx_bow"),

				// bucket - not stackable until fillBucket() gets fixed.
				setup(new CopperBucket(new Item.Properties().maxStackSize(1).group(ModTabGroups.MOD_ITEM_GROUP)), "copper_bucket"),
				setup(new CopperBucket(Fluids.WATER,
                                       new Item.Properties().maxStackSize(1).group(ModTabGroups.MOD_ITEM_GROUP)), "copper_bucket_water"),

				// hoes
				setup(new HoeItem(SimpleOresItemTier.COPPER,-2.0F,
						new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_hoe"),
				setup(new HoeItem(SimpleOresItemTier.TIN,-3.0F,
								  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_hoe"),
				setup(new HoeItem(SimpleOresItemTier.MYTHRIL,-1.0F,
								  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_hoe"),
				setup(new HoeItem(SimpleOresItemTier.ADAMANTIUM,-1.0F,
								  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_hoe"),
				setup(new HoeItem(SimpleOresItemTier.ONYX, 0.0F,
								  new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_hoe"),

                // pickaxes
				setup(new PickaxeItem(SimpleOresItemTier.COPPER, 1, -2.8F,
										new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_pickaxe"),
				setup(new PickaxeItem(SimpleOresItemTier.TIN, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_pickaxe"),
				setup(new PickaxeItem(SimpleOresItemTier.MYTHRIL, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_pickaxe"),
				setup(new PickaxeItem(SimpleOresItemTier.ADAMANTIUM, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_pickaxe"),
				setup(new PickaxeItem(SimpleOresItemTier.ONYX, 1, -2.8F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_pickaxe"),

                // shears
				// TODO - won't shear leaves, grass.
				setup(new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.COPPER.getMaxUses())
                                                         .group(ModTabGroups.MOD_ITEM_GROUP)), "copper_shears"),
				setup(new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.TIN.getMaxUses())
                                                         .group(ModTabGroups.MOD_ITEM_GROUP)), "tin_shears"),
				setup(new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.MYTHRIL.getMaxUses())
                                                         .group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_shears"),
				setup(new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.ADAMANTIUM.getMaxUses())
                                                         .group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_shears"),
				setup(new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.ONYX.getMaxUses())
                                                         .group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_shears"),

				// shovels
				setup(new ShovelItem(SimpleOresItemTier.COPPER, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_shovel"),
				setup(new ShovelItem(SimpleOresItemTier.TIN, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_shovel"),
				setup(new ShovelItem(SimpleOresItemTier.MYTHRIL, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_shovel"),
				setup(new ShovelItem(SimpleOresItemTier.ADAMANTIUM, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_shovel"),
				setup(new ShovelItem(SimpleOresItemTier.ONYX, 1.5F, -3.0F,
									 new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_shovel"),

				// swords
				setup(new SwordItem(SimpleOresItemTier.COPPER, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "copper_sword"),
				setup(new SwordItem(SimpleOresItemTier.TIN, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "tin_sword"),
				setup(new SwordItem(SimpleOresItemTier.MYTHRIL, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "mythril_sword"),
				setup(new SwordItem(SimpleOresItemTier.ADAMANTIUM, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "adamantium_sword"),
				setup(new SwordItem(SimpleOresItemTier.ONYX, 3, -2.4F,
									new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)), "onyx_sword")
		);

		// We need to go over the entire registry so that we include any potential Registry Overrides
		for (final Block block : ForgeRegistries.BLOCKS.getValues()) {

			final ResourceLocation blockRegistryName = block.getRegistryName();
			Preconditions.checkNotNull(blockRegistryName, "Registry Name of Block \"" + block + "\" is null! This is not allowed!");

			// Check that the blocks is from our mod, if not, continue to the next block
			if (!blockRegistryName.getNamespace().equals(SimpleOres.MODID)) {
				continue;
			}
			// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
			final Item.Properties properties = new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP);

			// Create the new BlockItem with the block and it's properties
			final BlockItem blockItem = new BlockItem(block, properties);
			// Setup the new BlockItem with the block's registry name and register it
			registry.register(setup(blockItem, blockRegistryName));
		}
		LOGGER.debug("Registered Items");
	}  // end onRegisterItems()

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
		final ModConfig config = event.getConfig();

		// Rebake the configs when they change
		if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
			ConfigHelper.bakeServer(config);
		}
	} // onModConfigEvent

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry,
													   final String name)
	{
		return setup(entry, new ResourceLocation(SimpleOres.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry,
													   final ResourceLocation registryName)
	{
		entry.setRegistryName(registryName);
		return entry;
	}

} // end class ModEventSubscriber
