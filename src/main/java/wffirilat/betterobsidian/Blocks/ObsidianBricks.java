package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ObsidianBricks extends Block {

	public String name = "obsidianBricks";

	public ObsidianBricks() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);
	}
}