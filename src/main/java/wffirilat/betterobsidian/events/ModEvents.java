package wffirilat.betterobsidian.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wffirilat.betterobsidian.blocks.ModBlocks;
import wffirilat.betterobsidian.items.ModItems;

public class ModEvents {

	private static TerrainEvents terrainEvents = new TerrainEvents();
	private static ModEvents events = new ModEvents();
	private static OreGenEvents oreGenEvents = new OreGenEvents();

	public static void init() {
		FMLCommonHandler.instance().bus().register(terrainEvents);

		MinecraftForge.EVENT_BUS.register(events);
		MinecraftForge.TERRAIN_GEN_BUS.register(terrainEvents);
		MinecraftForge.ORE_GEN_BUS.register(oreGenEvents);
	}
	
	@SubscribeEvent
	public void obsidianDropsCobblesidian(BlockEvent.HarvestDropsEvent event) {
		if(event.state.getBlock() == Blocks.obsidian) {
			event.drops.clear();
			event.drops.add(new ItemStack(Item.getItemFromBlock(ModBlocks.cobblesidian)));
		}
	}
}
