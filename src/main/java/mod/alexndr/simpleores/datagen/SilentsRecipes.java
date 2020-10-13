package mod.alexndr.simpleores.datagen;

import java.util.function.Consumer;

import mod.alexndr.simplecorelib.datagen.CrushingRecipeBuilder;
import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.init.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SilentsRecipes extends RecipeProvider implements ISimpleConditionBuilder, IConditionBuilder
{
    private static final int CRUSHING_CHUNKS_TIME = 300;
    private static final int CRUSHING_INGOT_TIME = 200;
    private static final int CRUSHING_ORE_TIME = 400;
    private static final float CRUSHING_CHUNKS_EXTRA_CHANCE = 0.1f;
    private static final float CRUSHING_ORE_STONE_CHANCE = 0.1f;
    
    private RecipeSetBuilder setbuilder;
    
    public SilentsRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(SimpleOres.MODID);
    }

    
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerCrushingRecipes(consumer);
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()


    private void registerFurnaceRecipes(Consumer<IFinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.adamantium_dust.get().asItem()), 
                ModItems.adamantium_ingot.get(), 
                hasItem(ModItems.adamantium_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.crushed_adamantium_ore.get().asItem()), 
                ModItems.adamantium_ingot.get(), 
                hasItem(ModItems.crushed_adamantium_ore.get().asItem()), 0.7F, 200, "_from_ore_chunk");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.mythril_dust.get().asItem()), 
                ModItems.mythril_ingot.get(), 
                hasItem(ModItems.mythril_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.fromItems(ModItems.crushed_mythril_ore.get().asItem()), 
                ModItems.mythril_ingot.get(), 
                hasItem(ModItems.crushed_mythril_ore.get().asItem()), 0.7F, 200, "_from_ore_chunk");
    }
    
    private void registerCrushingRecipes(Consumer<IFinishedRecipe> consumer)
    {
        // crush ore
        CrushingRecipeBuilder.crushingOre(SimpleOres.MODID,
                ModTags.Items.ORES_MYTHRIL, ModItems.crushed_mythril_ore.get(), CRUSHING_ORE_TIME, 
                Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
            .build(consumer);
        CrushingRecipeBuilder.crushingOre(SimpleOres.MODID,
                ModTags.Items.ORES_ADAMANTIUM, ModItems.crushed_adamantium_ore.get(), CRUSHING_ORE_TIME, 
                Blocks.COBBLESTONE, CRUSHING_ORE_STONE_CHANCE)
            .build(consumer);
        
        // crush chunks
        CrushingRecipeBuilder.crushingChunks(SimpleOres.MODID, 
                ModTags.Items.CHUNKS_ADAMANTIUM, ModItems.adamantium_dust.get(), CRUSHING_CHUNKS_TIME, 
                CRUSHING_CHUNKS_EXTRA_CHANCE)
            .build(consumer);
        CrushingRecipeBuilder.crushingChunks(SimpleOres.MODID, 
                ModTags.Items.CHUNKS_MYTHRIL, ModItems.mythril_dust.get(), CRUSHING_CHUNKS_TIME, 
                CRUSHING_CHUNKS_EXTRA_CHANCE)
            .build(consumer);
        
        // crush ingots
        CrushingRecipeBuilder.crushingIngot(SimpleOres.MODID,
                ModTags.Items.INGOTS_MYTHRIL, ModItems.mythril_dust.get(), CRUSHING_INGOT_TIME)
            .build(consumer, new ResourceLocation(SimpleOres.MODID, "crushing/mythril_dust_from_ingot"));
        CrushingRecipeBuilder.crushingIngot(SimpleOres.MODID,
                ModTags.Items.INGOTS_ADAMANTIUM, ModItems.adamantium_dust.get(), CRUSHING_INGOT_TIME)
            .build(consumer, new ResourceLocation(SimpleOres.MODID, "crushing/adamantium_dust_from_ingot"));
    } // end registerCrushingRecipes


    @Override
    public ICondition flag(String name)
    {
        return impl_flag(SimpleOres.MODID, SimpleOresConfig.INSTANCE, name);
    }

} // end class
