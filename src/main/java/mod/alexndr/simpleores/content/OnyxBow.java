package mod.alexndr.simpleores.content;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Custom bow that does extra damage (intrinsic POWER 2 enchantment) and sets
 * things on fire (intrinsic FLAME enchantment).
 */
public class OnyxBow extends BowItem
{
    private Random rng;

    public OnyxBow(Properties builder)
    {
        super(builder);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Onyx bow.
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(stack);
        stack = this.addOnyxEnchantments(oldEnchants, stack);

        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);

        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(oldEnchants, stack);
    }

    private ItemStack addOnyxEnchantments(Map<Enchantment,Integer> oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        Map<Enchantment,Integer> enchMap = new HashMap<>(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 2.
        if (! (enchMap.containsKey(Enchantments.POWER) && enchMap.get(Enchantments.POWER) > 1) )
        {
            enchMap.put(Enchantments.POWER, 2);
        }

        if (! enchMap.containsKey(Enchantments.FLAME)) enchMap.put(Enchantments.FLAME, 1);

        // add intrinsic enchantments, if any.
        if (enchMap.size() > 0) {
            EnchantmentHelper.setEnchantments(enchMap, stack);
        }
        return stack;
    } // end addMythrilEnchantments()

}  // end class OnyxBow
