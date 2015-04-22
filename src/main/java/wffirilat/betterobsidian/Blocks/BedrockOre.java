package wffirilat.betterobsidian.Blocks;

import java.util.Random;

import wffirilat.betterobsidian.Items.ModItems;
import wffirilat.betterobsidian.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BedrockOre extends Block {

	public String name = "bedrockOre";

	public BedrockOre() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 4);
		GameRegistry.registerBlock(this, name);
	}

	public Item getItemDropped(int p_149650_1_, Random rand, int fortune) {
		return ModItems.bedrockShard;
	}
}