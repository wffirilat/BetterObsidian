package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;

public class ToolModPick extends ItemPickaxe {
	
	public String name;

	public ToolModPick(ToolMaterial material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(Constants.MODID + "_" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabTools);
	}
}
