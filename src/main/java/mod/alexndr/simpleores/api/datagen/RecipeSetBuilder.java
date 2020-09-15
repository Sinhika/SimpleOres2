package mod.alexndr.simpleores.api.datagen;

import java.util.function.Consumer;

import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Stash functions to assemble standard recipe sets (tools, armors, storage) here.
 * Used by RecipeProviders.
 * 
 * @author Sinhika
 *
 */
public class RecipeSetBuilder
{
    protected final String modid;
    
    public RecipeSetBuilder(String modid)
    {
        this.modid = modid;
    }

    public ResourceLocation make_resource(String path) {
        return new ResourceLocation(this.modid, path);
    }

    /**
     * Used by a RecipeProvider to generate recipe sets for armor sets. Based heavily on
     * Botania's registerSimpleArmorSet() method.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param item what the armor is made from.
     * @param variant first part of armor piece name, like 'copper' or 'ubermetal'
     * @param criterion item to get the recipe advancement
     * @param condition null for no conditions, ICondition object for a conditional recipe.
     */
    public void buildSimpleArmorSet(Consumer<IFinishedRecipe> consumer, Ingredient item, 
                                    String variant, ICriterionInstance criterion, ICondition condition)
    {
        ResourceLocation helmet_name = make_resource(variant + "_helmet");
        ResourceLocation chestplate_name = make_resource(variant + "_chestplate");
        ResourceLocation leggings_name = make_resource(variant + "_leggings");
        ResourceLocation boots_name = make_resource(variant + "_boots");
        
        Item helmet = ForgeRegistries.ITEMS.getValue(helmet_name);
        Item chestplate = ForgeRegistries.ITEMS.getValue(chestplate_name);
        Item leggings = ForgeRegistries.ITEMS.getValue(leggings_name);
        Item boots = ForgeRegistries.ITEMS.getValue(boots_name);
    
        if (condition==null) 
        {
            ShapedRecipeBuilder.shapedRecipe(helmet)
                .key('S', item)
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("   ")
                .addCriterion("has_item", criterion)
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(chestplate)
                .key('S',item)
                .patternLine("S S")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", criterion)
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(leggings)
                .key('S', item)
                .patternLine("SSS")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", criterion)
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(boots)
                .key('S', item)
                .patternLine("   ")
                .patternLine("S S")
                .patternLine("S S")
                .addCriterion("has_item", criterion)
                .build(consumer);
        } // end condition null
        else 
        {
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(helmet)
                        .key('S', item)
                        .patternLine("SSS")
                        .patternLine("S S")
                        .patternLine("   ")
                        .addCriterion("has_item", criterion)
                        ::build)
                .build(consumer, helmet_name);
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(chestplate)
                        .key('S',item)
                        .patternLine("S S")
                        .patternLine("SSS")
                        .patternLine("SSS")
                        .addCriterion("has_item", criterion)
                        ::build)
                .build(consumer, chestplate_name);
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(leggings)
                        .key('S', item)
                        .patternLine("SSS")
                        .patternLine("S S")
                        .patternLine("S S")
                        .addCriterion("has_item", criterion)
                        ::build)
                .build(consumer, leggings_name);
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(boots)
                        .key('S', item)
                        .patternLine("   ")
                        .patternLine("S S")
                        .patternLine("S S")
                        .addCriterion("has_item", criterion)
                        ::build)
                .build(consumer, boots_name);
        } // else has condition
    } // end buildSimpleArmorSet
    
    
} // end class
