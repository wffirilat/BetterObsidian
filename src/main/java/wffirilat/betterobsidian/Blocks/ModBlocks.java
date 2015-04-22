package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public final class ModBlocks {

	public static Block cobblesidian;
	public static Block obsidianBricks;
	public static Block bedrockOre;
	public static Block voidBlock;
	public static Block fossilRainbow;
	public static Block glowAir;
	public static Block compressedCobble;
	public static Block superCompressedCobble;
	public static Block ash;
	public static Block basalt;
	public static Block geyser;
	public static Block lavaGeyser;

	public static void init() {
		cobblesidian = new Cobblesidian().setHardness(10.0f).setResistance(2000.0f);
		obsidianBricks = new ObsidianBricks().setHardness(50.0f).setResistance(2000.0f);
		bedrockOre = new BedrockOre().setHardness(250f).setResistance(6000000f);
		voidBlock = new VoidBlock();
		fossilRainbow = new RainbowOre();
		glowAir = new GlowAir().setLightLevel(1f);
		compressedCobble = new CompressedCobble().setHardness(8.0f).setResistance(40f);
		superCompressedCobble = new SuperCompressedCobble().setHardness(32.0f).setResistance(160f);
		ash = new BlockAsh().setHardness(0.5f).setResistance(10.0f).setStepSound(Block.soundTypeSand);
		basalt = new ModBlock("basalt").setHardness(1.5f).setResistance(15.0f);
		geyser = new BlockGeyser(Blocks.water, "geyser").setHardness(1.5f).setResistance(15.0f);
		lavaGeyser = new BlockGeyser(Blocks.lava, "lavaGeyser").setHardness(1.5f).setResistance(15.0f);
	}
}