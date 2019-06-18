package mod.alexndr.simpleores.content;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

/**
 * The only reason this class exists is because some idiot made AxeItem have a
 * protected constructor. WHY??
 */
public class SimpleAxe extends AxeItem
{
  public SimpleAxe(IItemTier tier, float attackDamageIn, float attackSpeedIn,
                   Item.Properties builder)
  {
      super(tier, attackDamageIn, attackSpeedIn, builder);
  }
}  // end class SimpleAxe
