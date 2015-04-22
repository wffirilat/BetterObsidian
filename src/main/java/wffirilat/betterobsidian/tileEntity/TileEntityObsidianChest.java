package wffirilat.betterobsidian.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import wffirilat.betterobsidian.Blocks.ObsidianChest;

public class TileEntityObsidianChest extends TileEntityChest {

	private String customName;
	private ItemStack[] chestContents = new ItemStack[45];

	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityObsidianChest adjacentChestZNeg;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityObsidianChest adjacentChestXPos;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityObsidianChest adjacentChestXNeg;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityObsidianChest adjacentChestZPos;
	private int cachedChestType;

	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "obsidianChest";
	}

	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void func_145976_a(String name) {
		this.customName = name;
	}

	public void readFromNBT(NBTTagCompound tags) {
		super.readFromNBT(tags);
		/*NBTTagList nbttaglist = tags.getTagList("Items", 10);
		this.chestContents = new ItemStack[this.getSizeInventory()];

		if (tags.hasKey("CustomName", 8)) {
			this.customName = tags.getString("CustomName");
		}

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.chestContents.length) {
				this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}*/
	}

	public void writeToNBT(NBTTagCompound tags) {
		super.writeToNBT(tags);
		/*NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.chestContents.length; ++i) {
			if (this.chestContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.chestContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		tags.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			tags.setString("CustomName", this.customName);
		}*/
	}

	private void func_145978_a(TileEntityChest chest, int side) {
		if (chest.isInvalid()) {
			this.adjacentChestChecked = false;
		} else if (this.adjacentChestChecked) {
			switch (side) {
				case 0:
					if (this.adjacentChestZPos != chest) {
						this.adjacentChestChecked = false;
					}

					break;
				case 1:
					if (this.adjacentChestXNeg != chest) {
						this.adjacentChestChecked = false;
					}

					break;
				case 2:
					if (this.adjacentChestZNeg != chest) {
						this.adjacentChestChecked = false;
					}

					break;
				case 3:
					if (this.adjacentChestXPos != chest) {
						this.adjacentChestChecked = false;
					}
			}
		}
	}

	public void checkForAdjacentChests() {
		if (!this.adjacentChestChecked) {
			this.adjacentChestChecked = true;
			this.adjacentChestZNeg = null;
			this.adjacentChestXPos = null;
			this.adjacentChestXNeg = null;
			this.adjacentChestZPos = null;

			if (this.func_145977_a(this.xCoord - 1, this.yCoord, this.zCoord)) {
				this.adjacentChestXNeg = (TileEntityObsidianChest) this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
			}

			if (this.func_145977_a(this.xCoord + 1, this.yCoord, this.zCoord)) {
				this.adjacentChestXPos = (TileEntityObsidianChest) this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
			}

			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord - 1)) {
				this.adjacentChestZNeg = (TileEntityObsidianChest) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
			}

			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord + 1)) {
				this.adjacentChestZPos = (TileEntityObsidianChest) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
			}

			if (this.adjacentChestZNeg != null) {
				this.adjacentChestZNeg.func_145978_a(this, 0);
			}

			if (this.adjacentChestZPos != null) {
				this.adjacentChestZPos.func_145978_a(this, 2);
			}

			if (this.adjacentChestXPos != null) {
				this.adjacentChestXPos.func_145978_a(this, 1);
			}

			if (this.adjacentChestXNeg != null) {
				this.adjacentChestXNeg.func_145978_a(this, 3);
			}
		}
	}

	private boolean func_145977_a(int x, int y, int z) {
		if (this.worldObj == null) {
			return false;
		} else {
			Block block = this.worldObj.getBlock(x, y, z);
			return block instanceof ObsidianChest && ((ObsidianChest) block).field_149956_a == this.func_145980_j();
		}
	}

	public int func_145980_j() {
		if (this.cachedChestType == -1) {
			if (this.worldObj == null || !(this.getBlockType() instanceof ObsidianChest)) {
				return 0;
			}

			this.cachedChestType = ((ObsidianChest) this.getBlockType()).field_149956_a;
		}

		return this.cachedChestType;
	}
	
	public int getSizeInventory(){
		return 36;
		
	}

}
