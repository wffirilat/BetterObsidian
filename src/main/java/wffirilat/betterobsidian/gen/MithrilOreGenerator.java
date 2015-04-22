package wffirilat.betterobsidian.gen;

import java.util.Random;

import wffirilat.betterobsidian.Blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MithrilOreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1:
				generateInNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateInOverworld(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				generateInEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
	}

	private void generateInEnd(World world, Random random, int x, int z) {}

	private void generateInOverworld(World world, Random random, int x, int z) {}

	private void generateInNether(World world, Random random, int chunkX, int chunkZ) {
		int rarity = 4;
		int maxHeight = 128;
		for (int i = 0; i < rarity; i++) {

			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(maxHeight);
			int z = chunkZ + random.nextInt(16);
			
			new WorldGenMinable(ModBlocks.mithrilOre, 8, Blocks.netherrack).generate(world, random, x, y, z);
			
		}
	}
}
