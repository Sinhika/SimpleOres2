package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ModArmorMaterials
{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, SimpleOres.MODID);

    // We place copper somewhere between leather and chainmail.
    public static final Holder<ArmorMaterial> COPPER =
            ARMOR_MATERIALS.register("copper", () -> new ArmorMaterial(
                    // Determines the defense value of this armor material, depending on what armor piece it is.
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 2);
                        map.put(ArmorItem.Type.CHESTPLATE, 3);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 3);
                    }),
                    // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                    // Gold uses 25, we put copper slightly below that.
                    8,
                    // Determines the sound played when equipping this armor.
                    // This is wrapped with a Holder.
                    SoundEvents.ARMOR_EQUIP_CHAIN,
                    // Determines the repair item for this armor.
                    () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
                    // Determines the texture locations of the armor to apply when rendering
                    // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                    List.of(
                            // Creates a new armor texture that will be located at:
                            // - 'assets/mod_id/textures/models/armor/copper_layer_1.png' for the outer texture
                            // - 'assets/mod_id/textures/models/armor/copper_layer_2.png' for the inner texture (only legs)
                            new ArmorMaterial.Layer(
                                    new ResourceLocation(SimpleOres.MODID, "copper")
                            )
                    ),
                    // Returns the toughness value of the armor. The toughness value is an additional value included in
                    // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
                    // https://minecraft.wiki/w/Armor#Armor_toughness
                    // Only diamond and netherite have values greater than 0 here, so we just return 0.
                    0,
                    // Returns the knockback resistance value of the armor. While wearing this armor, the player is
                    // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
                    // from all armor pieces combined, they will not take any knockback at all.
                    // Only netherite has values greater than 0 here, so we just return 0.
                    0
            )); // end copper

    public static final Holder<ArmorMaterial> TIN = ARMOR_MATERIALS.register("tin", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 3);
            }),
            9, SoundEvents.ARMOR_EQUIP_CHAIN,
            () -> Ingredient.of(ModItems.tin_ingot.get()),
            List.of(new ArmorMaterial.Layer(new ResourceLocation(SimpleOres.MODID, "tin"))),
            0, 0));

    public static final Holder<ArmorMaterial> MYTHRIL = ARMOR_MATERIALS.register("mythril", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            12, SoundEvents.ARMOR_EQUIP_GOLD,
            () -> Ingredient.of(ModItems.mythril_ingot.get()),
            List.of(new ArmorMaterial.Layer(new ResourceLocation(SimpleOres.MODID, "mythril"))),
            0, 0));

    public static final Holder<ArmorMaterial> ADAMANTIUM = ARMOR_MATERIALS.register("adamantium", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 8);
            }),
            3, SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(ModItems.adamantium_ingot.get()),
            List.of(new ArmorMaterial.Layer(new ResourceLocation(SimpleOres.MODID, "adamantium"))),
            1, 0));

    public static final Holder<ArmorMaterial> ONYX = ARMOR_MATERIALS.register("onyx", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 5);
                map.put(ArmorItem.Type.BODY, 11);
            }),
            15, SoundEvents.ARMOR_EQUIP_TURTLE,
            () -> Ingredient.of(ModItems.onyx_gem.get()),
            List.of(new ArmorMaterial.Layer(new ResourceLocation(SimpleOres.MODID, "onyx"))),
            2, 0));

} // end class
