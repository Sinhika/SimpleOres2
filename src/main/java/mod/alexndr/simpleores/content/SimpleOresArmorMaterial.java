package mod.alexndr.simpleores.content;

import java.util.function.Supplier;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;

public enum SimpleOresArmorMaterial implements ArmorMaterial
{
    COPPER ("simpleores:copper", 8, new int [] {1,2,3,2}, 8,
            SoundEvents.ARMOR_EQUIP_CHAIN , 0.0F,
            ()-> { return Ingredient.of(Items.COPPER_INGOT);} ),
    TIN ("simpleores:tin", 9, new int [] {1,2,3,2}, 8,
         SoundEvents.ARMOR_EQUIP_CHAIN , 0.0F,
            ()-> { return Ingredient.of(ModItems.tin_ingot.get());} ),
    MYTHRIL ("simpleores:mythril", 22, new int [] {3,4,5,3}, 12,
             SoundEvents.ARMOR_EQUIP_GOLD, 0.0F,
            ()-> { return Ingredient.of(ModItems.mythril_ingot.get());} ),
    ADAMANTIUM("simpleores:adamantium", 28, new int [] {2,6,8,3}, 3, SoundEvents.ARMOR_EQUIP_IRON, 1.0F,
            ()-> { return Ingredient.of(ModItems.adamantium_ingot.get());} ),
    ONYX("simpleores:onyx", 45, new int [] {5,6,8,5}, 15, SoundEvents.ARMOR_EQUIP_GOLD, 2.0F,
            ()-> { return Ingredient.of(ModItems.onyx_gem.get());} );

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;

    private SimpleOresArmorMaterial(String nameIn, int maxDamageIn, int[] drAmtArray,
                                    int enchantabilityIn, SoundEvent soundIn,
                                    float toughnessIn,
                                    Supplier<Ingredient> repairMatIn)
    {
        name = nameIn;
        maxDamageFactor = maxDamageIn;
        damageReductionAmountArray = drAmtArray;
        enchantability = enchantabilityIn;
        soundEvent = soundIn;
        toughness = toughnessIn;
        repairMaterial = Lazy.of(repairMatIn);
    } // end ctor()

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        // TODO Auto-generated method stub
        return 0;
    }
}  // end class SimpleOresArmorMaterial
