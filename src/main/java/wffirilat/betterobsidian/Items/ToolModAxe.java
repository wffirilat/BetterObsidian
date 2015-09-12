package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;

public class ToolModAxe extends ItemAxe {

	public String name;
	
	public ToolModAxe(ToolMaterial material, String name) {

		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabTools);
	}
}
