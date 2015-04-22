package wffirilat.betterobsidian.Blocks;

import java.util.Random;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class SuperCompressedCobble extends Block {

	public String name = "superCompressedCobble";

	public SuperCompressedCobble() {

		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);

	}

	public Item getItemDropped(int p_149650_1_, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.cobblestone);
	}

	public int quantityDropped(Random r) {
		return 81;
	}
}