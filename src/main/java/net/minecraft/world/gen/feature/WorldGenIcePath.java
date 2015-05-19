package net.minecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class WorldGenIcePath extends WorldGenerator {
	private Block block;
	private int width;
	private static final String __OBFID = "CL_00000416";

	public WorldGenIcePath(int width) {
		this.block = Blocks.packed_ice;
		this.width = width + 2;
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		while (world.isAirBlock(x, y, z) && y > 2) {
			--y;
		}

		if (world.getBlock(x, y, z) != Blocks.snow) {
			return false;
		} else {
			int l = rand.nextInt(this.width - 2) + 2;
			byte b0 = 1;

			for (int i1 = x - l; i1 <= x + l; ++i1) {
				for (int j1 = z - l; j1 <= z + l; ++j1) {
					int k1 = i1 - x;
					int l1 = j1 - z;

					if (k1 * k1 + l1 * l1 <= l * l) {
						for (int i2 = y - b0; i2 <= y + b0; ++i2) {
							Block block = world.getBlock(i1, i2, j1);

							if (block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice) {
								world.setBlock(i1, i2, j1, this.block, 0, 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
}