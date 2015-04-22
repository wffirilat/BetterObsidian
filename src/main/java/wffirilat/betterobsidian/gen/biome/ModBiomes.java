package wffirilat.betterobsidian.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes {

	public static BiomeGenBase volcanoBiome;

	public static void init() {
		volcanoBiome = new BiomeGenVolcano(137).setBiomeName("Volcano Planes").setTemperatureRainfall(2.0f, 0.0f);
		BiomeDictionary.registerBiomeType(volcanoBiome, Type.FOREST);
		BiomeManager.addSpawnBiome(volcanoBiome);
	}

}
