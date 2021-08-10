package mod.alexndr.simpleores.datagen;

import java.util.function.Consumer;

import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerStorageRecipes(consumer);
        registerMiscRecipes(consumer);
        registerToolRecipes(consumer);
        registerArmorRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes() 
    
    protected void registerToolRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_COPPER), "copper", 
                                      has(ModTags.Items.INGOTS_COPPER), flag("copper_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_TIN), "tin", 
                has(ModTags.Items.INGOTS_TIN), flag("tin_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                has(ModTags.Items.INGOTS_MYTHRIL), flag("mythril_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                has(ModTags.Items.INGOTS_ADAMANTIUM), flag("adamantium_tools"), true);
        setbuilder.buildSimpleToolSet(consumer, Ingredient.of(ModTags.Items.GEMS_ONYX), "onyx", 
                has(ModTags.Items.GEMS_ONYX), flag("onyx_tools"), true);
        
        setbuilder.buildModBowRecipe(consumer, ModItems.mythril_bow.getId(), Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), 
                ModItems.mythril_rod.get(), Ingredient.of(Items.IRON_INGOT), has(ModTags.Items.INGOTS_MYTHRIL), 
                flag("mod_bows"));
        
        setbuilder.buildModBowRecipe(consumer, ModItems.onyx_bow.getId(), Ingredient.of(ModTags.Items.GEMS_ONYX), 
                ModItems.onyx_rod.get(), Ingredient.of(Items.IRON_INGOT), has(ModTags.Items.GEMS_ONYX), 
                flag("mod_bows"));
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_COPPER), "copper", 
                                       has(ModTags.Items.INGOTS_COPPER), flag("copper_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_TIN), "tin", 
                has(ModTags.Items.INGOTS_TIN), flag("tin_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                has(ModTags.Items.INGOTS_MYTHRIL), flag("mythril_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                has(ModTags.Items.INGOTS_ADAMANTIUM), flag("adamantium_armor"));
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModTags.Items.GEMS_ONYX), "onyx", 
                has(ModTags.Items.GEMS_ONYX), flag("onyx_armor"));
    } // end registerArmorRecipes()
    
    protected void registerStorageRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapelessRecipeBuilder.shapeless(ModItems.copper_nugget.get(), 9)
	        .requires(Items.COPPER_INGOT)
	        .unlockedBy("has_item", has(Items.COPPER_INGOT))
	        .save(consumer);
    
	    ShapedRecipeBuilder.shaped(Items.COPPER_INGOT)
	        .define('S', ModItems.copper_nugget.get())
	        .pattern("SSS")
	        .pattern("SSS")
	        .pattern("SSS")
	        .unlockedBy("has_item", has(ModItems.copper_nugget.get()))
	        .save(consumer, new ResourceLocation(SimpleOres.MODID, Items.COPPER_INGOT.toString() + "_from_nuggets"));

        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.tin_ingot.get(), ModBlocks.tin_block.get(), 
                ModItems.tin_nugget.get(), has(ModItems.tin_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_tin.get(), 
        		ModBlocks.raw_tin_block.get(), null, has(ModItems.raw_tin.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.mythril_ingot.get(), ModBlocks.mythril_block.get(), 
                ModItems.mythril_nugget.get(), has(ModItems.mythril_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_mythril.get(), 
        		ModBlocks.raw_mythril_block.get(), null, has(ModItems.raw_mythril.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.adamantium_ingot.get(), ModBlocks.adamantium_block.get(), 
                ModItems.adamantium_nugget.get(), has(ModItems.adamantium_ingot.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.raw_adamantium.get(), 
        		ModBlocks.raw_adamantium_block.get(), null, has(ModItems.raw_adamantium.get()));
        setbuilder.buildSimpleStorageRecipes(consumer, ModItems.onyx_gem.get(), ModBlocks.onyx_block.get(), 
                null, has(ModItems.onyx_gem.get()));
    } // end registerStorageRecipes()
    
    protected void registerMiscRecipes(Consumer<FinishedRecipe> consumer)
    {
        // copper bucket
        ResourceLocation copper_bucket_name = new ResourceLocation(SimpleOres.MODID, "copper_bucket");
        ConditionalRecipe.builder().addCondition(flag("copper_bucket"))
        .addRecipe(
            ShapedRecipeBuilder.shaped(ModItems.copper_bucket.get())
                .define('S', ModTags.Items.INGOTS_COPPER)
                .pattern("S S")
                .pattern(" S ")
                .unlockedBy("has_item", has(ModTags.Items.INGOTS_COPPER))
                ::save)
        .setAdvancement(copper_bucket_name, 
                      setbuilder.build_advancement_with_condition(copper_bucket_name, 
                              flag("copper_bucket"), has(ModTags.Items.INGOTS_COPPER)))
        .build(consumer, copper_bucket_name);
       
    } // end registerMiscRecipes()

    protected void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_adamantium.get()), ModItems.adamantium_ingot.get(), 
                has(ModItems.raw_adamantium.get().asItem()), 0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.adamantium_ore.get().asItem()), ModItems.adamantium_ingot.get(), 
                has(ModBlocks.adamantium_ore.get().asItem()), 0.7F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_mythril.get()), ModItems.mythril_ingot.get(), 
                has(ModItems.raw_mythril.get().asItem()), 0.7F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.mythril_ore.get().asItem()), ModItems.mythril_ingot.get(), 
                has(ModBlocks.mythril_ore.get().asItem()), 0.7F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModItems.raw_tin.get()), ModItems.tin_ingot.get(), 
                has(ModItems.raw_tin.get()), 0.4F, 200);
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.tin_ore.get().asItem()), ModItems.tin_ingot.get(), 
                has(ModBlocks.tin_ore.get().asItem()), 0.4F, 200, "_from_ore");
        setbuilder.buildOre2IngotRecipes(consumer, Ingredient.of(ModBlocks.onyx_ore.get().asItem()), ModItems.onyx_gem.get(), 
                has(ModBlocks.onyx_ore.get().asItem()), 1.0F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.adamantium_axe.get(), ModItems.adamantium_boots.get(), ModItems.adamantium_chestplate.get(),
                        ModItems.adamantium_helmet.get(), ModItems.adamantium_hoe.get(), ModItems.adamantium_leggings.get(), 
                        ModItems.adamantium_pickaxe.get(),ModItems.adamantium_shovel.get(), ModItems.adamantium_sword.get()), 
                ModItems.adamantium_nugget.get(), has(ModItems.adamantium_axe.get()), 
                0.3F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.tin_axe.get(), ModItems.tin_boots.get(), ModItems.tin_chestplate.get(),
                        ModItems.tin_helmet.get(), ModItems.tin_hoe.get(), ModItems.tin_leggings.get(), 
                        ModItems.tin_pickaxe.get(),ModItems.tin_shovel.get(), ModItems.tin_sword.get()), 
                ModItems.tin_nugget.get(), has(ModItems.tin_axe.get()), 
                0.2F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.copper_axe.get(), ModItems.copper_boots.get(), ModItems.copper_chestplate.get(),
                        ModItems.copper_helmet.get(), ModItems.copper_hoe.get(), ModItems.copper_leggings.get(), 
                        ModItems.copper_pickaxe.get(),ModItems.copper_shovel.get(), ModItems.copper_sword.get(),
                        ModItems.copper_bucket.get()), 
                ModItems.copper_nugget.get(), has(ModItems.copper_axe.get()), 
                0.2F, 200);
        
        setbuilder.buildVanillaRecyclingRecipes(consumer,
                Ingredient.of(ModItems.mythril_axe.get(), ModItems.mythril_boots.get(), ModItems.mythril_chestplate.get(),
                        ModItems.mythril_helmet.get(), ModItems.mythril_hoe.get(), ModItems.mythril_leggings.get(), 
                        ModItems.mythril_pickaxe.get(),ModItems.mythril_shovel.get(), ModItems.mythril_sword.get()), 
                ModItems.mythril_nugget.get(), has(ModItems.mythril_axe.get()), 
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