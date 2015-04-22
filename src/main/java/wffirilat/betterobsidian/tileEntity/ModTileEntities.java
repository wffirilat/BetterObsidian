package wffirilat.betterobsidian.tileEntity;

import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(TileEntityObsidianChest.class, Constants.MODID);
	}

}
