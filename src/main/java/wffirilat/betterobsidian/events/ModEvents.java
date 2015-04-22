package wffirilat.betterobsidian.events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import wffirilat.betterobsidian.Items.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
	public void handleFlameGhastTears(AnvilUpdateEvent event) {
		if (event.right.getItem() == ModItems.flameGhastTear) {
			ItemStack i = event.left.copy();
			i.addEnchantment(Enchantment.fireAspect, 3);
			event.output = i;
			event.cost = 1;
		}
	}
}
