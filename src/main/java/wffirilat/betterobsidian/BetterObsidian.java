package wffirilat.betterobsidian;

import net.minecraft.world.WorldType;
import wffirilat.betterobsidian.Blocks.ModBlocks;
import wffirilat.betterobsidian.Items.ModItems;
import wffirilat.betterobsidian.Mobs.ModMobs;
import wffirilat.betterobsidian.events.ModEvents;
import wffirilat.betterobsidian.events.TerrainEvents;
import wffirilat.betterobsidian.gen.biome.ModBiomes;
import wffirilat.betterobsidian.gen.biome.WorldTypeBetterObsidian;
import wffirilat.betterobsidian.lib.Constants;
import wffirilat.betterobsidian.lib.ModOreGenerators;
import wffirilat.betterobsidian.lib.ModRecipies;
import wffirilat.betterobsidian.proxy.CommonProxy;
import wffirilat.betterobsidian.tileEntity.ModTileEntities;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class BetterObsidian {

	@Instance(Constants.MODID)
	public static BetterObsidian modInstance;

	public static final int dimensionId = 8;

	public static TerrainEvents terrainEvents = new TerrainEvents();

	@SidedProxy(clientSide = "wffirilat.betterobsidian.proxy.ClientProxy", serverSide = "wffirilat.betterobsidian.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler()
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
		ModItems.init();
		ModRecipies.init();
		ModOreGenerators.init();
		ModMobs.init();
		ModBiomes.init();
		ModEvents.init();
		ModTileEntities.init();

		// DimensionManager.registerProviderType(dimensionId,
		// WorldProviderVoid.class, false);
		// DimensionManager.registerDimension(dimensionId, dimensionId);

		proxy.registerRenderers();

	}

	@EventHandler()
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler()
	public void postInit(FMLPostInitializationEvent event) {
		WorldType VOID = new WorldTypeBetterObsidian(3, "Better Obsidian");
	}
}
