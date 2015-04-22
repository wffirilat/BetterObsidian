package wffirilat.betterobsidian.lib;

import wffirilat.betterobsidian.gen.BedrockOreGenerator;
import wffirilat.betterobsidian.gen.RainbowOreGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModOreGenerators {

	public static BedrockOreGenerator bedrockOreGen = new BedrockOreGenerator();
	public static RainbowOreGenerator rainbowOreGen = new RainbowOreGenerator();

	public static void init() {

		GameRegistry.registerWorldGenerator(bedrockOreGen, 100);
		GameRegistry.registerWorldGenerator(rainbowOreGen, 1);

	}

}
