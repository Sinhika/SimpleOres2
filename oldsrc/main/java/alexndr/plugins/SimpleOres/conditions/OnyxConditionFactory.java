package alexndr.plugins.SimpleOres.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.SimpleOres.ModInfo;
import alexndr.plugins.SimpleOres.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class OnyxConditionFactory implements IConditionFactory 
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":onyx_tools_enabled")) {
			return () -> Settings.onyxTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":onyx_armor_enabled")) {
			return () -> Settings.onyxArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":onyx_block_enabled")) {
			return () -> Settings.onyxBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":onyx_gem_enabled")) {
			return () -> Settings.onyxGem.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":onyx_rod_enabled")) {
			return () -> Settings.onyxRod.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":onyx_bow_enabled")) {
			return () -> Settings.onyxBow.isEnabled() == value;
		}
		return null;
	}

} // end class
