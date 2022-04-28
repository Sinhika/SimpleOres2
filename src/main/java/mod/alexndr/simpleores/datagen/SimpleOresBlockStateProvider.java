package mod.alexndr.simpleores.datagen;

import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SimpleOresBlockStateProvider extends SimpleBlockStateProvider
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
                new ResourceLocation(SimpleOres.MODID, "block/tin_block"));
        ModelFile mythrilPlateModel = this.models().pressurePlate("mythril_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/mythril_block"));
        ModelFile mythrilPlateModel_down = this.models().pressurePlateDown("mythril_plate_down", 
                new ResourceLocation(SimpleOres.MODID, "block/mythril_block"));
        ModelFile adamantiumPlateModel = this.models().pressurePlate("adamantium_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/adamantium_block"));
        ModelFile adamantiumPlateModel_down = this.models().pressurePlateDown("adamantium_plate_down", 
                new ResourceLocation(SimpleOres.MODID, "block/adamantium_block"));
        ModelFile onyxPlateModel = this.models().pressurePlate("onyx_plate", 
                new ResourceLocation(SimpleOres.MODID, "block/onyx_block"));
        ModelFile onyxPlateModel_down = this.models().pressurePlateDown("onyx_plate_down", 
                new ResourceLocation(SimpleOres.MODID, "block/onyx_block"));
        
        // ITEM MODELS
        this.itemModels().withExistingParent("copper_pressure_plate", new ResourceLocation(SimpleOres.MODID, "block/copper_plate"));
        this.itemModels().withExistingParent("tin_pressure_plate", new ResourceLocation(SimpleOres.MODID, "block/tin_plate"));
        this.itemModels().withExistingParent("mythril_pressure_plate", new ResourceLocation(SimpleOres.MODID, "block/mythril_plate"));
        this.itemModels().withExistingParent("adamantium_pressure_plate", new ResourceLocation(SimpleOres.MODID, "block/adamantium_plate"));
        this.itemModels().withExistingParent("onyx_pressure_plate", new ResourceLocation(SimpleOres.MODID, "block/onyx_plate"));

        // BLOCKSTATES
        this.buildWeightedPressurePlateBlockState(ModBlocks.copper_pressure_plate.get(), copperPlateModel, copperPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.tin_pressure_plate.get(), tinPlateModel, tinPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.mythril_pressure_plate.get(), mythrilPlateModel, mythrilPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.adamantium_pressure_plate.get(), adamantiumPlateModel, adamantiumPlateModel_down);
        this.buildWeightedPressurePlateBlockState(ModBlocks.onyx_pressure_plate.get(), onyxPlateModel, onyxPlateModel_down);
        
    } // end-registerStatesAndModels()

} // end class
