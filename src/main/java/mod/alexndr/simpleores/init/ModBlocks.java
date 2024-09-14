package mod.alexndr.simpleores.init;

import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SimpleOres.MODID);

    // Ore Blocks
    public static final DeferredBlock<DropExperienceBlock> tin_ore = BLOCKS.register("tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,3), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 3.0F, 3.0F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<DropExperienceBlock> deepslate_tin_ore = BLOCKS.register("deepslate_tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,3),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 3.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> mythril_ore = BLOCKS.register("mythril_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 4.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> deepslate_mythril_ore = BLOCKS.register("deepslate_mythril_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 4.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> adamantium_ore = BLOCKS.register("adamantium_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 5.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> deepslate_adamantium_ore = BLOCKS.register("deepslate_adamantium_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 5.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> onyx_ore = BLOCKS.register("onyx_ore",
            () -> new DropExperienceBlock(ConstantInt.of(1), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 7.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> basalt_onyx_ore = BLOCKS.register("basalt_onyx_ore",
            () -> new DropExperienceBlock(ConstantInt.of(1), BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .strength( 7.0F, 3.0F)
                    .requiresCorrectToolForDrops()));

    // Raw_metal blocks
    public static final DeferredBlock<Block> raw_tin_block = BLOCKS.register("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .strength(4.0F, 6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> raw_mythril_block = BLOCKS.register("raw_mythril_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(7.0F, 6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> raw_adamantium_block = BLOCKS.register("raw_adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                    .strength(7.0F, 12.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    
    // Metal Blocks
    public static final DeferredBlock<Block> tin_block = BLOCKS.register("tin_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .strength(4.0F, 6.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> mythril_block = BLOCKS.register("mythril_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(7.0F, 6.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> adamantium_block = BLOCKS.register("adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> onyx_block = BLOCKS.register("onyx_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL)
                    .strength(20.0F, 100.0F)
                    .requiresCorrectToolForDrops()));
    
    // Blocks - bricks - Simple Ores
//    public static DeferredBlock<Block> copper_bricks = BLOCKS.register("copper_bricks",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static DeferredBlock<Block> tin_bricks = BLOCKS.register("tin_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(tin_block.get())));
    public static DeferredBlock<Block> onyx_bricks = BLOCKS.register("onyx_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(onyx_block.get())));
    public static DeferredBlock<Block> adamantium_bricks = BLOCKS.register("adamantium_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(adamantium_block.get())));
    public static DeferredBlock<Block> mythril_bricks = BLOCKS.register("mythril_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(mythril_block.get())));

    // blocks - slabs
    public static DeferredBlock<SlabBlock> tin_brick_slab = BLOCKS.register("tin_brick_slab",
    		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(tin_bricks.get())));
    public static DeferredBlock<SlabBlock> onyx_brick_slab = BLOCKS.register("onyx_brick_slab",
    		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(onyx_bricks.get())));
    public static DeferredBlock<SlabBlock> mythril_brick_slab = BLOCKS.register("mythril_brick_slab",
    		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(mythril_bricks.get())));
    public static DeferredBlock<SlabBlock> adamantium_brick_slab = BLOCKS.register("adamantium_brick_slab",
    		() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(adamantium_bricks.get())));
            
    // Blocks - stairs - simpleores
//    public static DeferredBlock<StairBlock> copper_brick_stairs = BLOCKS.register("copper_brick_stairs",
//            () -> new StairBlock( () -> copper_bricks.get().defaultBlockState(), 
//                                   BlockBehaviour.Properties.copy(copper_bricks.get())));
    public static DeferredBlock<StairBlock> tin_brick_stairs = BLOCKS.register("tin_brick_stairs",
            () -> new StairBlock( tin_bricks.get().defaultBlockState(),
                                   BlockBehaviour.Properties.ofFullCopy(tin_bricks.get())));
    public static DeferredBlock<StairBlock> onyx_brick_stairs = BLOCKS.register("onyx_brick_stairs",
            () -> new StairBlock( onyx_bricks.get().defaultBlockState(),
                                   BlockBehaviour.Properties.ofFullCopy(onyx_bricks.get())));
    public static DeferredBlock<StairBlock> adamantium_brick_stairs = BLOCKS.register("adamantium_brick_stairs",
            () -> new StairBlock( adamantium_bricks.get().defaultBlockState(),
                                   BlockBehaviour.Properties.ofFullCopy(adamantium_bricks.get())));
    public static DeferredBlock<StairBlock> mythril_brick_stairs = BLOCKS.register("mythril_brick_stairs",
            () -> new StairBlock( mythril_bricks.get().defaultBlockState(),
                                   BlockBehaviour.Properties.ofFullCopy(mythril_bricks.get())));

    // Blocks - doors - simpleores
    public static DeferredBlock<DoorBlock> copper_door = BLOCKS.register("copper_door",
            () -> new DoorBlock(BlockSetType.COPPER, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
            						.requiresCorrectToolForDrops().strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static DeferredBlock<DoorBlock> tin_door = BLOCKS.register("tin_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
					.requiresCorrectToolForDrops().strength(4.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static DeferredBlock<DoorBlock> adamantium_door = BLOCKS.register("adamantium_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
					.requiresCorrectToolForDrops().strength(7.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static DeferredBlock<DoorBlock> onyx_door = BLOCKS.register("onyx_door",
            () -> new DoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL)
					.requiresCorrectToolForDrops().strength(20.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static DeferredBlock<DoorBlock> mythril_door = BLOCKS.register("mythril_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
					.requiresCorrectToolForDrops().strength(7.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
   
    // Blocks - bars - simpleores
    public static DeferredBlock<IronBarsBlock> copper_bars = BLOCKS.register("copper_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> tin_bars = BLOCKS.register("tin_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> onyx_bars = BLOCKS.register("onyx_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(20.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> adamantium_bars = BLOCKS.register("adamantium_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static DeferredBlock<IronBarsBlock> mythril_bars = BLOCKS.register("mythril_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    
    // Blocks - pressure plates
    public static final DeferredBlock<MultifunctionPressurePlateBlock> copper_pressure_plate = BLOCKS.register("copper_pressure_plate",
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.LIVING_WEIGHTED, 10, 
                                                      BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                                                        .noCollission().strength(0.5F).sound(SoundType.COPPER), BlockSetType.IRON));
    
    public static final DeferredBlock<MultifunctionPressurePlateBlock> tin_pressure_plate = BLOCKS.register("tin_pressure_plate",
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                      BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL), BlockSetType.IRON));
    
    public static final DeferredBlock<MultifunctionPressurePlateBlock> mythril_pressure_plate = BLOCKS.register("mythril_pressure_plate",
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.MOBS_WEIGHTED, 10, 
                                                      BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL),BlockSetType.GOLD));
    
    public static final DeferredBlock<MultifunctionPressurePlateBlock> adamantium_pressure_plate = BLOCKS.register("adamantium_pressure_plate",
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                      BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL),BlockSetType.GOLD));

    public static final DeferredBlock<MultifunctionPressurePlateBlock> onyx_pressure_plate = BLOCKS.register("onyx_pressure_plate",
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.PLAYERS, 20, 
                                                      BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                                                        .noCollission().strength(0.5F).sound(SoundType.STONE), BlockSetType.STONE));
}  // end class ModBlocks
