package wffirilat.betterobsidian.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCyl extends WorldGenerator {

	private Block block;
	private int radX;
	private int radZ;
	private int height;
	private boolean hollow;

	public WorldGenCyl(Block block, int rad) {
		this(block, rad, rad, 1, true);
	}

	public WorldGenCyl(Block block, int rad, int height) {
		this(block, rad, rad, height, true);
	}

	public WorldGenCyl(Block block, int radX, int radZ, int height) {
		this(block, radX, radZ, height, true);
	}

	public WorldGenCyl(Block block, int rad, boolean hollow) {
		this(block, rad, rad, 1, hollow);
	}

	public WorldGenCyl(Block block, int rad, int height, boolean hollow) {
		this(block, rad, rad, height, hollow);
	}

	public WorldGenCyl(Block block, int radX, int radZ, int height, boolean hollow) {
		this.block = block;
		this.radX = radX;
		this.radZ = radZ;
		this.height = height;
		this.hollow = hollow;
	}

	public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
		for (int y1 = 0; y1 < height; y1++) {
			for (int x1 = -radX; x1 <= radX; x1++) {
				for (int z1 = -radZ; z1 <= radZ; z1++) {
					
				}
			}
		}
		return false;
	}

}
