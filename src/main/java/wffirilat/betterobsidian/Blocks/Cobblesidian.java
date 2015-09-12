package wffirilat.betterobsidian.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;

public class Cobblesidian extends Block {
	public String name = "cobblesidian";

	public Cobblesidian() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 2);
	}
}
