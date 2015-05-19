package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorBedrock extends ItemArmor {

	// private String name = "obsidianHelmet";

	public ArmorBedrock(ArmorMaterial material, int armorType, String name) {

		super(material, 0, armorType);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ModItems.bedrockLeggings) {
			return Constants.MODID + ":models/armor/bedrockArmor2.png";
		} else if (stack.getItem() == ModItems.bedrockBoots || stack.getItem() == ModItems.bedrockChestplate || stack.getItem() == ModItems.bedrockHelmet) {
			return Constants.MODID + ":models/armor/bedrockArmor1.png";
		} else {
			System.out.println("Invalid Item bedrockArmor");
			return null;
		}
	}
}