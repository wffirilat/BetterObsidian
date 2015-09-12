package wffirilat.betterobsidian.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import wffirilat.betterobsidian.Constants;

public class ModItems {
	
	public static Item obsidianIngot;
	
	public static Item obsidianPick;
	public static Item obsidianSword;
	public static Item obsidianAxe;
	public static Item obsidianShovel;

	public static Item bedrockPick;
	public static Item bedrockSword;
	public static Item bedrockAxe;
	public static Item bedrockShovel;

	public static Item obsidianHelmet;
	public static Item obsidianChestplate;
	public static Item obsidianLeggings;
	public static Item obsidianBoots;
	
	public static Item GEN_TEST;
	
	public static void init() {
		
		ToolMaterial obsidian = EnumHelper.addToolMaterial("obsidian", 4, 8192, 12.0f, 5.0f, 50);

		ToolMaterial bedrock = EnumHelper.addToolMaterial("bedrock", 4, -1, 50, 13, 0);

		ArmorMaterial ObsidianArmor = EnumHelper.addArmorMaterial("ObsidianArmor", "obsidianArmor", 50, new int[] { 5, 8, 7, 5 }, 50);
		
		obsidianIngot = new ObsidianIngot();
		
		obsidianPick = new ToolModPick(obsidian, "obsidianPick");
		obsidianSword = new ToolModSword(obsidian, "obsidianSword");
		obsidianAxe = new ToolModAxe(obsidian, "obsidianAxe");
		obsidianShovel = new ToolModShovel(obsidian, "obsidianShovel");
		
		bedrockPick = new ToolModPick(bedrock, "bedrockPick");
		bedrockSword = new ToolModSword(bedrock, "bedrockSword");
		bedrockAxe = new ToolModAxe(bedrock, "bedrockAxe");
		bedrockShovel = new ToolModShovel(bedrock, "bedrockShovel");
		
		obsidianHelmet = new ArmorObsidian(ObsidianArmor, 0, "obsidianHelmet");
		obsidianChestplate = new ArmorObsidian(ObsidianArmor, 1, "obsidianChestplate");
		obsidianLeggings = new ArmorObsidian(ObsidianArmor, 2, "obsidianLeggings");
		obsidianBoots = new ArmorObsidian(ObsidianArmor, 3, "obsidianBoots");
		
		GEN_TEST = new GenItem();
	}
	
	public static void registerRenderers() {
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		ItemModelMesher mesher = renderItem.getItemModelMesher();
		
    	mesher.register(obsidianIngot, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ObsidianIngot) obsidianIngot).name, "inventory"));
    	
    	mesher.register(obsidianPick, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModPick) obsidianPick).name, "inventory"));
    	mesher.register(obsidianSword, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModSword) obsidianSword).name, "inventory"));
    	mesher.register(obsidianAxe, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModAxe) obsidianAxe).name, "inventory"));
    	mesher.register(obsidianShovel, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModShovel) obsidianShovel).name, "inventory"));

    	mesher.register(bedrockPick, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModPick) bedrockPick).name, "inventory"));
    	mesher.register(bedrockSword, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModSword) bedrockSword).name, "inventory"));
    	mesher.register(bedrockAxe, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModAxe) bedrockAxe).name, "inventory"));
    	mesher.register(bedrockShovel, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ToolModShovel) bedrockShovel).name, "inventory"));   	

    	mesher.register(obsidianHelmet, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ArmorObsidian) obsidianHelmet).name, "inventory"));
    	mesher.register(obsidianChestplate, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ArmorObsidian) obsidianChestplate).name, "inventory"));
    	mesher.register(obsidianLeggings, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ArmorObsidian) obsidianLeggings).name, "inventory"));
    	mesher.register(obsidianBoots, 0, new ModelResourceLocation(Constants.MODID + ":" + ((ArmorObsidian) obsidianBoots).name, "inventory"));
	}

}
