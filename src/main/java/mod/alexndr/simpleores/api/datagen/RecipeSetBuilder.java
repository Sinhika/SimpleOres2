package mod.alexndr.simpleores.api.datagen;

import java.util.function.Consumer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
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
public class RecipeSetBuilder extends AbstractRecipeSetBuilder
{
    public RecipeSetBuilder(String modid)
    {
        super(modid);
    }

    public ConditionalAdvancement.Builder build_advancement_with_condition(ResourceLocation recipe_id, ICondition condition,
                                                                            ICriterionInstance criterion)
    {
        return ConditionalAdvancement.builder()
                .addCondition(condition)
                .addAdvancement(
                        Advancement.Builder.builder()
                            .withParentId(new ResourceLocation("minecraft", "recipes/root"))
                            .withRewards(AdvancementRewards.Builder.recipe(recipe_id))
                            .withCriterion("has_item", criterion));
    }
    
    
    /**
     * 
     * @param consumer Used by a RecipeProvider to generate ore-to-ingot smelting and blasting recipes.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param oreIn ore ingredient.
     * @param ingotOut ingot or gem created from smelting/blasting oreIn.
     * @param criterion required to get the recipe advancement; usually hasItem()
     * @param experienceIn  smelting/blasting xp.
     * @param cookingTimeIn smelting cook time. Blasting time is automatically 1/2 that.
     */
    public void buildOre2IngotRecipes(Consumer<IFinishedRecipe> consumer, Ingredient oreIn, IItemProvider ingotOut,
            ICriterionInstance criterion, float experienceIn, int cookingTimeIn)
    {
        String recipe_name = ingotOut.asItem().toString() + "_from_smelting";
        CookingRecipeBuilder.smeltingRecipe(oreIn, ingotOut, experienceIn, cookingTimeIn)
            .addCriterion(recipe_name, criterion)
            .build(consumer, make_resource(recipe_name));

       recipe_name = ingotOut.asItem().toString() + "_from_blasting";
       CookingRecipeBuilder.blastingRecipe(oreIn, ingotOut, experienceIn, cookingTimeIn/2)
           .addCriterion(recipe_name, criterion)
           .build(consumer, make_resource(recipe_name));
    }
    
    /**
     * Used by a RecipeProvider to generate vanilla recycling to nuggets of a list of items-as-ingredients.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param ingredients items that can be recycled to yield nugget.
     * @param nugget output item
     * @param criterion required to get the recipe advancement; usually hasItem()
     */
    public void buildVanillaRecyclingRecipes(Consumer<IFinishedRecipe> consumer, Ingredient ingredients, 
                                             IItemProvider nugget, ICriterionInstance criterion, 
                                             float experienceIn, int cookingTimeIn)
    {
        String recipe_name = nugget.asItem().toString() + "_from_smelting";
        CookingRecipeBuilder.smeltingRecipe(ingredients, nugget, experienceIn, cookingTimeIn)
            .addCriterion(recipe_name, criterion)
            .build(consumer, make_resource(recipe_name));
            
        recipe_name = nugget.asItem().toString() + "_from_blasting";
        CookingRecipeBuilder.blastingRecipe(ingredients, nugget, experienceIn, cookingTimeIn/2)
            .addCriterion(recipe_name, criterion)
            .build(consumer, make_resource(recipe_name));
    } // end buildVanillaRecyclingRecipes
    
    /**
     * Used by a RecipeProvider to generate basic storage recipes for an ingot/block/nugget set.
     * These recipes are non-conditional.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param ingot item
     * @param block block
     * @param nugget item
     * @param criterion required to get the recipe advancement; usually hasItem()
     */
    public void buildSimpleStorageRecipes(Consumer<IFinishedRecipe> consumer, 
                                          IItemProvider ingot, IItemProvider block,
                                          IItemProvider nugget, ICriterionInstance criterion)
    {
        // block <=> ingots
        ShapelessRecipeBuilder.shapelessRecipe(ingot.asItem(), 9)
            .addIngredient(block.asItem())
            .addCriterion("has_item", criterion)
            .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(block.asItem())
            .key('S', ingot)
            .patternLine("SSS")
            .patternLine("SSS")
            .patternLine("SSS")
            .addCriterion("has_item", criterion)
            .build(consumer);
        
        // ingot <=> nuggets
        if (nugget != null)
        {
            String ingot_name = ingot.asItem().toString();
                    
            ShapelessRecipeBuilder.shapelessRecipe(nugget.asItem(), 9)
                .addIngredient(ingot)
                .addCriterion("has_item", criterion)
                .build(consumer);
            
            ShapedRecipeBuilder.shapedRecipe(ingot)
                .key('S', nugget.asItem())
                .patternLine("SSS")
                .patternLine("SSS")
                .patternLine("SSS")
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(ingot_name + "_from_nuggets"));
        }
    } // end buildSimpleStorageRecipes
    
    
    public void buildChunkConversionRecipes(Consumer<IFinishedRecipe> consumer, IItemProvider nugget,
                                            IItemProvider medium_chunk, IItemProvider large_chunk, 
                                            ICriterionInstance criterion)
    {
        String nugget_name = nugget.asItem().toString();
        
        if (medium_chunk != null)
        {
            String mchunk_name = medium_chunk.asItem().toString();
            
            // nuggets to medium chunk,
            ShapedRecipeBuilder.shapedRecipe(medium_chunk)
                .key('S', nugget.asItem())
                .patternLine("SS")
                .patternLine("SS")
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(mchunk_name + "_from_nuggets"));
                
            // medium chunk to nuggets
            ShapelessRecipeBuilder.shapelessRecipe(nugget.asItem(), 4)
                .addIngredient(medium_chunk)
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(nugget_name + "_from_medium_chunk"));
        }
        if (large_chunk != null && medium_chunk != null)
        {
            String lchunk_name = large_chunk.asItem().toString();
            String mchunk_name = medium_chunk.asItem().toString();
            
            // large chunk to medium chunks
            ShapelessRecipeBuilder.shapelessRecipe(medium_chunk.asItem(), 2)
                .addIngredient(large_chunk)
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(mchunk_name + "_from_large_chunk"));
            
            // medium chunks + nugget to large chunk
            ShapelessRecipeBuilder.shapelessRecipe(large_chunk.asItem())
                .addIngredient(medium_chunk, 2)
                .addIngredient(nugget)
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(lchunk_name + "_from_medium_chunks"));
            
            // nuggets & medium chunk to large chunk.
            ShapelessRecipeBuilder.shapelessRecipe(large_chunk.asItem())
                .addIngredient(nugget, 5)
                .addIngredient(medium_chunk)
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(lchunk_name + "_from_nuggets"));
           
        } // end-if large_chunk && medium_chunk
        else if (large_chunk != null)
        {
            // large chunk to nuggets
            ShapelessRecipeBuilder.shapelessRecipe(nugget.asItem(), 8)
                .addIngredient(large_chunk)
                .addCriterion("has_item", criterion)
                .build(consumer, make_resource(nugget_name + "_from_large_chunk"));
        } // end else-if just large_chunk exists.
    } // end buildChunkConversionRecipes
    
    
    /**
     * Used by a RecipeProvider to generate rod and mod bow recipes (that follow the usual pattern), 
     * optionally with a condition.
     *
     */
    public void buildModBowRecipe(Consumer<IFinishedRecipe> consumer, ResourceLocation bow_name, Ingredient rod_material,
            Item rod, Ingredient keystone, ICriterionInstance criterion, ICondition condition)
    {
            Item bow = ForgeRegistries.ITEMS.getValue(bow_name);
            Ingredient string = Ingredient.fromTag(Tags.Items.STRING);
                    
            ShapedRecipeBuilder.shapedRecipe(rod)
                .key('S', rod_material)
                .patternLine("S")
                .patternLine("S")
                .addCriterion("has_item", criterion)
                .build(consumer);
            
            if (condition==null)
            {
                ShapedRecipeBuilder.shapedRecipe(bow)
                    .key('X', rod)
                    .key('Y', string)
                    .key('Z', keystone)
                    .patternLine(" XY")
                    .patternLine("Z Y")
                    .patternLine(" XY")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            } // end-if no condition
            else {
                ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(bow)
                    .key('X', rod)
                    .key('Y', string)
                    .key('Z', keystone)
                    .patternLine(" XY")
                    .patternLine("Z Y")
                    .patternLine(" XY")
                    .addCriterion("has_item", criterion)               
                    ::build)
                .setAdvancement(bow_name, build_advancement_with_condition(bow_name, condition, criterion))
                .build(consumer, bow_name);
            } // end-else condition
    } // end buildModBowRecipe()
    
    
    /**
     * Used by a RecipeProvider to generate recipe sets for armor sets. Based heavily on
     * Botania's registerSimpleArmorSet() method.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param item what the armor is made from.
     * @param variant first part of armor piece name, like 'copper' or 'ubermetal'
     * @param criterion required to get the recipe advancement; usually hasItem()
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
                .setAdvancement(helmet_name, build_advancement_with_condition(helmet_name, condition, criterion))
                .build(consumer, helmet_name);
            
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(chestplate)
                        .key('S',item)
                        .patternLine("S S")
                        .patternLine("SSS")
                        .patternLine("SSS")
                        .addCriterion("has_item", criterion)
                        ::build)
                .setAdvancement(chestplate_name, build_advancement_with_condition(chestplate_name, condition, criterion))
                .build(consumer, chestplate_name);
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(leggings)
                        .key('S', item)
                        .patternLine("SSS")
                        .patternLine("S S")
                        .patternLine("S S")
                        .addCriterion("has_item", criterion)
                        ::build)
                .setAdvancement(leggings_name, build_advancement_with_condition(leggings_name, condition, criterion))
                .build(consumer, leggings_name);
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(ShapedRecipeBuilder.shapedRecipe(boots)
                        .key('S', item)
                        .patternLine("   ")
                        .patternLine("S S")
                        .patternLine("S S")
                        .addCriterion("has_item", criterion)
                        ::build)
                .setAdvancement(boots_name, build_advancement_with_condition(boots_name, condition, criterion))
                .build(consumer, boots_name);
        } // else has condition
    } // end buildSimpleArmorSet()
    
    /**
     * Used by a RecipeProvider to generate recipe sets for tool sets. Based heavily on
     * Botania's registerToolSetRecipes() method.
     * 
     * @param consumer passed in from RecipeProvider to builder() call.
     * @param item what the tools are made from, besides sticks.
     * @param variant first part of the tool name, like 'copper' or 'ubermetal'
     * @param criterion required to get the recipe advancement; usually hasItem().
     * @param condition null for no conditions, ICondition object for a conditional recipe.
     * @param has_shears true if there is a shears for this variant, false if no shears.
     */
    public void buildSimpleToolSet(Consumer<IFinishedRecipe> consumer, Ingredient item,
            String variant, ICriterionInstance criterion, ICondition condition, boolean has_shears )
    {
        ResourceLocation sword_name = make_resource(variant + "_sword");
        ResourceLocation pickaxe_name = make_resource(variant + "_pickaxe");
        ResourceLocation axe_name = make_resource(variant + "_axe");
        ResourceLocation shovel_name = make_resource(variant + "_shovel");
        ResourceLocation hoe_name = make_resource(variant + "_hoe");
        ResourceLocation shears_name = has_shears ? make_resource(variant + "_shears") : null;
        
        Ingredient stick = Ingredient.fromTag(Tags.Items.RODS_WOODEN);
        Item sword = ForgeRegistries.ITEMS.getValue(sword_name);
        Item pickaxe = ForgeRegistries.ITEMS.getValue(pickaxe_name);
        Item axe = ForgeRegistries.ITEMS.getValue(axe_name);
        Item shovel = ForgeRegistries.ITEMS.getValue(shovel_name);
        Item hoe = ForgeRegistries.ITEMS.getValue(hoe_name);
        Item shears = has_shears ? ForgeRegistries.ITEMS.getValue(shears_name) : null;

        if (condition==null) 
        {
            // sword
            ShapedRecipeBuilder.shapedRecipe(sword)
                .key('S', item)
                .key('T', stick)
                .patternLine(" S ")
                .patternLine(" S ")
                .patternLine(" T ")
                .addCriterion("has_item", criterion)
                .build(consumer);
            
            // axe
            if (axe != null) {
                ShapedRecipeBuilder.shapedRecipe(axe)
                    .key('S', item)
                    .key('T', stick)
                    .patternLine("SS ")
                    .patternLine("ST ")
                    .patternLine(" T ")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            }
            
            // hoe
            if (hoe != null) {
                ShapedRecipeBuilder.shapedRecipe(hoe)
                    .key('S', item)
                    .key('T', stick)
                    .patternLine("SS ")
                    .patternLine(" T ")
                    .patternLine(" T ")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            }
            
            // pickaxe
            if (pickaxe != null) {
                ShapedRecipeBuilder.shapedRecipe(pickaxe)
                    .key('S', item)
                    .key('T', stick)
                    .patternLine("SSS")
                    .patternLine(" T ")
                    .patternLine(" T ")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            }
            
            // shovel
            if (shovel != null)
            {
                ShapedRecipeBuilder.shapedRecipe(shovel)
                    .key('S', item)
                    .key('T', stick)
                    .patternLine(" S ")
                    .patternLine(" T ")
                    .patternLine(" T ")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            }
            
            if (has_shears && shears != null) 
            {
                ShapedRecipeBuilder.shapedRecipe(shears)
                    .key('S', item)
                    .patternLine(" S")
                    .patternLine("S ")
                    .addCriterion("has_item", criterion)
                    .build(consumer);
            }
        } // end condition null
        else 
        {
            // sword
            ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(
                    ShapedRecipeBuilder.shapedRecipe(sword)
                        .key('S', item)
                        .key('T', stick)
                        .patternLine(" S ")
                        .patternLine(" S ")
                        .patternLine(" T ")
                        .addCriterion("has_item", criterion)
                        ::build)
                .setAdvancement(sword_name, build_advancement_with_condition(sword_name, condition, criterion))
                .build(consumer, sword_name);

            // pickaxe
            if (pickaxe != null) {
                ConditionalRecipe.builder().addCondition(condition)
                    .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(pickaxe)
                            .key('S', item)
                            .key('T', stick)
                            .patternLine("SSS")
                            .patternLine(" T ")
                            .patternLine(" T ")
                            .addCriterion("has_item", criterion)
                            ::build)
                    .setAdvancement(pickaxe_name, build_advancement_with_condition(pickaxe_name, condition, criterion))
                    .build(consumer, pickaxe_name);
            }
            
            // axe
            if (axe != null) {
                ConditionalRecipe.builder().addCondition(condition)
                    .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(axe)
                            .key('S', item)
                            .key('T', stick)
                            .patternLine("SS ")
                            .patternLine("ST ")
                            .patternLine(" T ")
                            .addCriterion("has_item", criterion)
                            ::build)
                   .setAdvancement(axe_name, build_advancement_with_condition(axe_name, condition, criterion))
                   .build(consumer, axe_name);
            }
            // shovel
            if (shovel != null) {
                ConditionalRecipe.builder().addCondition(condition)
                    .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(shovel)
                            .key('S', item)
                            .key('T', stick)
                            .patternLine(" S ")
                            .patternLine(" T ")
                            .patternLine(" T ")
                            .addCriterion("has_item", criterion)
                            ::build)
                    .setAdvancement(shovel_name, build_advancement_with_condition(shovel_name, condition, criterion))
                    .build(consumer, shovel_name);
            }
            // hoe
            if (hoe != null) {
                ConditionalRecipe.builder().addCondition(condition)
                    .addRecipe(
                        ShapedRecipeBuilder.shapedRecipe(hoe)
                            .key('S', item)
                            .key('T', stick)
                            .patternLine("SS ")
                            .patternLine(" T ")
                            .patternLine(" T ")
                            .addCriterion("has_item", criterion)
                            ::build)
                    .setAdvancement(hoe_name, build_advancement_with_condition(hoe_name, condition, criterion))
                    .build(consumer, hoe_name);
            }
            // shears
            if (has_shears && shears != null) {
                ConditionalRecipe.builder().addCondition(condition)
                    .addRecipe(
                            ShapedRecipeBuilder.shapedRecipe(shears)
                            .key('S', item)
                            .patternLine(" S")
                            .patternLine("S ")
                            .addCriterion("has_item", criterion)
                            ::build)
                    .setAdvancement(shears_name, build_advancement_with_condition(shears_name, condition, criterion))
                    .build(consumer, shears_name);
            }
        } // else has condition
    } // end buildSimpleToolSet()
    
} // end class
