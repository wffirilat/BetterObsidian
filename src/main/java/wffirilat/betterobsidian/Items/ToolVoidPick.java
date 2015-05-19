package wffirilat.betterobsidian.Items;

import java.util.ArrayDeque;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolVoidPick extends ItemPickaxe {

	private String name = "voidPick";

	public ToolVoidPick(ToolMaterial material) {

		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabTools);
	}

	public boolean recur(World world, EntityPlayer player, int xPos, int yPos, int zPos, Block block, int iteration) {
		if (iteration <= 3) {
			if (!world.isRemote) {
				if (!player.capabilities.isCreativeMode && world.getBlock(xPos, yPos, zPos) == block) {
					player.inventory.addItemStackToInventory(new ItemStack(block.getItemDropped(1, itemRand, 0), block.quantityDropped(itemRand), world.getBlockMetadata(xPos, yPos, zPos)));
				}
				world.setBlock(xPos, yPos, zPos, Blocks.air);
			}
			for (int i1 = -1; i1 <= 1; i1++) {
				for (int j1 = -1; j1 <= 1; j1++) {
					for (int k1 = -1; k1 <= 1; k1++) {
						if (world.getBlock(xPos + i1, yPos + j1, zPos + k1) == block && !(i1 == 0 && j1 == 0 && k1 == 0) && yPos + j1 > 0) {
							recur(world, player, xPos + i1, yPos + j1, zPos + k1, block, iteration + 1);
						}
					}
				}
			}
			if (!world.isRemote) {
				if (yPos > 0) {
					if (!player.capabilities.isCreativeMode && world.getBlock(xPos, yPos, zPos) == block) {
						player.inventory.addItemStackToInventory(new ItemStack(block.getItemDropped(1, itemRand, 0), block.quantityDropped(itemRand), block.damageDropped(0)));
						world.setBlock(xPos, yPos, zPos, Blocks.air);
					}
				}
			}
		}
		return true;
	}

	public boolean mine(World world, EntityPlayer player, int xPos, int yPos, int zPos, Block block) {
		int total = 0;
		int x;
		int y;
		int z;
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
		if (!world.isRemote && (h == null || h == "pickaxe")) {
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
