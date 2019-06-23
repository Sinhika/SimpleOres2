package mod.alexndr.simpleores.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ShearsItem;
import net.minecraft.tags.BlockTags;

public class SimpleShears extends ShearsItem 
{

	public SimpleShears(Properties builder) 
	{
		super(builder);
	}

	@Override
	public boolean canHarvestBlock(BlockState blockIn) 
	{
		boolean canHarvest = super.canHarvestBlock(blockIn); 
		if (canHarvest)	return true;

		Block block = blockIn.getBlock();
		return block.isIn(BlockTags.LEAVES) || block == Blocks.GRASS || block == Blocks.FERN
				|| block == Blocks.DEAD_BUSH || block == Blocks.VINE;
	} // end canHarvestBlock()

	
} // end class SimpleShears
