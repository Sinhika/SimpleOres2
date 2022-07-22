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
        pressurePlateStatesAndModels();
        doorStatesAndModels();
        barStatesAndModels();
    } // end-registerStatesAndModels()

    /**
     * generate this mod's bar models and blockstates and item models.
     */
    private void barStatesAndModels()
    {
        this.buildBarsBlockState(ModBlocks.adamantium_bars.get(), modLoc("block/adamantium_bars"));
        this.buildBarsBlockState(ModBlocks.copper_bars.get(), modLoc("block/copper_bars"));
        this.buildBarsBlockState(ModBlocks.mythril_bars.get(), modLoc("block/mythril_bars"));
        this.buildBarsBlockState(ModBlocks.onyx_bars.get(), modLoc("block/onyx_bars"));
        this.buildBarsBlockState(ModBlocks.tin_bars.get(), modLoc("block/tin_bars"));
        
        // item models
        this.itemModels().basicItem(ModBlocks.adamantium_bars.get().asItem());
        this.itemModels().basicItem(ModBlocks.copper_bars.get().asItem());
        this.itemModels().basicItem(ModBlocks.mythril_bars.get().asItem());
        this.itemModels().basicItem(ModBlocks.onyx_bars.get().asItem());
        this.itemModels().basicItem(ModBlocks.tin_bars.get().asItem());
        
    } // end barStatesAndModels()
    
    /**
     * generate this mod's door models and blockstates and/or item models.
     */
    private void doorStatesAndModels()
    {
        // BLOCKSTATES & BLOCK MODELS
        this.doorBlockWithRenderType(ModBlocks.adamantium_door.get(), modLoc("block/adamantium_door_lower"), 
               modLoc("block/adamantium_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.copper_door.get(), modLoc("block/copper_door_lower"), 
                modLoc("block/copper_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.mythril_door.get(), modLoc("block/mythril_door_lower"), 
                modLoc("block/mythril_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.onyx_door.get(), modLoc("block/onyx_door_lower"), 
                modLoc("block/onyx_door_upper"), "cutout");
        this.doorBlockWithRenderType(ModBlocks.tin_door.get(), modLoc("block/tin_door_lower"), 
                modLoc("block/tin_door_upper"), "cutout");

        // ITEM MODELS
        this.itemModels().basicItem(ModBlocks.adamantium_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.copper_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.mythril_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.onyx_door.get().asItem());
        this.itemModels().basicItem(ModBlocks.tin_door.get().asItem());
        
    } // end doorStatesAndModels()
    
    /**
     * generate this mod's pressure plates models and blockstates and item models.
     */
    private void pressurePlateStatesAndModels()
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
        
    } // end pressurePlateStatesAndModels()
    
    
} // end class
