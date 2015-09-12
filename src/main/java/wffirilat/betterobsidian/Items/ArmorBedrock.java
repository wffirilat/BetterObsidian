package wffirilat.betterobsidian.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.Constants;

public class ArmorBedrock extends ItemArmor {
	
	public String name;

	public ArmorBedrock(ArmorMaterial material, int armorType, String name) {

		super(material, 0, armorType);
		setUnlocalizedName(Constants.MODID + "_" + name);
		this.name = name;
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ModItems.obsidianLeggings) {
			return Constants.MODID + ":models/armor/bedrockArmor2.png";
		} else if (stack.getItem() == ModItems.obsidianBoots || stack.getItem() == ModItems.obsidianChestplate || stack.getItem() == ModItems.obsidianHelmet) {
			return Constants.MODID + ":models/armor/bedrockArmor1.png";
		} else {
			System.out.println("Invalid Item bedrockArmor");
			return null;
		}
	}
}