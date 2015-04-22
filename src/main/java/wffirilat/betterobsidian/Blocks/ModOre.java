package wffirilat.betterobsidian.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModOre extends Block {

	private Item drop;

	public ModOre(String name, Item drop) {
		this(name, drop, 1, "pickaxe");
	}

	public ModOre(String name, Item drop, int harvestLevel) {
		this(name, drop, harvestLevel, "pickaxe");
	}

	public ModOre(String name, Item drop, int harvestLevel, String harvestTool) {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel(harvestTool, harvestLevel);
		this.drop = drop;
		GameRegistry.registerBlock(this, name);

	}

	public Item getItemsDropped(int par1, Random rand, int fortune) {
		return this.drop;
	}

}
