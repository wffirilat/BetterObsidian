package wffirilat.betterobsidian.Blocks;

import java.util.List;
import java.util.Random;

import wffirilat.betterobsidian.Items.ModItems;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class NetherReactor extends Block {

	public IIcon inactive;
	public IIcon active;
	public IIcon dead;

	public String name = "netherReactor";

	public NetherReactor() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 3);
		GameRegistry.registerBlock(this, ItemBlockReactor.class, name);
	}

	public Item getItemDropped(int p_149650_1_, Random rand, int fortune) {
		return null;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.inactive = p_149651_1_.registerIcon(this.getTextureName());
		this.active = p_149651_1_.registerIcon(this.getTextureName() + "_active");
		this.dead = p_149651_1_.registerIcon(this.getTextureName() + "_used");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		switch (meta) {
			case 0:
				return this.inactive;
			case 1:
				return this.active;
			case 2:
				return this.dead;
			default:
				return this.dead;
		}
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {

		for (int i = 0; i < 3; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	private void activate(World w, int x, int y, int z) {
		w.setWorldTime(15000);
		w.setBlockMetadataWithNotify(x, y, z, 1, 3);
		for (int x1 = -1; x1 <= 1; x1++) {
			for (int y1 = -1; y1 <= 1; y1++) {
				for (int z1 = -1; z1 <= 1; z1++) {
					if ((x1 != 0 || y1 != 0 || z1 != 0) && w.getBlock(x + x1, y + y1, z + z1) != Blocks.air) {
						w.setBlock(x + x1, y + y1, z + z1, ModBlocks.glowingObsidian);
					}
				}
			}
		}
	}

	private void burnOut(World w, int x, int y, int z) {
		w.setBlockMetadataWithNotify(x, y, z, 2, 3);
		for (int x1 = -1; x1 <= 1; x1++) {
			for (int y1 = -1; y1 <= 1; y1++) {
				for (int z1 = -1; z1 <= 1; z1++) {
					if ((x1 != 0 || y1 != 0 || z1 != 0) && w.getBlock(x + x1, y + y1, z + z1) == ModBlocks.glowingObsidian) {
						w.setBlock(x + x1, y + y1, z + z1, Blocks.obsidian);
					}
				}
			}
		}
	}

	private void reset(World w, int x, int y, int z) {
		w.setWorldTime(3000);
		w.setBlockMetadataWithNotify(x, y, z, 0, 3);
		for (int x1 = -1; x1 <= 1; x1++) {
			for (int y1 = -1; y1 <= 1; y1++) {
				for (int z1 = -1; z1 <= 1; z1++) {
					if ((x1 != 0 || y1 != 0 || z1 != 0) && w.getBlock(x + x1, y + y1, z + z1) == Blocks.obsidian) {
						w.setBlock(x + x1, y + y1, z + z1, Blocks.cobblestone);
					}
					if ((y1 == -1 && Math.abs(x1) == 1 && Math.abs(z1) == 1)) {
						w.setBlock(x + x1, y + y1, z + z1, Blocks.gold_block);
					}
				}
			}
		}
	}

	private Block[][][] getMap() {
		Block A = Blocks.air;
		Block C = Blocks.cobblestone;
		Block G = Blocks.gold_block;
		Block X = this;
		return new Block[][][] { { { G, C, G }, { C, C, C }, { G, C, G } },

		{ { C, A, C }, { A, X, A }, { C, A, C } },

		{ { A, C, A }, { C, C, C }, { A, C, A } } };

	}

	public boolean getStructureIsValid(World w, int x, int y, int z, EntityPlayer p) {

		Block[][][] map = getMap();

		for (int y1 = -1; y1 < 2; y1++) {
			for (int x1 = -1; x1 <= 1; x1++) {
				for (int z1 = -1; z1 <= 1; z1++) {
					Block b = map[y1 + 1][x1 + 1][z1 + 1];
					if ((b != null) && (w.getBlock(x + x1, y + y1, z + z1) != b)) {
						return false;
					}
				}
			}
		}
		if (p.posY < y - 1) {
			return false;
		}
		return true;
	}

	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9) {
		if (!w.isRemote) {
			if (w.getBlockMetadata(x, y, z) == 2) {
				reset(w, x, y, z);
			} else if (w.getBlockMetadata(x, y, z) == 1) {
				burnOut(w, x, y, z);
			} else if (getStructureIsValid(w, x, y, z, p)) {
				activate(w, x, y, z);
			}
		}
		return true;
	}
}