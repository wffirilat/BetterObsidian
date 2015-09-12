package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;

public class ToolModSword extends ItemSword {
	
	public String name;

	public ToolModSword(ToolMaterial material, String name) {

		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabCombat);
	}
}
