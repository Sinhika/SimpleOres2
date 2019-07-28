package mod.alexndr.simpleores.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class SimpleMetalBlock extends Block
{
    public SimpleMetalBlock(Properties properties)
    {
        super(properties.sound(SoundType.METAL));
    }

    @Override
    public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon)
    {
        return true;
    }
}  // end class SimpleMetalBlock
