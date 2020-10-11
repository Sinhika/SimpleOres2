package mod.alexndr.simpleores.datagen;

import java.util.function.Consumer;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

/** 
 * RecipeProvider for SimpleOres.
 * @author Sinhika
 *
 */
public class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;
    
    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(SimpleOres.MODID);
    }

    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes() 
    
    protected void registerToolRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_COPPER), "copper", 
                                      hasItem(ModTags.Items.INGOTS_COPPER), flag("copper_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_TIN), "tin", 
                hasItem(ModTags.Items.INGOTS_TIN), flag("tin_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                hasItem(ModTags.Items.INGOTS_MYTHRIL), flag("mythril_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                hasItem(ModTags.Items.INGOTS_ADAMANTIUM), flag("adamantium_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.fromTag(ModTags.Items.GEMS_ONYX), "onyx", 
                hasItem(ModTags.Items.GEMS_ONYX), flag("onyx_tools"), true);
        
        setbuilder.buildModBowRecipe(consumer, ModItems.mythril_bow.getId(), Ingredient.fromTag(ModTags.Items.INGOTS_MYTHRIL), 
                ModItems.mythril_rod.get(), Ingredient.fromItems(Items.IRON_INGOT), hasItem(ModTags.Items.INGOTS_MYTHRIL), 
                flag("mod_bows"));
        
        setbuilder.buildModBowRecipe(consumer, ModItems.onyx_bow.getId(), Ingredient.fromTag(ModTags.Items.GEMS_ONYX), 
                ModItems.onyx_rod.get(), Ingredient.fromItems(Items.IRON_INGOT), hasItem(ModTags.Items.GEMS_ONYX), 
                flag("mod_bows"));
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_COPPER), "copper", 
                                       hasItem(ModTags.Items.INGOTS_COPPER), flag("copper_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_TIN), "tin", 
                hasItem(ModTags.Items.INGOTS_TIN), flag("tin_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                hasItem(ModTags.Items.INGOTS_MYTHRIL), flag("mythril_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                hasItem(ModTags.Items.INGOTS_ADAMANTIUM), flag("adamantium_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.fromTag(ModTags.Items.GEMS_ONYX), "onyx", 
                hasItem(ModTags.Items.GEMS_ONYX), flag("onyx_armor"));
    } // end registerArmorRecipes()
    
    protected void registerStorageRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.copper_ingot.get(), ModBlocks.copper_block.get(), 
                                             ModItems.copper_nugget.get(), hasItem(ModItems.copper_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.tin_ingot.get(), ModBlocks.tin_block.get(), 
                ModItems.tin_nugget.get(), hasItem(ModItems.tin_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.mythril_ingot.get(), ModBlocks.mythril_block.get(), 
                ModItems.mythril_nugget.get(), hasItem(ModItems.mythril_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.adamantium_ingot.get(), ModBlocks.adamantium_block.get(), 
                ModItems.adamantium_nugget.get(), hasItem(ModItems.adamantium_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.onyx_gem.get(), ModBlocks.onyx_block.get(), 
                null, hasItem(ModItems.onyx_gem.get()));
    } // end registerStorageRecipes()
    
    protected void registerMiscRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // copper bucket
        ResourceLocation copper_bucket_name = new ResourceLocation(SimpleOres.MODID, "copper_bucket");
        ConditionalRecipe.builder().addCondition(flag("copper_bucket"))
        .addRecipe(
            ShapedRecipeBuilder.shapedRecipe(ModItems.copper_bucket.get())
                .key('S', ModTags.Items.INGOTS_COPPER)
                .patternLine("S S")
                .patternLine(" S ")
                .addCriterion("has_item", hasItem(ModTags.Items.INGOTS_COPPER))
                ::build)
        .setAdvancement(copper_bucket_name, 
                      setbuilder.build_advancement_with_condition(copper_bucket_name, 
                              flag("copper_bucket"), hasItem(ModTags.Items.INGOTS_COPPER)))
        .build(consumer, copper_bucket_name);
       
    } // end registerMiscRecipes()

    protected void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModBlocks.adamantium_ore.get().asItem()), ModItems.adamantium_ingot.get(), 
                hasItem(ModBlocks.adamantium_ore.get().asItem()), 0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModBlocks.copper_ore.get().asItem()), ModItems.copper_ingot.get(), 
                hasItem(ModBlocks.copper_ore.get().asItem()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModBlocks.mythril_ore.get().asItem()), ModItems.mythril_ingot.get(), 
                hasItem(ModBlocks.mythril_ore.get().asItem()), 0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModBlocks.onyx_ore.get().asItem()), ModItems.onyx_gem.get(), 
                hasItem(ModBlocks.onyx_ore.get().asItem()), 1.0F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.fromItems(ModBlocks.tin_ore.get().asItem()), ModItems.tin_ingot.get(), 
                hasItem(ModBlocks.tin_ore.get().asItem()), 0.4F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.adamantium_axe.get(), ModItems.adamantium_boots.get(), ModItems.adamantium_chestplate.get(),
                        ModItems.adamantium_helmet.get(), ModItems.adamantium_hoe.get(), ModItems.adamantium_leggings.get(), 
                        ModItems.adamantium_pickaxe.get(),ModItems.adamantium_shovel.get(), ModItems.adamantium_sword.get()), 
                ModItems.adamantium_nugget.get(), hasItem(ModItems.adamantium_axe.get()), 
                0.3F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.tin_axe.get(), ModItems.tin_boots.get(), ModItems.tin_chestplate.get(),
                        ModItems.tin_helmet.get(), ModItems.tin_hoe.get(), ModItems.tin_leggings.get(), 
                        ModItems.tin_pickaxe.get(),ModItems.tin_shovel.get(), ModItems.tin_sword.get()), 
                ModItems.tin_nugget.get(), hasItem(ModItems.tin_axe.get()), 
                0.2F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.copper_axe.get(), ModItems.copper_boots.get(), ModItems.copper_chestplate.get(),
                        ModItems.copper_helmet.get(), ModItems.copper_hoe.get(), ModItems.copper_leggings.get(), 
                        ModItems.copper_pickaxe.get(),ModItems.copper_shovel.get(), ModItems.copper_sword.get(),
                        ModItems.copper_bucket.get()), 
                ModItems.copper_nugget.get(), hasItem(ModItems.copper_axe.get()), 
                0.2F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.fromItems(ModItems.mythril_axe.get(), ModItems.mythril_boots.get(), ModItems.mythril_chestplate.get(),
                        ModItems.mythril_helmet.get(), ModItems.mythril_hoe.get(), ModItems.mythril_leggings.get(), 
                        ModItems.mythril_pickaxe.get(),ModItems.mythril_shovel.get(), ModItems.mythril_sword.get()), 
                ModItems.mythril_nugget.get(), hasItem(ModItems.mythril_axe.get()), 
                0.4F, 200);
        
    } // end registerFurnaceRecipes()

    
    /**
     * Builds an ICondition representing FlagCondition...
     *
     */
    public ICondition flag(String name)
    {
        return impl_flag(SimpleOres.MODID, SimpleOresConfig.INSTANCE, name);
    }

} // end subclass Recipes.