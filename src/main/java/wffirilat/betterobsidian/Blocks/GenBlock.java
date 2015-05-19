package wffirilat.betterobsidian.Blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import wffirilat.betterobsidian.gen.ReallyBigTree;

public class GenBlock extends ModBlock {

	public GenBlock() {
		super("genBlock");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float faceX, float faceY, float faceZ) {
		ReallyBigTree gen = new ReallyBigTree(true);
		gen.setScale(2.0d, 2.0d, 2.0d);
		return gen.generate(world, world.rand, x, y, z);
	}

}
