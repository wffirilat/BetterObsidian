package wffirilat.betterobsidian.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class SuperCompressedCobble extends Block {

	public String name = "superCompressedCobble";

	public SuperCompressedCobble() {

		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);

	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.cobblestone);
	}

	@Override
	public int quantityDropped(Random r) {
		return 81;
	}
}