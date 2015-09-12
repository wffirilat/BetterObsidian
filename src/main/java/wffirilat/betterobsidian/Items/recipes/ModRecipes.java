package wffirilat.betterobsidian.items.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wffirilat.betterobsidian.blocks.ModBlocks;
import wffirilat.betterobsidian.items.ModItems;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(new ItemStack(ModBlocks.cobblesidian), new ItemStack(Blocks.obsidian), 3.5f);
		GameRegistry.addSmelting(new ItemStack(Blocks.obsidian), new ItemStack(ModItems.obsidianIngot), 6.5f);

		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianPick), "III", " S ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), "II ", "IS ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianShovel), " I ", " S ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianSword), " I ", " I ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianBoots), "   ", "I I", "I I", 'I', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHelmet), "IDI", "I I", "   ", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianLeggings), "IDI", "I I", "I I", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianChestplate), "I I", "IDI", "IDI", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
	}

}
