package wffirilat.betterobsidian.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wffirilat.betterobsidian.Items.ModItems;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class RainbowOre extends Block {

	public String name = "fossilRainbow";

	public RainbowOre() {

		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		this.lightOpacity=0;
		GameRegistry.registerBlock(this, name);
	}
	
	public boolean blocksMovement(){
		return false;
	}
	
    public Item getItemDropped(int p_149650_1_, Random rand, int fortune)
    {
        return fortune == 3 && rand.nextInt(3) == 0 ? ModItems.rainbowFossil : ModItems.rainbowShard;
    }
    
}