package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;
import wffirilat.betterobsidian.gen.WorldGenSpikes;

public class GenItem extends Item {
	
	public String name = "GEN_ITEM_TEST";

	public GenItem() {
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		return new WorldGenSpikes(Blocks.obsidian.getDefaultState(), 14, 8, 20, 30, 4).generate(world, world.rand, pos);
	}
	

}
