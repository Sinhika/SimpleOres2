package mod.alexndr.simpleores.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

/**
 *  A bow with some special features: Efficiency, which makes it act like an
 *  INFINITY bow sometimes, and extra damage (equivalent to POWER 2).
 */
public class MythrilBow extends BowItem
{
    private static final int EFFICIENCY = 50;
    private Random rng;

    public MythrilBow(Properties builder)
    {
        super(builder);
        rng = new Random();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslatableComponent("tips.damage_tooltip")).withStyle(ChatFormatting.GREEN));
        tooltip.add((new TranslatableComponent("tips.efficiency_tooltip")).withStyle(ChatFormatting.GREEN));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Mythril bow.
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(stack);
        stack = this.addMythrilEnchantments(oldEnchants, stack);

        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);

        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(oldEnchants, stack);
    } // end onPlayerStoppedUsing()

    private ItemStack addMythrilEnchantments(Map<Enchantment,Integer> oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        Map<Enchantment,Integer> enchMap = new HashMap<>(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 2.
        if (! (enchMap.containsKey(Enchantments.POWER_ARROWS) && enchMap.get(Enchantments.POWER_ARROWS) > 1) )
        {
            enchMap.put(Enchantments.POWER_ARROWS, 2);
        }

        // add intrinsic INFINITY enchantment if RNG <= EFFICIENCY.
        if (! enchMap.containsKey(Enchantments.INFINITY_ARROWS))
        {
            if (rng.nextInt(100) < EFFICIENCY) enchMap.put(Enchantments.INFINITY_ARROWS, 1);
        }

        // add intrinsic enchantments, if any.
        if (enchMap.size() > 0) {
            EnchantmentHelper.setEnchantments(enchMap, stack);
        }
        return stack;
    } // end addMythrilEnchantments()
}  // end class MythrilBow
