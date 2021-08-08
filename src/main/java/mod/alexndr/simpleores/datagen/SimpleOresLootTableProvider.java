package mod.alexndr.simpleores.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.alexndr.simplecorelib.datagen.BlockLootTableProvider;
import mod.alexndr.simpleores.init.ModBlocks;
import mod.alexndr.simpleores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.resources.ResourceLocation;

/**
 * LootTableProvider for SimpleOres. Again, proof-of-concept.
 */
public class SimpleOresLootTableProvider extends BlockLootTableProvider
{

    public SimpleOresLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
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