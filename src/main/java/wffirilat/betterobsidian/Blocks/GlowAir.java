package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.BlockAir;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class GlowAir extends BlockAir {

	public String name = "glowair";

	public GlowAir() {

		super();
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		//setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);

	}

	@Override
	public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity e) {
		w.setBlock(x, y, z, Blocks.air);
	}
}