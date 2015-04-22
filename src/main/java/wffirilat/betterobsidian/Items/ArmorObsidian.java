package wffirilat.betterobsidian.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import wffirilat.betterobsidian.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorObsidian extends ItemArmor {
	
    //private String name = "obsidianHelmet";
    
    public ArmorObsidian(ArmorMaterial material, int armorType, String name) {
        
    	super(material, 0, armorType);
        setUnlocalizedName(Constants.MODID + "_" + name);
        setTextureName(Constants.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(CreativeTabs.tabCombat);
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
    	if(stack.getItem()==ModItems.obsidianLeggings){
    		return Constants.MODID+":models/armor/obsidianArmor2.png";
    	}
    	else if(stack.getItem()==ModItems.obsidianBoots || stack.getItem()==ModItems.obsidianChestplate || stack.getItem()==ModItems.obsidianHelmet ){
    		return Constants.MODID+":models/armor/obsidianArmor1.png";
    	}
    	else{
    		System.out.println("Invalid Item obsidianArmor");
    		return null;
    	}
    }
}