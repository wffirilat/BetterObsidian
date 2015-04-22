package wffirilat.betterobsidian.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class NetherFurnace extends Block {

	public String name = "netherFurnace";

	public NetherFurnace() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 4);
		GameRegistry.registerBlock(this, name);
	}
	
	public Block[][][] getMap(){
		
		Block N = Blocks.nether_brick;
		Block X = null;
		Block A = Blocks.air;
		
		return new Block[][][] { { { X, X, N, N, N, X, X }, { X, X, N, N, N, X, X }, { N, N, N, N, N, N, N }, { N, N, N, X, N, N, N }, { N, N, N, N, N, N, N }, { X, X, N, N, N, X, X }, { X, X, N, N, N, X, X } },

				{ { X, X, X, X, X, X, X }, { X, X, N, A, N, X, X }, { X, X, N, A, N, N, X }, { X, A, A, A, A, A, X }, { X, X, N, A, N, N, X }, { X, X, N, A, N, X, X }, { X, X, X, X, X, X, X } },

				{ { X, X, X, X, X, X, X }, { X, X, X, A, X, X, X }, { X, X, N, N, N, X, X }, { X, A, N, A, N, A, X }, { X, X, N, N, N, X, X }, { X, X, X, A, X, X, X }, { X, X, X, X, X, X, X } } };
	}

	public boolean getStructureIsValid(World w, int x, int y, int z, EntityPlayer p) {

		Block[][][] map = getMap();

		for (int y1 = 0; y1 < 3; y1++) {
			for (int x1 = -3; x1 <= 3; x1++) {
				for (int z1 = -3; z1 <= 3; z1++) {
					Block b = map[y1][x1 + 3][z1 + 3];
					if ((b != null) && (w.getBlock(x + x1, y + y1, z + z1) != b)) {
						return false;
					}
				}
			}
		}
		return true;

	}

	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int par6, float par7, float par8, float par9) {
		if (getStructureIsValid(w, x, y, z, p)) {
			w.setBlock(x, y + 1, z, Blocks.obsidian);
			return true;
		}
		return false;
	}

}