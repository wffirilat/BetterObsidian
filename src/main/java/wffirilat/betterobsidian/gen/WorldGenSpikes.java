package wffirilat.betterobsidian.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpikes extends WorldGenerator {
	
	public IBlockState block;
	public int minHeight;
	public int variation;
	public int spireChance;
	public int spireHeightMax;
	public int heightOffset;

	public WorldGenSpikes(IBlockState block) {
		this(block, 7, 4);
	}

	public WorldGenSpikes(IBlockState block, int minHeight, int variation) {
		this(block, minHeight, variation, 60, 30);
	}

	public WorldGenSpikes(IBlockState block, int minHeight, int variation, int spireChance, int spireHeightMax) {
		this(block, minHeight, variation, spireChance, spireHeightMax, 0);
	}

	public WorldGenSpikes(IBlockState block, int minHeight, int variation, int spireChance, int spireHeightMax, int heightOffset) {
		super();
		this.block = block;
		this.minHeight = minHeight;
		this.variation = variation;
		this.spireChance = spireChance;
		this.spireHeightMax = spireHeightMax;
		this.heightOffset = heightOffset;
	}

	public boolean generate(World world, Random rand, BlockPos pos) {
		while (world.isAirBlock(pos) && pos.getY() > 2) {
			pos = pos.down();
		}
		pos = pos.up(rand.nextInt(4) + this.heightOffset);
		int height = rand.nextInt(this.variation) + this.minHeight;
		int width = height / 4 + rand.nextInt(2);

		if (width > 1 && rand.nextInt(this.spireChance) == 0) {
			pos = pos.up(10 + rand.nextInt(this.spireHeightMax));
		}

		int y1;
		int l;

		for (y1 = 0; y1 < height; ++y1) {
			float f = (1.0F - (float) y1 / (float) height) * (float) width;
			l = MathHelper.ceiling_float_int(f);

			for (int x1 = -l; x1 <= l; ++x1) {
				float f1 = (float) MathHelper.abs_int(x1) - 0.25F;

				for (int z1 = -l; z1 <= l; ++z1) {
					float f2 = (float) MathHelper.abs_int(z1) - 0.25F;

					if ((x1 == 0 && z1 == 0 || f1 * f1 + f2 * f2 <= f * f)
							&& (x1 != -l && x1 != l && z1 != -l && z1 != l || rand.nextFloat() <= 0.75F)) {
						Block block = world.getBlockState(pos.add(x1, y1, z1)).getBlock();

						if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow
								|| block == Blocks.ice) {
							world.setBlockState(pos.add(x1, y1, z1), this.block);
						}

						if (y1 != 0 && l > 1) {
							block = world.getBlockState(pos.add(x1, -y1, z1)).getBlock();

							if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow
									|| block == Blocks.ice) {
								world.setBlockState(pos.add(x1, -y1, z1), this.block);
							}
						}
					}
				}
			}
		}

		y1 = width - 1;

		if (y1 < 0) {
			y1 = 0;
		} else if (y1 > 1) {
			y1 = 1;
		}

		for (int k1 = -y1; k1 <= y1; ++k1) {
			l = -y1;

			while (l <= y1) {
				BlockPos blockpos1 = pos.add(k1, -1, l);
				int l1 = 50;

				if (Math.abs(k1) == 1 && Math.abs(l) == 1) {
					l1 = rand.nextInt(5);
				}

				while (true) {
					if (blockpos1.getY() > 50) {
						Block block1 = world.getBlockState(blockpos1).getBlock();

						if (block1.getMaterial() == Material.air || block1 == Blocks.dirt || block1 == Blocks.snow
								|| block1 == Blocks.ice || block1 == Blocks.packed_ice) {
							world.setBlockState(blockpos1, this.block);
							blockpos1 = blockpos1.down();
							--l1;

							if (l1 <= 0) {
								blockpos1 = blockpos1.down(rand.nextInt(5) + 1);
								l1 = rand.nextInt(5);
							}

							continue;
						}
					}

					++l;
					break;
				}
			}
		}

		return true;

	}
}