package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SimpleOresBlockStateProvider extends BlockStateProvider
{


    public SimpleOresBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, SimpleOres.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // MODELS
        ModelFile copperPlateModel = this.models().pressurePlate("copper_plate", 
                new ResourceLocation("minecraft", "block/copper_block"));
        ModelFile copperPlateModel_down = this.models().pressurePlateDown("copper_plate_down", 
                new ResourceLocation("minecraft", "block/copper_block"));
        ModelFile tinPlateModel = this.models().pressurePlate("tin_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/tin_block"));
        ModelFile tinPlateModel_down = this.models().pressurePlateDown("tin_plate_down", 
                new ResourceLocation("SimpleOres.MODID", "block/tin_block"));
        ModelFile mythrilPlateModel = this.models().pressurePlate("mythril_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/mythril_block"));
        ModelFile mythrilPlateModel_down = this.models().pressurePlateDown("mythril_plate_down", 
                new ResourceLocation("SimpleOres.MODID", "block/mythril_block"));
        ModelFile adamantiumPlateModel = this.models().pressurePlate("adamantium_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/adamantium_block"));
        ModelFile adamantiumPlateModel_down = this.models().pressurePlateDown("adamantium_plate_down", 
                new ResourceLocation("SimpleOres.MODID", "block/adamantium_block"));
        ModelFile onyxPlateModel = this.models().pressurePlate("onyx_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/onyx_block"));
        ModelFile onyxPlateModel_down = this.models().pressurePlateDown("onyx_plate_down", 
                new ResourceLocation("SimpleOres.MODID", "block/onyx_block"));
        
        // BLOCKSTATES
        this.buildWeightedPressurePlateBlockState(ModBlocks.copper_pressure_plate.get(), copperPlateModel, copperPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.tin_pressure_plate.get(), tinPlateModel, tinPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.mythril_pressure_plate.get(), mythrilPlateModel, mythrilPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.adamantium_pressure_plate.get(), adamantiumPlateModel, adamantiumPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.onyx_pressure_plate.get(), onyxPlateModel, onyxPlateModel_down);
        
    } // end-registerStatesAndModels()

    private void buildWeightedPressurePlateBlockState(MultifunctionPressurePlateBlock pBlock, ModelFile pPlate, ModelFile pPlate_down)
    {
        this.getVariantBuilder(pBlock)
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 0).setModels(new ConfiguredModel(pPlate))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 1).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 2).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 3).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 4).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 5).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 6).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 7).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 8).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 9).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 10).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 11).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 12).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 13).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 14).setModels(new ConfiguredModel(pPlate_down))
            .partialState().with(MultifunctionPressurePlateBlock.POWER, 15).setModels(new ConfiguredModel(pPlate_down));
    }
} // end class
