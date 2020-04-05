package mod.alexndr.simpleores.helpers;

import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class ShearsLootModifier extends LootModifier 
{
	public ShearsLootModifier(ILootCondition[] conditionsIn) {
		super(conditionsIn);
	} // end ctor

	/**
	 * For our mod shears: pretend that genuine minecraft:shears were applied to the loot table, 
	 * then see what you get.
	 */
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) 
	{
		ItemStack fakeShears = new ItemStack(Items.SHEARS);
        LootContext.Builder builder = new LootContext.Builder(context);
        builder.withParameter(LootParameters.TOOL, fakeShears);
        LootContext ctx = builder.build(LootParameterSets.BLOCK);
        LootTable loottable = context.getWorld().getServer().getLootTableManager()
        							 .getLootTableFromLocation(context.get(LootParameters.BLOCK_STATE).getBlock().getLootTable());
        return loottable.generate(ctx);		
	} // end doApply()

	public static class Serializer extends GlobalLootModifierSerializer<ShearsLootModifier> 
	{
		/**
		 * No special serialization handling needed; just pass ILootCondition list to constructor.
		 */
		@Override
		public ShearsLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) 
		{
			return new ShearsLootModifier(ailootcondition);
		} // end read()
	} // end class Serializer

} // end class ShearsLootModifier
