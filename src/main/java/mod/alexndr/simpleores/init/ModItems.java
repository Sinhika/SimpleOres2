package mod.alexndr.simpleores.init;

import de.cech12.bucketlib.api.item.UniversalBucketItem;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.content.MythrilBow;
import mod.alexndr.simpleores.content.OnyxBow;
import mod.alexndr.simpleores.content.SimpleOresTiers;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems( SimpleOres.MODID);

    // ingots and nuggets
    public static final DeferredItem<Item> copper_nugget = ITEMS.registerSimpleItem("copper_nugget");

    public static final DeferredItem<Item> tin_ingot = ITEMS.registerSimpleItem("tin_ingot");
    public static final DeferredItem<Item> tin_nugget = ITEMS.registerSimpleItem("tin_nugget");
    public static final DeferredItem<Item> raw_tin = ITEMS.registerSimpleItem("raw_tin");
    public static final DeferredItem<Item> mythril_ingot = ITEMS.registerSimpleItem("mythril_ingot");
    public static final DeferredItem<Item> mythril_nugget = ITEMS.registerSimpleItem("mythril_nugget");
    public static final DeferredItem<Item> raw_mythril = ITEMS.registerSimpleItem("raw_mythril");
    public static final DeferredItem<Item> adamantium_ingot = ITEMS.registerSimpleItem("adamantium_ingot");
    public static final DeferredItem<Item> adamantium_nugget = ITEMS.registerSimpleItem("adamantium_nugget");
    public static final DeferredItem<Item> raw_adamantium = ITEMS.registerSimpleItem("raw_adamantium");
    public static final DeferredItem<Item> onyx_gem = ITEMS.registerSimpleItem("onyx_gem");

    public static final DeferredItem<Item> copper_dust = ITEMS.registerSimpleItem("copper_dust");
    public static final DeferredItem<Item> crushed_copper_ore = ITEMS.registerSimpleItem("crushed_copper_ore");
    public static final DeferredItem<Item> tin_dust = ITEMS.registerSimpleItem("tin_dust");
    public static final DeferredItem<Item> crushed_tin_ore = ITEMS.registerSimpleItem("crushed_tin_ore");
    public static final DeferredItem<Item> adamantium_dust = ITEMS.registerSimpleItem("adamantium_dust");
    public static final DeferredItem<Item> crushed_adamantium_ore = ITEMS.registerSimpleItem("crushed_adamantium_ore");
    public static final DeferredItem<Item> mythril_dust = ITEMS.registerSimpleItem("mythril_dust");
    public static final DeferredItem<Item> crushed_mythril_ore = ITEMS.registerSimpleItem("crushed_mythril_ore");

    // parts
    public static final DeferredItem<Item> mythril_rod = ITEMS.registerSimpleItem("mythril_rod");
    public static final DeferredItem<Item> onyx_rod = ITEMS.registerSimpleItem("onyx_rod");

    // buckets 
    public static final DeferredItem<Item> copper_bucket = ITEMS.register("copper_bucket",
            () -> new UniversalBucketItem(
                    new UniversalBucketItem.Properties()
                    .upperCrackingTemperature(SimpleOresConfig.serverCopperBucketMeltTemperature)
                    .burningTemperature(SimpleOresConfig.serverCopperBucketFireTemperature)
                    .milking(SimpleOresConfig.serverEnableCopperBucketMilking)
                    ));


    // TOOLS & WEAPONS
    // bows
    public static final DeferredItem<MythrilBow> mythril_bow = ITEMS.register("mythril_bow",
            () -> new MythrilBow(new Item.Properties().durability(750)));
    public static final DeferredItem<OnyxBow> onyx_bow = ITEMS.register("onyx_bow",
            () -> new OnyxBow(new Item.Properties().durability(1000)));

    // swords: constant dmg 3, eff -2.4
    public static final DeferredItem<SwordItem> copper_sword = ITEMS.register("copper_sword",
            () -> new SwordItem(SimpleOresTiers.COPPER, 3, -2.4F,
                                new Item.Properties()));
    public static final DeferredItem<SwordItem> tin_sword = ITEMS.register("tin_sword",
            () -> new SwordItem(SimpleOresTiers.TIN, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<SwordItem> mythril_sword = ITEMS.register("mythril_sword",
            () -> new SwordItem(SimpleOresTiers.MYTHRIL, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<SwordItem> adamantium_sword = ITEMS.register("adamantium_sword",
            () -> new SwordItem(SimpleOresTiers.ADAMANTIUM, 3, -2.4F,
                    new Item.Properties()));
    public static final DeferredItem<SwordItem> onyx_sword = ITEMS.register("onyx_sword",
            () -> new SwordItem(SimpleOresTiers.ONYX, 3, -2.4F,
                    new Item.Properties()));

    // pickaxes: constant dmg 1, eff: -2.8
    public static final DeferredItem<PickaxeItem> copper_pickaxe = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.COPPER, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> tin_pickaxe = ITEMS.register("tin_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.TIN, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> mythril_pickaxe = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.MYTHRIL, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> adamantium_pickaxe = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.ADAMANTIUM, 1, -2.8F,
                    new Item.Properties()));
    public static final DeferredItem<PickaxeItem> onyx_pickaxe = ITEMS.register("onyx_pickaxe",
            () -> new PickaxeItem(SimpleOresTiers.ONYX, 1, -2.8F,
                    new Item.Properties()));

    // axes: axe dmg + tier dmg == ~8.0  (9.0 for uber-materials); constant eff: -3.2 (3.1 to 3.0 for uberliness)
    public static final DeferredItem<AxeItem> copper_axe = ITEMS.register("copper_axe",
            () -> new AxeItem(SimpleOresTiers.COPPER, 7.0F, -3.2F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> tin_axe = ITEMS.register("tin_axe",
            () -> new AxeItem(SimpleOresTiers.TIN, 7.0F, -3.2F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> mythril_axe = ITEMS.register("mythril_axe",
            () -> new AxeItem(SimpleOresTiers.MYTHRIL, 5.0F, -3.2F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> adamantium_axe = ITEMS.register("adamantium_axe",
            () -> new AxeItem(SimpleOresTiers.ADAMANTIUM, 5.0F, -3.2F,
                    new Item.Properties()));
    public static final DeferredItem<AxeItem> onyx_axe = ITEMS.register("onyx_axe",
            () -> new AxeItem(SimpleOresTiers.ONYX, 4.0F, -3.0F,
                    new Item.Properties()));

    // shovels: constant dmg: 1.5, eff: -3.0
    public static final DeferredItem<ShovelItem> copper_shovel = ITEMS.register("copper_shovel",
            () -> new ShovelItem(SimpleOresTiers.COPPER, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> tin_shovel = ITEMS.register("tin_shovel",
            () -> new ShovelItem(SimpleOresTiers.TIN, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> mythril_shovel = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(SimpleOresTiers.MYTHRIL, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> adamantium_shovel = ITEMS.register("adamantium_shovel",
            () -> new ShovelItem(SimpleOresTiers.ADAMANTIUM, 1.5F, -3.0F,
                    new Item.Properties()));
    public static final DeferredItem<ShovelItem> onyx_shovel = ITEMS.register("onyx_shovel",
            () -> new ShovelItem(SimpleOresTiers.ONYX, 1.5F, -3.0F,
                    new Item.Properties()));

    // hoes: hoe dmg + tier dmg == 0; Eff: -3 for bad hoe materials, 0 for uber materials, rest in-between.
    public static final DeferredItem<HoeItem> copper_hoe = ITEMS.register("copper_hoe",
            () -> new HoeItem(SimpleOresTiers.COPPER,-1, -2.0F,
                    new Item.Properties()){});
    public static final DeferredItem<HoeItem> tin_hoe = ITEMS.register("tin_hoe",
            () -> new HoeItem(SimpleOresTiers.TIN,-1, -2.0F,
                    new Item.Properties()){});
    public static final DeferredItem<HoeItem> mythril_hoe = ITEMS.register("mythril_hoe",
            () -> new HoeItem(SimpleOresTiers.MYTHRIL,-3, -1.0F,
                    new Item.Properties()){});
    public static final DeferredItem<HoeItem> adamantium_hoe = ITEMS.register("adamantium_hoe",
            () -> new HoeItem(SimpleOresTiers.ADAMANTIUM, -3, -1.0F,
                    new Item.Properties()) {});
    public static final DeferredItem<HoeItem> onyx_hoe = ITEMS.register("onyx_hoe",
            () -> new HoeItem(SimpleOresTiers.ONYX, -5, 0.0F,
                    new Item.Properties()) {});

    // shears
    public static final DeferredItem<ShearsItem> copper_shears = ITEMS.register("copper_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.COPPER.getUses())
                    ));
    public static final DeferredItem<ShearsItem> tin_shears = ITEMS.register("tin_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.TIN.getUses())
                    ));
    public static final DeferredItem<ShearsItem> mythril_shears = ITEMS.register("mythril_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.MYTHRIL.getUses())
                    ));
    public static final DeferredItem<ShearsItem> adamantium_shears = ITEMS.register("adamantium_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.ADAMANTIUM.getUses())
                    ));
    public static final DeferredItem<ShearsItem> onyx_shears = ITEMS.register("onyx_shears",
            () -> new ShearsItem(new Item.Properties().durability(SimpleOresTiers.ONYX.getUses())
                    ));

    // ARMOR
    // copper
    public static final DeferredItem<ArmorItem> copper_helmet = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(SimpleOresConfig.copperArmorDurability))));
    public static final DeferredItem<ArmorItem> copper_leggings = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(
                            ArmorItem.Type.LEGGINGS.getDurability(SimpleOresConfig.copperArmorDurability))));
    public static final DeferredItem<ArmorItem> copper_chestplate = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(
                            ArmorItem.Type.CHESTPLATE.getDurability(SimpleOresConfig.copperArmorDurability))));
    public static final DeferredItem<ArmorItem> copper_boots = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(
                            ArmorItem.Type.BOOTS.getDurability(SimpleOresConfig.copperArmorDurability))));

    // tin
    public static final DeferredItem<ArmorItem> tin_helmet = ITEMS.register("tin_helmet",
            () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(SimpleOresConfig.tinArmorDurability))));
    public static final DeferredItem<ArmorItem> tin_leggings = ITEMS.register("tin_leggings",
            () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(
                            ArmorItem.Type.LEGGINGS.getDurability(SimpleOresConfig.tinArmorDurability))));
    public static final DeferredItem<ArmorItem> tin_chestplate = ITEMS.register("tin_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(
                            ArmorItem.Type.CHESTPLATE.getDurability(SimpleOresConfig.tinArmorDurability))));
    public static final DeferredItem<ArmorItem> tin_boots = ITEMS.register("tin_boots",
            () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(
                            ArmorItem.Type.BOOTS.getDurability(SimpleOresConfig.tinArmorDurability))));

    // mythril
    public static final DeferredItem<ArmorItem> mythril_helmet = ITEMS.register("mythril_helmet",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(SimpleOresConfig.mythrilArmorDurability))));
    public static final DeferredItem<ArmorItem> mythril_leggings = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(
                            ArmorItem.Type.LEGGINGS.getDurability(SimpleOresConfig.mythrilArmorDurability))));
    public static final DeferredItem<ArmorItem> mythril_chestplate = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(
                            ArmorItem.Type.CHESTPLATE.getDurability(SimpleOresConfig.mythrilArmorDurability))));
    public static final DeferredItem<ArmorItem> mythril_boots = ITEMS.register("mythril_boots",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(
                            ArmorItem.Type.BOOTS.getDurability(SimpleOresConfig.mythrilArmorDurability))));

    // adamantium
    public static final DeferredItem<ArmorItem> adamantium_helmet = ITEMS.register("adamantium_helmet",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(SimpleOresConfig.adamantiumArmorDurability))));
    public static final DeferredItem<ArmorItem> adamantium_leggings = ITEMS.register("adamantium_leggings",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(
                            ArmorItem.Type.LEGGINGS.getDurability(SimpleOresConfig.adamantiumArmorDurability))));
    public static final DeferredItem<ArmorItem> adamantium_chestplate = ITEMS.register("adamantium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(
                            ArmorItem.Type.CHESTPLATE.getDurability(SimpleOresConfig.adamantiumArmorDurability))));
    public static final DeferredItem<ArmorItem> adamantium_boots = ITEMS.register("adamantium_boots",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(
                            ArmorItem.Type.BOOTS.getDurability(SimpleOresConfig.adamantiumArmorDurability))));

    // onyx
    public static final DeferredItem<ArmorItem> onyx_helmet = ITEMS.register("onyx_helmet",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(
                            ArmorItem.Type.HELMET.getDurability(SimpleOresConfig.onyxArmorDurability))));
    public static final DeferredItem<ArmorItem> onyx_leggings = ITEMS.register("onyx_leggings",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(
                            ArmorItem.Type.LEGGINGS.getDurability(SimpleOresConfig.onyxArmorDurability))));
    public static final DeferredItem<ArmorItem> onyx_chestplate = ITEMS.register("onyx_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(
                            ArmorItem.Type.CHESTPLATE.getDurability(SimpleOresConfig.onyxArmorDurability))));
    public static final DeferredItem<ArmorItem> onyx_boots = ITEMS.register("onyx_boots",
            () -> new ArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(
                            ArmorItem.Type.BOOTS.getDurability(SimpleOresConfig.onyxArmorDurability))));
    
} // end class
