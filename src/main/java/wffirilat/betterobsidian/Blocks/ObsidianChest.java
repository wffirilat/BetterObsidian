package wffirilat.betterobsidian.Blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import wffirilat.betterobsidian.tileEntity.TileEntityObsidianChest;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ObsidianChest extends BlockChest {

	private final Random field_149955_b = new Random();
	public String name = "obsidianChest";

	protected ObsidianChest(int chest) {
		super(chest);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		this.lightOpacity = 0;
		GameRegistry.registerBlock(this, name);

	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);
		byte meta = 0;
		int face = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (face == 0) {
			meta = 2;
		}

		if (face == 1) {
			meta = 5;
		}

		if (face == 2) {
			meta = 3;
		}

		if (face == 3) {
			meta = 4;
		}

		if (block != this && block1 != this && block2 != this && block3 != this) {
			world.setBlockMetadataWithNotify(x, y, z, meta, 3);
		} else {
			if ((block == this || block1 == this) && (meta == 4 || meta == 5)) {
				if (block == this) {
					world.setBlockMetadataWithNotify(x, y, z - 1, meta, 3);
				} else {
					world.setBlockMetadataWithNotify(x, y, z + 1, meta, 3);
				}

				world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			}

			if ((block2 == this || block3 == this) && (meta == 2 || meta == 3)) {
				if (block2 == this) {
					world.setBlockMetadataWithNotify(x - 1, y, z, meta, 3);
				} else {
					world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
				}

				world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			}
		}

		if (item.hasDisplayName()) {
			((TileEntityObsidianChest) world.getTileEntity(x, y, z)).func_145976_a(item.getDisplayName());
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		TileEntityObsidianChest tileentitychest = (TileEntityObsidianChest) world.getTileEntity(x, y, z);

		if (tileentitychest != null) {
			tileentitychest.updateContainingBlockInfo();
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int face) {
		TileEntityObsidianChest tileentitychest = (TileEntityObsidianChest) world.getTileEntity(x, y, z);

		if (tileentitychest != null) {
			for (int i1 = 0; i1 < tileentitychest.getSizeInventory(); ++i1) {
				ItemStack itemstack = tileentitychest.getStackInSlot(i1);

				if (itemstack != null) {
					float f = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.field_149955_b.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
						int j1 = this.field_149955_b.nextInt(21) + 10;

						if (j1 > itemstack.stackSize) {
							j1 = itemstack.stackSize;
						}

						itemstack.stackSize -= j1;
						entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.field_149955_b.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.field_149955_b.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.field_149955_b.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, face);
	}

	public IInventory func_149951_m(World world, int x, int y, int z) {
		Object object = (TileEntityObsidianChest) world.getTileEntity(x, y, z);

		if (object == null) {
			return null;
		} else if (world.isSideSolid(x, y + 1, z, DOWN)) {
			return null;
		} else if (func_149953_o(world, x, y, z)) {
			return null;
		} else if (world.getBlock(x - 1, y, z) == this && (world.isSideSolid(x - 1, y + 1, z, DOWN) || func_149953_o(world, x - 1, y, z))) {
			return null;
		} else if (world.getBlock(x + 1, y, z) == this && (world.isSideSolid(x + 1, y + 1, z, DOWN) || func_149953_o(world, x + 1, y, z))) {
			return null;
		} else if (world.getBlock(x, y, z - 1) == this && (world.isSideSolid(x, y + 1, z - 1, DOWN) || func_149953_o(world, x, y, z - 1))) {
			return null;
		} else if (world.getBlock(x, y, z + 1) == this && (world.isSideSolid(x, y + 1, z + 1, DOWN) || func_149953_o(world, x, y, z + 1))) {
			return null;
		} else {
			if (world.getBlock(x - 1, y, z) == this) {
				object = new InventoryLargeChest("largeObsidianChest", (TileEntityObsidianChest) world.getTileEntity(x - 1, y, z), (IInventory) object);
			}

			if (world.getBlock(x + 1, y, z) == this) {
				object = new InventoryLargeChest("largeObsidianChest", (IInventory) object, (TileEntityObsidianChest) world.getTileEntity(x + 1, y, z));
			}

			if (world.getBlock(x, y, z - 1) == this) {
				object = new InventoryLargeChest("largeObsidianChest", (TileEntityObsidianChest) world.getTileEntity(x, y, z - 1), (IInventory) object);
			}

			if (world.getBlock(x, y, z + 1) == this) {
				object = new InventoryLargeChest("largeObsidianChest", (IInventory) object, (TileEntityObsidianChest) world.getTileEntity(x, y, z + 1));
			}

			return (IInventory) object;
		}
	}

	private static boolean func_149953_o(World world, int x, int y, int z) {
		Iterator iterator = world.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double) x, (double) (y + 1), (double) z, (double) (x + 1), (double) (y + 2), (double) (z + 1))).iterator();
		EntityOcelot entityocelot;

		do {
			if (!iterator.hasNext()) {
				return false;
			}

			Entity entity = (Entity) iterator.next();
			entityocelot = (EntityOcelot) entity;
		} while (!entityocelot.isSitting());

		return true;
	}

	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		TileEntityObsidianChest tileentitychest = new TileEntityObsidianChest();
		return tileentitychest;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(Constants.MODID + ":obsidianChest");
	}

}
