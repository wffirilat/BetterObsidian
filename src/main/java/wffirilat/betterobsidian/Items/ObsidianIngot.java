package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import wffirilat.betterobsidian.Constants;

public class ObsidianIngot extends Item {

	public String name = "obsidianIngot";

	public ObsidianIngot() {
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}
