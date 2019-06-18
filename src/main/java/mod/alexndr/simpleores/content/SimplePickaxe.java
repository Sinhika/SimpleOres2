package mod.alexndr.simpleores.content;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

/**
 * another class that exists only because the parent tool class has a protected
 * constructor. WHY????
 */
public class SimplePickaxe extends PickaxeItem
{
    public SimplePickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}  // end class SimplePickaxe
