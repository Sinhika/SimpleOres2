package alexndr.plugins.SimpleOres.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.SimpleOres.ModInfo;
import alexndr.plugins.SimpleOres.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class AdamantiumConditionFactory implements IConditionFactory 
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":adamantium_tools_enabled")) {
			return () -> Settings.adamantiumTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":adamantium_armor_enabled")) {
			return () -> Settings.adamantiumArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":adamantium_block_enabled")) {
			return () -> Settings.adamantiumBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":adamantium_ingot_enabled")) {
			return () -> Settings.adamantiumIngot.isEnabled() == value;
		}
		return null;
	}

} // end class
