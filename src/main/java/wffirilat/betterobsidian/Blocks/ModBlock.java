package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlock extends Block {

	public ModBlock(String name) {
		this(Material.rock, name);
		
	}

	public ModBlock(Material mat, String name) {
		super(mat);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		this.lightOpacity = 0;
		GameRegistry.registerBlock(this, name);
	}
}