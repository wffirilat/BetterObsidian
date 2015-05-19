package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class VoidBlock extends Block {

	public String name = "voidBlock";

	public VoidBlock() {

		super(Material.rock);
		this.slipperiness = 0.1f;
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);

	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.attackEntityFrom(DamageSource.magic, 5.0F);

	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9) {
		w.playSoundAtEntity(p, "", 1.0f, 1.0f);
		if (!w.isRemote) {
			w.setBlock(x, y, z, Blocks.air);
			for (int i1 = -3; i1 <= 3; i1++) {
				for (int j1 = 3; j1 >= -3; j1--) {
					for (int k1 = -3; k1 <= 3; k1++) {
						if (y + j1 > 0 || i1 == 0 && j1 == -1 && k1 == 0) {
							if (!p.capabilities.isCreativeMode) {
								p.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(w.getBlock(x + i1, y + j1, z + k1)), 1, w.getBlockMetadata(x + i1, y + j1, z + k1)));
							}
							w.setBlock(x + i1, y + j1, z + k1, Blocks.air);

						}
						if (i1 == 0 && j1 == -1 && k1 == 0) {

						}
					}
				}
			}

			p.inventoryContainer.detectAndSendChanges();
		}
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox(x + f, y + f, z + f, x + 1 - f, y + 1 - f, z + 1 - f);
	}

}
