package mod.alexndr.simpleores.init;

import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;;

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
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleOres.MODID);

    // Ore Blocks
    public static final RegistryObject<DropExperienceBlock> tin_ore = BLOCKS.register("tin_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 3.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> deepslate_tin_ore = BLOCKS.register("deepslate_tin_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 3.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> mythril_ore = BLOCKS.register("mythril_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 4.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> deepslate_mythril_ore = BLOCKS.register("deepslate_mythril_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 4.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> adamantium_ore = BLOCKS.register("adamantium_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 5.0F, 3.0F)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> deepslate_adamantium_ore = BLOCKS.register("deepslate_adamantium_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 5.0F, 3.0F).sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<DropExperienceBlock> onyx_ore = BLOCKS.register("onyx_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength( 7.0F, 3.0F)
                    .requiresCorrectToolForDrops()));

    // Raw_metal blocks
    public static final RegistryObject<Block> raw_tin_block = BLOCKS.register("raw_tin_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(4.0F, 6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_mythril_block = BLOCKS.register("raw_mythril_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 6.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> raw_adamantium_block = BLOCKS.register("raw_adamantium_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN)
                    .strength(7.0F, 12.0F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));
    
    // Metal Blocks
    public static final RegistryObject<Block> tin_block = BLOCKS.register("tin_block",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(4.0F, 6.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> mythril_block = BLOCKS.register("mythril_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(7.0F, 6.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> adamantium_block = BLOCKS.register("adamantium_block",
            () -> new Block(Block.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN)
                    .strength(7.0F, 12.0F).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> onyx_block = BLOCKS.register("onyx_block",
            () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.PODZOL)
                    .strength(20.0F, 100.0F)
                    .requiresCorrectToolForDrops()));
    
    // Blocks - bricks - Simple Ores
//    public static RegistryObject<Block> copper_bricks = BLOCKS.register("copper_bricks",
//            () -> new Block(Block.Properties.copy(Blocks.COPPER_BLOCK)));
    public static RegistryObject<Block> tin_bricks = BLOCKS.register("tin_bricks",
            () -> new Block(Block.Properties.copy(tin_block.get())));
    public static RegistryObject<Block> onyx_bricks = BLOCKS.register("onyx_bricks",
            () -> new Block(Block.Properties.copy(onyx_block.get())));
    public static RegistryObject<Block> adamantium_bricks = BLOCKS.register("adamantium_bricks",
            () -> new Block(Block.Properties.copy(adamantium_block.get())));
    public static RegistryObject<Block> mythril_bricks = BLOCKS.register("mythril_bricks",
            () -> new Block(Block.Properties.copy(mythril_block.get())));

    // blocks - slabs
    public static RegistryObject<SlabBlock> tin_brick_slab = BLOCKS.register("tin_brick_slab",
    		() -> new SlabBlock(Block.Properties.copy(tin_bricks.get())));
    public static RegistryObject<SlabBlock> onyx_brick_slab = BLOCKS.register("onyx_brick_slab",
    		() -> new SlabBlock(Block.Properties.copy(onyx_bricks.get())));
    public static RegistryObject<SlabBlock> mythril_brick_slab = BLOCKS.register("mythril_brick_slab",
    		() -> new SlabBlock(Block.Properties.copy(mythril_bricks.get())));
    public static RegistryObject<SlabBlock> adamantium_brick_slab = BLOCKS.register("adamantium_brick_slab",
    		() -> new SlabBlock(Block.Properties.copy(adamantium_bricks.get())));
            
    // Blocks - stairs - simpleores
//    public static RegistryObject<StairBlock> copper_brick_stairs = BLOCKS.register("copper_brick_stairs", 
//            () -> new StairBlock( () -> copper_bricks.get().defaultBlockState(), 
//                                   Block.Properties.copy(copper_bricks.get())));
    public static RegistryObject<StairBlock> tin_brick_stairs = BLOCKS.register("tin_brick_stairs", 
            () -> new StairBlock( () -> tin_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(tin_bricks.get())));
    public static RegistryObject<StairBlock> onyx_brick_stairs = BLOCKS.register("onyx_brick_stairs", 
            () -> new StairBlock( () -> onyx_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(onyx_bricks.get())));
    public static RegistryObject<StairBlock> adamantium_brick_stairs = BLOCKS.register("adamantium_brick_stairs", 
            () -> new StairBlock( () -> adamantium_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(adamantium_bricks.get())));
    public static RegistryObject<StairBlock> mythril_brick_stairs = BLOCKS.register("mythril_brick_stairs", 
            () -> new StairBlock( () -> mythril_bricks.get().defaultBlockState(), 
                                   Block.Properties.copy(mythril_bricks.get())));

    // Blocks - doors - simpleores
    public static RegistryObject<DoorBlock> copper_door = BLOCKS.register("copper_door",
            () -> new DoorBlock(Block.Properties.copy(Blocks.COPPER_BLOCK).noOcclusion()));
    public static RegistryObject<DoorBlock> tin_door = BLOCKS.register("tin_door",
            () -> new DoorBlock(Block.Properties.copy(tin_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> adamantium_door = BLOCKS.register("adamantium_door",
            () -> new DoorBlock(Block.Properties.copy(adamantium_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> onyx_door = BLOCKS.register("onyx_door",
            () -> new DoorBlock(Block.Properties.copy(onyx_block.get()).noOcclusion()));
    public static RegistryObject<DoorBlock> mythril_door = BLOCKS.register("mythril_door",
            () -> new DoorBlock(Block.Properties.copy(mythril_block.get()).noOcclusion()));
   
    // Blocks - bars - simpleores
    public static RegistryObject<IronBarsBlock> copper_bars = BLOCKS.register("copper_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> tin_bars = BLOCKS.register("tin_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> onyx_bars = BLOCKS.register("onyx_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.STONE, MaterialColor.NONE)
                    .strength(20.0F).requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()));
    public static RegistryObject<IronBarsBlock> adamantium_bars = BLOCKS.register("adamantium_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    public static RegistryObject<IronBarsBlock> mythril_bars = BLOCKS.register("mythril_bars",
            () -> new IronBarsBlock(Block.Properties.of(Material.METAL, MaterialColor.NONE)
                    .strength(7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL).noOcclusion()));
    
    // Blocks - pressure plates
    public static final RegistryObject<MultifunctionPressurePlateBlock> copper_pressure_plate = BLOCKS.register("copper_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.LIVING_WEIGHTED, 10, 
                                                      Block.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE)
                                                        .noCollission().strength(0.5F).sound(SoundType.COPPER)));
    
    public static final RegistryObject<MultifunctionPressurePlateBlock> tin_pressure_plate = BLOCKS.register("tin_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                      Block.Properties.of(Material.METAL)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
    public static final RegistryObject<MultifunctionPressurePlateBlock> mythril_pressure_plate = BLOCKS.register("mythril_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.MOBS_WEIGHTED, 10, 
                                                      Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL)));
    
    public static final RegistryObject<MultifunctionPressurePlateBlock> adamantium_pressure_plate = BLOCKS.register("adamantium_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(75, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING_WEIGHTED, 10, 
                                                      Block.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN)
                                                        .noCollission().strength(0.5F).sound(SoundType.METAL)));

    public static final RegistryObject<MultifunctionPressurePlateBlock> onyx_pressure_plate = BLOCKS.register("onyx_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.PLAYERS, 20, 
                                                      Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                                                        .noCollission().strength(0.5F).sound(SoundType.STONE)));
}  // end class ModBlocks
