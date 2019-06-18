package mod.alexndr.simpleores.content;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum SimpleOresItemTier implements IItemTier
{
   COPPER(1, 185, 4.0F, 1.0F, 8, ()->{ return Ingredient.fromItems( ModItems.copper_ingot); }),
   TIN(1, 220, 3.5F, 1.0F, 8, ()->{ return Ingredient.fromItems( ModItems.tin_ingot); }),
   MYTHRIL(2, 800, 8.0F, 3.0F, 12, ()->{ return Ingredient.fromItems( ModItems.mythril_ingot); }),
   ADAMANTIUM(2, 1150, 14.0F, 3.0F, 3, ()->{ return Ingredient.fromItems( ModItems.adamantium_ingot); }),
   ONYX(4, 3280, 10.0F, 5.0F, 15, ()->{ return Ingredient.fromItems( ModItems.onyx_gem); });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private SimpleOresItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
                    Supplier<Ingredient> repairMaterialIn)
   {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
   }

   @Override
   public int getMaxUses() {
      return this.maxUses;
   }

   @Override
   public float getEfficiency() {
      return this.efficiency;
   }

   @Override
   public float getAttackDamage() {
      return this.attackDamage;
   }

   @Override
   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   @Override
   public int getEnchantability() {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}  // end class SimpleOresItemTier
