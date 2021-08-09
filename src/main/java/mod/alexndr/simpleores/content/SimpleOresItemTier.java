package mod.alexndr.simpleores.content;

import java.util.function.Supplier;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

public enum SimpleOresItemTier implements Tier
{
   COPPER(1, 185, 4.0F, 1.0F, 8, ()->{ return Ingredient.of(Items.COPPER_INGOT); }),
   TIN(1, 220, 3.5F, 1.0F, 8, ()->{ return Ingredient.of( ModItems.tin_ingot.get()); }),
   MYTHRIL(2, 800, 8.0F, 3.0F, 12, ()->{ return Ingredient.of( ModItems.mythril_ingot.get()); }),
   ADAMANTIUM(2, 1150, 14.0F, 3.0F, 3, ()->{ return Ingredient.of( ModItems.adamantium_ingot.get()); }),
   ONYX(4, 3280, 10.0F, 5.0F, 15, ()->{ return Ingredient.of( ModItems.onyx_gem.get()); });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final Lazy<Ingredient> repairMaterial;

   private SimpleOresItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                    Supplier<Ingredient> repairMaterialIn)
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = Lazy.of(repairMaterialIn);
   }

   @Override
   public int getUses() {
      return this.maxUses;
   }

   @Override
   public float getSpeed() {
      return this.efficiency;
   }

   @Override
   public float getAttackDamageBonus() {
      return this.attackDamage;
   }

   @Override
   public int getLevel() {
      return this.harvestLevel;
   }

   @Override
   public int getEnchantmentValue() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairIngredient() {
      return this.repairMaterial.get();
   }
}  // end class SimpleOresItemTier
