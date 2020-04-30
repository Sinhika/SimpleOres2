package mod.alexndr.simpleores.api.config;

import com.google.gson.JsonObject;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class FlagCondition implements ICondition
{
    private final ISimpleConfig config;
    private final ResourceLocation resource;
    private final String name;
    
    /**
     * A new condition flag, used in recipes.
     *  Use:   {
                  "type": "simpleores:flag",
                  "flag": "copper_tools"
                }
     * @param cfg - this module's config class.
     * @param name - the flag name, e.g. "copper_tools"
     * @param resource - the flag id, e.g. "simpleores:flag"
     */
    public FlagCondition(ISimpleConfig cfg, String name, ResourceLocation resource)
    {
        this.config = cfg;
        this.name = name;
        this.resource = resource;
    }

    @Override
    public ResourceLocation getID()
    {
        return resource;
    }

    @Override
    public boolean test()
    {
        return config.getFlag(this.name);
    }

    public static class Serializer implements IConditionSerializer<FlagCondition>
    {
        private final ISimpleConfig config;
        private final ResourceLocation resource;
        
        /**
         * constructor for the FlagCondition serializer.
         * @param config - this module's config class.
         * @param resource - same id as FlagCondition, e.g. "simpleores:flag"
         */
        public Serializer(ISimpleConfig config, ResourceLocation resource)
        {
            this.config = config;
            this.resource = resource;
        }

        @Override
        public void write(JsonObject json, FlagCondition value)
        {
            json.addProperty("flag", value.name);
        }

        @Override
        public FlagCondition read(JsonObject json)
        {
            return new FlagCondition(config, json.getAsJsonPrimitive("flag").getAsString(), resource);
        }

        @Override
        public ResourceLocation getID() {
            return resource;
        }
    } // end-class-Serializer
} // end-class
