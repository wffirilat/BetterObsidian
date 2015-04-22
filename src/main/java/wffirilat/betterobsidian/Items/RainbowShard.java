package wffirilat.betterobsidian.Items;

import java.util.Random;

import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RainbowShard extends Item {

	private static final float number = 0;
	private static final Block block = null;
	private static final int meta = 0;
	private String name = "rainbowShard";
	private static final Block target = null;
	private static final float pi = (float) Math.PI;

	public RainbowShard() {

		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	public boolean generate(World w, Random rand, int x, int y, int z) {
	
		float randPI = rand.nextFloat() * pi;
		double x0 = (double) ((float) (x + 8) + MathHelper.sin(randPI) * number / 8.0F);
		double x1 = (double) ((float) (x + 8) - MathHelper.sin(randPI) * number / 8.0F);
		double z0 = (double) ((float) (z + 8) + MathHelper.cos(randPI) * number / 8.0F);
		double z1 = (double) ((float) (z + 8) - MathHelper.cos(randPI) * number / 8.0F);
		double ry0 = (double) (y + rand.nextInt(3) - 2);
		double ry1 = (double) (y + rand.nextInt(3) - 2);

		for (int i = 0; i <= this.number; ++i) {
			double x2 = x0 + (x1 - x0) * (double) i / (double) this.number;
			double y2 = ry0 + (ry1 - ry0) * (double) i / (double) this.number;
			double z2 = z0 + (z1 - z0) * (double) i / (double) this.number;
			double r0 = rand.nextDouble() * (double) this.number / 16.0D;
			double d10 = (double) (MathHelper.sin((float) i * pi / number) + 1.0F) * r0 + 1.0D;
			double d11 = (double) (MathHelper.sin((float) i * pi / number) + 1.0F) * r0 + 1.0D;
			int i1 = MathHelper.floor_double(x2 - d10 / 2.0D);
			int j1 = MathHelper.floor_double(y2 - d11 / 2.0D);
			int k1 = MathHelper.floor_double(z2 - d10 / 2.0D);
			int l1 = MathHelper.floor_double(x2 + d10 / 2.0D);
			int i2 = MathHelper.floor_double(y2 + d11 / 2.0D);
			int j2 = MathHelper.floor_double(z2 + d10 / 2.0D);

			for (int k2 = i1; k2 <= l1; ++k2) {
				double d12 = ((double) k2 + 0.5D - x2) / (d10 / 2.0D);

				if (d12 * d12 < 1.0D) {
					for (int l2 = j1; l2 <= i2; ++l2) {
						double d13 = ((double) l2 + 0.5D - y2) / (d11 / 2.0D);

						if (d12 * d12 + d13 * d13 < 1.0D) {
							for (int i3 = k1; i3 <= j2; ++i3) {
								double d14 = ((double) i3 + 0.5D - z2) / (d10 / 2.0D);

								if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && w.getBlock(k2, l2, i3).isReplaceableOreGen(w, k2, l2, i3, target)) {
									w.setBlock(k2, l2, i3, this.block, this.meta, 2);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}
