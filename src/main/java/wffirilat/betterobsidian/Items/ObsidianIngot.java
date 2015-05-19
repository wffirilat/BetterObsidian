package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ObsidianIngot extends Item {

	private String name = "obsidianIngot";

	public ObsidianIngot() {

		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
