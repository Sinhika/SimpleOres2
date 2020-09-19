package mod.alexndr.simpleores.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * bundles up the GatherDataEvent handler and all the necessary data providers for
 * data generation.
 * @author Sinhika
 */
@EventBusSubscriber(modid = SimpleOres.MODID, bus = MOD)
public class SimpleOresDataGenerator
{

    /**
     * GatherDataEvent handler.
     * @param event the GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new Recipes(gen));
        }
     } // end gatherData()

    /** 
     * RecipeProvider for SimpleMod.
     * @author Sinhika
     *
     */
    public static class Recipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
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
        } // end registerFurnaceRecipes()
        
        /**
         * Builds an ICondition representing FlagCondition...
         *
         */
        public ICondition flag(String name)
        {
            return impl_flag(SimpleOres.MODID, SimpleOresConfig.INSTANCE, name);
        }

    } // end subclass SimpleModDataGenerator$Recipes.
    
} // end-class SimpleModDataGenerator
