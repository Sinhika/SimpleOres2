package alexndr.plugins.SimpleOres.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.SimpleOres.ModInfo;
import alexndr.plugins.SimpleOres.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class TinConditionFactory implements IConditionFactory 
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":tin_tools_enabled")) {
			return () -> Settings.tinTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":tin_armor_enabled")) {
			return () -> Settings.tinArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":tin_block_enabled")) {
			return () -> Settings.tinBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":tin_ingot_enabled")) {
			return () -> Settings.tinIngot.isEnabled() == value;
		}
		return null;
	}

} // end class
