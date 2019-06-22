package mod.alexndr.simpleores.content;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tips.damageTooltip")).applyTextStyle(TextFormatting.GREEN));
        tooltip.add((new TranslationTextComponent("tips.efficiencyTooltip")).applyTextStyle(TextFormatting.GREEN));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Mythril bow.
        Map<Enchantment,Integer> oldEnchants = EnchantmentHelper.getEnchantments(stack);
        stack = this.addMythrilEnchantments(oldEnchants, stack);

        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);

        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(oldEnchants, stack);
    } // end onPlayerStoppedUsing()

    private ItemStack addMythrilEnchantments(Map<Enchantment,Integer> oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        Map<Enchantment,Integer> enchMap = new HashMap<>(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 2.
        if (! (enchMap.containsKey(Enchantments.POWER) && enchMap.get(Enchantments.POWER) > 1) )
        {
            enchMap.put(Enchantments.POWER, 2);
        }

        // add intrinsic INFINITY enchantment if RNG <= EFFICIENCY.
        if (! enchMap.containsKey(Enchantments.INFINITY))
        {
            if (rng.nextInt(100) < 50) enchMap.put(Enchantments.INFINITY, 1);
        }

        // add intrinsic enchantments, if any.
        if (enchMap.size() > 0) {
            EnchantmentHelper.setEnchantments(enchMap, stack);
        }
        return stack;
    } // end addMythrilEnchantments()
}  // end class MythrilBow
