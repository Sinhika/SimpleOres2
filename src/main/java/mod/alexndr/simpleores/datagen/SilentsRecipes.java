package mod.alexndr.simpleores.datagen;

import java.util.function.Consumer;

import mod.alexndr.simplecorelib.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.datagen.RecipeSetBuilder;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class SilentsRecipes extends RecipeProvider implements ISimpleConditionBuilder, IConditionBuilder
{
    
    private RecipeSetBuilder setbuilder;
    
    public SilentsRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
        setbuilder = new RecipeSetBuilder(SimpleOres.MODID);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerFurnaceRecipes(consumer);
    } // end registerRecipes()


    private void registerFurnaceRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.adamantium_dust.get().asItem()), 
                ModItems.adamantium_ingot.get(), 
                has(ModItems.adamantium_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_adamantium_ore.get().asItem()), 
                ModItems.adamantium_ingot.get(), 
                has(ModItems.crushed_adamantium_ore.get().asItem()), 0.7F, 200, "_from_ore_chunk");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.mythril_dust.get().asItem()), 
                ModItems.mythril_ingot.get(), 
                has(ModItems.mythril_dust.get().asItem()), 0.7F, 200, "_from_dust");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_mythril_ore.get().asItem()), 
                ModItems.mythril_ingot.get(), 
                has(ModItems.crushed_mythril_ore.get().asItem()), 0.7F, 200, "_from_ore_chunk");
        setbuilder.buildOre2IngotRecipes(consumer, 
                Ingredient.of(ModItems.crushed_tin_ore.get().asItem()), 
                ModItems.tin_ingot.get(), 
                has(ModItems.crushed_tin_ore.get().asItem()), 0.4F, 200, "_from_ore_chunk");
    }
    

    @Override
    public ICondition flag(String name)
    {
        return impl_flag(SimpleOres.MODID, SimpleOresConfig.INSTANCE, name);
    }

} // end class
