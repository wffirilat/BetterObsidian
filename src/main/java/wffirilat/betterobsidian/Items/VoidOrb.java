package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class VoidOrb extends Item {

	private String name = "voidOrb";

	public VoidOrb() {

		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
		if (!p.capabilities.isCreativeMode) {
			--i.stackSize;
		}
		if (!w.isRemote) {
			for (int i1 = -1; i1 <= 1; i1++) {
				for (int j1 = 2; j1 >= -1; j1--) {
					for (int k1 = -1; k1 <= 1; k1++) {
						if ((int) p.posY + j1 > 0) {
							if (!p.capabilities.isCreativeMode) {
								p.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(w.getBlock((int) p.posX + i1, (int) p.posY + j1, (int) p.posZ + k1)), 1, w.getBlockMetadata((int) p.posX + i1, (int) p.posY + j1, (int) p.posZ + k1)));
							}
							w.setBlock((int) p.posX + i1, (int) p.posY + j1, (int) p.posZ + k1, Blocks.air);

						}
					}
				}
			}
			p.inventoryContainer.detectAndSendChanges();
		}
		return i;
	}
}
