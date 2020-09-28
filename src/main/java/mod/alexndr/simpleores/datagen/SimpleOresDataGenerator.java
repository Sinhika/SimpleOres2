package mod.alexndr.simpleores.datagen;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.api.datagen.AbstractLootTableProvider;
import mod.alexndr.simpleores.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simpleores.api.datagen.RecipeSetBuilder;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
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
            gen.addProvider(new ModBlockTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new SimpleOresLootTableProvider(gen));
        }
     } // end gatherData()

    
    /**
     * LootTableProvider for SimpleOres. Again, proof-of-concept.
     */
    public static class SimpleOresLootTableProvider extends AbstractLootTableProvider
    {

        public SimpleOresLootTableProvider(DataGenerator dataGeneratorIn)
        {
            super(dataGeneratorIn);
        }

        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
        {
            tables.clear();
            standardDropTable(ModBlocks.adamantium_block.get());
            standardDropTable(ModBlocks.adamantium_ore.get());
            standardDropTable(ModBlocks.copper_block.get());
            standardDropTable(ModBlocks.copper_ore.get());
            standardDropTable(ModBlocks.tin_block.get());
            standardDropTable(ModBlocks.tin_ore.get());
            standardDropTable(ModBlocks.mythril_block.get());
            standardDropTable(ModBlocks.mythril_ore.get());
            standardDropTable(ModBlocks.onyx_block.get());
            
            specialDropTable(ModBlocks.onyx_ore.get(), ModItems.onyx_gem.get());
            return tables;
        }
        
    } // end-class SimpleOresLootTableProvider
    
    /**
     * TagsProvider for SimpleOres. Mostly this is proof-of-concept, and guidance for other
     * mods on how to do tags with datagen.
     * 
     * @author Sinhika
     *
     */
    public static class ModBlockTags extends BlockTagsProvider
    {
        public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper helper )
        {
            super(generatorIn, SimpleOres.MODID, helper);
        }

        @Override
        protected void registerTags()
        {
            registerOreTags();
            registerStorageBlockTags();
        } // end registerTags()
        
        private void registerStorageBlockTags()
        {
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantium"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantine"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantite"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/copper"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/tin"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/mythril"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/mithril"))
                .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/onyx"));
            
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantium"))
                    .add(ModBlocks.adamantium_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantine"))
                    .add(ModBlocks.adamantium_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/adamantite"))
                    .add(ModBlocks.adamantium_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/copper"))
                    .add(ModBlocks.copper_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/tin"))
                    .add(ModBlocks.tin_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/mythril"))
                    .add(ModBlocks.mythril_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/mithril"))
                    .add(ModBlocks.mythril_block.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:storage_blocks/onyx"))
                    .add(ModBlocks.onyx_block.get());

        } // end registerStorageBlockTags
        
        private void registerOreTags()
        {
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/copper"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/tin"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantine"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantite"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantium"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/mithril"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/mythril"))
                    .addTag((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/onyx"));

            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/copper"))
                    .add(ModBlocks.copper_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/tin"))
                    .add(ModBlocks.tin_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantium"))
                    .add(ModBlocks.adamantium_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantine"))
                    .add(ModBlocks.adamantium_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/adamantite"))
                    .add(ModBlocks.adamantium_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/mythril"))
                    .add(ModBlocks.mythril_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/mithril"))
                    .add(ModBlocks.mythril_ore.get());
            this.getOrCreateBuilder((ITag.INamedTag<Block>) BlockTags.makeWrapperTag("forge:ores/onyx"))
                    .add(ModBlocks.onyx_ore.get());
            
        } // end registerOreTags()
        
    } // end-class ModBlockTags
   
    /** 
     * RecipeProvider for SimpleOres.
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

    } // end subclass SimpleModDataGenerator$Recipes.
    
} // end-class SimpleModDataGenerator
