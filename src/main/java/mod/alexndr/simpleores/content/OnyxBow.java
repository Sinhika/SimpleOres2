package mod.alexndr.simpleores.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * Custom bow that does extra damage (intrinsic POWER 2 enchantment) and sets
 * things on fire (intrinsic FLAME enchantment).
 */
public class OnyxBow extends BowItem
{
    public OnyxBow(Properties builder)
    {
        super(builder);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft)
    {
        // add the default enchantments for Onyx bow.
        ItemEnchantments oldEnchants = EnchantmentHelper.getEnchantmentsForCrafting(stack);
        stack = this.addOnyxEnchantments(oldEnchants, stack);

        super.releaseUsing(stack, worldIn, entityLiving, timeLeft);

        // remove temporary intrinsic enchantments.
        EnchantmentHelper.setEnchantments(stack, oldEnchants);
    }

    private ItemStack addOnyxEnchantments(ItemEnchantments oldEnch, ItemStack stack)
    {
        if (stack.isEmpty()) return stack;

        ItemEnchantments.Mutable enchMap = new ItemEnchantments.Mutable(oldEnch);

        // add intrinsic POWER enchantment only if bow does not already have
        // one >= 2.
        enchMap.upgrade(Enchantments.POWER, 2);
        enchMap.upgrade(Enchantments.FLAME, 1);

        // add intrinsic enchantments, if any.
        ItemEnchantments tmpEnchMap = enchMap.toImmutable();
        if (!tmpEnchMap.isEmpty()) {
            EnchantmentHelper.setEnchantments(stack, tmpEnchMap);
        }
        return stack;
    } // end addMythrilEnchantments()

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext pContext,
                                @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn)
    {
        super.appendHoverText(stack, pContext, tooltip, flagIn);
        tooltip.add(Component.translatable("tips.damage_tooltip").withStyle(ChatFormatting.GREEN));
        tooltip.add(Component.translatable("tips.flame_tooltip").withStyle(ChatFormatting.GREEN));
    }
    
    @Override
    public boolean isValidRepairItem(ItemStack pStack, ItemStack pRepairCandidate)
    {
        return this.getRepairIngredient().test(pRepairCandidate) || super.isValidRepairItem(pStack, pRepairCandidate);
    }
    
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ModItems.onyx_rod.get());
    }

}  // end class OnyxBow
