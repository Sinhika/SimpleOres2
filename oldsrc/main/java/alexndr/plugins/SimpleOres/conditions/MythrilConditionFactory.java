package alexndr.plugins.SimpleOres.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.SimpleOres.ModInfo;
import alexndr.plugins.SimpleOres.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class MythrilConditionFactory implements IConditionFactory 
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":mythril_tools_enabled")) {
			return () -> Settings.mythrilTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":mythril_armor_enabled")) {
			return () -> Settings.mythrilArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":mythril_block_enabled")) {
			return () -> Settings.mythrilBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":mythril_ingot_enabled")) {
			return () -> Settings.mythrilIngot.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":mythril_rod_enabled")) {
			return () -> Settings.mythrilRod.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":mythril_bow_enabled")) {
			return () -> Settings.mythrilBow.isEnabled() == value;
		}
		return null;
	}

} // end class
