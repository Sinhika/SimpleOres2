package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.content.CopperBucket;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import mod.alexndr.simpleores.content.SimpleOresItemTier;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems 
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, SimpleOres.MODID);

    // ingots and nuggets
    public static final RegistryObject<Item> copper_ingot = ITEMS.register("copper_ingot", 
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> copper_nugget = ITEMS.register("copper_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tin_ingot = ITEMS.register("tin_ingot",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tin_nugget = ITEMS.register("tin_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> mythril_ingot = ITEMS.register("mythril_ingot",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> mythril_nugget = ITEMS.register("mythril_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> adamantium_ingot = ITEMS.register("adamantium_ingot",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> adamantium_nugget = ITEMS.register("adamantium_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> onyx_gem = ITEMS.register("onyx_gem",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // parts
    public static final RegistryObject<Item> mythril_rod = ITEMS.register("mythril_rod",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> onyx_rod = ITEMS.register("onyx_rod",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // buckets - not stackable until fillBucket() gets fixed.
    public static final RegistryObject<CopperBucket> copper_bucket = ITEMS.register("copper_bucket",
            () -> new CopperBucket(new Item.Properties().maxStackSize(1).group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<CopperBucket> copper_bucket_water = ITEMS.register("copper_bucket_water",
            () -> new CopperBucket(Fluids.WATER, new Item.Properties().maxStackSize(1).group(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS & WEAPONS
    // bows
    public static final RegistryObject<MythrilBow> mythril_bow = ITEMS.register("mythril_bow",
            () -> new MythrilBow(new Item.Properties().maxDamage(750).group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<OnyxBow> onyx_bow = ITEMS.register("onyx_bow",
            () -> new OnyxBow(new Item.Properties().maxDamage(1000).group(ModTabGroups.MOD_ITEM_GROUP)));

    // swords
    public static final RegistryObject<SwordItem> copper_sword = ITEMS.register("copper_sword",
            () -> new SwordItem(SimpleOresItemTier.COPPER, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> tin_sword = ITEMS.register("tin_sword",
            () -> new SwordItem(SimpleOresItemTier.TIN, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> mythril_sword = ITEMS.register("mythril_sword",
            () -> new SwordItem(SimpleOresItemTier.MYTHRIL, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> adamantium_sword = ITEMS.register("adamantium_sword",
            () -> new SwordItem(SimpleOresItemTier.ADAMANTIUM, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> onyx_sword = ITEMS.register("onyx_sword",
            () -> new SwordItem(SimpleOresItemTier.ONYX, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // pickaxes
    public static final RegistryObject<PickaxeItem> copper_pickaxe = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(SimpleOresItemTier.COPPER, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> tin_pickaxe = ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(SimpleOresItemTier.TIN, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> mythril_pickaxe = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(SimpleOresItemTier.MYTHRIL, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> adamantium_pickaxe = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(SimpleOresItemTier.ADAMANTIUM, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> onyx_pickaxe = ITEMS.register("onyx_pickaxe",
            () -> new PickaxeItem(SimpleOresItemTier.ONYX, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // axes
    public static final RegistryObject<AxeItem> copper_axe = ITEMS.register("copper_axe",
            () -> new AxeItem(SimpleOresItemTier.COPPER, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> tin_axe = ITEMS.register("tin_axe",
            () -> new AxeItem(SimpleOresItemTier.TIN, 6.0F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> mythril_axe = ITEMS.register("mythril_axe",
            () -> new AxeItem(SimpleOresItemTier.MYTHRIL, 8.0F, -3.2F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> adamantium_axe = ITEMS.register("adamantium_axe",
            () -> new AxeItem(SimpleOresItemTier.ADAMANTIUM, 6.0F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> onyx_axe = ITEMS.register("onyx_axe",
            () -> new AxeItem(SimpleOresItemTier.ONYX, 9.0F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // shovels
    public static final RegistryObject<ShovelItem> copper_shovel = ITEMS.register("copper_shovel",
            () -> new ShovelItem(SimpleOresItemTier.COPPER, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> tin_shovel = ITEMS.register("tin_shovel",
            () -> new ShovelItem(SimpleOresItemTier.TIN, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> mythril_shovel = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(SimpleOresItemTier.MYTHRIL, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> adamantium_shovel = ITEMS.register("adamantium_shovel",
            () -> new ShovelItem(SimpleOresItemTier.ADAMANTIUM, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> onyx_shovel = ITEMS.register("onyx_shovel",
            () -> new ShovelItem(SimpleOresItemTier.ONYX, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // hoes
    public static final RegistryObject<HoeItem> copper_hoe = ITEMS.register("copper_hoe",
            () -> new HoeItem(SimpleOresItemTier.COPPER,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> tin_hoe = ITEMS.register("tin_hoe",
            () -> new HoeItem(SimpleOresItemTier.TIN,-3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> mythril_hoe = ITEMS.register("mythril_hoe",
            () -> new HoeItem(SimpleOresItemTier.MYTHRIL,-1.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> adamantium_hoe = ITEMS.register("adamantium_hoe",
            () -> new HoeItem(SimpleOresItemTier.ADAMANTIUM,-1.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> onyx_hoe = ITEMS.register("onyx_hoe",
            () -> new HoeItem(SimpleOresItemTier.ONYX, 0.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // shears
    public static final RegistryObject<ShearsItem> copper_shears = ITEMS.register("copper_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.COPPER.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> tin_shears = ITEMS.register("tin_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.TIN.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> mythril_shears = ITEMS.register("mythril_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.MYTHRIL.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> adamantium_shears = ITEMS.register("adamantium_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.ADAMANTIUM.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> onyx_shears = ITEMS.register("onyx_shears",
            () -> new ShearsItem(new Item.Properties().maxDamage(SimpleOresItemTier.ONYX.getMaxUses())
                    .group(ModTabGroups.MOD_ITEM_GROUP)));

    // ARMOR
    // copper
    public static final RegistryObject<ArmorItem> copper_helmet = ITEMS.register("copper_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_leggings = ITEMS.register("copper_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_chestplate = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_boots = ITEMS.register("copper_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // tin
    public static final RegistryObject<ArmorItem> tin_helmet = ITEMS.register("tin_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_leggings = ITEMS.register("tin_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_chestplate = ITEMS.register("tin_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_boots = ITEMS.register("tin_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // mythril
    public static final RegistryObject<ArmorItem> mythril_helmet = ITEMS.register("mythril_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_leggings = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_chestplate = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_boots = ITEMS.register("mythril_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // adamantium
    public static final RegistryObject<ArmorItem> adamantium_helmet = ITEMS.register("adamantium_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_leggings = ITEMS.register("adamantium_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_chestplate = ITEMS.register("adamantium_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_boots = ITEMS.register("adamantium_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // onyx
    public static final RegistryObject<ArmorItem> onyx_helmet = ITEMS.register("onyx_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_leggings = ITEMS.register("onyx_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_chestplate = ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_boots = ITEMS.register("onyx_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end class
