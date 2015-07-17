package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.GrowingTree;

public class GenBlock extends ModBlock {

	public GenBlock() {
		super("genBlock");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float faceX, float faceY, float faceZ) {
		GrowingTree maze = new GrowingTree(10, 10, 10);
		maze.generate();
		
		for(int dx = 0; dx < maze.maze.length; dx++) {
			for(int dy = 0; dy < maze.maze[dx].length; dy++) {
				for(int dz = 0; dz < maze.maze[dx][dy].length; dz++) {
					Block block = maze.maze[dx][dy][dz]? Blocks.stone : Blocks.water;
					world.setBlock(x + dx * 2, y + dy * 2, z + dz * 2, block);
					world.setBlock(x + dx * 2, y + dy * 2, z + dz * 2 + 1, block);
					world.setBlock(x + dx * 2, y + dy * 2 + 1, z + dz * 2, block);
					world.setBlock(x + dx * 2, y + dy * 2 + 1, z + dz * 2 + 1, block);
					world.setBlock(x + dx * 2 + 1, y + dy * 2, z + dz * 2, block);
					world.setBlock(x + dx * 2 + 1, y + dy * 2, z + dz * 2 + 1, block);
					world.setBlock(x + dx * 2 + 1, y + dy * 2 + 1, z + dz * 2, block);
					world.setBlock(x + dx * 2 + 1, y + dy * 2 + 1, z + dz * 2 + 1, block);
				}
			}
		}
		
		return true;
	}

}
