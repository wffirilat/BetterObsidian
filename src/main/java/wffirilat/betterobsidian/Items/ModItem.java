package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItem extends Item {

	public ModItem(String name) {
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
