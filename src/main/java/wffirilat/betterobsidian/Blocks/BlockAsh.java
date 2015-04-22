package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.creativetab.CreativeTabs;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockAsh extends BlockFalling {

	public String name = "ash";

	public BlockAsh() {
		super();
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);
	}

}
