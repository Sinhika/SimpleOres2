package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.content.CopperBucket;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import mod.alexndr.simpleores.content.SimpleOresArmorMaterial;
import mod.alexndr.simpleores.content.SimpleOresTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems 
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, SimpleOres.MODID);

    // ingots and nuggets
    public static final RegistryObject<Item> copper_nugget = ITEMS.register("copper_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tin_ingot = ITEMS.register("tin_ingot",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tin_nugget = ITEMS.register("tin_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> raw_tin = ITEMS.register("raw_tin",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
   public static final RegistryObject<Item> mythril_ingot = ITEMS.register("mythril_ingot",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> mythril_nugget = ITEMS.register("mythril_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> raw_mythril = ITEMS.register("raw_mythril",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> adamantium_ingot = ITEMS.register("adamantium_ingot",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> adamantium_nugget = ITEMS.register("adamantium_nugget",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> raw_adamantium = ITEMS.register("raw_adamantium",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> onyx_gem = ITEMS.register("onyx_gem",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> copper_dust = ITEMS.register("copper_dust",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> crushed_copper_ore = ITEMS.register("crushed_copper_ore",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> tin_dust = ITEMS.register("tin_dust",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> crushed_tin_ore = ITEMS.register("crushed_tin_ore",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> adamantium_dust = ITEMS.register("adamantium_dust",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> crushed_adamantium_ore = ITEMS.register("crushed_adamantium_ore",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> mythril_dust = ITEMS.register("mythril_dust",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> crushed_mythril_ore = ITEMS.register("crushed_mythril_ore",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // parts
    public static final RegistryObject<Item> mythril_rod = ITEMS.register("mythril_rod",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> onyx_rod = ITEMS.register("onyx_rod",
            ()-> new Item(new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // buckets - not stackable until fillBucket() gets fixed.
    public static final RegistryObject<CopperBucket> copper_bucket = ITEMS.register("copper_bucket",
            () -> new CopperBucket(new Item.Properties().stacksTo(1).tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<CopperBucket> copper_bucket_water = ITEMS.register("copper_bucket_water",
            () -> new CopperBucket(Fluids.WATER, new Item.Properties().stacksTo(1).tab(ModTabGroups.MOD_ITEM_GROUP)));
    
    // TOOLS & WEAPONS
    // bows
    public static final RegistryObject<MythrilBow> mythril_bow = ITEMS.register("mythril_bow",
            () -> new MythrilBow(new Item.Properties().durability(750).tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<OnyxBow> onyx_bow = ITEMS.register("onyx_bow",
            () -> new OnyxBow(new Item.Properties().durability(1000).tab(ModTabGroups.MOD_ITEM_GROUP)));

    // swords: constant dmg 3, eff -2.4
    public static final RegistryObject<SwordItem> copper_sword = ITEMS.register("copper_sword",
            () -> new SwordItem(SimpleOresTiers.COPPER, 3, -2.4F,
                                new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> tin_sword = ITEMS.register("tin_sword",
            () -> new SwordItem(SimpleOresTiers.TIN, 3, -2.4F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> mythril_sword = ITEMS.register("mythril_sword",
            () -> new SwordItem(SimpleOresTiers.MYTHRIL, 3, -2.4F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> adamantium_sword = ITEMS.register("adamantium_sword",
            () -> new SwordItem(SimpleOresTiers.ADAMANTIUM, 3, -2.4F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> onyx_sword = ITEMS.register("onyx_sword",
            () -> new SwordItem(SimpleOresTiers.ONYX, 3, -2.4F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // pickaxes: constant dmg 1, eff: -2.8
    public static final RegistryObject<PickaxeItem> copper_pickaxe = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.COPPER, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> tin_pickaxe = ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.TIN, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> mythril_pickaxe = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.MYTHRIL, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> adamantium_pickaxe = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.ADAMANTIUM, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> onyx_pickaxe = ITEMS.register("onyx_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.ONYX, 1, -2.8F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // axes: axe dmg + tier dmg == ~8.0  (9.0 for uber-materials); constant eff: -3.2 (3.1 to 3.0 for uberliness)
    public static final RegistryObject<AxeItem> copper_axe = ITEMS.register("copper_axe",
            () -> new AxeItem(SimpleOresTiers.COPPER, 7.0F, -3.2F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> tin_axe = ITEMS.register("tin_axe",
            () -> new AxeItem(SimpleOresTiers.TIN, 7.0F, -3.2F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> mythril_axe = ITEMS.register("mythril_axe",
            () -> new AxeItem(SimpleOresTiers.MYTHRIL, 5.0F, -3.2F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> adamantium_axe = ITEMS.register("adamantium_axe",
            () -> new AxeItem(SimpleOresTiers.ADAMANTIUM, 5.0F, -3.2F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> onyx_axe = ITEMS.register("onyx_axe",
            () -> new AxeItem(SimpleOresTiers.ONYX, 4.0F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // shovels: constant dmg: 1.5, eff: -3.0
    public static final RegistryObject<ShovelItem> copper_shovel = ITEMS.register("copper_shovel",
            () -> new ShovelItem(SimpleOresTiers.COPPER, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> tin_shovel = ITEMS.register("tin_shovel",
            () -> new ShovelItem(SimpleOresTiers.TIN, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> mythril_shovel = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(SimpleOresTiers.MYTHRIL, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> adamantium_shovel = ITEMS.register("adamantium_shovel",
            () -> new ShovelItem(SimpleOresTiers.ADAMANTIUM, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> onyx_shovel = ITEMS.register("onyx_shovel",
            () -> new ShovelItem(SimpleOresTiers.ONYX, 1.5F, -3.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // hoes: hoe dmg + tier dmg == 0; Eff: -3 for bad hoe materials, 0 for uber materials, rest in-between.
    public static final RegistryObject<HoeItem> copper_hoe = ITEMS.register("copper_hoe",
            () -> new HoeItem(SimpleOresTiers.COPPER,-1, -2.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)){});
    public static final RegistryObject<HoeItem> tin_hoe = ITEMS.register("tin_hoe",
            () -> new HoeItem(SimpleOresTiers.TIN,-1, -2.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)){});
    public static final RegistryObject<HoeItem> mythril_hoe = ITEMS.register("mythril_hoe",
            () -> new HoeItem(SimpleOresTiers.MYTHRIL,-3, -1.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)){});
    public static final RegistryObject<HoeItem> adamantium_hoe = ITEMS.register("adamantium_hoe",
            () -> new HoeItem(SimpleOresTiers.ADAMANTIUM, -3, -1.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)) {});
    public static final RegistryObject<HoeItem> onyx_hoe = ITEMS.register("onyx_hoe",
            () -> new HoeItem(SimpleOresTiers.ONYX, -5, 0.0F,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)) {});

    // shears
    public static final RegistryObject<ShearsItem> copper_shears = ITEMS.register("copper_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.COPPER.getUses())
                    .tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> tin_shears = ITEMS.register("tin_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.TIN.getUses())
                    .tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> mythril_shears = ITEMS.register("mythril_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.MYTHRIL.getUses())
                    .tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> adamantium_shears = ITEMS.register("adamantium_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.ADAMANTIUM.getUses())
                    .tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShearsItem> onyx_shears = ITEMS.register("onyx_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.ONYX.getUses())
                    .tab(ModTabGroups.MOD_ITEM_GROUP)));

    // ARMOR
    // copper
    public static final RegistryObject<ArmorItem> copper_helmet = ITEMS.register("copper_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_leggings = ITEMS.register("copper_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_chestplate = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> copper_boots = ITEMS.register("copper_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.COPPER, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // tin
    public static final RegistryObject<ArmorItem> tin_helmet = ITEMS.register("tin_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_leggings = ITEMS.register("tin_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_chestplate = ITEMS.register("tin_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> tin_boots = ITEMS.register("tin_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.TIN, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // mythril
    public static final RegistryObject<ArmorItem> mythril_helmet = ITEMS.register("mythril_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_leggings = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_chestplate = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> mythril_boots = ITEMS.register("mythril_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.MYTHRIL, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // adamantium
    public static final RegistryObject<ArmorItem> adamantium_helmet = ITEMS.register("adamantium_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_leggings = ITEMS.register("adamantium_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_chestplate = ITEMS.register("adamantium_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> adamantium_boots = ITEMS.register("adamantium_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.ADAMANTIUM, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));

    // onyx
    public static final RegistryObject<ArmorItem> onyx_helmet = ITEMS.register("onyx_helmet",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_leggings = ITEMS.register("onyx_leggings",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_chestplate = ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> onyx_boots = ITEMS.register("onyx_boots",
            () -> new ArmorItem(SimpleOresArmorMaterial.ONYX, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModTabGroups.MOD_ITEM_GROUP)));
    
} // end class
