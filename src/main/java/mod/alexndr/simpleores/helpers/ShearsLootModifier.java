package mod.alexndr.simpleores.helpers;

import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class ShearsLootModifier extends LootModifier {

	public ShearsLootModifier(ILootCondition[] conditionsIn) 
	{
		super(conditionsIn);
		// TODO Auto-generated constructor stub
	} // end ctor

	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) 
	{
		// TODO Auto-generated method stub
		return null;
	} // end doApply()

	public static class Serializer extends GlobalLootModifierSerializer<ShearsLootModifier> 
	{
		@Override
		public ShearsLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) 
		{
			// TODO Auto-generated method stub
			return null;
		} // end read()
	} // end class Serializer

} // end class ShearsLootModifier
