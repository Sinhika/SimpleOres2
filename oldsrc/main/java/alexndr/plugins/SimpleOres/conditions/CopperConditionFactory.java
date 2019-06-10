package alexndr.plugins.SimpleOres.conditions;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import alexndr.plugins.SimpleOres.ModInfo;
import alexndr.plugins.SimpleOres.Settings;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class CopperConditionFactory implements IConditionFactory 
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		boolean value = JsonUtils.getBoolean(json , "value", true);
		String key = JsonUtils.getString(json, "type");
		
		if (key.equals(ModInfo.ID + ":copper_tools_enabled")) {
			return () -> Settings.copperTools.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":copper_armor_enabled")) {
			return () -> Settings.copperArmor.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":copper_block_enabled")) {
			return () -> Settings.copperBlock.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":copper_ingot_enabled")) {
			return () -> Settings.copperIngot.isEnabled() == value;
		}
		else if (key.equals(ModInfo.ID + ":copper_bucket_enabled")) {
			return () -> Settings.copperBucket.isEnabled() == value;
		}
		return null;
	}

} // end class
