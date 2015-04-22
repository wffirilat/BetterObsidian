package wffirilat.betterobsidian.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenIceSpike;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class iceSpike extends Block {

	public String name = "iceSpike";
	private int width;
	private Block block = Blocks.obsidian;

	public iceSpike() {

		super(Material.rock);
		this.slipperiness = 0.1f;
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);

	}

	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float sideX, float sideY, float sideZ) {
		WorldGenIceSpike g = new WorldGenIceSpike();
		return g.generate(w, w.rand, x, y-1, z);
	}

	public boolean generate(World world, Random rand, int x, int y, int z) {
		while (world.isAirBlock(x, y, z) && y > 2) {
			--y;
		}

		if (world.getBlock(x, y, z) != Blocks.snow) {
			return false;
		} else {
			int width = rand.nextInt(this.width - 2) + 2;
			byte b0 = 1;

			for (int x1 = x - width; x1 <= x + width; ++x1) {
				for (int z1 = z - width; z1 <= z + width; ++z1) {
					int dx = x1 - x;
					int dz = z1 - z;

					if (dx * dx + dz * dz <= width * width) {
						for (int i2 = y - b0; i2 <= y + b0; ++i2) {
							Block block = world.getBlock(x1, i2, z1);

							if (block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice) {
								world.setBlock(x1, i2, z1, this.block, 0, 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
	
	public boolean generateSpike(World world, Random rand, int x, int y, int z)
    {
        while (world.isAirBlock(x, y, z) && y > 2)
        {
            --y;
        }

        if (world.getBlock(x, y, z) != Blocks.snow)
        {
            return false;
        }
        else
        {
            y += rand.nextInt(4);
            int height = rand.nextInt(4) + 7;
            int width = height / 4 + rand.nextInt(2);

            if (width > 1 && rand.nextInt(60) == 0)
            {
                y += 10 + rand.nextInt(30);
            }

            int y1;
            int thickness;
            int x1;
            
            for (y1 = 0; y1 < height; ++y1)
            {
                float remainder = (1.0F - (float)y1 / (float)height) * (float)width;
                thickness = MathHelper.ceiling_float_int(remainder);

                for (x1 = -thickness; x1 <= thickness; ++x1)
                {
                    float f1 = (float)MathHelper.abs_int(x1) - 0.25F;

                    for (int z1 = -thickness; z1 <= thickness; ++z1)
                    {
                        float f2 = (float)MathHelper.abs_int(z1) - 0.25F;

                        if ((x1 == 0 && z1 == 0 || f1 * f1 + f2 * f2 <= remainder * remainder) && (x1 != -thickness && x1 != thickness && z1 != -thickness && z1 != thickness || rand.nextFloat() <= 0.75F))
                        {
                            Block block = world.getBlock(x + x1, y + y1, z + z1);

                            if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice)
                            {
                                world.setBlock(x + x1, y + y1, z + z1, this.block);
                            }

                            if (y1 != 0 && thickness > 1)
                            {
                                block = world.getBlock(x + x1, y - y1, z + z1);

                                if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice)
                                {
                                    world.setBlock(x + x1, y - y1, z + z1, this.block);
                                }
                            }
                        }
                    }
                }
            }

            y1 = width - 1;

            if (y1 < 0)
            {
                y1 = 0;
            }
            else if (y1 > 1)
            {
                y1 = 1;
            }

            for (int j2 = -y1; j2 <= y1; ++j2)
            {
                thickness = -y1;

                while (thickness <= y1)
                {
                    x1 = y - 1;
                    int k2 = 50;

                    if (Math.abs(j2) == 1 && Math.abs(thickness) == 1)
                    {
                        k2 = rand.nextInt(5);
                    }

                    while (true)
                    {
                        if (x1 > 50)
                        {
                            Block block1 = world.getBlock(x + j2, x1, z + thickness);

                            if (block1.getMaterial() == Material.air || block1 == Blocks.dirt || block1 == Blocks.snow || block1 == Blocks.ice || block1 == Blocks.packed_ice)
                            {
                                world.setBlock(x + j2, x1, z + thickness, this.block);
                                --x1;
                                --k2;

                                if (k2 <= 0)
                                {
                                    x1 -= rand.nextInt(5) + 1;
                                    k2 = rand.nextInt(5);
                                }

                                continue;
                            }
                        }

                        ++thickness;
                        break;
                    }
                }
            }

            return true;
        }
    }

}
