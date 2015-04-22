package wffirilat.betterobsidian.gen;

import java.util.Random;

import wffirilat.betterobsidian.Blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class BedrockOreGenerator implements IWorldGenerator {

	//checks whether an int is prime or not.
	public static boolean isPrime(int n) {
		n=Math.abs(n);
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

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

	private void generateInOverworld(World world, Random random, int x, int z) {
		int rarity = 3;
		int maxHeight = 5;
		if (isPrime(x) && isPrime(z)) {
			rarity = 100;
		}
		for (int i = 0; i <= rarity; i++) {

			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextInt(maxHeight);
			int chunkZ = z + random.nextInt(16);

			new WorldGenMinable(ModBlocks.bedrockOre, 4).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}

	private void generateInNether(World world, Random random, int x, int z) {
		int rarity = 6;
		int maxHeight = 5;
		for (int i = 0; i < rarity; i++) {

			int chunkX = x + random.nextInt(16);
			int chunkY = random.nextBoolean() ? random.nextInt(maxHeight) : 128 - random.nextInt(maxHeight);
			int chunkZ = z + random.nextInt(16);

			new WorldGenMinable(ModBlocks.bedrockOre, 4, Blocks.netherrack).generate(world, random, chunkX, chunkY, chunkZ);
		}
	}
}
