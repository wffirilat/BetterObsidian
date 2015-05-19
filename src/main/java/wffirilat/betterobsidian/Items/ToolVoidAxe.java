package wffirilat.betterobsidian.Items;

import java.util.ArrayDeque;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolVoidAxe extends ItemAxe {

	private String name = "voidAxe";

	public ToolVoidAxe(ToolMaterial material) {

		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabTools);
	}

	public boolean mine(World world, EntityPlayer player, int xPos, int yPos, int zPos, Block block) {
		int total = 0;
		int x;
		int y;
		int z;
		System.out.println("i called it");
		ArrayDeque stack = new ArrayDeque();
		stack.add(Vec3.createVectorHelper(xPos, yPos, zPos));
		while (!stack.isEmpty()) {
			if (total >= 64) {
				return false;
			}
			Vec3 pos = (Vec3) stack.poll();
			x = (int) pos.xCoord;
			y = (int) pos.yCoord;
			z = (int) pos.zCoord;
			if (world.getBlock(x, y, z) != block) {
				continue;
			}
			if (!world.isRemote && y > 0) {
				if (!player.capabilities.isCreativeMode) {
					player.inventory.addItemStackToInventory(new ItemStack(block.getItemDropped(1, itemRand, 0), block.quantityDropped(itemRand), block.damageDropped(0)));
				}
				world.setBlock(x, y, z, Blocks.air);
			}
			total++;
			stack.add(Vec3.createVectorHelper(x + 1, y, z));
			stack.add(Vec3.createVectorHelper(x - 1, y, z));
			stack.add(Vec3.createVectorHelper(x, y + 1, z));
			stack.add(Vec3.createVectorHelper(x, y - 1, z));
			stack.add(Vec3.createVectorHelper(x, y, z + 1));
			stack.add(Vec3.createVectorHelper(x, y, z - 1));

		}
		return true;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int xPos, int yPos, int zPos, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		String h = world.getBlock(xPos, yPos, zPos).getHarvestTool(world.getBlockMetadata(xPos, yPos, zPos));
		if (!world.isRemote && (h == null || h == "axe")) {
			mine(world, player, xPos, yPos, zPos, world.getBlock(xPos, yPos, zPos));
			player.inventoryContainer.detectAndSendChanges();
			return true;
		}
		return false;
	}

	@Override
	public void onCreated(ItemStack item, World world, EntityPlayer player) {
		player.attackEntityFrom(DamageSource.magic, 19);
	}

}
