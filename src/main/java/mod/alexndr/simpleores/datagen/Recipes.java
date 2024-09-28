package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.datagen.SimpleRecipeProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/** 
 * RecipeProvider for SimpleOres.
 * @author Sinhika
 *
 */
public class Recipes extends SimpleRecipeProvider
{

    public Recipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(pOutput, lookupProvider, SimpleOres.MODID);
    }


    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        registerStorageRecipes(pRecipeOutput);
        registerMiscRecipes(pRecipeOutput);
        registerToolRecipes(pRecipeOutput);
        registerArmorRecipes(pRecipeOutput);
        registerFurnaceRecipes(pRecipeOutput);
        registerAestheticRecipes(pRecipeOutput);
        
        registerSilentsFurnaceRecipes(pRecipeOutput);
    } // end registerRecipes() 
    
    
    protected void registerAestheticRecipes(RecipeOutput pRecipeOutput)
    {
    	 buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.adamantium_ingot.get()), "adamantium", 
    			has(ModItems.adamantium_ingot.get()));
    	 buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.mythril_ingot.get()), "mythril", 
     			has(ModItems.mythril_ingot.get()));
    	 buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.tin_ingot.get()), "tin", 
      			has(ModItems.tin_ingot.get()));
    	 buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(ModItems.onyx_gem.get()), "onyx", 
       			has(ModItems.onyx_gem.get()));
    	 buildSimpleAestheticBlocks(pRecipeOutput, Ingredient.of(Items.COPPER_INGOT), "copper", 
       			has(Items.COPPER_INGOT));
    } // end registerAestheticRecipes()
    
    
    protected void registerToolRecipes(RecipeOutput pRecipeOutput)
    {
        buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_COPPER), "copper", 
                                      has(ModTags.Items.INGOTS_COPPER), true);
        buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_TIN), "tin", 
                has(ModTags.Items.INGOTS_TIN), true);
        buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                has(ModTags.Items.INGOTS_MYTHRIL), true);
        buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                has(ModTags.Items.INGOTS_ADAMANTIUM), true);
        buildSimpleToolSet(pRecipeOutput, Ingredient.of(ModTags.Items.GEMS_ONYX), "onyx", 
                has(ModTags.Items.GEMS_ONYX), true);
        
        buildModBowRecipe(pRecipeOutput, ModItems.mythril_bow.getId(), Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), 
                ModItems.mythril_rod.get(), Ingredient.of(Items.IRON_INGOT), has(ModTags.Items.INGOTS_MYTHRIL));
        
        buildModBowRecipe(pRecipeOutput, ModItems.onyx_bow.getId(), Ingredient.of(ModTags.Items.GEMS_ONYX), 
                ModItems.onyx_rod.get(), Ingredient.of(Items.IRON_INGOT), has(ModTags.Items.GEMS_ONYX));
    } // end registerToolRecipes()
    
    protected void registerArmorRecipes(RecipeOutput pRecipeOutput)
    {
        buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_COPPER), "copper", 
                                       has(ModTags.Items.INGOTS_COPPER));
        buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_TIN), "tin", 
                has(ModTags.Items.INGOTS_TIN));
        buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_MYTHRIL), "mythril", 
                has(ModTags.Items.INGOTS_MYTHRIL));
        buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM), "adamantium", 
                has(ModTags.Items.INGOTS_ADAMANTIUM));
        buildSimpleArmorSet(pRecipeOutput, Ingredient.of(ModTags.Items.GEMS_ONYX), "onyx", 
                has(ModTags.Items.GEMS_ONYX));
    } // end registerArmorRecipes()
    
    
    protected void registerStorageRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        buildSimpleStorageRecipes(pRecipeOutput, Items.COPPER_INGOT, Items.COPPER_BLOCK, ModItems.copper_nugget.get());

        buildSimpleStorageRecipes(pRecipeOutput, ModItems.tin_ingot.get(), ModBlocks.tin_block.get(),
                ModItems.tin_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_tin.get(),
        		ModBlocks.raw_tin_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.mythril_ingot.get(), ModBlocks.mythril_block.get(), 
                ModItems.mythril_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_mythril.get(), 
        		ModBlocks.raw_mythril_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.adamantium_ingot.get(), ModBlocks.adamantium_block.get(), 
                ModItems.adamantium_nugget.get());
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.raw_adamantium.get(), 
        		ModBlocks.raw_adamantium_block.get(), null);
        buildSimpleStorageRecipes(pRecipeOutput, ModItems.onyx_gem.get(), ModBlocks.onyx_block.get(), 
                null);
    } // end registerStorageRecipes()
    
    protected void registerMiscRecipes(RecipeOutput pRecipeOutput)
    {
        // copper bucket
        ResourceLocation copper_bucket_name = new ResourceLocation(SimpleOres.MODID, "copper_bucket");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.copper_bucket.get())
                .define('S', ModTags.Items.INGOTS_COPPER)
                .pattern("S S")
                .pattern(" S ")
                .unlockedBy("has_item", has(ModTags.Items.INGOTS_COPPER))
                .save(pRecipeOutput, copper_bucket_name);

        // pressure_plates
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_COPPER), 
                ModBlocks.copper_pressure_plate.get(), has(ModTags.Items.INGOTS_COPPER));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_TIN),
                ModBlocks.tin_pressure_plate.get(), has(ModTags.Items.INGOTS_TIN));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_MYTHRIL),
                ModBlocks.mythril_pressure_plate.get(), has(ModTags.Items.INGOTS_MYTHRIL));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModTags.Items.INGOTS_ADAMANTIUM),
                ModBlocks.adamantium_pressure_plate.get(), has(ModTags.Items.INGOTS_ADAMANTIUM));
        this.buildSimplePressurePlate(pRecipeOutput, Ingredient.of(ModTags.Items.GEMS_ONYX),
                ModBlocks.onyx_pressure_plate.get(), has(ModTags.Items.GEMS_ONYX));
    } // end registerMiscRecipes()

    protected void registerFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.raw_adamantium.get(), ModBlocks.adamantium_ore.get().asItem(),
                        ModBlocks.deepslate_adamantium_ore.get().asItem()),
                ModItems.adamantium_ingot.get(), 0.7F, 200, "adamantium_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.raw_mythril.get(), ModBlocks.mythril_ore.get().asItem(),
                        ModBlocks.deepslate_mythril_ore.get().asItem()),
                ModItems.mythril_ingot.get(), 0.7F, 200, "mythril_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.raw_tin.get(), ModBlocks.tin_ore.get().asItem(),
                        ModBlocks.deepslate_tin_ore.get().asItem()),
                ModItems.tin_ingot.get(), 0.4F, 200, "tin_ingots");
        buildOre2IngotRecipes(pRecipeOutput, List.of(ModBlocks.onyx_ore.get().asItem(),
                        ModBlocks.basalt_onyx_ore.asItem(), ModBlocks.blackstone_onyx_ore.asItem()),
                ModItems.onyx_gem.get(), 1.0F, 200, "onyx_gems");

        buildVanillaRecyclingRecipes(pRecipeOutput,
                List.of(ModItems.adamantium_axe.get(), ModItems.adamantium_boots.get(),
                        ModItems.adamantium_chestplate.get(),
                        ModItems.adamantium_helmet.get(), ModItems.adamantium_hoe.get(),
                        ModItems.adamantium_leggings.get(),
                        ModItems.adamantium_pickaxe.get(), ModItems.adamantium_shovel.get(),
                        ModItems.adamantium_sword.get()),
                ModItems.adamantium_nugget.get(),0.3F, 200, "adamantium_recycling");
        
        buildVanillaRecyclingRecipes(pRecipeOutput,
                List.of(ModItems.tin_axe.get(), ModItems.tin_boots.get(), ModItems.tin_chestplate.get(),
                        ModItems.tin_helmet.get(), ModItems.tin_hoe.get(), ModItems.tin_leggings.get(),
                        ModItems.tin_pickaxe.get(), ModItems.tin_shovel.get(), ModItems.tin_sword.get()),
                ModItems.tin_nugget.get(), 0.2F, 200, "tin_recycling");
        
        buildVanillaRecyclingRecipes(pRecipeOutput,
                List.of(ModItems.copper_axe.get(), ModItems.copper_boots.get(), ModItems.copper_chestplate.get(),
                        ModItems.copper_helmet.get(), ModItems.copper_hoe.get(), ModItems.copper_leggings.get(), 
                        ModItems.copper_pickaxe.get(),ModItems.copper_shovel.get(), ModItems.copper_sword.get(),
                        ModItems.copper_bucket.get()), 
                ModItems.copper_nugget.get(), 0.2F, 200, "copper_recycling");
        
        buildVanillaRecyclingRecipes(pRecipeOutput,
                List.of(ModItems.mythril_axe.get(), ModItems.mythril_boots.get(), ModItems.mythril_chestplate.get(),
                        ModItems.mythril_helmet.get(), ModItems.mythril_hoe.get(), ModItems.mythril_leggings.get(), 
                        ModItems.mythril_pickaxe.get(),ModItems.mythril_shovel.get(), ModItems.mythril_sword.get()), 
                ModItems.mythril_nugget.get(), 0.4F, 200, "mythril_recycling");
        
    } // end registerFurnaceRecipes()

    
    private void registerSilentsFurnaceRecipes(RecipeOutput pRecipeOutput)
    {
        buildOre2IngotRecipes(pRecipeOutput, 
                List.of(ModItems.adamantium_dust.get()),
                ModItems.adamantium_ingot.get(), 0.7F, 200, "adamantium_ingots");
        buildOre2IngotRecipes(pRecipeOutput, 
                List.of(ModItems.crushed_adamantium_ore.get()),
                ModItems.adamantium_ingot.get(),0.7F, 200, "adamantium_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.mythril_dust.get().asItem()),
                ModItems.mythril_ingot.get(), 0.7F, 200, "mythril_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.crushed_mythril_ore.get().asItem()),
                ModItems.mythril_ingot.get(), 0.7F, 200, "mythril_ingots");
        buildOre2IngotRecipes(pRecipeOutput,
                List.of(ModItems.crushed_tin_ore.get().asItem()),
                ModItems.tin_ingot.get(), 0.4F, 200, "tin_ingots");
    }
    

} // end subclass Recipes.