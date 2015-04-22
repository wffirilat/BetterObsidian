package wffirilat.betterobsidian.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import wffirilat.betterobsidian.Blocks.ModBlocks;
import wffirilat.betterobsidian.Items.FuelNetherrack;
import wffirilat.betterobsidian.Items.ModItems;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipies {
	
	private static IFuelHandler fuelNetherrack = new FuelNetherrack();

	public static void init() {
		GameRegistry.addSmelting(new ItemStack(ModBlocks.cobblesidian), new ItemStack(Blocks.obsidian), 0.5f);
		GameRegistry.addSmelting(new ItemStack(Blocks.obsidian), new ItemStack(ModItems.obsidianIngot), 0.5f);
		GameRegistry.addSmelting(new ItemStack(ModItems.rawMithril), new ItemStack(ModItems.mithril), 0.5f);

		GameRegistry.addRecipe(new ItemStack(ModBlocks.cobblesidian, 4), "OO", "OO", 'O', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.obsidianBricks, 4), "OOO", "OOO", "OOO", 'O', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(Blocks.bedrock), "BB", "BB", 'B', ModItems.bedrockShard);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.voidBlock, 1), "OOO", "OOO", "OOO", 'O', ModItems.voidOrb);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedCobble), "ccc", "ccc", "ccc", 'c', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.superCompressedCobble), "ccc", "ccc", "ccc", 'c', ModBlocks.compressedCobble);

		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianPick), "III", " S ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianAxe), "II ", "IS ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianShovel), " I ", " S ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianSword), " I ", " I ", " S ", 'I', ModItems.obsidianIngot, 'S', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianBoots), "   ", "I I", "I I", 'I', ModItems.obsidianIngot);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianHelmet), "IDI", "I I", "   ", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianLeggings), "IDI", "I I", "I I", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.obsidianChestplate), "I I", "IDI", "IDI", 'I', ModItems.obsidianIngot, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockPick), "III", " S ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockAxe), "II ", "IS ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockShovel), " I ", " S ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockSword), " I ", " I ", " S ", 'I', Blocks.bedrock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockBoots), "   ", "I I", "I I", 'I', Blocks.bedrock);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockHelmet), "III", "I I", "   ", 'I', Blocks.bedrock);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockLeggings), "III", "I I", "I I", 'I', Blocks.bedrock);
		GameRegistry.addRecipe(new ItemStack(ModItems.bedrockChestplate), "I I", "III", "III", 'I', Blocks.bedrock);
		GameRegistry.addRecipe(new ItemStack(ModItems.rainbowPick), "III", " S ", " S ", 'I', ModItems.rainbowShard, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.rainbowAxe), "II ", "IS ", " S ", 'I', ModItems.rainbowShard, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.rainbowShovel), " I ", " S ", " S ", 'I', ModItems.rainbowShard, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.rainbowSword), " I ", " I ", " S ", 'I', ModItems.rainbowShard, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.voidPick), "III", " S ", " S ", 'I', ModBlocks.voidBlock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.voidAxe), "II ", "IS ", " S ", 'I', ModBlocks.voidBlock, 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.voidShovel), " I ", " S ", " S ", 'I', ModBlocks.voidBlock, 'S', Items.stick);
		GameRegistry.registerFuelHandler(fuelNetherrack);
	}
}